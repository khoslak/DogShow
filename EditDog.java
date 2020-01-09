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
 * Servlet implementation class EditDog
 */
@WebServlet("/EditDog")
public class EditDog extends HttpServlet {
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
				  if((Integer)session.getAttribute("specialedit")==null)
					 {
							int number=Integer.parseInt(request.getParameter("editNumber"));
							System.out.println(number);
							session.setAttribute("specialedit",number);
							request.getRequestDispatcher("editor.jsp").forward(request,response);
					}
				  else
					{
						String dog_name=request.getParameter("name");
						String owner_name=request.getParameter("ownerName");
						String dog_breed=request.getParameter("breed");
						String dog_group=request.getParameter("group");
						String dog_gender=request.getParameter("gender");
						String dog_type=request.getParameter("type");
						Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
						int number=(int)session.getAttribute("specialedit");
						System.out.println("inside the else block "+number);
					
					dao.updateDogHandler(number, d);
						session.removeAttribute("specialedit");
						request.getRequestDispatcher("GetDogs").forward(request, response);
					}
			}
			else {		
	     if((Integer)session.getAttribute("specialedit")==null)
		 {
				int number=Integer.parseInt(request.getParameter("editNumber"));
				System.out.println(number);
				session.setAttribute("specialedit",number);
				request.getRequestDispatcher("editor.jsp").forward(request,response);
		}
			else
			{
				String dog_name=request.getParameter("name");
				String owner_name=request.getParameter("ownerName");
				String dog_breed=request.getParameter("breed");
				String dog_group=request.getParameter("group");
				String dog_gender=request.getParameter("gender");
				String dog_type=request.getParameter("type");
				Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
				int number=(int)session.getAttribute("specialedit");
				System.out.println("inside the else block "+number);
			
			dao.updateDog(number, d);
				session.removeAttribute("specialedit");
				request.getRequestDispatcher("GetDogs").forward(request, response);
		
			}
		
			}
		
	}



}
