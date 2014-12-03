package com.project.edit_student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.AddressBean;
import com.project.bean.EducationLevelBean;
import com.project.bean.MajorBean;
import com.project.bean.ParentBean;
import com.project.bean.StudentBean;
import com.project.utility.ConnectDB;

public class EditStudentManager {

	public StudentBean findStudentByStudentID(String studentID) throws SQLException {
		StudentBean student = new StudentBean();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select * from student where student.studentID = ?";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, studentID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				student.setStudentID(rs.getString("studentID"));
				student.setAntecedent(rs.getString("antecedent"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				ParentBean parent = findParent(studentID);
				student.setParent(parent);
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
		return student;
	}

	public ParentBean findParent(String studentID) throws SQLException {
		ParentBean parent = new ParentBean();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select * from student join parent on student.studentID = parent.studentID where student.studentID = ?";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, studentID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				parent.setAntecedent(rs.getString("antecedent_parent"));
				parent.setFirstName(rs.getString("firstName_parent"));
				parent.setLastName(rs.getString("lastName_parent"));
				AddressBean address = findAddress(studentID);
				parent.setAddress(address);
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
		return parent;
	}

	public AddressBean findAddress(String studentID) throws SQLException {
		AddressBean address = new AddressBean();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select * from student join parent on student.studentID = parent.studentID"
				+ " join address on parent.Parent_ID = address.Parent_ID where student.studentID = ?";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, studentID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				address.setAddNo(rs.getString("addNo"));
				address.setMoo(rs.getString("moo"));
				address.setStreet(rs.getString("street"));
				address.setSubDistrict(rs.getString("subDistrict"));
				address.setDistrict(rs.getString("district"));
				address.setProvince(rs.getString("province"));
				address.setZipCode(rs.getString("zipCode"));
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
		return address;
	}

	public List<MajorBean> findAllEducationLevelByMajorName(String majorName) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * from educationlevel inner join major on educationlevel.major_ID = major.major_ID where major.majorName = ? ORDER BY educationalBackground,educationLevel";
		List<MajorBean> listEducationLevel = new ArrayList<MajorBean>();
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, majorName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				EducationLevelBean educationLevelBean = new EducationLevelBean();
				educationLevelBean.setEducationalBackground(rs.getString("educationalBackground"));
				educationLevelBean.setEducationLevel(Integer.parseInt(rs.getString("educationLevel")));

				MajorBean major = new MajorBean();
				major.setMajorName(rs.getString("majorName"));
				major.setEducationLevel(educationLevelBean);
				listEducationLevel.add(major);
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
		return listEducationLevel;
	}

	public List<MajorBean> findAllMajor() throws SQLException {
		List<MajorBean> listMajor = new ArrayList<MajorBean>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select majorName from major where major_ID != '15'";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				MajorBean majorBean = new MajorBean();
				majorBean.setMajorName(rs.getString("majorName"));
				listMajor.add(majorBean);
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
		return listMajor;
	}

	public boolean updateDataStudent(MajorBean major) throws SQLException {
		Connection con = null;
		PreparedStatement prep = null;
		String update_data = "UPDATE student SET antecedent = ? ,firstName = ?  ,lastName = ? ,EducationLevel_ID = ? WHERE studentID = ?";
		try {
			con = ConnectDB.getInstance().DBConnection();
			prep = con.prepareStatement(update_data);
			// student
			prep.setString(1, major.getEducationLevel().getStudent().getAntecedent());
			prep.setString(2, major.getEducationLevel().getStudent().getFirstName());
			prep.setString(3, major.getEducationLevel().getStudent().getLastName());

			int educationLevel_ID = findEducationLevel_ID(major);

			prep.setInt(4, educationLevel_ID);
			prep.setString(5, major.getEducationLevel().getStudent().getStudentID());
			prep.executeUpdate();
			this.updateDataParent(major);
			this.updateDataAddress(major);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (prep != null) {
				prep.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return false;
	}

	public boolean updateDataParent(MajorBean major) throws SQLException {
		Connection con = null;
		PreparedStatement prep = null;
		String update_data = "UPDATE parent SET antecedent_parent = ? ,firstName_parent = ? ,lastName_parent = ?  WHERE studentID = ?";
		try {
			con = ConnectDB.getInstance().DBConnection();
			prep = con.prepareStatement(update_data);
			// parent
			prep.setString(1, major.getEducationLevel().getStudent().getParent().getAntecedent());
			prep.setString(2, major.getEducationLevel().getStudent().getParent().getFirstName());
			prep.setString(3, major.getEducationLevel().getStudent().getParent().getLastName());
			prep.setString(4, major.getEducationLevel().getStudent().getStudentID());
			prep.executeUpdate();

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (prep != null) {
				prep.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return false;
	}

	public boolean updateDataAddress(MajorBean major) throws SQLException {
		Connection con = null;
		PreparedStatement prep = null;
		String update_data = "UPDATE address SET addNo = ?, moo = ?, street = ?, subDistrict = ?, district = ?, province = ?, zipCode = ? WHERE Parent_ID = ?";
		try {
			con = ConnectDB.getInstance().DBConnection();
			prep = con.prepareStatement(update_data);
			// address
			prep.setString(1, major.getEducationLevel().getStudent().getParent().getAddress().getAddNo());
			prep.setString(2, major.getEducationLevel().getStudent().getParent().getAddress().getMoo());
			prep.setString(3, major.getEducationLevel().getStudent().getParent().getAddress().getStreet());
			prep.setString(4, major.getEducationLevel().getStudent().getParent().getAddress().getSubDistrict());
			prep.setString(5, major.getEducationLevel().getStudent().getParent().getAddress().getDistrict());
			prep.setString(6, major.getEducationLevel().getStudent().getParent().getAddress().getProvince());
			prep.setString(7, major.getEducationLevel().getStudent().getParent().getAddress().getZipCode());

			int Parent_ID = findParent_ID(major.getEducationLevel().getStudent().getStudentID());

			prep.setInt(8, Parent_ID);
			prep.executeUpdate();

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (prep != null) {
				prep.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return false;
	}

	public int findEducationLevel_ID(MajorBean major) throws SQLException {
		int EducationLevel_ID = 0;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT educationlevel.EducationLevel_ID FROM educationlevel JOIN major ON major.Major_ID = educationlevel.Major_ID "
				+ " WHERE educationlevel.educationalBackground = ? AND educationlevel.educationLevel = ? AND major.majorName = ?";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, major.getEducationLevel().getEducationalBackground());
			preparedStatement.setInt(2, major.getEducationLevel().getEducationLevel());
			preparedStatement.setString(3, major.getMajorName());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				EducationLevel_ID = rs.getInt("EducationLevel_ID");
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
		return EducationLevel_ID;
	}

	public int findParent_ID(String studentID) throws SQLException {
		int Parent_ID = 0;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT parent.Parent_ID FROM parent WHERE studentID = ?";
		try {
			dbConnection = ConnectDB.getInstance().DBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, studentID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Parent_ID = rs.getInt("Parent_ID");
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
		return Parent_ID;
	}
}
