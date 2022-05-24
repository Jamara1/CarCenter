/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jamar
 */
@ManagedBean(name = "createNav")
@SessionScoped
public class CreateNav {
    
    public String showHome() {
        return "home";
    }

    public String showDocumentCreate() {
        return "document-create";
    }

    public String showClientCreate() {
        return "client-create";
    }

    public String showMechanicCreate() {
        return "mechanic-create";
    }
    
    public String showCarCreate() {
        return "car-create";
    }
    
    public String showSiteCreate() {
        return "site-create";
    }
    
    public String showReplacementCreate() {
        return "replacement-create";
    }
}
