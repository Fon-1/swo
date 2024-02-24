<%-- 
    Document   : ViewCustomerProfile
    Created on : Jan 20, 2024, 1:54:55 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết khách hàng</title>
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
        <c:set var="c" value="${requestScope.customer}"/>
        <button class="back-button" onclick="goBack()">Trở về</button>
        <div class="profile-container">
            <div class="profile-info"> 
                <div class="profile-info-top">
                    <div class="profile-tile">Thông tin cá nhân</div>
                    <div class="update-button" onclick="redirect()">Cập nhật</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">Mã khách hàng</div>
                    <div class="content">${c.customerID}</div>
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
                        <div class="content">${c.DOB}</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">CCCD</div>
                    <div class="content">${c.CCCD}</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">Quốc tịch</div>
                    <div class="content">${c.nationality}</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">Nghề nghiệp</div>
                    <div class="content">${c.job}</div>
                </div>                
                <div class="profile-info-item">
                    <div class="lable">Số điện thoại</div>
                    <div class="content">${c.phoneNumber}</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">Email</div>
                    <div class="content">${c.email}</div>
                </div>
                <div class="profile-info-item">
                    <div class="lable">Địa chỉ</div>
                    <div class="content">${c.address}</div>
                </div>
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
                <div class="content">${c.customerID}</div>
            </div>
            <div class="profile-info-item">
                <div class="lable">Mật khẩu</div>
                <div class="content" id="password">${c.password}</div>
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
