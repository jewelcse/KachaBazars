<%@page import="java.util.Iterator"%>
<%@page import="model.CartDetailsModel"%>
<%@page import="model.UnionModel"%>
<%@page import="model.UpazillaModel"%>
<%@page import="model.ProductModel"%>
<%@page import="model.SubcategoryModel"%>
<%@page import="model.SellersProduct"%>
<%@page import="dao.AreaDao"%>
<%@page import="model.DistrictModel"%>
<%@page import="model.DivisionModel"%>
<%@page import="model.AreaModel"%>
<%@page import="model.CustomerModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="navbar.jsp" />
<jsp:include page="sidenavbar.jsp" />

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" type="text/css" href="css/explore.css">

<title>KachaBazar</title>

<script src="javascript/jquery.js"></script>




</head>
<body>

	<div class="page-info">
		<h2>
			<u>Explore Products</u>
		</h2>
	</div>

	<div class="product-container">
		<h2>Inventory Product</h2>
		<ul>

			<c:forEach items="${productList1 }" var="product">
				<li class="product-card">
					<div class="image-holder">
						<img class="product-image"
							src="images/products/${product.productImageName }" alt="Image">
						<div class="product-options">
							<div class="option">
								<a
									href="./viewproducts?action=order&productid=${product.productId}"><h4>Details</h4></a>
							</div>
						</div>
					</div>

					<div class="product-details">

						<h3>${product.productName }</h3>
						<h3>Product Price : ${product.productPrice }/=</h3>
						<h3>Government Price : ${product.productSubcategory.govtPrice }/=</h3>

					</div>

				</li>
			</c:forEach>
		</ul>
	</div>


	<div class="product-container">
		<h2>Farmer's Product</h2>

		<ul>
			<c:forEach items="${productList }" var="product">

				<li class="product-card">

					<div class="image-holder">
						<img class="product-image"
							src="images/sellerproducts/${product.productImageName }"
							alt="Image">
						<div class="product-options">
							<div class="option">
								<a
									href="./viewproducts?action=sellerorder&productid=${product.productId}"><h4>One
										click buy</h4></a>
							</div>
						</div>
					</div>


					<div class="product-details">

						<h3>${product.productName } By ${product.sellerModel.sellerFirstName }</h3>
						<h3>Product Price : ${product.productPrice }/=</h3>
						<h3>Government Price : ${product.subcategoryModel.govtPrice }/=</h3>						

					</div>

				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>