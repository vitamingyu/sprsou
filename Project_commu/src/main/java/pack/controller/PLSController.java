package pack.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.CommuDao;
import pack.model.CommuDto;

@Controller
public class PLSController {
	@Autowired
	private CommuDao comDao;

	private int tot; // 전체 레코드 수
	private int plist = 10; // 페이지 당 행 수
	private int pagesu; // 전체 페이지 수

	public ArrayList<CommuDto> getListdata(ArrayList<CommuDto> list, int page) {
		ArrayList<CommuDto> result = new ArrayList<CommuDto>();

		int start = (page - 1) * plist; // 0, 10, 20, ...

		int size = plist <= list.size() - start ? plist : list.size() - start; // 삼항 연산

		for (int i = 0; i < size; i++) {
			result.add(i, list.get(start + i));
		}
		return result;
	}

	public int getPageSu() { // 총 페이지 수 얻기
		tot = comDao.totalCnt();
		pagesu = tot / plist;
		if (tot % plist > 0)
			pagesu += 1;
		return pagesu;
	}

	@GetMapping("commu")
	public String listProcess(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		int spage = page;
		if (page <= 0)
			spage = 1;

		// 전체자료 읽어오기, paging 처리도 함
		ArrayList<CommuDto> list = (ArrayList<CommuDto>) comDao.selectAll();
		ArrayList<CommuDto> result = getListdata(list, spage);

		model.addAttribute("list", result);
		model.addAttribute("pagesu", getPageSu());
		model.addAttribute("page", spage);

		return "commu";
	}

	@GetMapping("search")
	public String searchProcess(CommuBean bean, Model model) {
		// System.out.println(bean.getSearchName() + " " + bean.getSearchValue());
		ArrayList<CommuDto> list = (ArrayList<CommuDto>) comDao.search(bean);

		model.addAttribute("list", list);
		model.addAttribute("pagesu", getPageSu());
		model.addAttribute("page", "1");
		return "commu";
	}

}
