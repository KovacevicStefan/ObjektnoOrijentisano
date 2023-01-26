package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	
	private DrawingPanel panel = new DrawingPanel(this);
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton select;
	private JToggleButton modify;
	private JToggleButton erase;
	private JToggleButton point;
	private JToggleButton line;
	private JToggleButton rectangle;
	private JToggleButton circle;
	private JToggleButton donut;

	
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
		
		select = new JToggleButton("Select");
		buttonGroup.add(select);
		toolBar.add(select);
		
		modify = new JToggleButton("Modify");
		buttonGroup.add(modify);
		toolBar.add(modify);
		
		erase = new JToggleButton("Erase");
		buttonGroup.add(erase);
		toolBar.add(erase);
		
		JLabel lblNewLabel = new JLabel("                                                           ");
		toolBar.add(lblNewLabel);
		
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
	
	protected void delete() {
		Shape selected = panel.getSelected();
		if(selected != null)
			panel.getShapes().remove(selected);
		panel.repaint();
	}
	
	protected void modify() {
		Shape selected = panel.getSelected();
		if(selected != null) {
			if(selected instanceof Point) {
			Point point = (Point) selected;
			DlgPoint dlg = new DlgPoint();
			dlg.setPoint(point);
			dlg.setModal(true);
			dlg.setVisible(true);
		}else if(selected instanceof Line) {
			Line line = (Line) selected;
			DlgLine dlg = new DlgLine();
			dlg.setLine(line);
			dlg.setModal(true);
			dlg.setVisible(true);
		}else if(selected instanceof Rectangle) {
			Rectangle rectangle = (Rectangle) selected;
			DlgRectangle dlg = new DlgRectangle();
			dlg.setRectangle(rectangle);
			dlg.setModal(true);
			dlg.setVisible(true);
		}else if(selected instanceof Circle) {
			Circle circle = (Circle) selected;
			DlgCircle dlg = new DlgCircle();
			dlg.setCircle(circle);
			dlg.setModal(true);
			dlg.setVisible(true);
		}else if(selected instanceof Donut) {
			Donut donut = new Donut();
			DlgDonut dlg = new DlgDonut();
			dlg.setDonut(donut);
			dlg.setModal(true);
			dlg.setVisible(true);
		}
	}
		panel.repaint();
	}
	

	
	
	public JToggleButton getSelect() {
		return select;
	}
	public JToggleButton getModify() {
		return modify;
	}
	public JToggleButton getErase() {
		return erase;
	}
	public JToggleButton getPoint() {
		return point;
	}
	public JToggleButton getLine() {
		return line;
	}
	public JToggleButton getRectangle() {
		return rectangle;
	}
	public JToggleButton getCircle() {
		return circle;
	}
	public JToggleButton getDonut() {
		return donut;
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
