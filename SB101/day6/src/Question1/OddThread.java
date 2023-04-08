package Question1;

public class OddThread implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=1;i<20;i+=2)
		{
			System.out.print(i+" ");
		}
	}


}
