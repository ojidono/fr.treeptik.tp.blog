<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div id="mainContent">
			<hgroup>
				<h1>${comment.name}</h1>
				<h6>Written the ${comment.pubDate} by ${comment.email}</h6>
				<h4>${comment.content}</h4>
			</hgroup>
			<a href="../article/detail?id=${article.id}">${article.title}</a>
			<p>${article.subTitle}</p>
		</div>