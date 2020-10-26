<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table talbe-hober">
	  	<tr>
	  		<td>Num</td>
	  		<td>Writer</td>
	  		<td>Contents</td>
	  		<td>Date</td>	
	  	</tr>
	  	
	  	<c:forEach items="${lists}" var="dto">
	  		<tr>
	  			<td>${dto.num}</td>
	  			<td>${dto.writer}</td>
	  			<td>${dto.contents}</td>
	  			<td>${dto.regDate}</td>
	  			<td><button title="${dto.num}" class="btn btn-danger del">DEL</button></td>
	  		</tr>
	  	</c:forEach>
</table>
