package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.EmployeeModel;
import com.revature.models.TicketModel;
import com.revature.utils.ConnectionUtil;

public class EmployeeRepo {
    
    public void save(EmployeeModel employee){
        String sql = "insert into employeemodel (email, passw) values (?, ?)";
        if(!emailValidity(employee)){
            try (Connection con = ConnectionUtil.getConnection()) {
                PreparedStatement prstmt = con.prepareStatement(sql);
    
                // replace ? wiith values
                prstmt.setString(1, employee.getEmail());
                prstmt.setString(2, employee.getPassw());
    
                prstmt.execute();
                System.out.println("Success");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        } else {
            System.out.println("Email already used");
        }
    }


    public boolean emailValidity(EmployeeModel employee){
        boolean confirm = false;
        String sql = "select * from employeemodel where email = ?";
        
        try (Connection con = ConnectionUtil.getConnection();){

            PreparedStatement prstmt = con.prepareStatement(sql);
            prstmt.setString(1, employee.getEmail());
            ResultSet rs = prstmt.executeQuery();
            confirm = rs.next();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return confirm;
    }

    public boolean login(EmployeeModel employee){
        boolean confirm = false;
        String sql = "select * from employeemodel where email = ? and passw = ?";
        
        try (Connection con = ConnectionUtil.getConnection();){

            PreparedStatement prstmt = con.prepareStatement(sql);
            prstmt.setString(1, employee.getEmail());
            prstmt.setString(2, employee.getPassw());
            ResultSet rs = prstmt.executeQuery();
            confirm = rs.next();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return confirm;
    }

    public void submitTicket(TicketModel ticket){
        String sql="insert into ticketmodel (tkAmount, tkdescription, tkstatus, tkemployeeid) values (?, ?, ?, ?)";
        if(ticket.getTkAmount() == 0 || ticket.getTkDescription() == null){
            System.out.println("missing amount or description");
        }
        try (Connection con = ConnectionUtil.getConnection();){

            PreparedStatement prstmt = con.prepareStatement(sql);
            prstmt.setInt(1, ticket.getTkAmount());
            prstmt.setString(2, ticket.getTkDescription());
            prstmt.setString(3, ticket.gettkStatus());
            prstmt.setInt(4, ticket.getTkEmployeeId());
            prstmt.execute();
            
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public int retrieveId (EmployeeModel employee) {
        int id = 0;
        String sql ="select employeeid from employeemodel where email = ?";

        try (Connection con = ConnectionUtil.getConnection();){

            PreparedStatement prstmt = con.prepareStatement(sql);
            prstmt.setString(1, employee.getEmail());
            ResultSet rs = prstmt.executeQuery();
            while(rs.next()){
                return rs.getInt("employeeid");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return id;
    }

    public List<TicketModel> getPrevTk(TicketModel ticket){
        List<TicketModel> ticketList = new ArrayList<>();
        String sql ="select * from ticketmodel where tkemployeeid = ?";

        try (Connection con = ConnectionUtil.getConnection()) {
            PreparedStatement prstmt = con.prepareStatement(sql);
            prstmt.setInt(1, ticket.getTkEmployeeId());

            ResultSet rs = prstmt.executeQuery();
            while(rs.next()){
                ticket.setTkAmount(rs.getInt("tkamount"));
                ticket.setTkDescription(rs.getString("tkdescription"));
                ticketList.add(ticket);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ticketList;
    }
}
