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
	        url : "/admin/changeOfficeState",
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
          <h1 class="h3 mb-2 text-gray-800">지점 목록</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            
            <div class="card-body">
              <div class="table-responsive">
              	<c:choose>
	              	<c:when test="${empty office}">
	              		<h3>등록된 지점이 없습니다.</h3>
	              	</c:when>
	              	
	              	<c:otherwise>
	                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                  <thead>
	                    <tr>
	                      <th>officeId</th>
	                      <th>이름</th>
	                      <th>주소</th>
	                      <th>번호</th>
	                      <th>비밀번호</th>
	                      <th>링크</th>
	                      <th>상태</th>
	                      <th>수정</th>
	                    </tr>
	                  </thead>
	                 
	                  <tbody>
	                  	<c:forEach items="${office}" var="office">
	                    <tr>
	                      <td> 
	                      ${office.officeId}
	              		  </td>
	                      <td>${office.officeName}</td>
	                      <td>${office.address}</td>
	                      <td>${office.tel}</td>
	                      <td>${office.password}</td>
	                      <td>${office.url}</td>
	                      
	                     <c:choose>
	  					 	<c:when test="${office.state==1}">
	  					 		<td style="color: green;">
	  					 		<a href="#" class="btn btn-success" id="${office.officeId}">
                    					<span class="text">활성화</span>
                  					</a>
	  					 	</c:when>
	  					 	
	  					 	<c:otherwise>
	  					 		<td style="color: red;">
	  					 		<a href="#" class="btn btn-warning" id= "${office.officeId}">
                    					<span class="text">비활성화</span>
                  					</a>
	  					 	</c:otherwise>
	  					 </c:choose>
	                      
	                      <td style="color: green;">
	  					 		<a href="${pageContext.request.contextPath}/admin/officeDetail/${office.officeId}"  class="btn btn-primary" id="${office.officeId}">
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
                						<div class="form-group col-md-2">
											<button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/officeRegister'" class="btn btn-primary">지점 등록하기</button>
										</div>
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
