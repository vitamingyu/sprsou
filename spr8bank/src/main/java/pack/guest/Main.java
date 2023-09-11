package pack.guest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// Annotation 연습용
		ApplicationContext context = new ClassPathXmlApplicationContext("annobank.xml");
		Gogek 길동 = (Gogek)context.getBean("gogek");  //Gogek.java의 객체이름
		길동.selectBank("신한");
		길동.playInputMoney(2000);
		길동.playOutputMoney(1000);
		System.out.println("길동 - ");
		길동.showMoney();
		
		Gogek 국인 = (Gogek)context.getBean("gogek"); 
		국인.selectBank("하나");
		국인.playInputMoney(2000);
		국인.playOutputMoney(1000);
		System.out.println("국인 - ");
		국인.showMoney();
		
		Gogek 효림 = (Gogek)context.getBean("gogek"); 
		효림.selectBank("하나");
		효림.playInputMoney(5000);
		효림.playOutputMoney(1000);
		System.out.println("효림 - ");
		효림.showMoney();
		
		System.out.println("주소 : " + 길동 +" "+ 국인 + " " + 효림);  // 싱글톤이라 3개의 주소가 다 같음 -> 신한은행, 하나은행, 고객에서 scope설정을 prototype으로 해줌. 주소 다 다름
		
		((ConfigurableApplicationContext)context).close();
	}

}
