package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myinit.xml");
		
		MyProcess myProcess = (MyProcess)context.getBean("my");
		//System.out.println(myProcess.displayData());
		System.out.println(myProcess.toString()); // 원래는 주소가 찍히는거, toString은 생략가능. MyProcess에서 오버라이드 정의해줘서 이제 주소가 안 찍힘
		//정상적인 구구단 출력이 됨
	}

}
