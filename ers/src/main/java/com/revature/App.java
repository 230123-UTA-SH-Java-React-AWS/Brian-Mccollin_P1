package com.revature;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.revature.controller.Controller;
import com.revature.controller.LoginController;
import com.revature.controller.ManagerController;
import com.revature.controller.TicketController;

import com.sun.net.httpserver.HttpServer;

public final class App {
    private App() {
    }


    public static void main(String[] args) throws IOException {
        
        System.out.println("Starting server...");
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/employee", new Controller());
        server.createContext("/employee/login", new LoginController());
        server.createContext("/employee/ticket", new TicketController());
        server.createContext("/manage", new ManagerController());
        server.setExecutor(null);
        server.start();
    }
}
