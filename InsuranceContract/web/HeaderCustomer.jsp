<%-- 
    Document   : Header
    Created on : Jan 31, 2024, 10:23:12 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f7f7f8;
            }

            .header {
                background-color: #ffff;
                padding: 15px 10px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .logo {
                text-decoration: none;
                color: #344659;
                display: flex;
                align-items: center;
            }
            .logo h2 {
                margin: 0 0 0 10px;
                font-size: 32px;
                font-weight: bold;
                display: flex;
                align-items: center;
            }
            .logo h2 span {
                color: #00B2CE;
                font-weight: normal;
                margin-left: 8px;
            }
            .icons-container {
                display: flex;
                gap: 20px 20px;
                margin-right: 10px;
            }
            i {
                font-size: 20px;
                /*margin-left: 24px;*/
                cursor: pointer;
            }
            a {
                color: black;
                text-decoration: none;
            }
            .account:hover {
                background-color: #f7f7f8;
            }
        </style>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    </head>

    <body>

        <div class="header">
            <a href="customerHomepage" class="logo">
                <h2>Bảo hiểm <span>nhân thọ</span></h2>
            </a>
            <div class="icons-container">
                <div style="padding: 10px 0;">
                    <i class="fas fa-envelope"></i>
                </div>
                <div style="padding: 10px 0;">
                    <i class="fas fa-bell"></i>
                </div>
                <div class="account" style="padding: 10px 0;">
                    <a href="viewCustomerDetail"><i class="fas fa-user"></i>
                        ${sessionScope.authcode.fullName}</a>
                </div>
            </div>
        </div>
    </body>

</html>
