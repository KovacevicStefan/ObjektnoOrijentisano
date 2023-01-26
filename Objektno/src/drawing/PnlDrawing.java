package drawing;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel{

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public PnlDrawing(){
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape s : shapes) {
			s.draw(g);
		}
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
}
