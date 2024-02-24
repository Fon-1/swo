<%-- 
    Document   : TransHistory
    Created on : Jan 18, 2024, 6:33:30 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Lịch sử giao dịch</title>
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
            .buttonleft{
                background-color: #344659;
                position: absolute;
                transform: translate(-50%,-50%);
                top: 50%;
                left: 30%;
                padding: 20px 50px;
                font-size: 30px;
                font-weight: bold;
                color: white;
            }

            .buttonright{
                background-color: #344659;
                position: absolute;
                transform: translate(-50%,-50%);
                top: 50%;
                right: 5%;
                padding: 20px 50px;
                font-size: 30px;
                font-weight: bold;
                color: white;
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
                margin-top:150px;
                margin-bottom: 400px;
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
            .footer {
                background-color: #ebecf1;

                padding: 20px;
                text-align: center;
                position: fixed;
                bottom: 0;
                
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
            .footer {
                padding: 12px 12px;
            }
            .footer p {
                margin: 0;
                flex-grow: 1;
                text-align: center;
            }
        </style>
    </head>
    <body class="body">    
        <%@include file="HeaderCustomer.jsp"%>
        <div class="space">
            <div class="container">
                <a href='CustomerHomepage.jsp'>&laquo; Quay về</a> 
            </div>
            <center>
                <button class="buttonleft" type="button" onclick="location.href = 'viewAccidentHistory'">Xem lịch sử tai nạn</button>
                <button class="buttonright" type="button" onclick="location.href = 'viewPaymentHistory'">Xem lịch sử thanh toán</button>
            </center>
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
        <div class="footer">
            <p>© 2023-2024 Sản phẩm được xây dựng bởi Nhóm 6 của lớp SE1766.JS</p>           
        </div>
    </body>
</html>
