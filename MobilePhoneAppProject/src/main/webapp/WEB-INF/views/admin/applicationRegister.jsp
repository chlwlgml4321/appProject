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

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						상품 [${products.device.deviceName}] 신청서 등록하기
						</h1>
					</div>

					<form method="post" id="applicationForm"
						action="${pageCotext.request.contextPath}/common/applicationForm">
						<div>

							<input type='hidden' name='applicationId'
								value="${application.applicationId}"> <input
								type='hidden' name='productId' value="${products.productsId}">

							<div class="form-group col-md-2">
								<label for="inputState">개통유형</label> <select id="activationType"
									class="form-control" name="activationType">
									<option selected>개통 유형</option>
									<option value="0">번호 이동</option>
									<option value="1">기기변경</option>
								</select>
							</div>

							<div class="form-group col-md-2">
								<label for="inputState">결제 방법</label> <select id="purchaseType"
									class="form-control" name="purchaseType">
									<option selected>결제 방법</option>

									<option value="0">현금 일시불 개통</option>
									<option value="1">할부 개통</option>

								</select>
							</div>

							<div class="form-group col-md-2">
								<label for="inputState">자동 이체 카드 결합</label> <select id="cardId"
									class="form-control" name="cardId">
									<option selected>결제 방법</option>
									<option value="0">미결합</option>
									<c:forEach items="${cards}" var="cards">
										<option value="${cards.cardId}">${cards.cardName}</option>
									</c:forEach>
								</select>
							</div>




							<div class="form-group col-md-2">
								<label for="inputState">결합 할인 선택</label> <select
									id="wiredGoodsId" class="form-control" name="wiredGoodsId">
									<option selected>결제 방법</option>
									<option value="0">미결합</option>
									<c:forEach items="${wiredGoods}" var="wiredGoods">
										<option value="${wiredGoods.wiredGoodsId}">${wiredGoods.wiredGoodsName}</option>
									</c:forEach>
								</select>
							</div>


							<div class="form-group col-md-2">
								<label for="inputState">지원금 유형 선택</label> <select
									id="supportFundType" class="form-control"
									name="supportFundType">
									<option selected>결제 방법</option>
									<option value="0">공시지원금 개통</option>
									<option value="0">선택약정 개통</option>

								</select>
							</div>
							
							
						<div class="form-group col-md-2">
			      			<label for="inputEmail4">신청자 핸드폰 번호</label>
			      			<input type="text" class="form-control" id="phone" name="phone">
			    		</div>


						</div>

						<div class="form-group col-md-2">
							<button type="submit" id="registerOffice" class="btn btn-primary">등록</button>
						</div>
					</form>

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