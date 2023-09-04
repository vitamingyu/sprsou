package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 전통적인 방식
		HelloMaven hellomaven = new HelloMaven();
		hellomaven.sayHello("홍길동");
		
		System.out.println();
		// Spring을 사용 : IOC-제어의 역전 객체관리를 spring이 함
		
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		HelloInter  inter = (HelloInter)context.getBean("hello");  // 이렇게 치환하는걸 di라고 한다는디
		inter.sayHello("한국인");
		((ConfigurableApplicationContext)context).close();
	}
}
