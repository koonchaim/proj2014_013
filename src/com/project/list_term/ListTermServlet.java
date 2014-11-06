package com.project.list_term;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.TermBean;

/**
 * Servlet implementation class ListTermServlet
 */
@WebServlet("/ListTermServlet")
public class ListTermServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListTermServlet() {
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
		ListTermManager termMng = new ListTermManager();

		try {
			String termName = request.getParameter("termName");
			if (termName != null) {
				boolean removeTerm = termMng.removeTerm(termName);
				if (removeTerm) {
					System.out.println("Remove Term Success");
					List<TermBean> listTerm = termMng.findAllTerm();

					List<String> listTermName = new ArrayList<String>();
					for (int i = 0; i < listTerm.size(); i++) {
						String result = listTerm.get(i).getTermName();
						String[] parts = result.split("/");
						String term = parts[0] + "/" + (Integer.parseInt(parts[1]) + 543);
						listTermName.add(term);
					}

					request.setAttribute("listTerm", listTerm);
					request.setAttribute("listTermName", listTermName);
					request.getRequestDispatcher("ListTerm.jsp").forward(request, response);
					
				}
				
			}else{
			List<TermBean> listTerm = termMng.findAllTerm();

			List<String> listTermName = new ArrayList<String>();
			for (int i = 0; i < listTerm.size(); i++) {
				String result = listTerm.get(i).getTermName();
				String[] parts = result.split("/");
				String term = parts[0] + "/" + (Integer.parseInt(parts[1]) + 543);
				listTermName.add(term);
			}

			request.setAttribute("listTerm", listTerm);
			request.setAttribute("listTermName", listTermName);
			request.getRequestDispatcher("ListTerm.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
