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
import model.OptionModel;
import model.PollModel;

/**
 *
 * @author rohan
 */
public class PollDao {
    
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    
    public boolean createPoll(PollModel pm,ServletContext context)
    {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="insert into poll(pollque,status,zaykaid,typeid,polltimestamp) values(?,?,?,?,(select current_timestamp from dual))";
            boolean flag=false;
            
            ps=con.prepareStatement(qr);
            ps.setString(1,pm.getQue());
            ps.setString(2,pm.getStatus().charAt(0)+"");
            ps.setInt(3,pm.getZaykaId());
            ps.setInt(4,pm.getTypeId());
            
            if(ps.executeUpdate()>0)
            {
            flag=true;
            qr="insert into options(pollId,optionId,optionText) values((select max(pid) from poll),?,?)";
            ps=con.prepareStatement(qr);
            int i=1;
            
                for(OptionModel om:pm.getOption())
                {
                        ps.setInt(1,i++);
                        ps.setString(2,om.getOptionText());
                            
                        if(ps.executeUpdate()>0)
                            continue;
                        else
                        {
                            flag=false;
                            break;
                        }
                }
            }
           
            return flag;
        } catch (SQLException ex) {
            Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<PollModel> showPolls(PollModel pm,ServletContext context)
    {
        con=(Connection)context.getAttribute("datacon");
        ArrayList<PollModel> alpm=new ArrayList<>();
        String qr=null;
        PollModel pm1=null;
        
        if(pm.getZaykaId()!=0)
        {
            qr="select pid,pollque,date_format(polltimestamp,\"%d %b %Y @ %H:%i \"),status,zaykaid,typeid from poll where status=? and typeId=? and zaykaid in(0,?) order by polltimestamp desc";
            try {
                ps=con.prepareStatement(qr);
                ps.setString(1,pm.getStatus());
                ps.setInt(2,pm.getTypeId());
                ps.setInt(3,pm.getZaykaId());
           
            } catch (SQLException ex) {
                Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else 
        {
            qr="select pid,pollque,date_format(polltimestamp,\"%d %b %Y @ %H:%i \"),status,zaykaid,typeid from poll where status=? and typeId=? order by polltimestamp desc";
            try {
                ps=con.prepareStatement(qr);
                ps.setString(1,pm.getStatus());
                ps.setInt(2,pm.getTypeId());
            } catch (SQLException ex) {
                Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        try {
            rs=ps.executeQuery();
            String qr1="select * from options where pollid=?";
            
            ResultSet rs1=null;
            ArrayList<OptionModel> opal=null;
            OptionModel om=null;
            String qr2="select truncate((votecount/(select sum(votecount) from options where pollid=?))*100,2) from options where pollid=? group by pollid,optionid";
            while(rs.next())
            {
            pm1=new PollModel();
            pm1.setPollId(rs.getInt(1));
            pm1.setQue(rs.getString(2));
            pm1.setTimestamp(rs.getString(3));
            pm1.setStatus(rs.getString(4));
            pm1.setZaykaId(rs.getInt(5));
            pm1.setTypeId(rs.getInt(6));
            ps=con.prepareStatement(qr1);
            
            ps.setInt(1,pm1.getPollId());
            rs1=ps.executeQuery();
            opal=new ArrayList<>();
            int sum=0;
                while(rs1.next())
                {
                    om=new OptionModel();
                    om.setPid(rs1.getInt(1));
                    om.setOptid(rs1.getInt(2));
                    om.setVotecount(rs1.getInt(3));
                    om.setOptionText(rs1.getString(4));
                    sum+=om.getVotecount();
                    opal.add(om);
                    
                }
                
            ps=con.prepareStatement(qr2);
            ps.setInt(1,pm1.getPollId());
            ps.setInt(2,pm1.getPollId());
            
            rs1=ps.executeQuery();
            int j=0;
            while(rs1.next())
            {
                opal.get(j++).setPercentCount(rs1.getFloat(1));
            }
                
            pm1.setOption(opal);
            alpm.add(pm1);
            }
    
            
            return alpm;
        } catch (SQLException ex) {
            Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean deletePoll(int pid, ServletContext context)
    {
         try {
            con=(Connection)context.getAttribute("datacon");
            String qr="delete from options where pollid=?";
            
            ps=con.prepareStatement(qr);
            ps.setInt(1,pid);
            if(ps.executeUpdate()>0){
            qr="delete from poll where pid=?";
            ps=con.prepareStatement(qr);
            ps.setInt(1,pid);
            return(ps.executeUpdate()>0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean canBeMailed(PollModel pm, ServletContext context) 
    {
        try {
            if(pm.getTypeId()==3)
            {
                return true;
            }
            int count=-1;
            con=(Connection)context.getAttribute("datacon");
            String qr="select count(*) from poll where zaykaid=? and typeid=? and status='o'";
            ps=con.prepareStatement(qr);
            ps.setInt(1,pm.getZaykaId());
            ps.setInt(2,pm.getTypeId());
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                count=rs.getInt(1);
            }
            if(count==0)
                return true;
            else 
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateStatus(PollModel pm,ServletContext context) 
    {
        con=(Connection)context.getAttribute("datacon");
        String qr="update poll set status='o' where pid=?";
        try {
            ps=con.prepareStatement(qr);
            ps.setInt(1,pm.getPollId());
            return(ps.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }

    public boolean isVoterValid(String pid, String cid, ServletContext context)
    {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="select * from voterdetail where pid=? and cid=?";
            ps=con.prepareStatement(qr);   
            ps.setString(1,pid);
            ps.setString(2,cid);
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean incVoteCount(String pid, String opt, String cid, ServletContext context)
    {
       con=(Connection)context.getAttribute("datacon");
       String qr="update options set votecount=votecount+1 where pollid=? and optionId=? and (select status from poll where status='o' and pid=?) in('o')";
        try {
            ps=con.prepareStatement(qr);
            ps.setString(1,pid);
            ps.setString(2,opt);
            ps.setString(3,pid);
            if(ps.executeUpdate()>0)
            {
                qr="insert into voterdetail values(?,?)";
                ps=con.prepareStatement(qr);
                ps.setString(1,pid);
                ps.setString(2,cid);
                return (ps.executeUpdate()>0);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      return false;  
    }

    public boolean updatePoll(PollModel pm,int optcount ,ServletContext context) 
    {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="update poll set pollque=?,polltimestamp=(select CURRENT_TIMESTAMP from dual),status=?,zaykaid=?,typeid=? where pid=?";
            boolean flag=false;
            
            ps=con.prepareStatement(qr);
            ps.setString(1,pm.getQue());
            ps.setString(2,pm.getStatus().charAt(0)+"");
            ps.setInt(3,pm.getZaykaId());
            ps.setInt(4,pm.getTypeId());
            ps.setInt(5,pm.getPollId());
            
            if(ps.executeUpdate()>0)
            {
            flag=true;
            qr="update options set optiontext=? where pollid=? and optionid=?";
            String qr1="insert into options(pollid,optionid,optiontext) values(?,?,?)";
            
            int i=1;
            
                for(OptionModel om:pm.getOption())
                {
                        if(i<=optcount){
                        ps=con.prepareStatement(qr);
                        ps.setString(1,om.getOptionText());
                        ps.setInt(2,pm.getPollId());
                        ps.setInt(3,i++);
                        }
                        else
                        {
                          ps=con.prepareStatement(qr1);
                          ps.setInt(1,pm.getPollId());
                          ps.setInt(2,i++);
                          ps.setString(3,om.getOptionText());
                        }
                        if(ps.executeUpdate()>0)
                            continue;
                        else
                        {
                            flag=false;
                            break;
                        }
                }
                qr="delete from options where pollid=? and optionid=?";
                ps=con.prepareStatement(qr);
                while(i<=optcount)
                {
                    ps.setInt(1,pm.getPollId());
                    ps.setInt(2,i++);
                    
                    if(ps.executeUpdate()>0)
                    {
                        continue;
                    }
                    else
                    {
                        flag=false;
                        break;
                    }
                }
            }
           
            return flag;
        } catch (SQLException ex) {
            Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean closePoll(String pid, ServletContext context) {
        try {
            con=(Connection)context.getAttribute("datacon");
            String qr="update poll set status='c' where pid=?";
            
            ps=con.prepareStatement(qr);
            ps.setString(1,pid);
            
            if(ps.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(PollDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

}
