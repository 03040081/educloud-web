package zsc.gof.biz.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.VideoClassifyBiz;
import zsc.gof.biz.VideosDetailedBiz;
import zsc.gof.dao.VideoClassifyDao;
import zsc.gof.entity.CategoryDetailed;
import zsc.gof.entity.Major;

@Service
public class VideoClassifyBizImpl implements VideoClassifyBiz {

	@Autowired
	VideoClassifyDao dao;
	
	@Override
	public List<Major> getMajors() {
		// TODO Auto-generated method stub
		return dao.getMajors();
	}

	@Override
	public List<CategoryDetailed> getCategoryDetaileds(int categoryId) {
		// TODO Auto-generated method stub
		return dao.getCategoryDetaileds(categoryId);
	}

}
