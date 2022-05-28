/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigations;

import controllers.DocumentTypeController;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import models.DocumentType;

/**
 *
 * @author jamar
 */
@Named("documentTypeNav")
@ApplicationScoped
public class DocumentTypeNav {
    
    DocumentTypeController controller = new DocumentTypeController();
    
    public String index() {
        return "documents";
    }

    public String show() {
        return "document-show";
    }

    public String create() {
        return "document-create";
    }

    public String post(DocumentType documentType) throws SQLException {
        controller.store(documentType);
        return "document-type-index.xhtml?faces-redirect=true";
    }
    
    public String edit(int id) throws SQLException {
        controller.getDocumentType(id);
        
        return "document-type-index.xhtml?faces-redirect=true";
    }
    
    public String put(DocumentType documentType) throws SQLException {
        controller.update(documentType);
        
        return "document-put";
    }
    
    public String delete(DocumentType documentType) throws SQLException {
        controller.destroy(documentType);
        
        return "document-type-index.xhtml?faces-redirect=true";
    }
}
