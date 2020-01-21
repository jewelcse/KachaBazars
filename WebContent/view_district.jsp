<%@page import="dao.AreaDao"%>
<%@page import="model.DistrictModel"%>
<%@page import="model.DivisionModel"%>
<%@page import="model.AreaModel"%>
<%@page import="model.CustomerModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Areas</title>
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>

	<div id="navbar">
		
		<div class="logo">
			KachaBazar.com
		</div>
		<div class="search">
			<input class="search-box" placeholder="Type to search"> <input type="submit" class="search-button" value="Search">
		</div>
		<div class="menu-items">
			<a class="active" href="javascript:void(0)">Home</a> 
			<a href="">Profile</a> 
			<a href="">Notification</a>
		</div>
	</div>
	
	

	<div class="wrapper-box">
		<div class="side-bar">
			<h2>Menu</h2>
			<ul>
				<li class="options-div"><a class="options"
					href="./orders?action=view">Dashboard</a></li>
				<li class="options-div" id="product"><a class="options"
					href="#product">Products</a>
					<div class="sub-menu">
						<a href="./products?action=new">Add Products</a> <a
							href="./products?action=view">View Products</a>
					</div></li>
				<li class="options-div" id='category'><a class="options"
					href="#category">Category</a>
					<div class="sub-menu">
						<a href="./categories?action=new">Add Category</a> <a
							href="Category.jsp">View Category</a>
					</div></li>
				<li class="options-div" id="area"><a class="options"
					href="#area">Areas</a>
					<div class="sub-menu">
						<a href="./areas?action=new">Add Areas</a> <a
							href="./areas?action=view">View Areas</a>
					</div></li>
				<li class="options-div" id="sellers"><a class="options"
					href="#sellers">Sellers</a>
					<div class="sub-menu">
						<a href="./sellers?action=new">Add Sellers</a> <a
							href="./sellers?action=view">View Sellers</a>
					</div></li>
				<li class="options-div"><a class="options"
					href="./customers?action=view">Customers</a></li>
				<li class="options-div" id="deliverer"><a class="options"
					href="#deliverer">Delivery Persons</a>
					<div class="sub-menu">
						<a href="./deliveries?action=add">Add Deliverers</a> <a
							href="./deliveries?action=view">View Deliverers</a>
					</div></li>
			</ul>
		</div>
	</div>
	<div class="header">
		<h2>Districts</h2>
	</div>
		
		<%			
			DBData db = new DBData();
			AreaDao ad = new AreaDao();
			if(request.getAttribute("divId").toString() != null)
			{
				int divId = Integer.parseInt(request.getAttribute("divId").toString());
				System.out.println(divId);
				List<DistrictModel> districtModels = ad.getDistrictByDivisionId(divId);
				
				request.setAttribute("districts", districtModels);
			}
			
		%>
	<div class="container-box big">
		<table align="center">
		
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th colspan="2">Action</th>
			</tr>
	 		<c:forEach items= "${districts}" var="area">
			<tr>
				<td>${area.districtId}</td>
			<td><a href="./areas?action=viewdis&disId=${area.districtId}">${area.districtBanglaName}</a></td>
				<td>
					<a class="blue-button small" href="./areas?action=update&aid=${area.districtId}">Edit</a>
					<a class="red-button small" href="./areas?action=delete&aid=${area.districtId}">Delete</a>
				</td>
			</tr>
			</c:forEach> 
		</table>
	</div>
</body>
</html>