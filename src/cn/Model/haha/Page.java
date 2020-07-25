package cn.Model.haha;

import java.util.List;

public class Page {
	private int currentPage;
	private int count;
	private int PageSize;
	private List<Student> students;
	private int totalPage;
	
	public Page() {
		super();
	}

	public Page(int currentPage, int count, int pageSize, List<Student> students, int totalPage) {
		super();
		this.currentPage = currentPage;
		this.count = count;
		PageSize = pageSize;
		this.students = students;
		this.totalPage = totalPage;
	}
	public Page(int currentPage, int count, int pageSize, List<Student> students) {
		super();
		this.currentPage = currentPage;
		this.count = count;
		PageSize = pageSize;
		this.students = students;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
		this.totalPage=this.count%this.PageSize==0?this.count/this.PageSize:this.count/this.PageSize+1;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
