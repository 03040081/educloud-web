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
	 * ��ȡ�γ̵�
	 * VideoAssess����  �ܼ�¼��---------
	 */
	public int getTotalRecordsAssess(int videoId);
	
	/*
	 * ��ȡ�γ̵�
	 * Forum��ѯ �ܼ�¼��----------
	 */
	public int getTotalRecordsForum(int videoId);
}
