/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jamar
 */
@Named("homeNav")
@SessionScoped
public class HomeNav implements Serializable {
    
    public String index() {
        return "home";
    }
}
