package com.book.utils;

public class Pager {
    private int totalRows; //总行数    
    private int pageSize = 10; //每页显示的行数      
    private int currentPage=1; //当前页号    
    private int totalPages; //总页数     
    private int startRow; //当前页在数据库中的起始行      
    
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
	public int getCurrentPage() {
		if(currentPage <= 0){
			currentPage=1;
		}
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		if(totalRows<=pageSize){
			totalPages=1;
		}else{
			totalPages=(totalRows+pageSize-1)/pageSize;
		}
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartRow() {
		startRow=(currentPage-1) * pageSize+1;
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
   
}
