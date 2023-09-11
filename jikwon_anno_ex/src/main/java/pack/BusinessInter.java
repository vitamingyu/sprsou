package pack;

import java.util.List;

public interface BusinessInter {
	List<JikwonDto>selectDataAll();
	List<JikwonDto>buserMax();
	List<JikwonDto>countIn();
	void dataShow();
	void buser();
	void count();
}
