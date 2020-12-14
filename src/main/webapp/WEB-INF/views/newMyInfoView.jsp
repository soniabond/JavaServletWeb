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
        <jsp:include page="_menuSigned.jsp"></jsp:include>
    </div>
    <div class="main-content-box">
        <div class="main-content">
            <form id="change-form" method="POST" action="${pageContext.request.contextPath}/myInfo">
                <div class="search-item show">
                    <img src="https://www.bootdey.com/img/Content/avatar/avatar1.png">
                    <div id="info-page" class="info-box">
                        <span id="name"><h3><b>${loginedUser.firstName} ${loginedUser.lastName}</b></h3></span>
                        <span id="user-description">Java Web Developer with exp +7 years I provide the following types of consulting services: ==> learning the basics of programming in the language chosen by the client (Data Types / Conditional Operators / Cycles / Arrays / Functions / Data Structures). ==> study of object-oriented analysis / design / programming (OOA / OOD / OOP) approaches in the chosen language.
                    </span>
                    </div>
                </div>
                <div class="search-item show">
                    <div id="apply-box" class="info-box">
                        <div class="price"> ${loginedUser.cooperationPrice} </div><br>
                        phone: <a id="phone">${loginedUser.phoneNumber}</a><br>
                        mail: <a id="mail">${loginedUser.mail}</a>
                        github <a >view more</a><br>
                        website <a >http//:${loginedUser.firstName}.com</a>
                    </div>
                    <c:if test="${loginedUser.lang.size gt 0}">
                        <div id="info-page" class="info-box">
                        <span class="languageName"><h3><b>Java Script</b></h3></span>
                        <span class="languageDesc">
                i am veryyyy good programmer i am veryyyy good programmer
                i am veryyyy good programmer i am veryyyy good programmer
                i am veryyyy good programmer i am veryyyy good programmer
                </span>
                    </div>
                    </c:if>
                </div>
                    <c:if test="${loginedUser.lang.size eq 0}">
                        <span id="add-new-item"></span>
                    </c:if>
                <div class="search-item show">
                    <div id="change-profile" class="info-box">
                        Change profile
                    </div>
                    <c:if test="${loginedUser.lang.size gt 1}">
                        <div id="info-page" class="info-box">
                            <span class="languageName"><h3><b>Scala</b></h3></span>
                            <span class="languageDesc">
                i am veryyyy good programmer i am veryyyy good programmer
                i am veryyyy good programmer i am veryyyy good programmer
                i am veryyyy good programmer i am veryyyy good programmer
                </span>
                        </div>
                    </c:if>
                </div>
                <c:if test="${loginedUser.lang.size eq 1}">
                    <span id="add-new-item"></span>
                </c:if>
                <c:if test="${loginedUser.lang.size eq 2}">
                    <span id="add-new-item">
              </span>
                </c:if>
                <c:if test="${loginedUser.lang.size gt 2}">
                        <%! int size = loginedUser.getlang.size; %>
                    <%! int i; %>

                        <%for ( i = 1; i <= ${loginedUser.lang.size}; i++){ %>
                        <div class="search-item show">
                            <div id="info-page" class="info-box right-margin">
                                <span class="languageName"><h3><b>Scala</b></h3></span>
                                <span class="languageDesc">
                                i am veryyyy good programmer i am veryyyy good programmer
                                i am veryyyy good programmer i am veryyyy good programmer
                                i am veryyyy good programmer i am veryyyy good programmer
                                </span>
                            </div>
                        </div>
                        <font color = "green" size = "<%= i %>">
                            JSP Tutorial
                        </font><br />
                        <%}%>
                    <span id="add-new-item">
              </span>
                </c:if>
            </form>
        </div>
    </div>
    <script><%@include file="../../js/myProfileChange.js"%></script>
</body>
</html>


