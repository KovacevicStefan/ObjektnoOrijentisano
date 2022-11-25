package geometry;

public class Rectangle {

	private Point upperLeft;
	private int width;
	private int height;
	private boolean selected;
	
	public int circumference() {
		
		return 2*(width + height);
		
	}
	
	public int area() {
		
		return width*height;
		
	}
	
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
		boolean selected = true;
	
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
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
}
