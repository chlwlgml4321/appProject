    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Phonestor Admin</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      
  <!-- 유저관리 Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        유저 관리
      </div>

      <!-- 유저 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/common/user">
          <i class="fas fa-fw fa-table"></i>
          <span>회원</span></a>
          
      </li>
      
      
       <!-- 블랙리스트 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/common/blackList">
          <i class="fas fa-fw fa-table"></i>
          <span>BlackList</span></a>
      </li>
      
      
      <!-- 대기중인고객 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/common/inactiveUser">
          <i class="fas fa-fw fa-table"></i>
          <span>대기중인 고객</span></a>
      </li>
      
      
      <!-- point 관리 -->
      <!-- <li class="nav-item">
        <a class="nav-link" href="/admin/point">
          <i class="fas fa-fw fa-table"></i>
          <span>포인트 관리</span></a>
      </li>   -->
      
      
     <!-- 구분선 -->
      <hr class="sidebar-divider">
      
      
      
      <!-- Heading -->
      <div class="sidebar-heading">
        신청서 관리
      </div>
      
      <!-- 신청서 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/common/application">
          <i class="fas fa-fw fa-table"></i>
          <span>신청서</span></a>
          
      </li>
      
      
      <!-- 구분선 -->
      <hr class="sidebar-divider">
      
  <!-- Heading -->
      <div class="sidebar-heading">
        지역 관리
      </div>

      <!-- 지역 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/admin/region">
          <i class="fas fa-fw fa-table"></i>
          <span>지역</span></a>
          
      </li>
      
      
      <!-- 지역 등록 -->
      <li class="nav-item">
        <a class="nav-link" href="/admin/regionInsert">
          <i class="fas fa-fw fa-table"></i>
          <span>지역 등록</span></a>
          
      </li>  
      
      
      <!-- 구분선 -->
      <hr class="sidebar-divider">
      
  <!-- Heading -->
      <div class="sidebar-heading">
        지점 관리
      </div>

      <!-- 지점 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/admin/office">
          <i class="fas fa-fw fa-table"></i>
          <span>지점</span></a>
          
      </li>
      
      
      <!-- 지역 등록 -->
      <li class="nav-item">
        <a class="nav-link" href="/admin/officeRegister">
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
        <a class="nav-link" href="/admin/callingPlan">
          <i class="fas fa-fw fa-table"></i>
          <span>요금제</span></a>
          
      </li>
      
      
      <!-- 요금제 등록 -->
      <li class="nav-item">
        <a class="nav-link" href="/admin/callingPlanRegister">
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
        <a class="nav-link" href="/admin/wiredGoods">
          <i class="fas fa-fw fa-table"></i>
          <span>유선 상품</span></a>
          
      </li>
      
      <!-- 카드 결합 -->
      <li class="nav-item">
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
        <a class="nav-link" href="/admin/device">
          <i class="fas fa-fw fa-table"></i>
          <span>디바이스</span></a>
          
      </li>
      
      <!-- 상품 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/common/products">
          <i class="fas fa-fw fa-table"></i>
          <span>특가 상품</span></a>
          
      </li>  
      
      <!-- 방문 고객 상품 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/admin/guestProduct">
          <i class="fas fa-fw fa-table"></i>
          <span>방문고객 상품</span></a>
          
      </li>  
      
     <!-- 추천 상품 관리 -->
      <li class="nav-item">
        <a class="nav-link" href="/admin/recommendation">
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
        <a class="nav-link" href="/admin/review">
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
        <a class="nav-link" href="/admin/banner">
          <i class="fas fa-fw fa-table"></i>
          <span>배너</span></a>
      </li>
      
       <hr class="sidebar-divider">
      
      <!-- Heading -->
      <div class="sidebar-heading">
        공지사항 관리
      </div>
      
      <li class="nav-item">
        <a class="nav-link" href="/admin/notice">
          <i class="fas fa-fw fa-table"></i>
          <span>전체 공지사항</span></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="/common/officeNotice">
          <i class="fas fa-fw fa-table"></i>
          <span>지점 중고 게시판</span></a>
      </li>
      
      
     
          <!-- 구분선 -->
      <hr class="sidebar-divider">
      
      <!-- Heading -->
      <div class="sidebar-heading">
        커뮤니티 관리
      </div>
      
      <li class="nav-item">
        <a class="nav-link" href="/common/community">
          <i class="fas fa-fw fa-table"></i>
          <span>지점 게시판</span></a>
      </li>
      
      
      
      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->