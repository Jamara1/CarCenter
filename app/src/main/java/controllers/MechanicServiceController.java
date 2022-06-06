/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import models.MechanicService;

/**
 *
 * @author jamar
 */
@Named(value = "mechanicSController")
@RequestScoped
public class MechanicServiceController {

    private static List<MechanicService> listMechanic = new ArrayList<>();
    private MechanicService mechanicService = new MechanicService();

    public List<MechanicService> getListMechanic() {
        return listMechanic;
    }

    public void setListMechanic(List<MechanicService> listMechanic) {
        MechanicServiceController.listMechanic = listMechanic;
    }

    public MechanicService getMechanicService() {
        return mechanicService;
    }

    public void setMechanicService(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    public void addMechanic() throws SQLException {
        
        if (this.duplicate(this.mechanicService)) {
            return;
        }
        
        if (this.mechanicService.getIdMechanic() == 0) {
            return;
        }
        
        for (int i = 0; i < MechanicServiceController.listMechanic.size() + 2; i++) {
            this.mechanicService.setMechanic(
                    this.mechanicService.relationMechanic(this.mechanicService.getIdMechanic())
            );
        }

        MechanicServiceController.listMechanic.add(this.mechanicService);
        this.mechanicService = null;
    }

    public void destroy(MechanicService mechanicService) {
        MechanicServiceController.listMechanic.remove(mechanicService);
    }
    
    public boolean duplicate(MechanicService mechanicService) {
        for (MechanicService mechanic : MechanicServiceController.listMechanic) {
            if (mechanic.getIdMechanic() == mechanicService.getIdMechanic()) {
                return true;
            }
        }
        
        return false;
    }
}
