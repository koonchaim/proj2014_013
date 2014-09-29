package com.project.bean;

import java.util.Date;

public class Term {
	private String termName;
	private Date startDate;
	private Date endDate;

	public Term(String termName, Date startDate, Date endDate) {
		super();
		this.termName = termName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
