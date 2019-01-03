package site.ilemon.rightsmanagement.util;

import java.util.List;

public class Pagination<T>{


	private Integer currentPage = new Integer(1); // 当前页
	
	private Integer totalRecord; // 总记录数
	
	private Integer totalPage;  //  总页数
	
	private List<T> list;
	
	private Integer pageCount = new Integer(10);
	
	private boolean firstPage;
	
	private boolean lastPage;
	
	private Integer startRow;
	
	private Integer endRow;

	public Pagination(Integer currentPage, Integer totalRecord, List<T> list) {
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalRecord % pageCount == 0 ? totalRecord / pageCount : totalRecord / pageCount + 1;
		this.list = list;
		this.firstPage = currentPage == 1? true: false;
		this.lastPage = currentPage == totalPage? true: false;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	
}
