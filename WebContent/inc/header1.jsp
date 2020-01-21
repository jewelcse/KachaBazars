<%@page import="model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>




<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Kachabazar Homepage</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon.png">

        <link rel="stylesheet" href="css/home.css">
        
        
        <style>
div.gallery {
  margin: 5px;
  border: 1px solid #ccc;
  float: left;
  width: 180px;
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
}

div.desc {
  padding: 15px;
  text-align: center;
}
</style>
        
</head>
<body>

	<div id="preloader">
            <div class="preloader-area">
            	<div class="preloader-box">
            		<div class="preloader"></div>
            	</div>
            </div>
        </div>
        
        <header class="header-section">
            <nav class="navbar navbar-default">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#"><b>Kacha</b>Bazar</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li ><a href="#">Home</a></li>
                            
							<c:if test="${login=='login'}">
                            <li><a href="#">${name }</a></li>
                            </c:if>
                            <c:if test="${login!='login'}">
                             <li><a href="#">Need Cart</a></li>
                            </c:if>
							
                            <li class="active"><a href="./browse?action=view">Explore Shop</a></li>
                            
							<c:if test="${login=='login'}">
                            <li><a href="./customers?action=logout">Logout</a></li>
                            </c:if>
                            <c:if test="${login!='login'}">
                             <li><a href="./customers?action=login">Login</a></li>
                            </c:if>

                        </ul>
                        <ul class="nav navbar-nav navbar-right cart-menu">
                        <li><a href="#" class="search-btn"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                        <li><a href="./Cart?cid=${cid}&action=view""> <span class="shoping-cart">$</span></a></li>
                    </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container -->
            </nav>
        </header>
        
        <section class="search-section">
            <div class="container">
                <div class="row subscribe-from">
                    <div class="col-md-12">
                        <form class="form-inline col-md-12 wow fadeInDown animated">
                            <div class="form-group">
                                <input type="email" class="form-control subscribe" id="email" placeholder="Search...">
                                <button class="suscribe-btn" ><i class="pe-7s-search"></i></button>
                            </div>
                        </form><!-- end /. form -->
                    </div>
                </div><!-- end of/. row -->
            </div><!-- end of /.container -->
        </section>
        
        
      <section class="slider-section">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">


                <!-- Wrapper for slides -->
                <div class="bbgg carousel-inner" role="listbox">
                    <div class="item active">
                        <img class="" src="images/bg_1.jpg" width="1648" height="400" alt="">
                        <div class="carousel-caption">
                            <h2>Explore <b>the Shop</b></h2>
                            <h3>and find your <Span>Favorite item</Span></h3>
                        </div>
                    </div>
                </div>

               
            </div>
        </section>
        
         
