package pack.guest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.ShinhanBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype")
public class Gogek {
	private Bank bank;
	
	@Autowired // 타입에 의한 매핑
	private ShinhanBank shinhanBank;

	@Resource(name="hana") // 이름에 의한 매핑
	private HanaBank hanaBank;
	
	public void selectBank(String sel) {
		if(sel.equals("신한")) {
			bank = shinhanBank;
		}else if(sel.equals("하나")) {
			bank = hanaBank;
		}
	}
	
	public void playInputMoney(int money) {
		bank.inputMoney(money);
	}
	
	public void playOutputMoney(int money) {
		bank.outputMoney(money);
	}
	
	private String msg;
	
	@PostConstruct // 생성자 먼저 실행되고 이후에 자동발생
	public void init() {
		msg="계좌 잔고 : ";
	}
	
	@PreDestroy // 서비스 클래스(public class Gogek {))가 종료되기 바로 전에 실행
	public void end() {
		if(shinhanBank != null) shinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
	
	public void showMoney() {
		//System.out.println("고객님의 계좌 잔고는 " + bank.getMoney());
		System.out.println(msg + bank.getMoney());
	}
	
	
}
