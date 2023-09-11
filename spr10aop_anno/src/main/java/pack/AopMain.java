package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopinit.xml");
		LogicInter inter = (LogicInter)context.getBean("logicImpl");
		inter.selectData_process1();
		inter.selectData_process2();
		
		((ConfigurableApplicationContext)context).close();
	}
}
