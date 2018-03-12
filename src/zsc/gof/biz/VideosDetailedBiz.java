package zsc.gof.biz;

import java.util.List;
import java.util.Map;

import zsc.gof.entity.Forum;
import zsc.gof.entity.VideoAssess;
import zsc.gof.entity.VideoChapter;
import zsc.gof.entity.VideoInfo;

public interface VideosDetailedBiz {

	public int publishVideo(VideoInfo videoInfo);
	
	public List<VideoAssess> videoAssessesList(Map map);
	
	public List<Forum> forumsList(Map map);
	
	public void publishAssess(VideoAssess videoAssess);
	
	public void publishForum(Forum forum);
	
	public int publishChapter(VideoChapter videoChapter);
	
	public VideoInfo getVideoDetailed(int videoId);
	
	public int publishChapterDetaileds(VideoChapter videoChapter);
	
	/*
	 * 获取课程的
	 * VideoAssess评论  总记录数---------
	 */
	public int getTotalRecordsAssess(int videoId);
	
	/*
	 * 获取课程的
	 * Forum咨询 总记录数----------
	 */
	public int getTotalRecordsForum(int videoId);
}
