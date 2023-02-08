package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.utils.ConnectionUtil;
import com.revature.models.TicketModel;

public class ManagerRepo {
    
    public String updateStatus(TicketModel ticket){
        String tkUpdate = "";
        String sql = "update ticketmodel set tkstatus = ? where tkid = ?";

        try (Connection con = ConnectionUtil.getConnection()) {
            PreparedStatement prstmt = con.prepareStatement(sql);

            // replace ? wiith values
            
            prstmt.setString(1, (ticket.gettkStatus()));
            prstmt.setInt(2, (ticket.getTkId()));
            prstmt.execute();
            System.out.println("Success");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return tkUpdate;
    }

    public List<TicketModel> getPendingtk(){
        List<TicketModel> pendingtk = new ArrayList<>();
        String sql = "select * from ticketmodel where tkstatus = 'Pending'";
        try (Connection con = ConnectionUtil.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                TicketModel pendingList = new TicketModel();
                pendingList.setTkAmount(rs.getInt(2));
                pendingList.setTkDescription(rs.getString(3));;
                pendingList.settkStatus(rs.getString(4));
                pendingList.setTkId(rs.getInt(1));

                pendingtk.add(pendingList);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return pendingtk;
    }
}
