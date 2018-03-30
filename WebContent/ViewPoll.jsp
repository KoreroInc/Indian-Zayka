<!DOCTYPE html>

<%@page import="model.OptionModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PollModel"%>
<%
ArrayList<PollModel> alpm=(ArrayList<PollModel>)session.getAttribute("AllPolls");
%>


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
        
       
        function deletePoll(x)
        {   
        request=getXmlHttpRequestObject();
        request.onreadystatechange=showResponse;
        request.open("post","DeletePoll",true);
        request.setRequestHeader ("Content-Type", "application/x-www-form-urlencoded");

        var data="pid="+x;
        request.send(data);
        }
        
        function showResponse()
        {
            if(request.readyState===4 && request.status===200)
            {
                alert(request.responseText);
                window.location="ShowPolls?zayka="+zayka+"&type="+type+"&status="+status;
                
            }
        }
        function showMailResponse()
        {
            if(request.readyState===4 && request.status===200)
            {
                alert(request.responseText);
                window.location="ShowPolls?zayka="+zayka+"&type="+type+"&status="+status;
            }
        }
 
        function confirmDelete(x) {
            if (confirm("Are You Sure You Want To delete ?") === true) {
                deletePoll(x);
            } 
            
        }
        function confirmEdit(x) {
            if (confirm("Are You Sure You Want To Edit ?") === true) 
            {
                window.location="CreatePoll.jsp?opr=edit&index="+x;
            } 
            
        }
        
        function confirmMail(x) {
            if (confirm("Are You Sure You Want To Mail ?") === true) {
                mailPoll(x);
            } 
            
        }
        
        
        
        function mailPoll(x)
        {
            
            document.getElementById("mail"+x).disabled=true;
            request=getXmlHttpRequestObject();
            request.onreadystatechange=showMailResponse;
            request.open("post","MailPoll",true);
            request.setRequestHeader ("Content-Type", "application/x-www-form-urlencoded");
            
            var data="index="+x;
            request.send(data);
         }
       
       
       function confirmOff(x) {
            if (confirm("Are You Sure You Want To Close the Poll?") === true) {
                offPoll(x);
            } 
            
        }
        
        function offPoll(x){
            request=getXmlHttpRequestObject();
            request.onreadystatechange=showOffResponse;
            request.open("post","ClosePoll",true);
            request.setRequestHeader ("Content-Type", "application/x-www-form-urlencoded");
            
            var data="pid="+x;
            request.send(data);
        }
        
        function showOffResponse()
        {
            if(request.readyState===4 && request.status===200)
            {
                alert(request.responseText);
                window.location="ShowPolls?zayka="+zayka+"&type="+type+"&status="+status;
            }
        }
        </script>
</head>
<body>
<div id="mdb-preloader" class="flex-center">
    <div id="preloader-markup">
    </div>
</div>
     <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>

    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/tether.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    
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
                        <a class="nav-link">View Polls<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerEntry.jsp">Customer Entry</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ShowCustomers">View Customers</a>

                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item ">
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
        <div class="jumbotron col-md-12 pb-1 pt-1"><h1 class="text-center display-4">POLLS</h1>
  </div>
