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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/style.css">
  
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
	
	
<script type="text/javascript">
$(document).ready(function(){
		$("#updateNotice").click(function(){
			$("#updateForm").submit();
			
		});
		
	});

		



</script>	


<style>
	img{
		width: 280px;
		height: 310px; 
	}
</style>
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
          <h1 class="h3 mb-2 text-gray-800">${review.member.name}님의 리뷰 </h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            
            <div class="card-body">
             <div class="col-lg-12">

              <!-- Roitation Utilities -->
              
              <div class="card">
             
                <div class="card-header py-3">
                <h5>${review.member.name}님</h5>
                
                  <h6 class="m-0 font-weight-bold text-primary">
                 	모델명 : ${review.device.deviceName}
                 </h6>
                 
                  <h6 class="m-0 font-weight-bold text-primary">
                 	${review.carrier.carrierName} / 
                 	<c:choose>
	  					 <c:when test="${review.activationType==0}">
	  					 	<th>번호이동</th>
	  					 </c:when>
	  					 	
	  					 <c:otherwise>
	  					 	<th>기기변경</th>
	  					 </c:otherwise>
	  				</c:choose>/ ${review.office.officeName}
                 </h6>
                 <h6 align="right" class="mb-1 small">
                 
	  				
	  					<%-- <c:forEach begin="0" end="${review.rate-1}" items="${reviewBest}" var="reviewBest"  >
	                            
	                    	<i class="fa fa-star icolor"></i>
<!-- 	                    <i class="fa fa-star"></i> -->
	                   </c:forEach> --%>
	                   
	                <div class="rating-icon">
					<c:forEach begin="1" end="5" varStatus="st">
						<c:choose >
							<c:when test="${st.count<=review.rate}">
							<i class="fa fa-star icolor"></i>
							</c:when>
						<c:otherwise>
							<i class="fa fa-star"></i>
						</c:otherwise>
					</c:choose>
					</c:forEach> 
                    </div>  
                      
				 </h6>
				 
				 
                  <h6 align="right" class="mb-1 small">${review.regDate} </h6>
                  
                </div>
                <div class="card-body text-left">
                	${review.content}
               
                </div>
                <div class="card-body text-left">
                	<img src="${review.reviewImg1}"/>
                	
               
                </div>
             
              </div>

            </div>

				 <div class="form-group col-md-2" >
				 </br>
			  </div>
			 
            </div>
				
				
				
				
				
				
				
				
			<!-- <table >
				<tr>
				<td>
				<input type="submit" value="수정하기" style="text-align: center;">
				</td>
				</tr>
			</table> -->
							<%-- <form id = "updateForm" action="/admin/noticeInsert" method="post">
				<input type="hidden" name="title" value ="${notice.title}">
				<input type="hidden" name="content" value="${notice.content}">
			</form> --%>
			
             
             
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
