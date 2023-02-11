package drawing;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
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
				g.setColor(s.getC());
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
