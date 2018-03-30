<%@page import="model.OptionModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PollModel"%>

<%
    String opr=request.getParameter("opr");
    PollModel pm=null;
   if(opr!=null && opr.trim().equals("edit"))
   {
    int index=Integer.parseInt(request.getParameter("index"));
    ArrayList<PollModel> alpm=(ArrayList<PollModel>)session.getAttribute("AllPolls");
    pm=alpm.get(index);
   }
%>

<html>
    <head>
        
        <title>Indian Zayka</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        
        
        <link href="css/mdb.min.css" rel="stylesheet">
    
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
        
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.9/semantic.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.9/semantic.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!--<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>-->
    

      







<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




        <style>
            #qid {
  padding: 10px 15px;
  -moz-border-radius: 50px;
  -webkit-border-radius: 50px;
  border-radius: 20px;
}




label .glyphicon {
    top: 34%
}




.modal-header {
    background-color: transparent;
    color: inherit
}

.modal-body {
    min-height: 205px
    
}


@-moz-keyframes fadeG {
    0% {
        background-color: #000
    }

    100% {
        background-color: #FFF
    }
}

@-webkit-keyframes fadeG {
    0% {
        background-color: #000
    }

    100% {
        background-color: #FFF
    }
}

@-ms-keyframes fadeG {
    0% {
        background-color: #000
    }

    100% {
        background-color: #FFF
    }
}

@-o-keyframes fadeG {
    0% {
        background-color: #000
    }
    100% {
        background-color: #FFF
    }
}

@keyframes fadeG {
    0% {
        background-color: #000
    }

    100% {
        background-color: #FFF
    }
}


/*inputstyling*/



* { box-sizing:border-box; }

