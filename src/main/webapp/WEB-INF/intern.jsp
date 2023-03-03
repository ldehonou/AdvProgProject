
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
    <h2 class="text-center">Intern informations</h2>

    <div class="mt-4">
        <div style="display: flex;flex-direction: row;gap:40px;">
            <div class="bloc-infos">
                <div class="div-title-bloc">
                    <h4 class="title-bloc">Intern</h4>
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
                            <label>Lastname : </label>
                            <strong  class="ml-3">${internship.internByIdIntern.lastname}</strong>
                        </div>
                        <div class="p-2">
                            <label>Firstname : </label>
                            <strong class="ml-3">${internship.internByIdIntern.firstname}</strong>
                        </div>
                    </div>
                </div>


            </div>

            <div class="bloc-infos">
                <div class="div-title-bloc">
                    <h4 class="title-bloc">Company</h4>
                </div>
                <div class="mt-3">
                    <label>Name : </label>
                    <strong class="ml-3">${internship.companyByIdCompany.name}</strong>
                </div>
                <div class="">
                    <label>Address : </label>
                    <strong class="ml-3">${internship.companyByIdCompany.address}</strong>
                </div>
                <div class="">
                    <label>Started date : </label>
                    <strong  class="ml-3">${internship.startedDate}</strong>
                </div>
                <div class="">
                    <label>Ended date : </label>
                    <strong  class="ml-3">${internship.endedDate}</strong>
                </div>


            </div>
        </div>
        <div>
            <div class="bloc-infos" style="display: flex;flex-direction: column;width:100%!important;">
                <div class="div-title-bloc">
                    <h4 class="title-bloc">Internship</h4>
                </div>
                <label>Mission : </label>
                <strong>${internship.mission}</strong>
                <label class="mt-4">Comments : </label>
                <strong>....</strong>
            </div>

        </div>


    </div>

</div>


</body>
</html>
