<%--
  Created by IntelliJ IDEA.
  User: sofiia
  Date: 27.10.20
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<head>
    <title>Title</title>
</head>
<body>
<div class="my-container">
    <div class="main-body">
<jsp:include page="_menu.jsp"></jsp:include>
<div class="container mt-5">
    <h1>Mentor search</h1>

    <c:forEach var="el" items="${mentors}">
        <div class="alert alert-info mt-2">
        <p>${el.getUserName()}</p>
        <a href="${pageContext.request.contextPath}/mentorSearch/${el.getId()}" class="btn btn-warning">view page</a>
        </div>
    </c:forEach>

</div>
    </div>
</div>
</body>
</html>
