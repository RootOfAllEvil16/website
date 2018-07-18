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
    <section id="chapters admin-page">
        <div class="row admin-page">
            <c:set var="chapters_length" value="${fn:length(chapters)}"/>
            <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                <div class="row section-name text-shadow">
                    <b>
                        <span class="color-black">Главы</span>
                        <c:if test="${chapters_length eq 0}">
                            <span class="color-red"> - список пуст!</span><br>
                            <a href="<c:url value="/admin/chapter/add"/>" title="Добавить новую главу">
                                <button class="btn btn-success" type="submit">Добавить</button>
                            </a>
                        </c:if>
                    </b>
                </div>
            </div>
            <c:if test="${chapters_length gt 0}">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                    <table class="table">
                        <tr>
                            <th width="40%">Название книги</th>
                            <th width="35%">
                                Действие
                                <a href="<c:url value="/admin/chapter/add"/>" title="Добавить новую главу">
                                    <button class="btn btn-success" type="submit">Добавить</button>
                                </a>
                                <a href="<c:url value="/admin/chapter/delete_all"/>" title="Удалить все главы">
                                    <button class="btn btn-danger" type="submit">Удалить ВСЕ</button>
                                </a>
                                <a href="<c:url value="/admin/book/all"/> " title="Просмотреть книги">
                                    <button class="btn btn-success" type="submit">Просмотреть книги</button>
                                </a>
                                <a href="<c:url value="/home"/> " title="Вернуться на сайт">
                                    <button class="btn btn-success" type="submit">Вернуться на сайт</button>
                                </a>
                            </th>
                        </tr>
                        <c:forEach items="${chapters}" var="chapter">
                            <tr>


                                <th>${chapter.book.title}</th>

                                <td>
                                    <a href="<c:url value="/admin/chapter/view/${chapter.id}"/>"
                                       title="Просмотреть главу ${chapter.chapterTitle}">
                                        <button class="btn btn-info" type="submit">Смотреть</button>
                                    </a>
                                    <a href="<c:url value="/admin/chapter/delete/${chapter.id}"/>"
                                       title="Удалить главу ${chapter.chapterTitle}">
                                        <button class="btn btn-danger" type="submit">Удалить</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
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