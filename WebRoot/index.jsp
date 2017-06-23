<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript">
   		 var xmlHttpRequest;
    	
    	function  getXMLHttpRequest(){
    		//判断浏览器类型
    		if (window.XMLHttpRequest){
    			xmlHttpRequest = new XMLHttpRequest();
    		}else if (window.ActiveXObject){
    			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    		}
    	}
    	
    	function sendMsg(){
    		getXMLHttpRequest();
    		var name = $("#name").val();// "SMILESUU";//document.getElementById("name").value; 
    		alert(name);
    		
    		//服务器地址
   			var wsUrl = "http://59.120.248.198:8004/VerNew02a_WebService/ERPHandWebService";
   			
   			//请求体
   			var soap = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://server.su.com/">'
					  +' <soapenv:Header/> <soapenv:Body> <web:hello>' 
					  +' <name>' + name +' </name> </web:hello> </soapenv:Body> </soapenv:Envelope>'; 
			alert(soap);
			//打开连接
			xmlHttpRequest.open("POST",wsUrl,false);
			
			//
			xmlHttpRequest.setRequestHeader("Content-Type","text/xml");
			//xmlHttpRequest.setRequestheader("Access-Control-Allow-Origin","*"); 
					  
    		//注册回调函数，readyState状态的每一次变化，都会调用一次callBack函数
    		xmlHttpRequest.onreadystatechange = callBack;
    		
    		alert("TEST");
    		xmlHttpRequest.open("POST", wsUrl,false);//建立连接。。
    		
    		
    		xmlHttpRequest.send(soap);//发送请求
    	}
    	  
   		//响应完成后，再取出服务器返回的数据
    	function callBack(){
    		//判断
    	 	//alert(xmlHttpRequest.readyState);
			if (xmlHttpRequest.readyState==4){
				alert("响应完成");
				//判断服务器的响应码
				//当响应码为200时，表示正常返回数据
				if(xmlHttpRequest.status==200){
					alert(xmlHttpRequest.responseText);//得到服务器响应的字符串
				}else if (xmlHttpRequest.status==500){
					alert("服务器内部错误");
				}else if (xmlHttpRequest.status==404){
					alert("您请求的资源不存在:URL错误");
				}
				//alert(xmlHttpRequest.status);
			}
    		
    	}
   </script>
	
  </head>
  
  <body>
      <input type="button" value="Click" onclick="sendMsg();">  
      <input type="text" id="name">  
      <div id="showInfo">  
      </div>  
  </body>
</html>
