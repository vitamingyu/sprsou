package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // 테이블이라는 뜻
@Table(name="product")  // product 테이블과 매핑. 물리적 이름을 줌
public class ProductVo { // 테이블과 메핑할 클래스 하나 만들어줌
	@Id
	@Column(name="code")  // 밑에 선언해준거랑 이름 같아서 안 써줘도 됨, 그냥 명시적으로 써줌
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column(name="sang", nullable=false,length=20)
	private String sang;
	
	@Column
	private int su;
	
	@Column
	private int dan;
}
