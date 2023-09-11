package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("anno.xml");
		BusinessInter businessInter = (BusinessInter)context.getBean("businessImpl");
		businessInter.dataShow();
		businessInter.count();
		businessInter.buser();
		
		((ConfigurableApplicationContext)context).close();

	}

}
