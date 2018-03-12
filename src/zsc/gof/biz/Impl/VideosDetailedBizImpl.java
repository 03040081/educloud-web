package zsc.gof.biz.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.VideosDetailedBiz;
import zsc.gof.dao.VideosDetailedDao;
import zsc.gof.entity.Forum;
import zsc.gof.entity.VideoAssess;
import zsc.gof.entity.VideoChapter;
import zsc.gof.entity.VideoInfo;

@Service
public class VideosDetailedBizImpl implements VideosDetailedBiz {

	@Autowired
	VideosDetailedDao dao;
	
	@Override
	public int publishVideo(VideoInfo videoInfo) {
		// TODO Auto-generated method stub
		try{
			dao.publishVideo(videoInfo);
			//dao.publishVideoChapters(videoInfo);
		}catch(Exception exception){
			System.out.println(exception);
		}
		
		return 1;
	}

	@Override
	public int publishChapter(VideoChapter videoChapter) {
		// TODO Auto-generated method stub
		dao.publishVideoChapters(videoChapter);
		dao.publishChapterDetaileds(videoChapter);
		return 0;
	}

	@Override
	public VideoInfo getVideoDetailed(int videoId) {
		// TODO Auto-generated method stub
		return dao.getVideoDetailed(videoId);
	}

	@Override
	public List<VideoAssess> videoAssessesList(Map map) {
		// TODO Auto-generated method stub
		return dao.videoAssessesList(map);
	}

	@Override
	public List<Forum> forumsList(Map map) {
		// TODO Auto-generated method stub
		return dao.forumsList(map);
	}

	@Override
	public void publishAssess(VideoAssess videoAssess) {
		// TODO Auto-generated method stub
		dao.publishAssess(videoAssess);
	}

	@Override
	public void publishForum(Forum forum) {
		// TODO Auto-generated method stub
		dao.publishForum(forum);
	}

	@Override
	public int publishChapterDetaileds(VideoChapter videoChapter) {
		// TODO Auto-generated method stub
		return dao.publishChapterDetaileds(videoChapter);
	}

	@Override
	public int getTotalRecordsAssess(int videoId) {
		// TODO Auto-generated method stub
		return dao.getTotalRecordsAssess(videoId);
	}

	@Override
	public int getTotalRecordsForum(int videoId) {
		// TODO Auto-generated method stub
		return dao.getTotalRecordsForum(videoId);
	}

}
