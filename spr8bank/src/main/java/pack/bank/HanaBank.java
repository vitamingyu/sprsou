package pack.bank;
import org.springframework.context.annotation.Scope;
// 은행마다 부르는 이름(input, get, ...)은 같으나 시스템은 다르다는 것을 보여줌
import org.springframework.stereotype.Component;

@Component("hana")
@Scope("prototype")
public class HanaBank implements Bank{
	private int money = 1000;
	
	@Override
	public void inputMoney(int money) {
		this.money = this.money + money;
	}
	
	@Override
	public void outputMoney(int money) {
		int imsi = money;
		this.money = this.money - imsi;
	}
	
	@Override
	public int getMoney() {
		int hbuffer = money;
		return hbuffer;
	}
}
