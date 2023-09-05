package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myinit.xml"); // xml의 내용을 읽어오는 애플리케이션컨텍스트
		MyServiceInter inter = (MyServiceInter)context.getBean("myService"); //init에 있는 id를 불러온거. 이러면 객체의 주소가 inter로 넘어감
		inter.inputMoney();
		inter.showMoney();
	}

}
