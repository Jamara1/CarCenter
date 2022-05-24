/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import java.util.List;


import models.MechanicModel;
import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author jamar
 */
@Named(value = "MechanicController")
@Dependent
public class MechanicController {
          
    private static List<MechanicModel> listMechanic = new ArrayList<>();
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

    public void setMechanic(MechanicModel mechanic) {
        this.mechanic = mechanic;
    }
    
    public void addMechanic() {
       MechanicController.listMechanic.add(this.mechanic);
    }
    
    public void isMechanic(MechanicModel mechanic) {
        MechanicController.listMechanic.remove(mechanic);
    }
}
