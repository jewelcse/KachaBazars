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
<link rel="stylesheet" href="css/sidebar.css">
</head>
<body>

	<div class="side-navbar">
		<div class="menu-1">
			<div class="menu-name-title">
				<h3>
					<u>Category</u>
				</h3>
			</div>
			
			
			<ul>
				<c:forEach items="${category}" var="category">
					<li class="menu-name-3"><a href="./explore?action=category&catName=${category.categoryName }">${category.categoryName}</a></li>
				</c:forEach>
			</ul>
		</div>

		<div class="menu-1">
			<div class="menu-name-title">
				<h3>
					<u>Divisions</u>
				</h3>
			</div>
			<%
			
			List<DivisionModel> divisionModel = db.getAllDivision();
			request.setAttribute("division", divisionModel);
			
			%>
			
			<ul>
				
					<c:forEach items="${division }" var="division">
						<li class="menu-name-3"><a href="./explore?action=divisionside&divId=${division.divisionId}">${division.divisionBanglaName}</a></li>
					</c:forEach>
				
			</ul>
		</div>
	</div>



</body>
</html>