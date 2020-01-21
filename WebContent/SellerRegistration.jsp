<%@page import="model.UnionModel"%>
<%@page import="model.UpazillaModel"%>
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller Registration</title>
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins&display=swap"
	rel="stylesheet">
<title>Products</title>
</head>
<body>

	<div id="navbar">
	
	<div class="logo">
		KachaBazar.com
		
		<a href="./pagination?action=paging">View Page</a>
	</div>
		<div class="search">
			<input class="search-box" placeholder="Type to search"> <input
				type="submit" class="search-button" value="Search">
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
							<a class="options"
								href="./subcategories?action=new">Add Sub-category</a>
					</div>
				</li>
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
				<li class="options-div"><a class="options"
					href="./demands?action=view">Explore Demands</a></li>
			</ul>
		</div>
	</div>
	
	<div class="header" align="center">
			<h2>Seller Registration</h2>
		</div>
	
	
	<div class="container">
	
		
		<form action="./sellers" method="post" enctype="multipart/form-data">
			<div class="box">
				<table>
					<tr>
						<th colspan="2" rowsapn="2">
							<div class="table-header">
								<h3>Insert Category Information</h3>
							</div>
						</th>
					</tr>
				<tr>
					<td>Seller First Name</td>
					<td><input type="text" name="sellerFirstName" required="required"></td>
				</tr>
				
				<tr>
					<td>Seller Last Name</td>
					<td><input type="text" name="sellerLastName" required="required"></td>
				</tr>
				
				<tr>
					<td>Seller Phone Number</td>
					<td><input type="text" name="sellerPhone" required="required"></td>
				</tr>
				
				<%
					DBData db = new DBData();
					AreaDao ad = new AreaDao();
					
					List<DivisionModel> divisionModels = db.getAllDivision();
					request.setAttribute("divisions", divisionModels);
				%>
				
				<tr>
					<td>Seller Division</td>
					<td>
						<select name="sellerDivision" required="required">
							<c:forEach items="${divisions}" var="division">
								<option value="${division.divisionId }">${division.divisionBanglaName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<%
					
					List<DistrictModel> districtModels = ad.getAllDistricts();
					request.setAttribute("districts", districtModels);
				%>
				
				<tr>
					<td>Seller District</td>
					<td>
						<select name="sellerDistrict" required="required">
							<c:forEach items="${districts}" var="district">
								<option value="${district.districtId }">${district.districtBanglaName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<%
					
					List<UpazillaModel> upazillaModels = ad.getAllUpazillas();
					request.setAttribute("upazillas", upazillaModels);
				%>
				
				<tr>
					<td>Seller Upazilla</td>
					<td>
						<select name="sellerUpazilla" required="required">
							<c:forEach items="${upazillas}" var="upazilla">
								<option value="${upazilla.upazillaId }">${upazilla.upazillaBangaName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<%
					
					List<UnionModel> unionModels = ad.getAllUnions();
					request.setAttribute("unions", unionModels);
				%>
				
				<tr>
					<td>Seller Union</td>
					<td>
						<select name="sellerUnion" required="required">
							<c:forEach items="${unions}" var="union">
								<option value="${union.unionId }">${union.unionBanglaName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Seller Village</td>
					<td><input type="text" name="sellerVillage" required="required"></td>
				</tr>
				
				<tr>
					<td>Seller Street</td>
					<td><input type="text" name="sellerStreet" required="required"></td>
				</tr>
				
				<tr>
					<td>Seller Holding Number</td>
					<td><input type="text" name="sellerHoldingNumber" required="required"></td>
				</tr>
				
				<tr>
					<td>Seller Date of Birth</td>
					<td><input type="date" name="sellerDOB" required="required"></td>
				</tr>
				
				<tr>
					<td>Seller Image</td>
					<td><input type="file" name="sellerImage" required="required"></td>
				</tr>
				
				<tr>
					<td>Seller NID</td>
					<td><input type="text" name="sellerNID" required="required"></td>
				</tr>
				
				<tr>
					<td>Seller Gender</td>
					<td><select name="sellerGender" required="required">
					
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
						</select></td>
				</tr>
				<tr>
					<td>Seller Password</td>
					<td><input type="password" name="sellerPassword" required="required"></td>
				</tr>
				
			</table>
				<c:if test="${action == 'reg' }">
					<input type="hidden" value="reg" name="action">
				</c:if>
				
				<input type="submit" value="submit">
					
		
		</form>
	</div>
</body>
</html>