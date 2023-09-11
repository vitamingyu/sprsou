package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	@Autowired //setter를 대신 해줌 private이니 setter로 불러와야됨
	private ArticleInter articleInter;
	
	public LogicImpl() {
		
	}
	
	@Override
	public void selectData_process1() {
		System.out.println("selectData_process1 수행");
		articleInter.selectAll();
	}
	
	@Override
	public void selectData_process2() {
		System.out.println("selectData_process2 수행");
		System.out.println("AOP 만세");
		System.out.println("AOP는 관심사항을 모듈로 만들어 인터셉트를 가능하게함. 탈부착이 자유로움");
	}
}
