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
	 * ��ȡ��Ƶ����ϸ��Ϣ
	 * ���� �½� �½��б�
	 */
	public VideoInfo getVideoDetailed(int videoId);
	
	/*
	 * ��ȡ�γ̵�
	 * VideoAssess���� ����ҳ��
	 */
	public List<VideoAssess> videoAssessesList(Map map);
	/*
	 * ��ȡ�γ̵�
	 * VideoAssess����  �ܼ�¼��---------
	 */
	public int getTotalRecordsAssess(int videoId);
	
	/*
	 * ��ȡ�γ̵�
	 * Forum��ѯ����ҳ��
	 */
	public List<Forum> forumsList(Map map);
	/*
	 * ��ȡ�γ̵�
	 * Forum��ѯ �ܼ�¼��----------
	 */
	public int getTotalRecordsForum(int videoId);
	
	/*
	 * ���� ����
	 * assess
	 */
	public void publishAssess(VideoAssess videoAssess);
	
	/*
	 * ���� ��ѯ
	 * forum
	 */
	public void publishForum(Forum forum);
	
	/*
	 * ������Ƶ
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
