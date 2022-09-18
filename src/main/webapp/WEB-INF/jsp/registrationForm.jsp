<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.myspringecommerceapp.model.UserType" %>
<%@page import="com.myspringecommerceapp.modelDTO.*" %>
<!DOCTYPE html>
<html>
<head>
    <link href="/resources/css/headers.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
    <link href="/resources/css/login-page.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>IT Accessories</title>
</head>
<body>


<a href="index.html">Povratak nazad</a>





<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">
                <div class="wrap">
                    <div class="img" style="background-image: url(https://wallpapertops.com/walldb/original/e/d/2/96430.jpg);"></div>
                    <div class="login-wrap p-4 p-md-5">

                        <div class="d-flex">
                            <div class="w-100">
                                <h3 class="mb-4">Registriraj se</h3>
                            </div>
                        </div>

                        <form  action="/registration" name="userDTO" class="signin-form" method="POST">
                            <form:errors cssClass="error" delimiter="&lt;p/&gt;" />

                            <c:forEach items="${errors}" var="error">
                                <%-- do want you want with ${error} --%>
                                <c:out value="${error.defaultMessage}" />
                            </c:forEach>

                            <div class="form-group mt-3">
                                <input id="ime" name="firstName" type="text" class="form-control" required>
                                <label class="form-control-placeholder" for="ime">Ime</label>
                            </div>

                            <div class="form-group mt-3">
                                <input id="prezime" name="lastName" type="text" class="form-control" required>
                                <label class="form-control-placeholder" for="prezime">Prezime</label>
                            </div>

                            <div class="form-group mt-3">
                                <input id="username" name="username" type="text" class="form-control" required>
                                <label class="form-control-placeholder" for="username">Korisničko ime</label>
                            </div>

                            <div class="form-group mt-3">
                                <input id="email" name="email" type="email" class="form-control" required>
                                <label class="form-control-placeholder" for="email">Email adresa</label>
                            </div>

                            <div class="form-group">
                                <input id="password-field" name="password" type="password" class="form-control" required>
                                <label class="form-control-placeholder" for="password-field" >Lozinka</label>
                                <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                            </div>

                            <div class="form-group">
                                <input id="passwordCheck" name="passwordCheck" type="password" class="form-control" required>
                                <label class="form-control-placeholder" for="passwordCheck" >Potvrda lozinke</label>
                                <span toggle="#passwordCheck" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                            </div>

                            <div class="form-group">
                                <select path="status" items="${Status.values()}" itemLabel="label" itemValue="name"  id="userType" type="${UserType}" name="userType" class="form-control">
                                    <c:forEach var="type" items="${UserType.values()}">
                                        <option value="${type.name()}" name="userType"> ${type.name()} </option>
                                    </c:forEach>
                                    <label class="form-control-placeholder" for="userType">User Type</label>
                                </select>
                            </div>

<%--                            <input type="hidden" name="userType" value="UserType.CUSTOMER" class="form-control" required>--%>

                            <%
                                if(request.getAttribute("incorrectPassword") != null) {
                            %>
                            <p style="color:red;"><%= request.getAttribute("incorrectPassword")%></p>
                            <%
                                request.setAttribute("incorrectPassword", null);
                            }
                            else if(request.getAttribute("usernameExists") != null) {
                            %>
                            <p style="color:red;"><%= request.getAttribute("usernameExists")%></p>
                            <%
                                request.setAttribute("usernameExists", null);
                            }
                            else if(request.getAttribute("emailExists") != null) {
                            %>
                            <p style="color:red;"><%= request.getAttribute("emailExists")%></p>
                            <%
                                    request.setAttribute("emailExists", null);
                                }
                            %>

                            <div class="form-group">
                                <button type="submit" class="form-control btn btn-primary rounded submit px-3">Registriraj se</button>
                            </div>
                        </form>

                        <spring:hasBindErrors name="userDTO">
                            <c:forEach var="error" items="${errors.allErrors}">
                                <b><spring:message message="${error}" /></b>
                                <br/>
                            </c:forEach>
                        </spring:hasBindErrors>


                        <p class="text-center">Već imate profil? <a href="LoginServlet">Prijavi se</a></p>
                        <p  class="text-center"><a style="color:#4267B2" href="IndexServlet">Povratak nazad</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>






<!-- ============= FOOTER// ============== -->

<div class="container">
    <footer class="py-3 my-4">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="/" class="nav-link px-2 text-muted">Početna</a></li>
            <li class="nav-item"><a href="dostava.jsp" class="nav-link px-2 text-muted">Dostava</a></li>
            <li class="nav-item"><a href="reklamacije.jsp" class="nav-link px-2 text-muted">Reklamacije</a></li>
            <li class="nav-item"><a href="cestapitanja.jsp" class="nav-link px-2 text-muted">Česta pitanja</a></li>
            <li class="nav-item"><a href="kontakt.jsp" class="nav-link px-2 text-muted">Kontakt</a></li>
            <li class="nav-item"><a href="Onama.jsp" class="nav-link px-2 text-muted">O nama</a></li>
        </ul>
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <p class="text-center text-muted">©Razor Sharp Technologies, Inc</p>

            <li class="ms-3"><a class="text-muted" href="https://twitter.com/"><i class="bi bi-twitter"></i></a></li>
            <li class="ms-3"><a class="text-muted" href="https://www.instagram.com/"><i class="bi bi-instagram"></i></a></li>
            <li class="ms-3"><a class="text-muted" href="https://web.facebook.com/"><i class="bi bi-facebook"></i></a></li>
        </ul>
    </footer>

</div>


<script src="/resources/javascript/jquery.min.js"></script>
<script src="/resources/javascript/popper.js"></script>
<script src="/resources/javascript/bootstrap.min.js"></script>
<script src="/resources/javascript/main.js"></script>

</body>
</html>
