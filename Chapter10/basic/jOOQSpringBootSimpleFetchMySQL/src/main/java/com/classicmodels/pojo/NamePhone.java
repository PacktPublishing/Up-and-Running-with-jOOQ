package com.classicmodels.pojo;

import java.io.Serializable;

public class NamePhone implements Serializable {

    private static final long serialVersionUID = 1L;
    
    String customerName;
    String phone;  

    @Override
    public String toString() {
        return "NamePhone{" + "customerName=" + customerName 
                + ", customerPhone=" + phone + '}';
    }        
}
