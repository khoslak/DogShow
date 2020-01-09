package ca.sheridancollege.dao;

import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.sql.*;

import ca.sheridancollege.bean.*;
public class DAO {
	
	private final  String url="jdbc:mysql://localhost/xdogshow";
	private  final   String userName="root";
	private  final   String password="";
	
	
	public void sendEmail(String email,Dog d,int rowNumber)
	{
		String sub="Confirmation Email";
		String msg="This message has been sent to you to confirm that your dog has been successfully registerd \n"+"Entry Number"+rowNumber+" "+d.toString();
		String from="shawnmic72@gmail.com";
		String to=email;
		String password="Incorrect72";;
		
		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
	
           
	}
	public  void addDog(Dog d,String email)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection(url,userName,password);
		Statement stm=con.createStatement();
		String queryz="SELECT * FROM XDOG ORDER BY EntryNumber";
		ResultSet rs=stm.executeQuery(queryz);
		rs.last();
		int rowNumber=0;
		if(rs.getRow()!=0)
		{
			rowNumber=rs.getInt(1)+1;
		}

		System.out.println(rowNumber);
		String query1="INSERT INTO XDOG VALUES ( "+rowNumber+" ,'"+d.getDog_name()+ "', '"+d.getOwner_name()+"','"+d.getDog_breed()+"','"+d.getDog_group()+"','"+d.getDog_gender()+"','"+d.getDog_type()+"')";
		stm.executeUpdate(query1);
		sendEmail(email,d,rowNumber);
		if(rs!=null)
		{
			rs.close();
		}
		if(stm!=null)
		{
			stm.close();
		}
		if(con!=null)
		{
			con.close();
		}
		
		System.out.println("Connection Established");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("SORRY DRIVER CLASS NOT FOUND !");
		}
		catch(SQLException e)
		{
			System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
	}
	
	public  void addDog(Dog d)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection(url,userName,password);
		Statement stm=con.createStatement();
		String queryz="SELECT * FROM XDOG ORDER BY EntryNumber";
		ResultSet rs=stm.executeQuery(queryz);
		rs.last();
		int rowNumber=0;
		if(rs.getRow()!=0)
		{
			rowNumber=rs.getInt(1)+1;
		}

		System.out.println(rowNumber);
		String query1="INSERT INTO XDOG VALUES ( "+rowNumber+" ,'"+d.getDog_name()+ "', '"+d.getOwner_name()+"','"+d.getDog_breed()+"','"+d.getDog_group()+"','"+d.getDog_gender()+"','"+d.getDog_type()+"')";
		stm.executeUpdate(query1);

		if(rs!=null)
		{
			rs.close();
		}
		if(stm!=null)
		{
			stm.close();
		}
		if(con!=null)
		{
			con.close();
		}
		
		System.out.println("Connection Established");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("SORRY DRIVER CLASS NOT FOUND !");
		}
		catch(SQLException e)
		{
			System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
	}
	
public ArrayList<Dog> getDog()
{
	ArrayList<Dog> ad=new ArrayList<Dog>();
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	String queryz="SELECT * FROM XDOG ORDER BY EntryNumber";
	ResultSet rs=stm.executeQuery(queryz);
	while(rs.next())
	{
		int entry_number=rs.getInt(1);
		String dog_name=rs.getString(2);
		String owner_name=rs.getString(3);
		String dog_breed=rs.getString(4);
		String dog_group=rs.getString(5);
		String dog_gender=rs.getString(6);
		String dog_type=rs.getString(7);
		Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
		d.setEntry_number(entry_number);
		ad.add(d);
		
	}
  
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
	return ad;
	
}

public ArrayList<Dog> searchByEntry_Number(int num)
{
	ArrayList<Dog> ad=new ArrayList<Dog>();
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	String queryz="SELECT * FROM XDOG WHERE  EntryNumber="+num+"";
	ResultSet rs=stm.executeQuery(queryz);
	while(rs.next())
	{
		int entry_number=rs.getInt(1);
		String dog_name=rs.getString(2);
		String owner_name=rs.getString(3);
		String dog_breed=rs.getString(4);
		String dog_group=rs.getString(5);
		String dog_gender=rs.getString(6);
		String dog_type=rs.getString(7);
		Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
		d.setEntry_number(entry_number);
		ad.add(d);
		
	}
  
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
	return ad;
	
	
}

public ArrayList<Dog> searchByDog_Name(String name)
{
	ArrayList<Dog> ad=new ArrayList<Dog>();
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	
	String queryz="SELECT * FROM XDOG WHERE  dog_name='"+name+"'";
	
	ResultSet rs=stm.executeQuery(queryz);
	while(rs.next())
	{
		int entry_number=rs.getInt(1);
		String dog_name=rs.getString(2);
		String owner_name=rs.getString(3);
		String dog_breed=rs.getString(4);
		String dog_group=rs.getString(5);
		String dog_gender=rs.getString(6);
		String dog_type=rs.getString(7);
		Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
		d.setEntry_number(entry_number);
		ad.add(d);
		
	}
  
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
	return ad;
	
}

