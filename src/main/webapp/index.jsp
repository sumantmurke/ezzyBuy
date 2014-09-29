<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">



<link href="bootstrap/bootstrap.min.css" rel="stylesheet" media="screen"
	type="text/css">
<link href="bootstrap/bootstrap.css" rel="stylesheet" media="screen"
	type="text/css">
<link href="bootstrap/bootstrap-responsive.css" rel="stylesheet"
	media="screen" type="text/css">
<link href="bootstrap/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen" type="text/css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="jsbootstrap/bootstrap.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap.min.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-dropdown.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-alert.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-button.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-carousel.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-scrollspy.js" /></script>
<script type="text/javascript" src="jsbootstrap/bootstrap-modal.js" /></script>



<body>
<%@include file="layout/header.jsp"%>

 <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src="img/Nexus5.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h2 style="color: white;">Nexus 5 </h2>
              <p class="lead">Capture the everyday and the epic in fresh new ways.</p>
              <br>
              <a class="btn btn-large btn-primary" href="#">Sign up today</a>
            </div>
          </div>
        </div>
             <!--    
        <div class="item">
          <img src="img/hero.png" alt="">
          <div class="container">
            <div class="carousel-caption" >
              <h2 style="color: white;">Iphone 6</h2>
              <p class="lead">Bigger than bigger.</p>
              <br>
              <a class="btn btn-large btn-primary" href="#">Learn more</a>
            </div>
          </div>
        </div>
 -->
        <div class="item">
          <img src="img/samsung-galaxy-s4.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h2 style="color: white;">Samsung galaxy S4</h2>
              <p class="lead">The next big thing is here</p>
              <br>
              <a class="btn btn-large btn-primary" href="#">Browse gallery</a>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->

<hr class="featurette-divider">

<!-- Thumbnails -->

<div class="row-fluid">
            <ul class="thumbnails">
              <li class="span4">
                <div class="thumbnail">
                  <img data-src="holder.js/300x200" alt="">
                  <div class="caption">
                    <h3>Hot Deals !</h3>
                    <p>Buy Iphone 5s @ $199 only. </p>
                    <p>Samsung just for $299.</p>
                    <p> <a href="#" class="btn">Details >></a></p>
                  </div>
                </div>
              </li>
              <li class="span4">
                <div class="thumbnail">
                  <img data-src="holder.js/300x200" alt="">
                  <div class="caption">
                    <h3>Trending Picks</h3>
                    <p>1. Iphone 6</p>
                    <p>2. Samsung Galaxy S5</p>
                    <p>3. Nexus 5</p>
                    <p>4. HTC one(M7)</p>
                    <p>5. Sony xperia Z1s</p>
                    <p>6. LG G2</p>
                     <p> <a href="#" class="btn">Details >></a></p>
                  </div>
                </div>
              </li>
              <li class="span4">
                <div class="thumbnail">
                  <img src="img/images.jpeg" alt="">
                  <div class="caption">
                    <h3>Coming soon</h3>
                    <p><a href="#" class="btn">Details >></a></p>
                  </div>
                </div>
              </li>
            </ul>
          </div>
          
          
    <!-- thumnails finish -->      
<hr class="featurette-divider">

 <script>
      !function ($) {
        $(function(){
          // carousel demo
       $('.myCarousel').carousel({
 	 interval: 2000
		})
        })
      }(window.jQuery)
    </script>
</body>
</html>
