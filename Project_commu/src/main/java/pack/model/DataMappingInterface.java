package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pack.controller.CommuBean;

@Mapper
public interface DataMappingInterface {
@Select("select * from commu order by gnum desc, onum asc")
List<CommuDto>selectAll();

@Select("select max(num) from commu")
int currentNum();

@Select("select * from commu\r\n"
		+ "		where ${searchName} like concat('%',#{searchValue},'%') order by num desc")
List<CommuDto>selectSearch(CommuBean bean);

@Select("select * from commu where num=#{num}")
CommuDto selectOne(String num);

@Select("select count(*) from commu")
int totalCnt();

@Select("select pass from commu where num=#{num}")
String selectPass(String num);

@Insert("insert into commu values(#{num},#{name},#{pass},#{mail},#{title},#{cont},#{cip},#{cdate},0,#{gnum},0,0)")
int insertCommu(CommuBean bean);

@Update("update commu set readcnt=readcnt + 1 where num=#{num}")
int updateReadcnt(String num);

@Update("update commu set name=#{name},mail=#{mail},title=#{title},cont=#{cont} where num=#{num}")
int updateData(CommuBean bean);

@Delete("delete from commu where num=#{num}")
int deleteData(String num);
}
