<%--
  Created by IntelliJ IDEA.
  User: sofiia
  Date: 27.10.20
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<head>
    <style>
        <%@ include file = "../../css/mentorSearchCSS.css"%>
    </style>
</head>
<body>
<div class="my-container">
    <jsp:include page="_menu.jsp"></jsp:include>
    <div class="main-body">
        <div class="container">
            <div class="row ng-scope">
                <div class="col-md-3 col-md-push-9">
                    <h4>Results <span class="fw-semi-bold">Filtering</span></h4>
                    <p class="text-muted fs-mini">Listed content is categorized by the following groups:</p>
                    <ul class="nav nav-pills nav-stacked search-result-categories mt">
                        <li><a href="#">Java<span class="badge">1</span></a>
                        </li>
                        <li><a href="#">Javascript<span class="badge">1</span></a>
                        </li>
                        <li><a href="#">Kharkiv<span class="badge">1</span></a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-9 col-md-pull-3">
                    <p class="search-results-count">${mentors.size()} results</p>
                    <c:forEach var="el" items="${mentors}">
                    <section class="search-result-item">
                        <a class="image-link" href="${pageContext.request.contextPath}/mentorSearch/${el.getId()}"><img class="image" src="https://bootdey.com/img/Content/avatar/avatar7.png">
                        </a>
                        <div class="search-result-item-body">
                            <div class="row">
                                <div class="col-sm-9">
                                    <h4 class="search-result-item-heading"><a href="#">${el.getUserName()}</a></h4>
                                    <p class="info">Kharkiv, Ukraine</p>
                                    <p class="description">ready to teach you if you are really into programming</p>
                                </div>
                                <div class="col-sm-3 text-align-center">
                                    <p class="value3 mt-sm">200$</p>
                                    <p class="fs-mini text-muted">PER MONTH</p><a class="btn btn-primary btn-info btn-sm" href="${pageContext.request.contextPath}/mentorSearch/${el.getId()}">View More</a>
                                    <br><br>
                                    <a class="btn btn-primary btn-info btn-sm" href="${pageContext.request.contextPath}/mentorSearch/${el.getId()}">Message</a>
                                </div>
                            </div>
                        </div>
                    </section>
                    </c:forEach>
                    <br>
                    <br>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#">Prev</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">2</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">3</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">4</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">5</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

</div>
    </div>
</body>
</html>
