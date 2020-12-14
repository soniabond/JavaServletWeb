<%--
  Created by IntelliJ IDEA.
  User: sofiia
  Date: 23.11.20
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<style>
    <%@ include file = "../../css/style.css"%>
    <%@ include file = "../../css/applyFormStyle.css"%>
    .error-label{
        color: #FF2741;
    }
    a:hover,a:focus{
        outline: none;
        text-decoration: none;
    }
    .tab{
        background: #f9fafc;
        background: #fff;
        padding: 40px 50px;
        position: relative;
        box-shadow: 13px 4px 47px 1px rgba(47, 104, 217, 0.19);
        border-radius: 24px;
    }
    .tab:before{
        content: "";
        width: 100%;
        height: 100%;
        display: block;
        position: absolute;
        top: 0;
        left: 0;
        background: #fff;
        opacity: 0.85;
        border-radius: 24px;
    }
    .tab .nav-tabs{
        border-bottom: none;
        padding: 0 20px;
        position: relative;
    }
    .tab .nav-tabs li{ margin: 0 30px 0 0; }
    .tab .nav-tabs li a{
        font-size: 18px;
        color: #929CB9;
        border-radius: 0;
        text-transform: uppercase;
        background: transparent;
        padding: 0;
        margin-right: 0;
        border: none;
        border-bottom: 2px solid transparent;
        opacity: 0.5;
        position: relative;
        transition: all 0.5s ease 0s;
    }
    .tab .nav-tabs li a:hover{ background: transparent; }
    .tab .nav-tabs li.active a,
    .tab .nav-tabs li.active a:focus,
    .tab .nav-tabs li.active a:hover{
        border: none;
        background: transparent;
        opacity: 1;
        border-bottom: 2px solid #177AFF;
        color: #172751;
    }
    .tab .tab-content{
        padding: 20px 0 0 0;
        margin-top: 40px;
        background: transparent;
        z-index: 1;
        position: relative;
    }
    .form-bg{ background: #ddd; }
    .form-horizontal .form-group{
        margin: 0 0 15px 0;
        position: relative;
    }
    .form-horizontal .form-control{
        height: 54px;
        background: #F6F7F9;
        border-radius: 12px;
        border: none;
        box-shadow: none;
        padding: 0 20px;
        font-size: 14px;
        font-weight: bold;
        color: #172751;
        transition: all 0.3s ease 0s;
    }
    .form-horizontal .form-control:focus{
        box-shadow: none;
        outline: 0 none;
    }
    .form-horizontal .form-group label{
        padding: 0 20px;
        color: #929CB9;
        text-transform: capitalize;
        margin-bottom: 10px;
    }
    .form-horizontal .main-checkbox{
        width: 20px;
        height: 20px;
        background: #F6F7F9;
        float: left;
        margin: 5px 0 0 20px;
        border: 1px solid #F6F7F9;
        position: relative;
    }
    .form-horizontal .main-checkbox label{
        width: 20px;
        height: 20px;
        position: absolute;
        top: 0;
        left: 0;
        cursor: pointer;
    }
    .form-horizontal .main-checkbox label:after{
        content: "";
        width: 10px;
        height: 5px;
        position: absolute;
        top: 5px;
        left: 4px;
        border: 3px solid #172751;
        border-top: none;
        border-right: none;
        background: transparent;
        opacity: 0;
        -webkit-transform: rotate(-45deg);
        transform: rotate(-45deg);
    }
    .form-horizontal .main-checkbox input[type=checkbox]{ visibility: hidden; }
    .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{ opacity: 1; }
    .form-horizontal .text{
        float: left;
        font-size: 14px;
        font-weight: bold;
        color: #929CB9;
        margin-left: 7px;
        line-height: 20px;
        padding-top: 5px;
        text-transform: capitalize;
    }
    .form-horizontal .btn{
        width: 100%;
        background: #177AFF;
        padding: 20px 30px;
        border: none;
        font-size: 14px;
        font-weight: bold;
        color: #fff;
        border-radius: 12px;
        text-transform: uppercase;
        margin: 20px 0 30px 0;
    }
    .form-horizontal .btn:focus{
        background: #0B57BE;
        color: #fff;
        outline: none;
        box-shadow: none;
    }
    .form-horizontal .forgot-pass{
        border-top: 1px solid #177AFF;
        margin: 0;
        text-align: center;
    }
    .form-horizontal .forgot-pass .btn{
        width: auto;
        background: transparent;
        margin: 30px 0 0 0;
        color: #929CB9;
        text-transform: capitalize;
        transition: all 0.3s ease 0s;
    }
    .form-horizontal .forgot-pass .btn:hover{ color: #177AFF; }
    @media only screen and (max-width: 479px){
        .tab{ padding: 40px 20px; }
    }
</style>
<div class="main-body">
    <div id="sign-form" class="my-container">
        <c:if test="${empty loginedUser}">
            <%@ include file ="_menuUnsigned.jsp"%>
            is empty or null.
        </c:if>
        <c:if test="${not empty loginedUser}">
            <%@ include file ="_menuSigned.jsp"%>
            is NOT empty or null.
        </c:if></div>
    <div class="main-content-box">

        <div class="container">
            <div class="row">
                <div class="col-md-offset-3 col-md-6">

                    <div class="tab" role="tabpanel">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">sign in</a></li>
                            <li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab">sign up</a></li>
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content tabs">
                            <div role="tabpanel" class="tab-pane fade in active" id="Section1">
                                <form class="form-horizontal" method="POST">
                                    <input type="hidden" name="redirectId"  value="${param.redirectId}">
                                    <div class="form-group">
                                        <label>email</label>
                                        <input type="email" name="userEmailIn" class="form-control" value="${userEmailIn}">
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="passwordIn" value= "${passwordIn}" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <div class="main-checkbox">
                                            <input value="None" id="checkbox1" name="check" type="checkbox">
                                            <label for="checkbox1"></label>
                                        </div>
                                        <span class="text">remember me</span>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" value="Submit" class="btn btn-default">Sign in</button>
                                    </div>
                                    <div class="form-group forgot-pass">
                                        <button type="submit" class="btn btn-default">forgot password</button>
                                    </div>
                                    <label class="error-label">${errorMessage}</label>
                                </form>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="Section2">
                                <form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/login">
                                    <div class="form-group">
                                        <label>Select your role: </label><br>
                                        <div class="form-group">
                                            <div class="main-checkbox">
                                                <input value="None" id="checkboxMentor" name="checkMentor" type="checkbox">
                                                <label for="checkboxMentor"></label>
                                            </div>
                                            <span class="text">Mentor</span>

                                            <div class="main-checkbox">
                                                <input value="None" id="checkboxTrainee" name="checkTrainee" type="checkbox">
                                                <label for="checkboxTrainee"></label>
                                            </div>
                                            <span class="text">Trainee</span>
                                        </div>
                                    </div>
                                    <input type="hidden" name="redirectId"  value="${param.redirectId}">
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input type="text" class="form-control" name="firstName"  value="${firstName}">
                                    </div>
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input type="text" class="form-control" name="lastName"  value="${lastName}">
                                    </div>
                                    <div class="form-group">
                                        <label>Email address</label>
                                        <input type="email" class="form-control" name="userEmailUp"  value="${userEmailUp}">
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" class="form-control" name="passwordUp"  value="${passwordUp}">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" value="Submit" class="btn btn-default">Sign up</button>
                                    </div>
                                    <label class="error-label">${errorMessage}</label>
                                </form>
                            </div>
                        </div>
                    </div>

                </div><!-- /.col-md-offset-3 col-md-6 -->
            </div><!-- /.row -->
        </div><!-- /.container -->
    </div><!

</body>
</html>
