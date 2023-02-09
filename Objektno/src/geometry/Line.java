package geometry;
import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}

	public Line(Point sp, Point ep) {
		this.startPoint = sp;
		this.endPoint = ep;
	}
	
	public Line(Point sp, Point ep, boolean selected) {
		
		this.startPoint = sp;
		this.endPoint = ep;
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
			if(this.startPoint.equals(temp.getStartPoint()) && this.endPoint.equals(temp.getEndPoint())) {
				return true;
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
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			Line temp = (Line)o;
			return ((int)(this.length()-temp.length()));
		}
		return 0;
	}
	
	public double distance(Point p) {
		double distAB = Math.sqrt((getStartPoint().getX() - getEndPoint().getX()) * (getStartPoint().getX() - getEndPoint().getX())
		+ (getStartPoint().getY() - getEndPoint().getY()) * (getStartPoint().getY() - getEndPoint().getY()));
		double distAC = Math.sqrt((getStartPoint().getX() - p.getX()) * (getStartPoint().getX() - p.getX()) + (getStartPoint().getY() - p.getY()) * (getStartPoint().getY() - p.getY()));
		double distBC = Math.sqrt((getEndPoint().getX() - p.getX()) * (getEndPoint().getX() - p.getX()) + (getEndPoint().getY() - p.getY()) * (getEndPoint().getY() - p.getY()));
		double s = (distAB + distAC + distBC) / 2;
		return 2 * (Math.sqrt(s * (s - distAB) * (s - distAC) * (s - distBC))) / distAB;
	}
	
	public boolean contains(int x, int y) {
		Point p = new Point(x,y);
		double dfltp = this.distance(p);
		double dfstp = startPoint.distance(p.getX(), p.getY());
		double dfetp = endPoint.distance(p.getX(), p.getY());
		return (dfltp < 5 && dfstp < length() && dfetp < length());
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
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
