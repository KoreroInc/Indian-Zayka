<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Login</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
 </head>

<body>
    <!--Navbar-->
    <nav class="navbar navbar-toggleable-md navbar-dark fixed-top scrolling-navbar graphite-gradient">
        <div class="container">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav1" aria-controls="navbarNav1" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">
             <img src="img/indianzaykat.png" style="height: 35px;width: 70px;">
            INDIAN ZAYKA
            </a>
        </div>
    </nav>
    <!--/.Navbar-->

    <!-- Start your project here-->
    <div style="height: 93vh">
        <div class="flex-center">
    
            <!--Form with header-->
                <div class="card col-md-5">
                    <div class="card-block">
                        <form action="CheckAdmin" method="post">
                        <!--Header-->
                        <div class="form-header black">
                            <h3><i class="fa fa-user"></i> Login:</h3>
                        </div>

                        <!--Body-->
                        <div class="md-form">
                            <i class="fa fa-user prefix"></i>
                            <input type="text" id="form3" name="adminId" class="form-control" required>
                            <label for="form3">User Id</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-lock prefix"></i>
                            <input type="password" id="form2" name="adminPwd" class="form-control" required>
                            <label for="form2">Password</label>
                        </div>
                        
                        <div class="text-center">
                            <input type="submit" class="btn btn-md black" value="Log In">
                        </div>
                    </form>
                    </div>
                </div>
          <!--/Form with header-->

        </div>
    </div>
    <!--Footer-->
    <footer class="page-footer center-on-small-only mt-0 black">

            <div class="container-fluid text-center" style="padding-bottom: 10px;">
                © 2017 Made with <i class="fa fa-heart" aria-hidden="true" style="color: #ff0000;"></i> by team Korero
            </div>
        <!--/.Copyright-->

    </footer>
    <!--/.Footer-->

    <!-- /Start your project here-->
                        
    <!-- SCRIPTS -->
    <!-- JQuery -->
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/tether.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
</body>

</html>
