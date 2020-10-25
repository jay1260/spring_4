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
	<h3>Member Join Page</h3>
	<form id="frm" action="./memberJoin" method="post">
	    <div class="form-group">
	      <label for="id">Id:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id">
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
var pw1 = document.getElementById("pw");
var pw2 = document.getElementById("pw2");
var pwCheck = document.getElementById("pwCheck");

pw2.addEventListener('blur', function() {
	if(pw1.value != pw2.value){
		var str = "PW가 일치하지 않습니다.";
		pwCheck.innerHTML = str;
	}else{
		var str = "멋진 비밀번호";
		pwCheck.innerHTML = str;
	}
});
	
</script>


</body>
</html>