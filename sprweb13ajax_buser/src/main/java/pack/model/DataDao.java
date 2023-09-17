package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 퍼시스트에서 벌어지니까 레퍼지토리
public class DataDao {
	@Autowired
	private DataMapperInter mapperInter;
	
	// 부서 자료 읽기
	public ArrayList<BuserDto> buserList(){
		ArrayList<BuserDto> blist=  (ArrayList<BuserDto>)mapperInter.buserList();
		return blist;
	}
	
	// 직원 자료 읽기
	public ArrayList<JikwonDto> jikwonList(String buser_no){
		ArrayList<JikwonDto> jlist=  (ArrayList<JikwonDto>)mapperInter.jikwonList(buser_no);
		return jlist;
	}
}
