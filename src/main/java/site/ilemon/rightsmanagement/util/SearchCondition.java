package site.ilemon.rightsmanagement.util;

public class SearchCondition {

	private String searchKeyword;
	
	private Integer currPage = new Integer(1);
	
	private Integer pageSize = new Integer(10);
	
	private Integer startRow;
	
	private Integer endRow;
	
	

	public SearchCondition(int currPage) {
		this.currPage = currPage;
		this.startRow = currPage == 1 ? 0 : (currPage-1)*(pageSize);
		this.endRow = pageSize;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
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

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
}
