package zsc.gof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zsc.gof.biz.VideoClassifyBiz;
import zsc.gof.entity.CategoryDetailed;
import zsc.gof.entity.Major;
import zsc.gof.entity.VideoHttpResponse;

@Controller
public class VideoClassifyController {

	@Autowired
	VideoClassifyBiz biz;
	/*
	 * 获取专业及其详细分类
	 */
	@RequestMapping("/getMajors")
	@ResponseBody
	public VideoHttpResponse<List<Major>> getMajors(){
		List<Major> list=null;
		VideoHttpResponse<List<Major>> videoHttpResponse=new VideoHttpResponse<List<Major>>();
		try {
			list=biz.getMajors();
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		} catch (Exception e) {
			videoHttpResponse.setMsg(e.getMessage());
			System.out.println(e);
		}
		return videoHttpResponse;
	}
	
	@RequestMapping("/getCategoryDetaileds")
	@ResponseBody
	public VideoHttpResponse<List<CategoryDetailed>> getCategoryDetaileds(
			@RequestParam("categoryId")int categoryId){
		List list=null;
		VideoHttpResponse<List<CategoryDetailed>> videoHttpResponse=new VideoHttpResponse<List<CategoryDetailed>>();
		try {
			list=biz.getCategoryDetaileds(categoryId);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		} catch (Exception e) {
			videoHttpResponse.setMsg(e.getMessage());
			System.out.print(e);
		}
		return videoHttpResponse;
	}
}
