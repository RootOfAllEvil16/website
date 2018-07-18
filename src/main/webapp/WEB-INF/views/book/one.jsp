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
    <meta name="keywords" content="website, она во мне, читать, читать она во мне, книга она во мне"/>
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


<div class="section section-item dark-background" id="book">
    <div class="inner-container">
        <div class="container">
            <div class="row section-separator">
                <div class="col-sm-12 overflow">
                    <div class="row chapter-container wow">

                        <div class="chapter-wrapper pagination-style-1 owl-carousel">


                            <c:forEach items="${chapters}" var="chapter">

                                <div class="item ">
                                    <div class="chapter-section overflow">

                                        <div class="col-xs-10 col-xs-offset-1">

                                            <div class="row">
                                                <div class="image text-center">
                                                    <img src="<c:url value="/resources/img/${chapter.chapterTitle}.jpg"/>"
                                                         alt="image">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="each-portfolio-heading">
                                            <div class="heading-text overflow wow">
                                                <div class="line"></div>
                                                <div class="overflow">
                                                    <div class="sub-heading-outer">
                                                        <p class="sub-heading">${chapter.chapterNumber}</p>
                                                    </div>
                                                </div>
                                                <div class="text overflow">
                                                    <div class="inner">
                                                            ${chapter.chapterTitle}
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="link-list overflow wow">
                                                <div class="link one overflow">
                                                    <div class="inner">
                                                        <a href="<c:url value="/reader"/>">ЧИТАТЬ</a>
                                                    </div>
                                                </div>
                                                <div class="link two overflow">

                                                    <div class="inner">
                                                        <a class="right-icon btn-mask"
                                                           data-element="project-detail">МУЗЫКА<i
                                                                class="icon icon-arrow-down"></i></a>

                                                            ${chapter.music}

                                                    </div>

                                                    <div class="line hidden-xs"></div>
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

<script src="<c:url value="/resources/js/plagin-js/jquery-1.11.3.js"/>"></script>
<script src="<c:url value="/resources/js/plagin-js/preloader.js"/>"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/plagin-js/plagin.js"/>"></script>

<!-- Custom Script
==========================================-->
<script src="<c:url value="/resources/js/custom-scripts.js"/>"></script>
</body>
</html>