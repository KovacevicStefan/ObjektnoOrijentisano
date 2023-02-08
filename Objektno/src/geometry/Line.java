package geometry;
import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}

	public Line(Point pb, Point db) {
		this.startPoint = pb;
		this.endPoint = db;
	}
	
	public Line(Point pb, Point db, boolean selected) {
		
		this.startPoint = pb;
		this.endPoint = db;
		this.selected = selected; 
	}
	
	@Override 
	public String toString() {
		return startPoint +"-->" +endPoint;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp = (Line)obj;
			if(startPoint.equals(temp.getStartPoint()) && endPoint.equals(temp.getEndPoint())) {
				
			}
		}
		return false;
	}

	@Override
	public void moveOn(int x, int y) {
		int midX = (startPoint.getX() + endPoint.getX())/2;
		int midY = (startPoint.getY() + endPoint.getY())/2;
		int dx = x - midX;
		int dy = y - midY;
		this.startPoint.moveBy(dx, dy);
		this.endPoint.moveBy(dx, dy);
	}

	@Override
	public void moveBy(int dx, int dy) {
		this.startPoint.moveOn(this.startPoint.getX() + dx, this.startPoint.getY() + dy);
		this.endPoint.moveOn(this.endPoint.getX() + dx, this.endPoint.getY() + dy);
	}	
	
	public double length() {
		int dx = this.startPoint.getX() - this.endPoint.getX();
		int dy = this.endPoint.getY() - this.endPoint.getY();
		double length = Math.sqrt(dx * dx + dy * dy);
		return length;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			Line temp = (Line)o;
			return ((int)(this.length()-temp.length()));
		}
		return 0;
	}
	
	public double distance(Point p) {
		double distAB = Math.sqrt((getStartPoint().getX() - endPoint.getX()) * (startPoint.getX() - endPoint.getX())
		+ (startPoint.getY() - endPoint.getY()) + (startPoint.getY() - endPoint.getY()));
		double distAC = Math.sqrt((startPoint.getX() - p.getX()) * (startPoint.getX() - p.getX()) + (endPoint.getY() - p.getY()));
		double distBC = Math.sqrt((endPoint.getX() - p.getX()) + (endPoint.getX() - p.getX()) + (endPoint.getY() - p.getY()) * (endPoint.getY() - p.getY()));
		double s = (distAB + distAC + distBC) / 2;
		return 2 * (Math.sqrt(s * (s - distAB) * (s - distAC) * (s - distBC))) / distAB;
	}
	
	public boolean contains(int x, int y) {
		Point point = new Point(x,y);
		double dfltp = this.distance(point);
		double dfstp = startPoint.distance(point.getX(), point.getY());
		double dfetp = endPoint.distance(point.getX(), point.getY());
		return (dfltp < 5 && dfstp < length() && dfetp < length());
	}
	
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(selected) {
			g.drawRect(getStartPoint().getX() - 3, getStartPoint().getY() - 3, 6, 6);
			g.drawRect(getEndPoint().getX() - 3, getEndPoint().getY() - 3, 6, 6);
		}
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	
}
