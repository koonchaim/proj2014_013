package com.project.print_list_student_for_activities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.project.bean.TermBean;
import com.project.utility.ConnectDB;

public class PrintListStudentForActivitiesManager {
	public TermBean findTermByTermName(String termName) throws SQLException {
		TermBean termBean = new TermBean();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM term WHERE termName = ?";

		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, termName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				termBean.setTermName(rs.getString("termName"));
				termBean.setStartDate(rs.getDate("startDate"));
				termBean.setEndDate(rs.getDate("endDate"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

		return termBean;
	}

	public Integer calAttendance(TermBean termBean) {
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(termBean.getStartDate());
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(termBean.getEndDate());

		int diffWeeks = endCalendar.get(Calendar.WEEK_OF_YEAR) - startCalendar.get(Calendar.WEEK_OF_YEAR);
		int diffDays = endCalendar.get(Calendar.DAY_OF_YEAR) - startCalendar.get(Calendar.DAY_OF_YEAR);
		int totalDay = diffDays - (diffWeeks * 2);

		int diffTotal = (totalDay * 80) / 100;
		int diffDayTotal = totalDay - diffTotal;

		System.out.println("Diff Weeks : " + diffWeeks + "\tWeek");
		System.out.println("Diff Days  : " + diffDays + "\tDay");
		System.out.println("TotalDay   : " + totalDay + "\tDay");
		System.out.println("TotalDay 80 %   : " + diffTotal + "\tDay");
		System.out.println("Total   : " + diffDayTotal + "\tDay");
		return diffDayTotal;
	}

}
