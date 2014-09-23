package com.project.print_letter_of_parent;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

import com.project.utility.ConnectDB;
import com.project.utility.ServletUtils;

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

		String studentID = request.getParameter("studentID");
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

}
