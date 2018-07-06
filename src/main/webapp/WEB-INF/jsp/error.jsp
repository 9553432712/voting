<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ErrorPage</title>
		<link href="./images/Errora.png" rel="icon" type="png" size="16x16">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body{
	background:linear-gradient(to left,grey,white);
	background-size:1500px;
	background-repeat:no;
}
h1,h4{
font-style: italic;
text-align:center;
color:red;
 font-family: "Times New Roman",Times,serif;
}
</style>
</head>
<%

%>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
				<a href="<%=request.getContextPath()%>"><img src="./images/quality1.jpg" width="100" height="100" class="img-responsive"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li id="ab"><a href="<%=request.getContextPath() %>/vote"><i class="fa fa-unlock-alt" style="color: #fff;"></i><font color="#fff">Vote</font></a></li>
					<li id="cd"><a href="./register"><i class="fa fa-user" style="color: #fff;"></i><font color="#fff">Registration</font></a></li>
					<li id="cd"><a href="./admin/login"><i class="fa fa-user" style="color: #fff;"></i><font color="#fff">Admin</font></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h1>Sorry please try again after some time!!!</h1>
	<h4>Below is the error message</h4>
	
	<div style="color:red;font-style:italic;text-align:center; font-family: "Times New Roman",Times,serif;">
		<%=request.getAttribute("errorMSG") %>
	</div>
	
</body>
</html> 