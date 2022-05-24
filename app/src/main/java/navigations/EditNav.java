/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.ClientModel;

/**
 *
 * @author jamar
 */
@ManagedBean(name = "editNav")
@SessionScoped
public class EditNav {
    
    public String showHome() {
        return "home";
    }

    public String showDocumentEdit() {
        return "document-edit";
    }

    public String showClientEdit() {
        return "client-edit";
    }

    public String showMechanicEdit() {
        return "mechanic-edit";
    }
    
    public String showCarEdit() {
        return "car-edit";
    }
    
    public String showSiteEdit() {
        return "site-edit";
    }
    
    public String showReplacementEdit() {
        return "replacement-edi";
    }
}
