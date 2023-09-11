package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	@Autowired
	private JikwonInter jikwonInter;

	public void dataShow() {
		List<JikwonDto> list = jikwonInter.selectList();
		for (JikwonDto s : list) {
			System.out.println(s.getJikwon_no() + " " + s.getJikwon_name() + " " + s.getBuser_name() + " " + s.getIbsa());
		}
		
		System.out.println("\n부서별 인원수");
		List<JikwonDto> list2 = jikwonInter.selectList2();
		for (JikwonDto b : list2) {
			System.out.println(b.getBuser_name() + " " + b.getInwon());
		}
		
		System.out.println("\n부서별 최고 연봉자");
		List<JikwonDto> list3 = jikwonInter.selectList3();
		for (JikwonDto m : list3) {
			System.out.println(m.getBuser_name() + " " + m.getJikwon_name() + " " + m.getJikwon_pay());
		}
	}
}
