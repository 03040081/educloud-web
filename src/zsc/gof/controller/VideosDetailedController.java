package zsc.gof.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zsc.gof.biz.VideosDetailedBiz;
import zsc.gof.entity.Category;
import zsc.gof.entity.CategoryDetailed;
import zsc.gof.entity.ChapterDetailed;
import zsc.gof.entity.Forum;
import zsc.gof.entity.Major;
import zsc.gof.entity.Rank;
import zsc.gof.entity.User;
import zsc.gof.entity.VideoAssess;
import zsc.gof.entity.VideoChapter;
import zsc.gof.entity.VideoHttpResponse;
import zsc.gof.entity.VideoInfo;

@Controller
public class VideosDetailedController {

	@Autowired
	VideosDetailedBiz biz;

	@RequestMapping("/publishVideo")
	@ResponseBody
	public VideoInfo publishVideo(@RequestParam("videoTile") String videoTile,
			@RequestParam("videoDiscript")String videoDiscript,
			@RequestParam("prices")double prices,
			@RequestParam("picUrl")MultipartFile picUrl,
			@RequestParam("rankId")int rankId,
			@RequestParam("majorId")int majorId,
			@RequestParam("categoryId")int categoryId,
			@RequestParam("cgdetailedId")int cgdetailedId,
			HttpSession session){
		VideoInfo videoInfo=null;
		try{
			videoInfo=new VideoInfo();
			videoInfo.setVideoTile(videoTile);
			videoInfo.setVideoDiscript(videoDiscript);
			videoInfo.setPrices(prices);
			Rank rank=new Rank();
			rank.setRankId(rankId);
			videoInfo.setRank(rank);
			Major major=new Major();
			major.setMajorId(majorId);
			videoInfo.setMajor(major);
			Category category=new Category();
			category.setCategoryId(categoryId);
			videoInfo.setCategory(category);
			CategoryDetailed categoryDetailed=new CategoryDetailed();
			categoryDetailed.setCgdetailedId(cgdetailedId);
			videoInfo.setCategoryDetailed(categoryDetailed);

			String basepath=session.getServletContext().getRealPath("videos");
			String filePath=picUrl.getOriginalFilename();

			String fileType=filePath.substring(filePath.lastIndexOf("."));

			String serialName=String.valueOf(System.currentTimeMillis());

			picUrl.transferTo(new File(basepath+"/img/"+serialName+fileType));
			videoInfo.setPicUrl("videos/img/"+serialName+fileType);
			/*for(int i=0;i<videoUrls.length;i++){

			}*/
			biz.publishVideo(videoInfo);

		}catch(Exception ex){
			System.out.println(ex);
		}

		return videoInfo;
	}

	@RequestMapping("/publishChapter")
	@ResponseBody
	public VideoChapter publishChapter(@RequestParam("videoId")int videoId,
			@RequestParam("chapterName")String chapterName,
			@RequestParam("detailedTile")String[] detailedTiles,
			@RequestParam("videoUrl") MultipartFile[] videoUrls,
			HttpServletRequest request){

		VideoChapter videoChapter=null;
		try {
			videoChapter=new VideoChapter();
			videoChapter.setVideoId(videoId);
			videoChapter.setChapterName(chapterName);
			if(detailedTiles.length>0&&detailedTiles.length==videoUrls.length){


				String path=request.getSession().getServletContext().getRealPath("videos");

				List<ChapterDetailed> list=new ArrayList<ChapterDetailed>();
				for(int i=0;i<videoUrls.length;i++){
					ChapterDetailed chapterDetailed=new ChapterDetailed();
					chapterDetailed.setDetailedTile(detailedTiles[i]);

					String fileName=videoUrls[i].getOriginalFilename();

					String fileType=fileName.substring(fileName.lastIndexOf("."));

					String serialName=String.valueOf(System.currentTimeMillis());

					videoUrls[i].transferTo(new File(path+"/temp/"+serialName+fileType));

					chapterDetailed.setVideoUrl("videos/temp/"+serialName+fileType);
					list.add(chapterDetailed);
					System.out.println(fileName);
				}
				videoChapter.setListChapterDetailed(list);
			}
			biz.publishChapter(videoChapter);
		} catch (Exception e) {
			System.out.println(e);
		}
		return videoChapter;
	}

