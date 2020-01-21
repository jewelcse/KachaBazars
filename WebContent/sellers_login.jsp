<%@page import="model.CustomerModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.ProductModel"%>
<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
<title>Login</title>
</head>
<body>

	<div class="menu-bar">
			<ul>
				<li class="logo">Kachabazar.com</li>
				<li>	
			</ul>
		</div>
	</div>
	
	<div class="header">
		<h2>Log In to Sell</h2>
		</div>


	<div class="container">
		<form action="./sellers?action=login" method="post">

			<script>
				history.forward();
			</script>
			<%
				response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "no-store");
				response.setHeader("Expires", "0");
				session.invalidate();
			%>

			<div class="add">
				<table>
					<tr>
						<th colspan="2"><h3>Log In</h3></th>
					</tr>
					<tr>
						<td><input class="input-box test" type="text" name="sellerPhone" placeholder="Phone Number" required="required"></td>
					</tr>


					<tr>
						<td><input class="input-box test" type="text" placeholder="Password" name="sellerPassword" required="required"></td>
					</tr>

					<tr>
						<td><c:if test="${action=='login'}">
								<input type="hidden" value="login" name="action">
							</c:if></td>
					</tr>
				</table>
				<div class="submit-button">
					<input type="submit" value="Submit">
				</div>
			</div>
		</form>
	</div>

</body>
</html>