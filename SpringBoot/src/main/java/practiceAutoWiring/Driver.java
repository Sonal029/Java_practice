package practiceAutoWiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver 
{
    public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo d = ctx.getBean("d",Demo.class);
		
		d.showDetails();
	}
}
