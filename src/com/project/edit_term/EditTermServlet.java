package com.project.edit_term;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.add_term.AddTermManager;
import com.project.bean.TermBean;
import com.project.editholiday.EditHolidayManager;

/**
 * Servlet implementation class EditTermServlet
 */
@WebServlet("/EditTermServlet")
public class EditTermServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTermServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String termName = request.getParameter("termName");
		try {
		TermBean term = new EditTermManager().findTermByTermName(termName);
		
		String json = new Gson().toJson(term);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		TermBean termBean = new TermBean();
//		EditTermManager editTermMng = new EditTermManager();
//		try {
//			String term = request.getParameter("editTermName");
//			String date1 = request.getParameter("StartDate2");
//			String date2 = request.getParameter("EndDate2");
//			String year = request.getParameter("editYear");			
//			String termName = term+"/"+year;
//			Calendar startDay = Calendar.getInstance(Locale.ENGLISH);
//			Calendar endDay = Calendar.getInstance(Locale.ENGLISH);
//			String[] startDate = date1.split("/");
//			String[] endDate = date2.split("/");
//			startDay.set(Integer.parseInt(startDate[2]), Integer.parseInt(startDate[1]) - 1, Integer.parseInt(startDate[0]));
//			endDay.set(Integer.parseInt(endDate[2]), Integer.parseInt(endDate[1]) - 1, Integer.parseInt(endDate[0]));			
//			termBean.setStartDate(startDay.getTime());
//			termBean.setEndDate(endDay.getTime());
//			termBean.setTermName(termName);
//			
//			boolean addTerm = editTermMng.editTerm(termBean);
//			if (addTerm) {
//				System.out.println("Edit Term Success");
//				response.sendRedirect("ListTermServlet");
//			}else{
//				System.out.println("Edit Term Fail");
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
