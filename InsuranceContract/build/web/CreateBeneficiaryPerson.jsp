<%-- 
    Document   : createBeneficiaryPerson
    Created on : Jan 17, 2024, 10:08:21 PM
    Author     : maian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo Người Thụ Hưởng</title>

        <style>
            h2, h3 {
                margin: 25px 0;
            }
            body {
                font-family: Open Sans, sans-serif;
            }
            .container {
                background-color: #f7f7f8;
            }
            .container-body {
                background: #ffffff;
                box-shadow: 0px 0px 40px rgba(155, 155, 155, 0.1);
                border-radius: 8px;
                padding: 5px 65px 30px 65px;
                margin: 24px auto;
                max-width: 600px;
            }
            .errors {
                color: red;
                margin-bottom: 20px;
            }
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
                cursor: pointer;
            }
            .content:focus {
                outline: none;
                border-color: #00B2CE;
                box-shadow: 0 0 5px #344659;
            }
            .label {
                font-size: 12px;
                opacity: 0.8;
            }
            .button {
                display: flex;
            }
            .button-left {
                width: 50%;
                margin: 10px 10px 0 0;
            }
            .button-right {
                width: 50%;
                margin: 10px 0 0 10px;
            }
            button {
                width: 100%;
                height: 50px;
                border-radius: 5px;
                border: 1px solid #f7f7f8;
            }
            button:hover {
                background-color: #00B2CE;
                color: white;
                cursor: pointer;
            }
            
            .container-back-action {
                max-width: 1200px;
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

    <body style="background-color: #f7f7f8;">
        <%@include file="HeaderCustomer.jsp"%> 
        <section id="page-content" style="margin-top: 0px;">
            <div class="container">
                <div class="container-back-action">
                    <div class="back-action" onclick="confirmExit();">
                        <i class="fa fa-fw fa-chevron-left" style="margin-top: 5px;"></i>
                        Thoát
                    </div>
                </div>
                <h2 style="text-align: center;">Bước 2: Thông tin Người Thụ Hưởng</h2>
                <div class="container-body">
                    <h3>Thông tin cá nhân</h3>
                    <form action="createbeneficiaryperson" method="get">
                        <div class="info-detail">
                            <div class="label">Họ và tên<span style="color: red;">*</span></div>
                            <input class="content" type="text" id="fullName" name="fullName" placeholder="Họ và tên" 
                                   value="${sessionScope.benePerson.fullName}" required 
                                   oninvalid="this.setCustomValidity('Vui lòng nhập họ và tên.')" oninput="setCustomValidity('')"/>
                        </div>

                        <div class="info-detail">
                            <div class="label">Giới Tính<span style="color: red;">*</span></div>
                            <select class="content" name="gender">
                                <option value="1" ${sessionScope.benePerson.gender eq '1' ? "selected":""}>Nam</option>
                                <option value="0" ${sessionScope.benePerson.gender eq '0' ? "selected":""}>Nữ</option>
                            </select>
                        </div>

                        <div class="info-detail">
                            <div class="label">Ngày Sinh<span style="color: red;">*</span></div>
                            <input class="content" type="date" id="dob" name="dob" required 
                                   oninvalid="this.setCustomValidity('Vui lòng nhập ngày sinh.')" oninput="setCustomValidity('')"/>
                            <div class="errors">${requestScope.dobError}</div>
                        </div>

                        <div class="info-detail">
                            <div class="label">Căn Cước Công Dân</div>
                            <input class="content" type="text" id="cccd" name="cccd" 
                                   placeholder="Căn cước công dân" value="${sessionScope.insuPerson.cccd}"/>
                            <div class="errors">${requestScope.cccdError}</div>
                        </div>

                        <div class="info-detail">
                            <div class="label">Quốc Tịch<span style="color: red;">*</span></div>
                            <input class="content" type="text" id="nationality" name="nationality" 
                                   placeholder="Quốc tịch" value="${requestScope.benePerson.nationality}" required 
                                   oninvalid="this.setCustomValidity('Vui lòng nhập quốc tịch.')" oninput="setCustomValidity('')"/>
                        </div>

                        <div class="info-detail">
                            <div class="label">Tình trạng hôn nhân<span style="color: red;">*</span></div>
                            <select class="content" name="maritalStatus">
                                <option value="Độc thân" ${sessionScope.insuPerson.maritalStatus eq 'Độc thân' ? "selected":""}>Độc thân</option>
                                <option value="Kết hôn" ${sessionScope.insuPerson.maritalStatus eq 'Kết hôn' ? "selected":""}>Kết hôn</option>
                                <option value="Góa Chồng/Vợ ${sessionScope.insuPerson.maritalStatus eq 'Góa Chồng/Vợ' ? "selected":""}">Góa Chồng/Vợ</option>
                                <option value="Ly dị" ${sessionScope.insuPerson.maritalStatus eq 'Ly dị' ? "selected":""}>Ly dị</option>
                            </select>
                        </div>

                        <div class="info-detail">
                            <div class="label">Trình độ học vấn<span style="color: red;">*</span></div>
                            <select class="content" name="education">
                                <option value="Đại học/Cao đẳng hoặc trên Đại học" ${sessionScope.insuPerson.education eq 'Đại học/Cao đẳng hoặc trên Đại học' ? "selected":""}>
                                    Đại học/Cao đẳng hoặc trên Đại học
                                </option>
                                <option value="Trung học phổ thông/cơ sở" ${sessionScope.insuPerson.education eq 'Trung học phổ thông/cơ sở' ? "selected":""}>
                                    Trung học phổ thông/cơ sở
                                </option>
                                <option value="Dưới Trung học cơ sở" ${sessionScope.insuPerson.education eq 'Dưới Trung học cơ sở' ? "selected":""}>
                                    Dưới Trung học cơ sở
                                </option>
                            </select>
                        </div>

                        <div class="info-detail">
                            <div class="label">Nghề nghiệp</div>
                            <input class="content" type="text" id="job" name="job" />
                        </div>

                        <div class="info-detail">
                            <div class="label">Địa chỉ<span style="color: red;">*</span></div>
                            <input class="content" type="text" id="address" name="address" 
                                   placeholder="Địa chỉ" value="${requestScope.benePerson.address}" required 
                                   oninvalid="this.setCustomValidity('Vui lòng nhập địa chỉ.')" oninput="setCustomValidity('')"/>
                        </div>

                        <h3>Thông tin liên lạc</h3>
                        <div class="info-detail">
                            <div class="label">Số điện thoại</div>
                            <input class="content" type="text" id="phoneNumber" name="phoneNumber" 
                                   placeholder="Số điện thoại" value="${requestScope.benePerson.phoneNumber}"/>
                            <div class="errors">${requestScope.phoneError}</div>
                        </div>

                        <div class="info-detail">
                            <div class="label">Email</div>
                            <input class="content" type="email" id="email" name="email" 
                                   placeholder="Email" value="${requestScope.benePerson.email}"/>
                        </div>

                        <div class="info-detail">
                            <label for="relationship">Mối quan hệ với NĐBH<span style="color: red;">*</span></label>
                            <select class="content" name="relationship">
                                <option value="Bản thân">Bản thân</option>
                                <option value="Cha / Mẹ">Cha / Mẹ</option>
                                <option value="Vợ / Chồng">Vợ / Chồng</option>
                                <option value="Anh / Chị / Em">Anh / Chị / Em </option>
                                <option value="Con">Con</option>
                                <option value="Họ hàng">Họ hàng</option>
                            </select>
                        </div>

                        <div class="button">
                            <div class="button-left">
                                <button onclick="goBack()">Quay lại</button>
                            </div>
                            <div class="button-right">
                                <input type="hidden" name="action" value="not null"/>
                                <button type="submit">Tiếp tục</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>

        <%@include file="Footer.jsp"%> 
    </body>
</html>

<script>
    function goBack() {
        window.history.back();
    }
    function confirmExit() {
        var confirmMessage = "Khi thoát, những thông tin sẽ không được lưu lại. Bạn có muốn tiếp tục không?";
        if (confirm(confirmMessage)) {
            // Nếu người dùng đồng ý, chuyển hướng đến trang staffHomepage
            window.location.href = "staffHomepage";
        }
    }
</script>
