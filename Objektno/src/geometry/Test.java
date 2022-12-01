package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point p = new Point(3,5);
		System.out.println(p.toString());
		Point p1 = new Point(3,5);
		
		Line l = new Line(new Point(5,7), new Point(8,9));
		System.out.println(l.toString());
		
		Circle c = new Circle(new Point(3,5), 5);
		System.out.println(c.toString());
		
		Rectangle r = new Rectangle(new Point(8,9), 7, 11);
		System.out.println(r.toString());
		
		System.out.println(p.equals(p1));
	}

}
