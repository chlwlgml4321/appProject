<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>Dashboard</title>

<!-- Custom fonts for this template-->
<link
	href="${pageCotext.request.contextPath}/admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageCotext.request.contextPath}/admin/css/sb-admin-2.min.css"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>


<script type="text/javascript">

$(document).ready(function(){
	
	$("#registerOffice").click(function(){
		$("#officeForm").submit();
		
	});
});
	
</script>
</head>
<body id="page-top">
	
	<h1>SPREAD</h1>
	
	<form>
	
	<input type= "text" class = "text" placeholder="금액">
	<input type= "text" class = "text" placeholder="계좌번호">
	<td style="color: green;">
	  					 		<a href="#" class="btn btn-success" >
                    					<span class="text">전송</span>
                  					</a>
	
	</form>
	
	
	
	
	</body>

</html>