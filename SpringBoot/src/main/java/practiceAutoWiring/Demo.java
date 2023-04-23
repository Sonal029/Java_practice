package practiceAutoWiring;

public class Demo {

	
	private A a1;
	private A a2;
	private B b1;
	
	
	
	
	
//	public Demo(A a1, A a2, B b1) {
//		super();
//		System.out.println("From 3args constructor");
//		this.a1 = a1;
//		this.a2 = a2;
//		this.b1 = b1;
//	}
//
//
//	public Demo(A a2, B b1) {
//		super();
//		
//		System.out.println("From 2args constructor");
//		this.a2 = a2;
//		this.b1 = b1;
//	}
//
//
//	public Demo() {
//		super();
//		System.out.println("From 0args constructor");
//		
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Demo(B b1) {
//		super();
//		System.out.println("From 1args constructor");
//		this.b1 = b1;
//	}
	
	public A getA1() {
		return a1;
	}





	public void setA1(A a1) {
		this.a1 = a1;
	}





	public A getA2() {
		return a2;
	}





	public void setA2(A a2) {
		this.a2 = a2;
	}





	public B getB1() {
		return b1;
	}





	public void setB1(B b1) {
		this.b1 = b1;
	}





	public void showDetails()
	{
		System.out.println("From show Details");
		System.out.println("b1 is : "+b1);
		System.out.println("a1: "+a1);
		System.out.println("a2: "+a2);
	}
	
	

	
	
	
	
}
