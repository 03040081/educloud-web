package zsc.gof.entity;

import java.util.List;

public class PageModel {
	private int currPage;//当前页
	private int totalRecords;//总记录数
	private List<?> list;
	private int pageSize;
	public PageModel(){}
	/*
	 * 获取总页数
	 
	public int getTotalPage(){
		return (totalRecords+pageSize-1)/pageSize;
	}*/
	/*
	 * 获取第一页
	 
	public int getFirstPage(){
		return 1;
	}
	
	 * 获取上一页
	 
	public int getPreviousPage(){
		return currPage<=1?1:currPage-1;
	}
	
	 * 获取下一页
	 
	public int getNextPage(){
		if(currPage>=getTotalPage()){
			return getLastPage();
		}
		return currPage+1;
	}
	public int getLastPage(){
		return getTotalPage()<=0?1:getTotalPage();
	}*/
	
	public void setTotalRecords(int totalRecords){
		this.totalRecords=totalRecords;
	}
	public void setCurrPage(int currPage){
		this.currPage=currPage;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
}
