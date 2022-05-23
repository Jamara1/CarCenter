/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.controllers;

import java.util.List;


import com.carcenter.app.models.DocumentTypeModel;
import java.util.ArrayList;

/**
 *
 * @author jamar
 */

public class DocumentTypeController {
          
    private static List<DocumentTypeModel> listDocumentType = new ArrayList<DocumentTypeModel>();
    private DocumentTypeModel documentType = new DocumentTypeModel();

    public List<DocumentTypeModel> getListDocumentType() {
        return listDocumentType;
    }

    public void setListDocumentType(List<DocumentTypeModel> listDocumentType) {
        DocumentTypeController.listDocumentType = listDocumentType;
    }

    public DocumentTypeModel getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeModel documentType) {
        this.documentType = documentType;
    }
    
    public void addDocumentType() {
       DocumentTypeController.listDocumentType.add(this.documentType);
    }
    
    public void isDocumentType(DocumentTypeModel documentType) {
        DocumentTypeController.listDocumentType.remove(documentType);
    }
}
