package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.BuserDto;
import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class DataController {
	@Autowired // 모델을 다녀와
	private DataDao dataDao;
	
	@GetMapping("buserlist")
	public String buserProcess(Model model) {
		ArrayList<BuserDto> blist=dataDao.buserList();
		
		model.addAttribute("blist",blist);
		return "list";
	}
	
	@GetMapping("jikwonlist")
	@ResponseBody
	public Map<String, Object> jikwonProcess(@RequestParam("buser_no")String buser_no, Model model) {
		List<Map<String, String>>jlist = new ArrayList<>();
		Map<String, String> data = null;
		
		for(JikwonDto j:dataDao.jikwonList(buser_no)) {
			data = new HashMap<String,String>();
			data.put("no", j.getJikwon_no());
			data.put("name", j.getJikwon_name());
			data.put("jik", j.getJikwon_jik());
			jlist.add(data);
		}
		Map<String, Object> jikList=new HashMap<>();
		jikList.put("datas", jlist);
		return jikList;
	}
}
