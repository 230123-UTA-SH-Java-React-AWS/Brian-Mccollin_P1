package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends UserModel {

    private int EmployeeId;

    private List<TicketModel> ticket;

    

    public EmployeeModel(){
        this.ticket = new ArrayList<>();
    }


    public int getEmployeeId() {
        return EmployeeId;
    }
    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public List<TicketModel> getTicket() {
        return ticket;
    }

    public void setTicket(List<TicketModel> ticket) {
        this.ticket = ticket;
    }

}
