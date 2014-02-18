package com.thirdblock.migo.core.web.action.dto;

public class BaseSearchForm {
	
	protected int pageSize = 10;
	protected int currentPage = 1;
	protected boolean isPage = true;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}
	
}
