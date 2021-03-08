<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/semantic/semantic.min.css">


	
	
<script type="text/javascript">

$(document).ready(function(){
	
	$("#registerOffice").click(function(){
		$("#officeForm").submit(); 
		
	});
	
	
	$(".regBtn").click(function() {
		
		
		
	});
	
	$(".deleteReply").click(function(){
		var result = confirm('댓글을 삭제하겠습니까?');
		if(result){
		
			
			$(this).parent().submit();
		}
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

          <sec:authentication var="office" property="principal" />


<sec:authorize access="isAuthenticated()">
<input id="officeId" type ="hidden" value = "${office.officeId}">
</sec:authorize>

	<div style="text-align: right; padding: 10px; margin-top: 50px;">
		<sec:authorize access="isAuthenticated()">
				
		<c:choose>
			<c:when test="${office.officeId==officeBoard.office.officeId}">
			
			<!-- 등록을 위한 -->
			<form id = "updateForm" action="/common/officeBoardRegister" method="post">
				<input type="hidden" name="officeBoardId" value ="${officeBoard.officeBoardId}">
			
			</form>
			
			
			<button class="ui primary button" id="deleteBtn"
				onclick="location.href='${pageContext.request.contextPath}/common/officeBoardDelete/${officeBoard.officeBoardId}'">
				삭제</button>
			<button class="ui primary button" id="updateBtn">
				수정</button>
			</c:when>
			
			<c:when test="${office.officeName eq '관리자'}">
			
			<button class="ui primary button" id="deleteBtn"
				onclick="location.href='${pageContext.request.contextPath}/common/officeBoardDelete/${officeBoard.officeBoardId}'">
				삭제</button>
			</c:when>
			
			
		</c:choose>
		
		</sec:authorize>
		
		<button class="ui primary button" id="list"
			onclick="location.href='${pageContext.request.contextPath}/common/community'">
			목록</button>
	</div>


	<!-- 내용 -->
	<div id="container">
		<table class="ui definition table">
			<thead>
				<tr>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="collapsing" style="text-align: center;">제목</td>
					<td>${officeBoard.title}</td>
				</tr>
				<tr>
					<td class="collapsing">작성자</td>
					<td>${officeBoard.office.officeName}
					</td>
				</tr>
				<tr>
					<div class="ui teal label">
						<i class="comment icon"></i> ${fn:length(officeBoard.replies)}
					</div>
					<div class="ui label">
						<i class="eye icon"></i> ${officeBoard.readNum}
					</div>
					<div class="ui label">
						<i class="calendar alternate outline icon"></i>
						${officeBoard.regDate}
					</div>
				</tr>



			</tbody>
		</table>

		<!-- content -->
		<div class="ui piled segment">${officeBoard.content}</div>


		<!-- btns -->
		
		<!-- comment Start -->

		<div class="ui large comments">

			<c:choose>
				<c:when test="${empty officeBoard.replies}">
			등록된 댓글이 없습니다.
		</c:when>
				<c:otherwise>
					<div>
						<span class="ui dividing header" style="font-size: 18pt">댓글
						</span><i class="gray comment icon"></i>
					</div>
					<c:forEach items="${officeBoard.replies}" var="replies">
						
								<div class="comment">
									<a class="avatar"> <i class="big user icon"></i>
									</a>
									<div class="content">
										<a class="author">${replies.office.officeName}</a>
										<div class="metadata">
											<a>${replies.regDate} </a> 
											
											
											<form class= "deleteReplyForm" action="/common/replyDelete" method="post">
												<input type ="hidden" name = "officeBoardId" value= "${officeBoard.officeBoardId}">
												<input type ="hidden" name = "repliesId" value = "${replies.replyNo}">
												
												
												
												
												
												<sec:authorize access="isAuthenticated()">
														
													<c:choose>
														<c:when test="${office.officeId==officeBoard.office.officeId}">
															<a class = "deleteReply"> 삭제 </a>
														</c:when>
													
														<c:when test="${office.officeName eq '관리자'}">
															<a class = "deleteReply"> 삭제 </a>
														</c:when>
													
													
													</c:choose>
												
												</sec:authorize>
												 
											</form>
											
											
										</div>
										<div class="text">${replies.reply}</div>
							
									</div>

								</div>
								
								
							
					</c:forEach>

				</c:otherwise>
			</c:choose>
			<sec:authorize access="isAuthenticated()">
			<form class="ui reply form" action="/common/replyInsert" method="post">
				<div class="field">
					<input type="text" name="reply" class="textArea">
					 <input type="hidden" name="officeId" value="${office.officeId}">
					 <input type="hidden" name="officeBoardId" value="${officeBoard.officeBoardId}">
					
				</div>
				<div class="ui blue labeled submit icon button regBtn">
					<i class="icon edit"></i> 댓글 달기
				</div>

			</form>
			</sec:authorize>
		</div>
	</div>

	
	<sec:authorize access="isAuthenticated()">
	<!-- 신고 modal -->
				<div class="ui modal">
		  <i class="close icon"></i>
		  <div class="header">
		    게시글 신고하기
		  </div>
		  
		  
		  <!-- 유형 선택 -->
		 <h4 style="margin-left: 40px">신고 유형</h4>
		<div class="ui fluid selection dropdown" id="dd" style="width: 80%;margin: auto; margin-top: 30px">
		  <input type="hidden" name="user">
		  <i class="dropdown icon"></i>
		  <div class="default text">신고유형을 선택해주세요.</div>
		  <div class="menu">
		    <div class="item" data-value="1">
		      영리목적의 광고
		    </div>
		    <div class="item" data-value="2">
		    음란성/ 선정성 게시글
		    </div>
		    <div class="item" data-value="3">
		      도배 게시글/댓글
		    </div>
		    <div class="item" data-value="4">
		     개인정보 노출/사생활 침해
		    </div>
		    <div class="item" data-value="5">
		      기타
		    </div>
		  </div>
		</div>
		  <!-- 유형 선택  -->
		  
		  
		  
		  <h4 style="margin-left: 40px">신고 내용</h4>
		  <div class="image content">
		   
		   <div class="description" style="text-align: center">
		      <form action="/community/report" method="post" id="reportForm">
		      	<input type="text" name= "repContent" style = "width: 90%; height : 100px">
		      	<input type="hidden" name= "id" value ="${member.id}">
		      	<input type="hidden" name= "boardNo" value ="${community.boardNo}">
		      	<input type="hidden" id="rt" name= "repType" value ="1">
		      	<input type="hidden" name ="${_csrf.parameterName}" value ="${_csrf.token}">
		      	
		      </form>
		    </div>
		  </div>
		  <div class="actions">
		    <div class="ui button" id = "cancleBtn">취소</div>
		    <div class="ui button" id = "submitReport">신고 하기</div>
		  </div>
		</div>
	</sec:authorize>
				
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