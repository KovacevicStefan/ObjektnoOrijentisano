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
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape selected;
	
	public DrawingPanel() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape s: shapes) {
			if(s.isSelected())
			{
			g.setColor(s.getC());
			s.draw(g);
			}
			else {
				s.draw(g);
			}
		}
	}
		
	public Shape getSelected() {
		return selected;
	
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	
}
