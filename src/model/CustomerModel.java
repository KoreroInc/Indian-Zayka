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
public class CustomerModel {
    private int id,zaykaId,typeId;
    private String name,address,email,mobile,altMobile;

    public CustomerModel()
    {
        name="";
        address="";
        email="";
        mobile="";
        altMobile="";
        zaykaId=1;
        typeId=1;
    }
    public String getZaykaName()
    {
        if(zaykaId==1)
            return "Executive";
        else if(zaykaId==2)
            return "Health";
        else if(zaykaId==3)
            return "Student";
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
            return "Both";
        else
            return null;
    }
    
    public String getAltMobile() {
        return altMobile;
    }

    public void setAltMobile(String altMobile) {
        this.altMobile = altMobile;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZaykaId() {
        return zaykaId;
    }

    public void setZaykaId(int zaykaId) {
        this.zaykaId = zaykaId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
}
