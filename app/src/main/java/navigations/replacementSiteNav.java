/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import controllers.ReplacementSiteController;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import models.ReplacementSite;

/**
 *
 * @author jamar
 */
@Named("replacementSiteNav")
@ApplicationScoped
public class ReplacementSiteNav {
    
    ReplacementSiteController controller = new ReplacementSiteController();
    
    public String index() {
        return "inventories";
    }

    public String show() {
        return "inventory-show";
    }

    public String create() {
        return "inventory-create";
    }

    public String post(ReplacementSite replacementSite) throws SQLException {
        controller.store(replacementSite);
        return "inventory-index.xhtml?faces-redirect=true";
    }
    
    public String edit(int id) throws SQLException {
        controller.getReplacementSite(id);
        
        return "inventory-index.xhtml?faces-redirect=true";
    }
    
    public String put(ReplacementSite replacementSite) throws SQLException {
        controller.update(replacementSite);
        
        return "document-put";
    }
    
    public String delete(ReplacementSite replacementSite) throws SQLException {
        
        return "inventory-index.xhtml?faces-redirect=true";
    }
}
