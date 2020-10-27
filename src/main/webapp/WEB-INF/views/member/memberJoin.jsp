<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	.idCheck0{
		color: blue;
	}
	.idCheck1{
		color: red;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h3>Member Join Page</h3>
	<form id="frm" action="./memberJoin" method="post">
	    <div class="form-group">
	      <label for="id">Id:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id">
	  	  <div id="idResult"></div>	
	    </div>
	    
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter Password" name="pw">
	    </div>
	    <div class="form-group">
	      <label for="pw2">Password:</label>
	      <input type="password" class="form-control" id="pw2" placeholder="Enter Password" name="pw2">
	      <div id="pwResult"></div>	
	    </div>
	    
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control empty"  id="name" placeholder="Enter Name" name="name">
	      <div class = "emptyResult"></div>	
	    </div>
	    
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="text" class="form-control empty" id="email" placeholder="Enter Email" name="email">
		  <div class = "emptyResult"></div>	    
 	    </div>
	    <input type="button" class="btn btn-default" id="join" value="Join">
  </form>
</div>
<script type="text/javascript">
	var idCheck = false;
	var pwCheck = false;
	var emptyCheckResult = true;
	
	// ***********************join click *****************
	$("#join").click(function() {
			emptyCheck();
			if(idCheck && pwCheck && emptyCheckResult){
				// 중.체크 , 사용가능 ID
				alert("OK");
			}else{
				// 중.노체크, 중복ID
				alert("NO");
			}
		//$("#frm").submit();
	});
	
	// ******************* empty check ***********************
	function emptyCheck() {
		emptyCheckResult = true;
		$(".emptyResult").removeClass("idCheck1");
		$(".emptyResult").html('');
		$(".empty").each(function() {
			var data = $(this).val();
			if(data==''){
				emptyCheckResult = false;
				$(this).next().html("필수 항목입니다.");
				$(".emptyResult").addClass("idCheck1");
			}
		});
		
	}
	

	// *********************** pw Check ****************	
	$("#pw2").blur(function() {
		var pw = $("#pw").val();
		var pw2 = $(this).val();
		pwCheck = false;
		
		if(pw2==''){
			$("#pwResult").html("비밀번호를 입력하세요.");
			$("#pwResult").removeClass("idCheck0").addClass("idCheck1");
		}else if(pw==pw2){
			$("#pwResult").html("비밀번호가 일치합니다.");
			$("#pwResult").removeClass("idCheck1").addClass("idCheck0");
			pwCheck = true;
		}else{
			$("#pwResult").html("비밀번호가 일치하지 않습니다.");
			$("#pwResult").removeClass("idCheck0").addClass("idCheck1");
		}
		
	});
	
	// ************************* id Check *****************
	$("#id").blur(function() {
		idCheck = false; // 한번더 초기화 시켜주기
		var id = $(this).val();
		if(id !=''){
		
		$.get("./memberIdCheck?id="+id, function(data) {
			//a 사용가능, b 사용불가
			//true 사용가능, false 사용불가
			//0 사용가능, 1 사용불가
			data = data.trim();
			var str = "중복된 아이디입니다.";
			
			$("#idResult").removeClass("idCheck0").addClass("idCheck1");
			if(data == 0){
				str = "멋진 아이디입니다.";
				$("#idResult").removeClass("idCheck1").addClass("idCheck0");
				idCheck = true;
			}
			$("#idResult").html(str);
			
		});
		}else{
			$("#idResult").html("아이디는 필수 항목입니다.");
			$("#idResult").removeClass("idCheck0").addClass("idCheck1");
		}
	});
	
	
</script>


</body>
</html>