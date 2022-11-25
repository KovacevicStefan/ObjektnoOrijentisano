package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point p1 = new Point();
		p1.setX(5);
		System.out.println("Koordinata x tacke p1 je: " +p1.getX());
		p1.setY(10);
		System.out.println("Koordinata y tacke p1 je: " +p1.getY());
		
		Point p2 = new Point();
		p2.setX(5);
		p2.setY(10);
		
		Point p2 = new Point();
		p2.setX(7);
		p2.setY(11);
		
		
		double dist = p1.distanca(p2.getX(), p2.getY());
		System.out.println("Distance is " +dist);
		
		
		Line l1 = new Line();
		l1.setStartPoint(p1);
		l1.setEndPoint(p2);
		int x = l1.getEndPoint().getX();
		int odtacke = p2.getX();
		System.out.println(+odtacke +" " +x);
		
		
		
		Circle c1 = new Circle();
		c1.setCenter(p1);
		c1.setR(7);
		
		System.out.println("Centar kruga je tacka sa koordinatama: " +p1);
		System.out.println("X: " + c1.getCenter().getX());
		System.out.println("Y: " +c1.getCenter().getY());
		System.out.println("Poluprecnik kruga je " +c1.getR());
		
		double circleArea = c1.area();
		System.out.println(circleArea);
		System.out.println(c1.area());
		
		Line l = new Line();
		Line l1 = new Line(p,p1);
		Line l2 = new Line(p, p, true);
		Line l3 = new Line(new Point(6,7), new Point(8,9));
		
	}

}
