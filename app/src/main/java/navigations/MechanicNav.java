/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import controllers.MechanicController;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import models.Mechanic;

/**
 *
 * @author jamar
 */
@Named("mechanicNav")
@ApplicationScoped
public class MechanicNav {

    MechanicController controller = new MechanicController();

    public String index() {
        return "mechanics";
    }

    public String show() {
        return "mechanic-show";
    }

    public String create() {
        return "mechanic-create";
    }

    public String post(Mechanic mechanic) throws SQLException {
        controller.store(mechanic);
        return "mechanic-index.xhtml?faces-redirect=true";
    }

    public String edit(int id) throws SQLException {
        controller.getMechanic(id);
        
        return "mechanic-edit";
    }
    
    public String put(Mechanic mechanic) throws SQLException {
        controller.update(mechanic);

        return "mechanic-index.xhtml?faces-redirect=true";
    }

    public String setStatus(Mechanic mechanic) throws SQLException {
        controller.isEnable(mechanic);

        return "mechanic-index.xhtml?faces-redirect=true";
    }
}
