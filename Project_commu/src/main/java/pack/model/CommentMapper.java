package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {

	@Insert("INSERT INTO comments (id, author, text) VALUES (#{id}, #{author}, #{text})")
	void insertComment(CommentDto comment);

	@Select("SELECT * FROM comments WHERE id = #{id}")
	List<CommentDto> selsectCommentsByPostId(Long id);
}
