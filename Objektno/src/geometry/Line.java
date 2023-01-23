package geometry;

public class Line extends Shape {
	
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
	
	public double length() {
		int dx = this.startPoint.getX() - this.endPoint.getX();
		int dy = this.endPoint.getY() - this.endPoint.getY();
		double length = Math.sqrt(dx * dx + dy * dy);
		return length;
	
	}
	
	public boolean contains(int x, int y) {
		return (startPoint.distance(x,y) + endPoint.distance(x, y)) - length() <= 2;
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
