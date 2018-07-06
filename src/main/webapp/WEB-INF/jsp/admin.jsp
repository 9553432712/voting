<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Anonymous Voting System</title>
<style type="text/css">
	body{
		background:linear-gradient(to left,white,grey,white);
		text-align: center;
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
				<a href="/../"><img src="<%=request.getContextPath()%>/images/quality1.jpg" width="100" height="100" class="img-responsive"></a>
		
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav navbar-right">
						<li id="cd"><a href="/../"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Home</font></a></li>
					</ul>
				</div>
			</div>
		</nav>
	<h1>Admin Login</h1>
		<div class="container">
			<form class="form-horizontal" method="post" action="./getData" >
				<div class="row">
					<div class="form-group">
						<div class="cols-sm-2">
							<label for="mail" class="control-label">Email</label>
						</div>
						<div class="cols-sm-2">
							<input type="text" name="email" id="email" required/>
						</div>
							
							
						</div>
					</div>
					<div class="row">
					<div class="form-group">
						<div class="cols-sm-2">
							<label for="mail" class="cols-sm-2 control-label">Password</label>
						</div>
						<div class="cols-sm-2">
							<input type="password" name="password" id="password" required/>
						</div>
							
							
						</div>
					</div>
						<div class="form-group ">
							<button name="submit" type="submit">
								Submit
							</button>
						</div>
				</form>		
			</div>
	</body>
