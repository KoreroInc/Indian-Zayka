/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.CustomerModel;
import model.PollModel;

/**
 *
 * @author rohan
 */
public class CustomerDao {
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    
    public boolean insertCustomer(CustomerModel cm,ServletContext context)
    {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="insert into customers(name,address,email,mobile,zaykaId,typeId,altMobile) values(?,?,?,?,?,?,?)";
            ps=con.prepareStatement(qr);
            ps.setString(1,cm.getName());
            ps.setString(2,cm.getAddress());
            ps.setString(3,cm.getEmail());
            ps.setString(4,cm.getMobile());
            ps.setInt(5,cm.getZaykaId());
            ps.setInt(6,cm.getTypeId());
            ps.setString(7,cm.getAltMobile());
            
            if (ps.executeUpdate()>0)
            {
                ps.close();
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<CustomerModel> getAllCustomers(ServletContext context)
    {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="select * from customers order by name";
            ps=con.prepareStatement(qr);
            rs=ps.executeQuery();
            
            ArrayList<CustomerModel> alcm=new ArrayList<>();
            CustomerModel cm;
            
            while(rs.next())
            {
                cm=new CustomerModel();
                cm.setId(rs.getInt(1));
                cm.setName(rs.getString(2));
                cm.setAddress(rs.getString(3));
                cm.setEmail(rs.getString(4));
                cm.setMobile(rs.getString(5));
                cm.setZaykaId(rs.getInt(6));
                cm.setTypeId(rs.getInt(7));
                cm.setAltMobile(rs.getString(8));
                
                alcm.add(cm);
                
            }
            return alcm;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean removeCustomer(String id,ServletContext context)
    {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="delete from customers where id=?";
            ps=con.prepareStatement(qr);
            ps.setString(1,id);
            return(ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateCustomer(CustomerModel cm, ServletContext context)
    {
       try {
            con=(Connection)context.getAttribute("datacon");
            String qr="update customers set name=?,address=?,email=?,mobile=?,zaykaId=?,typeid=?,altmobile=? where id=?";
            ps=con.prepareStatement(qr);
            ps.setString(1,cm.getName());
            ps.setString(2,cm.getAddress());
            ps.setString(3,cm.getEmail());
            ps.setString(4,cm.getMobile());
            ps.setInt(5,cm.getZaykaId());
            ps.setInt(6,cm.getTypeId());
            ps.setString(7,cm.getAltMobile());
            ps.setInt(8,cm.getId());
            System.out.println("======"+ps.executeUpdate());
            return(ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }

    public ArrayList<CustomerModel> getCustomersList(PollModel pm, ServletContext context) 
    {
        try {
            ArrayList<CustomerModel> alcm=new ArrayList<>();
            con=(Connection)context.getAttribute("datacon");
            String qr="select id,name,email from customers";
            if(pm.getZaykaId()!=0)
            {
                if(pm.getTypeId()!=3)
                {
                    qr+=" where zaykaid=? and typeid in(?,3)";
                    ps=con.prepareStatement(qr);
                    ps.setInt(1,pm.getZaykaId());
                    ps.setInt(2,pm.getTypeId());
                }
                else 
                {
                    qr+=" where zaykaid=?";
                    ps=con.prepareStatement(qr);
                    ps.setInt(1,pm.getZaykaId());
                    
                }
            }
            
            else
            {
                if(pm.getTypeId()!=3)
                {
                    qr+=" where typeid in(?,3)";
                    ps=con.prepareStatement(qr);
                    ps.setInt(1,pm.getTypeId());
                }
                else
                {
                    ps=con.prepareStatement(qr);
                    
                }
            }
            
            CustomerModel cm=null;
            rs=ps.executeQuery();
            while(rs.next())
            {
              cm=new CustomerModel();
              cm.setId(rs.getInt(1));
              cm.setName(rs.getString(2));
              cm.setEmail(rs.getString(3));
              alcm.add(cm);
            }
           
            return alcm;
            }
        catch (Exception ex) {
           ex.printStackTrace();
        }
        return null;
    }

    public boolean checkMail(String mail, ServletContext context)
    {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="select email from customers where email=?";
            ps=con.prepareStatement(qr);
            ps.setString(1,mail);
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<CustomerModel> fetchCustomers(String zayka, String type, ServletContext context) {
        
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="select * from customers where zaykaid=? and typeid=?";
            ps=con.prepareStatement(qr);
            ps.setString(1,zayka);
            ps.setString(2, type);
            rs=ps.executeQuery();
            
            ArrayList<CustomerModel> alcm=new ArrayList<>();
            CustomerModel cm;
            
            while(rs.next())
            {
                cm=new CustomerModel();
                cm.setId(rs.getInt(1));
                cm.setName(rs.getString(2));
                cm.setAddress(rs.getString(3));
                cm.setEmail(rs.getString(4));
                cm.setMobile(rs.getString(5));
                cm.setZaykaId(rs.getInt(6));
                cm.setTypeId(rs.getInt(7));
                cm.setAltMobile(rs.getString(8));
                
                alcm.add(cm);
                
            }
            return alcm;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
