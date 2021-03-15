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
	$(".btn").click(function(){
		if($(this).attr("class") == "btn btn-success"){
			
			
			var result = confirm('지점 상태를 비활성화 시키겠습니까?');
					
			if(result){
				
				$(this).attr("class","btn btn-warning");
				$(this).children().text("비활성화");
				
				changeOfficeState($(this).attr("id"));
				
				
			}
		} else if(($(this).attr("class") == "btn btn-warning")){
			var result = confirm('지점 상태를 활성화 시키겠습니까?');
			if(result){
				
				
				
				$(this).attr("class","btn btn-success");
				$(this).children().text("활성화");
				
				changeOfficeState($(this).attr("id"));
			}
		}
		
		
	});
	
	
	function changeOfficeState(id) {  
	    alert(id);
	    $.ajax({
	        type : 'GET',
	        url : "/common/changeOfficeState",
	        data : {"id" : id},
	        success : function (data) {
	                         
	        }

	    });
	}
	
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
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <form class="form-inline">
            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
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
          <h1 class="h3 mb-2 text-gray-800">신청서 목록</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            
            <div class="card-body">
              <div class="table-responsive">
              	<c:choose>
	              	<c:when test="${empty application}">
	              		<h3>등록된 신청서가 없습니다.</h3>
	              	</c:when>
	              	
	              	<c:otherwise>
	                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                  <thead>
	                    <tr>
	                      <th>신청서 Id</th>
	                      <th>신청자</th>
	                      <th>모델명</th>
	                      <th>출시가격</th>
	                      <th>통신사</th>
	                      <th>요금제</th>
	                      <th>결제방법</th>
	                      <th>개통유형</th>
	                      <th>자동이체카드</th>
	                      <th>결합할인</th>
	                      <th>지원금유형</th>
	                      <th>상태</th>
	                      <th>상태변경</th>
	                    </tr>
	                  </thead>
	                 
	                  <tbody>
	                  	<c:forEach items="${application}" var="ap">
	                    <tr>
	                      <td> 
	                      ${ap.applicationId}
	              		  </td>
	              		  
	              		  <td> 
	                      ${ap.member.name}
	              		  </td>
	              		  
	                      <td>${ap.product.device.deviceName}</td>
	                      <td>${ap.product.device.price}</td>
	                      <td>${ap.product.carrier.carrierName}</td>
	                      <td>${ap.product.callingPlan.planName}</td>
						  <c:choose>
	  					 	<c:when test="${ap.purchaseType==1}">
	  					 		<td>
	  					 			할부 개통
	  					 		</td>
	  					 	</c:when>
	  					 	
	  					 	<c:otherwise>
	  					 		<td>
	  					 		현금 일시불
	  					 		</td>
	  					 		
	  					 	</c:otherwise>
	  					 </c:choose>
	                      
	                      <c:choose>
	  					 	<c:when test="${ap.activationType==1}">
	  					 		<td>
	  					 			번호이동
	  					 		</td>
	  					 	</c:when>
	  					 	
	  					 	<c:otherwise>
	  					 		<td>
	  					 		기기변경
	  					 		</td>
	  					 		
	  					 	</c:otherwise>
	  					 </c:choose>
	                      
	                      <td>${ap.card.cardName}</td>
	                      <td>${ap.wiredGoods.wiredGoodsName}</td>
	                      <c:choose>
	  					 	<c:when test="${ap.supportFundType==1}">
	  					 		<td>
	  					 			선택약정
	  					 		</td>
	  					 	</c:when>
	  					 	
	  					 	<c:otherwise>
	  					 		<td>
	  					 		공시지원금
	  					 		</td>
	  					 		
	  					 	</c:otherwise>
	  					 </c:choose>
	                      
	                      
	                      
	                     <c:choose>
	                     
	                     	<c:when test="${ap.state==0}">
	  					 		<td style="color: green;">
	  					 		<a href="#" class="btn btn-success" id="${wg.wiredGoodsId}">
                    					<span class="text">개통 대기</span>
                  					</a>
	  					 	</c:when>
	  					 	<c:when test="${ap.state==1}">
	  					 		<td style="color: green;">
	  					 		<a href="#" class="btn btn-success" id="${wg.wiredGoodsId}">
                    					<span class="text">개통 접수</span>
                  					</a>
	  					 	</c:when>
	  					 	<c:when test="${ap.state==2}">
	  					 		<td style="color: green;">
	  					 		<a href="#" class="btn btn-success" id="${wg.wiredGoodsId}">
                    					<span class="text">개통 완료</span>
                  					</a>
	  					 	</c:when>
	  					 	
	  					 	<c:otherwise>
	  					 		<td style="color: red;">
	  					 		<a href="#" class="btn btn-warning" id= "${wg.wiredGoodsId}">
                    					<span class="text">삭제</span>
                  					</a>
	  					 	</c:otherwise>
	  					 </c:choose>
	                      
	                      <td style="color: green;">
	  					 		<a href="${pageContext.request.contextPath}/common/applicationDetail/${ap.applicationId}"  class="btn btn-primary" id="${wg.wiredGoodsId}">
                    					<span class="text">수정</span>
                  					</a>
	                      <%-- <td style="color: green;">
	  					 		<a href="#" class="btn btn-success" id="${office.officeId}">
                    					<span class="text">삭제</span>
                  					</a> --%>
	                    </tr>
	                    </c:forEach>
	                   
	                  </tbody>
	                </table>
	                </c:otherwise>
                </c:choose>
                
                </br>
                						<%-- <div class="form-group col-md-2">
											<button type="button" onclick="location.href='${pageContext.request.contextPath}/common/applicationRegister'" class="btn btn-primary">신청서 등록하기</button>
										</div> --%>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

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
