package ca.sheridancollege.controller;
import ca.sheridancollege.dao.*;
import ca.sheridancollege.bean.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddDogs
 */
@WebServlet(urlPatterns= {"/AddDogs","/secure/AddDogs"})

public class AddDogs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao=new DAO();
		if(request.isUserInRole("Admin"))
		{
			String dog_name=request.getParameter("name");
			String owner_name=request.getParameter("ownerName");
			String dog_breed=request.getParameter("breed");
			String dog_group=request.getParameter("group");
			String dog_gender=request.getParameter("gender");
			String dog_type=request.getParameter("type");
			Dog dog=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
			dao.addDogHandler(dog);
			response.sendRedirect("/Assignment1/doghandler");
			
		}
		
		else {
		String dog_name=request.getParameter("name");
		String owner_name=request.getParameter("ownerName");
		String dog_breed=request.getParameter("breed");
		String dog_group=request.getParameter("group");
		String dog_gender=request.getParameter("gender");
		String dog_type=request.getParameter("type");
		String email=request.getParameter("email");
		
		Dog dog=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
		
	
		dao.addDog(dog,email);
		response.sendRedirect("register.jsp");
		}
	}

}
