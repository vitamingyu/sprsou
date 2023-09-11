package anno2_resource;

import org.springframework.stereotype.Component;

@Component("kbs")
public class Abc2 {
	private int nai;
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public int getNai() {
		return nai;
	}
}
