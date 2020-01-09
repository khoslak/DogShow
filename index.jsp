<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
body
{
 background-color: lightblue
}
h1
{
text-align:center;
font-size:40px;
text-shadow: 0 0 3px #FF0000, 0 0 5px #0000FF;

  -webkit-animation-name: example; /* Safari 4.0 - 8.0 */
  -webkit-animation-duration: 8s; /* Safari 4.0 - 8.0 */
  animation-name: example;
  animation-duration: 7s;
  animation-iteration-count:infinite;
}

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

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color:green;
}

.active {
  background-color:green;
}

</style>
</head>
<body>
<h1> RISING DOG STAR</h1>
<img style="position:relative;top:-90px;" src="images/main.png" alt="my dog show image">
<nav style="position:relative;top:-50px;">
<ul>
		<li><a href="register.jsp">Register Dog</a></li>
		<li><a href="searchDogs.jsp">Search Dog</a></li>
		<li><a href="GetDogs">View Dogs</a></li>
		<li><a href="doghandler">Register with Doghandler</a></li>
</ul>

</nav>
<div style="position:relative;top:-30px">
Rising Dog Star Dog Show
 is an all-breed conformation show that has been held in New York City annually since 1877. Currently, the breed and Junior Showmanship competitions are held at Piers 92 and 94, while the group and Best in Show competitions are held at Madison Square Garden. The number of entries is so large at nearly 3000 that two days are required for all dogs to be judged.
Rising Dog Star Dog Show is one of a handful of benched shows in the United States. Dogs are required to be on display in an assigned location (bench) during the entirety of the show except when being shown in the ring, groomed for showing, or taken outside to eliminate, so that spectators and breeders alike have an opportunity to see all the entered dogs. (In the more common unbenched shows, dogs are required to be present only at assigned ring times.)
</div>
</body>
</html>