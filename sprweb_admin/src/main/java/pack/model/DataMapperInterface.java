package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper
public interface DataMapperInterface {
	// User sql문들
	@Select("select * from user")
	List<memberDto> selectAll();

	@Select("SELECT * FROM user WHERE user_name LIKE CONCAT('%', #{searchValue}, '%') OR con_num LIKE CONCAT('%', #{searchValue}, '%')")
	List<memberDto> selectSearch(FormBean bean);
	
	// Supplier sql문들
	@Select("select * from supplier")
	List<SupplierDto> selectAll2();
}
