package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopinit.xml");
		
		LogicInter inter = (LogicInter)context.getBean("logicImpl");
		inter.StartProcess();
		
		((ConfigurableApplicationContext)context).close();
	}

}
