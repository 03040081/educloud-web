package zsc.gof.dao;

import java.util.List;
import java.util.Map;

import zsc.gof.entity.VideoInfo;

public interface AboutVideosDao {
	
	public List<VideoInfo> getAboutVideos(Map map);
	
	public int getTotalRecords(Map map);
}
