<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div id="sideContent">
			<ul>
				<c:forEach items="${comments}" var="comment">
				<li>${comment.name} said:
					<p>${comment.content}</p>
					 </li>
				</c:forEach>
			</ul>
		</div>
		<div id="mainContent">
			<hgroup>
				<h1>${article.title}</h1>
				<h6>Written the ${article.pubDate} by ${author.firstName} ${author.lastName}</h6>
				<h4>${article.subTitle}</h4>
			</hgroup>
			<div>${article.content}</div>
		</div>