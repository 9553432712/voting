<html>
<head>
<title>Ananymous Voting System</title>
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
h1{
margin-top:5%;
color:green;
text-align:center;
 font-family: "Times New Roman",Times,serif;
 font-style: italic;
}
</style>
<link href="./images/icon_like_alt.png" rel="icon" type="png" size="16x16">
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
   <h1><%=request.getAttribute("successMSG") %></h1>
</body>
</html> 