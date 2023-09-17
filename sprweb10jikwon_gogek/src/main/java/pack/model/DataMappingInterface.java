package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInterface {
	//전체 직원 읽기
	@Select("select distinct jikwon_no, jikwon_name, jikwon_jik, buser_name,\r\n"
			+ "   case when gogek_damsano=jikwon_no then 'O'\r\n"
			+ "   else 'X' end as manage_gogek\r\n"
			+ "   from jikwon \r\n"
			+ "   left outer join buser on buser.buser_no=jikwon.buser_num\r\n"
			+ "   left outer join gogek on jikwon.jikwon_no=gogek.gogek_damsano")
	List<JikwonDto> selectAll();
	
	//관리 고객 읽기
	@Select("SELECT gogek_no,gogek_name,\r\n"
			+ "CASE WHEN SUBSTR(gogek_jumin, 8, 1) = '1' THEN '남' ELSE '여' END AS gogek_gen,\r\n"
			+ "CASE WHEN SUBSTR(gogek_jumin, 8, 1) < '3' THEN YEAR(NOW()) - (SUBSTR(gogek_jumin, 1, 2) + 1900) END AS gogek_age\r\n"
			+ ",gogek_tel FROM gogek\r\n"
			+ "WHERE gogek_damsano = #{num}")
	List<GogekDto> selectGogek(String num);
}
