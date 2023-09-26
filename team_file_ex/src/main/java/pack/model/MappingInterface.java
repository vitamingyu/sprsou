package pack.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MappingInterface {
	 @Insert("insert into filetest (fileName) values(#{fileName})")
	    void saveFile(VO vo);
}
