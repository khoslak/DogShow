package ca.sheridancollege.controller;
import ca.sheridancollege.bean.*;
import java.util.*;
import ca.sheridancollege.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchDogs
 */
@WebServlet("/SearchDogs")
public class SearchDogs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search=request.getParameter("search");
		String value=request.getParameter("value");
		
		if(search.equals("Entry_Number"))
		{
			int no=Integer.parseInt(value);
			DAO dao=new DAO();
			ArrayList<Dog> ald=dao.searchByEntry_Number(no);
			request.setAttribute("dogList",ald);
			request.getRequestDispatcher("/dogs/view").forward(request, response);
		}
		if(search.equals("Dog_Name"))
		{
			DAO dao=new DAO();
			ArrayList<Dog> ald=dao.searchByDog_Name(value);
			request.setAttribute("dogList",ald);
			request.getRequestDispatcher("/dogs/view").forward(request, response);
			
		}
		if(search.equals("Dog_Owner"))
		{
			DAO dao=new DAO();
			ArrayList<Dog> ald=dao.searchByDog_Owner(value);
			request.setAttribute("dogList",ald);
			request.getRequestDispatcher("/dogs/view").forward(request, response);
		}
		
		if(search.equals("Dog_Breed"))
		{
			DAO dao=new DAO();
			ArrayList<Dog> ald=dao.searchByDog_Breed(value);
			request.setAttribute("dogList",ald);
			request.getRequestDispatcher("/dogs/view").forward(request, response);
		}
		
		if(search.equals("Dog_Group"))
		{
			DAO dao=new DAO();
			ArrayList<Dog> ald=dao.searchByDog_Group(value);
			request.setAttribute("dogList",ald);
			request.getRequestDispatcher("/dogs/view").forward(request, response);
		}
		
	}

}
