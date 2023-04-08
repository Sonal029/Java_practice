package Question1;

public class Hrithik implements Runnable
{
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		int prod=1;
		for(int i=0;i<10;i++)
		{
			prod*=i;
		}
		System.out.println(prod);
	}
}
