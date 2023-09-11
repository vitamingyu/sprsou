package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component // Sender sender= new Sender() : 싱글톤으로 객체 생성
@Component("sender") // 위에랑 같은 말, mysender로 쓰면 이 객체변수의 이름은 mysender가 됨
@Scope("singleton") // ()안 쓰면 싱글톤이 기본값, bean의 생존범위 기본 값. 이외 옵션으로는 "prototype","request","session"등이 있다. @scope안쓰면 기본이 싱글톤이니 객체는 한번만 만들어짐
public class Sender implements SenderInter{ // xml에서 찾아서 없으면(우선순위) 어노테이션에서 찾고 있으면 어노테이션에서 객체를 만들어줌
	public void show() {
		System.out.println("show method 수행~~");
	}
}
