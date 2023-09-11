package pack;

import etc.OutDataInter;

public class MessageImpl implements MessageInter{
	//MessageInter 타입의 클래스가 됨.
	private String name1, name2; // 생성자를 통해 외부에서 값을 주입할거임(외부에서 값을 받을거임, 그래서 private. 외부에서 접근가능하게 컨스트럭터 혹은 
	private int year;
	private MyInfo myInfo;
	
	private String spec; // property를 통해 외부에서 값을 주입
	private OutDataInter inter;
	
	public MessageImpl(String name1,String name2, int year,MyInfo myInfo) { // constructor injection. di중 하나 컨스트럭터로 주입
		this.name1 = name1;
		this.name2 = name2;
		this.year = year;
		this.myInfo = myInfo; //얘는 지금 변수로 받는게 아니라 컨스럭터로 받음. 여기선 주소를 받아 넘김
	}
	
	public void setSpec(String spec) { // setter injection
		this.spec = spec;
	}
	
	public void setMyInfo(MyInfo myInfo) { // constructor injection
		this.myInfo = myInfo;
	}
	
	public void setInter(OutDataInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void sayhi() {
		// 현재 클래스 멤버들 출력용 메소드
		String msg = name1 + "의 별명은 " + name2;
		msg += (year + 23) + "년";
		msg += ", " + myInfo.myData(); // 마이 인포의 주소를 찾아가 myData실행해주는듯
		
		msg +="\n보유기술: " + spec;
		msg += " " + myInfo.myData();
		
		System.out.println(msg);
		
		// msg를 파일로 출력
		inter.outFile(msg);
	}
}
