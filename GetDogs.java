package ca.sheridancollege.controller;
import java.util.*;
import ca.sheridancollege.bean.*;
import ca.sheridancollege.dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetDogs
 */

@WebServlet(urlPatterns= {"/GetDogs","/secure/GetDogs"})
public class GetDogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO da=new DAO();
		HttpSession session=request.getSession();
		
		if(request.isUserInRole("Admin"))
		{
			ArrayList<Dog> ad=da.getDogHandler();
			session.setAttribute("dogListHandler",ad);
		response.sendRedirect("/Assignment1/ViewDogH");
			
		}
		else
		{
			ArrayList<Dog> ad=da.getDog();
		session.setAttribute("dogList",ad);
		request.getRequestDispatcher("/dogs/view").forward(request,response);
		}
		
		
	}



}
