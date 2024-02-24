<%-- 
    Document   : ManageCustomer
    Created on : Jan 17, 2024, 12:07:30 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang chủ quản lí</title>
    <style>
        .container {
            background: #f7f7f8;
            display: flex;
        }

        .sidebar {                        
            background-color:#fff;
            padding: 20px;
/*            position: fixed;*/
            top: 72px; 
            left: 0;
            width: 13%;
            height:auto;
            overflow-y: auto;
            z-index: 1000;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
        }

        .sidebar ul li {
            border-bottom: 1px solid #ccc;
        }

        .sidebar ul li a {
            text-decoration: none;
            color: #333;
            display: block;
            padding: 10px 0;
        }

        .sidebar ul li:last-child {
            border-bottom: none;
        }

        .header-spacer {
            height: 60px;
        }

        .content {
            flex: 1;
            padding: 20px;
        }
        .homepage {
            margin: 24px 60px 0 80px;
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
            font-size: 24px;
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

        .search-bar {
                display: flex;
                align-items: center;
            }

        .search-bar input[type="text"] {
                padding: 8px;
                margin-right: 5px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

        .search-bar input[type="submit"] {
                padding: 8px 15px;
                background-color: #00B2CE;
                color: #fff;
                border: none;
                cursor: pointer;
                border-radius: 5px;

                .list-customer {
                    display: flex;
                    flex-direction: column;
                    align-items: flex-start;
                }

                .title {
                    font-weight: bold;
                    font-size: 1.2em;
                }

                .search-bar {
                    display: flex;
                }

                .list-search{
                    align-items: end;
                }

            }

        .homepage-customer {
            margin-top: 10px;
        }

        body {
            font-family: Arial, sans-serif;
        }

        .hidden {
            display: none;
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
            /*                justify-content: space-between;
                            display: flex;
                            flex-flow: row wrap;
                            cursor: pointer;*/

            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .policy-card-wrapper {
            width: 368px;
        }
        .policy-card {
            border-radius: 8px;
            padding: 16px;
            width: calc(33.33% - 24px);
            ;
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

        #scrollToTopBtn {
            height: 45px;
            width: 45px;
            display: none;
            position: fixed;
            bottom: 20px;
            right: 20px;
            z-index: 99;
            border: none;
            outline: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            padding-top: 5px;
            border-radius: 5px;
            transition: all 0.3s ease;
        }

        #scrollToTopBtn:hover {
            background-color: #0056b3;
        }

    </style>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <%
        String message = (String) request.getAttribute("message");
        if ("success".equals(message)) {
    %>
    <script type="text/javascript">
        window.alert("Tạo hợp đồng thành công.");
    </script>
    <%
        }else if("createCustomer".equals(message)){
    %>
    <script type="text/javascript">
        window.alert("Tạo khách hàng thành công.");
    </script>
    <%
        }
    %>   
    <%@include file="HeaderStaff.jsp"%>

    <div class="container"> 
        <div class="sidebar">
            <ul>
                <li><a href="#manageCustomers">Quản lí khách hàng</a></li>
                <li><a href="#contractDetailStaff">Quản lí hợp đồng</a></li>
                <li><a href="#manageRequests">Quản lí yêu cầu</a></li>
            </ul>
        </div>
        <div class="content">            
            <div class="homepage">
                <div class="homepage-header">
                    <div class="homepage-header-right">
                        <div class="homepage-header-fullname">Xin chào, ${sessionScope.authcode.fullName}</div>                        
                    </div>
                    <div class="homepage-header-right" style="display: flex">
                        <div class="homepage-header-item">
                            <a href="createinsuperson"><button class="title">Tạo hợp đồng</button></a>
                        </div>
                        <div class="homepage-header-item">
                            <a href="contractDetailStaff"><button class="title">Quản lí hợp đồng</button></a>
                        </div>
                        <div class="homepage-header-item">
                            <a href="contactForm"><button class="title">Quản lí đơn liên hệ</button></a>
                        </div>
                        <div class="homepage-header-item">
                            <a href="viewListRequest"><button class="title">Quản lí yêu cầu</button></a>
                        </div>
                    </div>
                </div>

                <div class = "list-customer">
                    <div class = "list-customer-top" style="display: flex; justify-content: space-between; align-items: center;">
                        <h2 id="manageCustomers">Danh sách khách hàng</h2>
                        <div class="list-search" style="margin-left: auto; display: flex;">                                                   
                            <form class="search-bar" action="" method="">
                                <input type="text" name="">
                                <input type="submit" value="Search">
                            </form>
                            <!--<a href="createinsuperson"><button>Tạo hợp đồng</button></a>-->
                        </div>
                    </div>                                

                    <div class="customer-card-container">
                        <div class="policies-container">
                            <c:forEach items="${requestScope.listCustomer}" var="customer">
                                <div class="policy-card" onclick="redirectProfile('${customer.customerID}')">

                                    <div class="policy-info-header">
                                        <div class="customer-id">Mã: ${customer.customerID}</div>                                                                       
                                    </div>

                                    <div class="policies-info-item" style="margin-top: 12px;">
                                        <div class="text">Họ và tên</div>
                                        <div class="value">${customer.fullName}</div>    
                                    </div>

                                    <div class="policies-info-item">
                                        <div class="text">Số điện thoại</div>
                                        <div class="value">${customer.phoneNumber}</div>
                                    </div>

                                    <div class="policies-info-item" style="border-bottom: 1px solid #eeeff0; padding-bottom: 12px;">
                                        <div class="text">Email</div>
                                        <div class="value">${customer.email}</div>
                                    </div>

                                    <div class="policy-info-footer">
                                        <div style="color: #333d47">Nhấn vào đây để xem chi tiết</div>
                                        <div class="fas fa-arrow-right" style="color: #00B2CE"></div>
                                    </div>

                                </div>
                            </c:forEach>

                        </div>

                        <h2 id="contractDetailStaff">Danh sách hợp đồng</h2>

                        <div class="policies-container" onclick="redirectContract()">
                            <c:forEach items="${requestScope.contractList}" var="contract">
                                <div class="policy-card">                                    
                                    <div class="policy-info-header">                                       
                                        <c:forEach items="${requestScope.insuPackage}" var="p">
                                            <c:if test="${p.packageID == contract.packageID}">
                                                <div class="product-name">${p.packageName}</div>
                                            </c:if>
                                        </c:forEach>                                            
                                        <span class="policy-number">${contract.contractID}</span>
                                    </div>

                                    <div class="policies-info-item" style="margin-top: 12px;">
                                        <div class="text">Trạng thái</div>
                                        <c:if test="${contract.status == 'Có hiệu lực'}">
                                            <div class="value" style="color: #3da758">${contract.status}</div>
                                        </c:if>
                                        <c:if test="${contract.status == 'Không hiệu lực'}">
                                            <div class="value" style="color: #d31145">${contract.status}</div>
                                        </c:if>
                                    </div>

                                    <div class="policies-info-item">
                                        <div class="text">Bên mua bảo hiểm</div>
                                        <c:forEach items="${requestScope.listCustomer}" var="customer">
                                            <c:if test="${customer.customerID == contract.customerID}">
                                                <div class="value" style="color: #333d47">${customer.fullName}</div>
                                            </c:if>
                                        </c:forEach>
                                    </div>

                                    <div class="policies-info-item" style="border-bottom: 1px solid #eeeff0; padding-bottom: 12px;">
                                        <div class="text">Người được bảo hiểm</div>
                                        <c:forEach items="${requestScope.insuPerson}" var="p">
                                            <c:if test="${p.insuranID == contract.insuranID}">
                                                <div class="value">${p.fullName}</div>
                                            </c:if>
                                        </c:forEach>
                                    </div>

                                    <div class="policy-info-footer">
                                        <div style="color: #333d47">Nhấn vào đây để xem chi tiết</div>
                                        <div class="fas fa-arrow-right" style="color: #00B2CE"></div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

            <button onclick="scrollToTop()" id="scrollToTopBtn">
                <span class="material-symbols-outlined">
                    arrow_upward
                </span>
            </button>
        </div>
    </div>
    <%@include file="Footer.jsp"%>
</body>
</html>
    <script>
        
        window.addEventListener('scroll', function() {
            var sidebar = document.getElementById('sidebar');
            var headerHeight = 72; // Height of the fixed header
            var additionalSpace = 40; // Additional space between header and sidebar
            var scrollTop = window.pageYOffset || document.documentElement.scrollTop;
            if (scrollTop > headerHeight) {
                sidebar.style.maxHeight = 'calc(100% - ' + (headerHeight + additionalSpace) + 'px)';
            } else {
                sidebar.style.maxHeight = 'calc(100% - ' + (scrollTop + additionalSpace) + 'px)';
            }
        });
        
        function redirectContract() {
            window.location.href = 'contractDetailStaff';
        }

        function redirectProfile(customerID) {
            window.location.href = 'viewCustomerProfile?customerID=' + customerID;
        }

        document.addEventListener('DOMContentLoaded', function () {
            var links = document.querySelectorAll('.sidebar a');

            links.forEach(function (link) {
                link.addEventListener('click', function (e) {
                    e.preventDefault();
                    var targetId = this.getAttribute('href').substring(1);
                    var targetElement = document.getElementById(targetId);

                    if (targetElement) {
                        targetElement.scrollIntoView({behavior: 'smooth'});
                    }
                });
            });
        });

        window.onscroll = function () {
            scrollFunction()
        };

        function scrollFunction() {
            if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                document.getElementById("scrollToTopBtn").style.display = "block";
            } else {
                document.getElementById("scrollToTopBtn").style.display = "none";
            }
        }

        function scrollToTop() {
            
            var targetElement = document.getElementById('toppage');
            
            targetElement.scrollIntoView({behavior: 'smooth'});
        }
    </script>
