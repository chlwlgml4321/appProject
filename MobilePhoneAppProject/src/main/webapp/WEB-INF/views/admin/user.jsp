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
				
				
				var result = confirm('회원의 상태를 비활성화 시키겠습니까?');
						
				if(result){
					
					$(this).attr("class","btn btn-warning");
					$(this).children().text("탈퇴");
					
					changeState($(this).attr("id"));
					
					
				}
			} else if(($(this).attr("class") == "btn btn-warning")){
				var result = confirm('회원을 상태를 활성화 시키겠습니까?');
				if(result){
					
					
					
					$(this).attr("class","btn btn-success");
					$(this).children().text("정상");
					
					changeState($(this).attr("id"));
				}
			}
			
			
		});
		
		
		function changeState(id) {  
		    alert(id);
		    $.ajax({
		        type : 'GET',
		        url : "/common/changeUserSate",
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

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">회원 목록</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            
            <div class="card-body">
              <div class="table-responsive">
              	<c:choose>
	              	<c:when test="${empty members}">
	              		<h3>등록된 회원이 없습니다.</h3>
	              	</c:when>
	              	
	              	<c:otherwise>
	                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                  <thead>
	                    <tr>
	                      <th>ID</th>
	                      <th>방문여부</th>
	                      <th>회원코드</th>
	                      <th>이름</th>
	                      <th>비밀번호</th>
	                      <th>핸드폰</th>
	                      <th>가입일자</th>
	                      <th>지역</th>
	                      
	                      <th>지점 id</th>
	                      <th>회원상태</td>
	                      <th>포인트 관리</td>
	                      
	                    </tr>
	                  </thead>
	                 
	                  <tbody>
	                  	<c:forEach items="${members}" var="members">
	                    <tr>	                      
	                      <td>${members.memberId}</td>
	                      <td>${members.isVisitor}</td>
	                      <td>${members.memberCode}</td>
	                      <td>${members.name}</td>
	                      <td>${members.password}</td>
	                      <td>${members.phone}</td>
	                      <td>${members.regDate}</td>
	                      <td>${members.regions}</td>
	  					  <td>${members.office.officeId}</td> 
	  					 <c:choose>
	  					 	<c:when test="${members.state==1}">
	  					 		<td style="color: green;">
	  					 		<a href="#" class="btn btn-success" id="${members.memberId}">
                    					<span class="text">정상</span>
                  					</a>
	  					 	</c:when>
	  					 	
	  					 	<c:otherwise>
	  					 		<td style="color: red;">
	  					 		<a href="#" class="btn btn-warning" id= "${members.memberId}">
                    					<span class="text">탈퇴</span>
                  					</a>
	  					 	</c:otherwise>
	  					 </c:choose>
	  					 
	                       <td style="color: green;">
	  					 		<a href="${pageContext.request.contextPath}/admin/point/${members.memberId}"  class="btn btn-primary"  id="${products.productsId}">
                    					<span class="text">관리</span>
                  					</a>
	                     
	                     
	                      <%--  <td><a href="child?id=${member.id}" target="_blank"> ${fn:length(member.childs)}</a> </td> --%> 
	                   
	                     <%--  <c:choose>
	                      	<c:when test="${members.state==1}">
	                      		<td style="color: green;">
	                      		
	                      			<a href="#" class="btn btn-success" id="${members.memberId}">
                    					<span class="text">추가</span>
                  					</a>
	                      		</td>
	                      	</c:when>
	                      	
	                      	<c:otherwise>
	                      		<td style="color: red;">
	                	      		<a href="#" class="btn btn-warning" id= "${members.memberId}">
                    					<span class="text">블랙리스트</span>
                  					</a>
	                      		</td>
	                      	</c:otherwise>
	                      
	                      </c:choose> --%>
	                    </tr>
	                    </c:forEach>
	                   
	                  </tbody>
	                </table>
	                </c:otherwise>
                </c:choose>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up1"></i>
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
