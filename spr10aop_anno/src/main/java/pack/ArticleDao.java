package pack;

import org.springframework.stereotype.Repository;

@Repository   // 객체를 생성하면서 DB 자료를 처리하는 클래스임을 알림. 가독성을 위해
public class ArticleDao implements ArticleInter{
	@Override
	public void selectAll() {
		System.out.println("상품 자료 전체 출력 성공");
	}
}
