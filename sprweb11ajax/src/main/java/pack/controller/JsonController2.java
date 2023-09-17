package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController2 {
	
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJsons(){
		List<Map<String, String>> dataList = new ArrayList<>();
		
		Map<String, String>data = new HashMap<>();
		data.put("name", "한국인");
		data.put("age", "33");
		dataList.add(data);
		
		data = new HashMap<>();
		data.put("name", "신기해");
		data.put("age", "31");
		dataList.add(data);
		
		data = new HashMap<>();
		data.put("name", "신기한");
		data.put("age", "21");
		dataList.add(data);
		
		Map<String, Object> data2 = new HashMap<>();
		data2.put("datas", dataList);
		return data2;
	}
}