public ArrayList<Dog> searchByDog_Owner(String owner)
{
	ArrayList<Dog> ad=new ArrayList<Dog>();
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	String queryz="SELECT * FROM XDOG WHERE  owner_name='"+owner+"'";
	ResultSet rs=stm.executeQuery(queryz);
	while(rs.next())
	{
		int entry_number=rs.getInt(1);
		String dog_name=rs.getString(2);
		String owner_name=rs.getString(3);
		String dog_breed=rs.getString(4);
		String dog_group=rs.getString(5);
		String dog_gender=rs.getString(6);
		String dog_type=rs.getString(7);
		Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
		d.setEntry_number(entry_number);
		ad.add(d);
		
	}
  
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
	return ad;
	
}


public ArrayList<Dog> searchByDog_Breed(String breed)
{
	ArrayList<Dog> ad=new ArrayList<Dog>();

	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	String queryz="SELECT * FROM XDOG WHERE  dog_breed='"+breed+"'";
	ResultSet rs=stm.executeQuery(queryz);
	while(rs.next())
	{
		int entry_number=rs.getInt(1);
		String dog_name=rs.getString(2);
		String owner_name=rs.getString(3);
		String dog_breed=rs.getString(4);
		String dog_group=rs.getString(5);
		String dog_gender=rs.getString(6);
		String dog_type=rs.getString(7);
		Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
		d.setEntry_number(entry_number);
		ad.add(d);
		
	}
  
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
	return ad;
	
}

public ArrayList<Dog> searchByDog_Group(String group)
{
	ArrayList<Dog> ad=new ArrayList<Dog>();
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	String queryz="SELECT * FROM XDOG WHERE  dog_group='"+group+"'";
	ResultSet rs=stm.executeQuery(queryz);
	while(rs.next())
	{
		int entry_number=rs.getInt(1);
		String dog_name=rs.getString(2);
		String owner_name=rs.getString(3);
		String dog_breed=rs.getString(4);
		String dog_group=rs.getString(5);
		String dog_gender=rs.getString(6);
		String dog_type=rs.getString(7);
		Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
		d.setEntry_number(entry_number);
		ad.add(d);
		
	}
  
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
	return ad;
	
}

public ArrayList<DogList> showListBy(String dog_group)
{
	ArrayList<DogList> alds=new ArrayList<DogList>();
	ArrayList<String> breedNames=new ArrayList<String>();
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	
	String queryz="SELECT dog_breed,count(*) FROM XDOG WHERE dog_group='"+dog_group+"' GROUP BY dog_breed";
	
	ResultSet rs=stm.executeQuery(queryz);
	while(rs.next())
	{
		String dog_breed=rs.getString(1);
		int no=rs.getInt(2);
		breedNames.add(dog_breed);
		DogList d=new DogList(dog_breed,no);;
		alds.add(d);
		
	}

	int mc=0;
	int ms=0;
	int fc=0;
	int fs=0;
	for(int i=0;i<breedNames.size();i++)
	{
		String query1="SELECT count(*)  FROM XDOG WHERE (dog_breed='"+breedNames.get(i).toString()+"' AND dog_group='"+dog_group+"') AND (dog_gender='Male' AND dog_type='Class')";
		System.out.println(breedNames.get(i).toString());
		ResultSet rs1=stm.executeQuery(query1);
		while(rs1.next())
		{
			mc=rs1.getInt(1);
		}
		query1="SELECT count(*)  FROM XDOG WHERE (dog_breed='"+breedNames.get(i).toString()+"' AND dog_group='"+dog_group+"' )AND (dog_gender='Male' AND dog_type='Speciality')";
		ResultSet rs2=stm.executeQuery(query1);
		while(rs2.next())
		{
			ms=rs2.getInt(1);
		}
		query1="SELECT count(*)  FROM XDOG WHERE (dog_breed='"+breedNames.get(i).toString()+"' AND dog_group='"+dog_group+"') AND (dog_gender='Female' AND dog_type='Speciality')";
		ResultSet rs3=stm.executeQuery(query1);
		while(rs3.next())
		{
			fs=rs3.getInt(1);
		}
		query1="SELECT count(*)  FROM XDOG WHERE (dog_breed='"+breedNames.get(i).toString()+"' AND dog_group='"+dog_group+"') AND (dog_gender='Female' AND dog_type='Class')";
		ResultSet rs4=stm.executeQuery(query1);
		while(rs4.next())
		{
			fc=rs4.getInt(1);
		}
		System.out.println("MALE CLASS:"+mc+"FEMALE CLASS "+fc+"Male Special"+ms+"Female Special"+fs);
		alds.get(i).setMaleClass(mc);
		alds.get(i).setFemaleClass(fc);
		alds.get(i).setMaleSpecial(ms);
		alds.get(i).setFemaleSpecial(fs);
		
		System.out.println(alds.get(i).toString());
	}
	
 
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
 return alds;
	
}

