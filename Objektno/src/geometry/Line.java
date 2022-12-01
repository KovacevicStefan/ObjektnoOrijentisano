package geometry;

public class Line {
	
	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
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
