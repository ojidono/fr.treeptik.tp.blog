<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="app bg-default horizontal-layout">
	<table class="table table-striped list no-m">
		<tbody>
			<c:forEach items="${categories}" var="category">
				<tr><td><a href="detail?id=${category.id}">${category.name}</a></td></tr>
			</c:forEach>
		</tbody>
	</table>
</div>