package pack;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	private SangpumInter sangpumInter;
	
	@Override
	public void dataShow() {
		ArrayList<SangpumDto> list = sangpumInter.selectList();
		
		for(SangpumDto s:list) {
			System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() +" "+s.getDan());
		}
	}
}
