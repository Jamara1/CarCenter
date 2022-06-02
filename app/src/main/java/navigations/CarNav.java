/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import controllers.CarController;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import models.Car;

/**
 *
 * @author jamar
 */
@Named("carNav")
@ApplicationScoped
public class CarNav {
    
    CarController controller = new CarController();
    
    public String index() {
        return "cars";
    }

    public String show() {
        return "car-show";
    }

    public String create() {
        return "car-create";
    }

    public String post(Car car) throws SQLException {
        controller.store(car);
        
        return "car-index.xhtml?faces-redirect=true";
    }
    
    public String edit(int id) throws SQLException {
        controller.getCar(id);
        
        return "car-index.xhtml?faces-redirect=true";
    }
    
    public String put(Car car) throws SQLException {
        controller.update(car);
        
        return "car-put";
    }
    
    public String setStatus(Car car) throws SQLException {
        controller.isEnable(car);
        
        return "car-index.xhtml?faces-redirect=true";
    }
}
