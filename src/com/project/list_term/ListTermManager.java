package com.project.list_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.TermBean;
import com.project.utility.ConnectDB;

public class ListTermManager {
	public List<TermBean> findAllTerm() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select * from term order by startDate";
		List<TermBean> listTerm = new ArrayList<TermBean>();
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				TermBean termBean = new TermBean();
				termBean.setTermName(rs.getString("termName"));
				termBean.setStartDate(rs.getDate("startDate"));
				termBean.setEndDate(rs.getDate("endDate"));
				listTerm.add(termBean);
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
		return listTerm;
	}
	
	public boolean removeTerm(String termName) throws SQLException {
		Connection conn = null;
		PreparedStatement prep = null;
		String removeTerm = "delete from term where termName = ?";
		try {
			conn = ConnectDB.getInstance().DBConnection();
			prep = conn.prepareStatement(removeTerm);
			prep.setString(1, termName);
			prep.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (prep != null) {
				prep.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return false;
	}

}
