<%--
  Created by IntelliJ IDEA.
  User: sofiia
  Date: 13.12.20
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
            <div id="notifactions-result">Your new notifactions</div>
            <c:forEach var="el" items="${messages}">
            <div class="search-item show">
                <div id="info-page" class="info-box">
                    <span class="name"><h3>${el.getUserFrom().getFirstName()} ${el.getUserFrom().getFirstName()} <span class="language">${el.programmingLangMessage.name}</span></h3></span>
                    <span class="user-description"> ${el.content}</span>
                </div>
                <div class="accept-box">
                    <button class="accept">accept</button>
                    <button class="dismiss">dismiss</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
