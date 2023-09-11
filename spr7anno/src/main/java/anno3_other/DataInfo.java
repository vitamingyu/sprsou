package anno3_other;

import org.springframework.stereotype.Component;

@Component
public class DataInfo {
	private String name = "한국인";
	private String part = "개발부";
	public String job = "프로그래머";
	
	public String getName() {
		return name;
	}
	
	public String getPart() {
		return part;
	}
	
	public String getJob() {
		return job;
	}
}
