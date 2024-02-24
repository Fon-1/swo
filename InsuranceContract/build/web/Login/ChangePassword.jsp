
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8">
        <title>Forgot Password page</title>
        <link rel="stylesheet" href="css/verify.css">
        <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
      <style>
            form {
                background-color: #fff;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                padding: 0 50px;
                height: 100%;
                text-align: center;
            }

            input {
                background-color: #eae9e9;
                border: none;
                padding: 12px 15px;
                margin: 8px 0;
                width: 50%;
            }
            button {

                border-radius: 20px;
                border: 1px solid #F2eee3;
                background-color: #529dff;
                color: white;
                font-size: 12px;
                font-weight: bold;
                padding: 12px 45px;
                letter-spacing: 1px;
                text-transform: uppercase;
                transition: transform 80ms ease-in;
                border-color: black;
            }
        </style>
    </head>
    <body>
        <div class="container" id="container">
            <div class="form-container sign-in-container">
                <form action="ChangePasswordControl" method="post">
                    <h1>Thay đổi mật khẩu</h1>
                     <input type="password" name="oldpass" placeholder="Mật khẩu của bạn "></input>
                    <input type="password" name="confirm" placeholder="Mật khẩu mới"></input>
                    <input type="password" name="reconfirm" placeholder="Xác nhận lại mật khẩu mới"></input>
                    <% String errorMessage = (String)request.getAttribute("errorMessage");
      if (errorMessage != null && !errorMessage.isEmpty()) {
                    %>
                     <h6 style="color: red;"><%= errorMessage %></h6>
                    <% } %>
                    <button type="submit" >Đổi mật khẩu</button>
                </form>
            </div>
        </div>
    </body>
</html>