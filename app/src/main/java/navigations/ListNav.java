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
@ManagedBean(name = "listNav")
@SessionScoped
public class ListNav {
    
    public String showHome() {
        return "home";
    }

    public String showDocument() {
        return "documents";
    }

    public String showClient() {
        return "clients";
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
