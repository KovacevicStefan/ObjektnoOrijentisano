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
	
	public boolean contains(int x, int y) {
		return (startPoint.distanca(x,y) + endPoint.distanca(x, y)) - length() <= 2;
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
