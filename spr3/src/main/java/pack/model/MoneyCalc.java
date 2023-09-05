package pack.model;

public class MoneyCalc implements MoneyInter{
	@Override
	public int[] calcMoney(int money) {
		// money가 45678이 들어왔다 가정
		int[] result = new int[5];
		result[0] = money / 10000; // 몫만 취함
		result[1] = money % 10000 / 1000;
		result[2] = money % 10000 % 1000 / 100;
		result[3] = money % 10000 % 1000 % 100 / 10;
		result[4] = money % 10000 % 1000 % 100 % 10;
		return result;
	}
}
