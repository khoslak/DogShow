<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ca.sheridancollege.bean.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/showList.css" rel="stylesheet" type="text/css"/>
<title>Dog List</title>
<style type="text/css">
/* Safari 4.0 - 8.0 */
@-webkit-keyframes example {
  0%   {color: red;}
  25%  {color: yellow;}
  50%  {color: #FFDEAD;}
  100% {color: 	#DA70D6;}
}

/* Standard syntax */
@keyframes example {
  0%   {color: red;}
  25%  {color: yellow;}
  50%  {color: #FFDEAD;}
  100% {color: 	#DA70D6;}
}
</style>
</head>
<body>
<div style="position:relative;top:-40px">
<jsp:include page="/headers"/>
</div>
<h1> LIST OF DOGS IN <%=request.getParameter("groupList")  %> Group</h1>
<% ArrayList<DogList> aldsp=(ArrayList<DogList>)request.getAttribute("DoggyList"); %>
<table >
<% for(int i=0;i<aldsp.size();i++)
{ %>
<tr>
 			<td><%=aldsp.get(i).getCount() %></td>
 			<td><%=aldsp.get(i).getDog_breeds() %></td>
 			<td><%=aldsp.get(i).getMaleClass() %></td>
 			<td><%=aldsp.get(i).getFemaleClass() %></td>
 			<td><%=aldsp.get(i).getMaleSpecial() %></td>
 			<td><%=aldsp.get(i).getFemaleSpecial() %></td>
 </tr>
 <%
 }
 %>
</table>
<form action="register.jsp">
<input type="submit" value="ADD DOG" class="specialButton"/>
</form>
</body>
</html>