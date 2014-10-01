package com.project.print_letter_of_parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.StudentBean;
import com.project.utility.ConnectDB;

public class PrintLetterOfParentManager {
	public List<StudentBean> findAllStudent(String majorName, String educationalBackground, int educationLevel, String term, int countAttendance)
			throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT DISTINCT student.studentID, student.antecedent,student.firstName"
				+ " ,student.lastName,major.majorName,schedule.term,educationlevel.educationalBackground,educationlevel.educationLevel"
				+ " FROM major" + " JOIN educationlevel ON educationlevel.Major_ID = major.Major_ID"
				+ " JOIN student ON student.EducationLevel_ID = educationlevel.EducationLevel_ID"
				+ " JOIN attendance ON attendance.studentID = student.studentID JOIN schedule ON schedule.Schedule_ID = attendance.Schedule_ID"
				+ " WHERE educationlevel.educationalBackground = ? AND educationlevel.educationLevel = ? AND schedule.term = ?"
				+ " AND major.majorName = ? AND attendance.statusActivity = 'ขาด' GROUP BY student.studentID"
				+ " HAVING COUNT(attendance.statusActivity) > ?";

		List<StudentBean> listStudent = new ArrayList<StudentBean>();
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, educationalBackground);
			preparedStatement.setInt(2, educationLevel);
			preparedStatement.setString(3, term);
			preparedStatement.setString(4, majorName);
			preparedStatement.setInt(5, countAttendance);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				StudentBean student = new StudentBean();
				student.setStudentID(rs.getString("studentID"));
				student.setAntecedent(rs.getString("antecedent"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				listStudent.add(student);
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
		return listStudent;
	}

}