public void deleteDog(int entry_number)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	String queryz="SELECT * FROM XDOG";
	ResultSet rs=stm.executeQuery(queryz);
	rs.last();
	int rowNumber=(rs.getRow() +1);
	System.out.println(rowNumber);
	String query1="DELETE FROM XDOG WHERE EntryNumber="+entry_number+"";
	stm.executeUpdate(query1);
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
}

public void updateDog(int entry_number,Dog d)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	
	String querty="UPDATE xdog SET dog_name='"+d.getDog_name()+"',owner_name='"+d.getOwner_name()+"',dog_breed='"+d.getDog_breed()+"',dog_group='"+d.getDog_group()+"',dog_gender='"+d.getDog_gender()+"',dog_type='"+d.getDog_type()+"' WHERE EntryNumber="+entry_number+"";
	
		Statement st=con.createStatement();
	st.executeUpdate(querty);

	
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
}

public  void addDogHandler(Dog d)
{
	System.out.println("Reached ADD DOG HANDLER METHOD");
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	Statement stm1=con.createStatement();
	Statement stm2=con.createStatement();
	String querys="SELECT * FROM xdoghandler ORDER BY EntryNumber";
	int rowNumber=0;
	ResultSet rs1=stm1.executeQuery(querys);
	rs1.last();
	if(rs1.getRow()==0)
	{
	String queryz="SELECT * FROM XDOG ORDER BY EntryNumber";
	ResultSet rs=stm.executeQuery(queryz);
	
	rs.last();

	if(rs.getRow()!=0)
	{
		rowNumber=rs.getInt(1)+1;
	}
}
	else
	{
		rowNumber=rs1.getInt(1)+1;
	}

	System.out.println(rowNumber);
	String query1="INSERT INTO xdoghandler VALUES ( "+rowNumber+" ,'"+d.getDog_name()+ "', '"+d.getOwner_name()+"','"+d.getDog_breed()+"','"+d.getDog_group()+"','"+d.getDog_gender()+"','"+d.getDog_type()+"')";
	stm2.executeUpdate(query1);


	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
}

public ArrayList<Dog> getDogHandler()
{
	ArrayList<Dog> ad=new ArrayList<Dog>();
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();
	String queryz="SELECT * FROM xdoghandler ORDER BY EntryNumber";
	ResultSet rs=stm.executeQuery(queryz);
	while(rs.next())
	{
		int entry_number=rs.getInt(1);
		String dog_name=rs.getString(2);
		String owner_name=rs.getString(3);
		String dog_breed=rs.getString(4);
		String dog_group=rs.getString(5);
		String dog_gender=rs.getString(6);
		String dog_type=rs.getString(7);
		Dog d=new Dog(dog_name,owner_name,dog_breed,dog_group,dog_gender,dog_type);
		d.setEntry_number(entry_number);
		ad.add(d);
	
	}
	System.out.println("Reached dog handler get method");
  
	if(rs!=null)
	{
		rs.close();
	}
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
	return ad;
	
}
public void deleteDogHandler(int entry_number)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	Statement stm=con.createStatement();

	String query1="DELETE FROM xdoghandler WHERE EntryNumber="+entry_number+"";
	stm.executeUpdate(query1);
	
	if(stm!=null)
	{
		stm.close();
	}
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
}

public void updateDogHandler(int entry_number,Dog d)
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=null;
	con=DriverManager.getConnection(url,userName,password);
	
	String querty="UPDATE xdoghandler SET dog_name='"+d.getDog_name()+"',owner_name='"+d.getOwner_name()+"',dog_breed='"+d.getDog_breed()+"',dog_group='"+d.getDog_group()+"',dog_gender='"+d.getDog_gender()+"',dog_type='"+d.getDog_type()+"' WHERE EntryNumber="+entry_number+"";
	
		Statement st=con.createStatement();
	st.executeUpdate(querty);

	System.out.println("Updated Dog Handler");
	if(con!=null)
	{
		con.close();
	}
	
	System.out.println("Connection Established");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("SORRY DRIVER CLASS NOT FOUND !");
	}
	catch(SQLException e)
	{
		System.out.println("SORRY CONNECTION CANNOT BE ESTABLISHED");
	}
	catch(Exception e)
	{
		System.out.println("Something went wrong");
	}
}

	

}
