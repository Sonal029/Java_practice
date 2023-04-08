package Question2;

public class Main 
{
   public static void main(String[] args) throws InterruptedException {
	
	common c = new common();   
	Thread t1 = new Salman(c);
	Thread t2 = new Hritik(c);
	
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	
}
}

class Salman extends Thread
{
	
	common c ;
	
	public Salman(common c) {
		super();
		this.c = c;
	}

	@Override
	public void run()
	{
		
		
			try {
				c.even();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}

class Hritik extends Thread
{
      common c ;
	
	public Hritik(common c) {
		super();
		this.c = c;
	}
	@Override
	public void run()
	{
		try {
			c.odd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
class common
{
	synchronized public void even() throws InterruptedException
	{
		for(int i=0;i<=20;i+=2)
		{
			System.out.print(i+" ");
			notify();
			wait();
		}
	}
	
	synchronized public void odd() throws InterruptedException
	{
		for(int i=1;i<=20;i+=2)
		{
			System.out.print(i+" ");
			notify();
			wait();
		}
		notify();
	}
	
}

