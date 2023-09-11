package anno1_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		// Autowired 연습용
		ApplicationContext context = new ClassPathXmlApplicationContext("anno1.xml");
		// SenderProcess process = (SenderProcess)context.getBean("sendProcess"); 얘나 아래나 같은 말
		SenderProcess process = context.getBean("senderProcess",SenderProcess.class); // service에 k안주면 senderProcess로 불러와야됨 자동으로 그렇게 생성되니
		process.displayData();
		//process.getSender().show();
		
		((ConfigurableApplicationContext)context).close();
	}

}
