<%@page import="model.ProductModel"%>
<%@page import="model.AreaModel"%>
<%@page import="model.OrdersModel"%>
<%@page import="model.DeliveryPersonModel"%>
<%@page import="model.SellerModel"%>
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
<script src="javascript/jquery.js"></script>
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins&display=swap"
	rel="stylesheet">
<title>Products</title>
</head>
<body>



		
		<table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Emp ID</th>
            <th>Emp Name</th>
            <th>Salary</th>
            <th>Dept Name</th>
        </tr>
 
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td>${employee.productId}</td>
                <td>${employee.productName}</td>
                <td>${employee.productDescription}</td>
                <td>${employee.productPrice}</td>
            </tr>
        </c:forEach>
    </table>
    
  
		
		<table border="1" > 
		<c:forEach begin="1" end="${noOfPage}" var="i">
			<c:choose>
				<c:when test="${currentPage eq i}">
					<td>${i}</td>
				</c:when>
			
				<c:otherwise>
					<td><a href="pagination?page=${i}">${i}</a></td>
				</c:otherwise>
			
			</c:choose>
		</c:forEach>
		
		${noOfPage}
		${currentPage }
		</table>
		

</body>




</html>