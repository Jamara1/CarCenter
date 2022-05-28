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
import models.DocumentType;

/**
 *
 * @author jamar
 */
@Named(value = "documentTypeController")
@RequestScoped
public class DocumentTypeController {

    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    /* Methods */
    public ArrayList<DocumentType> getDocumentTypes() throws SQLException {
        ArrayList<DocumentType> listDocumentsTypes = new ArrayList<>();
        
        sql = "SELECT * FROM TB_DOCUMENT_TYPE ORDER BY ID_DOCUMENT_TYPE ASC";
        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DocumentType d = new DocumentType();
                d.setIndex(i++);
                d.setId(rs.getInt(1));
                d.setName(rs.getString(2));
                d.setCreatedAt(rs.getDate(3));
                d.setUpdatedAt(rs.getDate(4));

                listDocumentsTypes.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listDocumentsTypes;
    }

    public void store(DocumentType documentType) throws SQLException {

        if (documentType == null) {
            return;
        }

        sql = "INSERT INTO JAMARA.TB_DOCUMENT_TYPE "
                + "(NAME)"
                + " VALUES"
                + "(?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, documentType.getName());
            ps.executeUpdate();

            documentType.setModelNull();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void getDocumentType(int id) throws SQLException {
        DocumentType d = null;
        sql = "SELECT * FROM JAMARA.TB_DOCUMENT_TYPE WHERE ID_DOCUMENT_TYPE = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                d = new DocumentType();
                d.setId(rs.getInt(1));
                d.setName(rs.getString(2));
                d.setCreatedAt(rs.getDate(3));
                d.setUpdatedAt(rs.getDate(4));
            }

            connectionDb.saveData("editDocument", d);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void update(DocumentType documentType) throws SQLException {
        sql = "UPDATE JAMARA.TB_DOCUMENT_TYPE SET NAME = ?, "
                + "UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_DOCUMENT_TYPE = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, documentType.getName());
            ps.setInt(2, documentType.getId());
            ps.executeUpdate();

            documentType.setModelNull();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void destroy(DocumentType documentType) throws SQLException {
        if (documentType.getId() == 0) {
            return;
        }

        sql = "DELETE FROM JAMARA.TB_DOCUMENT_TYPE WHERE ID_DOCUMENT_TYPE = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, documentType.getId());
            ps.executeUpdate();

            documentType.setModelNull();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
    
}
