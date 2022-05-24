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

    /* Data */
    private static final ArrayList<DocumentTypeModel> listDocumentsTypes = new ArrayList<>();
    private DocumentTypeModel documentType = new DocumentTypeModel();

    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    /* Getter & Setters */
    public DocumentTypeModel getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(DocumentTypeModel documentType) {
        this.documentType = documentType;
    }

    /* Methods */
    public ArrayList<DocumentTypeModel> getDocumentTypes() throws SQLException {
        listDocumentsTypes.clear();
        sql = "SELECT * FROM TB_DOCUMENT_TYPE ORDER BY ID_DOCUMENT_TYPE ASC";
        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DocumentTypeModel d = new DocumentTypeModel();
                d.setIndex(i++);
                d.setId(rs.getInt(1));
                d.setTypeName(rs.getString(2));
                d.setCreatedAt(rs.getDate(3));
                d.setUpdatedAt(rs.getDate(4));

                DocumentTypeController.listDocumentsTypes.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return DocumentTypeController.listDocumentsTypes;
    }

    public void addDocumentType() throws SQLException {

        if (this.documentType == null) {
            return;
        }

        sql = "INSERT INTO JAMARA.TB_DOCUMENT_TYPE "
                + "(NAME)"
                + " VALUES"
                + "(?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.documentType.getTypeName());
            ps.executeUpdate();

            this.documentType = null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void updateDocumentType(DocumentTypeModel documentType) throws SQLException {

        if (this.documentType == null) {
            return;
        }

        sql = "UPDATE JAMARA.TB_DOCUMENT_TYPE SET TYPE_NAME = ?,"
                + " UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_DOCUMENT_TYPE = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(2, documentType.getTypeName());
            ps.setInt(1, documentType.getId());
            ps.executeUpdate();

            this.documentType = null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void isDocumentTypeEnable(DocumentTypeModel documentType) throws SQLException {
        if (documentType == null) {
            return;
        }

//        sql = "UPDATE JAMARA.TB_DOCUMENT_TYPE SET STATUS = ? WHERE ID_DOCUMENT_TYPE = ?";
//
//        try {
//            conn = connectionDb.getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setBoolean(2, !documentType.isStatus());
//            ps.setInt(1, documentType.getId());
//            ps.executeUpdate();
//
//            this.documentType = null;
//        } catch (SQLException e) {
//            System.out.println(e);
//        } finally {
//            conn.close();
//        }
    }
    
}
