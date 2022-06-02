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
import models.Client;

/**
 *
 * @author jamar
 */
@Named(value = "clientController")
@RequestScoped
public class ClientController {
    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;
    
    /* Methods */
    public ArrayList<Client> getClients() throws SQLException {
        ArrayList<Client> listClient = new ArrayList();
        sql = "SELECT * FROM TB_CLIENT ORDER BY ID_CLIENT ASC";
        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Client c = new Client();
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

                listClient.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listClient;
    }

    public void store(Client client) throws SQLException {
        sql = "INSERT INTO TB_CLIENT "
                + "(FIRST_NAME, LAST_NAME, FIRST_SURNAME, SECOND_SURNAME, ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, CELLPHONE, ADDRESS, EMAIL)"
                + " VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getFirstSurname());
            ps.setString(4, client.getSecondSurname());
            ps.setInt(5, client.getIdDocumentType());
            ps.setString(6, client.getDocumentNumber());
            ps.setString(7, client.getCellphone());
            ps.setString(8, client.getAddress());
            ps.setString(9, client.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public Client getClient(int id) throws SQLException {
        Client c = null;
        sql = "SELECT * FROM TB_CLIENT WHERE ID_CLIENT = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Client();
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
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
        
        return c;
    }
    
    public void edit(int id) throws SQLException {
        connectionDb.saveData("editClient", getClient(id));
    }

    public void update(Client client) throws SQLException {
        sql = "UPDATE TB_CLIENT SET FIRST_NAME = ?, LAST_NAME = ?, "
                + "FIRST_SURNAME = ?, SECOND_SURNAME = ?, ID_DOCUMENT_TYPE = ?, "
                + "DOCUMENT_NUMBER = ?, CELLPHONE = ?, ADDRESS = ?, "
                + "EMAIL = ?, UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_CLIENT = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getFirstSurname());
            ps.setString(4, client.getSecondSurname());
            ps.setInt(5, client.getIdDocumentType());
            ps.setString(6, client.getDocumentNumber());
            ps.setString(7, client.getCellphone());
            ps.setString(8, client.getAddress());
            ps.setString(9, client.getEmail());
            ps.setInt(10, client.getId());
            ps.executeUpdate();

            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void isEnable(Client client) throws SQLException {
        sql = "UPDATE TB_CLIENT SET STATUS = ? WHERE ID_CLIENT = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, !client.isStatus());
            ps.setInt(2, client.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
}
