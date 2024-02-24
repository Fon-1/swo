<%-- 
    Document   : SendUpdateContact
    Created on : Jan 20, 2024, 11:20:50 PM
    Author     : dell
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay đổi thông tin cá nhân</title>       
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
                padding-top:12px;
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
                top: 90px;
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
        <%@include file="HeaderCustomer.jsp"%>
        <div class="update-container">
            <div class="update-title">
                <h2>Thay đổi thông tin cá nhân</h2>
            </div>
            <button class="back-button" onclick="goBack()">Trở về</button>
            <c:set var="c" value="${sessionScope.authcode}" />
            <div class="update-info">
                <form action="updateProfile" method="POST" enctype="multipart/form-data">                    
                    <div class="update-info-item">
                        <div class="label">ID Khách hàng: ${c.customerID}</div>
                        <!--<input type="hidden" name="txtCustomerID" value="${c.customerID}"/>-->
                    </div>
                    <div class="imgCCCD-container">
                        <div class="update-info-item">
                            <div class="label">Mặt trước CCCD<span style="color: red;">*</span></div>
                            <img class="img-content" id="cccdFront" src="#" alt="Thêm/Tải hình" >
                            <input type="file" name="imgCCCDFront" accept="image/*" onchange="displayCCCDFront(event)" />
                        </div>
                        <div class="update-info-item">
                            <div class="label">Mặt sau CCCD<span style="color: red;">*</span></div>
                            <img class="img-content" id="cccdBack" src="#" alt="Thêm/Tải hình" >
                            <input type="file" name="imgCCCDBack" accept="image/*" onchange="displayCCCDBack(event)" />
                        </div>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Số CCCD<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="txtCCCD" value="${c.CCCD}" />
                        <div class="errors">${requestScope.cccdError}</div>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Họ và tên<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="txtFullName" value="${c.fullName}" />
                    </div>
                    <div class="update-info-item">
                        <div class="label">Ngày sinh<span style="color: red;">*</span> (tháng / ngày / năm)</div>
                        <input class="content" type="date" name="dob" value="${c.dob}" />
                        <div class="errors">${requestScope.dobError}</div>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Giới tính<span style="color: red;">*</span></div>
                        <select class="content" name="intGender">
                            <option value="1" ${c.gender == 1 ? "selected":""}>Nam</option>
                            <option value="0" ${c.gender == 0 ? "selected":""}>Nữ</option>
                        </select>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Quốc tịch<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="txtNationality" value="${c.nationality}" />
                    </div>
                    <div class="update-info-item">
                        <div class="label">Ngày cấp<span style="color: red;">*</span> (tháng / ngày / năm)</div>
                        <input class="content" type="date" name="issuedDate" value="${c.issuedDate}" />
                    </div>
                    <div class="update-info-item">
                        <div class="label">Ngày hết hạn<span style="color: red;">*</span> (tháng / ngày / năm)</div>
                        <input class="content" type="date" name="expiredDate" value="${c.expiredDate}" />
                    </div>
                    <div class="update-info-item">
                        <div class="label">Nơi cấp<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="txtIssuedPlace" value="${c.issuedPlace}" />
                    </div>
                    <div class="martial-container" style="display: flex;">
                        <div class="update-info-item">
                            <div class="label">Đăng kí kết hôn/Đơn ly hôn hoặc Giấy tờ khác</div>
                            <img class="img-content" id="martial" src="#" alt="Thêm/Tải hình" >
                            <input type="file" name="imgMartial" accept="image/*" onchange="displayMartial(event)" />
                        </div>
                        <div class="update-info-item" style="padding-left: 30px;">
                            <div class="label">Tình trạng hôn nhân</div>
                            <select class="content" name="txtMaritalStatus">
                                <option value="Độc thân" ${c.maritalStatus eq 'Độc thân' ? "selected":""}>Độc thân</option>
                                <option value="Kết hôn" ${c.maritalStatus eq 'Kết hôn' ? "selected":""}>Kết hôn</option>
                                <option value="Góa Chồng/Vợ" ${c.maritalStatus eq 'Góa Chồng/Vợ' ? "selected":""}>Góa Chồng/Vợ</option>
                                <option value="Ly dị" ${c.maritalStatus eq 'Ly dị' ? "selected":""}>Ly dị</option>
                            </select>
                        </div>
                    </div>
                    <div class="education-container" style="display: flex;">
                        <div class="update-info-item">
                            <div class="label">Bằng Đại học, Cao đẳng, THPT, THCS...</div>
                            <img class="img-content" id="edu" src="#" alt="Thêm/Tải hình" >
                            <input type="file" name="imgEducation" accept="image/*" onchange="displayEducation(event)" />
                        </div>
                        <div class="update-info-item" style="padding-left: 10px;">
                            <div class="label">Trình độ học vấn</div>
                            <select class="content" name="txtEducation">
                                <option value="Đại học/Cao đẳng hoặc trên Đại học" ${c.education eq 'Đại học/Cao đẳng hoặc trên Đại học' ? "selected":""}>Đại học/Cao đẳng hoặc trên Đại học</option>
                                <option value="Trung học phổ thông/cơ sở" ${c.education eq 'Trung học phổ thông/cơ sở' ? "selected":""}>Trung học phổ thông/cơ sở</option>
                                <option value="Dưới Trung học cơ sở" ${c.education eq 'Dưới Trung học cơ sở' ? "selected":""}>Dưới Trung học cơ sở</option>
                            </select>
                        </div>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Nghề nghiệp</div>
                        <input class="content" type="text" name="txtJob" value="${c.job}" placeholder="Nghề nghiệp"
                               required oninvalid="this.setCustomValidity('Vui lòng nhập nghề nghiệp.')" oninput="setCustomValidity('')">
                    </div>
                    <!--Thay đổi thông tin liên hệ-->
                    <div class="update-info-item">
                        <div class="label">Số điện thoại<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="txtPhoneNumber" value="${c.phoneNumber}" placeholder="Số điện thoại"
                               required oninvalid="this.setCustomValidity('Vui lòng nhập số điện thoại.')" oninput="setCustomValidity('')">
                        <div class="errors">${requestScope.phoneError}</div>
                    </div>
                    <div class="update-info-item">
                        <div class="label">Địa chỉ<span style="color: red;">*</span></div>
                        <input class="content" type="text" name="txtAddress" value="${c.address}" placeholder="Phường / Xã, Quận / Huyện, Tỉnh / TP"
                               required oninvalid="this.setCustomValidity('Vui lòng nhập địa chỉ.')" oninput="setCustomValidity('')">
                    </div>
                    <div class="update-info-item">
                        <div class="label">Email<span style="color: red;">*</span></div>
                        <input class="content" type="email" name="email" value="${c.email}" placeholder="Email"
                               required oninvalid="this.setCustomValidity('Vui lòng nhập email.')" oninput="setCustomValidity('')">
                    </div>        
                    <input class="submit" type="submit" value="Gửi yêu cầu"><br>           
                </form>
            </div>
        </div>
        <%@include file="Footer.jsp"%>
    </body>
</html>
<script>
    function goBack() {
        window.history.back();
    }
    function displayCCCDFront(event) {
        var input = event.target;
        var reader = new FileReader();

        reader.onload = function () {
            var img = document.getElementById('cccdFront');
            img.src = reader.result;
            img.style.display = 'block';
        };

        reader.readAsDataURL(input.files[0]);
    }
    function displayCCCDBack(event) {
        var input = event.target;
        var reader = new FileReader();

        reader.onload = function () {
            var img = document.getElementById('cccdBack');
            img.src = reader.result;
            img.style.display = 'block';
        };

        reader.readAsDataURL(input.files[0]);
    }
    function displayMartial(event) {
        var input = event.target;
        var reader = new FileReader();

        reader.onload = function () {
            var img = document.getElementById('martial');
            img.src = reader.result;
            img.style.display = 'block';
        };

        reader.readAsDataURL(input.files[0]);
    }
    function displayEducation(event) {
        var input = event.target;
        var reader = new FileReader();

        reader.onload = function () {
            var img = document.getElementById('edu');
            img.src = reader.result;
            img.style.display = 'block';
        };

        reader.readAsDataURL(input.files[0]);
    }
</script>
