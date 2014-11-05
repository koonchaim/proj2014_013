package com.project.register_teacher;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.project.bean.EducationBean;
import com.project.bean.LoginBean;
import com.project.bean.TeacherBean;

/**
 * Servlet implementation class RegisterTeacherServlet
 */
@WebServlet("/RegisterTeacherServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
// 50MB
public class RegisterTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Name of the directory where uploaded files will be saved, relative to the
	 * web application directory.
	 */
	private static final String SAVE_DIR = "images\\profile";

	/**
	 * handles file upload
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String appPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + SAVE_DIR;

		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		Part part = request.getPart("file");
		String fileName = extractFileName(part);

		RegisterTeacherManager regisMng = new RegisterTeacherManager();
		String idCardTeacher = request.getParameter("IdCardTeacher");
		String antecedentTeacher = request.getParameter("AntecedentTeacher");
		String firstNameTeacher = request.getParameter("FirstNameTeacher");
		String lastNameTeacher = request.getParameter("LastNameTeacher");
		String educationalBackgroundTeacher = request.getParameter("EducationalBackgroundTeacher");
		String educationalInstitutionTeacher = request.getParameter("EducationalInstitutionTeacher");
		String educationalMajorTeacher = request.getParameter("EducationalMajorTeacher");
		String emailTeacher = request.getParameter("EmailTeacher");
		String phoneTeacher = request.getParameter("PhoneTeacher");
		String vacancyTeacher = request.getParameter("VacancyTeacher");
		String departmentTeacher = request.getParameter("DepartmentTeacher");
		String usernameTeacher = request.getParameter("UsernameTeacher");
		String passwordTeacher = request.getParameter("PasswordTeacher");

		if (fileName.equals("")) {
			LoginBean login = new LoginBean(usernameTeacher, passwordTeacher);
			EducationBean education = new EducationBean(educationalInstitutionTeacher, educationalBackgroundTeacher, educationalMajorTeacher);
			TeacherBean teacherBean = new TeacherBean();
			teacherBean.setIdCard(idCardTeacher);
			teacherBean.setAntecedent(antecedentTeacher);
			teacherBean.setFirstName(firstNameTeacher);
			teacherBean.setLastName(lastNameTeacher);
			teacherBean.setPhone(phoneTeacher);
			teacherBean.setEmail(emailTeacher);
			teacherBean.setVacancy(vacancyTeacher);
			teacherBean.setPath_image(fileName);
			teacherBean.setEducation(education);
			teacherBean.setLogin(login);

			try {
				int major_ID = regisMng.findMajorID(departmentTeacher);
				if (major_ID != 0) {
					boolean chkIdcard = regisMng.findIdCardTeacher(teacherBean.getIdCard());
					// เช็ค รหัสประชาชนไม่มีในฐานข้อมูล
					if (chkIdcard) {
						boolean addteacher = regisMng.addTeacherNoImages(teacherBean, major_ID);
						if (addteacher) {
							System.out.println("Insert NoImages Success");
						} else {
							System.out.println("Insert NoImages Fail");
						}
						response.sendRedirect("ListTeacherServlet");
					} else {
						System.out.println("รหัสประจำตัวประชาชนซ้ำ");
						request.setAttribute("message", "รหัสประจำตัวประชาชนซ้ำ");
						response.sendRedirect("ListTeacherServlet");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			part.write(savePath + File.separator + fileName);

			LoginBean login = new LoginBean(usernameTeacher, passwordTeacher);
			EducationBean education = new EducationBean(educationalInstitutionTeacher, educationalBackgroundTeacher, educationalMajorTeacher);
			TeacherBean teacherBean = new TeacherBean();
			teacherBean.setIdCard(idCardTeacher);
			teacherBean.setAntecedent(antecedentTeacher);
			teacherBean.setFirstName(firstNameTeacher);
			teacherBean.setLastName(lastNameTeacher);
			teacherBean.setPhone(phoneTeacher);
			teacherBean.setEmail(emailTeacher);
			teacherBean.setVacancy(vacancyTeacher);
			teacherBean.setPath_image(fileName);
			teacherBean.setEducation(education);
			teacherBean.setLogin(login);

			try {
				int major_ID = regisMng.findMajorID(departmentTeacher);
				if (major_ID != 0) {
					boolean chkIdcard = regisMng.findIdCardTeacher(teacherBean.getIdCard());
					// เช็ค รหัสประชาชนไม่มีในฐานข้อมูล
					if (chkIdcard) {
						boolean addteacher = regisMng.addTeacher(teacherBean, major_ID);
						if (addteacher) {
							System.out.println("Insert Success");
						} else {
							System.out.println("Insert Fail");
						}
						response.sendRedirect("ListTeacherServlet");
					} else {
						System.out.println("รหัสประจำตัวประชาชนซ้ำ");
						request.setAttribute("message", "รหัสประจำตัวประชาชนซ้ำ");
						response.sendRedirect("ListTeacherServlet");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
