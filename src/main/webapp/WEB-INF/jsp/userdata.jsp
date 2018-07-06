<%@ page import="java.util.*,com.log.util.CommonUtility" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Anonymous Voting System</title>
	<style type="text/css">
		thead tr td
		{
			background-color:#337ab7;
			padding:5px;
			color:#fff;
			align="center"
		}
		table
		{
			width: 80%;
		}
		h1
		{
			text-align: center;
		}
	
	</style>
	<script type="text/javascript">
	$(document).ready(function()
			{ 
		//$('#campwiseform').hide();
		
		
		  $('#resultdata').DataTable( {

				    scrollY: "400px",
			        scrollX:   true,
			          iDisplayLength: 25 , 
			        scrollCollapse: true,
			        fixedColumns:   {
			            leftColumns: 2
			        }
		    })
			});
	</script>


<%
ArrayList userData = new ArrayList();
ArrayList temp = new ArrayList();
userData = (ArrayList)request.getAttribute("userData");
System.out.println("userData%%%%%%+"+request.getAttribute("userData"));%>
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
				<a href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath() %>/images/quality1.jpg" width="100" height="100" class="img-responsive"></a>
		
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav navbar-right">
						<li id="cd"><a href="<%=request.getContextPath()%>"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Home</font></a></li>
					</ul>
				</div>
			</div>
		</nav>
		<h1>User Data</h1>
	<div class="col-sm-12" style="text-align: center;">
		<%if(userData!=null && userData.size()>0) {%>
			<table id="resultdata" class="table table-striped table-bordered" style="width:100%">
				<thead>
			      <tr>
			       
			     	<td>SNO</td>
					<td>StudentID</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>role</td>
					<td>Email</td>
					<td>Mobile No</td>
					<td>State</td>
					<td>District</td>
					<td>City</td>
					<td>College</td>
					<td>Is Final Year</td>
					<td></td>
			   
			       </tr>
			      
			    </thead>
				<tbody>
				
			
			<%for(int i=0;i<userData.size();i++) 
			{
				temp = (ArrayList)userData.get(i);
			%>
			
			
				<tr>
					<td><%=temp.get(0) %></td>
					<td><%=temp.get(1) %></td>
					<td><%=temp.get(2) %></td>
					<td><%=temp.get(3) %></td>
					<td><%=temp.get(4) %></td>
					<td><%=temp.get(5) %></td>
					<td><%=temp.get(6) %></td>
					<td><%=temp.get(7) %></td>
					<td><%=temp.get(8) %></td>
					<td><%=temp.get(9) %></td>
					<td><%=temp.get(10) %></td>
					<td><%=temp.get(11) %></td>
					
					
					<td></td>
				</tr>
			
			
			
			
			<%}
			%>
				</tbody>
			</table>
		<%}else{ %>
			<p>No data </p>
		<%} %>
	
	</div>
	

</body>
</html>