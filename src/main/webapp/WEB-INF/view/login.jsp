<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fx.spring.Utility.UserDataUtil" %>
<%@ page import="com.fx.spring.ModelFx.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fx.spring.ModelFx.Partner" %>
<%@ page import="java.math.BigDecimal" %>
<html>
<head>
    <!--  bootstrap -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap-reboot.min.css" rel="stylesheet">
    <%--<link href="/resources/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <!-- head koniec  bootstrap -->

    <body>
    <div class="container">

        <nav class="navbar navbar-default ">
            <div style="margin: 20px">
                <h2>ADMINISTRATOR PANEL</h2>
            </div>
        </nav></br></br>
        <div class="row"></div>

        <div class ="col-md-offset-0 col-sm-5">
            <%--&lt;%&ndash;<form:form class="form-horizontal" action="login/admin" modelAttribute="user">&ndash;%&gt;--%>
                <%--<form:form action="admin" modelAttribute="editedProduct" method="post" class="form-horizontal" >--%>
                <%--<div class="form-group">--%>
                    <%--&lt;%&ndash;<label for="login" class="col-sm-2 control-label">Login</label>&ndash;%&gt;--%>
                    <%--<div class="col-sm-5">--%>
                        <%--&lt;%&ndash;<input type="text" class="form-control" id="login" name="login" value="admin">&ndash;%&gt;--%>
                        <%--<form:input path="login"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--&lt;%&ndash;<label for="password" class="col-sm-2 control-label">Password</label>&ndash;%&gt;--%>
                    <%--<div class="col-sm-5">--%>
                        <%--&lt;%&ndash;<input type="text" class="form-control" id="password" name="password" value="admin">&ndash;%&gt;--%>
                        <%--<form:input path="password"/>--%>
                    <%--</div>--%>
                <%--</div></br>--%>
                <%--<div class="form-group">--%>
                    <%--<div class="col-sm-offset-2 col-sm-10">--%>
                        <%--&lt;%&ndash;<button type="submit" class="btn btn-default">Sign in</button>&ndash;%&gt;--%>
                        <%--<input type="submit" value="Sign in"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form:form>--%>
                <form:form action="admin"   modelAttribute="user" method="post">

                    <div class="form-group">
                        <label for="productName">Product Name</label>
                        <form:input path="login" id="productName" class="form-control" value="${user.login}"/>
                    </div>

                    <div class="form-group">
                        <label for="productCategory">Category</label>
                        <form:input path="password" id="productCategory" class="form-control" value="${user.password}"/>
                    </div>

                    <button type="submit" class="btn btn-default">Update</button>
                </form:form>
        </div>

    </div>
Login: ${user.login} Pass: ${user.password}

     <!-- body bootstrap + jquery-->
    <script src="/resources/js/jquery-3.2.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- koniec body bootstrap + jquery-->
    </body>
</html>
