package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;

@Mapper
public interface DataMappingInterface {
	// 추상메소드의 이름은 mapper.xml의 id명과 일치시킨다
	
	List<Board> selectList();
	int insert(BoardBean bean);     //dao에서 선언해준거 여기서 만들어줘야됨 . dao에서 반환타입은 int로줌
	Board selectOne(String num);
	List<Board>selectSearch(BoardBean bean);
	void updateReadcnt(String num);
	int update(BoardBean bean); 
	int delete(String num);
}
