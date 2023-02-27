<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list }" var="b" varStatus="i">
			<tr>
				<td>${((pageMarker.totalCount - i.index - 1) -  ((pageMarker.viewPage-1)*pageMarker.displayPageNum))+1}</td>
				<td><a href="${b.bno }">${b.title }[${b.replyCnt }]</a></td>
				<td>${b.writer }</td>
				<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" /></td>
				<td>${b.readCount }</td>
			</tr>
		</c:forEach>
	</table>
	<div">
		<c:if test="${pageMarker.prev }">
			<a href="1">[처음]</a>
			<a href="${pageMarker.startPage-1 }"><<</a>
		</c:if>
		<c:forEach begin="${pageMarker.startPage }"
			end="${pageMarker.endPage }" var="page">
			<a href="${page }">${page }</a>
		</c:forEach>
		<c:if test="${pageMarker.next }">
			<a href="${pageMarker.endPage+1 }">>></a>
			<a href="${pageMarker.realEndPage }">[마지막]</a>
		</c:if>
	</div>
</body>
</html>