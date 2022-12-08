package geometry;

public class Circle {
	
		private Point center;
		private int r;
		private boolean selected;
		
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
		public boolean isSelected() {
			return selected;
		}
		public void setSelected(boolean selected) {
			this.selected = selected;
		}
		
		
		
	
}
