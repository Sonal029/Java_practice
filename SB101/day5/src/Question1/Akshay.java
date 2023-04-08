package Question1;

	public class Akshay implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<10;i++)
			{
				System.out.println("Thread name is"+Thread.currentThread().getName());
			}
		}
		
	}
