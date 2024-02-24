<%-- 
    Document   : CustomerHomePage
    Created on : Jan 21, 2024, 1:14:23 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ khách hàng</title>
        <style>
            .container {
                background: #f7f7f8;
            }
            .homepage {
                margin: 24px 80px 0 80px;
                padding: 24px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0px 0px 40px rgba(155, 155, 155, 0.1);
                position: relative;
                display: block;
            }
            .homepage-header {
                display: flex;
                align-items: center;
                justify-content: space-between;
                border-bottom: 1px solid #eeeff0;
                padding-bottom: 10px;
            }
            .homepage-header-right {
                display: block;
                margin: 16px 0;
                gap: 16px 16px;
                color: #333d47;
            }
            .homepage-header-fullname {
                font-weight: 600;
                font-size: 16px;
                line-height: 24px;
            }
            .homepage-header-experience {
                font-size: 14px;
                line-height: 24px;
                color: #5b636b;
            }
            .homepage-header-item {
                height: 40px;
                display: flex;
                border: 1.5px solid transparent;
                border-radius: 8px;
            }
            .title:hover {
                background-color: #00B2CE;
                color: #fff;
                cursor: pointer;
            }
            button {
                width: 140px;
                height: 50px;
                border-radius: 5px;
                border: 1px solid #f7f7f8;
                padding: 0 10px;
            }
            .policies-header {
                display: flex;
                justify-content: space-between;
                margin-top: 30px;
                margin-bottom: 16px;
            }
            .total-policies {
                font-weight: 600;
                margin-top: 16px;
                color: #333d47;
                line-height: 28px;
            }
            .policies-container {
                display: flex;
                justify-content: space-between;
                flex-flow: row wrap;
            }
            .policies-container-body {
                cursor: pointer;
            }
            .policy-card-wrapper {
                width: 368px;
            }
            .policy-card {
                border-radius: 8px;
                padding: 16px;
                width: 100%;
                min-height: 192px;
                display: block;
                margin-bottom: 24px;
                border: 1px solid #eeeff0;
                box-sizing: border-box;
            }
            .policy-info-header {
                line-height: 20px;
                color: #333d47;
                border-bottom: 1px solid #eeeff0;
                padding-bottom: 12px;
            }
            .product-name {
                max-width: 100%;
                height: 40px;
                color: #333d47;
            }
            .policy-number {
                color: #868b8c;
                font-weight: 600;
                font-size: 14px;
                line-height: 20px;
            }
            .policies-info-item {
                display: flex;
                justify-content: flex-start;
                margin-top: 8px;
                position: relative;
            }
            .text {
                color: #848a90;
                flex: 1;
                font-size: 14px;
            }
            .value {
                flex: 1;
                font-weight: 600;
                font-size: 14px;
            }
            .policy-info-footer {
                padding-top: 12px;
                font-size: 14px;
                display: flex;
                justify-content: space-between;
            }
        </style>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    </head>
    <body>
        <%
            String SendRequestMessage = (String) request.getAttribute("SendRequestMessage");
            if ("SendRequestMessageSuccess".equals(SendRequestMessage)) {
        %>
        <script type="text/javascript">
            window.alert("Gửi yêu cầu thành công");
        </script>
        <%
            }
        %>

        <%@include file="HeaderCustomer.jsp"%>

        <div class="container">
            <div class="homepage">
                <div class="homepage-header">
                    <div class="homepage-header-right">
                        <div class="homepage-header-fullname">Xin chào, ${sessionScope.authcode.fullName}</div>
                        <div class="homepage-header-experience">Cùng trải nhiệm các dịch vụ bảo hiểm</div>
                    </div>
                    <div class="homepage-header-right" style="display: flex">
                        <div class="homepage-header-item">
                            <a href="#"><button class="title">Yêu cầu thay đổi</button></a>
                        </div>
                        <div class="homepage-header-item">
                            <a href="#"><button class="title">Yêu cầu bồi thường</button></a>
                        </div>
                        <div class="homepage-header-item">
                            <a href="TransHistory.jsp"><button class="title">Lịch sử giao dịch</button></a>
                        </div>
                    </div>
                </div>

                <div class="policies-header">
                    <div class="total-policies">
                        Hợp đồng bảo hiểm (${requestScope.size})
                    </div>
                </div>

                <div class="policies-container">
                    <c:forEach items="${requestScope.contract}" var="c">
                        <div class="policies-container-body" onclick="redirect('${c.contractID}')">
                            <div class="policy-card-wrapper">
                                <div class="policy-card">
                                    <div class="policy-info-header">
                                        <c:forEach items="${requestScope.insuPackage}" var="p">
                                            <c:if test="${p.packageID == c.packageID}">
                                                <div class="product-name">${p.packageName}</div>
                                            </c:if>
                                        </c:forEach>
                                        <span class="policy-number">${c.contractID}</span>
                                    </div>

                                    <div class="policies-info-item" style="margin-top: 12px;">
                                        <div class="text">Trạng thái</div>
                                        <c:if test="${c.status == 'Có hiệu lực'}">
                                            <div class="value" style="color: #3da758">${c.status}</div>
                                        </c:if>
                                        <c:if test="${c.status == 'Không hiệu lực'}">
                                            <div class="value" style="color: #d31145">${c.status}</div>
                                        </c:if>
                                    </div>
                                    <div class="policies-info-item">
                                        <div class="text">Bên mua BH</div>
                                        <div class="value" style="color: #333d47">${sessionScope.authcode.fullName}</div>
                                    </div>
                                    <div class="policies-info-item" style="border-bottom: 1px solid #eeeff0; padding-bottom: 12px;">
                                        <div class="text">Người được BH</div>
                                        <c:forEach items="${requestScope.insuPerson}" var="p">
                                            <c:if test="${p.insuranID == c.insuranID}">
                                                <div class="value">${p.fullName}</div>
                                            </c:if>
                                        </c:forEach>
                                    </div>

                                    <div class="policy-info-footer">
                                        <div style="color: #333d47">Nhấn vào đây để xem chi tiết</div>
                                        <div class="fas fa-arrow-right" style="color: #00B2CE"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <%@include file="Footer.jsp"%> 

    </body>
</html>

<script>
    function redirect(contractID) {
        window.location.href = 'contractDetail?contractID=' + contractID;
    }
</script>