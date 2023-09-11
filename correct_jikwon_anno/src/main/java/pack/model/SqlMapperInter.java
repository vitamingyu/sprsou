package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("select jikwon_no, jikwon_name,ifnull(buser_name,'무소속') as buser_name, date_format(jikwon_ibsail, '%Y') as ibsa from jikwon left outer join buser on jikwon.buser_num = buser.buser_no")
	List<JikwonDto> selectList();
	
	@Select("select buser_name, count(*) as inwon from jikwon inner join buser on buser.buser_no=jikwon.buser_num group by buser_name")
	List<JikwonDto> selectList2();
	
	@Select("select ifnull((select buser_name from buser where buser_num=buser_no),'무소속') as buser_name, jikwon_name, jikwon_pay from jikwon a where a.jikwon_pay=(select max(b.jikwon_pay) from jikwon b where a.buser_num=b.buser_num) order by buser_num")
	List<JikwonDto> selectList3();
}
