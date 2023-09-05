package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.model.DataDao;
import pack.model.DataDaoImpl;

public class Main {

	public static void main(String[] args) {
		// 전통적인 방법
		// DB처리용 클래스 먼저 만듦
		DataDaoImpl daoImpl = new DataDaoImpl(); // 싱클톤 패턴 아님, 이제 싱글톤패턴으로 스프링이 new 해줄거임
		DataDao dataDao=daoImpl; // 자식의 객체주소는 부모에게 밀어 넣어줄 수 있다
		
		// 비즈니스 처리용
		BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl(dataDao);
		BusinessService businessService = businessServiceImpl; // 주소 밀어넣기
		businessService.selectProcess(); // sericeimpl의 셀렉트프로세스를 실행
		
		System.out.println("-------");
		// spring의 방법 : 환경설정(Configuration) 파일(xml)을 이용
		// 모든 객체 설정을 자바로부터 분리, 외부화 할 수 있다
		// spring은 설정파일에서(예를 들어 init.xml) 설정된 내용을 읽어 application에서 필요한 기능을 처리한다
		// xml 기반으로 작성하나, 자바 클래스로 작성할 수도 있다.
		// Root tag는 <bean>다.
		// <bean> tag로 주입할 객체를 설정파일에 설정한다
		// <bean>의 속성으로 id:객체변수명(중복 불가), name : 복수의 이름 지정 가능
		
		/*
		// xml파일로 설정(init.xml)
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:init.xml"); // 'classpath:'는 생략 가능(main/resource가 기본경로)
		// ("classpath:pack/controller/init.xml"); 다른 경로일 경우 지정법
		BusinessService businessService2 = (BusinessService)context.getBean("businessServiceImpl"); // 뭐시기 치환중
		businessService2.selectProcess();
		*/
		
		// java파일로 설정(Config.java)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		BusinessService businessService2 = (BusinessService)context.getBean("businessServiceImpl");
		businessService2.selectProcess();
	}

}
