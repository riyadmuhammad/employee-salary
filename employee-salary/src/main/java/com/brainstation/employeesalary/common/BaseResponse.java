/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.brainstation.employeesalary.common;

/**
 *
 * @author riad
 */
public class BaseResponse {
    
	protected String message;
	protected int messageType;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }



    
    
    
    
    
}
