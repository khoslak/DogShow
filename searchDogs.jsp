<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Dog</title>
<link rel="stylesheet" type="text/css" href="css/searchDogs.css"/>
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
<h1>Search Dogs</h1>

<form action="SearchDogs" method="get">
SEARCH BY:<select name="search">
					<option value="Entry_Number">Entry_Number</option>
					<option value="Dog_Name">Dog_Name</option>
					<option value="Dog_Owner">Dog_Owner</option>
					<option value="Dog_Breed">Dog_Breed</option>
					<option value="Dog_Group">Dog_Group</option>
					</select><br><br>
Enter The String :<input type="text" name="value"/>
<input type="submit" value="GO" class="specialButton"/>
</form>
<div id="div2">
<form action="register.jsp">
<input type="submit" value="ADD DOGS" class="specialButton"/>
</form>
</div>
</body>
</html>