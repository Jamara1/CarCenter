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
@ManagedBean(name = "editNav")
@SessionScoped
public class EditNav {
    
    public String showHome() {
        return "home";
    }

    public String showDocument() {
        return "documents";
    }

    public String showClientEdit() {
        return "client-edit";
    }

    public String showMechanic() {
        return "mechanics";
    }
    
    public String showCar() {
        return "cars";
    }
    
    public String showSite() {
        return "sites";
    }
    
    public String showReplacement() {
        return "replacements";
    }
}
