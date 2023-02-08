package com.revature.models;

import java.util.List;

public class ManagerModel extends UserModel{

    private int managerId;

    private List<TicketModel> ticket;
    
    public int getManagerId() {
        return managerId;
    }
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public List<TicketModel> getTicket() {
        return ticket;
    }
}
