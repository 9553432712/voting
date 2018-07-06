<%@ page import="java.util.*,com.log.util.CommonUtility" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	
		
		<style type="text/css">
		
				body, html{
				 	background-repeat: no-repeat;
				 	background-image: url("./images/reg.jpg");
				 	background-position: center;
				 	background-size: cover;
				 	background-attachment: fixed;
				 	font-family: 'Oxygen', sans-serif;
				}
				
				.main{
				 	margin-top: 20px;
				}
				
				h1{ 
					font-size: 70px;
					font-family: 'Passion One', cursive; 
					font-weight: 200; 
					text-align: center;
					text-shadow: 0px 3px 0px white;
				}
				#reg{
					text-align:center;
					border:1px solid transparent;
					color:white;
					font-size:20px;
					text-shadow: 0px 3px 1px black;
				}
				i{
					background-color:pink;
					height:27px;
					width:30px;
					text-align: center;
					padding: 5px;
				}
				
				#stateDivId,#districtDivId,#cityDivId,#collegeDivId{
					float: right;
					margin-right:0%;
					width:90%;
					margin-top:1%;
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
					font-size: 19px;
				}
				#isfinalyear{
					width:30px;
					height: 20px;
				}
				input,
				input::-webkit-input-placeholder {
				    font-size: 11px;
				    padding-top: 3px;
				    line-height: 20px;
				    width:90%;
				    margin-top: 1%;
				}
				.input-group{
					border:1px solid transparent;
					width: 101%;
				}
				.main-login{
				 	background-color: rgba(0,0,0,0.28);
				 	font-weight:bold;
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
				    padding: 10px 40px;
					max-width: 400px;
				}
				
				.login-button{
					margin-top: 5px;
				}
				
				.login-register{
					font-size: 11px;
					text-align: center;
				}
				#regist{
					text-align:center;
					line-height: 30px;
					margin-top:3%;
					width:100%;
					background-color: #1e90ff;
					border:none;
					font-size:20px;
					box-shadow: 0px 0px 3px 0px black;
					border-radius: 10px 10px 10px 10px;
				}
				#regist:hover{
					letter-spacing: 3px;
					cursor: pointer;
					background-color:#228B22;
					color:white;
					transition:1s;
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
		<link rel="stylesheet" href="./css/bootstrap.min.css"> 
		<!-- Website CSS style -->
        
		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LOG Registration Form</title>
	
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/ajax.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/validation.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/registration.js"></script>
	<script type="text/javascript">
	$(document).ready(function ($) 
	{
		try
		{
			$('#regist').click(function(){
				//alert($('#student_id').val());
				var pattern="/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/"
				if($('#student_id').val()==" " || $('#student_id').val().length==0 )
				{
					alert("Please enter student id");
					return false;
				}
				else if($('#first_name').val()==" " || $('#first_name').val().length==0 )
				{
					alert("Please enter First Name");
					return false;
				}
				else if($('#last_name').val()==" " || $('#last_name').val().length==0 )
				{
					alert("Please enter Last Name");
					return false;
				}
				else if($('#email').val()==" " || $('#email').val().length==0)
				{
					
					alert("Please enter Email Id");
					return false;
				}
				else if($('#phone').val()==" " || $('#phone').val().length==0)
				{
					alert("Please enter Phone Number");
					return false;
				}
				else if($('#stateId').val()=="-1" || $('#stateId').val().length==0 )
				{
					alert("Please select State");
					return false;
				}
				else if($('#student_id').val()==" ")
				{
					alert("Please select Student id");
					return false;
				}
				else if( $('#districtId').val()=="-1" || $('#districtId').val().length==0 )
				{
					alert("Please select District");
					return false;
				}
				else if($('#cityId').val()=="-1" || $('#cityId').val().length==0 )
				{
					alert("Please select City");
					return false;
				}
				else if($('#collegeId').val()=="-1" || $('#collegeId').val().length==0 )
				{
					alert("Please select College");
					return false;
				}
				else if(confirm("Are you sure you want to submit the request?"))
				{
				 document.myForm.target="_self";
				 document.myForm.action="<%=request.getContextPath()%>/registrationSubmit";
				 document.myForm.submit();
					/*Screen Locking Started */
				/*Screen Locking Ended */
				}

			});
			
			$('body').on('change','#districtId',function()
					{//alert("body");
						fire_ajax_submit("./getCity","cityDivId","stateId="+ $('#stateId').val()+"&districtId="+ $('#districtId').val());
						
				    });
			$('body').on('change','#cityId',function()
					{//alert("body");
						fire_ajax_submit("./getCollege","collegeDivId","stateId="+ $('#stateId').val()+"&districtId="+ $('#districtId').val()+"&cityId="+ $('#cityId').val());
						
				    });
			
			//fire_ajax_submit("/getState","stateDivId","stateId="+ $('#stateId').val());
				//alert();
			    $("#search-form").submit(function (event) 
			    {
			        //stop submit the form, we will post it manually.
			        event.preventDefault();
			        
			        fire_ajax_submit("./getState","stateDivId","stateId="+ $('#stateId').val());

			    });
			    
			        
			       <%
			       
			       %>
			   
			    
			    $('#stateId').change(function()
						{
					    	event.preventDefault();
					    	
					    	 //postRequest("<%=request.getContextPath()%>/getDistrict","districtDivId");
					        fire_ajax_submit("./getDistrict","districtDivId","stateId="+ $('#stateId').val());

							 //postRequest("<%=request.getContextPath()%>/getStates?action=loadpanchayatopenrep&stateId="+ $('#stateId').val()+"&randomid="+Math.random(),"districtDivId");
						});
			    function postRequest(strURL,textID) 
			    {
			        
			    	var xmlHttp;
			        if (window.XMLHttpRequest)  // Mozilla, Safari, ...
			    	 {
			              xmlHttp = new XMLHttpRequest();
			        }
			        else if (window.ActiveXObject)  // IE
			    	{
			              xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			        }
			        xmlHttp.open('POST', strURL, true);
			        xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			        xmlHttp.onreadystatechange = function()
			         {
			    	    
			        	if (xmlHttp.readyState == 1) 
			            {
			        		updatepage("<center><img src='<%=request.getContextPath()%>/images/loading.gif' width='15' height='15'></center>",textID);
			            }
			    	    else if(xmlHttp.readyState == 2)
			    	    {
			    	    	updatepage('Wait..',textID);
			    	    }
			    	    else if(xmlHttp.readyState == 3)
			    	    {
			    	    	updatepage('Please Wait..',textID);
			    	    }
			    	    else if (xmlHttp.readyState == 4) 
			            {
			    	    	var errorCode = xmlHttp.getResponseHeader('errorCode');
			    	    
			    	    	if(errorCode=="" || errorCode==null ) // Check null to for mozilla
			    	    	{
			            		updatepage(xmlHttp.responseText,textID);
			            		
			    	    	}
			    	    	else
			    	    	{
			    	    		$('#errorMsg').html(errorCode).fadeIn(100);
			    	    		location.replace(window.location);
			    	    	}
			        	}
			    	};
			    	xmlHttp.send(strURL);
			    }

			    function updatepage(msg,id)
			    {		
			    	if(msg!="" && msg!="null")
			    	{
			    		document.getElementById(id).innerHTML=msg;
			    	}
			    }

		}
		catch(e)
		{
			alert(e);
		}

	});
	

	
	</script>
	<%
	
		ArrayList stateList       = new ArrayList();
		stateList = (ArrayList)request.getAttribute("statesList");
		String selState = "";

		ArrayList districtList       = new ArrayList();
		String selDistrict = "";
		
		ArrayList cityList       = new ArrayList();
		String selCity = "";
		
		ArrayList collegeList       = new ArrayList();
		String selCollege = "";
		
		System.out.println("0000000000000000000000------"+stateList);
		
		System.out.println("0000000000000000000000------"+request.getContextPath());
	
	%>
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
						<li id="cd"><a href="./vote"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Vote</font></a></li>
						<li id="cd"><a href="./admin/login"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Admin</font></a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container">
			
			<div class="row main">
				<div class="panel-heading">
	               <h1 class="title">Anonymous Voting System</h1>
	            </div> 
				<div class="main-login main-center">
					<div class="panel-title text-center main-center">
	               		<h2 class="title">Registration Form</h2>
	               		<hr />
	               	</div>
					<form name="myForm" class="form-horizontal" method="post" name="registrationForm" id="registrationForm" action="registrationSubmit" onsubmit="return validate()">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Student ID</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-user fa" aria-hidden="true"></i>
									<input type="text" name="student_id" id="student_id" required/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">First Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-user fa" aria-hidden="true"></i>
									<input type="text" name="first_name" onkeypress="return onKeyPressAlphbateOnly(event);" id="first_name" required/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Last Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-user fa" aria-hidden="true"></i>
									<input type="text" name="last_name" onkeypress="return onKeyPressAlphbateOnly(event);" id="last_name" required/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-envelope fa" aria-hidden="true"></i>
									<input type="email" name="email" OnfocusOut="EmailCheck(this)" id="email" required/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">phone</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-mobile fa-lg" aria-hidden="true"></i>
									<input type="text" name="phone" OnfocusOut="PhoneNumber(this)" id="phone" onkeypress="return NumbersOnly(event);" required/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">State</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-lock fa-lg" aria-hidden="true"></i>
										<div id="stateDivId">
			                           		<%=CommonUtility.createStrComboBoxAuto("stateId",stateList,selState, "fa fa-lock fa-lg","",true,true,"")%>
			                           </div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">District</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-lock fa-lg" aria-hidden="true"></i>
										<div id="districtDivId">
			                       		    <%=CommonUtility.createStrComboBoxAuto("districtId",districtList,selDistrict, "fa fa-lock fa-lg","",true,true,"")%>
			                           </div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">City</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-lock fa-lg" aria-hidden="true"></i>
										<div id="cityDivId">
			                          		 <%=CommonUtility.createStrComboBoxAuto("cityId",cityList,selCity, "fa fa-lock fa-lg","",true,true,"")%>
			                           </div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">College</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-lock fa-lg" aria-hidden="true"></i>
										<div id="collegeDivId">
			                          		 <%=CommonUtility.createStrComboBoxAuto("collegeId",collegeList,selCity, "fa fa-lock fa-lg","",true,true,"")%>
			                           </div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Final Year</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<i id="icon" class="fa fa-lock fa-lg" aria-hidden="true"></i>
										<input type="checkbox" name="isfinalyear" OnfocusOut="CheckBox(this)" id="isfinalyear" required/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button id="regist" name="regist" type="submit">
								Register
							</button>
						</div>
					</form>
				</div>
			</div><br><br>
		</div>
		<script type="text/javascript">
		$(document).ready(function(){
			$("#registrationForm").validate({
				  rules: {
					  student_id: {
					      required: true,
					      minlength: 1,
					      maxlength: 50,
					    },
					    first_name: {
						      required: true,
						      minlength: 2,
						      maxlength: 100,
						    },
					    last_name: {
						      required: true,
						      minlength: 1,
						      maxlength: 100,
						    },
					    email: {
						      required: true,
						      email: true
						    },
					    phone: {
						      required: true,
						    },
					    stateId: {
						      required: true,
						      number: true,
						    },
					    districtId: {
						      required: true,
						    },
					    cityId: {
						      required: true,
						    },
					    collegeId: {
						      required: true,
						    }
				  },
				  messages: {
					  first_name: {
				      required: "Enter your First Name",
				      maxlength: "At max 100 characters are allowed",
				      minlength: "At atleast 3 characters are allowed",
				    }
				  }
				});
		})
		
		
		
		</script>

	</body>




</html>
