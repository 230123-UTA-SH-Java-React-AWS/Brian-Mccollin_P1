package com.revature.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.revature.models.TicketModel;
import com.revature.repository.ManagerRepo;

public class ManagerService {
    
    ManagerRepo mRepo = new ManagerRepo();
    ObjectMapper mapper = new ObjectMapper();
    TicketModel upTicket;

    public void updateTicket(String tkJson){
        try {
            upTicket = mapper.readValue(tkJson, TicketModel.class);
            mRepo.updateStatus(upTicket);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    public String AllPending(){
        List<TicketModel> pendingList = mRepo.getPendingtk();
        String jString = "";

        try {
            jString = mapper.writeValueAsString(pendingList);
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jString;
    }
}
