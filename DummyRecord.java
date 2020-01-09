package ca.sheridancollege.controller;
import ca.sheridancollege.bean.*;
import ca.sheridancollege.dao.*;
import MyEnums.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyEnums.DogsName;

/**
 * Servlet implementation class DummyRecord
 */
@WebServlet("/DummyRecord")
public class DummyRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DogsName dn=DogsName.Finn;
		OwnersName on=OwnersName.Liam;
		Breeds bn=Breeds.Beagles;
		Groups gp=Groups.Herding;
		Gender gn=Gender.Male;
		Type ty=Type.Class;
		DAO dao=new DAO();
		for(int i=1;i<=100;i++)
		{
		String dog_name=dn.values()[(int)(Math.random()*34)].name();
		String owner_name=on.values()[(int)(Math.random()*34)].name();
		String dog_breed=bn.values()[(int)(Math.random()*10)].name();
		String dog_group=gp.values()[(int)(Math.random()*7)].name();
		String dog_gender=gn.values()[(int)(Math.random()*2)].name();
		String dog_type=ty.values()[(int)(Math.random()*2)].name();
		dao.addDog(new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type));
		}
		request.getRequestDispatcher("GetDogs").forward(request,response);
		
		
	}

	
}
