package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import dialog.DlgCircle;
import dialog.DlgDonut;
import dialog.DlgLine;
import dialog.DlgPoint;
import dialog.DlgRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private DrawingPanel panel = new DrawingPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<Shape> slctd = new ArrayList<Shape>();
	private JLabel lbl;
	private JToggleButton select;
	private JToggleButton modify;
	private JToggleButton erase;
	private JToggleButton point;
	private JToggleButton line;
	private JToggleButton rectangle;
	private JToggleButton circle;
	private JToggleButton donut;
	private DlgRectangle dlgRectangle;
	private DlgCircle dlgCircle;
	private DlgDonut dlgDonut;
	private Point startPoint;
	private boolean selected;
	private int brojac = 0;
	private MouseListener ml = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(point.isSelected()) {
				point(e);	
			}else if(line.isSelected()) {
				line(e);	
			}else if(rectangle.isSelected()) {
				rectangle(e);	
			}else if(circle.isSelected()) {
				circle(e);
			}else if(donut.isSelected()) {
				donut(e);
			}else if(select.isSelected()) {
				selected(e);
			}
		}
	};

	public DrawingFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 234, 87, 16);
		contentPane.add(toolBar, BorderLayout.SOUTH);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.addMouseListener(ml);
		
		select = new JToggleButton("Select");
		buttonGroup.add(select);
		toolBar.add(select);
		
		modify = new JToggleButton("Modify");
		buttonGroup.add(modify);
		toolBar.add(modify);
		
		erase = new JToggleButton("Erase");
		erase.addActionListener(this);
		buttonGroup.add(erase);
		toolBar.add(erase);
		
		lbl = new JLabel("                                                           ");
		toolBar.add(lbl);
		
		point = new JToggleButton("Point");
		buttonGroup.add(point);
		toolBar.add(point);
		
		line = new JToggleButton("Line");
		buttonGroup.add(line);
		toolBar.add(line);
		
		rectangle = new JToggleButton("Rectangle");
		buttonGroup.add(rectangle);
		toolBar.add(rectangle);
		
		circle = new JToggleButton("Circle");
		buttonGroup.add(circle);
		toolBar.add(circle);
		
		donut = new JToggleButton("Donut");
		buttonGroup.add(donut);
		toolBar.add(donut);
		
	}
	
	protected void selected(MouseEvent e) {
		for(Shape s : panel.getShapes()){
			if(s.contains(e.getX(),e.getY()))
			{
				if(s instanceof Point){
					if(!s.isSelected()) {
						s.setSelected(true);
						slctd.add(s);
						repaint();
					}else {
						s.setSelected(false);
						slctd.remove(s);
						repaint();
					}
				}else if(s instanceof Line) {
					if(!s.isSelected()) {
						s.setSelected(true);
						slctd.add(s);
						repaint();
					}else {
						s.setSelected(false);
						slctd.remove(s);
						repaint();
					}
				}else if(s instanceof Rectangle) {
					if(!s.isSelected()) {
						s.setSelected(true);
						slctd.add(s);
						repaint();
					}else {
						s.setSelected(false);
						slctd.remove(s);
						repaint();
					}
				}else if(s instanceof Circle) {
					if(!s.isSelected()) {
						s.setSelected(true);
						slctd.add(s);
						repaint();
					}else {
						s.setSelected(false);
						slctd.remove(s);
						repaint();
					}
				}else if(s instanceof Donut) {
					if(!s.isSelected()) {
						s.setSelected(true);
						slctd.add(s);
						repaint();
					}else {
						s.setSelected(false);
						slctd.remove(s);
						repaint();
					}
				}
			}
		}
	}

	protected void point(MouseEvent e) {
		Point p = new Point(e.getX(),e.getY(),selected);
		panel.getShapes().add(p);
		repaint();
	}
	
	protected void line(MouseEvent e) {
		brojac++;
		if(brojac < 2) {
			startPoint = new Point(e.getX(),e.getY());
			panel.getShapes().add(startPoint);
			repaint();
		}else {
			Line l1 = new Line(startPoint,new Point(e.getX(),e.getY()),selected);
			panel.getShapes().remove(startPoint);
			panel.getShapes().add(l1);
			repaint();
			brojac = 0;
		}
	}
	
	protected void rectangle(MouseEvent e) {
		Point upperLeft = new Point(e.getX(),e.getY());
		panel.getShapes().add(upperLeft);
		repaint();
		dlgRectangle = new DlgRectangle();
		dlgRectangle.setVisible(true);
		
		if(dlgRectangle.isCommited()) {
			int w = Integer.parseInt(dlgRectangle.getWidthField().getText());
			int h = Integer.parseInt(dlgRectangle.getHeightField().getText());
			Rectangle r = new Rectangle(upperLeft,w,h,selected);
			panel.getShapes().remove(upperLeft);
			panel.getShapes().add(r);
			repaint();	
		}else {
			panel.getShapes().remove(upperLeft);
			repaint();
		}
	}
	
	protected void circle(MouseEvent e) {
		Point center = new Point(e.getX(),e.getY());
		panel.getShapes().add(center);
		repaint();
		dlgCircle = new DlgCircle();
		dlgCircle.setVisible(true);
		
		if(dlgCircle.isCommited()) {
			int r = Integer.parseInt(dlgCircle.getRadius().getText());
			Circle c = new Circle(center, r, selected);
			panel.getShapes().remove(center);
			panel.getShapes().add(c);
			repaint();
		}
	}
	
	protected void donut(MouseEvent e) {
		Point center = new Point(e.getX(),e.getY());
		panel.getShapes().add(center);
		repaint();
		dlgDonut = new DlgDonut();
		dlgDonut.setVisible(true);
		
		if(dlgDonut.isCommited()) {
			int outerR = Integer.parseInt(dlgDonut.getOutR().getText());
			int innerR = Integer.parseInt(dlgDonut.getInR().getText());
			Donut d = new Donut(center,outerR,innerR,selected);
			panel.getShapes().remove(center);
			panel.getShapes().add(d);
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(erase.isSelected()) {
			if(JOptionPane.showConfirmDialog(null, "Are you really want to erase the selected object(s)?", "Erase",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					panel.getShapes().removeAll(slctd);
					repaint();	
			}
		}else if(modify.isSelected()) {
			
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
