/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import controllers.BillController;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import models.Bill;

/**
 *
 * @author jamar
 */
@Named("billNav")
@ApplicationScoped
public class BillNav {
    
    BillController controller = new BillController();
    
    public String index() {
        return "bills";
    }

    public String show() {
        return "bill-show";
    }

    public String createService() {
        return "bill-service-create";
    }
    
    public String createReplacement() {
        return "bill-replacement-create";
    }

    public String post(Bill bill) throws SQLException {
        controller.store(bill);
        return "bill-index.xhtml?faces-redirect=true";
    }
    
    public String edit(Bill bill) {
        
        return "bill-index.xhtml?faces-redirect=true";
    }
    
    public String put(Bill bill) throws SQLException {
        controller.update(bill);
        
        return "bill-put";
    }
}
