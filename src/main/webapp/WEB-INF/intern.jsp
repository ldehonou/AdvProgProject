
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
    <h2 class="text-center">Intern informations</h2>

    <div class="container mt-4">
        <div class="row">
            <div class="container col-6 border border-dark">
                <h4>Intern</h4>
                <div class="row">
                    <label>Identifiant :</label>
                    <strong class="ml-3">${internship.internByIdIntern.id}</strong>
                </div>
                <div class="row">
                    <label>Lastname : </label>
                    <strong  class="ml-3">${internship.internByIdIntern.lastname}</strong>
                </div>
                <div class="row">
                    <label>Firstname : </label>
                    <strong class="ml-3">${internship.internByIdIntern.firstname}</strong>
                </div>

            </div>
            <div class="col-6 container p-3 border border-dark">
                <h4>Company</h4>
                <div class="row">
                    <label>Name : </label>
                    <strong class="ml-3">${internship.companyByIdCompany.name}</strong>
                </div>
                <div class="row">
                    <label>Address : </label>
                    <strong class="ml-3">${internship.companyByIdCompany.address}</strong>
                </div>
                <div class="row">
                    <label>Started date : </label>
                    <strong  class="ml-3">${internship.startedDate}</strong>
                </div>
                <div class="row">
                    <label>Ended date : </label>
                    <strong  class="ml-3">${internship.endedDate}</strong>
                </div>

            </div>
        </div>

        <div class = "row">
            <h4>Internship</h4>
            <div class="col">
                <label>Mission : </label>
                <strong>${internship.mission}</strong>
            </div>
            <div class="col">
                <label>Comments : </label>
                <strong>....</strong>
            </div>
        </div>
    </div>

</div>


</body>
</html>
