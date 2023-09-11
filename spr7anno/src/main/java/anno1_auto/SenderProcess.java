package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component // 단순하게 객체를 생성 아~ 객체를 만들어두는 구나, 어디선가 갖다 쓰겠지
@Service // 가독성을 위해 component대신 service로 씀. 아하~ 비즈니스 로직을 수행하기 위해 만든거구나 (똑같이 component가 생성됨)  정확하게는 @service("SenderProcess")임
public class SenderProcess {
	//@Autowired // 알아서 세터를 통해 와이어링. type에 의한 매핑 : 클래스의 포함관계
	//private Sender sender;   // 아래 주석 걸어준거를 이렇게 2줄로 구현 가능
	
	@Autowired  // 객체는 @service에서 만드는거고 얘는 자동으로 와이어링 해주는 어노테이션
	@Qualifier("sender")
	//@Qualifier("sender2")
	private SenderInter inter; // sender inter타입의 sender1과 2중 누가 들어올거야, 객체변수의 이름으로 매핑하는게 아니라 type에 의한 매핑임
	//SenderInter 타입의 객체가 2개 : sender, sender2 그러면 오류남 => 타입이 두 개 이상이면 오류 발생, 이름을 걸어줘야됨 : qualifier
	
	/*
	@Autowired // 자동으로 와이어링(연결) 얘가 sender타입의 객체를 찾아 => Sender.java에 있네? 그것의 주소를 아래 'sender'파라미터에 주소를 밀어넣음
						// 메소드에 자동으로 Sender 타입의 객체를 매핑
	public void setSender(Sender sender) { // sender라는 개체변수 이름은 내 맘
		this.sender = sender;
	}
	*/
	
	// 추상클래스랑 인터페이스랑 같은 거임, 추상클래스는 추상메소드만 갖고 있음 인터페이스는 일반메소드랑 추상메소드둘 다 가능
	
	/*
	public Sender getSender() {
		return sender;
	}
	
	public void displayData() {
		sender.show();
	}
	*/
	
	public SenderInter getInter() {
		return inter;
	}
	
	public void displayData() {
		inter.show();
	}
}
