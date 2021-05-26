<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.util.*,java.io.*,java.text.*, java.net.*" %>
<%@ page import="kr.co.danal.jsinbi.HttpClient" %> 
<%@ include file="function.jsp" %>
<%

	response.setHeader( "Pragma","No-cache" );

	/********************************************************************************
	*
	* �ٳ� ��������
	*
	* - ���� �Ϸ� ������
	*
	* ���� �ý��� ������ ���� ���ǻ����� �����ø� ���񽺰��������� ���� �ֽʽÿ�.
	* DANAL Commerce Division Technique supporting Team
	* EMail : tech@danal.co.kr
	*
	********************************************************************************/
	
	/********************************************************************************
	 *
	 * XSS ����� ������ ���� 
	 * ��� ���������� �Ķ���� ���� ���� �����ϴ� ������ �߰��� ���� �ǰ� �帳�ϴ�.
	 * XSS ������� ������ ��� ���������� �����ϴ� �������� �������� �������� ��ũ��Ʈ�� ����� �� �ֽ��ϴ�.
	 * ���� ��å
	 *  - html tag�� ������� �ʾƾ� �մϴ�.(html �±� ���� white list�� �����Ͽ� �ش� �±׸� ���)
	 *  - <, >, &, " ���� ���ڸ� replace���� ���� ��ȯ�Լ��� ����Ͽ� ġȯ�ؾ� �մϴ�.
	 * 
	 ********************************************************************************/
	request.setCharacterEncoding("EUC-KR");
	String BgColor	= (String)request.getParameter("BgColor");
	String Phone	  	= (String)request.getParameter("PHONE");
	String Name =(String)request.getParameter("NAME");
	
	

	/*
	 * Get BgColor
	 */
	BgColor = GetBgColor( BgColor );
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<title>�ٳ� ��������</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
<link href="./css/style.css" type="text/css" rel="stylesheet"  media="screen" />
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script language="JavaScript" src="./js/Common.js" type="text/javascript"></script>

<script type="text/javascript">

$(document).ready(function(){
	var phone = $("#phone").val();
	var name = $("#name").val();
	
	window.AndroidBridge.resultAuth('success', phone, name);
	
});

</script>	
</head>
<body onload="changeFontSize();">
	<div class="Wrap">
    <!--HEADER START-->
        <div class="header01">
			<ul>
				<li><h1>�ٳ� ����Ȯ�� ����</h1></li>
				<li class="ci_danal">�ٳ��ΰ�</li>
			</ul>
        </div>
    <div class="step bg_<%=BgColor%>">
        <ul>
		<li><b>���� ����</b></li>
        </ul>
    </div>
    <div class="header02">
        <div class="wrap_txtsize">
            <button class="btn_minus" onClick="return false;">-</button>
            <p class="txtsize">�۾�ũ��</p>
            <button class="btn_plus" onClick="return false;">+</button>
        </div>
    </div>
    <!--//HEADER END-->
    <!--CONTENT START-->
    <div class="content">
        <div class="wrap_content"> <!--���̾��˾��� ���� ��� style="display: none;"-->
            <div class="box_style03">
				<p>���������� ���� ó���Ǿ����ϴ�.</p>
            </div>
            <ul class="notice">
                <li class="bullet">�ٳ� ������ : 1566-3355 (���� 9�� ~ 19�� ��ȭ���� / ��,��,������ �޹�)</li>
            </ul>
        </div>
        <div class="btnfucntion">
            <label for="okay" ><input id="okay" class="bg_<%=BgColor%>" type="button" value="Ȯ��" /></label>
        </div>
        <ul class="certification">
            <li class="wau">�����ټ� ������ũ</li>
        </ul>
    </div>
    <!--//CONTENT END-->
    <!--BOARD START-->
    <div class="board">
	<ul>
		<li class="field">��������</li>
		<li class="value">�ٳ� ���������� �̿����ּż� �����մϴ�. (���� 1566-3355)</li>
	</ul>
    </div>
    <!--//BOARD END-->
</div>
<form>
	<input type ="hidden" id = "phone" value= "<%=Phone%>" ></input>
	<input type ="hidden" id = "name" value= "<%=Name%>" ></input>
</form>
</body>
</html>