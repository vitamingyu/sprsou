package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemCrudRepository extends JpaRepository<MemDto, Integer>{
	// num 자동 증가 처리를 할 경우 아래 처럼 코드 작성. 근데 이 방법 안 쓸거임
	// @Query(value="select max(p.num) from MemDto as p")
	//@Query(value="select max(num) from MemDto", nativeQuery = true)
	//int findByMaxNum();
	
	@Query(value="select m from MemDto as m where m.num=?1")
	MemDto findByNum(String num);
}
