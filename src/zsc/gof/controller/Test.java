package zsc.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.TestBiz;
import zsc.gof.entity.ChapterDetailed;

@Controller
public class Test {
	
	@Autowired
	TestBiz biz;
	
	@RequestMapping("/play")
	public ModelAndView play(@RequestParam("detailedId")int detailedId){
		ModelAndView modelAndView=new ModelAndView("index4");
		ChapterDetailed testD=biz.getChapterDetailed(detailedId);
		modelAndView.addObject("video",testD);
		return modelAndView;
	}
}
