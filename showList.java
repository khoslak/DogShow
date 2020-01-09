package ca.sheridancollege.controller;
import ca.sheridancollege.bean.*;
import ca.sheridancollege.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class showList
 */
@WebServlet("/showList")
public class showList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String entDog_group=request.getParameter("groupList");
		DAO dao=new DAO();
		ArrayList<DogList> aldsp=dao.showListBy(entDog_group);
		request.setAttribute("DoggyList", aldsp);
		request.getRequestDispatcher("ShowListByDog.jsp").forward(request,response);
	}

}
