package com.project.bean;

import java.util.Date;

public class ScheduleBean {
	// private int schedule_ID;
	private Date dateAttendance;
	private TermBean termBean;
	private AttendanceBean attendance;

	public ScheduleBean() {

	}

	public ScheduleBean(Date dateAttendance, TermBean termBean, AttendanceBean attendance) {
		super();
		this.dateAttendance = dateAttendance;
		this.termBean = termBean;
		this.attendance = attendance;
	}

	public Date getDateAttendance() {
		return dateAttendance;
	}

	public void setDateAttendance(Date dateAttendance) {
		this.dateAttendance = dateAttendance;
	}

	public TermBean getTerm() {
		return termBean;
	}

	public void setTerm(TermBean termBean) {
		this.termBean = termBean;
	}

	public AttendanceBean getAttendance() {
		return attendance;
	}

	public void setAttendance(AttendanceBean attendance) {
		this.attendance = attendance;
	}

	// public int getSchedule_ID() {
	// return schedule_ID;
	// }
	//
	// public void setSchedule_ID(int schedule_ID) {
	// this.schedule_ID = schedule_ID;
	// }

}
