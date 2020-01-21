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

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" type="text/css" href="css/homepage.css">
<link rel="stylesheet" type="text/css" href="css/navbar.css">
<link rel="stylesheet" type="text/css" href="css/oneclickbuy.css">
<link rel="stylesheet" type="text/css" href="css/profile.css">

<title>Homepage - KachaBazar</title>

<script src="javascript/jquery.js"></script>
<script>
	$(function() {
		$("#navbar").load("navbar.jsp");
		$("#footer").load("footer.jsp");
	});
</script>

</head>
<body>

	<div id="navbar"></div>
	<h1>${name}</h1>

	<c:forEach items="${productList }" var="product">

		<img calss="product-image"
			src="images/products/${product.productImageName }"
			alt="Image">
		<a
			href="./viewproducts?action=sellerorder&productid=${product.productId }">
			<h4>One click buy</h4>
		</a>

		<h3>${product.productName }</h3>
		<h3>Product Price : ${product.productPrice }/=</h3>
		${product.productImageName }

	</c:forEach>


</body>
</html>