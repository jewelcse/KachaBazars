<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.BidModel"%>
<%@page import="model.SellerModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<%
		System.out
				.println(session.getAttribute("cid") + " line 33 home " + (String) session.getAttribute("message"));
		if (session.getAttribute("cid") != null) {
			String login = (String) session.getAttribute("message");
			request.setAttribute("login", login);
		}
	%>


	<div align="center">
		<h1>Hi ${sellers.sellerFirstName}</h1>
		<h3>Welcome to your shop</h3>
	</div>
	<div>
		<ul>
			<li><a href="./sellersshop?action=add">Add product</a></li>
			<li>View Product</li>
			<li>View deals</li>
			<c:if test="${login=='login'}">
				<li><a href="./sellers?action=logout">Logout</a></li>
			</c:if>
			<c:if test="${login!='login'}">
				<li><a href="./sellers?action=login">Login</a></li>
			</c:if>
		</ul>
	</div>


</body>
</html>