
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
    <a class="navbar-brand" href="/home">InternManage</a>
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
    <h2 class="text-center mt-2 mb-4">Add new intern</h2>

    <div class="mt-5">
        <form action="createIntern" method="post">
            <div>
                <h4>Stagiaire :</h4>
                <div class="row p-3">
                    <div class="form-group col-6">
                        <label for="lastname">Nom</label>
                        <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Nom" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="firstname">Prenom</label>
                        <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Prenom" required>
                    </div>
                </div>

                <div class="row p-3">
                    <div class="form-group col-6">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="phoneNumber">Telephone</label>
                        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Telephone" required>
                    </div>
                </div>

                <div class="row p-3">
                    <div class="form-group col-6">
                        <label for="address">Adresse</label>
                        <input type="text" class="form-control" id="address" name="address" placeholder="Adresse" required>
                    </div>
                    <div class="form-group col-4">
                        <label for="city">Ville</label>
                        <input type="text" class="form-control" id="city" name="city" placeholder="Ville" required>
                    </div>
                    <div class="form-group col-2">
                        <label for="firstname">Code postal</label>
                        <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="Code postal" required>
                    </div>
                </div>

            </div>


            <div class="mt-4">
                <h4>Entreprise :</h4>
                <div class="row p-3">
                    <div class="form-group col-6">
                        <label for="lastname">Entreprise</label>
                        <input type="text" class="form-control" id="company" name="company" placeholder="Entreprise" required>
                    </div>
                </div>
                <div class="row p-3">
                    <div class="form-group col-6">
                        <label for="addressCompany">Adresse</label>
                        <input type="text" class="form-control" id="addressCompany" name="addressCompany" placeholder="Adresse" required>
                    </div>
                    <div class="form-group col-4">
                        <label for="cityCompany">Ville</label>
                        <input type="text" class="form-control" id="cityCompany" name="cityCompany" placeholder="Ville" required>
                    </div>
                    <div class="form-group col-2">
                        <label for="postalCodeCompany">Code postal</label>
                        <input type="text" class="form-control" id="postalCodeCompany" name="postalCodeCompany" placeholder="Code postal" required>
                    </div>
                </div>
            </div>

            <div class="mt-4">
                <h4>Stage :</h4>
                <div class="row p-3">
                    <div class="form-group col-6">
                        <label for="mission">Mission</label>
                        <input type="text" class="form-control" id="mission" name="mission" placeholder="Mission" required>
                    </div>
                </div>
                <div class="row p-3">
                    <div class="form-group col-6">
                        <label for="startedDate">Date de début</label>
                        <input type="date" class="form-control" id="startedDate" name="startedDate" placeholder="Started Date" required>
                    </div>
                    <div class="form-group col-6">
                        <label for="endedDate">Date de fin</label>
                        <input type="date" class="form-control" id="endedDate" name="endedDate" placeholder="Ended Date" required>
                    </div>
                </div>

            </div>


            <div class="text-center mt-2">
                <button type="submit" class="btn btn-primary">Créer</button>
            </div>

        </form>

    </div>

</div>


</body>
</html>
