<%@page import="model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">

<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Kachabazar Homepage</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon.png">

        <link rel="stylesheet" href="css/home.css">
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
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#">Profile</a></li>
                            <li><a href="./browse?action=view">Explore Shop</a></li>
                            <li><a href="./customers?action=logout">Logout</a></li>
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
                <!-- Indicators -->
                <ol class="carousel-indicators slider-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="images/slider1.jpg" width="1648" height="600" alt="">
                        <div class="carousel-caption">
                            <h2>Fresh <b>Vegetables</b></h2>
                            <h3>FROM OUR FARMERS <Span>FIELDS</Span></h3>
                            <a href="#"><b>Buy Now</b></a>
                        </div>
                    </div>
                    <div class="item">
                        <img src="images/slider2.jpg" width="1648" height="600" alt="">
                        <div class="carousel-caption">
                            <h2>Fresh <b>Fishes</b></h2>
                            <h3>FROM OUR <Span>FISHERMEN</Span></h3>
                            <a href="#"><b>Buy Now</b></a>
                        </div>
                    </div>
                    <div class="item ">
                        <img src="images/slider3.jpg" width="1648" height="600" alt="">
                        <div class="carousel-caption">
                            <h2>Fresh <b>Meats</b></h2>
                            <h3>FROM OUR FARMERS <Span>FARM</Span></h3>
                            <a href="#"><b>Buy Now</b></a>
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="pe-7s-angle-left glyphicon-chevron-left" aria-hidden="true"></span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="pe-7s-angle-right glyphicon-chevron-right" aria-hidden="true"></span>
                </a>
            </div>
        </section>
        
         <section class="service-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6 wow fadeInRight animated" data-wow-delay="0.1s">
                        <div class="service-item">
                            <i class="pe-7s-settings"></i>
                            <h3>Always Fresh</h3>
                            <p>Our products are collected from direct farmers. So we are ensuring you the freshness quality of our products.</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 wow fadeInRight animated" data-wow-delay="0.2s">
                        <div class="service-item">
                            <i class="pe-7s-safe"></i>
                            <h3>Superior Quality</h3>
                            <p>We are ensuring the top and superior quality of our products.</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 wow fadeInRight animated" data-wow-delay="0.3s">
                        <div class="service-item">
                            <i class="pe-7s-global"></i>
                            <h3>Home Delivery</h3>
                            <p>You can now order products from all over Bangladesh and we are providing you the shipping facility all over Bangladesh. We will take the products at your door.</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 wow fadeInRight animated" data-wow-delay="0.4s">
                        <div class="service-item">
                            <i class="pe-7s-headphones"></i>
                            <h3>Online support</h3>
                            <p>We have a good online support for you 24 hours.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
