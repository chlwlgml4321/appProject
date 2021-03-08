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
	
	$("#registerCallingPlan").click(function(){
		
		$("#callingPlanForm").submit();
		
	});
	
	/* alert("${callingPlan.carrier.carrierId}"); */
	
	/* $("#carrierId").each(function(){

	    if($(this).val()=="${callingPlan.carrier.carrierId}"){

	      $(this).attr("selected","selected"); 

	    }

	  }); */
		
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
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            요금제 수정하기</h1>
          </div>

            
			   <form method="post" id="callingPlanForm" action="${pageCotext.request.contextPath}/admin/callingPlanForm" >
			  <div>
		  		
		  		 <input type='hidden' name='callingPlanId' value="${callingPlan.callingPlanId}">
		  		 <%-- <input type='hidden' name='carrierId' value="${carrier.carrierId}"> --%>
					
		  		 
				 <div class="form-group col-md-2">
			      <label for="inputState">통신사</label>
			      <select id="carrierId" class="form-control" name="carrierId">
			       <!-- <option  value ="1" >SKT </option>
				   <option  value ="2" >KT </option>
				   <option  value ='3' >LGU+ </option> -->
			       <option  value ='1' <c:if test="${callingPlan.carrier.carrierId == '1'}"> selected="selected" </c:if>>SKT </option>
				   <option  value ='2' <c:if test="${callingPlan.carrier.carrierId == '2'}"> selected="selected" </c:if>>KT </option>
				   <option  value ='3' <c:if test="${callingPlan.carrier.carrierId == '3'}"> selected </c:if>>LGU+ </option> 
			      <%-- <option value="${callingPlan.carrier.carrierId}">${callingPlan.carrier.carrierName}</option>  --%>
			      </select>
			    </div>  
			
			    
			    
			    <div class="form-group col-md-2">
			      <label for="inputEmail4">요금제 이름</label>
			      <input type="text" class="form-control" id="planName" value="${callingPlan.planName}" name="planName">
			    </div>
			    
			    <div class="form-group col-md-2">
			      <label for="inputEmail4">기본요금</label>
			      <input type="text" class="form-control" id="basicFee" value="${callingPlan.basicFee}" name="basicFee">
			    </div>
			
			    
			    <div class="form-group col-md-2">
			      <label for="inputEmail4">선택약정 할인율</label>
			      <input type="text" class="form-control" id="bondDiscount"  value="${callingPlan.bondDiscount}"  name="bondDiscount">
			    </div>
			    
			     <div class="form-group col-md-2">
			      <label for="inputEmail4">networkType</label>
			      <select id="networkType" class="form-control" name="networkType">
					<option  value='1' <c:if test="${callingPlan.networkType == '1'}"> selected="selected" </c:if>>5G </option>
					<option  value ='0'<c:if test="${callingPlan.networkType == '0'}"> selected="selected" </c:if>>4G</option>
			      </select>
			    </div>  
			    
			  </div>
			  
			  <div class="form-group c ol-md-2" >
			   <button type="submit" id="registerCallingPlan" class="btn btn-primary">등록</button>
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