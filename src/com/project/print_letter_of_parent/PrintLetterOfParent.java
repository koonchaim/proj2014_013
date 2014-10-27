package com.project.print_letter_of_parent;

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
import com.project.bean.StudentBean;
import com.project.bean.TermBean;
import com.project.print_list_student_for_activities.PrintListStudentForActivitiesManager;
import com.project.utility.ConnectDB;
import com.project.utility.ServletUtils;
import com.project.view_all_attendance.ViewAllAttendanceManager;
import com.project.view_all_student.ViewAllStudentManager;

/**
 * Servlet implementation class PrintLetterOfParent
 */
@WebServlet("/PrintLetterOfParent")
public class PrintLetterOfParent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintLetterOfParent() {
		super();
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
		PrintListStudentForActivitiesManager printMng = new PrintListStudentForActivitiesManager();
		PrintLetterOfParentManager printLetMng = new PrintLetterOfParentManager();
		LoginBean login = (LoginBean) request.getSession().getAttribute("login");

		String majorName = request.getParameter("majorStudent");
		String studentID = request.getParameter("studentID");
		try {
			MajorBean major = viewAllStudentMng.findAllMajor(login.getUsername());

			if (majorName == null && studentID == null) {
				List<MajorBean> listEducationLevel = viewAllStudentMng.findAllEducationLevelByMajorName(major.getMajorName());
				request.getSession().setAttribute("majorPrintStudent", major.getMajorName());

				String selectEducation = listEducationLevel.get(0).getEducationLevel().getEducationalBackground();
				int selectEducation1 = listEducationLevel.get(0).getEducationLevel().getEducationLevel();

				// Term
				List<String> listTerm = viewAllAttendanceMng.findAllTerm(major.getMajorName(), selectEducation, selectEducation1);
				request.setAttribute("listTerm", listTerm);
				request.setAttribute("chkTerm", listTerm.get(listTerm.size() - 1).toString());

				TermBean findTerm = printMng.findTermByTermName(listTerm.get(listTerm.size() - 1).toString());
				int countAttendance = printMng.calAttendance(findTerm);

				List<StudentBean> listStudent = printLetMng.findAllStudent(major.getMajorName(), selectEducation, selectEducation1,
						listTerm.get(listTerm.size() - 1).toString(), countAttendance);

				for (StudentBean studentBean : listStudent) {
					System.out.println(studentBean.getStudentID());
				}

				request.setAttribute("listEducationLevel", listEducationLevel);
				request.setAttribute("selectEducation", selectEducation);
				request.setAttribute("selectEducation1", selectEducation1);
				request.setAttribute("listStudent", listStudent);
				request.getRequestDispatcher("PrintLetterOfActivity.jsp").forward(request, response);
			} else if (majorName != null) {
				List<MajorBean> listEducationLevel = viewAllStudentMng.findAllEducationLevelByMajorName(majorName);
				request.setAttribute("listEducationLevel", listEducationLevel);

				request.setAttribute("selectMajorName", majorName);

				String selectMajorName11 = request.getParameter("selectLevelEdu");
				String[] result = selectMajorName11.split(" ");
				String selectEducation = result[0];
				String selectEducation1 = result[1];
				request.setAttribute("selectEducation", selectEducation);
				request.setAttribute("selectEducation1", selectEducation1);
				String term = request.getParameter("selectPrintTerm");
				request.setAttribute("term", term);

				List<String> listTerm = viewAllAttendanceMng.findAllTerm(majorName, selectEducation, Integer.parseInt(selectEducation1));
				request.setAttribute("listTerm", listTerm);
				request.setAttribute("chkTerm", listTerm.get(listTerm.size() - 1).toString());

				TermBean findTerm = printMng.findTermByTermName(term);
				int countAttendance = printMng.calAttendance(findTerm);
				List<StudentBean> listStudent = printLetMng.findAllStudent(majorName, selectEducation, Integer.parseInt(selectEducation1), term,
						countAttendance);

				for (StudentBean studentBean : listStudent) {
					System.out.println(studentBean.getStudentID());
				}
				request.setAttribute("listStudent", listStudent);

				request.getRequestDispatcher("PrintLetterOfActivity.jsp").forward(request, response);
			} else if (studentID != null) {
				String termName = request.getParameter("term");
				ServletOutputStream servletOutputStream = response.getOutputStream();
				byte[] bytes = null;
				Map<String, Object> param = new HashMap<String, Object>();
				try {
					// โหลด Driver
					Class.forName("com.mysql.jdbc.Driver");
					// ระบุฐานข้อมูลที่ใช้ในการสร้างรายงาน
					Connection conn = ConnectDB.getInstance().DBConnection();
					// ทำการส่งค่าพารามิเตอร์ไปยัง iReport
					param.put("studentID", studentID);
					param.put("termName", termName);
					// กำหนด path ของไฟล์ i-report
					System.out.print(ServletUtils.getReportFile(getServletContext(), "letterReport.jasper"));
					bytes = JasperRunManager.runReportToPdf(ServletUtils.getReportFile(getServletContext(), "letterReport.jasper"), param, conn);

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
