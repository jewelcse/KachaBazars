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
	<div class="navbar">
		<div class="head-navbar">
			<div class="logo">
				<h2>
					KachaBazar<span>.com</span>
				</h2>
			</div>





			<nav class="main-menu">
				<ul>
					<li class="menu-name-1"><b><a href="Homepage.jsp">Home</a></b></li>

					<li class="menu-name-1 second-option">
						<%
							if ((session.getAttribute("cid") != null)) {
						%>
						<div class="profile-image second-option">
							<a href="./profiles?action=customerprofile"><img
								alt="user-image"
								src="images/customers/${customer.customerImageName }"></a>
						</div> <%
 	} else {
 %>
						<div class="profile-image second-option">
							<a href="./customers?action=login"><img alt="user-image"
								src="images/member4.png"></a>
						</div> <%
 	}
 %>
					</li>



					<%
						if ((session.getAttribute("cid") != null)) {
					%>
					<li class="menu-name-1 second-option"><b><a
							href="./Cart?cid=${cid}&action=view">Cart</a></b></li>

					<%
						} else {
					%>
					<li class="menu-name-1 second-option"><b><a
							href="./customers?action=login">Cart</a></b></li>
					<%
						}
					%>



					<%
						if ((session.getAttribute("cid") != null)) {
					%>
					<li class="menu-name-1 second-option"><b><a
							href="./customers?action=logout">Logout</a></b></li>

					<%
						} else {
					%>
					<li class="menu-name-1 second-option"><b><a
							href="./customers?action=login">Login</a></b></li>
					<%
						}
					%>



				</ul>
			</nav>
		</div>

		<div class="search">

			<form method="post" action="./search?action=search">

				<select class="selection" name="searchtable">
					<c:forEach items="${category}" var="category">
						<option value="${category.categoryId}">${category.categoryName}</option>
					</c:forEach>
				</select> <input class="search-box" type="text" name="keyword"
					placeholder="Search on Kachabazar" style="border: none"
					required="required">
				<button class="search-button">Search</button>
			</form>
		</div>


		<nav class="sub-navbar">
			<ul>
				<li class="menu-name-2"><b><a href="./test?action=all">Buy
							From Farmers</a></b></li>





				<li class="menu-name-2"><b><a
						href="./browse?action=ourshop">Explore Kachabazar Inventory</a></b></li>
			</ul>
		</nav>
	</div>

</body>
</html>