<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> 엑셀업로드 </title>
	<link rel="stylesheet" href="${path}/resources/css/excel.css">
</head>
<body>
	<span> [EXCEL] 엑셀업로드 다운로드 테스트 </span>
	<hr>
	<div class="backPage">
	
		<form id="srchOrder" class="srch">
			<span> 이름
				<select id="srchName">
					<option value=""> 전체 </option>
					<c:forEach var="name" items="${names}">
						<option> ${name} </option>
					</c:forEach>
				</select>
			</span>
			<span> 나이
				<select id="srchAge">
					<option value=""> 전체 </option>
					<c:forEach var="age" items="${ages}">
						<option> ${age} </option>
					</c:forEach>
				</select>
			</span>
			<span> 성별
				<select id="srchGender">
					<option value=""> 전체 </option>
					<c:forEach var="gender" items="${genders}">
						<option> ${gender} </option>
					</c:forEach>
				</select>
			</span>
			<button type="button" id="excelDownBtn"> 엑셀 다운로드 </button>
			<button type="button" id="srchBtn"> 조회 </button>
		</form>
		
		<div class="infoDiv">
			<span class="infoTitle"> 통계 정보 </span>
			<table id="infoTable">
				<colgroup>
					<col style="width:100px">
					<col style="width:19%">
					<col style="width:19%">
					<col style="width:19%">
					<col style="width:19%">
					<col style="width:19%">
				</colgroup>
				<tr>
					<th> NO </th>
					<th> 이름 </th>
					<th> 나이 </th>
					<th> 성별 </th>
					<th> 전화번호 </th>
					<th> 이메일 </th>
				</tr>
			</table>
		</div>
	
		<div class="infoDiv">
			<span class="infoTitle"> 엑셀 업로드 </span>
			<span class="excelForm">
				<form action="readFile.do" method="post" enctype="multipart/form-data">
					<input type = "file" name="file" id="file">
					<input type = "submit" value="전송">
				</form>
			</span>
			<table>
				<colgroup>
					<col style="width:100px">
					<col style="width:100px">
					<col style="width:18%">
					<col style="width:18%">
					<col style="width:18%">
					<col style="width:18%">
					<col style="width:18%">
				</colgroup>
				<tr>
					<th> NO </th>
					<th> <input type="checkbox"> </th>
					<th> 이름 </th>
					<th> 나이 </th>
					<th> 성별 </th>
					<th> 전화번호 </th>
					<th> 이메일 </th>
				</tr>
			</table>
		</div>
	</div>
	<p>${path}</p>
	<script type="text/javascript" src="${path}/resources/js/jquery-3.6.0.min.js"></script>
	<script src="${path}/resources/js/excel.js"></script>
</body>
</html>