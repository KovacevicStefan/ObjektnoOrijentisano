package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
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
import dialog.DlgCircleModify;
import dialog.DlgDonut;
import dialog.DlgDonutModify;

import dialog.DlgPointModify;
import dialog.DlgLineModify;
import dialog.DlgRectangle;
import dialog.DlgRectangleModify;
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
import javax.swing.JColorChooser;
import javax.swing.border.LineBorder;


public class DrawingFrame extends JFrame implements ActionListener{

	private int counter = 0;
	private boolean selected;
	private Point startPoint, endPoint;
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<Shape> slctd = new ArrayList<Shape>();
	private DrawingPanel panel = new DrawingPanel();
	private JPanel contentPane;
	private JLabel lbl;
	private Color clr;
	private JToggleButton color;
	private JToggleButton clrbtn;
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
	private DlgPointModify dlgPointM;
	private DlgLineModify dlgLineM;
	private DlgRectangleModify dlgRectangleM;
	private DlgCircleModify dlgCircleM;
	private DlgDonutModify dlgDonutM;
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
		
		setTitle("Drawing 1.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 234, 87, 16);
		contentPane.add(toolBar, BorderLayout.SOUTH);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.addMouseListener(ml);
		
		select = new JToggleButton("Select");
		buttonGroup.add(select);
		toolBar.add(select);
		
		modify = new JToggleButton("Modify");
		modify.addActionListener(this);
		buttonGroup.add(modify);
		toolBar.add(modify);
		
		erase = new JToggleButton("Erase");
		erase.addActionListener(this);
		buttonGroup.add(erase);
		toolBar.add(erase);
		
		color = new JToggleButton("Color");
		color.addActionListener(this);
		buttonGroup.add(color);
		toolBar.add(color);
		
		lbl = new JLabel("                                                                                                                                                  ");
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
		
		clrbtn = new JToggleButton("     ");
		clrbtn.setEnabled(false);
		clrbtn.setBackground(new Color(0, 0, 0));
		clr = clrbtn.getBackground();
		toolBar.add(clrbtn);
		
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
					if(s.getClass() != Circle.class) {
						if(!s.isSelected()) {
							s.setSelected(true);
							slctd.add(s);
							repaint();
						}else {
							s.setSelected(false);
							slctd.remove(s);
							repaint();
						}
					}else {
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
	}
	protected void modify(ActionEvent e) {
		if(panel.getShapes().isEmpty() || slctd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please select object to modify!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else if(slctd.size() > 1) {
			JOptionPane.showMessageDialog(null, "You can modify only one selected object!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else if(slctd.size() == 1) {
			for(Shape s : panel.getShapes()) {
				if(s instanceof Point) {
					if(s.isSelected()) {
						Point temp = (Point) s;
						Point p = new Point();
						
						dlgPointM = new DlgPointModify();
						dlgPointM.getxField().setText(Integer.toString(temp.getX()));
						dlgPointM.getyField().setText(Integer.toString(temp.getY()));
						dlgPointM.setVisible(true);
						
						if(dlgPointM.isCommited()) {
							p.setC(temp.getC());
							p.setSelected(false);
							p.moveOn(Integer.parseInt(dlgPointM.getxField().getText()), Integer.parseInt(dlgPointM.getyField().getText()));
							panel.getShapes().set(panel.getShapes().indexOf(temp), p);
							repaint();
							slctd.clear();
						}
					}
				}else if(s instanceof Line) {
					if(s.isSelected()) {
						Line temp = (Line) s;
						Line l = new Line();
						
						dlgLineM = new DlgLineModify();
						dlgLineM.getSpxField().setText(Integer.toString(temp.getStartPoint().getX()));
						dlgLineM.getSpyField().setText(Integer.toString(temp.getStartPoint().getY()));
						dlgLineM.getEpxField().setText(Integer.toString(temp.getEndPoint().getX()));
						dlgLineM.getEpyField().setText(Integer.toString(temp.getEndPoint().getY()));
						dlgLineM.setVisible(true);
						
						if(dlgLineM.isCommited()) {
							l.setC(temp.getC());
							l.setSelected(false);
							l.setStartPoint(new Point(Integer.parseInt(dlgLineM.getSpxField().getText()), Integer.parseInt(dlgLineM.getSpyField().getText())));
							l.setEndPoint(new Point(Integer.parseInt(dlgLineM.getEpxField().getText()), Integer.parseInt(dlgLineM.getEpyField().getText())));
							panel.getShapes().set(panel.getShapes().indexOf(temp), l);
							repaint();
							slctd.clear();
						}
					}
				}else if(s instanceof Rectangle) {
					if(s.isSelected()) {
						Rectangle temp = (Rectangle) s;
						Rectangle r = new Rectangle();
						
						dlgRectangleM = new DlgRectangleModify();
						dlgRectangleM.getHeightField().setText(Integer.toString(temp.getHeight()));
						dlgRectangleM.getWidthField().setText(Integer.toString(temp.getWidth()));
						dlgRectangleM.getUpperLeftXField().setText(Integer.toString(temp.getUpperLeft().getX()));
						dlgRectangleM.getUpperLeftYField().setText(Integer.toString(temp.getUpperLeft().getY()));
						dlgRectangleM.setVisible(true);
						
						if(dlgRectangleM.isCommited()) {
							r.setC(temp.getC());
							r.setSelected(false);
							r.setHeight(Integer.parseInt(dlgRectangleM.getHeightField().getText()));
							r.setWidth(Integer.parseInt(dlgRectangleM.getWidthField().getText()));
							r.setUpperLeft(new Point(Integer.parseInt(dlgRectangleM.getUpperLeftXField().getText()), Integer.parseInt(dlgRectangleM.getUpperLeftYField().getText())));
							panel.getShapes().set(panel.getShapes().indexOf(temp), r);
							repaint();
							slctd.clear();
						}
					}
				}else if(s instanceof Circle) {
					if(s.isSelected()) {
						if(s.getClass() != Circle.class) {
								Donut temp = (Donut) s;
								Donut d = new Donut();
								
								dlgDonutM = new DlgDonutModify();
								dlgDonutM.getInR().setText(Integer.toString(temp.getInnerR()));
								dlgDonutM.getOutR().setText(Integer.toString(temp.getR()));
								dlgDonutM.getFieldCenterX().setText(Integer.toString(temp.getCenter().getX()));
								dlgDonutM.getFieldCenterY().setText(Integer.toString(temp.getCenter().getY()));
								dlgDonutM.setVisible(true);
								
								if(dlgDonutM.isCommited()) {
									d.setC(temp.getC());
									d.setSelected(false);
									d.setInnerR(Integer.parseInt(dlgDonutM.getInR().getText()));
									d.setR(Integer.parseInt(dlgDonutM.getOutR().getText()));
									d.setCenter(new Point(Integer.parseInt(dlgDonutM.getFieldCenterX().getText()), Integer.parseInt(dlgDonutM.getFieldCenterY().getText())));
									panel.getShapes().set(panel.getShapes().indexOf(temp), d);
									repaint();
									slctd.clear();
							}
						}else {
								Circle temp = (Circle) s;
								Circle c = new Circle();
								
								dlgCircleM = new DlgCircleModify();
								dlgCircleM.getRadius().setText(Integer.toString(temp.getR()));
								dlgCircleM.getFieldCenterX().setText(Integer.toString(temp.getCenter().getX()));
								dlgCircleM.getFieldCenterY().setText(Integer.toString(temp.getCenter().getY()));
								dlgCircleM.setVisible(true);
								
								if(dlgCircleM.isCommited()) {
									c.setC(temp.getC());
									c.setSelected(false);
									c.setR(Integer.parseInt(dlgCircleM.getRadius().getText()));
									c.setCenter(new Point(Integer.parseInt(dlgCircleM.getFieldCenterX().getText()), Integer.parseInt(dlgCircleM.getFieldCenterY().getText())));
									panel.getShapes().set(panel.getShapes().indexOf(temp), c);
									repaint();
									slctd.clear();
							}
						}
					}
				}
			}
		}
	}
	protected void erase(ActionEvent e) {
		if(panel.getShapes().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Panel is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else if(!panel.getShapes().isEmpty() && slctd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There is no selected object(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			if(JOptionPane.showConfirmDialog(null, "Are you really want to erase the selected object(s)?", "ERASE",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					panel.getShapes().removeAll(slctd);
					slctd.clear();
					repaint();	
			}
		}
	}
	protected void color(ActionEvent e) {
		clr = JColorChooser.showDialog(null, "Choose color",Color.BLACK);
		clrbtn.setBackground(clr);
		for(Shape s : slctd) {
			if(s instanceof Point){
					repaint();
					s.setC(clr);
					repaint();
			}else if(s instanceof Line) {
					repaint();
					s.setC(clr);
					repaint();
			}else if(s instanceof Rectangle) {
					repaint();
					s.setC(clr);
					repaint();
			}else if(s instanceof Circle) {
				if(s.getClass() != Circle.class) {
					repaint();
					s.setC(clr);
					repaint();
				}else {
					repaint();
					s.setC(clr);
					repaint();
				}		
			}
		}
	}
	protected void point(MouseEvent e) {
		Point p = new Point(e.getX(),e.getY(),selected);
		p.setC(clr);
		panel.getShapes().add(p);
		repaint();
	}
	protected void line(MouseEvent e) {
		counter++;
		switch(counter) {
			case 1:
				startPoint = new Point(e.getX(),e.getY());
				panel.getShapes().add(startPoint);
				startPoint.setC(clr);
				repaint();
				break;
			case 2:
				endPoint = new Point(e.getX(),e.getY());
				Line l = new Line(startPoint,endPoint,selected);
				panel.getShapes().add(l);
				panel.getShapes().remove(startPoint);
				l.setC(clr);
				repaint();
				counter = 0;
				break;
		}
	}
	protected void rectangle(MouseEvent e) {
		Point upperLeft = new Point(e.getX(),e.getY());
		panel.getShapes().add(upperLeft);
		upperLeft.setC(clr);
		repaint();
		dlgRectangle = new DlgRectangle();
		dlgRectangle.setVisible(true);
		
		if(dlgRectangle.isCommited()) {
			int w = Integer.parseInt(dlgRectangle.getWidthField().getText());
			int h = Integer.parseInt(dlgRectangle.getHeightField().getText());
			Rectangle r = new Rectangle(upperLeft,w,h,selected);
			panel.getShapes().remove(upperLeft);
			panel.getShapes().add(r);
			r.setC(clr);
			repaint();	
		}else {
			panel.getShapes().remove(upperLeft);
			repaint();
		}
	}
	protected void circle(MouseEvent e) {
		Point center = new Point(e.getX(),e.getY());
		panel.getShapes().add(center);
		center.setC(clr);
		repaint();
		dlgCircle = new DlgCircle();
		dlgCircle.setVisible(true);
		
		if(dlgCircle.isCommited()) {
			int r = Integer.parseInt(dlgCircle.getRadius().getText());
			Circle c = new Circle(center, r, selected);
			panel.getShapes().remove(center);
			panel.getShapes().add(c);
			c.setC(clr);
			repaint();
		}else {
			panel.getShapes().remove(center);
			repaint();
		}
	}
	protected void donut(MouseEvent e) {
		Point center = new Point(e.getX(),e.getY());
		panel.getShapes().add(center);
		center.setC(clr);
		repaint();
		dlgDonut = new DlgDonut();
		dlgDonut.setVisible(true);
		
		if(dlgDonut.isCommited()) {
			int outerR = Integer.parseInt(dlgDonut.getOutR().getText());
			int innerR = Integer.parseInt(dlgDonut.getInR().getText());
			Donut d = new Donut(center,outerR,innerR,selected);
			panel.getShapes().remove(center);
			panel.getShapes().add(d);
			d.setC(clr);
			repaint();
		}else {
			panel.getShapes().remove(center);
			repaint();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(erase.isSelected()) {
			erase(e);
		}else if(modify.isSelected()) {
			modify(e);
		}else if(color.isSelected()) {
			color(e);
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

