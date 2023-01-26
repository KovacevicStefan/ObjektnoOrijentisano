package geometry;
import java.awt.Graphics;

public class LineString{

	private Line[] segments = new Line[10];
	private int lastIndex = -1;
	
	public LineString() {
		
	}
	
	public boolean addSegment(Line l) {
		if(this.lastIndex < 9) {
			if(lastIndex == -1) {
				segments[++lastIndex] = l;
				return true;
			}else {
			Line last = this.segments[lastIndex];
				if(last.getStartPoint().equals(l.getStartPoint()) || last.getStartPoint().equals(l.getEndPoint()) 
				|| last.getEndPoint().equals(l.getStartPoint()) || last.getEndPoint().equals(l.getEndPoint())) {
					segments[++lastIndex] = l;
					return true;
				}else {
					return false;
				}
			}
		}else {
			return false;
		}
	}
	
	public Line removeLastSegment() {
		if(lastIndex > -1) {
			Line lastSegment = segments[lastIndex--];
			return lastSegment;
		}else {
			return null;
		}
	}
	
	public double length() {
		double l = 0;
		for(int i = 0; i < this.segments.length; i++) {
			if(this.segments[i] == null) {
				break;
			}
			l = l + this.segments[i].length();
		}
		return l;
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < segments.length; i++) {
			if(segments[i] != null)
			segments[i].draw(g);
			
		}
	}
	
	public boolean containt(int x, int y) {
		for(int i = 0; i < segments.length; i++) {
			if(segments[i] != null && segments[i].contains(x, y)) {
				return true;
			}
		}
		return false;
	}
	
	public Line[] getSegment() {
		return this.segments;
	}
	
}
