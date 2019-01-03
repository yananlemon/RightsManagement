package site.ilemon.rightsmanagement.util;

import java.util.ArrayList;
import java.util.List;

public class Pagination<T>{


	private Integer currentPage = new Integer(1); // 当前页
	
	private Integer totalRecord; // 总记录数
	
	private Integer totalPage;  //  总页数
	
	private List<T> list;
	
	private Integer pageSize = new Integer(10);
	
	private List<Integer> pageSizes = new ArrayList<Integer>();
	
	private boolean firstPage;
	
	private boolean lastPage;
	
	private Integer startRow;
	
	private Integer endRow;

	public Pagination(Integer currentPage, Integer totalRecord, Integer pageSize,List<T> list) {
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		this.totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
		this.list = list;
		this.firstPage = currentPage == 1? true: false;
		this.lastPage = currentPage == totalPage? true: false;
		this.pageSizes.add(10);
		this.pageSizes.add(20);
		this.pageSizes.add(50);
	}
	
	public Pagination(Integer currentPage, Integer totalRecord,List<T> list) {
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
		this.list = list;
		this.firstPage = currentPage == 1? true: false;
		this.lastPage = currentPage == totalPage? true: false;
		this.pageSizes.add(10);
		this.pageSizes.add(20);
		this.pageSizes.add(50);
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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public List<Integer> getPageSizes() {
		return pageSizes;
	}

	public void setPageSizes(List<Integer> pageSizes) {
		this.pageSizes = pageSizes;
	}
	
}
