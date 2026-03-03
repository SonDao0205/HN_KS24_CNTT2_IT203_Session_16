package com.petkingdom.business;

import com.petkingdom.model.Client;
import com.petkingdom.model.Pet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClientManagement {
    public static Set<Client> clients = new LinkedHashSet<>();

    public static boolean isEmpty(){
        return clients.isEmpty();
    }

    public static boolean register(Client client) {
        return clients.add(client);
    }

    public static Client findById(String id){
        for(Client c : clients){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public static void displayClient(Client client){
        System.out.println("+-------------------------------------+");
        System.out.printf("|%-5s|%-15s|%-15s|\n","ID","Name","Phone Number");
        System.out.println("+-------------------------------------+");
        System.out.printf(client.toString());
        System.out.println("+-------------------------------------+");
    }
}
