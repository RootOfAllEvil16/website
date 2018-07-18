<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en" class="no-js">

	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>She is in me</title>
		<meta name="description" content="She is in me" />
		<meta name="keywords" content="читать, она во мне, читать она во мне, книга она во мне" />
		<meta name="author" content="" />
		<link rel="shortcut icon" href="">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.jscrollpane.custom.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bookblock.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>" />
		<script src="<c:url value="/resources/js/modernizr.custom.79639.js"/>"></script>
	</head>
	<body>
		<div id="container" class="container">	

			<div class="menu-panel">
				<h3>Она во мне</h3>
				<ul id="menu-toc" class="menu-toc">
					<c:forEach items="${chapters}" var="chapter">
					<li><a href="<c:url value="/chapter/${chapter.url}"/>" title=" <c:out value="${chapter.chapterTitle}"/>">
                        <div class="text">
                            <c:out value="${chapter.chapterTitle}"/>
                        </div>
                    </a></li>
                    </c:forEach>
				</ul>
				<div>
					<a href="<c:url value="/home"/>">Вернуться на сайт</a>
				</div>
			</div>

			<div class="bb-custom-wrapper">
				<div id="bb-bookblock" class="bb-bookblock">
                    <c:forEach items="${chapters}" var="chapter">
					<div class="bb-item" id="<c:url value="/chapter/${chapter.url}"/> ">
						<div class="content">
							<div class="scroller">
								<h2>${chapter.chapterTitle}</h2>
								<p>${chapter.text}</p>
							</div>
						</div>
					</div>
					</c:forEach>

					</div>
				</div>
				
				<nav>

					<span id="bb-nav-prev">&larr;</span>
					<span id="bb-nav-next">&rarr;</span>

				</nav>

				<span id="tblcontents" class="menu-button">Она во мне</span>

			</div>
				

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script src="<c:url value="/resources/js/jquery.mousewheel.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery.jscrollpane.min.js"/>"></script>
		<script src="<c:url value="/resources/js/jquerypp.custom.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery.bookblock.js"/>"></script>
		<script src="<c:url value="/resources/js/page.js"/>"></script>
		<script>
			$(function() {

				Page.init();

			});
		</script>
	</body>
</html>
