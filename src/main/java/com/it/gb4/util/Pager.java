package com.it.gb4.util;

public class Pager {
	
	// ********* 검색
	private String kind;
	private String search;
	
	private Integer curPage;
	
	private int startRow;
	private int lastRow;
	
	private int perPage;
	
	// JSP에서 사용
	private long startNum;
	private long lastNum;
	private boolean beforeCheck;
	private boolean nextCheck;
	
	private long totalCount;
	
	public Pager() {
		this.perPage = 10;
	}
	
	//************* startRow, lastRow 계산하는 메서드
	public void makeRow() {
		//***************** rownum 계산 *********************
		startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		lastRow = this.getCurPage()*this.getPerPage();
		//*************************************************
	}
	
	//************ 페이징 계산 ***********************
	public void makePage() {
		
		// 2. 전체 페이지의 개수
		long totalPage = this.getTotalCount()/10; // ex 102
		if(this.getTotalCount()%10 != 0) {
			totalPage++;	//몫이10이라 2가 남아 ++한다.
		}
		
		// 3. 전체 블럭의 수 구하기
		long totalBlock = totalPage/5;	// ex totalPage를 5개씩
		if(totalPage%5 != 0) {
			totalBlock++;
		}
		
		// 4. curPage를 이용해서 현재 블럭 번호 찾기
		long curBlock = this.getCurPage()/5;
		if(this.getCurPage()%5 != 0) {
			curBlock++;
		}
		
		// 5. 현재 블럭번호로 시작번호, 끝 번호 계산
		this.startNum = (curBlock-1)*5+1;
		this.lastNum = curBlock*5;
		
		// 6. 현재 블럭번호와 전체 블럭번호가 같은지 결정
		this.nextCheck = true;
		if(curBlock == totalBlock) {
			nextCheck = !nextCheck;
			// 현재 블럭이 마지막 블럭이라면 lastNum 수정
			lastNum = totalPage;
		}
				
		this.beforeCheck = true;
		if(curBlock == 1) {
			beforeCheck = !beforeCheck;
		}
	}
	
	// *****setter, getter
	
	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isBeforeCheck() {
		return beforeCheck;
	}

	public void setBeforeCheck(boolean beforeCheck) {
		this.beforeCheck = beforeCheck;
	}

	public boolean isNextCheck() {
		return nextCheck;
	}

	public void setNextCheck(boolean nextCheck) {
		this.nextCheck = nextCheck;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public Integer getCurPage() {
		if(curPage == null) {
			curPage=1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		if(curPage == null) {
			curPage = 1;
		}
		this.curPage = curPage;
	}

	public long getTotalCount() {
		if(this.totalCount==0) {
			this.totalCount=1;
		}
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	
}
