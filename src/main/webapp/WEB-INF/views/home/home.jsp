<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<!--[if IE 7]> <html class="no-js ie7 oldie" lang="en-US"> <![endif]-->
<!--[if IE 8]> <html class="no-js ie8 oldie" lang="en-US"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en-US">
<head>

    <!-- TITLE OF SITE -->
    <title>She is in me</title>

    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="description" content="She is in me"/>
    <meta name="keywords" content="website, она во мне, читать книгу она во мне, читать, книга она во мне"/>
    <meta name="developer" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="robots" content="noindex">


    <!-- FAV AND TOUCH ICONS   -->
    <!--  <link rel="icon" href="images/favicon.ico">
      <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
      <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
      <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">-->

    <!-- GOOGLE FONTS -->
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,700,900' rel='stylesheet' type='text/css'>
    <!-- font-family: 'Merriweather', serif; -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!-- font-family: 'Open Sans', sans-serif; -->

    <!-- BOOTSTRAP CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">

    <!-- Image Slider -->
    <link rel="stylesheet" href="<c:url value="/resources/css/plagin-css/owl.carousel.css"/>">

    <link rel="stylesheet" href="<c:url value="/resources/css/submenu.css"/> ">
    <!-- FONT ICONS -->
    <link rel="stylesheet" href="<c:url value="/resources/icons/rik-icons/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/icons/font-awesome/font-awesome.css"/>">

    <!--   CUSTOM CSS link  -->
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/responsive.css"/>">

    <!--[if lt IE 9] -->
    <script src="<c:url value="/resources/js/plagin-js/html5shiv.js"/>"></script>
    <script src="<c:url value="/resources/js/plagin-js/respond.min.js"/>"></script>
    <!--[endif]-->

</head>

<body class="style-1">
<!-- Start: Preloader Section
=================================== -->
<div id="main-preloader" class="main-preloader semi-dark-background">
    <div class="container full-height">
        <div class="row full-height">
            <div class="full-height col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-12">

                <div class="main-preloader-inner">

                    <h1 class="preloader-percentage">
                        <span class="preloader-percentage-text">0%</span> <!-- Show Percentage Number -->
                        <!-- <span class="percentage">%</span> -->
                    </h1>
                    <div class="preloader-bar-outer">
                        <div class="preloader-bar"></div> <!-- Percentage Precess Bar -->
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<!-- End: Preloader Section
=================================== -->

<!-- Start: Navbar Area
============================= -->
<nav class="navbar navbar-fixed-top main-navbar-top navbar-top-js" id="main-navbar-top">
    <div class="container relative">
        <div class="navbar-header">

            <!-- Menu Button show Mobile view -->
            <button type="button" class="nav-trigger nav-trigger-animate" data-target="#js-navbar-menu">
                <span aria-hidden="true" class="icon"></span>
            </button>


            <a class="navbar-brand light-logo btn-scroll" href="#home-section"><img
                    src="<c:url value="/resources/background/logo.png"/>" alt=""
                    class="img-responsive"></a>

        </div>

        <!-- Main Menu List -->
        <!--TO DO НАЗВАНИЯ В МЕНЮ-->
        <!-- TO DO ЦВЕТ ЗАЛИВИ КРАСНЫЙ-->
        <div class="navbar-collapse" id="js-navbar-menu">
            <ul class="nav navbar-nav navbar-right" id="navbar-nav">
                <li><a class="btn-nav" href="#book">ПОЧИТАТЬ</a></li>
                <li><a class="btn-nav" href="#social-links">ПООБЩАТЬСЯ</a></li>
                <li><a class="btn-nav" href="#contact-us-section">ПОДДЕРЖАТЬ</a></li>
            </ul>
        </div>
        <!-- Right Side Navigation Button -->
        <div class="navbar-collapse-right hidden-xs ">
            <ul class="nav navbar-nav navbar-right btn-scroll">
                <li><a class="btn-nav" href="#contact-us-section">ПООБЩАТЬСЯ<i class="icon icon-arrow-right"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- End: Navbar Area
============================= -->
<!--Start: 1st Section
- HOME PAGE
====================================-->
<div class="section section-item home-section overflow hide-overlay overlay-color bg-image-1 wow" id="home-section">
    <div class="inner-container ">
        <div class="container">
            <div class="row">

                <div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-12">

                    <div class="home-content-outer text-center">

                        <div class="overflow">
                            <div class="heading-outer left-right relative">
                                <div class="heading-outer top-bottom relative">
                                    <div class="overflow p-t-40 p-l-40 p-r-40 p-b-40">
                                        <div class="section-heading-outer">
                                            <h1 class="heading"><span class="color">SOME TEXT</span></h1>
                                            <h2 class="heading">Some text</h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="overflow m-t-30">
                            <div class="list-view">
                                <ul class="nav">
                                    <li><a class="btn-mask" href="#book">ПОЧИТАТЬ</a></li>
                                    <li><a class="btn-mask" href="#social-links">ПООБЩАТЬСЯ</a></li>
                                    <li><a class="btn-mask" href="#contact-us-section">ПОДДЕРЖАТЬ</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<!--End: 1st Section
