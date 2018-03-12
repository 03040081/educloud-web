package zsc.gof.biz.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.AboutVideosBiz;
import zsc.gof.dao.AboutVideosDao;
import zsc.gof.entity.VideoInfo;

@Service
public class AboutVideosBizImpl implements AboutVideosBiz {

	@Autowired
	AboutVideosDao dao;
	
	@Override
	public List<VideoInfo> getVideos(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.getAboutVideos(map);
	}

	@Override
	public List<VideoInfo> getFreeVideos(Map<String,Object> map) {
		// TODO Auto-generated method stub
		System.out.println(map.get("prices"));
		System.out.println(map);
		return dao.getAboutVideos(map);
	}

	@Override
	public List<VideoInfo> getRecommendVideos(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.getAboutVideos(map);
	}

	@Override
	public List<VideoInfo> searchVideos(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.getAboutVideos(map);
	}

	@Override
	public List<VideoInfo> smajorVideos(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.getAboutVideos(map);
	}

	@Override
	public List<VideoInfo> categoryVideos(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.getAboutVideos(map);
	}

	@Override
	public List<VideoInfo> cgdetailedVideos(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.getAboutVideos(map);
	}

	@Override
	public int getTotalRecords(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.getTotalRecords(map);
	}
}
