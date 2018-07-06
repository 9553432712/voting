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