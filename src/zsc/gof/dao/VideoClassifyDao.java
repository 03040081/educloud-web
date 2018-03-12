package zsc.gof.dao;

import java.util.List;

import zsc.gof.entity.CategoryDetailed;
import zsc.gof.entity.Major;

public interface VideoClassifyDao {

	/*
	 * ��ȡ����רҵ����רҵ�е�����
	 * Major & Category
	 */
	public List<Major> getMajors();
	
	/*
	 * ��ȡ��ϸ����
	 */
	public List<CategoryDetailed> getCategoryDetaileds(int categoryId);
	
}
