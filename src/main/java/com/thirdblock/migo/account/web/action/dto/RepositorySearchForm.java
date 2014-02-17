package com.thirdblock.migo.account.web.action.dto;

public class RepositorySearchForm {

	private int pageSize = 10;
	private int currentPage = 1;

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

}
