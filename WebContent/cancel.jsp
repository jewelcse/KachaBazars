<%@page import="java.util.Map"%>
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
<title>Insert title here</title>
<link rel="stylesheet" href="css/transaction.css">
</head>
<body>

<%
	Map<String, String[]> map = request.getParameterMap();
	String[] act = map.get("status");
	System.out.println(act[0]);
	
	System.out.println(request.getParameter("errorReason"));
	
	%>
	
	<div class="page-info">
		<h2>
			<u>Payment Status</u>
		</h2>
	</div>
	
	<div class="img-info">
		<img alt="Cancelled" src="images\close.gif">
	</div>

<div class="info cancel">
	<h1>Payment is Cancelled</h1>
	</div>

</body>
</html>