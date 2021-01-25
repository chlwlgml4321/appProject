<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">


  <title>Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="${pageCotext.request.contextPath}/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageCotext.request.contextPath}/admin/css/sb-admin-2.min.css" rel="stylesheet">

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
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Hooli Admin</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link" href="index.html">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

     
	  <!-- 유저관리 Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        유저 관리
      </div>

      <!-- 유저 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/user">
          <i class="fas fa-fw fa-table"></i>
          <span>Users</span></a>
          
      </li>
      
      
       <!-- 블랙리스트 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/user">
          <i class="fas fa-fw fa-table"></i>
          <span>BlackList</span></a>
      </li>
      
      
      <!-- 대기중인고객 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/inactiveUser">
          <i class="fas fa-fw fa-table"></i>
          <span>대기중인 고객</span></a>
      </li>
      
      
      <!-- point 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/inactiveUser">
          <i class="fas fa-fw fa-table"></i>
          <span>포인트 관리</span></a>
      </li>  
      
      
     <!-- 구분선 -->
      <hr class="sidebar-divider">
      
      
      
      <!-- Heading -->
      <div class="sidebar-heading">
        신청서 관리
      </div>
      
      <!-- 신청서 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/application">
          <i class="fas fa-fw fa-table"></i>
          <span>신청서</span></a>
          
      </li>
      
      
      <!-- 구분선 -->
      <hr class="sidebar-divider">
      
  <!-- Heading -->
      <div class="sidebar-heading">
        Region 관리
      </div>

      <!-- 지역 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/region">
          <i class="fas fa-fw fa-table"></i>
          <span>REGION</span></a>
          
      </li>
      
      
      <!-- 지역 등록 -->
      <li class="nav-item">
        <a class="nav-link" href="/regionInsert">
          <i class="fas fa-fw fa-table"></i>
          <span>지역 등록</span></a>
          
      </li>  
      
      
      <!-- 구분선 -->
      <hr class="sidebar-divider">
      
  <!-- Heading -->
      <div class="sidebar-heading">
        office 관리
      </div>

      <!-- 지점 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/office">
          <i class="fas fa-fw fa-table"></i>
          <span>OFFICE</span></a>
          
      </li>
      
      
      <!-- 지역 등록 -->
      <li class="nav-item">
        <a class="nav-link" href="/officeRegister">
          <i class="fas fa-fw fa-table"></i>
          <span>지점 등록</span></a>
          
      </li>  
      
      
       <!-- 구분선 -->
      <hr class="sidebar-divider">
      
  <!-- Heading -->
      <div class="sidebar-heading">
        요금제 관리
      </div>

      <!-- 요금제 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/callingPlan">
          <i class="fas fa-fw fa-table"></i>
          <span>요금제</span></a>
          
      </li>
      
      
      <!-- 요금제 등록 -->
      <li class="nav-item">
        <a class="nav-link" href="/callingPlanRegister">
          <i class="fas fa-fw fa-table"></i>
          <span>요금제 등록</span></a>
          
      </li> 
      
           <!-- 구분선 -->
      <hr class="sidebar-divider">
      
      <div class="sidebar-heading">
      	결합상품 관리
      </div>

      <!-- 결합 상품 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/wiredGoods">
          <i class="fas fa-fw fa-table"></i>
          <span>유선 상품</span></a>
          
      </li>
      
      <!-- 카드 결합 -->
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/card">
          <i class="fas fa-fw fa-table"></i>
          <span>카드 결합</span></a>
          
      </li>  

	  	<!-- 구분선 -->
      <hr class="sidebar-divider">
      
      
      <div class="sidebar-heading">
      	제품 관리
      </div>

      <!-- 기기 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/device">
          <i class="fas fa-fw fa-table"></i>
          <span>디바이스</span></a>
          
      </li>
      
      <!-- 상품 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/products">
          <i class="fas fa-fw fa-table"></i>
          <span>특가 상품</span></a>
          
      </li>  
      
      <!-- 방문 고객 상품 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/guestProduct">
          <i class="fas fa-fw fa-table"></i>
          <span>방문고객 상품</span></a>
          
      </li>  
      
     <!-- 추천 상품 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/">
          <i class="fas fa-fw fa-table"></i>
          <span>추천 상품</span></a>
          
      </li>

      
      
        <!-- 구분선 -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        리뷰 관리
      </div>
      
      <li class="nav-item">
        <a class="nav-link" href="/review">
          <i class="fas fa-fw fa-table"></i>
          <span>리뷰</span></a>
      </li>
      
      
       <!-- 구분선 -->
      <hr class="sidebar-divider">
      
      <!-- Heading -->
      <div class="sidebar-heading">
        배너 관리
      </div>
      
      <li class="nav-item">
        <a class="nav-link" href="/banners">
          <i class="fas fa-fw fa-table"></i>
          <span>배너</span></a>
      </li>
      
      
          <!-- 구분선 -->
      <hr class="sidebar-divider">
      
      <!-- Heading -->
      <div class="sidebar-heading">
        커뮤니티 관리
      </div>
      
      <li class="nav-item">
        <a class="nav-link" href="/community">
          <i class="fas fa-fw fa-table"></i>
          <span>community</span></a>
      </li>
      
      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <form class="form-inline">
            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
              <i class="fa fa-bars"></i>
            </button>
          </form>

          
          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>

            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Alerts Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 12, 2019</div>
                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-success">
                      <i class="fas fa-donate text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 7, 2019</div>
                    $290.29 has been deposited into your account!
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-exclamation-triangle text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 2, 2019</div>
                    Spending Alert: We've noticed unusually high spending for your account.
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
              </div>
            </li>

            <!-- Nav Item - Messages -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter">7</span>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                <h6 class="dropdown-header">
                  Message Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div class="font-weight-bold">
                    <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been having.</div>
                    <div class="small text-gray-500">Emily Fowler · 58m</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
                    <div class="status-indicator"></div>
                  </div>
                  <div>
                    <div class="text-truncate">I have the photos that you ordered last month, how would you like them sent to you?</div>
                    <div class="small text-gray-500">Jae Chun · 1d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                    <div class="status-indicator bg-warning"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Last month's report looks great, I am very happy with the progress so far, keep up the good work!</div>
                    <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</div>
                    <div class="small text-gray-500">Chicken the Dog · 2w</div>
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
              </div>
            </li>

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie Luna</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

