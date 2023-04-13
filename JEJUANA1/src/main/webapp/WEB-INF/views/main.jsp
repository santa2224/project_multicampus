<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>CFR(Clova Face Recognition)</h1>
	<p>얼굴과 관련된 다양한 정보를 제공하는 얼굴 감지 및 인식 API
	이미지 속 얼굴의 윤곽, 눈, 코, 입, 표정 값을 얻어 다양하게 활용할 수 있습니다.</p>
	<form id="uploadform" enctype="multipart/form-data">
		이미지선택 : <input type="file" name="image" id="image"><br>
		<button>확인</button>
	</form>
	<textarea style="width:100%; height:200px;" id="text"></textarea>
	<div id="viewer" style="border:1px solid #ddd"></div>
</body>
</html>