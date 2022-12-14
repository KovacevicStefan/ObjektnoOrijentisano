package geometry;

public class Circle extends Shape{
	
		private Point center;
		private int r;
		
		public double circumference() {
			
			return 2 * r * Math.PI;
			
		}
		
		public double area() {
			return r * r * Math.PI;
		}
		
		public Circle() {
			
		}
		
		public Circle (Point c, int r) {
			this.center = c;
			this.r = r;
			
		}
		
		public Circle (Point c, int r, boolean selected) {
			this.center = c;
			this.r = r;
			this.selected = selected;
		}
		
		public boolean contains(int x, int y) {
			return center.distanca(x, y) <= r;
		}
		
		public boolean contains(Point p) {
			return center.distanca(p.getX(),p.getY()) <= r;
		}
		
		@Override
		public String toString() {
			
			return "Center: " +center +", radius: " +r;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Circle) {
				Circle temp = (Circle)obj;
				if(temp.getCenter().equals(center) && temp.getR() == r) {
					return true;
				}
			}
			return false;
		}
		
		
		private Object r() {
			
			return null;
		}

		public Point getCenter() {
			return center;
		}
		public void setCenter(Point center) {
			this.center = center;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}	
	
}
