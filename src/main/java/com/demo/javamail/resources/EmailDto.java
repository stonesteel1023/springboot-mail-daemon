package com.demo.javamail.resources;

public class EmailDto {

    private String id;
    private String name;
    //private String receiverName;
    private String receiverEmail;
    private String subject;
    private String message;
    private String createdOn;
    private String createdBy;
    private String mailStatus;

    public EmailDto() {}

    public EmailDto(String id, String name, String receiverEmail, String subject, String message, String createdOn, String createdBy) {
	super();
	this.id = id;
	this.name = name;
	this.receiverEmail = receiverEmail;
	this.subject = subject;
	this.message = message;
	this.createdOn = createdOn;
	this.createdBy = createdBy;
    }

    public EmailDto(String id, String name, String mailStatus, String receiverEmail, String subject, String message, String createdOn, String createdBy) {
	super();
	this.id = id;
	this.name = name;
	this.mailStatus = mailStatus;
	this.receiverEmail = receiverEmail;
	this.subject = subject;
	this.message = message;
	this.createdOn = createdOn;
	this.createdBy = createdBy;
    }

    public String getId() {
	return id;
    }
    public void setId(String id) {
	this.id = id;
    }
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }
    //    public String getReceiverName() {
    //        return receiverName;
    //    }
    //    public void setReceiverName(String receiverName) {
    //        this.receiverName = receiverName;
    //    }
    public String getReceiverEmail() {
	return receiverEmail;
    }
    public void setReceiverEmail(String receiverEmail) {
	this.receiverEmail = receiverEmail;
    }
    public String getSubject() {
	return subject;
    }
    public void setSubject(String subject) {
	this.subject = subject;
    }
    public String getMessage() {
	return message;
    }
    public void setMessage(String message) {
	this.message = message;
    }

    public String getCreatedOn() {
	return createdOn;
    }
    public void setCreatedOn(String createdOn) {
	this.createdOn = createdOn;
    }
    public String getCreatedBy() {
	return createdBy;
    }
    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    public String getMailStatus() {
	return mailStatus;
    }
    public void setMailStatus(String mailStatus) {
	this.mailStatus = mailStatus;
    }

    @Override
    public String toString() {
	return "EmailDto [id=" + id + ", name=" + name + ", receiverEmail=" + receiverEmail + ", subject=" + subject
		+ ", message=" + message + ", mail_status =" + mailStatus+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + "]";
    }

}
