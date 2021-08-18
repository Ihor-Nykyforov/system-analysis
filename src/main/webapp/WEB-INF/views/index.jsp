<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="">

<head>
    <title>Car service</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="/WEB-INF/views/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
    <style>
        <%@include file='/WEB-INF/views/layout/styles/layout.css' %>
        <%@include file='/WEB-INF/views/layout/styles/framework.css' %>
    </style>
</head>
<body id="top">

<div class="bgded" style="background-image:url(<c:url value='/resources/images/demo/backgrounds/01.png' />)">

    <div class="wrapper row1">
        <header id="header" class="hoc clear">

            <div id="logo" class="fl_left">
                <h1><a href="${pageContext.request.contextPath}/index">Car service</a></h1>
            </div>
            <nav id="mainav" class="fl_right">
                <ul class="clear">
                    <li class="active">Hello ${login}</li>
                    <li class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/login">Change user</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/orders">Show all orders</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/users">Show all users</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/cars">Show all cars</a></li>
                </ul>
            </nav>

        </header>
    </div>

    <div class="wrapper">
        <article id="pageintro" class="hoc clear">

            <div class="transbox">
                <h3 class="heading">About us</h3>
                <p>Comprehensive car service provides a full cycle of car repair services, from a service station and a spare parts department to a car shop with a car sales area. The advantage is to get all services in one place, while saving nerves and time - we are proud to consider the highlight of our car service. Those of you who have had the opportunity to tinker with the disassembly with your own hands know how laborious and costly this process is. Special equipment and high qualifications of our employees allow us to quickly deal with serious injuries after an accident. </p>
            </div>
            <!-- ################################################################################################ -->
        </article>
    </div>
    <!-- ################################################################################################ -->
</div>
<!-- End Top Background Image Wrapper -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
    <main class="hoc container clear">
        <!-- main body -->
        <!-- ################################################################################################ -->
        <article class="group">
            <div class="three_quarter">
                <p class="btmspace-30"> Our specialists will carry out all the necessary complex of work using modern diagnostic equipment for quick and accurate troubleshooting, taking into account the characteristics of cars of all brands and models, including taking into account the age of your car.</p>
            </div>
            <div class="three_quarter">
                <p class="btmspace-30">Our Car Service Body Repair Center is especially respected by our customers. The specificity is associated with the high accuracy of the geometric parameters of the car body. In this regard, even simple body work should be carried out at a workshop and only by qualified specialists.</p>
            </div>
        </article>
        <!-- ################################################################################################ -->
        <!-- / main body -->
        <div class="clear"></div>
    </main>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper bgded overlay light" style="background-image:url('/WEB-INF/views/images/demo/backgrounds/03.png');">
    <section class="hoc container clear">
        <!-- ################################################################################################ -->
        <ul class="nospace group">
            <li class="one_quarter first">
                <h3 class="heading">Services</h3>
                <p>Premium car service meets excellent workmanship.</p>
                <footer><a class="btn" href="${pageContext.request.contextPath}/add-order">Make order</a></footer>
            </li>
            <li class="one_quarter">
                <figure><a href="#"><img class="btmspace-30" src="images/demo/222x100.png" alt=""></a>
                    <figcaption>
                        <h6 class="heading font-x1">Maintenance and repair</h6>
                        <footer><a href="#">View Details</a></footer>
                    </figcaption>
                </figure>
            </li>
            <li class="one_quarter">
                <figure><a href="#"><img class="btmspace-30" src="images/demo/222x100.png" alt=""></a>
                    <figcaption>
                        <h6 class="heading font-x1">Additional services</h6>
                        <footer><a href="#">View Details</a></footer>
                    </figcaption>
                </figure>
            </li>
            <li class="one_quarter">
                <figure><a href="#"><img class="btmspace-30" src="images/demo/222x100.png" alt=""></a>
                    <figcaption>
                        <h6 class="heading font-x1">Body repair</h6>
                        <footer><a href="#">View Details</a></footer>
                    </figcaption>
                </figure>
            </li>
        </ul>
        <!-- ################################################################################################ -->
    </section>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->



<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row5">
    <div id="copyright" class="hoc clear">
        <!-- ################################################################################################ -->
        <p class="fl_left"> <a href="#">Made by Ihor Nykyforov and Danylo Zelinskiy</a></p>
        <!-- ################################################################################################ -->
    </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="layout/scripts/jquery.min.js"></script>
<script src="layout/scripts/jquery.backtotop.js"></script>
<script src="layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>
