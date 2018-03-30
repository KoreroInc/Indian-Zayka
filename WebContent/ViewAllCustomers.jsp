<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CustomerModel"%>
<% ArrayList<CustomerModel> alcm=(ArrayList<CustomerModel>)session.getAttribute("AllCustomers"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    
    <title>View Customers</title>
 <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
 </head>
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
        
        var index;
        function deleteCustomer(x)
        {   
        index=x;
        request=getXmlHttpRequestObject();
        request.onreadystatechange=showResponse;
        request.open("post","DeleteCustomer",true);
        request.setRequestHeader ("Content-Type", "application/x-www-form-urlencoded");

        var data="id="+index;
        request.send(data);
        }
        
        function showResponse()
        {
            if(request.readyState===4 && request.status===200)
            {
                window.location="ShowCustomers";
                alert(request.responseText);
            }
        }
        
 
        function confirmDelete(x) {
            if (confirm("Are You Sure You Want To delete ?") === true) {
                deleteCustomer(x);
            } 
            
        }
        function editCustomer(x)
        {   
            window.location="CustomerEntry.jsp?opr=edit&index="+x;
        }
        </script>

<body>
    
    <!--Navbar-->
    <nav class="navbar navbar-toggleable-md navbar-dark fixed-top graphite-gradient">
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
                        <a class="nav-link" href="CreatePoll.jsp">Create Poll</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ShowPolls?zayka=0&status=o&type=1">View Polls</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerEntry.jsp">Customer Entry</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">View Customers<span class="sr-only">(current)</span></a>

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
    <div class="row">
        <div class="jumbotron col-md-12 pb-1 pt-1">
            <div class="md-form wow fadeInDown form-inline pb-0 mb-0">
                <i class="fa fa-tag prefix"></i>
                <li class="nav-item btn-group">
                    <a class="nav-link dropdown-toggle ml-5" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Zayka</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <a class="dropdown-item" id="z1" onclick="myfunct1(this.id);">Executive</a>
                        <a class="dropdown-item" id="z2" onclick="myfunct1(this.id);">Health</a>
                        <a class="dropdown-item" id="z3" onclick="myfunct1(this.id);">Student</a>
                    </div>
                </li>
                <li class="nav-item btn-group">
                    <a class="nav-link dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Type</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <a class="dropdown-item" id="t1" onclick="myfunct2(this.id);">Lunch</a>
                        <a class="dropdown-item" id="t2" onclick="myfunct2(this.id);">Dinner</a>
                        <a class="dropdown-item" id="t3" onclick="myfunct2(this.id);">Both</a>
                    </div>
                </li>
            <div class="form-inline waves-effect waves-light ml-5">
                
                <button class="btn btn-sm blue" onclick="setSearchParam()"><i class="fa fa-search"></i></button>            </div>

            </div>
            
            
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
        <div class="table-responsive">
           <table class="table table-hover">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>email</th>
                  <th>address</th>
                  <th>Contact</th>
                  <th>Alternate Contact</th>
                  <th>Zayka</th>
                  <th>Type</th>
                  <th>Edit</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody>
            <%if(alcm!=null){int i=0;for(CustomerModel cm:alcm){%>
        <tr>
            <th scope="row"><%=i+1%></th>
            <td><%=cm.getName() %></td>
            <td><%=cm.getAddress() %></td>
            <td><%=cm.getEmail() %></td>
            <td><%=cm.getMobile() %></td>
            <td><%=cm.getAltMobile() %></td>
            <td><%=cm.getZaykaName()%></td>
            <td><%=cm.getTypeName() %></td>
            <td><button class="btn btn-sm blue" onclick="editCustomer(<%=i%>)"><i class="fa fa-pencil"></i></button></td>
            <td><button class="btn btn-sm red" onclick="confirmDelete(<%=cm.getId() %>)"><i class="fa fa-trash"></i></button></td>
        </tr>
        <%i++;}}
            if(alcm!=null && alcm.size()==0){
        %>
        <tr><center style="color: red"><b>NO CUSTOMERS FOUND</b></center></tr><br>
        <%}%>
              </tbody>
            </table>
            </div>
        </div>
        
    </div>
</div>
</main>
    <!--Footer-->
    <footer class="page-footer center-on-small-only mt-0 black">

            <div class="container-fluid text-center" style="padding-bottom: 10px;">
                © 2017 Made with <i class="fa fa-heart" aria-hidden="true" style="color: #ff0000;"></i> by team Korero
            </div>
        <!--/.Copyright-->

    </footer>
    <!--/.Footer-->
    <!-- Start your project here-->

    <!-- /Start your project here-->
    

    <!-- SCRIPTS -->
    <script type="text/javascript">
        var zayka="-1",type="-1";
        function myfunct1(id1) {
                document.getElementById("dropdownMenu1").innerHTML = document.getElementById(id1).innerHTML;
                zayka=document.getElementById(id1).id.charAt(1);
            }
            function myfunct2(id2) {
                document.getElementById("dropdownMenu2").innerHTML = document.getElementById(id2).innerHTML;
                type=document.getElementById(id2).id.charAt(1);;
            }
            function myfunct3(id) {
                document.getElementById("dropdownMenu3").innerHTML = document.getElementById(id).innerHTML;
            }
            
            function setSearchParam()
            {
                if(zayka!="-1" && type!="-1")
                    window.location="ShowCustomers?zayka="+zayka+"&type="+type;
                else
                    alert("Choose zayka and type first!");
            }

    </script>
    

    <!-- JQuery -->
    <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>

    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/tether.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>


</body>

</html>