	/*
	 * 获取视频的详细信息
	 */
	@RequestMapping("/getVideoDetailed")
	@ResponseBody
	public VideoHttpResponse<VideoInfo> get(@RequestParam("videoId")int videoId){
		VideoInfo videoInfo=null;
		VideoHttpResponse<VideoInfo> videoHttpResponse=new VideoHttpResponse<VideoInfo>();
		try {
			videoInfo=biz.getVideoDetailed(videoId);
			
			videoHttpResponse.setRet(videoInfo);
			videoHttpResponse.setCode(200);
		} catch (Exception e) {
			videoHttpResponse.setMsg(e.getMessage());
			System.out.println(e);
		}

		return videoHttpResponse;
	}
	/*
	 * 获取视频评论
	 */
	@RequestMapping("/videoAssessesList")
	@ResponseBody
	public VideoHttpResponse<List<VideoAssess>> videoAssessesList(
			@RequestParam("videoId")int videoId,
			@RequestParam("currPage")int currPage,
			@RequestParam("pageSize")int pageSize){
		List<VideoAssess> list=null;
		VideoHttpResponse<List<VideoAssess>>videoHttpResponse=new VideoHttpResponse<List<VideoAssess>>();
		try{
			Map<String,Integer> map=new HashMap<String, Integer>();
			map.put("videoId", videoId);
			map.put("currPage", (currPage-1)*pageSize);
			map.put("pageSize", pageSize);
			list=biz.videoAssessesList(map);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		}catch(Exception e){
			videoHttpResponse.setMsg(e.getMessage());
		}
		
		return videoHttpResponse;
	}

	/*
	 * 获取视频咨询列表
	 */
	@RequestMapping("/forumsList")
	@ResponseBody
	public VideoHttpResponse<List<Forum>> forumsList(
			@RequestParam("videoId")int videoId,
			@RequestParam("currPage")int currPage,
			@RequestParam("pageSize")int pageSize){
		VideoHttpResponse<List<Forum>> videoHttpResponse=new VideoHttpResponse<List<Forum>>();
		List<Forum>list=null;
		try{
			Map<String,Integer> map=new HashMap<String, Integer>();
			map.put("videoId", videoId);
			map.put("currPage", (currPage-1)*pageSize);
			map.put("pageSize", pageSize);
			list=biz.forumsList(map);
			videoHttpResponse.setRet(list);
			videoHttpResponse.setCode(200);
		}catch(Exception e){
			videoHttpResponse.setMsg(e.getMessage());
		}
		
		return videoHttpResponse;
	}
	
	@RequestMapping("/publishAssess")
	public void publishAssess(
			@RequestParam("videoId")int videoId,
			@RequestParam("score")float score,
			@RequestParam("contents")String contents,
			@RequestParam("userId")int userId){
		VideoAssess videoAssess=new VideoAssess();
		User user=new User();
		user.setUserId(userId);
		videoAssess.setVideoId(videoId);
		videoAssess.setScore(score);
		videoAssess.setContents(contents);
		videoAssess.setUser(user);
		biz.publishAssess(videoAssess);
	}
	/*
	 * 发表咨询
	 */
	@RequestMapping("/publishForum")
	public void publishForum(
			@RequestParam("videoId")int videoId,
			@RequestParam("contents")String contents,
			@RequestParam("userId")int userId){
		Forum forum=new Forum();
		User user=new User();
		user.setUserId(userId);
		forum.setUser(user);
		forum.setContents(contents);
		forum.setVideoId(videoId);
		biz.publishForum(forum);
	}

	public static int hashFunc(String key){  
		int arraySize = 113;          //数组大小一般取质数  
		int hashCode = 0;  
		for(int i=0;i<key.length();i++){        //从字符串的左边开始计算  
			int letterValue=0;
			if(key.charAt(i)=='.')
				letterValue=key.charAt(i);
			letterValue = key.charAt(i) - 96;//将获取到的字符串转换成数字，比如a的码值是97，则97-96=1 就代表a的值，同理b=2；  
			hashCode = ((hashCode << 3) + letterValue) % arraySize;//防止编码溢出，对每步结果都进行取模运算  
		}  
		return hashCode;  
	} 


	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for"); 
		System.out.println("x-forwarded-for ip: " + ip);
		if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			if( ip.indexOf(",")!=-1 ){
				ip = ip.split(",")[0];
			}
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("Proxy-Client-IP");  
			System.out.println("Proxy-Client-IP ip: " + ip);
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("WL-Proxy-Client-IP");  
			System.out.println("WL-Proxy-Client-IP ip: " + ip);
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("HTTP_CLIENT_IP");  
			System.out.println("HTTP_CLIENT_IP ip: " + ip);
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
			System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("X-Real-IP");  
			System.out.println("X-Real-IP ip: " + ip);
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getRemoteAddr();  
			System.out.println("getRemoteAddr ip: " + ip);
		} 
		System.out.println("获取客户端ip: " + ip);
		return ip;  
	}
}
