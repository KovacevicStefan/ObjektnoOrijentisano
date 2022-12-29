package geometry;

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
		this.selected = true;
	}
	
	public int circumference() {
		return 2*(width + height);
	}
	
	public int area() {
		return width*height;
	}
	
	public boolean contains(int w, int h) {
		return upperLeft.getX() < w && upperLeft.getX() + w > w && upperLeft.getY() < h && upperLeft.getY() < h;
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
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
