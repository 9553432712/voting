<%@ page import="java.util.*,com.log.util.CommonUtility" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<link rel="stylesheet" href="./css/bootstrap.min.css"> 
        <link rel="stylesheet" type="text/css" href="./css/font-awesome-4.7.0/css/font-awesome.min.css">
        <script src="./js/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
		
		<style type="text/css">
		
				body, html{
				     height: 100%;
				 	background-repeat: no-repeat;
				 	background-color: #d3d3d3;
				 	font-family: 'Oxygen', sans-serif;
				}
				
				.main{
				 	margin-top: 70px;
				}
				
				h1.title { 
					font-size: 50px;
					font-family: 'Passion One', cursive; 
					font-weight: 400; 
				}
				#reg{
					text-align:center;
					border:1px solid black;
					width:30.6%;
					margin-left:34.6%;
				}
				i{
					background-color:pink;
					height:20px;
					width:20px;
					text-align: center;
					padding: 5px;
				}
				#stateDivId,#districtDivId,#cityDivId,#collegeDivId{
					float: right;
					margin-right:0%;
					width:90%;
				}
				hr{
					width: 10%;
					color: #fff;
				}
				
				.form-group{
					margin-bottom: 15px;
				}
				
				label{
					margin-bottom: 15px;
				}
				#isfinalyear{
					width:50px;
					line-height: 20px;
				}
				input,
				input::-webkit-input-placeholder {
				    font-size: 11px;
				    padding-top: 3px;
				    line-height: 20px;
				    width:88%;
				}
				
				.main-login{
				 	background-color: #fff;
				    /* shadows and rounded borders */
				    -moz-border-radius: 2px;
				    -webkit-border-radius: 2px;
				    border-radius: 2px;
				    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
				    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
				    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
				
				}
				
				.main-center{
				 	margin-top: 30px;
				 	margin: 0 auto;
				 	max-width: 330px;
				    padding: 40px 40px;
				
				}
				
				.login-button{
					margin-top: 5px;
				}
				
				.login-register{
					font-size: 11px;
					text-align: center;
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
				#icn{
					background-color: transparent;
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
		
		<meta name="viewport" content="width=device-width, initial-scale=1">


		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

	<%String successMsg = CommonUtility.checkNullObj(request.getAttribute("successMSG"));
%>

	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LOG Registration Form</title>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/registration.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/ajax.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/validation.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
	<script type="text/javascript">
	$(document).ready(function ($) 
	{
		try
		{
			$('#go').click(function(){
				//alert($('#student_id').val());
				var pattern="/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/"
				if($('#student_id').val()==" " || $('#student_id').val().length==0 )
				{
					alert("Please enter student id");
					return false;
				}
				else if($('#email').val()==" " || $('#email').val().length==0)
				{
					
					alert("Please enter Email Id");
					return false;
				}
				else if(confirm("Are you sure you want to submit the request?"))
				{
				 document.myForm.target="_self";
				 document.myForm.action="<%=request.getContextPath()%>/voteSubmit";
				 document.myForm.submit();
				}

			});
		}
		catch(e)
		{
			alert(e);
		}

	});	
	</script>
	
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
						<li id="cd"><a href="./register"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Registration</font></a></li>
						<li id="cd"><a href="./admin/login"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Admin</font></a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<div style="color:green;text-align:center;font-size:18px"><%=CommonUtility.checkNullObj(request.getAttribute("successMSG")) %></div>
		<div class="container">
			
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Anonymous Voting System</h1>
	               		<hr />
	               	</div>
	            </div> 
	            <div id="reg">
					<h2>Vote Here..</h2>
				</div>
				<div class="main-login main-center">
					<form name="myForm" class="form-horizontal" method="post">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Student ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" name="student_id" id="student_id" required/>
								</div>
							</div>
						</div>
					

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="email" name="email" OnfocusOut="EmailCheck(this)" id="email" required/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Voter Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" name="vname" id="vname" required/>
								</div>
							</div>
						</div>
						
						<div class="form-group ">
							<button id="go" name="go" type="submit">
								Vote
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</body>




</html>
