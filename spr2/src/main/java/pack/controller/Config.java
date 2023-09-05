package pack.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pack.model.DataDaoImpl;

@Configuration //이건 configuration파일이야! 알려줌
public class Config {
	// 객체 환경설정 파일(**.xml) 대신 클래스로 객체 환경설정을 할 수 있다.
	
	public DataDaoImpl dataDaoImpl() {
		DataDaoImpl dataDaoImpl = new DataDaoImpl();
		return dataDaoImpl;
	}
	
	@Bean
	public BusinessServiceImpl businessServiceImpl() { //init.xml대신에 이렇게 Config.java로 만들어서 써줄 수도 있다, 한 번만 보여줌(잘 안씀)
		BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl(dataDaoImpl());
		return businessServiceImpl;
	}
}
