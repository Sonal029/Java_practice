package Sprint1;

public abstract class video1 {
	
//	Abstract class
	
	public video1(String brand, String model) {
		super();
		Brand = brand;
		this.model = model;
	}
	protected String Brand;
	protected String model;
	
	public abstract void stop();
	public abstract void start();
	
	public void displayInfo()
	{
		System.out.println("Brand:"+Brand+",Model:"+model);
	}

}
