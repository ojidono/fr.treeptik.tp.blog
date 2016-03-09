<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="app bg-default horizontal-layout">
	<table class="table table-striped list no-m">
		<tbody>
			<c:forEach items="${authors}" var="author">
				<tr><td><a href="detail?id=${author.id}">${author.firstName} ${author.lastName} (${author.email})</a></td></tr>
			</c:forEach>
		</tbody>
	</table>
</div>