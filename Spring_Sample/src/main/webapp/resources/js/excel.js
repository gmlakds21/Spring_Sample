/**
 * https://sihus.tistory.com/5
 * https://jeong-pro.tistory.com/152
 */
 
var param = {};									// 검색조건 저장 하는 변수
var index = 'PNO,NAME,AGE,GENDER,PHONE,EMAIL';	// header 목록을 저장 하는 변수
var indexs = index.split(',');					// header 목록을 각각 개별적으로

// 조회버튼 클릭시 실행되는 이벤트
$('#srchBtn').click(function() {
	
	// 조회시 사용했던 검색조건을 전역변수로 저장
	param = { 
		'name' : $('#srchName').val(),
		'age' : $('#srchAge').val(),
		'gender' : $('#srchGender').val()
	}
	
 	$.ajax({
 		type : 'GET',
 		url : '/excel/readPerson.do',
 		dataType : 'json',
 		contentType : 'application/json; charset=UTF-8',
 		data : param,
 		success : function(datas) {
 			$('#infoTable').innerHTML = '';
 			var html = '';
 			for(let data of datas) {
 				html += '<tr>';
 				for(let i in indexs) {
 					html += '<td>'+ data[indexs[i]] +'</td>'
 				}
 				html += '</tr>';
 			}
 			$('#infoTable').append(html);},
 		error : function(xhr, status, error) {
 			console.log("안녕 error");
 			alert(xhr.status+" /--/ "+xhr.responseText+" /--/ "+error); }
 	})
});

// 엑셀 다운로드 버튼 클릭시 실행되는 이벤트
$('#excelDownBtn').click(function() {
	$.ajax({
		type : 'GET',
		url : '/excel/writeExcel.do',
		dataType : 'json',
		contentType : 'application/json; charset=UTF-8',
		data : param,
		success : function(datas) {
			alert("다운로드 완료");
		},
		error: function(xhr, status, error) {
 			alert(xhr.status+" /--/ "+xhr.responseText+" /--/ "+error);
		}
	})
});


