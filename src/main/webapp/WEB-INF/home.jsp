
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>InternManage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="height: 100%; width: 100%; background-color: #e9ecef">

<%
    if(session.getAttribute("identifiant") == null){
        response.sendRedirect(request.getContextPath() +"/");
    }
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">InternManage</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">


        </ul>
        <div class="form-inline my-2 my-lg-0">
            <div class="mr-3 font-weight-bold">${sessionScope.tutor}</div>
            <div>
                <a href="logout" class="btn btn-danger">Logout</a>
            </div>
        </div>
    </div>
</nav>

    <div class="container-fluid bg-white p-5">
        <h2 class="text-center mt-2">Hello ${sessionScope.tutor}</h2>

        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th class="text-center" scope="col">Action</th>
                <th class="text-center" scope="col">Nom</th>
                <th class="text-center" scope="col">C.d.c</th>
                <th class="text-center" scope="col">Fiche visite</th>
                <th class="text-center" scope="col">Fiche éval</th>
                <th class="text-center" scope="col">Sondage Web</th>
                <th class="text-center" scope="col">Rapport rendu</th>
                <th class="text-center" scope="col">Soutenance</th>
                <th  class="text-center" scope="col">Debut</th>
                <th class="text-center" scope="col">Fin</th>
                <th class="text-center" scope="col">Entr</th>
                <th class="text-center" scope="col">Adresse</th>
                <th class="text-center" scope="col">Note Tech</th>
                <th class="text-center" scope="col">Note Com</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${interns}" var="intern">
                <tr class="text-center">
                    <td style="display: flex;flex-direction: column;gap: 5px;">
                        <a class="btn btn-primary btn-sm" href="intern?id=${intern.internByIdIntern.id}">
                            <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-box-arrow-up-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M8.636 3.5a.5.5 0 0 0-.5-.5H1.5A1.5 1.5 0 0 0 0 4.5v10A1.5 1.5 0 0 0 1.5 16h10a1.5 1.5 0 0 0 1.5-1.5V7.864a.5.5 0 0 0-1 0V14.5a.5.5 0 0 1-.5.5h-10a.5.5 0 0 1-.5-.5v-10a.5.5 0 0 1 .5-.5h6.636a.5.5 0 0 0 .5-.5z"/>
                                <path fill-rule="evenodd" d="M16 .5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h3.793L6.146 9.146a.5.5 0 1 0 .708.708L15 1.707V5.5a.5.5 0 0 0 1 0v-5z"/>
                            </svg>
                        </a>
                        <a class="btn btn-danger btn-sm" href="removeIntern?id=${intern.internByIdIntern.id}">
                            <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                            </svg>
                        </a>
                    </td>
                    <td class="text-center">${intern.internByIdIntern.lastname}</td>
                    <td class="text-center">
                        <span class="bg-light p-1" style="border-radius: 50px">
                            <c:choose>
                                <c:when test="${intern.cdc}">✔️</c:when>
                                <c:otherwise>❌</c:otherwise>
                            </c:choose>
                        </span>
                    </td>
                    <td class="text-center">
                        <span class="bg-light p-1" style="border-radius: 50px">
                            <c:choose>
                                <c:when test="${intern.visitSheet}">✔️</c:when>
                                <c:otherwise>❌</c:otherwise>
                            </c:choose>
                        </span>
                    </td>
                    <td class="text-center">
                        <span class="bg-light p-1" style="border-radius: 50px">
                            <c:choose>
                                <c:when test="${intern.evalSheet}">✔️</c:when>
                                <c:otherwise>❌</c:otherwise>
                            </c:choose>
                        </span>
                    </td>
                    <td class="text-center">
                        <span class="bg-light p-1" style="border-radius: 50px">
                            <c:choose>
                                <c:when test="${intern.webSurvey}">✔️</c:when>
                                <c:otherwise>❌</c:otherwise>
                            </c:choose>
                        </span>
                    </td>
                    <td class="text-center">
                        <span class="bg-light p-1" style="border-radius: 50px">
                            <c:choose>
                                <c:when test="${intern.report}">✔️</c:when>
                                <c:otherwise>❌</c:otherwise>
                            </c:choose>
                        </span>
                    </td>
                    <td class="text-center">
                        <span class="bg-light p-1" style="border-radius: 50px">
                            <c:choose>
                                <c:when test="${intern.defense}">✔️</c:when>
                                <c:otherwise>❌</c:otherwise>
                            </c:choose>
                        </span>
                    </td>
                    <td class="text-center">${intern.startedDate}</td>
                    <td class="text-center">${intern.endedDate}</td>
                    <td class="text-center">${intern.companyByIdCompany.name}</td>
                    <td class="text-center">${intern.companyByIdCompany.address}</td>
                    <td class="text-center font-weight-bold">${intern.noteTech}</td>
                    <td class="text-center font-weight-bold">${intern.noteCom}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

        <div class="text-center">
            <a href="createIntern" class="btn btn-warning">+ Ajouter stagiaire</a>
        </div>

    </div>


</body>
</html>
