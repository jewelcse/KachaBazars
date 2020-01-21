<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
	<title>Home</title>
</head>
<body>

	
	<div class="menu-bar">
			<ul>
			<li class="logo">Kachabazar.com</li>
			<li>
				<div class="search">
					<input class="search-box" placeholder="Type to search"> <input
						type="submit" class="search-button" value="Search">
				</div>
			</li>
			<li class="home">
				<a href="Index.jsp">Home</a>
			</li>
			<li class="profile">
				<a href="admin-profile.html">Profile</a>
			</li>
			<li class="logout"><a
				href="./customers?action=logout">Logout</a>
			</li>
			<li class="notification"><a
				href="#">Notification</a>
			</li>
		</ul>
	</div>
	
	<div class="sub-menu-bar">
			<ul>
			<li><a href="./home?action=view">Visit Home page</a></li>
			<li>
				<div class="search">
					<input class="search-box" placeholder="Type to search"> <input
						type="submit" class="search-button" value="Search">
				</div>
			</li>
			<li class="home">
				<a href="Index.jsp">Home</a>
			</li>
			<li class="profile">
				<a href="admin-profile.html">Profile</a>
			</li>
			<li class="logout"><a
				href="./customers?action=logout">Logout</a>
			</li>
			<li class="notification"><a
				href="#">Notification</a>
			</li>
		</ul>
	</div>
	<a href="./demands?action=demand">view demand</a>
	<h2 align="center">Category</h2>
	<a href="./categories?action=new">Add New Category</a>
	<a href="./subcategories?action=new">Add New Sub Category</a>
	
	<a href="./customers?action=view">Customers</a>
	<a href="./sellers?action=view">Sellers</a>
	<a href="./deliveries?action=view">Delivery Persons</a> 
		
	<a href="./sellers?action=login">Sellers Login</a>
	<a href="./customers?action=reg">Customer Registration</a>
	<a href="./customers?action=login">Customer Login</a>
	
	<%
	DBData db = new DBData();
	List<CategoryModel> categoryModel = db.getAllCategories();
	request.setAttribute("categories", categoryModel);
	%>

</body>
</html>