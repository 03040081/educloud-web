package zsc.gof.biz;

import java.util.List;
import java.util.Map;

import zsc.gof.entity.VideoInfo;

public interface AboutVideosBiz {

	/*
	 * 获取课程
	 */
	public List<VideoInfo> getVideos(Map<String,Object> map);
	/*
	 * 获取免费课程
	 * price=0
	 */
	public List<VideoInfo> getFreeVideos(Map<String,Object> map);
	
	/*
	 * 获取首页推荐课程
	 * recommend=1
	 */
	public List<VideoInfo> getRecommendVideos(Map<String,Object> map);
	
	/*
	 * 根据标题videoTile获取搜索的课程
	 * videoTile
	 */
	public List<VideoInfo> searchVideos(Map<String,Object> map);
	
	/*
	 * 获取指定专业课程
	 * major
	 */
	public List<VideoInfo> smajorVideos(Map<String,Object> map);
	
	/*
	 * 获取指定专业中对应种类的课程
	 * major & category
	 */
	public List<VideoInfo> categoryVideos(Map<String,Object> map);
	
	/*
	 * 获取指定专业中对应种类的专业方向课程
	 * major & category & cgdetaliedId
	 */
	public List<VideoInfo> cgdetailedVideos(Map<String,Object> map);
	
	/*
	 * 获取查询结果 总记录数
	 */
	public int getTotalRecords(Map<String,Object> map);
}
