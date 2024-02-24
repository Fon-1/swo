<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
             .container {
            background: #f7f7f8;
            display: flex;
        }
        .sidebar {
            width: 180px;
            background-color: #fff;
            padding: 10px;
            height: auto;
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

        .content {
            flex: 1;
            padding: 20px;
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
            width: 100%;
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
        }

        .search-bar input[type="submit"] {
            padding: 8px 15px;
            background-color: #2ecc71;
            color: #fff;
            border: none;
            cursor: pointer;

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


            * {
                box-sizing: border-box;
            }

            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

            label {
                padding: 12px 12px 12px 0;
                display: inline-block;
            }

            input[type=submit] {
                background-color: #45B4D0;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
               
                float: right;
    width: 30%;
            }

            input[type=submit]:hover {
                background-color: #45B4D0;
            }

           
            .col-25 {
                float: left;
                width: 25%;
                margin-top: 6px;
            }

            .col-75 {
                float: left;
                width: 75%;
                margin-top: 6px;
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }
            .content1{
                margin-bottom: 30px;
            }

            /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 600px) {
                .col-25, .col-75, input[type=submit] {
                    width: 100%;
                    margin-top: 0;
                }
            }
              
    .btn btn-primary {
    background-color: #45B4D0;
    border-color: #45B4D0;
    padding: 0.8rem 2.6rem;
    font-weight: 500;
    -webkit-transition: all 0.5s ease;
    transition: all 0.5s ease;
    box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.15);
    margin: 10px 0px 20px;
    border-radius: 5px;
}
    
        </style>
    </head>
    <body>
        <script type="text/javascript">
            function validateForm() {
                var customerid = document.forms["myForm"]["customerid"].value;
                var fullname = document.forms["myForm"]["fullname"].value;
//                var cccd = document.forms["myForm"]["cccd"].value;
//                var gender = document.forms["myForm"]["gender"].value;
//                var dob = document.forms["myForm"]["dob"].value;
//                var nation = document.forms["myForm"]["nation"].value;
//                var issudate = document.forms["myForm"]["issudate"].value;
//                var expireddate = document.forms["myForm"]["expireddate"].value;
//                var place = document.forms["myForm"]["place"].value;
//                var material = document.forms["myForm"]["material"].value;
//                var education = document.forms["myForm"]["education"].value;
//                var job = document.forms["myForm"]["job"].value;
           //     var address = document.forms["myForm"]["address"].value;
                var phone = document.forms["myForm"]["phone"].value;

                var email = document.forms["myForm"]["email"].value;
                var customeridRegex = /^(?=.*[A-Za-z])(?=.*\d).{6}$/;
                if (!customeridRegex.test(customerid)) {
                    alert("CumstomerID must be 6 characters long and include both letters and numbers.");
                    return false;
                }
                var phoneRegex = /^\d{10}$/; // Assumes a 10-digit phone number
                if (!phoneRegex.test(phone)) {
                    alert("Invalid phone number. Please enter a 10-digit number.");
                    return false;
                }
                var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailRegex.test(email)) {
                    alert("Invalid email format.");
                    return false;
                }
                // Client-side validation
                if (customerid === null || customerid.trim() === "") {
                    alert("CustomerID is required.");
                    return false;
                }
                if (fullname === null || fullname.trim() === "") {
                    alert("Full name is required.");
                    return false;
                }
                if (cccd === null || cccd.trim() === "") {
                    alert("CCCD is required.");
                    return false;
                }
                if (gender === null || gender.trim() === "") {
                    alert("Gender is required.");
                    return false;
                }
                if (dob === null || dob.trim() === "") {
                    alert("Date of birth is required.");
                    return false;
                }
                if (nation === null || nation.trim() === "") {
                    alert("Nationality is required.");
                    return false;
                }
                if (gender === null || gender.trim() === "") {
                    alert("Gender is required.");
                    return false;
                }
                if (issudate === null || issudate.trim() === "") {
                    alert("Issue Date is required.");
                    return false;
                }
                if (expireddate === null || expireddate.trim() === "") {
                    alert("Expireddate is required.");
                    return false;
                }
                if (place === null || place.trim() === "") {
                    alert("Place is required.");
                    return false;
                }
                if (material === null || material.trim() === "") {
                    alert("Material Status is required.");
                    return false;
                }

                //
                if (education === null || education.trim() === "") {
                    alert("Education is required.");
                    return false;
                }
                if (job === null || job.trim() === "") {
                    alert("Job is required.");
                    return false;
                }
                if (address === null || address.trim() === "") {
                    alert("Address is required.");
                    return false;
                }
                if (phone === null || phone.trim() === "") {
                    alert("Phone is required.");
                    return false;
                }
                if (email === null || email.trim() === "") {
                    alert("Email is required.");
                    return false;
                }
                // You can add more validation rules as needed

                return true; // Form is valid, allow submission
            }
        </script>
            <%@include file="HeaderStaff.jsp"%>
       <div class="container">
        <div class="sidebar">
            <ul>
                <li><a href="createinsuperson">Quản lí khách hàng</a></li>
                <li><a href="contractDetailStaff">Quản lí hợp đồng</a></li>
                <li><a href="manageRequestChangeInfo">Quản lí yêu cầu</a></li>
                <li><a href="RegisterCustomer.jsp">Mở tài khoản</a></li>
            </ul>
        </div>
           <div class="content">     
                <div class="homepage">
                <div class="homepage-header">
                    <div class="homepage-header-right">
                        <div class="homepage-header-fullname">Xin chào ${sessionScope.authcode.fullName}</div>                        
                    </div>
                   
                </div>
            <form class="content1" name="myForm" action ="RegisterControl" method="post" onsubmit="return validateForm()">
                <div class="row">
                    <div class="col-25">
                        <label for="fname">Mã khách hàng<span style="color: red;"> *</span></label>

                    </div>
                    <div class="col-75">
                        <input type="text"  name="customerid" placeholder="Nhập mã khách hàng..">
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="lname">Họ và Tên</label><span style="color: red;">*</span></label>
                    </div>
                    <div class="col-75">
                        <input type="text"  name="fullname" placeholder="Nhập họ và tên...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">CCCD (Chứng minh nhân dân)</label>
                    </div>
                    <div class="col-75">
                        <input type="text"  name="cccd" placeholder="Nhập số CCCD...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Giới tính</label>
                    </div>
                    <div class="col-75">
                        <input type="radio" value="1"  name="gender" > Nam</input>
                        <input type="radio"  value="0" name="gender" >Nữ</input>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Ngày sinh</label>
                    </div>
                    <div class="col-75">
                        <input type="date"  name="dob" placeholder="Nhập số CCCD...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Quốc tịch</label>
                    </div>
                    <div class="col-75">
                        <input type="text"  name="nation" placeholder="Nhập quốc tịch...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Ngày cấp (tháng / ngày / năm)</label>
                    </div>
                    <div class="col-75">
                        <input type="date" name="issudate" placeholder="Your last name..">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Ngày hết hạn (tháng / ngày / năm)</label>
                    </div>
                    <div class="col-75">
                        <input type="date" name="expireddate" placeholder="Your last name..">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Nơi cấp</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="place" placeholder="Nhập nơi cấp..">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Tình trạng hôn nhân</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="material" placeholder="Nhập tình trạng hôn nhân...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                                                    <label for="lname">Trình độ học vấn</label>

                    </div>
                    <div class="col-75">
                                              <input type="text" name="education" placeholder="Nhập trình độ học vấn...">

                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                               <label for="lname">Nghề nghiệp</label>

                    </div>
                    <div class="col-75">
                                               <input type="text" name="job" placeholder="Nhập nghề nghiệp...">

                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                            <label for="lname">Địa chỉ</label>

                    </div>
                    <div class="col-75">
                                            <input type="text" name="address" placeholder="Nhập địa chỉ...">

                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                                              <label for="lname">Số điện thoại </label><span style="color: red;">*</span>

                    </div>
                    <div class="col-75">
                                               <input type="text" name="phone" placeholder="Nhập số điện thoại">

                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="lname">Email </label><span style="color: red;">*</span></label>
                    </div>
                    <div class="col-75">
                                            <input type="text" name="email" placeholder="Nhập email..">

                    </div>
                </div>
                <div class="row" style="margin-top: 10px ">
                    <input type="submit" value="Submit" class="btn btn-primary">
                </div>
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
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script src="js/jquery.flexslider-min.js"></script>
<script src="js/easyResponsiveTabs.js"></script>
<script src="js/owl.carousel.js"></script>
<script src="js/custom.js"></script>
