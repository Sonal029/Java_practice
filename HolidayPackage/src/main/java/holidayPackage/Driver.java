package holidayPackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HolidayPackage holiday = ctx.getBean(HolidayPackage.class,"holidayPackage");
		
		holiday.showDetails();
	}
	
	/*
	 * Get the Object of HolidayPackage from the Spring Container inside the main method
of Demo class and call the showDetails() method of HolidayPackage class
	 */
}
