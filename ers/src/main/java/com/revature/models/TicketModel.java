package com.revature.models;

public class TicketModel {
    private int tkId;
    private int tkAmount;
    private String tkDescription;
    private String tkStatus;
    private int tkEmployeeId;


    public TicketModel(){
        tkStatus="Pending";
    }

    public int getTkId() {
        return tkId;
    }
    public void setTkId(int tkId) {
        this.tkId = tkId;
    }
    public int getTkAmount() {
        return tkAmount;
    }
    public void setTkAmount(int tkAmount) {
        this.tkAmount = tkAmount;
    }
    public String getTkDescription() {
        return tkDescription;
    }
    public void setTkDescription(String tkDescription) {
        this.tkDescription = tkDescription;
    }

    public String gettkStatus() {
        return tkStatus;
    }
    public void settkStatus(String tkStatus) {
        this.tkStatus = tkStatus;
    }

    public int getTkEmployeeId() {
        return tkEmployeeId;
    }

    public void setTkEmployeeId(int tkEmployeeId) {
        this.tkEmployeeId = tkEmployeeId;
    }
}
