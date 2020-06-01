/**
 * <p>Title: Page.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: www.zto.com</p>
 */
package com.jyc.zeus.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Class: Page</p>
 * <p>Description: 通用的分页实体</p>
 * @author xiaowenke@zto.cn
 * @date 2017-08-16
 * @version 1.0
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int pageSize;
	
	private int currentPage;
	
	private int pageCount;
	
	private T data;
	
	private List<String> sortFields = new ArrayList<>();
	
	public Page() {
	}

	public Page(int pageSize, int currentPage, int pageCount, T data) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.pageCount = pageCount;
		this.data = data;
	}
	
	public Page(int pageSize, int currentPage, int pageCount, T data, List<String> sortFields) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.pageCount = pageCount;
		this.data = data;
		this.sortFields = sortFields;
	}

	public List<String> getSortFields() {
		return sortFields;
	}

	public void setSortFields(List<String> sortFields) {
		this.sortFields = sortFields;
	}

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

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
