<%-- 
    Document   : CreateContract
    Created on : Jan 20, 2024, 4:06:06 PM
    Author     : maian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo Hợp Đồng Mới</title>

        <style>
            h2, h3 {
                margin: 25px 0;
            }
            body {
                font-family: Open Sans, sans-serif;
                background-color: #f7f7f8;
            }
            .errors {
                color: red;
                margin-bottom: 20px;
            }
            .contract-info {
                display: block;
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                font-size: 16px;
            }
            .contract-info:hover  {
                border-color: #00B2CE;
                cursor: pointer;
            }
            .contract-info:focus{
                outline: none;
                border-color: #00B2CE;
                box-shadow: 0 0 5px #344659;
            }
            .label {
                font-size: 12px;
                opacity: 0.8;
            }
            label {
                font-weight: 500;
                padding-top: 10px;
            }
            .container-body {
                background: #ffffff;
                box-shadow: 0px 0px 40px rgba(155, 155, 155, 0.1);
                border-radius: 8px;
                padding: 32px 65px 32px 65px;
                margin: 24px auto;
                max-width: 600px;
            }
            .button {
                display: flex;
            }
            .insuranceTime {
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
            .pdf-content {
                display: block;
                width: 97%;
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
                margin-bottom: 15px;
            }
            .pdf-content:hover {
                border-color: #00B2CE;
            }
            .pdf-content:focus {
                outline: none;
                border-color: #00B2CE;
                box-shadow: 0 0 5px #344659;
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
    <body>
        <%@include file="HeaderCustomer.jsp"%> 
        <section id="page-content" style="margin-top: 0px;">
            <div class="container-back-action">
                    <div class="back-action" onclick="confirmExit();">
                        <i class="fa fa-fw fa-chevron-left" style="margin-top: 5px;"></i>
                        Thoát
                    </div>
                </div>
            <h2 style="text-align: center;">Bước 3: Thông tin Hợp đồng</h2>
            <div class="container-body">
                <form action="createcontract" method="post" enctype="multipart/form-data">
                    <div class="contract-detail">
                        <div class="label">ID hợp đồng<span style="color: red;">*</span></div>
                        <input class="contract-info" type="text" id="contractID" name="contractID" placeholder="ID Hợp Đồng" 
                               required oninvalid="this.setCustomValidity('Vui lòng nhập ID hợp đồng.')" oninput="setCustomValidity('')"/>
                        <div class="errors">${requestScope.errorContractIDexist}</div>
                        <div class="errors">${requestScope.errorContractIDformat}</div>
                    </div>

                    <div class="contract-detail">
                        <div class="label">ID khách hàng<span style="color: red;">*</span></div>
                        <input class="contract-info" type="text" id="customerID" name="customerID" placeholder="ID Khách Hàng" 
                               required oninvalid="this.setCustomValidity('Vui lòng nhập ID khách hàng.')" oninput="setCustomValidity('')"/>                  
                        <div class="errors">${requestScope.errorCustomerID}</div>
                    </div>

                    <div class="contract-detail">
                        <div class="label">Gói bảo hiểm<span style="color: red;">*</span></div>
                        <select class="contract-info" id="packageID" name="packageID">
                            <c:forEach items="${requestScope.insuPackage}" var="p">
                                <option value="${p.packageID}">${p.packageName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="contract-detail">
                        <div class="label">Người được bảo hiểm<span style="color: red;">*</span></div>
                        <input class="contract-info" type="text" id="insuranID" name="insuranID" 
                               value="${sessionScope.insuPerson.fullName}" disabled/>
                    </div>

                    <div class="contract-detail">
                        <div class="label">Người thụ hưởng<span style="color: red;">*</span></div>
                        <input class="contract-info" type="text" id="beneID" name="beneID" 
                               value="${sessionScope.benePerson.fullName}" disabled//>
                    </div>

                    <div class="contract-detail">
                        <div class="label">Số tiền bảo hiểm<span style="color: red;">*</span></div>
                        <input class="contract-info" type="text" id="sumAssured" name="sumAssured" placeholder="Số tiền bảo hiểm" 
                               required oninvalid="this.setCustomValidity('Vui lòng nhập số tiền bảo hiểm.')" oninput="setCustomValidity('')"/>
                    </div>

                    <div class="contract-detail">
                        <div class="label">Ngày hiệu lực<span style="color: red;">*</span></div>
                        <input class="contract-info" type="date" id="effectiveDate" name="effectiveDate" required 
                               oninvalid="this.setCustomValidity('Vui lòng nhập ngày hiệu lực.')" oninput="setCustomValidity('')"/>
                        <div class="errors">${requestScope.errorEffectiveDate}</div>
                    </div>

                    <div class="contract-detail">
                        <div class="label">Thời hạn hợp đồng<span style="color: red;">*</span></div>
                        <div class="insuranceTime">
                            <input class="contract-info" type="text" id="insuranceTime" name="insuranceTime" placeholder="Thời hạn hợp đồng" 
                                   required oninvalid="this.setCustomValidity('Vui lòng nhập thời hạn hợp đồng.')" oninput="setCustomValidity('')"/>
                            <div style="margin: 10px 10px 0 10px;">năm</div>
                        </div>
                    </div>

                    <div class="contract-detail">
                        <div class="label">Định kỳ đóng phí<span style="color: red;">*</span></div>
                        <select class="contract-info" name="premiumMode">
                            <option value="Năm">Năm</option>
                            <option value="Nửa năm">Nửa năm</option>
                            <option value="Quý">Quý</option>
                            <option value="Tháng">Tháng</option>
                        </select>
                    </div>

                    <div class="contract-detail">
                        <div class="label">Hợp đồng bản mềm<span style="color: red;">*</span></div>
                        <input class="pdf-content" type="file" id="contract_pdf" name="contract_pdf" accept=".pdf"/>
                    </div>

                    <input type="hidden" name="status" value="Có hiệu lực"/>                   
                    <div class="button">
                        <div class="button-left">
                            <button onclick="goBack()">Quay lại</button>
                        </div>
                        <div class="button-right">
                            <input type="hidden" name="action" value="not null"/>
                            <button type="submit">Gửi thông tin</button>
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