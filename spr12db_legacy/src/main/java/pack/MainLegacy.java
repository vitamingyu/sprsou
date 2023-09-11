package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLegacy {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dbinit.xml");
		BusinessInter businessInter = (BusinessInter)context.getBean("businessImpl");
		businessInter.dataShow();

		((ConfigurableApplicationContext)context).close();
	}

}
