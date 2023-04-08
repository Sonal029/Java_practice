package Question3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityAdderThread extends Thread 
{
	    private List<String> cityList;
	    private Scanner scanner;

	    public CityAdderThread(List<String> cityList) {
	        this.cityList = cityList;
	        this.scanner = new Scanner(System.in);
	    }

	    @Override
	    public void run() {
	        for (int i = 0; i < 4; i++) {
	            System.out.print("Enter a city: ");
	            String city = scanner.nextLine();
	            synchronized (cityList) {
	                cityList.add(city);
	            }
	        }
	    }

	    public static void main(String[] args) throws InterruptedException {
	        List<String> cityList = new ArrayList<>();
	        CityAdderThread cityAdderThread = new CityAdderThread(cityList);
	        cityAdderThread.start();
	        cityAdderThread.join();
	        for (String city : cityList) {
	            System.out.println(city);
	        }
	    }
}
