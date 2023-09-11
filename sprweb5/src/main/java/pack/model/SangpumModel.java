package pack.model;

import org.springframework.stereotype.Service;

@Service
public class SangpumModel {
	
	public String sangProcess(SangpumBean bean) {
		String data = "품명: " + 	bean.getSang() + " " +
							", 금액" + (bean.getSu() * bean.getDan());
		return data;
	}
}
