package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {
	@Select("select * from jikwon")
	List<SangpumDto> selectAll();
	
	// MariaDb, MySQL인 경우 where sang like concat('%',#{svalue},'%') 
	// Oracle인 경우 where sang like '%'||#{svalue}||'%'
	@Select("select jikwon_no,jikwon_name,jikwon_jik,buser_name,jikwon_pay"
			+ " from jikwon inner join buser on buser_num=buser_no where jikwon_name like concat(#{svalue},'%') ")
	List<SangpumDto> selectSearch(String svalue);
}
