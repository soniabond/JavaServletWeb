<%--
  Created by IntelliJ IDEA.
  User: sofiia
  Date: 06.12.20
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>mentor profile</title>
    <style>
        <%@ include file = "../../css/style.css"%>
        <%@ include file = "../../css/applyFormStyle.css"%>
    </style>
</head>
<body>
<div class="main-body">
    <div class="my-container">
        <jsp:include page="_menu.jsp"></jsp:include>
    </div>
    <div class="main-content-box">
        <div class="main-content">
            <form id="change-form" method="POST">
                <div class="search-item">
                    <img src="registerTest/avatar.png">
                    <div id="info-page" class="info-box">
                        <span id="name"><h3><b>${loginedUser.firstName} ${loginedUser.lastName}</b></h3></span>
                        <span id="user-description">i am veryyyy good programmer i am veryyyy good programmer i am veryyyy good programmer i am veryyyy good programmer i am veryyyy good programmer i am veryyyy good programmer
                    </span>
                    </div>
                </div>
                <div class="search-item">
                    <div id="apply-box" class="info-box">
                        <div class="price"> 420$ </div><br>
                        phone: <a href="#" id="phone">+380666830321</a><br>
                        mail: <a href="#" id="mail">${loginedUser.mail}</a>
                        github <a href="#">view more</a><br>
                        website <a href="#">http//:${loginedUser.firstName}.com</a>
                    </div>
                    <div id="info-page" class="info-box">
                        <span class="languageName"><h3><b>Java Script</b></h3></span>
                        <span class="languageDesc">
                i am veryyyy good programmer i am veryyyy good programmer
                i am veryyyy good programmer i am veryyyy good programmer
                i am veryyyy good programmer i am veryyyy good programmer
                </span>
                    </div>
                </div>
                <div class="search-item">
                    <div id="change-profile" class="info-box">
                        Change profile
                    </div>
                    <div id="info-page" class="info-box">
                        <span class="languageName"><h3><b>Java</b></h3></span>
                        <span class="languageDesc">
                  i am veryyyy good programmer i am veryyyy good programmer
                  i am veryyyy good programmer i am veryyyy good programmer
                  i am veryyyy good programmer i am veryyyy good programmer
                  </span>
                    </div>
                </div>
                <span id="add-new-item">
              </span>
            </form>
        </div>
    </div>
    <script><%@include file="../../js/myProfileChange.js"%></script>
</body>
</html>


