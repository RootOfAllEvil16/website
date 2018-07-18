<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <meta name="description" content="Book template"/>
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
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/responsive.css"/>">

    <!--[if lt IE 9] -->
    <script src="<c:url value="/resources/js/plagin-js/html5shiv.js"/>"></script>
    <script src="<c:url value="/resources/js/plagin-js/respond.min.js"/>"></script>
    <!--[endif]-->

</head>

<body>

<div class="container-fluid">
    <section id="chapter">
        <div class="row admin-page">
            <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                <div class="row section-name text-shadow">
                    <b>
                        <span class="color-black">Новая </span>
                        <span class="color-red">глава</span>
                    </b>
                </div>
            </div>
            <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                <form action="<c:url value="/admin/chapter/save"/>" enctype="multipart/form-data" method="post">
                    <table class="table">
                        <tr>
                            <th>Название:</th>
                            <td>
                                <input class="input-order" type="text" name="chapterTitle" minlength="1"
                                       maxlength="100" placeholder="Введите название главы" required>
                            </td>
                        </tr>
                        <tr>
                            <th>Номер главы:</th>
                            <td>
                                <input class="input-order" type="text" name="chapterNumber" minlength="1"
                                       maxlength="100" placeholder="Введите номер главы" required>
                            </td>
                        </tr>
                        <tr>
                            <th>URL:</th>
                            <td>
                                <input class="input-order" type="text" name="url" pattern="[a-z0-9_]{5,50}"
                                       placeholder=" Введите URL, формат (a-z, 0-9, _)"
                                       minlength="5" maxlength="50" required>
                            </td>
                        </tr>
                        <tr>
                            <th>Книга:</th>
                            <td>
                                <select class="input-order" name="book" title="Книга">
                                    <c:forEach items="${books}" var="book">
                                        <option value="${book.id}">${book.title}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <th>Текст:</th>
                            <td>
                                    <textarea class="input-order textarea" name="text" maxlength="100000"
                                              placeholder="Введите текст"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th>Cписок музыки:</th>
                            <td>
                                    <textarea class="input-order textarea" name="music" maxlength="500"
                                              placeholder="Введите список музыки"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th>Изображение:</th>
                            <td>
                                <br>
                                <input type="file" name="chapterImage" accept="image/*">
                            </td>
                        </tr>

                        <tr>
                            <th></th>
                            <td>
                                <button class="btn btn-success" type="submit"
                                        title="Добавить новую главу">
                                    Добавить главу
                                </button>
                                <button class="btn btn-info" type="reset"
                                        title="Сбросить введенные даные">
                                    Сброс
                                </button>
                            </td>
                        </tr>
                    </table>
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