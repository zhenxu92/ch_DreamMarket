package dao.common; 

// 得到分页信息的工具类
public class PageUtil {
	public static Page getPage(int pageRecord, int currentPage, int totalRecord) {
		pageRecord = getPageRecord(pageRecord);
		currentPage = getCurrentPage(currentPage);
		int startIndex = getStartIndex(pageRecord, currentPage);
		int totalPage = getTotalPage(pageRecord, totalRecord);
		int endIndex = getEndIndex(pageRecord,startIndex,totalRecord,currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getNextPage(currentPage, totalPage);
		return new Page(pageRecord, currentPage, totalRecord, startIndex, endIndex, totalPage, hasPrePage, hasNextPage);
	}

	public static int getPageRecord(int pageRecord) {
		return pageRecord == 0 ? 8 : pageRecord;
	}

	public static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}

	public static int getStartIndex(int pageRecord, int currentPage) {
		return (currentPage - 1) * pageRecord;
	}
	public static int getTotalPage(int pageRecord, int totalRecord) {
		int totalPage = 0;
		if (totalRecord != 0 && totalRecord % pageRecord == 0) {
			totalPage = totalRecord / pageRecord;
		} else {
			totalPage = totalRecord / pageRecord + 1;
		}
		return totalPage;
	}
	public static int getEndIndex(int pageRecord,int startIndex,int totalRecord,int currentPage){
		if(currentPage*pageRecord>totalRecord){
			return totalRecord;
		}
		return startIndex + pageRecord;
	};
	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	public static boolean getNextPage(int currentPage, int totalPage) {
		return currentPage == totalPage ? false : true;
	}
}
