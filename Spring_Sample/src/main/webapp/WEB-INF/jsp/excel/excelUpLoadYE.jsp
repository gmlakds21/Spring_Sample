<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>엑셀업로드</title>
</head>
<body>

	엑셀업로드
	
	<form action="file.do" method="post" enctype="multipart/form-data">
		<input type = "file" name="file" id="file">
		<input type = "submit" value="전송">
	</form>
	
</body>
</html>