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
    <meta name="keywords" content="website, portfolio, template, responsive, bootstrap"/>
    <meta name="developer" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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

<div class="container-fluid">
    <section id="login">
        <div class="row login">
            <div class="col-xs-6 col-xs-offset-4 col-sm-4 col-sm-offset-4 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-4 col-xl-4 col-xl-offset-4 text-center">
                <div class="text-shadow">
                    <span class="authorization">Авторизация</span>
                </div>
                <c:if test="${param.error ne null}">
                    <div class="alert alert-info" role="alert">
                        Ошибка авторизации
                    </div>
                </c:if>
                <c:if test="${param.logout ne null}">
                    <div class="alert alert-info" role="alert">
                        Вы вышли из системы
                    </div>
                </c:if>
                <form class="form-signin" action="<c:url value="/login"/>" method="post">
                    <input id="username" class="form-control" type="text" name="username" autofocus required
                           pattern="[A-Za-z0-9_]{5,50}" minlength="5" maxlength="50"
                           placeholder="Введите логин, формат (A-Z, a-z, 0-9, _)" style="margin-top: 25px">
                    <input id="password" class="form-control" type="password" name="password" required
                           pattern="[A-Za-z0-9]{6,50}" style="margin-top: 25px" minlength="6" maxlength="50"
                           placeholder="Введите пароль, формат (A-Z, a-z, 0-9)">
                    <button class="btn btn-success" type="submit" style="margin-top: 25px">Войти</button>
                </form>
            </div>
        </div>
    </section>
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
