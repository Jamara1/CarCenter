/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import controllers.ReplacementController;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import models.Replacement;

/**
 *
 * @author jamar
 */
@Named("replacementNav")
@ApplicationScoped
public class ReplacementNav {
    
    ReplacementController controller = new ReplacementController();
    
    public String index() {
        return "replacements";
    }

    public String show() {
        return "replacement-show";
    }

    public String create() {
        return "replacement-create";
    }

    public String post(Replacement replacement) throws SQLException {
        controller.store(replacement);
        
        return "replacement-index.xhtml?faces-redirect=true";
    }
    
    public String edit(int id) throws SQLException {
        controller.getReplacement(id);
        
        return "replacement-index.xhtml?faces-redirect=true";
    }
    
    public String put(Replacement replacement) throws SQLException {
        controller.update(replacement);
        
        return "replacement-put";
    }
    
    public String delete(Replacement replacement) throws SQLException {
        controller.destroy(replacement);
        
        return "replacement-index.xhtml?faces-redirect=true";
    }
}
