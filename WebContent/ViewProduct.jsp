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

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="icon" href="images/kachabazar-2.png">
<link rel="stylesheet" type="text/css" href="./css/productview.css">
<script src="javascript/jquery.js"></script>

<title>Kachabazar</title>



</head>
<body>


	<div class="page-info">
		<h2>
			<u>Product Details</u>
		</h2>
	</div>

	<div class="product-container">
		<form
			action="./viewproducts?pid=${product.productId}"
			method="post">
			<table class="product-table">
				<tr>
					<td colspan="2"><img class="product-image"
						src="images/products/${product.productImageName}" alt="image">
					</td>
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
					<td><h4>${product.productCategory.categoryName}</td>
				</tr>

				<tr>
					<td class="section"><h4>Subcategory :</td>
					<td><h4>${product.productSubcategory.subcategoryName}</td>
				</tr>

				<tr>
					<td class="section"><h4>Price :</td>
					<td><h4>${product.productPrice}/=</td>
				</tr>

				<tr>
					<td class="section"><h4>Government Price :</td>
					<td><h4>${product.governmentPrice}/=</td>
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
					<td colspan="2"><input class="button medium red" type="submit"
						name="action" value="Add to Cart">
						</h4></td>
				</tr>

				<tr>
					<td colspan="2">
						<div>
							<input class="button medium blue" type="submit" name="action"
								value="One Click Buy">
						</div>
					</td>
				</tr>


			</table>
		</form>
	</div>
</body>
</html>