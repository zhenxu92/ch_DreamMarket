package dao.common;

public class Page {
	private int pageRecord;
	private int currentPage;
	private int totalRecord;
	private int startIndex;
	private int endIndex;
	private int totalPage;
	private boolean hasPrePage;
	private boolean hasNextPage;

	public Page() {
	};

	
	public Page(int pageRecord, int currentPage, int totalRecord, int startIndex, int endIndex, int totalPage, boolean hasPrePage,
			boolean hasNextPage) {
		this.pageRecord = pageRecord;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.totalPage = totalPage;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}

	public int getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}


	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}


	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
}
