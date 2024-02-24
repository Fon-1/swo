<%-- 
    Document   : CustomerDetail
    Created on : Jan 22, 2024, 8:57:19 PM
    Author     : Nunulac
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hồ sơ</title>
        <style>

            .profile-container{
                padding: 24px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0px 0px 40px rgba(155, 155, 155, 0.1);
                position: relative;
                display: block;
                width: 100%;
                max-width: 792px;
                margin: auto;
                margin-top: 40px
            }

            .profile-info-top {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 10px;
            }

            .update-button {
                color: #00B2CE;
            }

            .profile-tile{
                font-weight: bold;
            }

            .profile-info-item {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                margin-bottom: 10px;
            }

            .lable {
                flex: 1;
                margin-right: 10px;
            }

            .content {
                flex: 2;
                text-align: left;
            }

            .logout{
                margin-left: 22%;
                width: 100%;
                max-width: 100px;
                margin-top: 10px;
            }
            .button-title{
                background-color: #00B2CE;
            }
            .custom-button {
                display: inline-block;
                min-width: 112px;
                max-height: 46px;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                font-weight: bold;
                color: #000;
                background-color: #fff;
                border: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                
            }

            .custom-button:hover {
                background-color: #1394a8;
                color: #fff;
            }
            
            .logout-wrapper { 
                padding-top:15px;
                left: 20px;
                top: 40px;
            }
            
            .join{
                position: relative;
                display: block;
                width: 100%;
                max-width: 800px;
                margin: auto;
                margin-top: 40px
            }
            
            .back-button {
                position: absolute;
                min-width: 100px;
                max-height: 46px;
                top: 15%;
                left: 13%;
                background-color: #fff;
                color: #000;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                text-align: center;                
                font-weight: bold;
                transition: background-color 0.3s ease;
            }
            .back-button:hover {
                background-color: #1394a8;
                color: #fff;
            }

        </style>
    </head>
    <body>
        <%@include file="HeaderStaff.jsp"%>
        <c:set var="c" value="${sessionScope.authcode}"/>
        <button class="back-button" onclick="goBack()">Trở về</button>
        <div class="join">        
        <div class="profile-container">
            <div class="profile-info"> 
                <div class="profile-info-top">
                    <div class="profile-tile">Thông tin cá nhân</div>
                    <div class="update-button" onclick="redirect()">Cập nhật</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">Mã khách hàng</div>
                    <div class="content">${c.staffID}</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">Họ tên</div>
                    <div class="content">${c.fullName}</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">Giới tính</div>
                    <div class="content">
                        <c:if test="${c.gender == 1}">Nam</c:if>
                        <c:if test="${c.gender == 0}">Nữ</c:if>
                        </div>
                    </div>
                    <div class="profile-info-item">
                        <div class="lable">Ngày sinh</div>
                        <div class="content">${c.dob}</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">CCCD</div>
                    <div class="content">${c.cccd}</div>
                </div>                                
            </div>                                                
        </div>


        <div class="profile-container">
            <div class="profile-info"> 
                <div class="profile-info-top">
                    <div class="profile-tile">Thông tin liên hệ</div>
                    <div class="update-button">Cập nhật</div>
                </div>
            </div>            
            <div class="profile-info-item">
                <div class="lable">Số điện thoại</div>
                <div class="content">${c.phoneNumber}</div>
            </div>
            <div class="profile-info-item">
                <div class="lable">Email</div>
                <div class="content">${c.email}</div>
            </div>
        </div>


        <div class="profile-container">
            <div class="profile-info"> 
                <div class="profile-info-top">
                    <div class="profile-tile">Thông tin tài khoản</div>
                    <div class="update-button" onclick="changePass()">Cập nhật</div>
                </div>
            </div>            
            <div class="profile-info-item">
                <div class="lable">Tên đăng nhập</div>
                <div class="content">${c.staffID}</div>
            </div>
            <div class="profile-info-item">
                <div class="lable">Mật khẩu</div>
                <div class="content" id="password">${c.password}</div>
            </div>
        </div>
        <div class="logout-wrapper">
                <a href="logout" class="custom-button">Đăng xuất</a>
            </div>            
        </div>  
            
        <%@include file="Footer.jsp"%>
    </body>


    <script>
        function redirect() {
            window.location.href = 'updateProfile';
        }
        function changePass() {
            window.location.href = 'ChangePassword.jsp';
        }
        document.addEventListener("DOMContentLoaded", function () {
            var passwordElement = document.getElementById("password");
            var passwordValue = passwordElement.textContent;
            var hiddenPassword = "*********";
            passwordElement.textContent = hiddenPassword;
        });
        
        function goBack() {
        window.history.back();
        }
    </script>
</html>
