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
	
	$("#registerProduct").click(function(){
		$("#productForm").submit();
		
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
						상품 등록하기
						</h1>
					</div>


					<form method="post" id="productForm"
						action="${pageCotext.request.contextPath}/common/productForm">
						<div>

							<input type='hidden' name='productsId'
								value="${products.productsId}">


							<div class="form-group col-md-2">
								<label for="inputState">통신사</label> <select id="carrierId"
									class="form-control" name="carrierId">
									<option selected>통신사 선택</option>
									<c:forEach items="${carrier}" var="car">
										<option value="${car.carrierId}">${car.carrierName}</option>
									</c:forEach>
								</select>
							</div>


							<div class="form-group col-md-2">
								<label for="inputState">디바이스 이름</label> <select id="deviceId"
									class="form-control" name="deviceId">
									<option selected>디바이스 선택</option>
									<c:forEach items="${device}" var="device">
										<option value="${device.deviceId}">${device.deviceName}</option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group col-md-2">
								<label for="inputState">요금제 이름</label> <select
									id="callingPlanId" class="form-control" name="callingPlanId">
									<option selected>요금제 선택</option>
									<c:forEach items="${callingPlan}" var="callingPlan">
										<option value="${callingPlan.callingPlanId}">${callingPlan.planName}</option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group col-md-2">
								<label for="inputState">지점 이름</label> <select id="officeId"
									class="form-control" name="officeId">
									<option selected>지점 선택</option>
									<c:forEach items="${office}" var="office">
										<option value="${office.officeId}">${office.officeName}</option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group col-md-2">
								<label for="inputEmail4">개통유형</label> <select
									id="activationType" class="form-control" name="activationType">
									<option selected>개통유형 선택</option>
									<option value='1'>기기변경</option>
									<option value='0'>번호이동</option>
								</select>
							</div>


							<div class="form-group col-md-2">
								<label for="inputEmail4">공시지원금</label> <input type="text"
									class="form-control" id="mainSupportFund" placeholder="원"
									name="mainSupportFund">
							</div>

							<div class="form-group col-md-2">
								<label for="inputEmail4">마켓지원금</label> <input type="text"
									class="form-control" id="marketSupportFund" placeholder="원"
									name="marketSupportFund">
							</div>
							
							<div class="form-group col-md-2">
								<label for="inputEmail4">할부수수료</label> <input type="text"
									class="form-control" id="installmentFee" placeholder="원"
									name="installmentFee">
							</div>


						</div>

						<div class="form-group col-md-2">
							<button type="submit" id="registerProduct"
								class="btn btn-primary">등록</button>
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

		<!— Custom scripts for all pages—>
		<script src="js/sb-admin-2.min.js"></script>

		<!— Page level plugins —>
		<script
			src="${pageCotext.request.contextPath}/admin/vendor/datatables/jquery.dataTables.min.js"></script>
		<script
			src="${pageCotext.request.contextPath}/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

		<!— Page level custom scripts —>
		<script
			src="${pageCotext.request.contextPath}/admin/js/demo/datatables-demo.js"></script>
</body>

</html>