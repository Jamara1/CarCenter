/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.controllers;

import java.util.List;


import com.carcenter.app.models.MechanicModel;
import java.util.ArrayList;

/**
 *
 * @author jamar
 */

public class MechanicController {
          
    private static List<MechanicModel> listMechanic = new ArrayList<MechanicModel>();
    private MechanicModel mechanic = new MechanicModel();

    public List<MechanicModel> getListMechanic() {
        return listMechanic;
    }

    public void setListMechanic(List<MechanicModel> listMechanic) {
        MechanicController.listMechanic = listMechanic;
    }

    public MechanicModel getMechanic() {
        return mechanic;
    }

    public void setClient(MechanicModel mechanic) {
        this.mechanic = mechanic;
    }
    
    public void addMechanic() {
       MechanicController.listMechanic.add(this.mechanic);
    }
    
    public void isMechanic(MechanicModel mechanic) {
        MechanicController.listMechanic.remove(mechanic);
    }
}
