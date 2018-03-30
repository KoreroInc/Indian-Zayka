<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>

<%@page import="model.CustomerModel"%>
<%
String opr=request.getParameter("opr");
String indexstr=request.getParameter("index");
CustomerModel cm=new CustomerModel();


if(opr!=null && indexstr!=null)
{
    opr=opr.trim();
    int index=Integer.parseInt(indexstr.trim());
    ArrayList<CustomerModel> alcm=null;
    if(opr.equals("edit"))
    {
    alcm=(ArrayList<CustomerModel>)session.getAttribute("AllCustomers");
    cm=alcm.get(index);
    }
}

%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Indian Zayka</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/style.css" rel="stylesheet">
</head>
 
<body>

 <script>      
        function getXmlHttpRequestObject()
        {
        var xmlHttpReq;

        if(window.XMLHttpRequest)
        {
            request=new window.XMLHttpRequest();
        }
        else if(window.ActiveXObject)
        {
            request=new window.ActiveXObject();
        }
        else
        {
            request=null;
        }
        return request;
        }
        
        
        function checkMail()
        {
        var mail=document.getElementById("form2").value;
        request=getXmlHttpRequestObject();
        request.onreadystatechange=showResponseMail;
        request.open("post","CheckMail",true);
        request.setRequestHeader ("Content-Type", "application/x-www-form-urlencoded");

        var data="mail="+mail;
        request.send(data);
        }
        var ismail=false;
        function showResponseMail()
        {
            if(request.readyState===4 && request.status===200)
            {
                if(request.responseText.trim()=="true")
                {
                    ismail=true;
                    alert("E-Mail Already Exists...!!!");
                }
                else
                {
                    ismail=false;
                }
            }
        }
        </script>
        
    <!--Navbar-->
    <nav class="navbar navbar-toggleable-md navbar-dark fixed-top scrolling-navbar graphite-gradient">
        <div class="container">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav1" aria-controls="navbarNav1" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">
            <img src="img/indianzaykat.png" style="height: 35px;width: 70px;">
            </a>
            <div class="collapse navbar-collapse" id="navbarNav1">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a href="CreatePoll.jsp" class="nav-link">Create Poll</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ShowPolls?zayka=0&status=o&type=1">View Polls</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">Customer Entry<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ShowCustomers">View Customers</a>

                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item">
                        <a href="LogOut" class="nav-link hoverable"><strong>Log off</strong></a>

                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!--/.Navbar-->

<main>
   <div class="container mt-5">
        <div class="flex-center">
            <!--Form with header-->
                <div class="card col-md-6">
                    <div class="card-block">
                        <form method="post" onsubmit="return validate()" id="registrationForm">
                        <!--Header-->
                        <div class="form-header" style="background-color: #2E2E2E">
                            <h3><i class="fa fa-user"></i> Register:</h3>
                        </div>

                        <!--Body-->
                        <div class="md-form">
                            <i class="fa fa-user prefix"></i>
                            <input type="text" id="form3" class="form-control" name="name" value="<%=cm.getName() %>" required>
                            <label for="form3">Your name</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-envelope prefix"></i>
                            <input type="email" id="form2" class="form-control" name="email" onchange="checkMail()"value="<%=cm.getEmail() %>" required>
                            <label for="form2">Your email</label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-book prefix"></i>
                            <input type="text" id="form4" class="form-control" name="address" value="<%=cm.getAddress() %>" required>
                            <label for="form4">Your address</label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-mobile prefix"></i>
                            <input type="text" pattern="[789][0-9]{9}" id="form5" class="form-control" name="mobile" value="<%=cm.getMobile() %>" required>
                            <label for="form5">Contact No</label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-mobile prefix"></i>
                            <input type="text" pattern="[789][0-9]{9}" id="form6" class="form-control" name="altMobile" value="<%=cm.getAltMobile() %>" required>
                            <label for="form6">Alternate no.</label>
                        </div>
                        <div class="md-form wow fadeInDown">
                            <i class="fa fa-tag prefix"></i>
                            <li class="nav-item btn-group">
                                <a class="nav-link dropdown-toggle ml-5" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Zayka</a>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <a class="dropdown-item" id="Z1" onclick="myfunct1(this.id);">Executive</a>
                                    <a class="dropdown-item" id="Z2" onclick="myfunct1(this.id);">Health</a>
                                    <a class="dropdown-item" id="Z3" onclick="myfunct1(this.id);">Student</a>
                                </div>
                            </li>
                            <li class="nav-item btn-group">
                                <a class="nav-link dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Type</a>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                    <a class="dropdown-item" id="T1" onclick="myfunct2(this.id);">Lunch</a>
                                    <a class="dropdown-item" id="T2" onclick="myfunct2(this.id);">Dinner</a>
                                    <a class="dropdown-item" id="T3" onclick="myfunct2(this.id);">Both</a>
                                </div>
                            </li>
                        </div>
                        <div class="text-center">
                            <input id="submit" type="submit" value="REGISTER" class="btn black">
                        </div>
                        </form>
                    </div>
                </div>
          <!--/Form with header-->
        </div>
    </div>
    <!-- /Start your project here-->
</main>
        <!--Footer-->
    <footer class="page-footer center-on-small-only mb-0 pb-0 black">

            <div class="container-fluid text-center" style="padding-bottom: 10px;">
                © 2017 Made with <i class="fa fa-heart" aria-hidden="true" style="color: #ff0000;"></i> by team Korero
            </div>
        <!--/.Copyright-->

    </footer>
    <!--/.Footer-->
    <!-- SCRIPTS -->
    <script type="text/javascript">
        var zayka="zayka",type="type";
        function myfunct1(id1) {
                document.getElementById("dropdownMenu1").innerHTML = document.getElementById(id1).innerHTML;
                zayka=document.getElementById(id1).id.charAt(1);
              
            }
            function myfunct2(id2) {
                document.getElementById("dropdownMenu2").innerHTML = document.getElementById(id2).innerHTML;
                type=document.getElementById(id2).id.charAt(1);
                
            }
            function myfunct3(id) {
                document.getElementById("dropdownMenu3").innerHTML = document.getElementById(id).innerHTML;
            }

    </script>
    
    <script>
                function validate()
                {
                if(ismail)
                {
                    alert("E-Mail Already Exists...!!!");
                    return false;
                }
                else if(zayka==="zayka")
                {
                    alert("Choose Appropriate Zayka Type Of Customer...");
                    return false;
                }
                else if(type==="type")
                {
                    alert("Choose Appropriate Type Of Particular Customer...");
                    return false;
                }
                document.getElementById("registrationForm").setAttribute("action","RegisterCustomer?opr=<%=opr%>&id=<%=cm.getId() %>&zayka="+zayka+"&type="+type);
                }
                
                
                if("<%=opr%>"==="edit")
                {
                    zayka="<%=cm.getZaykaId() %>";
                    type="<%=cm.getTypeId() %>";
                    document.getElementById("dropdownMenu1").innerHTML="<%=cm.getZaykaName()%>";
                    document.getElementById("dropdownMenu2").innerHTML="<%=cm.getTypeName()%>";
                    document.getElementById("submit").value="Update";
                }
                else
                    document.getElementById("submit").value="Register";
            </script>
        
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
