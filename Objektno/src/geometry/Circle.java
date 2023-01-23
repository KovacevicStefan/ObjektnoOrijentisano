package geometry;

import java.awt.Graphics;

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
			return center.distance(x, y) <= r;
		}
		
		public boolean contains(Point p) {
			return center.distance(p.getX(),p.getY()) <= r;
		}
		
		public void draw(Graphics g) {
			g.drawOval(this.getCenter().getX() - this.r, this.getCenter().getY(), this.r*2, this.r*2);
			if(selected) {
				g.drawRect(center.getX() - r - 3, center.getY() - 3, 6, 6);
				g.drawRect(center.getX() + r - 3, center.getY() - 3, 6, 6);
				g.drawRect(center.getX() - 3, center.getY() - r - 3, 6, 6);
				g.drawRect(center.getX() - 3, center.getY() + r -3, 6, 6);
			}
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
