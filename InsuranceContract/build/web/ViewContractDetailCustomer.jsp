<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chi tiết hợp đồng</title>
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <style>

            h2 {
                margin-top: 30px;
                margin-bottom: 0;
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
                margin: 0 auto 16px auto;
                max-width: 1000px;
            }
            .policy-detail-content-header {
                padding: 16px 16px 16px 24px;
                display: flex;
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
                padding: 10px 16px 10px 24px;
            }
            .card-item {
                margin-bottom: 20px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .card-item-text {
                flex: 1;
                width: 53%
            }
            .card-item-value {
                flex: 1;
                align-items: flex-start;
                font-weight: 600;
                font-size: 14px;
                line-height: 20px;
                max-width: 47%;
                color: #425e7a;
            }
            .service-name {
                font-size: 14px;
                line-height: 20px;
                font-weight: 400;
                color: #333d47;
                padding: 10px 0 10px 24px;
            }
            .service-name:hover {
                background-color: #F4F8FB;
                cursor: pointer;
            }
            .agent-info {
                padding: 16px 24px;
            }
            .agent-name {
                font-weight: 600;
                font-size: 14px;
                color: #1f78ad;
                padding-bottom: 5px;
            }
            .agent-sub-name {
                font-size: 12px;
                color: #868b8c;
                padding-bottom: 12px;
                border-bottom: 1px solid #eeeff0;
            }
            .agent-actions {
                text-align: center;
                display: flex;
                align-items: center;
                justify-content: space-evenly;
                padding-top: 12px;
            }
            a {
                font-size: 14px;
                line-height: 20px;
                color: #333d47;
                align-items: center;
                display: flex;
            }
            a:hover {
                text-decoration: none;
                color: #00B2CE;
            }
            .vertical {
                margin: 0;
                height: 24px;
                border-left: 1px solid #eeeff0;
            }
            .flipped-icon {
                transform: scaleX(-1);
            }
            
            .container-back-action {
                max-width: 1000px;
                position: relative;
                margin: 0 auto;
            }
            button {
                position: absolute;
                margin-top: 30px;
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
            button:hover {
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <%@include file="HeaderCustomer.jsp"%> 

        <c:set var="c" value="${requestScope.contract}"/> 
        <div class="container">
            <div class="container-back-action">
                <button type="button" onclick="goBack()"><i class="fa fa-fw fa-chevron-left" style="margin-top: 5px;"></i>Trở về</button>
            </div>
            <h2 style="text-align: center;">Chi tiết hợp đồng</h2>
            <div class="policy-detail">
                <div class="policy-detail-number">
                    Số hợp đồng: ${c.contractID}
                </div>
                <div class="policy-detail-content" style="display: flex; justify-content: space-between;">
                    <div class="policy-detail-content-header">
                        <div class="product-name">
                            <c:forEach items="${requestScope.insuPackage}" var="p">
                                <c:if test="${p.packageID == c.packageID}">
                                    <div class="product-name">${p.packageName}</div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="policy-detail-content col-sm-7" style="margin-right: 16px; width: 68.4%;">
                        <div class="policy-detail-content-header" style="border-bottom: 1px solid #eeeff0;">
                            <div class="title">Thông tin hợp đồng</div>
                        </div>
                        <div class="policy-detail-content-body">
                            <div class="card-item">
                                <div class="card-item-text">Trạng thái</div>
                                <div class="card-item-value">
                                    <c:if test="${c.status == 'Có hiệu lực'}">
                                        <div class="value" style="color: #3da758">${c.status}</div>
                                    </c:if>
                                    <c:if test="${c.status == 'Không hiệu lực'}">
                                        <div class="value" style="color: #d31145">${c.status}</div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="card-item">
                                <div class="card-item-text">Người được bảo hiểm</div>
                                <div class="card-item-value">
                                    <c:forEach items="${requestScope.insuPerson}" var="p">
                                        <c:if test="${p.insuranID == c.insuranID}">
                                            <div class="value">${p.fullName}</div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="card-item">
                                <div class="card-item-text">Bên mua bảo hiểm</div>
                                <div class="card-item-value">${sessionScope.authcode.fullName}</div>
                            </div>
                            <div class="card-item">
                                <div class="card-item-text">Số tiền bảo hiểm</div>
                                <div class="card-item-value">
                                    <fmt:formatNumber value="${c.sumAssured}" pattern="#,##0 đ"/>
                                </div>
                            </div>
                            <div class="card-item">
                                <div class="card-item-text">Ngày hiệu lực</div>
                                <div class="card-item-value">${c.effectiveDate}</div>
                            </div>
                            <div class="card-item">
                                <div class="card-item-text">Ngày đáo hạn</div>
                                <div class="card-item-value">${c.maturityDate}</div>
                            </div>
                            <div class="card-item">
                                <div class="card-item-text">Ngày hết hạn</div>
                                <div class="card-item-value">${c.expiryDate}</div>
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
                                <div class="card-item-text">Định kỳ thanh toán</div>
                                <div class="card-item-value">${c.premiumMode}</div>
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
                    <div class="col-sm-4" style="width: 30%; padding: 0;">
                        <div class="policy-detail-content" style="margin-bottom: 16px;">
                            <div class="policy-detail-content-header" style="border-bottom: 1px solid #eeeff0;">
                                <div class="title">Các dịch vụ liên quan</div>
                            </div>
                            <div class="services" style="padding-bottom: 10px;">
                                <div class="service-name"><a href="#">Thanh toán phí bảo hiểm</a></div>
                                <div class="service-name"><a href="#">Tải bộ hợp đồng</a></div>
                                <div class="service-name"><a href="#">Bồi thường</a></div>
                                <div class="service-name"><a href="contractChangeInfo?contractID=${c.contractID}">Thay đổi định kỳ đóng phí</a></div>
                            </div>
                        </div>
                        <div class="policy-detail-content">
                            <div class="policy-detail-content-header" style="border-bottom: 1px solid #eeeff0;">
                                <div class="title">Đại lý</div>
                            </div>
                            <div class="agent-container">
                                <c:forEach items="${requestScope.staff}" var="s">
                                    <c:if test="${s.staffID == c.staffID}">
                                        <div class="agent-info">
                                            <div class="agent-name">
                                                <div class="value">${s.fullName}</div>
                                            </div>
                                            <div class="agent-sub-name">Chuyên viên chăm sóc khách hàng</div>
                                            <div class="agent-actions">
                                                <a href="tel:${s.phoneNumber}">
                                                    <i class="fa fa-fw fa-phone flipped-icon"></i>
                                                    <div class="value" style="padding-left: 5px;">${s.phoneNumber}</div></i>
                                                </a>
                                                <div class="vertical"></div>
                                                
                                                <a href="mailto:${s.email}">
                                                    <i class="fa fa-fw fa-envelope flipped-icon"></i>
                                                    <div class="value" style="padding-left: 5px;">Email</div></i>
                                                </a>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
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
    function goBack() {
        window.history.back();
    }
</script>
