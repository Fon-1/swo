<%-- 
    Document   : AccidentHistory
    Created on : Jan 18, 2024, 6:34:34 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Lịch sử tai nạn</title>
        <link rel="shortcut icon" href="images/favicon.png" />
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="css/icons.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/easy-responsive-tabs.css " />
        <link rel="stylesheet" type="text/css" href="css/flexslider.css " />
        <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
        <!--[if lt IE 8]><!-->
        <link rel="stylesheet" href="ie7/ie7.css">
        <!--<![endif]-->
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <style>
            .table{
                width: 1000px;
                margin: auto;
                font-size: 17px;
                padding: 7px;
                text-align: center;
                border: 2px solid black;
                border-collapse: collapse;
            }
            .header{
                position: fixed;
                background: pink;
                width:100%;
                top: 0;
                left: 0;
                padding: 20px 100px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                z-index: 100;
                margin-bottom: 100px;
            }
            .space{
                margin-top:100px;
                margin-bottom: 150px;

            }
            .container{
                text-decoration: none;
                display: inline-block;
                padding: 8px 16px;

                color: black;
            }
            .body{
                background: #ebecf1;
                list-style: none;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                display: flex;
                justify-content: center;
            }
            .view_main{
                background: #fff;
                border-radius: 3px;
                padding: 15px;
            }
            .view_each{
                border: 1px solid #e2efe1;
                margin: 10px;
                padding: 10px 20px;

            }
            .view_each:last-child{
                margin-bottom: 0;
            }
            .view_right{

                position:relative;
                top:0px;
                left:500px;
            }
            .infor_left{
                position: relative;
                width: 100%;
                height: 100%;
            }
            .infor_right{
                position: absolute;
                bottom: 0;
                right: 0;
            }
            .infor_right span{
                font-size: 24px;
                font-weight: bold;
            }


            .footer {
                background-color: #ebecf1;

                padding: 20px;
                text-align: center;
            }

            .footer a {

                text-decoration: none;
            }

            .footer a:hover {
                color: #ccc;
            }


            .header {
                background-color: #ffffff;

                padding: 20px;
                text-align: center;
            }

            .header img {
                max-width: 100%;
                height: auto;
            }

            .header .logo {
                float: left;
            }

            .header .nav {
                float: right;
            }

            .header .nav a {
                color: black;
                text-decoration: none;
                margin-right: 20px;
            }

            .header .nav a:hover {
                color: #ccc;
            }
        </style>
    </head>
    <body class="body">
        <%@include file="HeaderCustomer.jsp"%>
        <div class="space">
            <div class="container">
                <a href='TransHistory.jsp'>&laquo; Quay về</a> 
            </div>
            <center >
                <h1>Lịch sử tai nạn</h1>
            </center>

            <div class="view_main">
                <div class="view_each">
                    <c:set var="pageSize" value="3" />
                    <c:set var="currentPage" value="${not empty param.page ? param.page : 1}" />
                    <c:set var="start" value="${(currentPage - 1) * pageSize}" />
                    <c:set var="end" value="${currentPage * pageSize-1}" />
                    <c:set var="totalContracts" value="${fn:length(listAccidentHistory)}" />

                    <c:forEach items="${listAccidentHistory}" var="listAccident" begin="${start}" end="${(end > totalContracts) ? totalContracts : end}">

                        <div class="view_left">

                            <div>Tên bệnh viện: ${listAccident.hospitalName}</div><br/>
                            <div>Địa chỉ: ${listAccident.address}</div><br/>
                            <div>Ngày xảy ra: ${listAccident.eventDate}</div><br/>
                            <div>Ngày vào viện: ${listAccident.fromDate}</div><br/>
                            <div>Ngày ra viện: ${listAccident.toDate}</div><br/>
                            <div>Loại chấn thương: ${listAccident.injuryType}</div><br/>
                            <div>Chẩn đoán: ${listAccident.diagnosis}</div><br/>
                        </div>
                        <div class="view_right">
                            <br/>
                            <br/>
                            <br/>
                        </div>

                    </c:forEach>
                </div>
            </div>
            <div style="text-align: center; margin-top: 20px;">
                <c:set var="totalPages" value="${(totalContracts + pageSize - 1) / pageSize}" />
                <c:forEach var="pageNumber" begin="1" end="${totalPages}">
                    <a href="?page=${pageNumber}">${pageNumber}</a>
                </c:forEach>
            </div>               
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
        <script src="js/jquery.flexslider-min.js"></script>
        <script src="js/easyResponsiveTabs.js"></script>
        <script src="js/owl.carousel.js"></script>
        <script src="js/custom.js"></script>
        <%@include file="Footer.jsp"%>
    </body>
</html>
