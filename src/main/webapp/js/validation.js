/* Only Numbers onkeypress="return NumbersOnly(event);" */
function NumbersOnly(e){           
   	var key = window.event ? e.keyCode:e.which;     //alert(key);        
   	var keychar = String.fromCharCode(key);           
   	reg = /\d/;   
	if(key==0 || key==8){   
		return true;  
	}  
	else{    
		return reg.test(keychar);     
	} 
}     
/* Only Alphabates onkeypress="return onKeyPressAlphbateOnly(event);" */ 
function onKeyPressAlphbateOnly(e){        
	var key = window.event ? e.keyCode:e.which;        
	var keychar = String.fromCharCode(key);     //alert(key);     
	reg = /\d/;     
	if(reg.test(keychar)==false)  {   
		if(((parseInt(key)>=65&&parseInt(key)<=90)|| (parseInt(key)>=97&&parseInt(key) <=122))||parseInt(key)==32||parseInt(key)==8||parseInt(key)==0)
		{   
			return true;   
		}   
		else   
		{   
			return false;   
		}  
	}  
	else  {  
		return false;  
	} 
}
/* Email Validation OnfocusOut="EmailCheck(this)" */ 
function EmailCheck(myForm) {
	   var filter =/^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9] {1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	   if (myForm.value!="" && filter.test(myForm.value))
	   {         
		   return true;     
	   }     
	   else     
	   {      
		   if(myForm.value!="")      
		   {       
			   alert("Invalid E-mail address please reenter.");       
			   myForm.value="";      
		   }         
		   return false;     
	   } 
}
/* PhoneNumber Validation OnfocusOut="PhoneNumber(this)" */ 
function PhoneNumber(myForm) {
	   var filter =/^([6789][0-9]{9})$/;
	   if (myForm.value!="" && filter.test(myForm.value))
	   {         
		   return true;     
	   }     
	   else     
	   {      
		   if(myForm.value!="")      
		   {       
			   alert("Phone Number should starts with 6/7/8/9 contains 10 numbers only");       
			   myForm.value="";      
		   }         
		   return false;     
	   }
}
