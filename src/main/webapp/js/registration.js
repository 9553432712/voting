

function fire_ajax_submit(strURL,textID,params) 
{
	//alert(params);
	//alert(textID);
	
	var vote = {"username" : $("#stateId").val()};

	
    var search = {}
    search["username"] = $("#stateId").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        //contentType: "application/json",
        url: strURL,
        data: params,//'firstName=lllll' + $("#stateId").val() + "&lastName=" + $("#stateId").val() + "&email=" + $("#stateId").val(),//{ name: "John", location: "Boston" },
        //dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	//alert(JSON.stringify(data);

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);
            
            var result = "";
            
            //$(#testID).html(data.resultMSG);
            //document.getElementById(textID).innerHTML="";
            //alert(JSON.stringify(data.resultMSG));
            document.getElementById(textID).innerHTML=data;//JSON.stringify(data.resultMSG);
            
//            for (x in data.resultList) 
//            {
//            	 //alert(JSON.stringify(data.resultList[x]));
//            	result = result + JSON.stringify(x);
//            }
//            
          
            
	        
        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
        
    });
    
}




