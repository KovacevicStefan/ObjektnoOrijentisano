package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape{

	private Point upperLeft;
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point ul, int w, int h) {
		this.upperLeft = ul;
		this.width = w;
		this.height = h;
	}
	
	public Rectangle(Point ul, int w, int h, boolean selected) {
		this.upperLeft = ul;
		this.width = w;
		this.height = h;
		this.selected = selected;
	}
	
	public int circumference() {
		return 2*(width + height);
	}
	
	public int area() {
		return width*height;
	}
	
	public boolean contains(int x, int y) {
		boolean containsX = false;
		if(x >= upperLeft.getX() && x <= (upperLeft.getX() + width)) {
			containsX = true;
		}
		
		boolean containsY = false;
		if(y >= upperLeft.getY() && y <= (upperLeft.getY() + height)) {
			containsY = true;
		}
		return containsX && containsY;
	}
	
	public void draw(Graphics g) {
		g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.height);
		if(selected) {
			g.drawRect(upperLeft.getX() - 3, upperLeft.getY() - 3, 6, 6);
			g.drawRect(upperLeft.getX() + width - 3, upperLeft.getY() - 3, 6, 6);
			g.drawRect(upperLeft.getX() - 3, upperLeft.getY() + height - 3, 6, 6);
			g.drawRect(upperLeft.getX() + width - 3, upperLeft.getY() + height - 3, 6, 6);
		}
	}
	
	@Override
	public String toString() {
		return "Upper left point: " +upperLeft +", width: " +width +", height: " +height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle)obj;
			if(temp.getUpperLeft().equals(upperLeft) && temp.getHeight() == height && temp.getWidth() == width) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void moveOn(int x, int y) {
		upperLeft.moveOn(x, y);
		
	}

	@Override
	public void moveBy(int dx, int dy) {
		upperLeft.moveBy(dx, dy);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle)o;
			return this.area() - temp.area();
		}
		return 0;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	
	
	
}
