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
import models.ClientModel;

/**
 *
 * @author jamar
 */
@Named(value = "clientController")
@RequestScoped
public class ClientController {

    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    private static final ArrayList<ClientModel> listClient = new ArrayList<>();
    private ClientModel client = new ClientModel();

    public ArrayList<ClientModel> getClients() throws SQLException {
        listClient.clear();
        sql = "SELECT * FROM TB_CLIENT ORDER BY ID_CLIENT ASC";
        int i = 1;
        
        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

                        
            while (rs.next()) {
                ClientModel c = new ClientModel();
                c.setIndex(i++);
                c.setId(rs.getInt(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setFirstSurname(rs.getString(4));
                c.setSecondSurname(rs.getString(5));
                c.setFullName(c.strFullName(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
                c.setIdDocumentType(rs.getInt(6));
                c.setDocumentNumber(rs.getString(7));
                c.setCellphone(rs.getString(8));
                c.setAddress(rs.getString(9));
                c.setEmail(rs.getString(10));
                c.setStatus(rs.getBoolean(11));
                c.setCreatedAt(rs.getDate(12));
                c.setUpdatedAt(rs.getDate(13));

                ClientController.listClient.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return ClientController.listClient;
    }
    
    public ClientModel getClient() {
        return client;
    }
    
    public void setClient(ClientModel client) {
        this.client = client;
    }
    
    public boolean isClient(ClientModel client) {
        return true;
    }
    
    public void addClient() throws SQLException {
        
        if (this.client == null) {
            return;
        }
        
        sql = "INSERT INTO JAMARA.TB_CLIENT "
                + "(FIRST_NAME, LAST_NAME, FIRST_SURNAME, SECOND_SURNAME, ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, CELLPHONE, ADDRESS, EMAIL)"
                + " VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.client.getFirstName());
            ps.setString(2, this.client.getLastName());
            ps.setString(3, this.client.getFirstSurname());
            ps.setString(4, this.client.getSecondSurname());
            ps.setInt(5, this.client.getIdDocumentType());
            ps.setString(6, this.client.getDocumentNumber());
            ps.setString(7, this.client.getCellphone());
            ps.setString(8, this.client.getAddress());
            ps.setString(9, this.client.getEmail());
            ps.executeUpdate();
            this.client = null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

}