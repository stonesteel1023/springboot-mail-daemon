package com.demo.javamail.resources;

import java.util.Date;

public class MailResult {

    private String id;
    private String mailAddress;
    private String mailResult;
    private String mailResultMessage;
    private Date createdOn;
    private String createdBy;
    
    public MailResult(String id, String mailAddress, String mailResult, String mailResultMessage, Date createdOn,
	    String createdBy) {
	super();
	this.id = id;
	this.mailAddress = mailAddress;
	this.mailResult = mailResult;
	this.mailResultMessage = mailResultMessage;
	this.createdOn = createdOn;
	this.createdBy = createdBy;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public String getMailResult() {
        return mailResult;
    }
    public void setMailResult(String mailResult) {
        this.mailResult = mailResult;
    }
    public String getMailResultMessage() {
        return mailResultMessage;
    }
    public void setMailResultMessage(String mailResultMessage) {
        this.mailResultMessage = mailResultMessage;
    }
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
	return "MailResult [id=" + id + ", mailAddress=" + mailAddress + ", mailResult=" + mailResult
		+ ", mailResultMessage=" + mailResultMessage + ", createdOn=" + createdOn + ", createdBy=" + createdBy
		+ "]";
    }
    
}
