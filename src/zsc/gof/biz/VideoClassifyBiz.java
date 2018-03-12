package zsc.gof.biz;

import java.util.List;

import zsc.gof.entity.CategoryDetailed;
import zsc.gof.entity.Major;

public interface VideoClassifyBiz {

	/*
	 * 获取所有专业及其专业中的种类
	 * Major & Category
	 */
	public List<Major> getMajors();
	
	/*
	 * 获取详细分类
	 */
	public List<CategoryDetailed> getCategoryDetaileds(int categoryId);
}
