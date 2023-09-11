package anno2_resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		// @resource 연습용
		// Configuration 파일이 복수인 경우     String [] metas = new String[] {"anno2.xml"};   // {"anno2.xml","..."} 배열로 만들어서 쓸수도 있음
		ApplicationContext context = new ClassPathXmlApplicationContext("anno2.xml");
		
		AbcProcess process = context.getBean("ap",AbcProcess.class);
		process.showData();
		
		((ConfigurableApplicationContext)context).close();
	}

}
