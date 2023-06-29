package com.pojo;

import java.util.List;

public class ApiWrite {

	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<Data> e;
	private Support1 support1;
	public ApiWrite(int page, int per_page, int total, int total_pages, List<Data> e, Support1 support1) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.e = e;
		this.support1 = support1;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<Data> getE() {
		return e;
	}
	public void setE(List<Data> e) {
		this.e = e;
	}
	public Support1 getSupport1() {
		return support1;
	}
	public void setSupport1(Support1 support1) {
		this.support1 = support1;
	}
				
}
