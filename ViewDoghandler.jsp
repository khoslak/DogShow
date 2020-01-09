<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ca.sheridancollege.bean.Dog" %>
    <%@ page import="java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Dog</title>
<link rel="stylesheet" href="css/viewDogs.css" type="text/css"/>
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
<h1> Dogs Details</h1>
<div id="div2">
<form action="/Assignment1/doghandler">
<input type="submit" value="Add Dog" class="specialButton"/>
</form>

</div>

<div align="center">
<table border="1">
<tr>
                 <th>entry_number</th>
				<th> dog_name</th>
				<th> owner_namer</th>
				<th> dog_breed</th>
				<th> dog_group</th>
				<th>dog_gender</th>
				<th>dog_type</th>
				<th>Delete</th>
				<th>EDIT</th>
				
</tr>
<c:forEach var="dog" items="${dogListHandler }">
<tr>
					<td><c:out value="${dog.entry_number }"/></td>
					<td><c:out value="${dog.dog_name }"/></td>
					<td><c:out value="${dog.owner_name }"/></td>
					<td><c:out value="${dog.dog_breed }"/></td>
					<td><c:out value="${dog.dog_group}" /></td>
					<td><c:out value="${dog.dog_gender }" /></td>
					<td><c:out value="${dog.dog_type }" /></td>
					<td><form action="DeleteDog" method="get">
					       <input type="hidden" name="deleteNumber" value="${dog.entry_number}"/>
					       <input type="submit" value="Delete"/>
					
					</form>
					</td>
					<td><form action="EditDog" method="get">
							<input type="hidden" name="editNumber" value="${dog.entry_number }"/>
							<input type="submit" value="Edit"/>
					
					</form>
	</tr>				
</c:forEach>
</table>



</body>
</html>