/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import db.ConnectionController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import models.DocumentTypeModel;

/**
 *
 * @author jamar
 */
@Named(value = "documentTypeController")
@RequestScoped
public class DocumentTypeController {

    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    
    private static final ArrayList<DocumentTypeModel> listDocumentType = new ArrayList<>();
    private DocumentTypeModel documentType = new DocumentTypeModel();

    public List<DocumentTypeModel> getListDocumentType() {
        return listDocumentType;
    }

    public ArrayList<DocumentTypeModel> getDocumentsTypes() {
        listDocumentType.clear();
        String sql = "SELECT * FROM TB_DOCUMENT_TYPE";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DocumentTypeModel d = new DocumentTypeModel();
                d.setId(rs.getInt(1));
                d.setTypeName(rs.getString(2));
                d.setCreatedAt(rs.getDate(3));
                d.setUpdatedAt(rs.getDate(4));

                DocumentTypeController.listDocumentType.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return DocumentTypeController.listDocumentType;
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
