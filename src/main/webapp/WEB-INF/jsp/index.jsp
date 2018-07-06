<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>::Anonymous Voting System::</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- <link rel="stylesheet" href="/css/bootstrap.min.css"> 
        <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
        <script src="/js/jquery.min.js"></script>
        <script src="/js/bootstrap.min.js"></script> -->
        <style type="text/css">
		body{
			margin: 0;
			padding: 0;
			position: relative;
			background: url(./images/1g.jpeg);
			background-size: 1500px;
		}
		nav{
			width: 100%;
			height: 65px;
			position: relative;
			background: #0a4b33;
			box-shadow: 0px 2px 8px 0px #333;
		}
		.nav-container{
			width: 1000px;
			margin: 0 auto;
			position: relative;
		}
		.fa{
			margin-right: 5px;
		}
		#ab{
			font-family: sans-serif,Arial;
			font-size: 16px;
			font-weight: bold;
			letter-spacing: -0.05em;
			position: relative;
			line-height: 65px;
		}
		#cd{
			font-family: sans-serif,Arial;
			font-size: 16px;
			font-weight: bold;
			letter-spacing: -0.05em;
			position: relative;
			line-height: 65px;
		}
	</style>
</head>
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
<h2 align="center" style="margin-top: 20%;font-family: sans-serif,Arial;font-style: italic;"><font color="red">Anonymous Voting System</font></h2>
</body>
</html>