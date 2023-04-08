package Question3;

public class ThreadClass1 extends Thread
{
   int n1;
   int n2;
   
	public ThreadClass1(int n1, int n2) 
	{
		super();
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
	public void run()
	{
		for(int i=n1;i<=n2;i++)
		{
			int c=0;
			for(int j=1;j<=i;j++)
			{
				if(i%j==0)
				{
					c=c+1;
				}
			}
			if(c==2)
			{
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		ThreadClass1 T1 = new ThreadClass1(201,300);
		ThreadClass1 T2 = new ThreadClass1(301,400);
		ThreadClass1 T3 = new ThreadClass1(601,700);
		T2.setPriority(7);
		T3.setPriority(3);
		T1.start();
		T1.join();
		
		Thread.sleep(500);
		
		T2.start();
		T3.start();
		T2.join();
		T3.join();
		
		
		System.out.println("End of Main");
	}
	
}
