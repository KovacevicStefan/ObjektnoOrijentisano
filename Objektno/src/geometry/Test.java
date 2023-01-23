package geometry;

public class Test {

	public static void main(String[] args) {
		
		// TOKEN - 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
		
		Circle c = new Circle(new Point(3,5), 7);
		System.out.println(c.circumference());
		System.out.println(c.area());
		
		System.out.println("");
		
		Donut d = new Donut(new Point(3,5), 7, 3);
		System.out.println(d.circumference());
		System.out.println(d.area());
		
		Donut d1 = new Donut(new Point(3,5), 7, 4);
		
		System.out.println(d.equals(d1));
		
		
	}

}
