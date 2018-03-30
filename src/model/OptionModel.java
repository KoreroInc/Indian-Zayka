/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rohan
 */
public class OptionModel {
    private int optid,pid,votecount;
    private String optionText;
    private float percentCount;

    

    public float getPercentCount() {
        return percentCount;
    }

    public void setPercentCount(float percentCount) {
        this.percentCount = percentCount;
    }
 
    public int getOptid() {
        return optid;
    }

    public void setOptid(int optid) {
        this.optid = optid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }
    
}
