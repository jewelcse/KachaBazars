<%@page import="model.DistrictModel"%>
<%@page import="model.DivisionModel"%>
<%@page import="dao.AreaDao"%>
<%@page import="model.CustomerModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.ProductModel"%>
<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	if (session.getAttribute("cid") != null) {
		String login = (String) session.getAttribute("message");
		String name = (String) session.getAttribute("name");
		
		DBData db = new DBData();
		
		int cid = Integer.parseInt(session.getAttribute("cid").toString());
		
		
		CustomerModel customerModel = db.getCustomerById(cid);
		
		request.setAttribute("customer", customerModel);
		request.setAttribute("login", login);
		request.setAttribute("name", name);
	}
	
%>

<%
			DBData db = new DBData();
			List<CategoryModel> categoryModels = db.getAllCategories();
			request.setAttribute("category", categoryModels);

%>
			
		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/nav.css">



</head>
<body>
	<div class="menubar">
		<div class="head-navbar">
			<div class="logo">
				<h2>KachaBazar<span>.com</span></h2>
			</div>
			
			
			
			
			
			<nav class="main-menu">
				<ul>
					<li class="menu-name-1"><b><a href="Homepage.jsp">Home</a></b></li>
					
				


					<c:if test="${login=='login'}">
						<li class="menu-name-1"><b><a
								href="./Cart?cid=${cid}&action=view">Cart</a></b></li>

					</c:if>
					<c:if test="${login!='login'}">
						<li class="menu-name-1"><b><a
								href="./customers?action=login">Cart</a></b></li>
					</c:if>


					<c:if test="${login=='login'}">
						<li class="menu-name-1"><b><a
								href="./customers?action=logout">Logout</a></b></li>
					</c:if>
					<c:if test="${login!='login'}">
						<li class="menu-name-1"><b><a
								href="./customers?action=login">Login</a></b></li>
					</c:if>


				</ul>
			</nav>
		</div>
		</div>

</body>
</html>