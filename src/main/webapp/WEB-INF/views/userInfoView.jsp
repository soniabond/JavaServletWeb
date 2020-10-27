<%--
  Created by IntelliJ IDEA.
  User: sophi
  Date: 11.10.2020
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Hello: ${loginedUser.userName}</h3>

User Name: <b>${loginedUser.userName}</b>
<br />
Gender: ${loginedUser.gender } <br />


</body>
</html>
