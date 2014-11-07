package com.project.add_term;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.TermBean;

/**
 * Servlet implementation class AddTermServlet
 */
@WebServlet("/AddTermServlet")
public class AddTermServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTermServlet() {
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
		TermBean termBean = new TermBean();
		AddTermManager addTermMng = new AddTermManager();
		try {
			String term = request.getParameter("termName");
			String date1 = request.getParameter("StartDate1");
			String date2 = request.getParameter("EndDate1");
			String year = request.getParameter("year");
			String termName = term + "/" + year;
			Calendar startDay = Calendar.getInstance(Locale.ENGLISH);
			Calendar endDay = Calendar.getInstance(Locale.ENGLISH);
			String[] startDate = date1.split("/");
			String[] endDate = date2.split("/");
			startDay.set(Integer.parseInt(startDate[2]), Integer.parseInt(startDate[1]) - 1, Integer.parseInt(startDate[0]));
			endDay.set(Integer.parseInt(endDate[2]), Integer.parseInt(endDate[1]) - 1, Integer.parseInt(endDate[0]));
			termBean.setStartDate(startDay.getTime());
			termBean.setEndDate(endDay.getTime());
			termBean.setTermName(termName);

			boolean addTerm = addTermMng.addTerm(termBean);
			if (addTerm) {
				System.out.println("Add Term Success");
				response.sendRedirect("ListTermServlet");
			} else {
				System.out.println("Add Term Fail");
				response.sendRedirect("ListTermServlet");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
