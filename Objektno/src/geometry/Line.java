package geometry;

public class Line {
	
	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	public Line() {
		
	}
	//dasdad
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
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
}
