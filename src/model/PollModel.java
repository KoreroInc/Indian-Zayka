/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author rohan
 */
public class PollModel {
    private String que,timestamp,status;
    private int zaykaId,typeId;
    private ArrayList<OptionModel>option;
    private int pollId;

   
    
    public String getZaykaName()
    {
        if(zaykaId==1)
            return "Executive";
        else if(zaykaId==2)
            return "Health";
        else if(zaykaId==3)
            return "Student";
        else if(zaykaId==0)
            return "All";
        else
            return null;
    }
    public String getTypeName()
    {
        if(typeId==1)
            return "Lunch";
        else if(typeId==2)
            return "Dinner";
        else if(typeId==3)
            return "Others";
        else 
            return null;
    }
    public String getStatusName()
    {
        if(status.equalsIgnoreCase("p"))
            return "Pending";
        else if(status.equalsIgnoreCase("o"))
            return "Open";
        else if(status.equals("c"))
            return "Closed";
        else 
            return null;
    }
    public String getQue() {
        return que;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getZaykaId() {
        return zaykaId;
    }

    public void setZaykaId(int zaykaId) {
        this.zaykaId = zaykaId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public ArrayList<OptionModel> getOption() {
        return option;
    }

    public void setOption(ArrayList<OptionModel> option) {
        this.option = option;
    }

   
    
    
}
