package drawing;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import dialog.DlgCircle;
import dialog.DlgDonut;
import dialog.DlgRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingPanel extends JPanel{
	
	private DrawingFrame frame;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint;
	private Shape selected;
	private DlgRectangle dlg = new DlgRectangle();
	
	public DrawingPanel(DrawingFrame frame) {
		
		this.frame = frame;
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				thisMouseClicked(arg0);
			}
		});
	
	}
	
	protected void thisMouseClicked(MouseEvent e) {
		
		Shape newShape = null;
		if(frame.getSelect().isSelected()) {
			selected = null;
			Iterator<Shape> it = shapes.iterator();
			while(it.hasNext()) {
				Shape shape = it.next();
				shape.setSelected(false);
				if(shape.contains(e.getX(), e.getY())) {
					selected = shape;
				}
			}
			if(selected != null) {
				selected.setSelected(true);
			}else if (frame.getPoint().isSelected()) {
				newShape = new Point(e.getX(),e.getY());
				
			}else if(frame.getLine().isSelected()) {
				startPoint = new Point(e.getX(), e.getY());
			}else {
				newShape = new Line(startPoint, new Point(e.getX(), e.getY()));
				startPoint = null;
			}
		}else if(frame.getRectangle().isSelected()) {
			dlg.setModal(true);
			dlg.setRectangle(new Rectangle(new Point(e.getX(), e.getY()), -1, -1));
			dlg.setVisible(true);
			if(!dlg.isCommited()) 
			return;
			try {
				newShape = dlg.getRectangle();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(frame.getCircle().isSelected()) {
			DlgCircle dlg = new DlgCircle();
			dlg.setModal(true);
			dlg.setCircle(new Circle(new Point(e.getX(),e.getY()), -1));
			dlg.setVisible(true);
			if(!dlg.isCommited())
				return;
			try {
				newShape = dlg.getCircle();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(frame.getDonut().isSelected()) {
			DlgDonut dlg = new DlgDonut();
			dlg.setModal(true);
			dlg.setDonut(new Donut(new Point(e.getX(),e.getY()), -1, -1));
			dlg.setVisible(true);
			if(!dlg.isCommited())
				return;
			try {
				newShape = dlg.getDonut();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(frame, "Wrong data type", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(newShape != null)
			shapes.add(newShape);
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext())
			it.next().draw(g);
			}
		
	public Shape getSelected() {
		return selected;
	
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	
}
