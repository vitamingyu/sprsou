package pack.controller;

import java.util.Scanner;

import pack.model.MoneyInter;

public class MyServiceProcess implements MyServiceInter{
	private MoneyInter inter; // 다형성을 위해 이렇게 함    / moneyinter는 인터테이스니까 new할 수 없다는데
	private int re[];
	
	public MyServiceProcess(MoneyInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void inputMoney() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("금액을 입력하세요");
			int myMoney = scanner.nextInt();
			re = inter.calcMoney(myMoney);
		} catch (Exception e) {
			System.out.println("inputMoney err : "+e.getMessage());
		}
		
	}
	
	@Override
	public void showMoney() {
		StringBuffer sb = new StringBuffer();
		sb.append("만원 : " + re[0] + "\n");
		sb.append("천원 : " + re[1] + "\n");
		sb.append("백원 : " + re[2] + "\n");
		sb.append("십원 : " + re[3] + "\n");
		sb.append("일원 : " + re[4] + "\n");
		System.out.println(sb.toString());
	}
}
