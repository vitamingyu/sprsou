package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataMappingInterface mappingInter;
	 
	// 직원 자료 읽기
	public ArrayList<JikwonDto> jikwonListAll(){
		ArrayList<JikwonDto> jlist = (ArrayList<JikwonDto>)mappingInter.jikwonlist();
		return jlist;
	}
	
	// 직원 로그인
	public JikwonDto jikwonLogin(String jikwon_no) {
		JikwonDto dto = mappingInter.jikwonLogin(jikwon_no);
		return dto;
	}
}
