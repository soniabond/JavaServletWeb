<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sofiia
  Date: 06.12.20
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>my first page</title>
    <style>
        <%@ include file = "../../css/style.css"%>
        <%@ include file = "../../css/applyFormStyle.css"%>
    </style>
</head>
<body>
<dialog>
    <span id="button-name"></span>
    O HAI, I’m a dialog. Click on me to dismiss.

    <form>
        <p><strong>Выбери персонажа</strong></p>
        <p><select name="hero">
            <option value="s1">Чебурашка</option>
            <option value="s2" selected>Крокодил Гена</option>
            <option value="s3">Шапокляк</option>
            <option value="s3" label="Лариса">Крыса Лариса</option>
        </select>
            <input type="submit" value="Отправить"></p>
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
            <div class="filter-menu">
                <form class="filter-form" method="post">
                    <span class="underlined-text">filters        <br></span>
                    <p><input type="submit" value="apply" class="button">
                    <p><b>programming language</b></p>
                    <input class="label"type="checkbox" name="option1" value="a1"/>Java<Br>
                    <input class="label" type="checkbox" name="option2" value="a2">JS<Br>
                    <input class="label" type="checkbox" name="option3" value="a3">C<Br>
                    <input class="label" type="checkbox" name="option4" value="a4">C++<Br>
                    <input class="label" type="checkbox" name="option5" value="a5">C#<br>
                    <input class="label" type="checkbox" name="option4" value="a4">Python<Br>
                    <input class="label" type="checkbox" name="option5" value="a5">Ruby<Br>
                    <input class="label" type="checkbox" name="option4" value="a4">HTML/CSS<Br>
                    <input class="label" type="checkbox" name="option4" value="a4">.NET<Br>
                    <input class="label" type="checkbox" name="option5" value="a5">Flatter</p>

                    <p><b>price per lesson</b></p>
                    <input class="label" type="radio" name="price" value="a1">free<Br>
                    <input class="label" type="radio" name="price" value="a2">up to 15$<Br>
                    <input class="label" type="radio" name="price" value="a3">up to 50$<Br>

                    <p><b>studying format</b></p>
                    <input class="label" type="checkbox" name="option1" value="a1">online<Br>
                    <input class="label" type="checkbox" name="option2" value="a2">offline<Br>

                    <p><input type="submit" value="apply" class="button">
                </form>
            </div>
            <div class="main-content">
                results found: ${mentors.size()}
                <c:forEach var="el" items="${mentors}">
                <div class="search-item">
                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png">
                    <div class="info-box">
                        <b>${el.getFirstName()} ${el.getLastName()}</b><br>
                        i am veryyyy good programmer i am veryyyy good programmer
                        i am veryyyy good programmer i am veryyyy good programmer
                        i am veryyyy good programmer i am veryyyy good programmer

                    </div>
                    <div id="apply-box" class="info-box">
                        <div class="price"> 420$ </div>
                        <div class="dialog-button message-button">message</div>
                        <a href="${pageContext.request.contextPath}/mentorSearch/${el.getId()}">view more</a>
                    </div>
                </div>
                </c:forEach>
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