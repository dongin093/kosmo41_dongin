class Circle { 
	//		private double rad=0;
	double rad = 0 ;
	final double PI = 3.14;
	
	public Circle(double r) { 
		setRad(r);
	}
	public void setRad(double r) {
		if(r<0) {
			rad = 0 ;
			return;
		}
		rad=r;
	}
	public double getArea() {
		return (rad*rad) *PI;
	}
}
public class A_UnsafeCircle {

	public static void main(String[] args) {
		Circle c = new Circle (1.5);
		System.out.println(c.getArea());
		
		c.setRad(2.5);
		System.out.println(c.getArea());
		c.setRad(-3.3);
		System.out.println(c.getArea());
		c.rad = -4.5;
		System.out.println(c.getArea());
	}

}
