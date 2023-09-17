package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pack.controller.MemBean;
@Repository
public class DataProcess {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemCrudRepository repository; // 자동으로 풀링 처리 됨, 따로 할 필요 없음
	
	// 전체 자료 읽기
	public List<MemDto> getDataAll(){
		List<MemDto> list = repository.findAll();
		logger.info("datas " + list.size());
		return list;
	}
	// 추가
	public String insert(MemBean bean) {
		// 가장 큰 num을 구해 num 자동증가를 구현한다면 
		// int max = repository.findByMaxNum();
		
		// num 중복 자료 확인을 통한 등록
		try {
			// 사용자가 입력한 num이 이미 등록되어 있다면 현재 블록을 정상 수행
			MemDto dto = repository.findById(bean.getNum()).get();
			System.out.println("dto : " + dto);
			return "이미 등록된 번호입니다";
		} catch (Exception e) {
			try {
				// 사용자가 입력한 num이 없어서 에러가 발생하는 영역. 회원등록을 여기서 수행
				MemDto memDto = new MemDto();
				memDto.setNum(bean.getNum());
				memDto.setName(bean.getName());
				memDto.setAddr(bean.getAddr());
				memDto=repository.save(memDto);   // 없는 번호에 save해줬으니 insert처리
				System.out.println("memDto : " + memDto);
				return "success";
			} catch (Exception e2) {
				return "입력자료 오류" + e2.getMessage();
			}
		}
		
	}
	// 수정, 삭제에서 사용하기 위해 레코드 한 개 읽기
	public MemDto getData(String num) {
		MemDto dto = repository.findByNum(num);
		return dto;
	}
	
	// 수정
	public String update(MemBean bean) {
		try {
			MemDto memDto = new MemDto();
			memDto.setNum(bean.getNum());
			memDto.setName(bean.getName());
			memDto.setAddr(bean.getAddr());
			memDto=repository.save(memDto);  // 있는 번호가 들어올테니 이거는 update가 됨
			System.out.println("update memDto : " + memDto);
			return "success";
		} catch (Exception e) {
			return "수정 작업 오류 : " + e.getMessage();
		}
	}
	
	// 삭제
	public String delete(int num) {
		try {
			repository.deleteById(num);
			return "success";
		} catch (Exception e) {
			return "삭제 작업 오류 : " + e.getMessage();
		}
	}
}
