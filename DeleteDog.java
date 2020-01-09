package ca.sheridancollege.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.sheridancollege.bean.Dog;
import ca.sheridancollege.dao.DAO;

/**
 * Servlet implementation class DeleteDog
 */
@WebServlet("/DeleteDog")
public class DeleteDog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<Dog> arlds=new ArrayList<Dog>();
		DAO dao=new DAO();
		if(request.isUserInRole("Admin"))
		{
			arlds=(ArrayList<Dog>)session.getAttribute("dogListHandler");
			int dogNumber=Integer.parseInt(request.getParameter("deleteNumber"));
			dao.deleteDogHandler(dogNumber);
			for(int i=0;i<arlds.size();i++)
			{
				if(dogNumber==arlds.get(i).getEntry_number())
				{
					arlds.remove(i);
					break;
				}
			}
			session.setAttribute("dogListHandler",arlds);
			response.sendRedirect("/Assignment1/ViewDogH");
			
			//request.getRequestDispatcher("/dogs/view").forward(request, response);
		}
		else {
		arlds=(ArrayList<Dog>)session.getAttribute("dogList");
		int dogNumber=Integer.parseInt(request.getParameter("deleteNumber"));
		
		dao.deleteDog(dogNumber);
		for(int i=0;i<arlds.size();i++)
		{
			if(dogNumber==arlds.get(i).getEntry_number())
			{
				arlds.remove(i);
				break;
			}
		}
		session.setAttribute("dogList",arlds);
		request.getRequestDispatcher("/dogs/view").forward(request, response);
		}
	}


}
