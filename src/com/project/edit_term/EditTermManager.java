package com.project.edit_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.bean.HolidayBean;
import com.project.bean.TermBean;
import com.project.utility.ConnectDB;

public class EditTermManager {

	public TermBean findTermByTermName(String termName) throws SQLException {
		TermBean term = new TermBean();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select * from term where termName = ?";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, termName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {				
				term.setStartDate(rs.getDate("startDate"));
				term.setEndDate(rs.getDate("endDate"));
				term.setTermName(rs.getString("termName"));
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
		return term;
	}
	
//	public boolean editTerm(TermBean term) throws SQLException {
//		boolean chk = true;
//		Connection conn = null;
//		PreparedStatement prep = null;
//		String editRoom = "Update holiday set detail = ? where date = ? and month = ? and year = ?";
//		try {
//			conn = ConnectDB.getInstance().DBConnection();;
//			prep = conn.prepareStatement(editRoom);
//
//			prep.setString(1, holiday.getDetail());
//			prep.setInt(2, holiday.getDate());
//			prep.setInt(3, holiday.getMonth());
//			prep.setInt(4, holiday.getYear());
//			prep.executeUpdate();
//			chk = true;
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			chk = false;
//		} finally {
//			if (prep != null) {
//				prep.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return chk;
//	}
	
}
