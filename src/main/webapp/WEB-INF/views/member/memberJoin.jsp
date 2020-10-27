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
	    </div>
	    <div id="pwCheck"></div>
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
	    </div>
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
	    </div>
	    <input type="button" class="btn btn-primary" value="Submint" id="btn">
	    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
<script type="text/javascript">
	
	$("#id").blur(function() {
		var id = $(this).val();
		
		$.get("./memberIdCheck?id="+id, function(data) {
			//a 사용가능, b 사용불가
			//true 사용가능, false 사용불가
			//0 사용가능, 1 사용불가
			data = data.trim();
			var str = "중복된 아이디입니다.";
			$("#idResult").addClass("idCheck1");
			if(data == 0){
				str = "멋진 아이디입니다.";
				$("#idResult").removeClass("idCheck1").addClass("idCheck0");
			}
			$("#idResult").html(str);
		});
	});
	
</script>


</body>
</html>