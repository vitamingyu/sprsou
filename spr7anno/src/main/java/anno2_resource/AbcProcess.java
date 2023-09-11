package anno2_resource;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("ap")
public class AbcProcess {
	@Resource(name="abc1") // 이름에 의한 매핑. resource어노테이션은 form.xml에 추가되어있기에 쓸 수 있음 
	private Abc1 abc1;
	
	@Resource(name="kbs")
	private Abc2 abc2;
	
	public void showData() {
		abc1.setIrum("웅고집");
		abc2.setNai(23);
		
		String ss = "결과 : 이름은 " + abc1.getIrum();
		ss +=  ", 나이는 " + abc2.getNai();
		System.out.print(ss);
	}
}
