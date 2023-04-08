package Question1;

public class Multithreaded implements Runnable
{
	@Override
	public void run() 
	{
		int sum=0;
		for(int i=0;i<10;i++)
		{
			sum+=i;
		}
		
		System.out.println(sum);
	}
}

