<%-- 
    Document   : verify
    Created on : Jan 18, 2024, 11:42:30 PM
    Author     : hoang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Change password page</title>
        <!-- Favicon -->
        <link rel="icon" type="image/png" sizes="56x56" href="images/fav-icon/icon.png">
        <!-- Bootstrap  -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <!-- Main style sheet -->
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
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
                                <form action="ChangePassFirstTime" method="post">
                                    <div class="form-group">
                                        <h4 class="login-title">Tạo mật khẩu</h4>
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" name="customerid" value="${param.customerid}" class="form-control">
                                        <input type="password" name="confirm" placeholder="Mật khẩu mật mới" class="form-control"></input>
                                        <input type="password" name="reconfirm" placeholder="Nhập lại mật khẩu mật mới" class="form-control"></input>
                                        <% String errorMessage = (String)request.getAttribute("errorMessage");
                          if (errorMessage != null && !errorMessage.isEmpty()) {
                                        %>
                                        <h6 style="color: red;"><%= errorMessage %></h6>
                                        <% } %>
                                    </div>
                                    <div class="form-group text-center">
                                        <button type="submit" class="btn btn-primary" >Tạo mật khẩu</button>
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
