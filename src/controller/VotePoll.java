/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PollDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rohan
 */
public class VotePoll extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            HttpSession session=request.getSession();
            ServletContext context=getServletContext();
            String opt[]=request.getParameterValues("option");
            String optId=opt[0].substring(opt[0].indexOf("$")+1);
            String optText=opt[0].substring(0,opt[0].indexOf("$"));
            String pid=request.getParameter("pid");
            String cid=request.getParameter("cid");
            
            PollDao pd=new PollDao();
            if(pd.isVoterValid(pid,cid,context))
            {
                if(pd.incVoteCount(pid,optId,cid,context))
                {
                    session.setAttribute("msg","<h1>You Have Voted On "+optText+"</h1><br><h1> Thanks For Voting Poll... :)</h1>");
                    response.sendRedirect("Success.jsp");
                }
                   
                else
                {
                    session.setAttribute("msg","Poll Has Been Closed Now...!!!");
                    response.sendRedirect("Failure.jsp");
                }
                   
            }
            else
            { 
                session.setAttribute("msg","You Have Already Voted...!!!");
                response.sendRedirect("Failure.jsp");
               
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
