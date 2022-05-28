/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import controllers.SiteController;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import models.Site;

/**
 *
 * @author jamar
 */
@Named("siteNav")
@ApplicationScoped
public class SiteNav {
    
    SiteController controller = new SiteController();
    
    public String index() {
        return "sites";
    }

    public String show() {
        return "site-show";
    }

    public String create() {
        return "site-create";
    }

    public String post(Site site) throws SQLException {
        controller.store(site);
        return "site-index.xhtml?faces-redirect=true";
    }
    
    public String edit(Site site) {
        site.setName(site.getName());
        
        return "site-index.xhtml?faces-redirect=true";
    }
    
    public String put(Site site) throws SQLException {
        controller.update(site);
        
        return "document-put";
    }
    
    public String delete(Site site) throws SQLException {
        controller.destroy(site);
        
        return "site-index.xhtml?faces-redirect=true";
    }
}
