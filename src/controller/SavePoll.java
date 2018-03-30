/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PollDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OptionModel;
import model.PollModel;

/**
 *
 * @author rohan
 */
public class SavePoll extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ServletContext context=getServletContext();
            HttpSession session=request.getSession();
            
            String que=request.getParameter("que");
            String option[]=request.getParameterValues("option");
            int zaykaId=Integer.parseInt(request.getParameter("zayka").trim());
            int typeId=Integer.parseInt(request.getParameter("type").trim());
            String opr=request.getParameter("opr");
            
            
            List<String> optlist = Arrays.<String>asList(option);
            ArrayList<String> optal = new ArrayList<>(optlist);
            ArrayList<OptionModel> omal=new ArrayList<>();
            OptionModel om=null;
            
            for(String s:optal)
            {
                if(s.trim().length()!=0)
                {    
                    om=new OptionModel();
                    om.setOptionText(s);
                    omal.add(om);
                }
                else
                    break;
            }
            
            PollModel pm=new PollModel();
            pm.setQue(que);
            pm.setOption(omal);
            pm.setZaykaId(zaykaId);
            pm.setTypeId(typeId);
            pm.setStatus("pending");
            
            PollDao pd=new PollDao();
            if(opr==null)
            {
                if(pd.createPoll(pm,context))
                {   
                    session.setAttribute("msg","Go To Home Page");
                    response.sendRedirect("Success.jsp?param=create");
                }
                else
                {
                    session.setAttribute("msg", "Create Poll Again");
                    response.sendRedirect("Failure.jsp");
                }
            }
            else
            {
                int pid=Integer.parseInt(request.getParameter("pid"));
                int optcount=Integer.parseInt(request.getParameter("optcount"));
                pm.setPollId(pid);
                if(pd.updatePoll(pm,optcount,context))
                    {   
                    session.setAttribute("msg","Go To Home Page");
                    response.sendRedirect("Success.jsp?param=update");
                    }
                else
                 {
                    session.setAttribute("msg", "Go To Home Page");
                    response.sendRedirect("Failure.jsp");
                }
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
