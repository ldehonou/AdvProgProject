
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>InternManage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .bloc-infos{
            margin-top:40px;
            padding:10px;
            background-color: #f3f3f3;
            border-radius: 15px;
            border-left: 5px solid #A4EEEA;
            width:50%;
        }
        .title-bloc{
            padding: 8px;
            background-color: white;
            width: fit-content;
            border-radius: 15px;
        }
        .div-title-bloc{
            display: flex;
            justify-content: center;
        }
    </style>
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
    <div>
        <div class="float-left">
            <a href="home">
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" class="bi bi-arrow-return-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M14.5 1.5a.5.5 0 0 1 .5.5v4.8a2.5 2.5 0 0 1-2.5 2.5H2.707l3.347 3.346a.5.5 0 0 1-.708.708l-4.2-4.2a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 8.3H12.5A1.5 1.5 0 0 0 14 6.8V2a.5.5 0 0 1 .5-.5z"/>
                </svg>
                Back
            </a>
        </div>
        <h2 class="text-center">Stagiaire informations</h2>
    </div>


    <div class="mt-2">
        <div style="display: flex;flex-direction: row;gap:40px;">
            <div class="bloc-infos">
                <div class="div-title-bloc">
                    <h4 class="title-bloc">Stagiaire</h4>
                </div>
                <div style="display: flex;align-items: center;gap:45px;">
                    <div>
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRv3v8eT0Vp-0n3xYiISR6P-5Q1GZ0zoKHUQbXd-66yiWE2W4mmpO5LQfk0tUnpAvo54KU&usqp=CAU" style="width:80px;height: 80px;border-radius: 50px;" />
                    </div>
                    <div>
                        <div class="p-2 mt-3" >
                            <label>Identifiant :</label>
                            <strong class="ml-3">${internship.internByIdIntern.id}</strong>
                        </div>
                        <div class="p-2">
                            <label>Nom : </label>
                            <strong  class="ml-3">${internship.internByIdIntern.lastname}</strong>
                        </div>
                        <div class="p-2">
                            <label>Prenom : </label>
                            <strong class="ml-3">${internship.internByIdIntern.firstname}</strong>
                        </div>
                    </div>
                </div>


            </div>

            <div class="bloc-infos">
                <div class="div-title-bloc">
                    <h4 class="title-bloc">Entreprise</h4>
                </div>
                <div class="mt-3">
                    <label>Nom : </label>
                    <strong class="ml-3">${internship.companyByIdCompany.name}</strong>
                </div>
                <div class="">
                    <label>Adresse : </label>
                    <strong class="ml-3">${internship.companyByIdCompany.address}</strong>
                </div>
                <div class="">
                    <label>Ville : </label>
                    <strong class="ml-3">${internship.companyByIdCompany.city}</strong>
                </div>
                <div class="">
                    <label>Code Postal : </label>
                    <strong class="ml-3">${internship.companyByIdCompany.postalcode}</strong>
                </div>

            </div>
        </div>
        <div style="display: flex;flex-direction: row;gap:40px;">
            <div class="bloc-infos" style="display: flex;flex-direction: column;">
                <div class="div-title-bloc">
                    <h4 class="title-bloc">Stage</h4>
                </div>
                <label>Mission : </label>
                <strong>${internship.mission}</strong>
                <div class="mt-5">
                    <label>Date de début : </label>
                    <strong  class="ml-3">${internship.startedDate}</strong>
                </div>
                <div class="mt-5">
                    <label>Date de fin : </label>
                    <strong  class="ml-3">${internship.endedDate}</strong>
                </div>
            </div>
            <div class="bloc-infos" style="display: flex;flex-direction: column;">
                <div class="div-title-bloc">
                    <h4 class="title-bloc">Actions</h4>
                </div>
                <form action="intern" method="post">
                    <div class="mt-2" style="display: flex;flex-direction: row;gap:10px;">
                        <input type="hidden" name="idIntern" value="${internship.id}">
                        <div class="col-4 form-check">
                            <input type="checkbox" class="form-check-input" name="cdc" <c:if test="${internship.cdc}">checked</c:if>>
                            <label class="form-check-label" >Cdc</label>
                        </div>
                        <div class="col-4 form-check">
                            <input type="checkbox" class="form-check-input" name="visitSheet" <c:if test="${internship.visitSheet}">checked</c:if>>
                            <label class="form-check-label" >Fiche visite</label>
                        </div>
                        <div class="col-4 form-check">
                            <input type="checkbox" class="form-check-input" name="evalSheet" <c:if test="${internship.evalSheet}">checked</c:if>>
                            <label class="form-check-label" >Fiche eval</label>
                        </div>

                    </div>
                    <div class="mt-2" style="display: flex;flex-direction: row;gap:10px;">
                        <div class="col-4 form-check">
                            <input type="checkbox" class="form-check-input" name="webSurvey" <c:if test="${internship.webSurvey}">checked</c:if>>
                            <label class="form-check-label" >Sondage web</label>
                        </div>
                        <div class="col-4  form-check">
                            <input type="checkbox" class="form-check-input" name="report" <c:if test="${internship.report}">checked</c:if>>
                            <label class="form-check-label" >Rapport rendu</label>
                        </div>
                        <div class="col-4 form-check">
                            <input type="checkbox" class="form-check-input" name="defense" <c:if test="${internship.defense}">checked</c:if>>
                            <label class="form-check-label" >Soutenance</label>
                        </div>
                    </div>
                    <div class="mt-3" style="display: flex;flex-direction: row;">
                        <div class="col-6">
                            <label>Note tech</label>
                            <input type="text" class="form-control" name="noteTech"  placeholder="Entrez une note" value="${internship.noteTech}">
                        </div>
                        <div class="col-6">
                            <label >Note com</label>
                            <input type="text" class="form-control" name="noteCom"  placeholder="Entrez une note" value="${internship.noteCom}">
                        </div>
                    </div>
                    <div class="text-center mt-3">
                        <button class="btn btn-primary" type="submit">Valider</button>
                    </div>
                </form>


            </div>

        </div>


    </div>

</div>


</body>
</html>
