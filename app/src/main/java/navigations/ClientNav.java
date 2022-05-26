/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import controllers.ClientController;

import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.Client;

/**
 *
 * @author jamar
 */
@Named("clientNav")
@SessionScoped
public class ClientNav implements Serializable {
    
    ClientController controller = new ClientController();
    
    public String index() {
        return "clients";
    }

    public String show() {
        return "client-show";
    }

    public String create() {
        return "client-create";
    }

    public String post(Client client) throws SQLException {
        controller.store(client);
        return "client-index.xhtml?faces-redirect=true";
    }
    
    public String edit(Client client) {
        client.setFirstName(client.getFirstName());
        
        return "client-index.xhtml?faces-redirect=true";
    }
    
    public String put(Client client) throws SQLException {
        controller.update(client);
        
        return "client-put";
    }
    
    public String setStatus(Client client) throws SQLException {
        controller.isEnable(client);
        
        return "client-index.xhtml?faces-redirect=true";
    }
}
