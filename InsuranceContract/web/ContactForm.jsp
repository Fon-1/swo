<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Contact Form</title>
        <link rel="shortcut icon" href="images/favicon.png" />
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="css/icons.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/easy-responsive-tabs.css " />
        <link rel="stylesheet" type="text/css" href="css/flexslider.css " />
        <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
        <!--[if lt IE 8]><!-->
        <link rel="stylesheet" href="ie7/ie7.css">
        <!--<![endif]-->
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            table {
                width: 90%;
                margin: auto;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            .center {
                text-align: center;
            }
            .form-container {
                text-align: center;
            }

            /* Style cho label nằm ngang với ô chọn */
            .form-container label {
                display: inline-block;
                margin-bottom: 5px; /* Để tăng khoảng cách giữa label và ô chọn */
            }

            /* Style cho form */
            .form-container form {
                margin: 0 auto;
                width: 200px;
                text-align: left; /* Căn lề nội dung về bên trái */
            }
        </style>
    </head>

    <body data-spy="scroll" data-target=".navbar-fixed-top">

        <jsp:include page="HeaderStaff.jsp"></jsp:include>  
            <form action="contactForm" method="post">
                <div style="margin-top: 50px; display: flex; flex-direction: column; align-items: center;">
                    <h1 style="text-align: center;">Các đơn liên hệ</h1>
                    <div style="display: flex; justify-content: center; width: 100%;">
                        <!-- Form lọc -->
                        <div class="form-container" style="margin-right: 20px;">
                            <label for="statusFilter">Lọc theo trạng thái:</label>
                            <select name="statusFilter">
                                <option value="">Tất cả</option>
                                <option value="Đã trả lời" <% if ("Đã trả lời".equals(request.getAttribute("statusFilterValue"))) { %> selected <% } %>>Đã trả lời</option>
                            <option value="Đang chờ" <% if ("Đang chờ".equals(request.getAttribute("statusFilterValue"))) { %> selected <% } %>>Đang chờ</option>
                        </select>
                        <button type="submit" id="searchButton" name="actions" value="Filter">Lọc</button>
                    </div>

                    <!-- Form tìm kiếm -->
                    <div class="center">               
                        <label for="searchKeyword">Tìm kiếm bằng Email/Sđt:</label>
                        <input type="text" name="searchKeyword" id="searchInput" placeholder="Tìm kiếm..." 
                               value="<%= (request.getAttribute("searchKeywordValue") != null) ? request.getAttribute("searchKeywordValue") : "" %>">
                        <button type="submit" id="searchButton" name="actions" value="search">Tìm kiếm</button>
                    </div>
                </div>

                <c:set var="pageSize" value="5" />
                <c:set var="currentPage" value="${not empty param.page ? param.page : 1}" />
                <c:set var="start" value="${(currentPage - 1) * pageSize}" />
                <c:set var="end" value="${currentPage * pageSize-1}" />
                <c:set var="totalContactForms" value="${fn:length(contactFormList)}" />
                <table border="1">
                    <thead>
                        <tr>
                            <th>Mã khách</th>
                            <th>Họ và tên</th>
                            <th>Email</th>
                            <th>Số điện thoại</th>
                            <th>Nội dung tư vấn</th>
                            <th>Thời gian nộp</th>
                            <th>Trạng thái</th>
                            <th>Thời gian phản hồi</th>
                            <th>Cập nhật</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="contactForm" begin="${start}" end="${(end > totalContactForms) ? totalContactForms : end}" items="${contactFormList}">
                            <tr>
                                <td>${contactForm.guestID}</td>
                                <td>${contactForm.fullName}</td>
                                <td>${contactForm.email}</td>
                                <td>${contactForm.phoneNumber}</td>
                                <td>${contactForm.supportContent}</td>
                                <td>
                                    <fmt:formatDate value="${contactForm.submissionTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </td>
                                <td>${contactForm.status}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${not empty contactForm.responseTime}">
                                            <fmt:formatDate value="${contactForm.responseTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </c:when>
                                        <c:otherwise>
                                            <i></i>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <form action="contactForm" method="post">
                                        <input type="hidden" name="guestID" value="${contactForm.guestID}" />
                                        <input type="submit" name="actions" value="update" onclick="return confirmUpdate();"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div style="text-align: center; margin-top: 20px;">

                    <c:set var="totalPages" value="${(totalContactForms + pageSize - 1) / pageSize}" />
                    <c:set var="currentPage" value="${currentPage}" />
                    <c:set var="statusFilter" value="${sessionScope.statusFilter}" />
                    <c:set var="searchKeyword" value="${sessionScope.searchKeyword}" />
                    <c:if test="${totalPages <= 4}">
                        <c:forEach var="pageNumber" begin="1" end="${totalPages}">
                            <c:choose>
                                <c:when test="${pageNumber == currentPage}">
                                    <strong>${pageNumber}</strong>
                                </c:when>
                                <c:otherwise>
                                    <a href="?page=${pageNumber}">${pageNumber}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:if>

                    <c:if test="${totalPages > 4}">
                        <a href="?page=1">1</a>
                        <c:if test="${currentPage > 3}">...</c:if>
                        <c:forEach var="pageNumber" begin="${currentPage - 1}" end="${currentPage + 1}" varStatus="loop">
                            <c:if test="${pageNumber > 1 and pageNumber < totalPages}">
                                <c:choose>
                                    <c:when test="${pageNumber == currentPage}">
                                        <strong>${pageNumber}</strong>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="?page=${pageNumber}">${pageNumber}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <c:if test="${currentPage < totalPages.intValue() - 2}">...</c:if>
                        <c:if test="${currentPage != totalPages.intValue() && currentPage != totalPages.intValue()-1}">
                            <a href="?page=${totalPages.intValue()}">${totalPages.intValue()}</a>
                        </c:if>
                    </c:if>
                </div>
        </form>
        <div style="margin-bottom: 100px;"></div>
        <jsp:include page="Footer.jsp"></jsp:include>  
        <script type="text/javascript">
            function confirmUpdate() {
                var confirmation = confirm("Bạn có chắc chắn muốn update chứ?");
                return confirmation;
            }
        </script>
    </body>

</html>
