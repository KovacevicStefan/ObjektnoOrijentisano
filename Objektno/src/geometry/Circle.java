package geometry;

import java.awt.Graphics;

public class Circle extends Shape{
	
		private Point center;
		private int r;
		
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
		
		public double circumference() {
			return 2 * r * Math.PI;	
		}
		
		public double area() {
			return r * r * Math.PI;
		}
		
		
		public boolean contains(int x, int y) {
			return center.distance(x, y) <= r;
		}
		
		public void draw(Graphics g) {
			g.drawOval(center.getX()-r, center.getY()-r, r*2, r*2);
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
		
		@Override
		public void moveOn(int x, int y) {
			center.moveOn(x, y);
		}

		@Override
		public void moveBy(int dx, int dy) {
			center.moveBy(dx, dy);
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
		public void setR(int r) throws Exception {
			if(r >= 0) {
				this.r = r;
			}else {
				throw new Exception("Vrednost poluprecnika ne moze biti negativan broj.");
			}
		}
	
}