</div>
    <div class="row"> 
        <div class="jumbotron col-md-12 pb-1 pt-1">
            <div class="md-form wow fadeInDown form-inline pb-0 mb-0">
                <i class="fa fa-tag prefix"></i>
                <li class="nav-item btn-group">
                    <a class="nav-link dropdown-toggle ml-5" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Zayka</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <a class="dropdown-item" id="z0" onclick="myfunct1(this.id);">All</a>
                        <a class="dropdown-item" id="z1" onclick="myfunct1(this.id);">Executive</a>
                        <a class="dropdown-item" id="z2" onclick="myfunct1(this.id);">Health</a>
                        <a class="dropdown-item" id="z3" onclick="myfunct1(this.id);">Student</a>
                        
                    </div>
                </li>
                
                <li class="nav-item btn-group">
                    <a class="nav-link dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Poll Status</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu3">
                        <a class="dropdown-item" id="o" onclick="myfunct3(this.id);">Open</a>
                        <a class="dropdown-item" id="p" onclick="myfunct3(this.id);">Pending</a>
                        <a class="dropdown-item" id="c" onclick="myfunct3(this.id);">Closed</a>
                    </div>
                </li>
                
                <li class="nav-item btn-group">
                    <a class="nav-link dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Type</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <a class="dropdown-item" id="t1" onclick="myfunct2(this.id);">Lunch</a>
                        <a class="dropdown-item" id="t2" onclick="myfunct2(this.id);">Dinner</a>
                        <a class="dropdown-item" id="t3" onclick="myfunct2(this.id);">Other</a>
                    </div>
                </li>
                <button class="btn btn-lg ml-5 white-text" style="background-color: #2e2e2e;" onclick="getPolls()">GO!</button>
            </div>
        </div>
    </div>
    
    <script>
               var zayka    ='<%=request.getParameter("zayka").trim() %>';
               var type     ='<%=request.getParameter("type").trim() %>';
               var status   ='<%=request.getParameter("status").trim() %>'
               var zayka1   =document.getElementById("z"+zayka).innerHTML;
               var type1    =document.getElementById("t"+type).innerHTML;
               var status1  =document.getElementById(status).innerHTML;
     
            document.getElementById("dropdownMenu1").innerHTML=zayka1;
            document.getElementById("dropdownMenu3").innerHTML=status1;
            document.getElementById("dropdownMenu2").innerHTML=type1;
            
    var colour=["#F7464A","#803790","#2196F3","#4CAF50","#FAFA37","#FF8833","#837050","#C8C8CD","#E97451","#F7468A"];
    var high=["#FF5A5E","#733380","#0B7DDA","#46A049","#FFEB00","#FF681F","#665233","#8B8680","#AF593E","#E30B56"];
    
     
     </script>
    <%if(alpm!=null){int i=0; for(PollModel pm:alpm){%>
        <%if(pm!=null){%>
    <div class="row">
      <div class="col-md-12">
                
        <!--Panel-->
        <div class="card">
            <div class="card-header white-text" style="background-color: #2e2e2e;">
               
                <span class="badge badge-primary"><%=pm.getZaykaName() %></span>
                <span class="badge badge-success"><%=pm.getStatusName() %></span>
                <span class="badge badge-warning"><%=pm.getTypeName() %></span>
               
            </div>
            <div class="card-block">
                <h4 class="card-title"><%=pm.getQue() %>
                <button class="btn btn-md red ml-5 delete" onclick="confirmDelete(<%=pm.getPollId() %>)"><i class="fa fa-trash"></i></button>
                <button class="btn btn-md blue edit" onclick="confirmEdit(<%=i%>)"><i class="fa fa-pencil"></i></button>
                <button class="btn btn-md green mail" onclick="confirmMail(<%=i%>)"><i class="fa fa-envelope"></i></button>
                <button class="btn btn-md btn-brown off" onclick="confirmOff(<%=pm.getPollId() %>)"><i class="fa fa-lock"></i></button>
                
                <div class="btn-group" data-toggle="buttons">
                    
                    
                  </div>

                </h4>
                 
               <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-6">
                    <canvas class="myChart"></canvas>
                  </div>
                  <div class="col-md-3">

                      <!--Panel-->
                        <div class="card card-block">
                            <h4 class="card-title">Poll statistics</h4>
                            <%for(OptionModel om : pm.getOption()){%>
                            <p class="card-text"><i class="fa fa-circle" aria-hidden="true" style="color: #f44336"></i> <%=om.getOptionText() %>: 
                            <span class="badge badge-info"><%=om.getVotecount() %></span>
                            </p>
                            <%}%>
                        </div>
                        <!--/.Panel-->
                  </div>
                </div>
               
            </div>
            <div class="card-footer text-muted white-text" style="background-color: #2e2e2e;">
                <p><i class="fa fa-clock-o"></i> <%=pm.getTimestamp() %></p>
            </div>
        </div>
        <!--/.Panel-->
      </div>  
    </div>
            <br>
            <br>
             <script type="text/javascript">
                 var j=0;
             document.getElementsByClassName("myChart")[<%=i%>].id="OurChart<%=i%>";
            
   
       $(function () {
    // Get the context of the canvas element we want to select
  var option = {
    responsive: true
    };
    
 var data = [];

<%int j=0;for (OptionModel om: pm.getOption()) {%>
        console.log(<%=om.getPercentCount() %>);
    data.push({
        
        value: <%=om.getPercentCount() %>,
        color: colour[<%=j%>],
        highlight: high[<%=j%>],
        label: "<%=om.getOptionText() %>"
    });
    
<%j++;}%>



 
 var ctx = document.getElementById("OurChart<%=i%>").getContext('2d');

 var myPieChart = new Chart(ctx).Pie(data,option);
 var myLineChart = new Chart(ctx).Line(data, option); //'Line' defines type of the chart.
    

});
    </script>
            
       <%}%>
     <%i++;}}%>
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
                status=document.getElementById(id).id;
            }
           
    </script>
    

    <!-- JQuery -->
   
   
    
    <script>
         var editar=document.getElementsByClassName("edit");
         for(i=0;i<editar.length;i++){
             editar[i].id="edit"+i;
             if(status!='p')
         {
             document.getElementById(editar[i].id).disabled=true;
         }
         }
         var mailar=document.getElementsByClassName("mail");
         for(i=0;i<mailar.length;i++){
             mailar[i].id="mail"+i;
             if(status!='p')
         {
             document.getElementById(mailar[i].id).disabled=true;
         }
         }
         var deletear=document.getElementsByClassName("delete");
         for(i=0;i<deletear.length;i++){
             deletear[i].id="delete"+i;
             
             if(status =='o')
         {
             document.getElementById(deletear[i].id).disabled=true;
         }
         }
         var radoff=document.getElementsByClassName("off");
         for(i=0;i<radoff.length;i++)
         {
             radoff[i].id="off"+i;
             if(status=='p' || status=='c')
             {
                 console.log(radoff[i].id);
                 document.getElementById(radoff[i].id).disabled=true;;
             }
         }
         
         function getPolls()
         {
             console.log("z="+zayka+"s="+status+"type"+type);
           window.location="ShowPolls?zayka="+zayka+"&status="+status+"&type="+type;  
         }
         
     </script>
     


</body>

</html>