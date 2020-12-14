<%--
  Created by IntelliJ IDEA.
  User: sofiia
  Date: 07.12.20
  Time: 11:31
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
<dialog>
    <span id="button-name"></span>
    You are sendind request for mentor. If mentor wants to teach you you will get his personam contacts
    in a responce message. Check it in notifaction page.
    <form>
        <p><strong>Choose language</strong></p>
        <p><select>
        </select>
        <p>write your message</p>
        <textarea cols=50 rows=6></textarea>
        <input type="submit" value="Send"></p>
    </form>

    <button id="leave-dialog-button">Hide dialog</button>
</dialog>
<main>
    <div class="main-body">
        <div class="my-container">
            <c:if test="${empty loginedUser}">
                <%@ include file ="_menuUnsigned.jsp"%>
                is empty or null.
            </c:if>
            <c:if test="${not empty loginedUser}">
                <%@ include file ="_menuSigned.jsp"%>
                is NOT empty or null.
            </c:if>

        </div>
        <div class="main-content-box">
            <div class="main-content">
                <div class="search-item">
                    <img src="https://bootdey.com/img/Content/avatar/avatar6.png">
                    <div id="info-page" class="info-box">
                        <b>${userInfo.firstName} ${userInfo.lastName}</b><br>
                        i am veryyyy good programmer i am veryyyy good programmer
                        i am veryyyy good programmer i am veryyyy good programmer
                        i am veryyyy good programmer i am veryyyy good programmer
                    </div>
                </div>
                <div class="search-item">
                    <div id="apply-box" class="info-box">
                        <div class="price"> 420$ </div>
                        <div class="dialog-button info-page message-button">message</div>
                        github <a href="#">view more</a><br>
                        website <a href="#">view more</a>
                    </div>
                    <div id="info-page" class="info-box">
                        <b>Java Script</b><br>
                        i am veryyyy good programmer i am veryyyy good programmer
                        i am veryyyy good programmer i am veryyyy good programmer
                        i am veryyyy good programmer i am veryyyy good programmer
                    </div>
                </div>
                <div class="search-item">
                    <div id="info-page" class="right-margin info-box">
                        <b>HTML/CSS</b><br>
                        i am veryyyy good programmer i am veryyyy good programmer
                        i am veryyyy good programmer i am veryyyy good programmer
                        i am veryyyy good programmer i am veryyyy good programmer
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<script type="text/javascript">
    <%@include file="../../js/apply.js"%>
</script>
</body>
</html>
