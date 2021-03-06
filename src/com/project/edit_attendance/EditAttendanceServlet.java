package com.project.edit_attendance;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.bean.AttendanceBean;
import com.project.bean.ScheduleBean;
import com.project.bean.StudentBean;

/**
 * Servlet implementation class EditAttendanceServlet
 */
@WebServlet("/EditAttendanceServlet")
public class EditAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAttendanceServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		EditAttendanceManager edtMng = new EditAttendanceManager();
		String[] studentID = request.getParameterValues("stuID[]");
		if (studentID == null) {
			String majorName = request.getParameter("majorName");
			String eduBackground = request.getParameter("eduBackground");
			String eduLevel = request.getParameter("eduLevel");
			int intEduLevel = Integer.parseInt(eduLevel);
			String term = request.getParameter("term");
			String dateAttendance = request.getParameter("dateAttendance");

			/*
			 * Show Date
			 */

			try {
				Date result = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(dateAttendance);
				System.out.println(result);
				List<ScheduleBean> listSchedule = edtMng.listStudentAndSchedule(majorName, eduBackground, intEduLevel, term, result);
				request.setAttribute("listSchedule", listSchedule);
				for (int i = 0; i < listSchedule.size(); i++) {
					System.out.println(listSchedule.get(i).getAttendance().getStudent().getStudentID() + "  -  "
							+ listSchedule.get(i).getAttendance().getStatusActivity());
				}
				String json1 = new Gson().toJson(listSchedule);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json1);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			int count = 1;
			String editDate = request.getParameter("EditDateShow");
			Date dateAttendance;
			try {
				dateAttendance = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(editDate);

				for (int i = 0; i < studentID.length; i++) {
					String status = request.getParameter("status_" + count);

					System.out.println("Attendance : " + studentID[i] + " - " + status);

					AttendanceBean attendanceBean = new AttendanceBean();
					attendanceBean.setStatusActivity(status);

					StudentBean studentBean = new StudentBean();
					studentBean.setStudentID(studentID[i]);
					attendanceBean.setStudent(studentBean);

					ScheduleBean scheduleBean = new ScheduleBean();
					scheduleBean.setDateAttendance(dateAttendance);
					scheduleBean.setAttendance(attendanceBean);

					boolean chkUpdateAttendance = edtMng.updateAttendance(scheduleBean);
					if (chkUpdateAttendance) {
						System.out.println("Update : " + studentID[i] + " - " + status + " Success");
					}
					count++;
				}
				response.sendRedirect("ViewAllAttendanceServlet");
			} catch (ParseException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
