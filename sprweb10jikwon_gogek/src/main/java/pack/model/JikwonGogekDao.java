package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonGogekDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMappingInterface mappingInterface;
	
	public List<JikwonDto> selectAll(){ // 얘는 dao의 일반메소드
		List<JikwonDto> jlist = mappingInterface.selectAll(); // 얘는 인터페이스의 추상메소드
		logger.info("읽은 자료 수 : " + jlist.size());
		return jlist;
	}
	
	public List<GogekDto> selectGogek(String jikwon_no){ // 얘는 dao의 일반메소드
		List<GogekDto> glist = mappingInterface.selectGogek(jikwon_no); // 얘는 인터페이스의 추상메소드
		logger.info("읽은 자료 수 : " + glist.size());
		return glist;
	}
}
