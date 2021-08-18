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

<div class="bgded" style="background-image:url('/WEB-INF/views/images/demo/backgrounds/01.png');">

    <div class="wrapper row1">
        <header id="header" class="hoc clear">

            <div id="logo" class="fl_left">
                <h1><a href="${pageContext.request.contextPath}/index-user">Car service</a></h1>
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
                <form method="post" id="car" action="${pageContext.request.contextPath}/add-order"></form>
                <h1>Users</h1>
                <table border="1" class="table_dark">
                    <tr>
                        <th>ID</th>
                        <th>Login</th>
                        <th>Phone</th>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>
                                <c:out value="${user.id}"/>
                            </td>
                            <td>
                                <c:out value="${user.login}"/>
                            </td>
                            <td>
                                <c:out value="${user.phone}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <!-- ################################################################################################ -->
        </article>
    </div>
    <!-- ################################################################################################ -->
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
