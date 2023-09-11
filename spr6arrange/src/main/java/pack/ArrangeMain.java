package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArrangeMain {
	public static void main(String[] args) {
		
		// spring이 생성한 객체를 호출 후 실행
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml");
		
		
		// singleton 확인
		//전통적 방법
		/*
		MessageImpl impl1 = new MessageImpl("tom");
		impl1.sayhi();
		System.out.println("객체 주소 : " + impl1.toString()); // tostring은 써도 그만 안 써도 그만, 오버라이딩 안 했으니 주소찍히겠지
		
		MessageImpl impl2 = new MessageImpl("oscar");
		impl2.sayhi();
		*/
		
		//System.out.println("객체 주소 : "+impl2.toString()+ " " + impl2);
		// tom
		// 객체 주소 : pack.MessageImpl@1573f9fc
		// oscar
		// 객체 주소 : pack.MessageImpl@6150c3ec pack.MessageImpl@6150c3ec객체가 별도로 생성 => singleton이 아니라는 말임. 웹에서는 객체가 매번 만들어지면 안됨. 이제 spring으로 해보자
		
		System.out.println("------ spring 방법");
		
		MessageImpl spr_impl1 = (MessageImpl)context.getBean("msgImpl");
		spr_impl1.sayhi();
		
		MessageImpl spr_impl2 = (MessageImpl)context.getBean("msgImpl");
		spr_impl2.sayhi();
		System.out.println("객체 주소(스프링) : "+spr_impl1.toString()+ " " + spr_impl2);  // 뒤엔 귀찮아서 toString 안 써줌
		// 두 변수의 주소가 동일하다면, arrange.xml의 scope="singleton"이다!
		
		System.out.println("-----------------------------------------");
		
		
		System.out.println("\n다형성 캐스팅 관련 ~~");
		MessageImpl spr_impl3 = (MessageImpl)context.getBean("msgImpl");
		spr_impl3.sayhi();
		
		System.out.println(); // MessageImpl의 super클래스를 사용 중인 거임 아래에서는
		MessageInter inter1 = (MessageInter)context.getBean("msgImpl");
		inter1.sayhi();
		MessageInter inter2 = (MessageImpl)context.getBean("msgImpl");  // 보통 위의 방법으로 하지만 impl로 받아서 출력해도 된다
		inter2.sayhi();
		
		((ConfigurableApplicationContext)context).close();
	}

}
