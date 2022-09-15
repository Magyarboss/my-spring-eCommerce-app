
<%--
  Created by IntelliJ IDEA.
  User: Magyarboss
  Date: 9/13/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="/resources/javascript/sidebar-nav-submenu.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/sidebar-nav-submenu.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body class="d-flex flex-column min-vh-100">

<!-- ============= HEADER ============== -->
<header class="p-3 bg-dark text-white">
    <div  class="container-fluid">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-white">Početna</a></li>
                <li><a href="cestapitanja.jsp" class="nav-link px-2 text-white">Česta pitanja</a></li>
                <li><a href="kontakt.jsp" class="nav-link px-2 text-white">Kontakt</a></li>
                <li><a href="Onama.jsp" class="nav-link px-2 text-white">O nama</a></li>
            </ul>
            <form class="col-auto col-auto mb-3 mb-md-0 me-3">
                <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
            </form>

            <c:if test="${userDTO!=null}" >
                <div  class="dropdown text-end mx-2">
                    <a href="#" class="d-block link-light text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <c:if test="${userDTO.image==null}">
                            <img src="/resources/images/profile-images/blank-profile-picture-973460__340.png" alt="mdo" width="32" height="32" class="rounded-circle">
                        </c:if>
                        <c:if test="${userDTO.image!=null}">
                            <img src="/user/${userDTO.username}/userImage" alt="mdo" width="32" height="32" class="rounded-circle">
                        </c:if>
                            ${userDTO.firstName}
                    </a>
                    <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
                        <li><a class="dropdown-item" href="/user/${userDTO.username}/profile">Moj profil</a></li>
                        <li><a class="dropdown-item" href="PovijestKupnjeServlet">Moja povijest kupnja</a></li>

                        <c:if test="${userDTO.userType=='ADMIN'}" >
                            <li><a class="dropdown-item" href="PovijestKupnjeAdminServlet">Povijest svih kupnja</a></li>
                        </c:if>

                        <li><a class="dropdown-item" href="#">Promjena lozinke</a></li>

                        <c:if test="${userDTO.userType=='ADMIN'}" >
                            <li><a class="dropdown-item" href="dodavanjeproizvoda.jsp">Dodavanje proizvoda</a></li>
                        </c:if>

                        <li><a class="dropdown-item" href="#">Postavke</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/logout">Odjavi se</a></li>
                    </ul>
                </div>
            </c:if>
            <div class="text-end mx-2">
                <c:if test="${userDTO==null}" >
                    <a href="/login" class="btn btn btn-success me-2">Prijava</a>
                    <a href="RegisterServlet" class="btn btn-success me-2">Registracija</a>
                </c:if>

                <div  class="float-end mx-2">
                    <c:if test="${kosarica==null}">
                        <a href="PrikazKosariceServlet" class="btn btn-warning"> Moja košarica <i class="bi bi-cart4"></i> </a>
                    </c:if>
                    <c:if test="${kosarica!=null}">
                        <a href="PrikazKosariceServlet" class="btn btn-warning"> Moja košarica <i class="bi bi-cart4"></i> (${kosarica.size()}) </a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</header>

<hr style="margin: 0 0 0 0;color: whitesmoke "></hr>

<header class="p-3 bg-dark text-white">
    <div class="container-fluid d-flex justify-content-sm-center justify-content-lg-start align-content-lg-center mb-lg-0 ">
        <a href="/"  class="text-dark text-decoration-none">
            <h1  style="color:white;"><b><i> Razor Sharp Technologies </i> Inc.</b> </h1>
        </a>
    </div>
</header>






<h1>Dodaj sliku</h1>

<div class="container">
    <div class="form-group">
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">
                <div class="form-group">
                <c:if test="${userDTO.image==null}">
                    <img src="/resources/images/profile-images/blank-profile-picture-973460__340.png" alt="mdo" width="182" height="182" class="rounded-circle">
                </c:if>

                <c:if test="${userDTO.image!=null}">
                    <img src="/user/${userDTO.username}/userImage" alt="mdo" width="182" height="182" class="rounded-circle">
                </c:if>
                </div>
                <form action="/user/${userDTO.username}/image" class="signin-form" method="POST" enctype="multipart/form-data">
                    Odaberi sliku:
                    <input type="file" name="file" required>
                    <div class="form-group">
                        <input class="form-control btn btn-primary rounded submit px-3" type="submit" value="add image">
                    </div>
                    <div class="form-group">
                        <input  type="reset" value='Obriši uneseno'>
                    </div>
                </form>
                <p  class="text-center"> <a style="color:#4267B2" href="/">Povratak nazad</a> </p>
            </div>
        </div>
    </div>
</div>




<!-- ============= FOOTER// ============== -->

<div class="container mt-auto">
    <footer class="py-3 my-4">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="IndexServlet" class="nav-link px-2 text-muted">Početna</a></li>
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



</body>
</html>
