package com.project.register_teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.bean.TeacherBean;
import com.project.utility.ConnectDB;

public class RegisterTeacherManager {

	public int findMajorID(String majorName) throws SQLException {
		int MajorID = 0;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select major_ID from major where majorName = ?";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, majorName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				MajorID = Integer.parseInt(rs.getString("major_ID"));
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
		return MajorID;
	}

	public boolean addTeacher(TeacherBean teacher, int MajorID) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String addSQL = "insert into teacher (idCard,antecedent,firstName,lastName,vacancy,email,phone,major_ID,path_image) values (?,?,?,?,?,?,?,?,?)";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(addSQL);
			preparedStatement.setString(1, teacher.getIdCard());
			preparedStatement.setString(2, teacher.getAntecedent());
			preparedStatement.setString(3, teacher.getFirstName());
			preparedStatement.setString(4, teacher.getLastName());
			preparedStatement.setString(5, teacher.getVacancy());
			preparedStatement.setString(6, teacher.getEmail());
			preparedStatement.setString(7, teacher.getPhone());
			preparedStatement.setInt(8, MajorID);
			preparedStatement.setString(9, teacher.getPath_image());
			preparedStatement.executeUpdate();
			this.addLogin(teacher.getLogin().getUsername(), teacher.getLogin().getPassword(), "Teacher", teacher.getIdCard());
			this.addEducation(teacher.getEducation().getEducationalInstitution(), teacher.getEducation().getEducationalBackground(), teacher
					.getEducation().getEducationalMajor(), teacher.getIdCard());
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

	public boolean addLogin(String username, String password, String status, String teacherID) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String addLogin = "insert into login (username,password,status,teacherID) values (?,?,?,?)";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(addLogin);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, status);
			preparedStatement.setString(4, teacherID);
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

	public boolean addEducation(String educationalInstitution, String educationalBackground, String educationalMajor, String teacherID)
			throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String addEducation = "insert into education (educationalInstitution,educationalBackground,educationalMajor,teacherID) values (?,?,?,?)";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(addEducation);
			preparedStatement.setString(1, educationalInstitution);
			preparedStatement.setString(2, educationalBackground);
			preparedStatement.setString(3, educationalMajor);
			preparedStatement.setString(4, teacherID);
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

	public boolean addTeacherNoImages(TeacherBean teacher, int MajorID) throws SQLException {
		boolean chk = true;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String addSQL = "insert into teacher (idCard,antecedent,firstName,lastName,vacancy,email,phone,major_ID) VALUES (?,?,?,?,?,?,?,?)";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(addSQL);
			preparedStatement.setString(1, teacher.getIdCard());
			preparedStatement.setString(2, teacher.getAntecedent());
			preparedStatement.setString(3, teacher.getFirstName());
			preparedStatement.setString(4, teacher.getLastName());
			preparedStatement.setString(5, teacher.getVacancy());
			preparedStatement.setString(6, teacher.getEmail());
			preparedStatement.setString(7, teacher.getPhone());
			preparedStatement.setInt(8, MajorID);
			preparedStatement.executeUpdate();
			addLogin(teacher.getLogin().getUsername(), teacher.getLogin().getPassword(), "Teacher", teacher.getIdCard());
			addEducation(teacher.getEducation().getEducationalInstitution(), teacher.getEducation().getEducationalBackground(), teacher
					.getEducation().getEducationalMajor(), teacher.getIdCard());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			chk = false;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return chk;
	}

	public boolean findIdCardTeacher(String idCard) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select idCard from teacher where idCard = ?";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, idCard);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return false;
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
		return true;
	}
}