<!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            상품 수정하기</h1>
          </div>

            
			   <form method="post" id="productForm" action="${pageCotext.request.contextPath}/productForm" >
			  <div>
		  		
		  		 <input type='hidden' name='productsId' value="${products.productsId}">
		  		 <%-- <input type='hidden' name='carrierId' value="${carrier.carrierId}"> --%>
					
		  		 
				 <div class="form-group col-md-2">
			      <label for="inputState">통신사</label>
			      <select id="carrierId" class="form-control" name="carrierId">
			      
			       <option  value ='1' <c:if test="${products.carrier.carrierId == '1'}"> selected="selected" </c:if>>SKT </option>
				   <option  value ='2' <c:if test="${products.carrier.carrierId == '2'}"> selected="selected" </c:if>>KT </option>
				   <option  value ='3' <c:if test="${products.carrier.carrierId == '3'}"> selected </c:if>>LGU+ </option> 
			      </select>
			    </div>  
			    
			    
			    <div class="form-group col-md-2">
			      <label for="inputState">디바이스 이름</label>
			      <select id="deviceId" class="form-control" name="deviceId">
			     	 <option selected>디바이스 선택</option>
			        		<c:forEach items="${devices}" var="devices">
			        			<c:choose>
				        			<c:when test = "${devices.deviceId == products.device.deviceId}">
				        				<option value="${devices.deviceId}" selected="selected" >${devices.deviceName}</option>
				        			</c:when>
				        			<c:otherwise>
				        				<option value="${devices.deviceId}">${devices.deviceName}</option>
				        			</c:otherwise>
								</c:choose>
				   			</c:forEach>
					</select>
			    </div> 
			
			    
			    
			    <div class="form-group col-md-2">
			      <label for="inputState">요금제 이름</label>
			      <select id="callingPlanId" class="form-control" name="callingPlanId">
			     	 <option selected>요금제 선택</option>
			        		<c:forEach items="${callingPlans}" var="callingPlans">
			        			<c:choose>
				        			<c:when test = "${callingPlans.callingPlanId == products.callingPlan.callingPlanId}">
				        				<option value="${callingPlans.callingPlanId}" selected="selected" >${callingPlans.planName}</option>
				        			</c:when>
				        			<c:otherwise>
				        				<option value="${callingPlans.callingPlanId}">${callingPlans.planName}</option>
				        			</c:otherwise>
								</c:choose>
				   			</c:forEach>
					</select>
			    </div> 
			    
			    <div class="form-group col-md-2">
			      <label for="inputState">지점</label>
			      <select id="officeId" class="form-control" name="officeId">
			     	 <option selected>지점 선택</option>
			        		<c:forEach items="${offices}" var="offices">
			        			<c:choose>
				        			<c:when test = "${offices.officeId == products.office.officeId}">
				        				<option value="${offices.officeId}" selected="selected" >${offices.officeName}</option>
				        			</c:when>
				        			<c:otherwise>
				        				<option value="${offices.officeId}">${offices.officeName}</option>
				        			</c:otherwise>
								</c:choose>
				   			</c:forEach>
					</select>
			    </div> 
			
			    
			      
			     <div class="form-group col-md-2">
			      <label for="inputEmail4">개통유형</label>
			      <select id="activationType" class="form-control" name="activationType">
					<option  value='1' <c:if test="${products.activationType == '1'}"> selected="selected" </c:if>>기기변경 </option>
					<option  value ='0'<c:if test="${products.activationType == '0'}"> selected="selected" </c:if>>번호이동</option>
			      </select>
			    </div>  
			    
			    
			    <div class="form-group col-md-2">
			      <label for="inputEmail4">공시지원금</label>
			      <input type="text" class="form-control" id="mainSupportFund"  value="${products.mainSupportFund}"  name="mainSupportFund">
			    </div>
			    
			    <div class="form-group col-md-2">
			      <label for="inputEmail4">마켓지원금</label>
			      <input type="text" class="form-control" id="marketSupportFund"  value="${products.marketSupportFund}"  name="marketSupportFund">
			    </div>
			    
			    
			  </div>
			  
			  <div class="form-group c ol-md-2" >
			   <button type="submit" id="registeProduct" class="btn btn-primary">등록</button>
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
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Bootstrap core JavaScript-->
  <script src="${pageCotext.request.contextPath}/admin/vendor/jquery/jquery.min.js"></script>
  <script src="${pageCotext.request.contextPath}/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageCotext.request.contextPath}/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="${pageCotext.request.contextPath}/admin/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="${pageCotext.request.contextPath}/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="${pageCotext.request.contextPath}/admin/js/demo/datatables-demo.js"></script>

</body>

</html>