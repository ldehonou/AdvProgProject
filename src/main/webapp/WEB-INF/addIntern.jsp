
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
    <h2 class="text-center mt-2 mb-4">Add new intern</h2>

    <div class="mt-5">
        <form action="createIntern" method="post">
            <div class="row">
                <div class="form-group col-6">
                    <label for="lastname">Lastname</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Firstname">
                </div>
                <div class="form-group col-6">
                    <label for="firstname">Firstname</label>
                    <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Firstname">
                </div>
            </div>

            <div class="row">
                <div class="form-group col-6">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                </div>
                <div class="form-group col-6">
                    <label for="phoneNumber">Phone number</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Phone number">
                </div>
            </div>

            <div class="row">
                <div class="form-group col-6">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Address">
                </div>
                <div class="form-group col-4">
                    <label for="city">City</label>
                    <input type="text" class="form-control" id="city" name="city" placeholder="City">
                </div>
                <div class="form-group col-2">
                    <label for="firstname">Postal Code</label>
                    <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="Postal code">
                </div>
            </div>

            <div class="text-center mt-2">
                <button type="submit" class="btn btn-primary">Create</button>
            </div>

        </form>

    </div>





</div>


</body>
</html>
