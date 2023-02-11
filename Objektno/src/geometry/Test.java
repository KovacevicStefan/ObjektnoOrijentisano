package geometry;

public class Test {

	public static void main(String[] args) {
		

		Circle c = new Circle(new Point(3,5), 7);
		System.out.println(c.circumference());
		System.out.println(c.area());
		
		System.out.println("");
		
		Donut d = new Donut(new Point(3,5), 7, 3);
		System.out.println(d.circumference());
		System.out.println(d.area());
		
		Rectangle r = new Rectangle(new Point(3,5), 50, 50);
		System.out.println(r.area());
		
		
	}

}
