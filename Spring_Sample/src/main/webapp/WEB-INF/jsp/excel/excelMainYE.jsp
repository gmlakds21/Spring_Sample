<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



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
	
		<div class="srch">
			<span> 이름
				<select>
					<option> 홍길동 </option>
					<option> 조승희 </option>
				</select>
			</span>
			<span> 성별
				<select>
					<option> 20 </option>
					<option> 19 </option>
				</select>
			</span>
			<button> 조회 </button>
		</div>
		
		<div class="infoDiv">
			<span class="infoTitle"> 통계 정보 </span>
			<form action="downloadYE.do" method="post">
			<input type="submit" value="다운로드">
			</form>
			<table>
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
					<th> 이메일</th>
				</tr>
		 	<c:forEach var="person" items="${people}">
					<tr>
						<th> ${person.pno} </th>
						<th> ${person.name} </th>
						<th> ${person.age} </th>
						<th> ${person.gender}</th>
						<th> ${person.phone} </th>
						<th> ${person.email}</th>
					</tr>
			</c:forEach>
			</table>
		</div>
	
		<div class="infoDiv">
			<span class="infoTitle"> 엑셀 업로드 </span>
			<span class="excelForm">
				<form action="fileYE.do" method="post" enctype="multipart/form-data">
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
<%-- 				<c:forEach var="Person" items="${Persons}">
					<tr>
						<td> ${Person.pno} </td>
						<td> ${Person.check} </td>
						<td> ${Person.name} </td>					
						<td> ${Person.age} </td>					
						<td> ${Person.gender} </td>					
						<td> ${Person.phone} </td>					
						<td> ${Person.email} </td>					
					</tr>
				</c:forEach> --%>
			</table>
		</div>
	</div>
<script src="${path}/resources/js/excelYE.js">





</script>
</body>
</html>