<%-- 
    Document   : Login
    Created on : Feb 7, 2022, 10:43:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta charset="UTF-8">
        <!-- For IE -->

        <!-- For Resposive Device -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login page</title>
        <!-- Favicon -->
        <link rel="icon" type="image/png" sizes="56x56" href="images/fav-icon/icon.png">
        <!-- Bootstrap  -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <!-- Main style sheet -->
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>

    <body>
        <%-- Retrieve the alert message from the request attribute --%>

        <% String alertMessage1 = (String)request.getAttribute("alertMessage1");
        if (alertMessage1 != null && !alertMessage1.isEmpty()) {
        %>
        <script>
                        alert('<%= alertMessage1 %>');
        </script>
        <% } %>


        <!--        <div class="container" id="container">
                    <div class="form-container sign-up-container">
                        <form  class="form-signup" action ="signup" method="post">
                            <h1>Create Account</h1>
        
                            <span>or use your email for registration</span>
                            <input type="text" placeholder="CustomerID" name="newuser" />
                            <input type="email" placeholder="Email" name="email" />             
                            <input type="password" placeholder="Password" name="newpass">
                            <button type="submit">Sign Up</button>
        <% String alertMessage = (String)request.getAttribute("alertMessage");
if (alertMessage != null && !alertMessage.isEmpty()) {
        %>
        <script>
            alert('<%= alertMessage %>');
        </script>
        <% } %>

    </form>

</div>-->





        <div class="container-fluid login-1">
            <div class="container">
                <div class="login-form">
                    <div class="row align-items-center">
                        <div class="col-md-6">
                            <div class="img-box">
                                <img src="images/login-img.png" class="back-img" title="login" alt="welcome image">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="login-box">
                                <form class="form-signup" action ="login" method="post">
                                    <div class="form-group">
                                        <h4 class="login-title">Đăng Nhập</h4>
                                        <p class="login-p">điền mã tài khoản và mật khẩu vào ô phía dưới</p>
                                    </div>
                                    <div class="form-group">
                                        <input type="text"  value="${username}" placeholder="Mã tài khoản" name="user" class="form-control"/>
                                        <input type="password" value="${password}" placeholder="Mật khẩu" name="pass" class="form-control" />
                                        <% String errorMessage = (String)request.getAttribute("errorMessage");
                         if (errorMessage != null && !errorMessage.isEmpty()) {
                                        %>
                                        <h6 style="color: red;"><%= errorMessage %></h6>
                                        <% } %>
                                    </div>
                                    <div class="input-group check-field">

                                        <a href="/insurancecontract/EnterEmail.jsp" class="forgot">Quên mật khẩu?</a>
                                        
                                    </div>
                                    <div class="form-group text-center">
                                        <button type="submit" class="btn btn-primary">Đăng Nhập</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>




    </body>

</html>