package com.project.print_list_student_for_activities;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

import com.project.bean.LoginBean;
import com.project.bean.MajorBean;
import com.project.utility.ConnectDB;
import com.project.utility.ServletUtils;
import com.project.view_all_attendance.ViewAllAttendanceManager;
import com.project.view_all_student.ViewAllStudentManager;

/**
 * Servlet implementation class PrintListStudentForActivities
 */
@WebServlet("/PrintListStudentForActivities")
public class PrintListStudentForActivities extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintListStudentForActivities() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ViewAllStudentManager viewAllStudentMng = new ViewAllStudentManager();
		ViewAllAttendanceManager viewAllAttendanceMng = new ViewAllAttendanceManager();
		LoginBean login = (LoginBean) request.getSession().getAttribute("login");

		String majorName = request.getParameter("majorStudent");

		try {
			MajorBean major = viewAllStudentMng.findAllMajor(login.getUsername());
			if (majorName == null) {
				List<MajorBean> listEducationLevel = viewAllStudentMng.findAllEducationLevelByMajorName(major.getMajorName());
				request.getSession().setAttribute("majorPrintStudent", major.getMajorName());

				System.out.println("Search " + listEducationLevel.get(0).getEducationLevel().getEducationalBackground() + " - "
						+ listEducationLevel.get(0).getEducationLevel().getEducationLevel());
				String selectEducation = listEducationLevel.get(0).getEducationLevel().getEducationalBackground();
				int selectEducation1 = listEducationLevel.get(0).getEducationLevel().getEducationLevel();

				// Term
				List<String> listTerm = viewAllAttendanceMng.findAllTerm(major.getMajorName(), selectEducation, selectEducation1);
				request.setAttribute("listTerm", listTerm);
				request.setAttribute("chkTerm", listTerm.get(listTerm.size() - 1).toString());

				request.setAttribute("listEducationLevel", listEducationLevel);
				request.setAttribute("selectEducation", selectEducation);
				request.setAttribute("selectEducation1", selectEducation1);
				request.getRequestDispatcher("PrintListStudent.jsp").forward(request, response);
			} else {
				// TODO Auto-generated method stub
				String selectMajorName11 = request.getParameter("selectLevelEdu");
				String[] result = selectMajorName11.split(" ");
				String selectEducation = result[0];
				String selectEducation1 = result[1];
				request.setAttribute("selectEducation", selectEducation);
				request.setAttribute("selectEducation1", selectEducation1);

				String eduBackgroung = selectEducation;
				int eduLevel = Integer.parseInt(selectEducation1);
				String term = request.getParameter("selectPrintTerm");
				int attendance = 15;

				ServletOutputStream servletOutputStream = response.getOutputStream();
				byte[] bytes = null;
				Map<String, Object> param = new HashMap<String, Object>();
				try {
					// โหลด Driver
					Class.forName("com.mysql.jdbc.Driver");
					// ระบุฐานข้อมูลที่ใช้ในการสร้างรายงาน
					Connection conn = ConnectDB.getInstance().DBConnection();
					// ทำการส่งค่าพารามิเตอร์ไปยัง iReport
					param.put("majorName", majorName);
					param.put("eduBackgroung", eduBackgroung);
					param.put("eduLevel", eduLevel);
					param.put("term", term);
					param.put("attendance", attendance);
					// กำหนด path ของไฟล์ i-report
					System.out.print(ServletUtils.getReportFile(getServletContext(), "failActivity.jasper"));
					bytes = JasperRunManager.runReportToPdf(ServletUtils.getReportFile(getServletContext(), "failActivity.jasper"), param, conn);

					// กำหนดชนิดของไฟล์ที่ใช้แสดงผล
					response.setContentType("application/pdf");
					response.setContentLength(bytes.length);
					servletOutputStream.write(bytes, 0, bytes.length);
					servletOutputStream.flush();
					servletOutputStream.close();
				} catch (Exception e) {
					StringWriter stringWriter = new StringWriter();
					PrintWriter printWriter = new PrintWriter(stringWriter);
					e.printStackTrace(printWriter);
					response.setContentType("text/plain");
					response.getOutputStream().print(stringWriter.toString());
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
