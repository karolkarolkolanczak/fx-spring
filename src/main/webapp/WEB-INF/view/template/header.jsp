<%--<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fx.spring.Utility.UserDataUtil" %>
<%@ page import="com.fx.spring.Entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fx.spring.Entity.Partner" %>
<%@ page import="java.math.BigDecimal" %>
<html>
<head>
    <!--  bootstrap -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resources/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap-reboot.min.css" rel="stylesheet">
    <%--<link href="/resources/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <!-- head koniec  bootstrap -->

<body>
