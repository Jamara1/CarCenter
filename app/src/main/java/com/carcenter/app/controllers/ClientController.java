/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.controllers;

import java.util.List;


import com.carcenter.app.models.ClientModel;
import java.util.ArrayList;

/**
 *
 * @author jamar
 */

public class ClientController {
          
    private static List<ClientModel> listClient = new ArrayList<ClientModel>();
    private ClientModel client = new ClientModel();

    public List<ClientModel> getListClient() {
        return listClient;
    }

    public void setListClient(List<ClientModel> listClient) {
        ClientController.listClient = listClient;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
    
    public void addClient() {
       ClientController.listClient.add(this.client);
    }
    
    public void isClient(ClientModel client) {
        ClientController.listClient.remove(client);
    }
}