/* basic stylings ------------------------------------------ */
body 				 { 
                                   background-color: #53B2C8;
                                                                         
}
.container 		{ 
  font-family:'Roboto';
  width:600px; 
  margin:30px auto 0; 
  display:block; 
  background:#FFF;
  padding:10px 50px 50px;
}
h2 		 { 
  text-align:center; 
  margin-bottom:50px; 
}
h2 small { 
  font-weight:normal; 
  color:#888; 
  display:block; 
}
.footer 	{ text-align:center; }
.footer a  { color:#53B2C8; }

/* form starting stylings ------------------------------- */
.group 			  { 
  position:relative; 
  margin-bottom:45px; 
}
input 	,textarea			{
  font-size:18px;
  padding:10px 10px 10px 5px;
  display:block;
  width: 560px;
  border:none;
  border-bottom:2px solid #2e2e2e;
}
input:focus 		{ outline:none; }

/* LABEL ======================================= */
label 				 {
  color:#999; 
  font-size:18px;
  font-weight:normal;
  position:absolute;
  pointer-events:none;
  left:5px;
  top:10px;
  transition:0.2s ease all; 
  -moz-transition:0.2s ease all; 
  -webkit-transition:0.2s ease all;
}

/* active state */
input:focus ~ label, input:valid ~ label 		{
  top:-20px;
  font-size:14px;
  color:black;
}

/* BOTTOM BARS ================================= */
.bar 	{ position:relative; display:block; width:560px; }
.bar:before, .bar:after 	{
  content:'';
  height:2px; 
  width:0;
  bottom:1px; 
  position:absolute;
  background:black; 
  transition:0.2s ease all; 
  -moz-transition:0.2s ease all; 
  -webkit-transition:0.2s ease all;
}
.bar:before {
  left:50%;
}
.bar:after {
  right:50%; 
}

/* active state */
input:focus ~ .bar:before, input:focus ~ .bar:after {
  width:50%;
}

/* HIGHLIGHTER ================================== */
.highlight {
  position:absolute;
  height:60%; 
  width:560px; 
  top:25%; 
  left:0;
  pointer-events:none;
  opacity:0.5;
}

/* active state */
input:focus ~ .highlight {
  -webkit-animation:inputHighlighter 0.3s ease;
  -moz-animation:inputHighlighter 0.3s ease;
  animation:inputHighlighter 0.3s ease;
}

/* ANIMATIONS ================ */
@-webkit-keyframes inputHighlighter {
	from { background:#5264AE; }
  to 	{ width:0; background:transparent; }
}
@-moz-keyframes inputHighlighter {
	from { background:#5264AE; }
  to 	{ width:0; background:transparent; }
}
@keyframes inputHighlighter {
	from { background:#5264AE; }
  to 	{ width:0; background:transparent; }
}




/*create heading*/
   @-webkit-keyframes mask-move {
  0% {
    -webkit-transform: translateX(0);
            transform: translateX(0);
  }
  100% {
    -webkit-transform: translateX(400px);
            transform: translateX(400px);
  }
}
@keyframes mask-move {
  0% {
    -webkit-transform: translateX(0);
            transform: translateX(0);
  }
  100% {
    -webkit-transform: translateX(400px);
            transform: translateX(400px);
  }
}
@-webkit-keyframes mask-inner-move {
  0% {
    -webkit-transform: translateX(0);
            transform: translateX(0);
  }
  100% {
    -webkit-transform: translateX(-400px);
            transform: translateX(-400px);
  }
}
@keyframes mask-inner-move {
  0% {
    -webkit-transform: translateX(0);
            transform: translateX(0);
  }
  100% {
    -webkit-transform: translateX(-400px);
            transform: translateX(-400px);
  }
}
*,
*:before,
*:after {
  box-sizing: border-box;
}

body,
html {
  height: 100%;

}

body {
  padding: 0;
  margin: 0;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
      -ms-flex-pack: center;
          justify-content: center;
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  background: white;
  font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
}
/*.focus {
  font-size: 3rem;
  text-transform: uppercase;
  color:#2e2e2e;
  letter-spacing: .7rem;
  line-height: 1;
  position: relative;
  width: 700px;
}
.focus:before {
  content: 'CreatePoll';
  -webkit-filter: blur(3px);
          filter: blur(3px);
}
.focus:after {
  content: '';
  position: absolute;
  width: 80px;
  height: calc(100% + 8px);
  top: -4px;
  left: 0;
  border-top: 2px solid;
  border-bottom: 2px solid;
  -webkit-animation: mask-move 2s linear infinite alternate;
          animation: mask-move 2s linear infinite alternate;
}
.focus--mask {
  overflow: hidden;
  position: absolute;
  width: 80px;
  height: 100%;
  top: 0;
  left: 0;
  background: white;
  -webkit-animation: mask-move 2s linear infinite alternate;
          animation: mask-move 2s linear infinite alternate;
}
.focus--mask-inner {
  -webkit-animation: mask-inner-move 2s linear infinite alternate;
          animation: mask-inner-move 2s linear infinite alternate;
}*/

/*create heading*/
        </style>
     
    </head>
    
    <body>
        
        <div class="container-fluid bg-info" style="background-color: white; height: 100%; position: relative;top: 70px;">
            
           <br> <br> <div class="focus" style="position: relative;left:300px;margin-left: 0px;"> 
  
      <div  style="color:#2e2e2e;font-size: 40px" id="titlePoll">Create Poll </div>
  
</div>
           <br><br>
           <div style="text-align: center">
  Zayka
  <select class="ui dropdown" name="zayka" id="zayka">
  <option value="1">Executive</option>
  <option value="2">Health</option>
  <option value="3">Student</option>
  <option value="0">All</option>
</select>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Type
 <select class="ui dropdown" name="type" id="type">
  <option value="1">Lunch</option>
  <option value="2">Dinner</option>
  <option value="3">Other</option>
</select>
           </div>
           
           
           
           <div class="modal-dialog" style="margin-left:130px;box-shadow: rgba(0,0,0,0.2);">
      <div class="modal-content" style="box-shadow:none;">
         <div class="modal-header">
             <textarea  name="question" id="qu" placeholder="POLL QUESTION" required></textarea>
        </div>
        <div class="modal-body">
        <div id='TextBoxesGroup'>
	<div id="TextBoxDiv1">
    <div class="group" style="margin-bottom:30px;">      
      <input type="text" id='textbox1' required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Option 1</label>
    </div>
      
    <div class="group">      
      <input type="text" id='textbox2' required>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Option 2</label>
    </div>
    </div>
</div>
          
   </div>
   
</div>
</div>
          

           <div align="center" style="margin-left:130px;">
               <button class="ui huge  black button" value='Add OPTION' id='addButton' onclick="addButton()" >ADD OPTION</button>
           <button class="ui huge  black button" value='Remove OPTION' id='removeButton' onclick="removeButton()">REMOVE OPTION</button>
           <button class="ui huge  black button" value='PROCEED' id='getButtonValue' onclick="getButtonValue()">PROCEED</button> <br><br>
           <center>  <button class="ui black button" value='go back' onclick="goBack()">GO BACK</button> <br>
            
             </center>


<div id="p1" style="display: none">
    <form action="SavePoll" method="post" id="hidForm" onsubmit="return checkValid()">
    Zayka                   
    <select name="zayka" id="zaykaf">
        <option value="1">Executive</option>
        <option value="2">Health</option>
        <option value="3">Student</option>
        <option value="0">All</option>
    </select>
  
     
    Type
    <select name="type" id="typef">
        <option value="1">Lunch</option>
        <option value="2">Dinner</option>
        <option value="3">Other</option>
    </select>
  
             QUESTION<input name="que" id="que1"><br/>
             OPTION-1<input type="text" name="option" id="fop1"><br/>
             OPTION-2<input type="text" name="option" id="fop2"><br/>
             OPTION-3<input type="text" name="option" id="fop3" ><br/>
             OPTION-4<input type="text" name="option" id="fop4"><br/>
             OPTION-5<input type="text" name="option" id="fop5"><br/>
             OPTION-6<input type="text" name="option" id="fop6"><br/>
             OPTION-7<input type="text" name="option" id="fop7" ><br/>
             OPTION-8<input type="text" name="option" id="fop8"><br/>
             OPTION-9<input type="text" name="option" id="fop9"><br/>
             OPTION-10<input type="text" name="option" id="fop10"><br/>
              <input type="submit" value="CREATE" id="pollCreate" style="height: 100px">
                           </form>
                  </div>
             
             
             
             
            
        </div>

      </div>
    
    
     
    
<script type="text/javascript">

 function goBack()
 {
     window.location="index.jsp";
 }

    var counter = 3;

    function addButton(){
        
	if(counter>10){
            alert("Only 10 textboxes allowed");
            return false;
	}
        
	var newTextBoxDiv = $(document.createElement('div'))
	     .attr("id", 'TextBoxDiv' + counter);

	newTextBoxDiv.after().html('<div class="group">'+'<input type="text" id="textbox'+counter+'" required>'+'<span class="highlight"></span>'+' <span class="bar"></span>'+'<label>Option '+counter+'</label>'+'</div>');

	newTextBoxDiv.appendTo("#TextBoxesGroup");


	counter++;
     }

     function removeButton () {
	if(counter===2){
          alert("No more textbox to remove");
          return false;
       }

	counter--;

        $("#TextBoxDiv" + counter).remove();

     }

     function getButtonValue() {

//	var msg = '';
//	for(i=1; i<counter; i++){
//   	  msg += "\n Textbox #" + i + " : " + $('#textbox' + i).val();
//	}
//    	  alert(msg);
       var a;
       a = document.getElementById("qu").value;
       document.getElementById("que1").value=a;

	
	for(i=1; i<counter; i++)
        {
   	  document.getElementById("fop"+i).value= $('#textbox' + i).val();
	}
        document.getElementById("zaykaf").value=document.getElementById("zayka").value;
        document.getElementById("typef").value=document.getElementById("type").value;;
        
//        document.getElementById("p1").style.display="block";
//        document.getElementById("p5").style.display="block";
    	 
         document.getElementById("pollCreate").click();
     }
 
  
  $('.ui.dropdown')
  .dropdown()
;

    function checkValid(){
        
        if(document.getElementById("qu").value.trim().length==0)
        {
            alert("Question Can't be left Empty");
            return false;
        }
        for(i=1;i<counter;i++)
        {
            if(document.getElementById("textbox"+i).value.length==0)
            {
                alert("Any of the Option Field is Empty....Fill it or Remove it!!");
                return false;
            }
        }
    }

</script>
 <script>
               <%if(pm!=null){%>
               document.getElementById("zayka").value=<%=pm.getZaykaId() %>;
               document.getElementById("type").value=<%=pm.getTypeId() %>;
               document.getElementById("qu").value="<%=pm.getQue() %>";
               i=1;
               <%for(OptionModel om: pm.getOption()){%>
                    if(i==1 || i==2)
                    document.getElementById("textbox"+i).value="<%=om.getOptionText() %>";
                    else
                    {
                     document.getElementById("addButton").click();
                     document.getElementById("textbox"+i).value="<%=om.getOptionText() %>";
                    }
                   i++;
               <%}%>
               document.getElementById("hidForm").setAttribute("action","SavePoll?opr=edit&pid=<%=pm.getPollId() %>&optcount=<%=pm.getOption().size() %>");
               document.getElementById("getButtonValue").innerHTML="UPDATE POLL";
               document.getElementById("titlePoll").innerHTML="UPDATE POLL";
               <%}%>    
</script>
    </body>
</html>
