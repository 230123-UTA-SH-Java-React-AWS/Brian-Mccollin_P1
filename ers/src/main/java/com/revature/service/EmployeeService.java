package com.revature.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.revature.models.EmployeeModel;
import com.revature.models.TicketModel;
import com.revature.repository.EmployeeRepo;

public class EmployeeService {
    EmployeeRepo repo = new EmployeeRepo();
    ObjectMapper mapper = new ObjectMapper();
    EmployeeModel newEmployee;
    TicketModel newTicket;

    public void saveEmployee(String employJson){

        
        try {
            newEmployee = mapper.readValue(employJson, EmployeeModel.class);
            repo.save(newEmployee);
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

    public boolean employeelogin(String loginString){
        boolean result= false;
        try {
            newEmployee = mapper.readValue(loginString, EmployeeModel.class);
            return repo.login(newEmployee);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    public void newTicket(String newTk){
        
        try {
            newTicket = mapper.readValue(newTk, TicketModel.class);
            repo.submitTicket(newTicket);
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

    public String prevTicket(String employeetk){
        String tkString = "";
        newTicket = new TicketModel();
        
        
        try {
            newTicket = mapper.readValue(employeetk, TicketModel.class);
            List<TicketModel> tkList = repo.getPrevTk(newTicket);
            tkString = mapper.writeValueAsString(tkList);
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
        return tkString;
    }
}
