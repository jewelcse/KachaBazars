<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<jsp:include page="navbar.jsp" />
<jsp:include page="sidenavbar.jsp" />

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<link rel="stylesheet" href="css/homepage.css">
<title>Homepage - KachaBazar</title>

<script src="javascript/jquery.js"></script>


</head>
<body>

	<%
	
	DBData db = new DBData();
	List<ProductModel> productModels = db.getFeaturedProducts();
	
	List<ProductModel> productModels2 = new ArrayList<ProductModel>();

	
	if(!productModels.isEmpty()){
		
		int length = productModels.size();
		
		
		if(length == 1 ){
			productModels2.add(productModels.get(0));
		}
		else if(length == 2 ){
			productModels2.add(productModels.get(0));
			productModels2.add(productModels.get(1));
		}
		else if(length == 3 ){
			productModels2.add(productModels.get(0));
			productModels2.add(productModels.get(1));
			productModels2.add(productModels.get(2));
		}
		else if(length == 4 ){
			productModels2.add(productModels.get(0));
			productModels2.add(productModels.get(1));
			productModels2.add(productModels.get(2));
			productModels2.add(productModels.get(3));
		}
		else if(length > 4 ){
			productModels2.add(productModels.get(length - 1));
			productModels2.add(productModels.get(length - 2));
			productModels2.add(productModels.get(length - 3));
			productModels2.add(productModels.get(length - 4));
		}
		
		request.setAttribute("product", productModels2);

		
	}
	else{
		request.setAttribute("product", productModels);
	}
	
	%>



	<%
		
		if (session.getAttribute("cid") != null) {
			String login = (String) session.getAttribute("message");
			String name = (String) session.getAttribute("name");

			request.setAttribute("login", login);
			request.setAttribute("name", name);
		}
	%>
	
	
	
	
	<div class="page-info">
		<h2>
			<u>Welcome to Kachabazar</u>
		</h2>
	</div>

	<div class="product-container">
		<div class="featured-product">
		<h2>Featured Products</h2>
		<ul>
		
			
			
			
			<c:forEach items="${product}" var="product">
					
					
				<li class="product-card">
				<div class="image-holder">
					<img calss="product-image" src="images/products/${product.productImageName }" alt="Image">
					<div class="product-options">
						<div class="option">
							<a href="./viewproducts?action=order&productid=${product.productId}"><h4>Add to Cart</h4></a> 
						</div>
						<div class="option">
							<a href="./viewproducts?action=order&productid=${product.productId}"> <h4>One click buy</h4></a>
						</div>
					</div>
				</div>
				<div class="product-details">
				
					<h3>${product.productName }</h3>
						
						
						<h4>Product Price : ${product.productPrice }/=</h4>
						<h4>Government Price : ${product.productPrice }/=</h4>
				</div>
			</li>
				</c:forEach>
			
			
			
		</ul>
		
		<div class="explore-button"">
			<p><a href="./explore?action=browseall">Browse All</a></p>
		</div>
		</div>
	</div>

	<%
						if ((session.getAttribute("cid") == null)) {
		%>
		<div class="default">
				<a href="./customers?action=login"> Login to view Local Markets</a>
				</div>
	
	<%
						} else {
				
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				System.out.println("cust ID " + cid);
				CustomerModel customerModel = db.getCustomerById(cid);
				int uniId = customerModel.getUnionModel().getUnionId();
				int upaId = customerModel.getUpazillaModel().getUpazillaId();
				int disId = customerModel.getDistrictModel().getDistrictId();
				int divId = customerModel.getDivisionmodel().getDivisionId();

				List<SellersProduct> sellersProductsUnion = db.getProductByUnion(uniId);
				List<SellersProduct> sellersProductsUnion2 = new ArrayList<SellersProduct>();
				
				List<SellersProduct> sellersProductsUpazilla = db.getProductByUpazilla(upaId);
				List<SellersProduct> sellersProductsUpazilla2 = new ArrayList<SellersProduct>();
				
				List<SellersProduct> sellersProductsDistrict = db.getProductByDistrict(disId);
				List<SellersProduct> sellersProductsDistrict2 = new ArrayList<SellersProduct>();
				
				List<SellersProduct> sellersProductsDivision = db.getProductByDivision(divId);
				List<SellersProduct> sellersProductsDivision2 = new ArrayList<SellersProduct>();

				
				if(!sellersProductsUpazilla.isEmpty()){
					
					int length = sellersProductsUpazilla.size();
					
					
					if(length == 1 ){
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(0));
					}
					else if(length == 2 ){
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(0));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(1));
					}
					else if(length == 3 ){
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(0));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(1));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(2));
					}
					else if(length == 4 ){
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(0));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(1));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(2));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(3));
					}
					else if(length > 4 ){
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(length - 1));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(length - 2));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(length - 3));
						sellersProductsUpazilla2.add(sellersProductsUpazilla.get(length - 4));
					}
					
					request.setAttribute("Upazillaproduct", sellersProductsUpazilla2);

					
				}
				else{
					request.setAttribute("Upazillaproduct", sellersProductsUpazilla);
				}
				
				
				if(!sellersProductsUnion.isEmpty()){
					
					int length = sellersProductsUnion.size();
					
					if(length == 1 ){
						sellersProductsUnion2.add(sellersProductsUnion.get(0));
					}
					else if(length == 2 ){
						sellersProductsUnion2.add(sellersProductsUnion.get(0));
						sellersProductsUnion2.add(sellersProductsUnion.get(1));
					}
					else if(length == 3 ){
						sellersProductsUnion2.add(sellersProductsUnion.get(0));
						sellersProductsUnion2.add(sellersProductsUnion.get(1));
						sellersProductsUnion2.add(sellersProductsUnion.get(2));
					}
					else if(length == 4 ){
						sellersProductsUnion2.add(sellersProductsUnion.get(0));
						sellersProductsUnion2.add(sellersProductsUnion.get(1));
						sellersProductsUnion2.add(sellersProductsUnion.get(2));
						sellersProductsUnion2.add(sellersProductsUnion.get(3));
					}
					else if(length > 4 ){
						sellersProductsUnion2.add(sellersProductsUnion.get(length - 1));
						sellersProductsUnion2.add(sellersProductsUnion.get(length - 2));
						sellersProductsUnion2.add(sellersProductsUnion.get(length - 3));
						sellersProductsUnion2.add(sellersProductsUnion.get(length - 4));
					}
					
					request.setAttribute("Unionproducts", sellersProductsUnion2);
					
				}
				else{
					request.setAttribute("Unionproducts", sellersProductsUnion);
				}
				
				
				
				if(!sellersProductsDistrict.isEmpty()){
					
					int length = sellersProductsDistrict.size();
					
					if(length == 1 ){
						sellersProductsDistrict2.add(sellersProductsDistrict.get(0));
					}
					else if(length == 2 ){
						sellersProductsDistrict2.add(sellersProductsDistrict.get(0));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(1));
					}
					else if(length == 3 ){
						sellersProductsDistrict2.add(sellersProductsDistrict.get(0));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(1));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(2));
					}
					else if(length == 4 ){
						sellersProductsDistrict2.add(sellersProductsDistrict.get(0));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(1));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(2));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(3));
					}
					else if(length > 4 ){
						sellersProductsDistrict2.add(sellersProductsDistrict.get(length - 1));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(length - 2));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(length - 3));
						sellersProductsDistrict2.add(sellersProductsDistrict.get(length - 4));
					}
					
					request.setAttribute("Districtproduct", sellersProductsDistrict2);
					
				}
				else{
					request.setAttribute("Districtproduct", sellersProductsDistrict);
				}
				
				
				
				if(!sellersProductsDivision.isEmpty()){
					
					int length = sellersProductsDivision.size();
					
					if(length == 1 ){
						sellersProductsDivision2.add(sellersProductsDivision.get(0));
					}
					else if(length == 2 ){
						sellersProductsDivision2.add(sellersProductsDivision.get(0));
						sellersProductsDivision2.add(sellersProductsDivision.get(1));
					}
					else if(length == 3 ){
						sellersProductsDivision2.add(sellersProductsDivision.get(0));
						sellersProductsDivision2.add(sellersProductsDivision.get(1));
						sellersProductsDivision2.add(sellersProductsDivision.get(2));
					}
					else if(length == 4 ){
						sellersProductsDivision2.add(sellersProductsDivision.get(0));
						sellersProductsDivision2.add(sellersProductsDivision.get(1));
						sellersProductsDivision2.add(sellersProductsDivision.get(2));
						sellersProductsDivision2.add(sellersProductsDivision.get(3));
					}
					else if(length > 4 ){
						sellersProductsDivision2.add(sellersProductsDivision.get(length - 1));
						sellersProductsDivision2.add(sellersProductsDivision.get(length - 2));
						sellersProductsDivision2.add(sellersProductsDivision.get(length - 3));
						sellersProductsDivision2.add(sellersProductsDivision.get(length - 4));
					}
					
					request.setAttribute("Divisionproduct", sellersProductsDivision2);
					
				}
				else{
					request.setAttribute("Divisionproduct", sellersProductsDivision);
				}
				
			request.setAttribute("uniId", uniId);
			request.setAttribute("upaId", upaId);
			request.setAttribute("disId", disId);
			request.setAttribute("divId", divId);
				
		%>



		<div class="product-container">
			<h2>Local Market Products</h2>
			<ul>

				<c:forEach items="${Unionproducts}" var="unionproduct">
					
					
					<li class="product-card">
					<div class="image-holder">
						<img class="product-image" src="images/sellerproducts/${unionproduct.productImageName }" alt="Image">
						<div class="product-options">
							
							<div class="option">
								<a href="./viewproducts?action=sellerorder&productid=${unionproduct.productId }"> <h4>One click buy</h4></a>
							</div>
						</div>
					</div>
					<div class="product-details">
					
						<h3>${unionproduct.productName }</h3>
						<h4>by ${unionproduct.sellerModel.sellerFirstName }</h4>
						
						<h3>Product Price : ${unionproduct.productPrice }/= </h3>
						<h3>Product Price : ${unionproduct.subcategoryModel.govtPrice }/= </h3>
						
					</div>
				</li>
				</c:forEach>
			</ul>
			
			<div class="explore-button"">
				<p><a href="./explore?action=union&uid=${uniId}">Explore More</a></p>
			</div>
		</div>

		<div class="product-container">
			<h2>Upazila Market Products</h2>
			<ul>
				<c:forEach items="${Upazillaproduct}" var="upazillaproduct">
					
					
					<li class="product-card">
					<div class="image-holder">
						<img class="product-image" src="images/sellerproducts/${upazillaproduct.productImageName }" alt="Image">
						<div class="product-options">
							
							<div class="option">
								<a href="./viewproducts?action=sellerorder&productid=${upazillaproduct.productId }"> <h4>One click buy</h4></a>
							</div>
						</div>
					</div>
					<div class="product-details">
						<h3>${upazillaproduct.productName }</h3>
						<h4>${upazillaproduct.sellerModel.sellerFirstName }</h4>
						
						<h3>Product Price : ${upazillaproduct.productPrice }/=</h3>
						<h3>Product Price : ${upazillaproduct.subcategoryModel.govtPrice }/= </h3>
					</div>
				</li>
				</c:forEach>
			</ul>
			
			<div class="explore-button">
			<p><a href="./explore?action=upazilla&upaId=${upaId}">Explore More</a></p>
		</div>
		</div>
		

		<div class="product-container">
			<h2>District Market Products</h2>
			<ul>
				<c:forEach items="${Districtproduct}" var="Districtproduct">
					
					
					<li class="product-card">
					<div class="image-holder">
						<img class="product-image" src="images/sellerproducts/${Districtproduct.productImageName }" alt="Image">
						<div class="product-options">
							
							<div class="option">
								<a href="./viewproducts?action=sellerorder&productid=${Districtproduct.productId }"> <h4>One click buy</h4></a>
							</div>
						</div>
					</div>
					<div class="product-details">
						<h3>${Districtproduct.productName }</h3>
						<h4>${Districtproduct.sellerModel.sellerFirstName }</h4>
						
						<h3>Product Price : ${Districtproduct.productPrice }/=</h3>
						<h3>Product Price : ${Districtproduct.subcategoryModel.govtPrice }/= </h3>
					</div>
				</li>
				</c:forEach>
			</ul>
			
			<div class="explore-button">
			<p><a href="./explore?action=district&disId=${disId}">Explore More</a></p>
		</div>
		</div>
	
		

		<div class="product-container">
			<h2>Division Market Products</h2>
			<ul>
				<c:forEach items="${Divisionproduct}" var="Divisionproduct">
					
					
					<li class="product-card">
					<div class="image-holder">
						<img class="product-image" src="images/sellerproducts/${Divisionproduct.productImageName }" alt="Image">
						<div class="product-options">
							
							<div class="option">
								<a href="./viewproducts?action=sellerorder&productid=${Divisionproduct.productId }"> <h4>One click buy</h4></a>
							</div>
						</div>
					</div>
					<div class="product-details">
						<h3>${Divisionproduct.productName }</h3>
						<h4>${Divisionproduct.sellerModel.sellerFirstName }</h4>
						
						<h3>Product Price : ${Divisionproduct.productPrice }/=</h3>
						<h3>Product Price : ${Divisionproduct.subcategoryModel.govtPrice }/= </h3>
					</div>
				</li>
				</c:forEach>
			</ul>
			
			<div class="explore-button"">
			<p><a href="./explore?action=division&divId=${divId}">Explore More</a></p>
		</div>
		
		</div>
		
		
	<%
	 }
	%>		
</body>
</html>