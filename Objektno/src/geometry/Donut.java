package geometry;

public class Donut extends Circle{

	private int innerR;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int r, int iR) {
		super(center, r);
		this.innerR = iR;
	}
	
	public Donut(Point center, int r, int iR, boolean selected) {
		super(center, r);
		this.innerR = iR;	
	}
	
	@Override
	public boolean contains(int w, int h) {
		return super.contains(w, h) && super.getCenter().distance(w, h)>=innerR;
	}
	
	@Override
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public double area() {
		return super.area() - (innerR * innerR * Math.PI);	
	}
	
	@Override
	
	public double circumference() {
		return super.circumference() + (2 * innerR * Math.PI);	
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius: " +innerR;	
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut) obj;
			if(super.equals(new Circle(temp.getCenter(), temp.getR())) && temp.getInnerR() == innerR) {
				return true;
			}
		}
		return false;
			
	}

	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}
	
	
	
}
