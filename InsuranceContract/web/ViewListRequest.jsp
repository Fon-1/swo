<%-- 
    Document   : ManageRequest
    Created on : Jan 23, 2024, 2:16:44 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý yêu cầu</title>
        <style>
            body {
                font-family: Open Sans, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }
            .request-title {
                padding: 12px;
                text-align: center;
                font-size: 24px;
                margin-bottom: 12px;
            }
            .inbox-container {
                width: 80%;
                max-width: 800px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                position: relative;
                transform: translate(-50%, 50%);
                top: 50%;
                left: 50%;
                margin-top: 12px;
            }
            .request-list {
                border-right: 1px solid #ddd;
                flex: 1;
                overflow-y: auto;
                max-height: 400px;
            }
            .request {
                padding: 15px;
                border-bottom: 1px solid #ddd;
                cursor: pointer;
                transition: background-color 0.3s;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .request:hover {
                background-color: #f9f9f9;
            }
            .request.active {
                background-color: #f1f1f1;
            }
            .request-detail{
                display: flex;
                justify-content: space-between;
            }

            .back-button {
                position: absolute;
                top: 20px;
                left: 200px;
                background-color: #00B2CE;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
            }
            .back-button:hover {
                background-color: #344659;
            }
        </style>
    </head>
    <body>        
        <div class="request-title">
            <h2>Quản lý yêu cầu hồ sơ khách hàng</h2>
        </div>
        <button class="back-button" onclick="goBack()">Trở về</button>
        <div class="inbox-container">
            <c:forEach items="${requestScope.listRequestUpdateProfile}" var="lq">
                <div class="request-list" id="request-list">
                    <div class="request" onclick="redirectDetail('${lq.requestID}')">
                        <div class="request-customerID">${lq.customerID}</div>
                        <div class="request-detail">
                            <div class="detail-date" style="margin-right: 30px;">${lq.timeCreate}</div>
                            <div class="detail-content" style="margin-right: 30px;">Yêu cầu thay đổi thông tin</div>
                            <div class="detail-status">${lq.status}</div>
                        </div>
                        <div>&gt;</div>
                    </div>
                </div>
            </c:forEach>
            <div class="pagination" id="pagination"></div>
        </div>
    </body>
</html>
<script>
    function redirectDetail(requestID) {
        window.location.href = 'updateCustomerProfile?requestID=' + requestID;
    }
    function goBack() {
        window.history.back();
    }
</script>

