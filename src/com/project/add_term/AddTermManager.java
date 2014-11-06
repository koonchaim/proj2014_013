package com.project.add_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.bean.TermBean;
import com.project.utility.ConnectDB;

public class AddTermManager {
	
	public boolean addTerm(TermBean term) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String addSQL = "insert into term (startDate,endDate,termName) values (?,?,?)";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(addSQL);
			java.sql.Date sqlStartDate = new java.sql.Date(term.getStartDate().getTime());
			java.sql.Date sqlEndDate = new java.sql.Date(term.getEndDate().getTime());
			preparedStatement.setDate(1, sqlStartDate);
			preparedStatement.setDate(2, sqlEndDate);
			
			preparedStatement.setString(3, term.getTermName());
			preparedStatement.executeUpdate();
			return true;
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
		return false;
	}
	
}
