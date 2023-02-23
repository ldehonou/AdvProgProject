
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="mr-3 font-weight-bold">${sessionScope.identifiant}</div>
            <div>
                <a href="logout" class="btn btn-danger">Logout</a>
            </div>
        </div>
    </div>
</nav>

    <div class="container-fluid bg-white p-5">
        <h2 class="text-center mt-2">Hello ${sessionScope.identifiant}</h2>

        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Groupe</th>
                <th scope="col">Nom</th>
                <th scope="col">Prenom</th>
                <th scope="col">C.d.c</th>
                <th scope="col">Fiche visite</th>
                <th scope="col">Fiche éval</th>
                <th scope="col">Sondage Web</th>
                <th scope="col">Rapport rendu</th>
                <th scope="col">Soutenance</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>23</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>v</td>
                <td>v</td>
                <td>v</td>
                <td>v</td>
                <td>v</td>
                <td>v</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>100</td>
                <td>Mira</td>
                <td>To</td>
                <td>x</td>
                <td>x</td>
                <td>x</td>
                <td>x</td>
                <td>v</td>
                <td>v</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>1</td>
                <td>Zidane</td>
                <td>Zidane</td>
                <td>x</td>
                <td>v</td>
                <td>v</td>
                <td>v</td>
                <td>x</td>
                <td>v</td>
            </tr>
            </tbody>
        </table>

        <div class="text-center">
            <button class="btn btn-primary">Ajouter</button>
            <button class="btn btn-warning">Valider</button>
        </div>



    </div>


</body>
</html>
