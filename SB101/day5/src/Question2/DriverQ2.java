package Question2;

import java.util.ArrayList;
import java.util.List;

public class DriverQ2 
{
	public static void main(String[] args) 
{
	Runnable r1 = ThreadOperations::reverseArray ;
	
	ThreadOperations tr = new ThreadOperations();
	
	Runnable r2 = tr::findNearestToAverage;
	
	RunThread rt = Thread::start;
	
	List<Thread> al = new ArrayList<>();
	al.add(new Thread(r1));
	al.add(new Thread(r2));
	
	rt.startThread(al.get(0));
	rt.startThread(al.get(1));
	
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	System.out.println("Done.");
}
	
}

