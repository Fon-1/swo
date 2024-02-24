<%-- 
    Document   : UpdateCustomerContact
    Created on : Jan 20, 2024, 11:37:43 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay đổi thông tin liên hệ</title>       
        <style>
            body, h1, h2, h3, p, ul, li {
                margin: 0;
                padding: 0;
            }
            body {
                font-family: Open Sans, sans-serif;
            }
            .update-container {
                background-color: #f7f7f8;
            }
            .update-title {
                padding-top: 8px;
                text-align: center;
                font-size: 24px;
            }

            /* Form container styling */
            .update-info {
                background: #ffffff;
                box-shadow: 0px 0px 40px rgba(155, 155, 155, 0.1);
                border-radius: 8px;
                padding: 32px 65px 32px 65px;
                margin: 24px auto;
                max-width: 600px;
            }
            .update-info-item {
                margin-bottom: 20px;
            }
            .errors {
                color: red;
            }
            .imgCCCD-container {
                display: flex;
                justify-content: space-between;
            }
            .submit {
                background-color: #00B2CE;
                color: white;
                cursor: pointer;
                display: block;
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                font-size: 16px;
            }
            .submit:hover {
                background-color: #344659;
            }
            .cancel {
                background-color: #00B2CE;
                color: white;
                cursor: pointer;
                display: block;
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                font-size: 16px;
            }
            .cancel:hover {
                background-color: #C2344A;
            }

            /* Style for the square file input */
            .img-content {
                display: block;
                width: 264px;
                height: 140px;
                font-size: 16px;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 8px;
                background-color: #fff;
                cursor: pointer;
                text-align: center;
                line-height: 130px;
                overflow: hidden;
            }
            .img-content:hover {
                background-color: #f5f5f5;
            }
            .img-content:focus {
                outline: none;
                border-color: #00B2CE;
                box-shadow: 0 0 5px #344659;
            }

            /* Style for the text input */
            .content {
                display: block;
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                font-size: 16px;
            }
            .content:hover {
                border-color: #00B2CE;
            }
            .content:focus {
                outline: none;
                border-color: #00B2CE;
                box-shadow: 0 0 5px #344659;
            }
            .label{
                font-size: 12px;
                opacity: 0.8;
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
        <%@include file="HeaderStaff.jsp"%>
        <div class="update-container">
            <div class="update-title">
                <h2>Yêu cầu thay đổi thông tin cá nhân</h2>
            </div>
            <button class="back-button" onclick="goBack()">Trở về</button>
            <c:set var="ru" value="${requestScope.requestUpdate}" />
            <div class="update-info">
                <form action="updateCustomerProfile" method="post">                    
                    <div class="update-info-item">
                        <div class="label">ID Khách hàng: ${ru.customerID}</div>
                        <input type="hidden" name="customerID" value="${ru.customerID}" >
                        <input type="hidden" name="requestID" value="${ru.requestID}" readonly>
                    </div>
                    <div class="imgCCCD-container">
                        <div class="update-info-item">
                            <div class="label">Mặt trước CCCD</div>
                            <img class="img-content" src="imgFile/${ru.CCCD_imgFront}" alt="${ru.CCCD_imgFront}" >
                        </div>
                        <div class="update-info-item">
                            <div class="label">Mặt sau CCCD</div>
                            <img class="img-content" src="imgFile/${ru.CCCD_imgBack}" alt="${ru.CCCD_imgBack}" >
                        </div>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Số CCCD<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="cccd" value="${ru.CCCD}" >
                    </div>
                    <div class="update-info-item">
                        <div class="label">Họ và tên<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="fullName" value="${ru.fullName}" >
                    </div>
                    <div class="update-info-item">
                        <div class="label">Ngày sinh<span style="color: red;">*</span> (tháng / ngày / năm)</div>
                        <input class="content" type="date" name="dob" value="${ru.dob}" >
                    </div>
                    <div class="update-info-item">
                        <div class="label">Giới tính<span style="color: red;">*</span></div>
                        <select class="content" name="gender">
                            <option value="1" ${ru.gender == 1 ? "selected":""}>Nam</option>
                            <option value="0" ${ru.gender == 0 ? "selected":""}>Nữ</option>
                        </select>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Quốc tịch<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="nationality" value="${ru.nationality}" >
                    </div>
                    <div class="update-info-item">
                        <div class="label">Ngày cấp<span style="color: red;">*</span> (tháng / ngày / năm)</div>
                        <input class="content" type="date" name="issuedDate" value="${ru.issuedDate}" >
                    </div>
                    <div class="update-info-item">
                        <div class="label">Ngày hết hạn<span style="color: red;">*</span> (tháng / ngày / năm)</div>
                        <input class="content" type="date" name="expiredDate" value="${ru.expiredDate}" >
                    </div>
                    <div class="update-info-item">
                        <div class="label">Nơi cấp<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="issuedPlace" value="${ru.issuedPlace}" >
                    </div>
                    <div class="martial-container" style="display: flex;">
                        <div class="update-info-item">
                            <div class="label">Đăng kí kết hôn/Đơn ly hôn hoặc Giấy tờ khác</div>
                            <img class="img-content" src="imgFile/${ru.marital_img}" alt="${ru.marital_img}" >
                        </div>
                        <div class="update-info-item" style="padding-left: 30px;">
                            <div class="label">Tình trạng hôn nhân</div>
                            <select class="content" name="maritalStatus">
                                <option value="Độc thân" ${ru.maritalStatus eq 'Độc thân' ? "selected":""}>Độc thân</option>
                                <option value="Kết hôn" ${ru.maritalStatus eq 'Kết hôn' ? "selected":""}>Kết hôn</option>
                                <option value="Góa Chồng/Vợ" ${ru.maritalStatus eq 'Góa Chồng/Vợ' ? "selected":""}>Góa Chồng/Vợ</option>
                                <option value="Ly dị" ${ru.maritalStatus eq 'Ly dị' ? "selected":""}>Ly dị</option>
                            </select>
                        </div>
                    </div>
                    <div class="education-container" style="display: flex;">
                        <div class="update-info-item">
                            <div class="label">Bằng Đại học, Cao đẳng, THPT, THCS...</div>
                            <img class="img-content" src="imgFile/${ru.education_img}" alt="${ru.education_img}" >
                        </div>
                        <div class="update-info-item" style="padding-left: 10px;">
                            <div class="label">Trình độ học vấn</div>
                            <select class="content" name="education">
                                <option value="Đại học/Cao đẳng hoặc trên Đại học" ${ru.education eq 'Đại học/Cao đẳng hoặc trên Đại học' ? "selected":""}>Đại học/Cao đẳng hoặc trên Đại học</option>
                                <option value="Trung học phổ thông/cơ sở" ${ru.education eq 'Trung học phổ thông/cơ sở' ? "selected":""}>Trung học phổ thông/cơ sở</option>
                                <option value="Dưới Trung học cơ sở" ${ru.education eq 'Dưới Trung học cơ sở' ? "selected":""}>Dưới Trung học cơ sở</option>
                            </select>
                        </div>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Nghề nghiệp</div>
                        <input class="content" type="text" name="job" value="${ru.job}" readonly>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Số điện thoại<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="phoneNumber" value="${ru.phoneNumber}" readonly >
                    </div>
                    <div class="update-info-item">
                        <div class="label">Địa chỉ<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="address" value="${ru.address}" readonly >
                    </div>
                    <div class="update-info-item">
                        <div class="label">Email<span style="color: red;">*</span></div>
                        <input class="content" type="email" name="email" value="${ru.email}" readonly >
                    </div>        
                    <input class="submit" type="submit" value="Xác nhận">           
                    <input class="cancel" type="submit" value="Hủy yêu cầu"><br>           
                </form>
            </div>
        </div>
        <%@include file="Footer.jsp"%>
    </body>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</html>