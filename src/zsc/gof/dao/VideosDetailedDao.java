package zsc.gof.dao;

import java.util.List;
import java.util.Map;

import zsc.gof.entity.ChapterDetailed;
import zsc.gof.entity.Forum;
import zsc.gof.entity.VideoAssess;
import zsc.gof.entity.VideoChapter;
import zsc.gof.entity.VideoInfo;

public interface VideosDetailedDao {

	/*
	 * 获取视频的详细信息
	 * 包含 章节 章节列表
	 */
	public VideoInfo getVideoDetailed(int videoId);
	
	/*
	 * 获取课程的
	 * VideoAssess评论 （分页）
	 */
	public List<VideoAssess> videoAssessesList(Map map);
	/*
	 * 获取课程的
	 * VideoAssess评论  总记录数---------
	 */
	public int getTotalRecordsAssess(int videoId);
	
	/*
	 * 获取课程的
	 * Forum咨询（分页）
	 */
	public List<Forum> forumsList(Map map);
	/*
	 * 获取课程的
	 * Forum咨询 总记录数----------
	 */
	public int getTotalRecordsForum(int videoId);
	
	/*
	 * 发表 评价
	 * assess
	 */
	public void publishAssess(VideoAssess videoAssess);
	
	/*
	 * 发表 咨询
	 * forum
	 */
	public void publishForum(Forum forum);
	
	/*
	 * 发布视频
	 * 
	 */
	public int publishVideo(VideoInfo videoInfo);
	
	/*
	 * VideoChapter
	 */
	public int publishVideoChapters(VideoChapter videoChapter);
	
	/*
	 * ChapterDetailed
	 */
	public int publishChapterDetaileds(VideoChapter videoChapter);
}
