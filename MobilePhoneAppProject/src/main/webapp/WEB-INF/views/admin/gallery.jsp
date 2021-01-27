<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>파일 업로드</h1> <hr>

    <form action="${pageCotext.request.contextPath}/app/registerReview" method="post" enctype="multipart/form-data">
        제목 : <input type="text" name="title"> <br>
        파일 : <input type="file" name="file"> <br>
        
        <input type ="hidden" name="content" value="1">
        <input type ="hidden" name="rate" value="3.0">
        <input type ="hidden" name="officeId" value="1">
        <input type ="hidden" name="memberId" value="1">
        <input type ="hidden" name="carrierId" value="1">
        <input type ="hidden" name="deviceId" value="1">
        <input type ="hidden" name="activationType" value="1">
        
        <button>등록하기</button>
    </form>

<img alt="" src="https://phonestorimage.s3.ap-northeast-2.amazonaws.com/review_image_24.png">
</body>
</html>