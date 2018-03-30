/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailmodule;

/**
 *
 * @author rohan
 */
import java.util.ArrayList;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
import model.CustomerModel;
import model.OptionModel;
import model.PollModel;
class Mailer{  
    public static void send(String from,String password,ArrayList<CustomerModel> alcm,String sub,PollModel pm){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getInstance(props,    
           new javax.mail.Authenticator() {    
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
          
           
           int i=0;
           for(CustomerModel cm:alcm)
           {
           MimeMessage message = new MimeMessage(session);    
           message.setSubject(sub);
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(cm.getEmail()));    
           
          
           String options="";
           for(OptionModel opt:pm.getOption())
           {
//               options+="<input type=\"radio\" name=\"option\" value=\""+opt.getOptionText()+"$"+opt.getOptid()+"\">"+opt.getOptionText()+"<br>";
               options+="<input type=\"radio\" name=\"option\" value=\""+opt.getOptionText()+"$"+opt.getOptid()+"\">"+opt.getOptionText()+"<br>"+
                        "<br><div style=\"height: 10px;\">&nbsp;</div>";
           }
          //message.setText(msg); 
//           message.setContent(
//                    "Dear "+cm.getName()+" "+"<br><br>"+
//                    pm.getQue()+"<br><br>"+
//                    "<form id=\"voteform\" action=\"http://192.168.1.100:8080/IndianZayka/VotePoll\">"+
//                    options +
//                   
//                    "<input type=\"text\" name=\"pid\"  value=\""+pm.getPollId()+"\" style=\"display:none\">"+
//                    "<input type=\"text\" name=\"cid\"  value=\""+cm.getId()+"\" style=\"display:none\">"+
//                    "<input type=\"submit\" value=\"Vote\">"+
//                    "</form>"
//                
//                   
//                    ,"text/html"
//             
//           );
           
           message.setContent(""+
                   
    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"+
""+
"<html xmlns=\"http://www.w3.org/1999/xhtml\">"+
"<head>"+
"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"+
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
"	<title>mail</title>"+
"	<style type=\"text/css\">"+
""+
"		#outlook a {padding:0;}"+
"		body{width:100% !important; -webkit-text-size-adjust:100%; -ms-text-size-adjust:100%; margin:0; padding:0;}"+
"		.ExternalClass {width:100%;}"+
"		.ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div {line-height: 100%;}"+
"		#backgroundTable {margin:0; padding:0; width:100% !important; line-height: 100% !important;}"+
"		img {outline:none; text-decoration:none; -ms-interpolation-mode: bicubic;}"+
"		a img {border:none;display:inline-block;}"+
"		.image_fix {display:block;}"+
"		"+
"		h1, h2, h3, h4, h5, h6 {color: black !important;}"+
""+
"		h1 a, h2 a, h3 a, h4 a, h5 a, h6 a {color: blue !important;}"+
""+
"		h1 a:active, h2 a:active,  h3 a:active, h4 a:active, h5 a:active, h6 a:active {"+
"			color: red !important; "+
"		}"+
""+
"		h1 a:visited, h2 a:visited,  h3 a:visited, h4 a:visited, h5 a:visited, h6 a:visited {"+
"			color: purple !important; "+
"		}"+
""+
"		table td {border-collapse: collapse;}"+
""+
"		table { border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt; }"+
""+
"		a {color: #000;}"+
""+
"		@media only screen and (max-device-width: 480px) {"+
""+
"			a[href^=\"tel\"], a[href^=\"sms\"] {"+
"				text-decoration: none;"+
"				color: black; /* or whatever your want */"+
"				pointer-events: none;"+
"				cursor: default;"+
"			}"+
""+
"			.mobile_link a[href^=\"tel\"], .mobile_link a[href^=\"sms\"] {"+
"				text-decoration: default;"+
"				color: orange !important; /* or whatever your want */"+
"				pointer-events: auto;"+
"				cursor: default;"+
"			}"+
"		}"+
""+
""+
"		@media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {"+
"			a[href^=\"tel\"], a[href^=\"sms\"] {"+
"				text-decoration: none;"+
"				color: blue; /* or whatever your want */"+
"				pointer-events: none;"+
"				cursor: default;"+
"			}"+
""+
"			.mobile_link a[href^=\"tel\"], .mobile_link a[href^=\"sms\"] {"+
"				text-decoration: default;"+
"				color: orange !important;"+
"				pointer-events: auto;"+
"				cursor: default;"+
"			}"+
"		}"+
""+
"		p {"+
"			margin:0;"+
"			color:#555;"+
"			font-family:Helvetica, Arial, sans-serif;"+
"			font-size:16px;"+
"			line-height:160%;"+
"		}"+
"		a.link2{"+
"			text-decoration:none;"+
"			font-family:Helvetica, Arial, sans-serif;"+
"			font-size:16px;"+
"			color:#fff;"+
"			border-radius:4px;"+
"		}"+
"		h2{"+
"			color:#181818;"+
"			font-family:Helvetica, Arial, sans-serif;"+
"			font-size:22px;"+
"			font-weight: normal;"+
"		}"+
""+
"		.bgItem{"+
"			background:#64b5f6;"+
"		}"+
"		.bgBody{"+
"			background:#eeeeee;"+
"		}"+
""+
"	</style>"+
""+
"<script type=\"colorScheme\" class=\"swatch active\">"+
"  {"+
"    \"name\":\"Default\","+
"    \"bgBody\":\"ffffff\","+
"    \"link\":\"f2f2f2\","+
"    \"color\":\"555555\","+
"    \"bgItem\":\"F4A81C\","+
"    \"title\":\"181818\""+
"  }"+
"</script>"+
""+
"</head>"+
"<body style=\"-webkit-text-size-adjust: 100%;-ms-text-size-adjust: 100%;margin: 0;padding: 0;width: 100% !important;\">"+
"	<!-- Wrapper/Container Table: Use a wrapper table to control the width and the background color consistently of your email. Use this approach instead of setting attributes on the body tag. -->"+
"	<table cellpadding=\"0\" width=\"100%\" cellspacing=\"0\" border=\"0\" id=\"backgroundTable\" class=\"bgBody\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;background: #eeeeee;margin: 0;padding: 0;width: 100% !important;line-height: 100% !important;\">"+
"		<tr>"+
"			<td style=\"border-collapse: collapse;\">"+
""+
"				<!-- Tables are the most common way to format your email consistently. Set your table widths inside cells and in most cases reset cellpadding, cellspacing, and border to zero. Use nested tables as a way to space effectively in your message. -->"+
""+
"				<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"100%\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">"+
"					<tr>"+
"						<td class=\"movableContentContainer\" style=\"border-collapse: collapse;\">"+
"							"+
"							<div class=\"movableContent\">"+
"								<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">"+
"									<tr height=\"40\">"+
"										<td width=\"200\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"										<td width=\"200\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"										<td width=\"200\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"									</tr>"+
"									<tr>"+
"										<td width=\"200\" valign=\"top\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"										<td width=\"200\" valign=\"top\" align=\"center\" style=\"border-collapse: collapse;\">"+
"											<div class=\"contentEditableContainer contentTextEditable\">"+
"												<div class=\"contentEditable\">"+
"													<img src=\"https://raw.githack.com/rohanshrimal/indianzaykaimg/master/indianzayka.png\" width=\"255\" height=\"155\" alt=\"Logo\" data-default=\"placeholder\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\">"+
"												</div>"+
"											</div>"+
"										</td>"+
"										<td width=\"200\" valign=\"top\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"									</tr>"+
"									<tr height=\"25\">"+
"										<td width=\"200\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"										<td width=\"200\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"										<td width=\"200\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"									</tr>"+
"								</table>"+
"							</div>"+
""+
"							<div class=\"movableContent\">"+
"								<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">"+
"									<tr>"+
"										<td width=\"100%\" colspan=\"3\" align=\"center\" style=\"padding-bottom: 10px;padding-top: 5px;border-collapse: collapse;\">"+
"											<div class=\"contentEditableContainer contentTextEditable\">"+
"												<div class=\"contentEditable\">"+
"													<h2 style=\"color: black !important;font-family: Helvetica, Arial, sans-serif;font-size: 22px;font-weight: normal;\">Hello, "+cm.getName()+"!<br><br>Your opinion matters to us.</h2>"+
"												</div>"+
"											</div>"+
"										</td>"+
"									</tr>"+
"								</table>"+
"							</div>"+
"							<div class=\"movableContent\" align=\"center\" style=\"text-align:center;\">"+
"								<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">"+
"									<tr>"+
"										<td width=\"100%\" align=\"center\" style=\"border-collapse: collapse;\">"+
"											<div class=\"contentEditableContainer contentImageEditable\" style=\"display:inline;\">"+
"												<div class=\"contentEditable\" style=\"display:inline;\">"+
"													<img src=\"https://raw.githack.com/rohanshrimal/indianzaykaimg/master/yes.gif\" width=\"200\" alt=\"yes\" data-default=\"placeholder\" data-max-width=\"200\" style=\"padding-right: 10px;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\">"+
"												</div>"+
"											</div>"+
"											<div class=\"contentEditableContainer contentImageEditable\" style=\"display:inline;\">"+
"												<div class=\"contentEditable\" style=\"display:inline;\">"+
"													<img src=\"https://raw.githack.com/rohanshrimal/indianzaykaimg/master/no.gif\" width=\"200\" alt=\"no\" data-default=\"placeholder\" data-max-width=\"200\" style=\"padding-left: 10px;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\">"+
"												</div>"+
"											</div>"+
"										</td>"+
"									</tr>"+
"								</table>"+
"							</div>"+
"							<div class=\"movableContent\">"+
"								<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">"+
"									<tr>"+
"										<td width=\"100%\" colspan=\"3\" align=\"center\" style=\"padding-bottom: 10px;padding-top: 5px;border-collapse: collapse;\">"+
"											<div class=\"contentEditableContainer contentTextEditable\">"+
"												<div class=\"contentEditable\">"+
"													<h2 style=\"color: black !important;font-family: Helvetica, Arial, sans-serif;line-height:160%;font-size: 22px;font-weight: normal;\">Please vote on any one of the options provided below.</h2>"+
"												</div>"+
"											</div>"+
"										</td>"+
"									</tr>"+
"								</table>"+
"							</div>"+
""+
"							<div class=\"movableContent\" align=\"center\" style=\"text-align:center;\">"+
"								<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" style=\"border: solid;border-color: #bababa;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">"+
"									<tr>"+
"										<td width=\"100%\" colspan=\"3\" align=\"center\" style=\"padding-bottom: 10px;padding-top: 10px;background-color: #64b5f6;border-collapse: collapse;\">"+
"											<div class=\"contentEditableContainer contentTextEditable\">"+
"												<div class=\"contentEditable\">"+
"													<h2 style=\"color: black !important;font-family: Helvetica, Arial, sans-serif;font-size: 22px;font-weight: normal;\">Today's Poll:</h2>"+
"												</div>"+
"											</div>"+
""+
"										</td>"+
"									</tr>"+
"									<tr>"+
"										<td width=\"50\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
"										<td width=\"500\" align=\"left\" style=\"border-collapse: collapse;\">"+
"											<div class=\"contentEditableContainer contentTextEditable\">"+
"												<div class=\"contentEditable\">"+
"													<div style=\"font-family:Helvetica, Arial, sans-serif;font-size:16px;line-height:160%;color:#181818;font-weight:bold;padding-top: 10px;\">"+pm.getQue()+"</div>"+
"												</div>"+
"											</div>"+
"											<div style=\"height:20px;\">&nbsp;</div>"+
"											<div class=\"contentEditableContainer contentTextEditable\">"+
"												<div class=\"contentEditable\">"+
"													<div style=\"margin:0;"+
"														color:#555;"+
"														font-family:Helvetica, Arial, sans-serif;"+
"														font-size:16px;"+
"														line-height:160%;"+
"													\">"+
                                                                                                            "<form id=\"voteform\" action=\"http://indianzayka.azurewebsites.net/VotePoll\">"+
                   
                    "<input type=\"text\" name=\"pid\"  value=\""+pm.getPollId()+"\" style=\"display:none\">"+
                    "<input type=\"text\" name=\"cid\"  value=\""+cm.getId()+"\" style=\"display:none\">"+
                                                                                                            options+
"														<div align=\"center\" width=\"50\" height=\"70\">"+
"															<div class=\"contentEditableContainer contentTextEditable\">"+
"																<div class=\"contentEditable\">"+
"																<input type=\"submit\" value=\"VOTE\" style=\"background-color: #000;border-radius:4px;height: 40px;width: 140px;color: #fff;border-color: #000\" width=\"200\" height=\"50\">"+
"																</div>"+
"															</div>"+
"														</div></form>"+
"													</div>"+
"												</div>"+
"											</div>"+
""+
""+
"											<div style=\"height:20px;\">&nbsp;</div>"+
"										</td>"+
"										<td width=\"50\" style=\"border-collapse: collapse;\">&nbsp;</td>"+
""+
"									</tr>"+
""+
"								</table>"+
"							</div>"+
"							<div class=\"movableContent\">"+
"								<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"600\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">"+
"									<tr>"+
"										<td width=\"100%\" colspan=\"2\" style=\"padding-top: 65px;border-collapse: collapse;\">"+
"											<hr style=\"height:1px;border:none;color:#333;background-color:#ddd;\">"+
"										</td>"+
"									</tr>"+
"									<tr>"+
"										<td width=\"60%\" height=\"70\" valign=\"middle\" style=\"padding-bottom: 20px;border-collapse: collapse;\">"+
"											<div class=\"contentEditableContainer contentTextEditable\">"+
"												<div class=\"contentEditable\">"+
"													<span style=\"font-size:17px;color:#181818;font-family:Helvetica, Arial, sans-serif;line-height:200%;\">"+
"														Get in touch<br>Indian Zayka : Best Tiffin Service in Indore"+
"													</span>"+
"													<br>"+
"													<span style=\"font-size:11px;color:#555;font-family:Helvetica, Arial, sans-serif;line-height:200%;\">Saket Nagar"+
"														Indore, (M.P.)|  0731- 2566333 or 8989505618</span>"+
"													<br>"+
"								                    <span style=\"font-size:13px;color:#181818;font-family:Helvetica, Arial, sans-serif;line-height:200%;\">"+
"														<a target=\"_blank\" href=\"[FORWARD]\" style=\"text-decoration:none;line-height: 20px;color:#555; font-size:13px;\">support@indianzayka.com</a></span>"+
"													<br>"+
"												</div>"+
"											</div>"+
"										</td>"+
"										<td width=\"40%\" height=\"70\" align=\"right\" valign=\"top\" style=\"padding-bottom: 20px;border-collapse: collapse;\">"+
"											<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">"+
"												<tr>"+
"													<td width=\"57%\" style=\"border-collapse: collapse;\"></td>"+
"													<td valign=\"top\" width=\"34\" style=\"border-collapse: collapse;\">"+
"														<div class=\"contentEditableContainer contentFacebookEditable\" style=\"display:inline;\">"+
"															<div class=\"contentEditable\">"+
"															<a href=\"#fff\" style=\"color: #000;\">"+
"																<img src=\"https://raw.githack.com/rohanshrimal/indianzaykaimg/master/facebook.png\" data-default=\"placeholder\" data-max-width=\"30\" width=\"30\" height=\"30\" alt=\"facebook\" style=\"margin-right: 40x;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;border: none;display: inline-block;\" data-customicon=\"true\"></a>"+
"															</div>"+
"														</div>"+
"													</td>"+
"													<td valign=\"top\" width=\"34\" style=\"border-collapse: collapse;\">"+
"														<div class=\"contentEditableContainer contentTwitterEditable\" style=\"display:inline;\">"+
"															<div class=\"contentEditable\">"+
"																<img src=\"https://raw.githack.com/rohanshrimal/indianzaykaimg/master/email.png\" data-default=\"placeholder\" data-max-width=\"30\" width=\"30\" height=\"30\" alt=\"twitter\" style=\"margin-right: 40x;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\" data-customicon=\"true\">"+
"															</div>"+
"														</div>"+
"													</td>"+
"													"+
"												</tr>"+
"											</table>"+
"										</td>"+
"									</tr>"+
"								</table>"+
"							</div>"+
""+
""+
"							"+
""+
"							"+
"						</td>"+
"					</tr>"+
"				</table>"+
"<!-- END BODY -->"+
""+
"			</td>"+
"		</tr>"+
"	</table>"+
"	<!-- End of wrapper table -->"+
"</body>"+
"</html>"+
""
           ,"text/html"
           );
           //send message  
           Transport.send(message);  
               System.out.println("mail sent "+i);
           }
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  

  
}  
public class SendMailSSL{    
    public  int verification(ArrayList<CustomerModel> alcm,PollModel pm) {    
     //from,password,to,subject,message  
//     RegisterServlet forotp=new RegisterServlet();
//     String tomail=forotp.mailcopy;
//     String b=forotp.otpval;
       
        
     Mailer.send("korero.medicaps@gmail.com","QWERTYUIOP",alcm,"Indian Zayka",pm);  
     
     //change from, password and to  
     
    return 0;
    
   }    
    
    
    
   
}    