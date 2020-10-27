<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>	
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	<div class="container">
		<h1>Memo Page</h1>
		<div>
			<div class="form-group">
				<label for="writer">Writer:</label>
				<input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    	</div>
	    
	    <div class="form-group">
	    	<label for="contents">Contents:</label>
	    	<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
	    </div>
	    
	    <div class="form-group">
	   		 <button type="submit" class="btn btn-default" id="write">Write</button>
	    </div>
		
		</div>
		
		<div>
			<table id="result" class="table talbe-hober">
			
			</table>
		</div>
		<button class="btn btn-danger" id="more">더보기</button>
	</div>
	
<script type="text/javascript">
	var curPage = 1; // curPage를 1번으로 시작
	getList(); // getList 함수 호출
	
	// ********************** More *************************
	$("#more").click(function() {
		curPage++;
		getList();
	});
	
	// ********************** DEL **************************
	$("#result").on("click",".del", function() {
		var num = $(this).attr("title");
		
		$.ajax({
			url:"./memoDelete",
			type:"POST",
			data:{num:num},
			success: function(data) {
				data=data.trim();
				if(data>0){
					alert("삭제 완료");
					$("#result").html(''); // result html 초기화 시켜주기
					curPage=1; // curPage 1번으로 초기화
					getList(); // getList 함수 호출
				}else{
					alert("Delete Fail");
				}
			}
		});
	
	});
	
	//************************************
	$("#write").click(function() {
		var writer = $("#writer").val();
		var contents = $("#contents").val();
		
		$.ajax({
			url:"./memoWrite",
			type:"POST",
			data:{writer:writer, contents:contents},
			success : function(result) {
				alert(result);
				$("#writer").val('');
				$("#contents").val('');
				$("#result").html(''); // result html 초기화시켜주기
				curPage=1; // Page 1번으로 초기화
				getList(); // getList 함수호출
			}
		});
		
		
	});
	//****************getList 함수선언*********************
	
	function getList() {
		
		$.ajax({
			url:"./memoList",
			type:"GET",
			data:{curPage:curPage}, // curPage를 파라미터로 
			success: function(data) {
				$("#result").append(data); 
				// 요소 내부 마지막 부분에 값을 추가한다.
			}
		});	
	}
	
</script>
	
</body>
</html>