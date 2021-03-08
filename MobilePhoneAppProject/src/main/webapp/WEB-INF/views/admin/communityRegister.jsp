<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">
	
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" href="/css/summernote/summernote-lite.css">

<script type="text/javascript">

$(document).ready(function() {
	//여기 아래 부분
	

	
	
	$("#regBtn").click(function(){
		
		$("#regForm").submit();
		
	});
	
	$("#summernote").summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
        
	});
	
	

});
	
</script>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
				  <%@ include file="side.html" %>
		
		<!-- End of Sidebar -->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<form class="form-inline">
						<button id="sidebarToggleTop"
							class="btn btn-link d-md-none rounded-circle mr-3">
							<i class="fa fa-bars"></i>
						</button>
					</form>


					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				
				<div class="container-fluid">
					<sec:authentication var="office" property="principal" />
					<!-- 1 -->
				

					<div id=container>
						<i class="big blue pen square icon"></i>
						<h2 style="display: inline-block; font-style: italic;">새글 쓰기</h2>
						

						<div class="ui middle aligned selection list"
							style="background-color: #eeeeee">
							<div class="item">
								<i class="huge black user circle icon"></i>
								<div class="content">
									<div id="id" class="header" style="font-size: 15pt">${office.officeName}</div>
								</div>
							</div>

						</div>
						<form id="regForm" class="ui form" method="post"
							action="/common/officeBoardForm">

							<div class="field">
								<input type="text" name="title" placeholder="제목을 입력해주세요">
							</div>


							<textarea id="summernote" name="content"></textarea>

							<br>

							<button id="cancleBtn" class="ui button" type="button"
								style="margin: 10px; width: 100px;">취소</button>

							<button id="regBtn" class="positive ui button" type="button"
								style="float: right; margin: 10px; width: 100px;">등록</button>
							<input type="hidden" name="officeId" value="${office.officeId}">
							
						</form>

					</div>


					<div id="cover-spin"></div>


				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2020</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript-->
		<script
			src="${pageCotext.request.contextPath}/admin/vendor/jquery/jquery.min.js"></script>
		<script
			src="${pageCotext.request.contextPath}/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script
			src="${pageCotext.request.contextPath}/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script
			src="${pageCotext.request.contextPath}/admin/vendor/datatables/jquery.dataTables.min.js"></script>
		<script
			src="${pageCotext.request.contextPath}/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

		<!-- Page level custom scripts -->
		<script
			src="${pageCotext.request.contextPath}/admin/js/demo/datatables-demo.js"></script>
</body>

</html>