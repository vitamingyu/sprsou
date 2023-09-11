package pack;

import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	
	@Override
	public void StartProcess() {
		System.out.println("검증이 되었으므로 핵심 로직 수행");
		
	}

}
