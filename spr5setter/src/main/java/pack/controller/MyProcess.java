package pack.controller;

import pack.model.CalcInter;

public class MyProcess {
	private String name;
	private int su;
	//private Gugudan gugudan;
	private CalcInter calcInter; // 위에는 다형성을 안 씀
	//생성자 쓸 수 있지만 setter 연습중이니 setter씀
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public void setCalcInter(CalcInter calcInter) {
		this.calcInter = calcInter;
	}
	
//	public String displayData() {
//		int[] results = calcInter.numberCalc9(su);
//		String ss ="";
//		for (int i = 0; i < results.length; i++) {
//			ss += su + "*" + (i + 1) + "=" + results[i] + "\n";
//		}
//		return "작성자:" + name + "\n" + su + "단 결과 : \n" + ss;
//	}
	
	@Override
	public String toString() {
		int[] results = calcInter.numberCalc9(su);
		String ss ="";
		for (int i = 0; i < results.length; i++) {
			ss += su + "*" + (i + 1) + "=" + results[i] + "\n";
		}
		return "작성자:" + name + "\n" + su + "단 결과 : \n" + ss;
	}
	
	
}
