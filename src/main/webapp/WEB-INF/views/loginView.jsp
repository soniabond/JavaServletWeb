<%--
  Created by IntelliJ IDEA.
  User: sophi
  Date: 11.10.2020
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@ include file = "../../css/loginCSS.css"%>
</style>
<html>
<head>
</head>
<body>
<div class="my-container">
    <div class="main-body">
<jsp:include page="_menu.jsp"></jsp:include>
    </div>
</div>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Login Form -->
                <form method="POST" action="${pageContext.request.contextPath}/login">
                    <input type="hidden" name="redirectId"  value="${param.redirectId}">
                    <input type="text" name="userName"  value="${userName}" placeholder="username">
                    <input type="password" name="password" value= "${password}" placeholder="password">
                    <input type="submit" value="Submit">
                </form>

                <!-- Remind Passowrd -->
                <div id="formFooter">
                    <a class="underlineHover" href="#">Forgot Password?</a>
                </div>

            </div>
        </div>
</body>
</html>