- HOME PAGE
====================================-->

<!--Start: 3rd Section
- Portfolio PAGE
====================================-->

<div class="section section-item dark-background" id="book">
    <div class="inner-container">
        <div class="container">
            <div class="row section-separator">
                <div class="col-sm-12 overflow">
                    <div class="row chapter-container wow">

                        <div class="chapter-wrapper pagination-style-1 owl-carousel">


                            <c:forEach items="${books}" var="book">

                                <div class="item ">
                                    <div class="chapter-section overflow">

                                        <div class="col-xs-10 col-xs-offset-1">

                                            <div class="row">
                                                <div class="image text-center">
                                                    <a href="/book/${book.url}">
                                                    <img src="<c:url value="/resources/img/${book.title}.jpg"/>"
                                                         alt="image" class="img-responsive">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="each-portfolio-heading">
                                            <div class="heading-text overflow wow">
                                                <div class="line"></div>
                                                <div class="overflow">
                                                    <div class="sub-heading-outer">
                                                        <p class="sub-heading">${book.title}</p>
                                                    </div>
                                                </div>
                                                <div class="text overflow">
                                                    <div class="inner">
                                                        <a href="<c:url value="/book/${book.url}"/>">ЧИТАТЬ</a>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                </div>
                            </c:forEach>

                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>

<!--End: 3rd Section
- Portfolio PAGE
====================================-->

<!--Start: 6th Section
- CONTACT US PAGE
====================================-->
<div class=" section section-item combine-section hide-overlay overflow wow" id="contact-us-section">
    <div class="overlay-color relative bg-image-2">

        <div class="inner-container contact-us" id="contact">
            <div class="container">
                <div class="row">

                    <!-- Start: Section Heading -->
                    <div class="section-header col-sm-10 col-sm-offset-1">
                        <div class="overflow">
                            <div class="line-outer">
                                <div class="line wow"></div>
                            </div>
                        </div>
                        <div class="overflow">
                            <div class="section-heading-outer m-b-15">
                                <p class="sub-heading wow">Ещё не время</p>
                            </div>
                        </div>
                        <div class="overflow">
                            <div class="section-heading-outer p-l-50 p-r-50">
                                <h2 class="section-heading wow">ДОЖДИСЬ ПОЛНОЙ ПУБЛИКАЦИИ</h2>
                            </div>
                        </div>
                    </div>
                    <!-- End: Section Heading -->

                    <div class="clearfix"></div>


                    <div class="clearfix"></div>

                    <div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 contact-footer">
                        <div class="row">

                            <div class="about col-sm-1 m-t-15">
                                <div class="overflow">
                                    <div class="logo-outer wow">
                                        <a href="<c:url value="/home"/>" class="logo-link">
                                            <img src="<c:url value="/resources/background/logo.png"/>" alt=""
                                                 class="img-responsive logo">
                                        </a>
                                    </div>
                                </div>

                            </div> <!-- End: .about -->

                            <div class="other-link col-sm-11" id="social-links">
                                <div class="row">

                                    <div class="each-section col-sm-4 col-xs-12">
                                        <div class="each-section-inner">

                                            <div class="overflow">
                                                <p class="title wow">Контакты</p>
                                            </div>
                                            <ul class="nav">
                                                <li class="overflow">
                                                    <div class="li-inner wow">
                                                        <a href="mailto:mail@example.com" class="btn-mask">your mail</a>
                                                    </div>
                                                </li>
                                                <li class="overflow">
                                                    <div class="li-inner wow">
                                                        <ul class="nav social-icon">
                                                            <li><a href="#"><i
                                                                    class="fa fa-vk"></i></a></li>
                                                            <li><a href="#"><i
                                                                    class="icon icon-social-twitter"></i></a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </li>
                                            </ul>

                                        </div>
                                    </div> <!-- End: .each-section -->

                                </div>
                            </div> <!-- End: .other-link -->

                        </div> <!-- End: .row -->
                    </div> <!-- End: .contact-footer -->

                </div> <!-- End: .row -->
            </div> <!-- End: .container -->
        </div> <!-- End: .inner-container -->

    </div>
    <div class="footer-bottom">
        <div class="container">
            <div class="footer-bottom__left">
                Екатерина Ходаковская
            </div>
            <div class="footer-bottom__right">
                &copy; 2018 <strong>Она во мне</strong>
            </div>
        </div>
    </div>
</div>
<!--End: 6th Section
- CONTACT US PAGE
====================================-->


<!-- SCRIPTS
========================================-->
<script src="<c:url value="/resources/js/plagin-js/jquery-1.11.3.js"/>"></script>
<script src="<c:url value="/resources/js/plagin-js/preloader.js"/>"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/plagin-js/plagin.js"/>"></script>

<!-- Custom Script
==========================================-->
<script src="<c:url value="/resources/js/custom-scripts.js"/>"></script>
</body>
</html>
