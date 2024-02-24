<%-- 
    Document   : FooterCustomer
    Created on : Feb 18, 2024, 4:16:58 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .footer {
                background-color: #f7f7f8;
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                align-items: center;
                position: fixed;
                width: 100%;
                height: 52px;
                bottom: 0;
                padding: 0 20px;
                margin-top: 20px;
            }
            .footer a {
                text-decoration: none;
                color: #000;
            }
            .footer a:hover {
                color: #ccc;
            }
            .footer p {
                margin: 0;
                flex-grow: 1;
                text-align: center;
            }
            .footer-logo {
                width: 100px;
            }
        </style>
    </head>
    <body>
        <div class="footer" id="footer">
            <p>© 2021-2022 Bản quyền thuộc về Tập đoàn AIA (AIA Group Limited) và các chi nhánh</p>           
        </div>
    </body>
</html>
<script>
    window.onscroll = function () {
        scrollFunction();
    };

    function scrollFunction() {
        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            document.getElementById("footer").style.display = "flex"; // Hiển thị footer khi lướt xuống cuối trang
        } else {
            document.getElementById("footer").style.display = "none"; // Ẩn footer khi người dùng không lướt xuống cuối trang
        }
    }
</script>
