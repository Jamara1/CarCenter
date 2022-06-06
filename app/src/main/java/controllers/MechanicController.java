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
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import models.Mechanic;

/**
 *
 * @author jamar
 */
@Named(value = "mechanicController")
@RequestScoped
public class MechanicController {
          
    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    /* Methods */
    public ArrayList<Mechanic> getMechanics(boolean option) throws SQLException {
        ArrayList<Mechanic> listMechanic = new ArrayList<>();
        
        if (option) {
            sql = "SELECT * FROM TB_MECHANIC WHERE STATUS = 1 ORDER BY ID_MECHANIC ASC";
        } else {
            sql = "SELECT * FROM TB_MECHANIC ORDER BY ID_MECHANIC ASC";
        }
        
        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Mechanic m = new Mechanic();
                m.setIndex(i++);
                m.setId(rs.getInt(1));
                m.setFirstName(rs.getString(2));
                m.setLastName(rs.getString(3));
                m.setFirstSurname(rs.getString(4));
                m.setSecondSurname(rs.getString(5));
                m.setFullName(m.strFullName(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
                m.setIdDocumentType(rs.getInt(6));
                m.setDocumentNumber(rs.getString(7));
                m.setCellphone(rs.getString(8));
                m.setAddress(rs.getString(9));
                m.setEmail(rs.getString(10));
                m.setStatus(rs.getBoolean(11));
                m.setCreatedAt(rs.getDate(12));
                m.setUpdatedAt(rs.getDate(13));

                listMechanic.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listMechanic;
    }

    public void store(Mechanic mechanic) throws SQLException {
        sql = "INSERT INTO TB_MECHANIC "
                + "(FIRST_NAME, LAST_NAME, FIRST_SURNAME, SECOND_SURNAME, ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, CELLPHONE, ADDRESS, EMAIL)"
                + " VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, mechanic.getFirstName());
            ps.setString(2, mechanic.getLastName());
            ps.setString(3, mechanic.getFirstSurname());
            ps.setString(4, mechanic.getSecondSurname());
            ps.setInt(5, mechanic.getIdDocumentType());
            ps.setString(6, mechanic.getDocumentNumber());
            ps.setString(7, mechanic.getCellphone());
            ps.setString(8, mechanic.getAddress());
            ps.setString(9, mechanic.getEmail());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public Mechanic getMechanic(int id) throws SQLException {
        Mechanic m = null;
        sql = "SELECT * FROM TB_MECHANIC WHERE ID_MECHANIC = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                m = new Mechanic();
                m.setId(rs.getInt(1));
                m.setFirstName(rs.getString(2));
                m.setLastName(rs.getString(3));
                m.setFirstSurname(rs.getString(4));
                m.setSecondSurname(rs.getString(5));
                m.setFullName(m.strFullName(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
                m.setIdDocumentType(rs.getInt(6));
                m.setDocumentNumber(rs.getString(7));
                m.setCellphone(rs.getString(8));
                m.setAddress(rs.getString(9));
                m.setEmail(rs.getString(10));
                m.setStatus(rs.getBoolean(11));
                m.setCreatedAt(rs.getDate(12));
                m.setUpdatedAt(rs.getDate(13));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
        
        return m;
    }
    
    public void edit(int id) throws SQLException {
        connectionDb.saveData("editMechanic", getMechanic(id));
    }

    public void update(Mechanic mechanic) throws SQLException {
        sql = "UPDATE TB_MECHANIC SET FIRST_NAME = ?, LAST_NAME = ?, "
                + "FIRST_SURNAME = ?, SECOND_SURNAME = ?, ID_DOCUMENT_TYPE = ?, "
                + "DOCUMENT_NUMBER = ?, CELLPHONE = ?, ADDRESS = ?, "
                + "EMAIL = ?, UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_MECHANIC = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, mechanic.getFirstName());
            ps.setString(2, mechanic.getLastName());
            ps.setString(3, mechanic.getFirstSurname());
            ps.setString(4, mechanic.getSecondSurname());
            ps.setInt(5, mechanic.getIdDocumentType());
            ps.setString(6, mechanic.getDocumentNumber());
            ps.setString(7, mechanic.getCellphone());
            ps.setString(8, mechanic.getAddress());
            ps.setString(9, mechanic.getEmail());
            ps.setInt(10, mechanic.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void isEnable(Mechanic mechanic) throws SQLException {
        sql = "UPDATE TB_MECHANIC SET STATUS = ? WHERE ID_MECHANIC = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, !mechanic.isStatus());
            ps.setInt(2, mechanic.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
}
