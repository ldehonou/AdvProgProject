<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>InternManage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="display: table;position: absolute;height: 100%; width: 100%">
<br/>

<div class="jumbotron vertical-center" style="display: table-cell; vertical-align: middle;">
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h3 class="card-title text-center mb-5">Authentication</h3>
                <form action="/hello-servlet" method="post">
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">Identifiant</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="identifiant" placeholder="Enter identifiant">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" name="password"  placeholder="Enter password">
                        </div>
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </div>

                </form>
            </div>
        </div>
    </div>
    <a href="hello-servlet">Hello Servlet</a>

</div>


</body>
</html>