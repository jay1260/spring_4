<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h1>${board} Update Page</h1>
	<form action="./${board}Update" method="post">
	<input type="hidden" name="num" value="${dto.num}"> 
	
	<div class="form-group">
		<label for="title">Title:</label>
		<input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" value="${dto.title}">
	</div>
	
	<div class="form-group">
		<label for="writer">Writer:</label>
		<input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer" value="${dto.writer}" readonly="readonly">
	</div>
	
	<div class="form-group">
		<label for="contents">Contents:</label>
		<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
	</div>
	
	<button type="submit" class="btn btn-default">Update</button>
	</form>
</div>
<script type="text/javascript">
	$("#contents").summernote({
		height : 300
	});
	$("#contents").summernote('code','${dto.contents}');
</script>	
</body>
</html>