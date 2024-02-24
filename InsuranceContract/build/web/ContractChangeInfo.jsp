<%-- 
    Document   : ContractChangeInfo
    Created on : Feb 22, 2024, 4:42:57 PM
    Author     : maian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay đổi thông tin hợp đồng</title>

        <style>
            h2 {
                margin-top: 30px;
                margin-bottom: 30px;
                font-weight: 600;
                line-height: 32px;
                color: #333d47;
            }
            body {
                font-family: Open Sans, sans-serif;
                background-color: #f7f7f8;
                font-size: 16px;
            }
            .policy-detail-number {
                text-align: center;
                padding: 8px 0 24px 0;
                font-size: 16px;
                color: #425e7a;
            }
            .policy-detail-content {
                background: #ffffff;
                box-shadow: 0px 0px 40px rgba(155, 155, 155, 0.1);
                border-radius: 8px;
                margin: 0 auto 10px auto;
                max-width: 1000px;
            }
            .policy-detail-content-header {
                padding: 16px 16px 16px 24px;
                align-items: center;
                justify-content: space-between;
                width: 100%;
            }
            .product-name {
                font-weight: 600;
                font-size: 18px;
                line-height: 28px;
                color: #333d47;
            }
            .policy-action-container {
                width: 60%;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .policy-action {
                text-align: center;
                width: 33.33333333%;
                cursor: pointer;
            }
            .row {
                margin: 0 auto 16px auto;
                max-width: 1000px;
            }
            .title {
                font-weight: 600;
                font-size: 16px;
                line-height: 24px;
                color: #333d47;
            }
            .policy-detail-content-body {
                margin-top: 5px;
                padding: 10px 24px 10px 24px;
            }
            .card-item {
                margin-bottom: 16px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .card-item-text {
                flex: 1;
                width: 53%;
                color: #425e7a;
            }
            .card-item-value {
                flex: 1;
                text-align: right;
                align-items: flex-start;
                font-weight: 600;
                line-height: 20px;
                max-width: 47%;
                color: #425e7a;
            }
            .button {
                flex: 1;
                width: 100%;
                text-align: center;
                padding-top: 10px;
                padding-bottom: 10px;
                border: 1px solid #425e7a;
                border-radius: 8px;
                font-size: 14px;
            }
            .button:hover {
                border-color: #1F78AD;
                background-color: #E9F2F7;
                color: #1F78AD;
                cursor: pointer;
            }
            .button.selected {
                border-color: #1F78AD;
                background-color: #E9F2F7;
                color: #1F78AD;
            }

            .container-back-action {
                max-width: 1000px;
                position: relative;
                margin: 0 auto;
            }
            .back-action {
                position: absolute;
                font-size: 18px;
                font-weight: 600;
                line-height: 28px;
                display: flex;
                padding: 0px;
                min-width: 0px;
                height: fit-content;
                background-color: #f7f7f8;
                border: none;
            }
            .back-action:hover {
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <%@include file="HeaderCustomer.jsp"%> 

        <c:set var="c" value="${requestScope.contract}"/> 
        <div class="container">
            <div class="container-back-action">
                <div class="back-action" onclick="confirmExit();">
                    <i class="fa fa-fw fa-chevron-left" style="margin-top: 5px;"></i>
                    Thoát
                </div>            
            </div>
            <h2 style="text-align: center;">Điều chỉnh định kỳ đóng phí</h2>

            <div class="policy-detail">
                <div class="policy-detail-content">
                    <div class="policy-detail-content-header">
                        <div class="product-name">
                            <c:forEach items="${requestScope.insuPackage}" var="p">
                                <c:if test="${p.packageID == c.packageID}">
                                    ${p.packageName}
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="policy-detail-content-body" style="padding: 0 24px 10px 24px; margin-top: 0;">
                        <div class="card-item">
                            <div class="card-item-text">Số hợp đồng</div>
                            <div class="card-item-value">${c.contractID}</div>
                        </div>
                        <div class="card-item">
                            <div class="card-item-text">Người được bảo hiểm</div>
                            <div class="card-item-value">
                                <c:forEach items="${requestScope.insuPerson}" var="p">
                                    <c:if test="${p.insuranID == c.insuranID}">
                                        ${p.fullName}
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="policy-detail-content">
                    <div class="policy-detail-content-header" style="border-bottom: 1px solid #eeeff0;">
                        <div class="title">Định kỳ đóng phí hiện tại</div>
                    </div>
                    <div class="policy-detail-content-body">
                        <div class="card-item">
                            <div class="card-item-text">Định kỳ thanh toán</div>
                            <div class="card-item-value">${c.premiumMode}</div>
                        </div>
                        <div class="card-item">
                            <div class="card-item-text">Phí bảo hiểm định kỳ</div>
                            <div class="card-item-value">
                                <c:forEach items="${requestScope.detailFee}" var="d">
                                    <c:if test="${d.contractID == c.contractID}">
                                        <div class="value">
                                            <fmt:formatNumber value="${d.premiumPayment}" pattern="#,##0 đ"/>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="card-item">
                            <div class="card-item-text">Ngày đến hạn thanh toán</div>
                            <div class="card-item-value">
                                <c:forEach items="${requestScope.detailFee}" var="d">
                                    <c:if test="${d.contractID == c.contractID}">
                                        <div class="value">${d.paymentDueDate}</div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="policy-detail-content">
                    <div class="policy-detail-content-header" style="border-bottom: 1px solid #eeeff0;">
                        <div class="title">Thay đổi định kỳ đóng phí mới</div>
                    </div>
                    <div class="policy-detail-content-body">
                        <div class="card-item" style="gap: 14px;">
                            <c:if test="${c.premiumMode == 'Năm'}">
                                <div class="button" onclick="updatePayment('Nửa năm')">Nửa năm</div>
                                <div class="button" onclick="updatePayment('Quý')">Quý</div>
                                <div class="button" onclick="updatePayment('Tháng')">Tháng</div>
                            </c:if>
                            <c:if test="${c.premiumMode == 'Nửa năm'}">
                                <div class="button" onclick="updatePayment('Năm')">Năm</div>
                                <div class="button" onclick="updatePayment('Quý')">Quý</div>
                                <div class="button" onclick="updatePayment('Tháng')">Tháng</div>
                            </c:if>
                            <c:if test="${c.premiumMode == 'Quý'}">
                                <div class="button" onclick="updatePayment('Năm')">Năm</div>
                                <div class="button" onclick="updatePayment('Nửa năm')">Nửa năm</div>
                                <div class="button" onclick="updatePayment('Tháng')">Tháng</div>
                            </c:if>
                            <c:if test="${c.premiumMode == 'Tháng'}">
                                <div class="button" onclick="updatePayment('Năm')">Năm</div>
                                <div class="button" onclick="updatePayment('Nửa năm')">Nửa năm</div>
                                <div class="button" onclick="updatePayment('Quý')">Quý</div>
                            </c:if>
                        </div>
                        <div class="card-item">
                            <div class="card-item-text">Phí thanh toán định kỳ mới</div>
                            <div class="card-item-value" id="card-item-value">0 đ</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>                
    </div>

    <%@include file="Footer.jsp"%> 
</body>
</html>

<script>
    function confirmExit() {
        var confirmMessage = "Khi thoát, những thông tin sẽ không được lưu lại. Bạn có muốn tiếp tục không?";
        if (confirm(confirmMessage)) {
            window.location.href = "customerHomepage";
        }
    }

    var sumAssured = <%= requestScope.contract.sumAssured %>;
    function updatePayment(premiumMode) {
        var cardValueElement = document.getElementById("card-item-value");
        var premiumPayment;
        switch (premiumMode) {
            case "Năm":
                premiumPayment = (0.0011 * sumAssured + 430) * 12;
                break;
            case "Nửa năm":
                premiumPayment = (0.0011 * sumAssured + 430) * 6;
                break;
            case "Quý":
                premiumPayment = (0.0011 * sumAssured + 430) * 4;
                break;
            case "Tháng":
                premiumPayment = (0.0011 * sumAssured + 430);
                break;
            default:
                premiumPayment = 0;
        }
        cardValueElement.innerText = premiumPayment.toLocaleString() + " đ";

        var premiumOptions = document.querySelectorAll(".button");
        premiumOptions.forEach(function (option) {
            option.classList.remove("selected");
        });
        event.target.classList.add("selected");
    }
</script>
