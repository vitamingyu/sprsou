package anno3_etc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
		// Autowired 연습용
		ApplicationContext context = new ClassPathXmlApplicationContext("anno3.xml");
		
		MyProcess myProcess = (MyProcess)context.getBean("myProcess"); // class이름 불러오는데 앞은 소문자
		myProcess.showResult();
		((ConfigurableApplicationContext)context).close();
	}

}
