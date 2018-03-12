package zsc.gof.biz.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.gof.biz.TestBiz;
import zsc.gof.dao.TestDao;
import zsc.gof.entity.ChapterDetailed;
@Service
public class TestBizImpl implements TestBiz {

	@Autowired
	TestDao dao;
	
	@Override
	public ChapterDetailed getChapterDetailed(int detailedId) {
		// TODO Auto-generated method stub
		return dao.getChapterDetailed(detailedId);
	}

}
