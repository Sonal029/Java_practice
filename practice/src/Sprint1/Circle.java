package Sprint1;

public class Circle implements Drawable {

	private double radius;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing a circle");
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*(radius*radius);
	}

}
