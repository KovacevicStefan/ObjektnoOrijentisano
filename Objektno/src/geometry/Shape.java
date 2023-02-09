package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable<Object>{
		
	protected boolean selected;
	private Color c;
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	public Shape() {
		
	}
	
	public abstract void draw(Graphics g);
	
	public abstract boolean contains(int x, int y);
	
	public Shape(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}	
}
