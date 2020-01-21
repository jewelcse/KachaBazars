<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.ProductModel"%>
<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="navbar.jsp" />
<jsp:include page="sidenavbar.jsp" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/kachabazar-2.png">
<link rel="stylesheet" type="text/css" href="./css/productview.css">
<title>Kachabazar</title>
<script src="javascript/jquery.js"></script>


</head>
<body>

	<div class="page-info">
		<h2>
			<u>Product Details</u>
		</h2>
	</div>

	<div class="product-container">
		<form action="./viewproducts?pid=${product.productId}" method="post">
			<table class="product-table">

				<tr>
					<td colspan="2"><img class="product-image"
						src="images/sellerproducts/${product.productImageName}"
						alt="image"></td>
				</tr>

				<tr>
					<td colspan="2"><h1>
							<u>${product.productName}</u>
						</h1></td>
				</tr>

				<tr>
					<td class="section"><h4>Uploaded By :</h4></td>
					<td><h4>Admin</h4></td>
				</tr>

				<tr>
					<td class="section"><h4>Category :</td>
					<td><h4>${product.categoryModel.categoryName}</td>
				</tr>

				<tr>
					<td class="section"><h4>Subcategory :</td>
					<td><h4>${product.subcategoryModel.subcategoryName}</td>
				</tr>

				<tr>
					<td class="section"><h4>Price :</td>
					<td><h4>${product.productPrice}/=</td>
				</tr>

				<tr>
					<td class="section"><h4>Seller :</td>
					<td><h4>${product.sellerModel.sellerFirstName}/=</td>
				</tr>

				<tr>
					<td class="section"><h4>Description :</td>
					<td><h4>${product.productDescription}</td>
				</tr>

				<tr>
					<td colspan="2">
						<div class="option">
							<h4>
								<input placeholder="Quantity" class="input-field" type="number"
									step=".5" min=".5" name="productQuantity" required="required">
						</div>
					</td>
				</tr>
				
			<tr>
					<td colspan="2">
						<div>
							<input class="button medium blue" type="submit" name="action"
								value="Buy Product">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>