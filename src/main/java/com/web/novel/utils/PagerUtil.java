package com.book.utils;

public class PagerUtil {
	/**
	 * 分页的六大必备条件，却一不可，切记
	 */
	private int totalRows;//总条数; 不用写算法从数据库获取条数，用分页前必须设置
	private int pageSize=10;//当前页面显示条数默认5条，不用写算法
	private int currentPage=1;//当前页：默认1 ， 不用写算法
	private int startRow;//数据库查询sql语句的开始条数
	private int endTow;//数据库查询sql语句的结束条数
	private int totalPage;//总页数
	
	public int getTotalPage() {
		if(totalRows<=pageSize){
			totalPage=1;
		}else{
			totalPage=(totalRows+pageSize-1)/pageSize;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		
		this.totalPage = totalPage;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrenPage() {
		if(currentPage <= 0){
			currentPage=1;
		}
		return currentPage;
	}
	public void setCurrenPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		startRow=(currentPage-1) * pageSize;
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndTow() {
		endTow=currentPage*pageSize;
		return endTow;
	}
	public void setEndTow(int endTow) {
		this.endTow = endTow;
	}
	
}	
