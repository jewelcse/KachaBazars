
<%@page import="model.UnitModel"%>
<%@page import="model.ProductModel"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="javascript/jquery.js"></script>
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
					</div></li>
					
				<li class="options-div" id='subcategory'><a class="options"
					href="#subcategory">Subcategory</a>
					<div class="sub-menu">
						<a href="./subcategories?action=new">Add Subcategory</a> <a
							href="./subcategories?action=view">View Subcategory</a>
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


	<div class="header" align="center">
		<h2>Add Your Products</h2>
	</div>
	


		<div class="container">
		
		<form enctype="multipart/form-data" action="./sellersshop?action=submit" method="post">
			<div class="box">
			<table>
				<tr>
					<th colspan="2" rowsapn="2">
					<div class="table-header">
						<h3>Insert Product Information</h3>
						</div>
					</th>
				</tr>
				<tr>
				</tr>
				<tr>
					<td class="name-label">Product Name</td>
					<td><input type="text" name="productName" placeholder="Enter Product Name" value="${product.productName}" required="required"></td>
				</tr>

				<tr>
					<td class="name-label">Product Image</td>
					<td>
					
				
					       	<input type="file" name="productImage" id="file" class="upload"/>
							<label for="file">Choose a file</label>
					</td>
				</tr>
				
				
				<%
					DBData db = new DBData();
					List<UnitModel> unitModels = db.getAllUnits();
					request.setAttribute("units", unitModels);
				%>

				<tr>
					<td class="label">Unit</td>
					<td><select class="dropdown" name="unit" required="required">
							<c:forEach items="${units}" var="unit">
								<option value="${unit.unitId}">${unit.unitId}  ${unit.unit}</option>
							</c:forEach>
					</select></td>
				</tr>

				<%
				
					List<CategoryModel> categoryModel = db.getAllCategories();
					request.setAttribute("categoryioptions", categoryModel);
				%>


				<tr>
					<td class="label">Product Category</td>
					<td><select class="dropdown" name="dropdownProductCategory" required="required">
							<option value="${product.productCategory.categoryId}" >${product.productCategory.categoryName}</option>
							<c:forEach items="${categoryioptions}" var="category">
								<option value="${category.categoryId}">${category.categoryId}  ${category.categoryName}</option>
							</c:forEach>
					</select></td>
				</tr>
				
				

				
				

				<%
					DBData db2 = new DBData();
					List<SubcategoryModel> subcategoryModel = db2.getAllSubcategories();
					request.setAttribute("subcategorieoptions", subcategoryModel);
				%>

				<tr>
					<td class="name-label">Product Sub-category</td>
					<td><select class="dropdown" name="dropdownProductSubcategory" required="required">
						<option value="${product.productSubcategory.subcategoryId}">${product.productSubcategory.subcategoryName} </option>
							<c:forEach items="${subcategorieoptions}" var="subcategory">
								<option value="${subcategory.subcategoryId}">${subcategory.subcategoryId}
									${subcategory.subcategoryName}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td class="name-label">Product Price</td>
					<td><input type="text" name="productPrice" placeholder="BDT /=" value="${product.productPrice}" required="required"></td>
				</tr>
				
				
				<tr>
					<td class="name-label">Product Description</td>
					<td><input type="text" name="productDescription" placeholder="Enter Product Description" value="${product.productDescription}" required="required"></td>
				</tr>
				
				<tr>
					<td class="name-label">Product Quantity</td>
					<td><input type="text" name="productQuantity" placeholder="Enter Product Quantity" value="${product.productDescription}" required="required"></td>
				</tr>
				
				
				<tr>
			<td>
					
					
					
			</td>
			<td>
					
					        <div class="submit-button">
								<input type="submit" value="submit">
							</div>

			</td>
				</tr>
			</table>
			</div>

		</form>

	</div>


</body>


</html>