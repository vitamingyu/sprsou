package pack.setterex;

public class MyProcessService {
	private int nai;
	private String name;
	private ShowData showData;
	
	public MyProcessService() {  // 안 써도 됨
	}
	
	public void setNai(int nai) { // private 멤버 값은 외부에서 setter를 사용해 입력(spring에선 setter injection이라 부름)
		// spring에선 객체를 (new)를 spring에서 하니까 주객전도 ioc
		this.nai = nai;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 "+ name + ", 나이는 " + nai  + ", 별명은 " + showData.processName() + ", 취미는" +
				showData.processHobby());
	}
}
