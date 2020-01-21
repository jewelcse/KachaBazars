<%@page import="model.CustomerModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.ProductModel"%>
<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="menubar.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/signing.css">
 <link rel="icon" href="images/favicon.png">
<title>Login</title>
</head>
<body>

			

        <!-- PRELOADER -->
        <div id="preloader">
            <div class="preloader-area">
            	<div class="preloader-box">
            		<div class="preloader"></div>
            	</div>
            </div>
        </div>


	      <div class="container">
        	<div class="box-info">
        		<h3>Sign In</h3>
        	</div>
        	
        	
        	<form action="./customers?action=login" method="post">
        	
        	<input type="hidden" name="url" value="${url }">
            <input type="hidden" name="pid" value="${pid }">
            <input type="hidden" name="page" value="${page }">
            
            
            <div class="add">
            
        	<table class="form-table">
        		<tr>
        			<td>
        				<input class="input-field" type="text" name="customerPhone" placeholder="Phone Number" required="required">
        			</td>
        		</tr>
        		
        		<tr>
        			<td>
        				<input class="input-field" type="password" placeholder="Password" name="customerPassword" required="required">
        			</td>
        		</tr>
        		
        		<tr>
        			<td>
        				${message}
        			</td>
        		</tr>
        		
        		<tr>
        			<td>
                        <input class="button" type="submit" value="Sign In" />
                    </td>
        		</tr>
        		<tr>
        			<td>
        				<div class="misc">
        					Don't Have an Account?<p><a href="./customers?action=reg">Sign Up Now</a></p>
        				</div>
        			</td>
        			</tr>
        	</table>
        	
        	
        	
        	</div>
        	</form>
        	
        	
        </div>


	<!-- 
        

        <section class="signin-section">
            <div class="container-box">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="titie-section wow fadeInDown animated ">
                            <h1>Sign In</h1>
                           
                            
                        </div>
                    </div>
                </div>
                 <div class="col-md-6 wow fadeInRight animated">
                        <form class="contact-form" action="./customers?action=login" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <input class="form-control" type="text" name="customerPhone" placeholder="Phone Number" required="required">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <input class="form-control" type="text" placeholder="Password" name="customerPassword" required="required">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <input type="submit" class="contact-submit" value="Sign In" />
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="url" value="${url }">
                            <input type="hidden" name="pid" value="${pid }">
                            <input type="hidden" name="page" value="${page }">
                        </form>
                         <a href="./customers?action=reg" class="contact-submit"><h1>Need an account</h1></a> <p>
                    </div>
                </div>
                </div>
                --!>
                
                
                
          
                

        <!-- JQUERY -->
        <script src="js/vendor/jquery-1.11.2.min.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>