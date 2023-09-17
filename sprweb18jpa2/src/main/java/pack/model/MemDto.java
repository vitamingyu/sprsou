package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="mem")
@Data
public class MemDto {
	@Id
	@Column(name="num") // 안 써도 돼, 가독성을 위해 명시적으로 써줌
	private int num;
	
	@Column(nullable=false)
	private String name;
	
	private String addr;
}
