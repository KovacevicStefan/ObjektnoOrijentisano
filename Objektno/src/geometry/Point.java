package geometry;
import java.awt.Graphics;

public class Point extends Shape{

	//obelezja
	private int x;
	private int y;

	
	//konstruktori
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this.x = x;
		this.y = y;
		this.selected = selected;
	}
	
	public double distance(int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		double d = Math.sqrt((dx*dx)+(dy*dy));
		return d;
	}
	
	//metode
	
	@Override 
	public String toString() {
		return "(" +x + "," +y +")";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Point) {
			Point temp = (Point) obj;
			if(x==temp.x && y==temp.y)
				return true;
		}
		return false;
		
	}
	
	public boolean contains(int x, int y) {
		
		return this.distance(x, y) <= 2;
		
	}
	
	public void draw(Graphics g) {
		g.drawLine(this.x, this.y, this.x, this.y);
		if(selected) {
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
	}
	
	//getteri i setteri
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	

}