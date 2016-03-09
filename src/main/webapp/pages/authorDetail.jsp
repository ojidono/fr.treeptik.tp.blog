<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div id="mainContent">
			<hgroup>
				<h1>${author.firstName} ${author.lastName}</h1>
				<h6>${author.email}</h6>
			</hgroup>
			<ul>
				<c:forEach items="${articles}" var="article">
					<li><a href="../article/detail?id=${article.id}">${article.title}</a>
						<p>${article.subTitle}</p>
					</li>
				</c:forEach>
			</ul>
		</div>