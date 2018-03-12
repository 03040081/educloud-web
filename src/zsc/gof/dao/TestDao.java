package zsc.gof.dao;

import org.apache.ibatis.annotations.Select;

import zsc.gof.entity.ChapterDetailed;

public interface TestDao {
	@Select("select * from chapterdetailed where detailedId=#{detailedId}")
	public ChapterDetailed getChapterDetailed(int detailedId);
}
