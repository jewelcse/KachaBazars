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
<title>Testing</title>
</head>
<body>

	<a href="./test?action=ourshop"> Buy from our inventory</a>
	<a href="./test?action=union"> Buy from Your Union</a>
	<a href="./test?action=upazilla"> Buy from Your Upazilla</a>
	<a href="./test?action=district"> Buy from Your District</a>
	<a href="./test?action=division"> Buy from Your Division</a>
	
	
	
	
	<div>
		<div align="center">
		<h1>Union</h1>
		<span>
			<c:forEach items="${Unionproducts}" var="unionproduct">
			<p style="display: inline;">	${unionproduct.productName }
			<img alt="" src="images/sellerproducts/${unionproduct.productImageName }" height="200px" width="200px">
				${unionproduct.productPrice }
				Uploaded by ${unionproduct.sellerModel.sellerFirstName }
				<a href="./viewproducts?action=sellerorder&productid=${unionproduct.productId }"> View Product</a>
				</p>
			</c:forEach>
		</span>
		</div>
		
		<div align="center">
		<h1>Upazilla</h1>
		<span>
			<c:forEach items="${Upazillaproduct}" var="Upazillaproduct">
			<p style="display: inline;">	${Upazillaproduct.productName }
			<img alt="" src="images/sellerproducts/${Upazillaproduct.productImageName }" height="200px" width="200px">
				${Upazillaproduct.productPrice }
				Uploaded by ${Upazillaproduct.sellerModel.sellerFirstName }</p>
			</c:forEach>
		</span>
		</div>
		
		<div align="center">
		<h1>District</h1>
		<span>
			<c:forEach items="${Districtproduct}" var="Districtproduct">
			<p style="display: inline;">	${Districtproduct.productName }
			<img alt="" src="images/sellerproducts/${Districtproduct.productImageName }" height="200px" width="200px">
				${Districtproduct.productPrice }
				Uploaded by ${Districtproduct.sellerModel.sellerFirstName }</p>
			</c:forEach>
		</span>
		</div>
		
		<div align="center">
		<h1>Division </h1>
		<span>
			<c:forEach items="${Divisionproduct}" var="Divisionproduct">
			<p style="display: inline;">	${Divisionproduct.productName }
			<img alt="" src="images/sellerproducts/${Divisionproduct.productImageName }" height="200px" width="200px">
				${Divisionproduct.productPrice }
				Uploaded by ${Divisionproduct.sellerModel.sellerFirstName }</p>
			</c:forEach>
		</span>
		</div>
		
	
	</div>

</body>
</html>