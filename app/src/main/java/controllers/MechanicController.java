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
import models.MechanicModel;

/**
 *
 * @author jamar
 */
@Named(value = "mechanicController")
@RequestScoped
public class MechanicController {
          
    /* Data */
    private static final ArrayList<MechanicModel> listMechanic = new ArrayList<>();
    private MechanicModel mechanic = new MechanicModel();

    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    /* Getter & Setters */
    public MechanicModel getMechanic() {
        return this.mechanic;
    }

    public void setMechanic(MechanicModel mechanic) {
        this.mechanic = mechanic;
    }

    /* Methods */
    public ArrayList<MechanicModel> getMechanics() throws SQLException {
        listMechanic.clear();
        sql = "SELECT * FROM TB_MECHANIC ORDER BY ID_MECHANIC ASC";
        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MechanicModel m = new MechanicModel();
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

                MechanicController.listMechanic.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return MechanicController.listMechanic;
    }

    public void addMechanic() throws SQLException {

        if (this.mechanic == null) {
            return;
        }

        sql = "INSERT INTO JAMARA.TB_MECHANIC "
                + "(FIRST_NAME, LAST_NAME, FIRST_SURNAME, SECOND_SURNAME, ID_DOCUMENT_TYPE, DOCUMENT_NUMBER, CELLPHONE, ADDRESS, EMAIL)"
                + " VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.mechanic.getFirstName());
            ps.setString(2, this.mechanic.getLastName());
            ps.setString(3, this.mechanic.getFirstSurname());
            ps.setString(4, this.mechanic.getSecondSurname());
            ps.setInt(5, this.mechanic.getIdDocumentType());
            ps.setString(6, this.mechanic.getDocumentNumber());
            ps.setString(7, this.mechanic.getCellphone());
            ps.setString(8, this.mechanic.getAddress());
            ps.setString(9, this.mechanic.getEmail());
            ps.executeUpdate();

            this.mechanic = null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void updateMechanic(MechanicModel mechanic) throws SQLException {

        if (this.mechanic == null) {
            return;
        }

        System.out.println(mechanic.getFullName());

        sql = "UPDATE JAMARA.TB_MECHANIC SET FIRST_NAME = ?, LAST_NAME = ?, "
                + "FIRST_SURNAME = ?, SECOND_SURNAME = ?, ID_DOCUMENT_TYPE = ?, "
                + "DOCUMENT_NUMBER = ?, CELLPHONE = ?, ADDRESS = ?, "
                + "EMAIL = ?, UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_MECHANIC = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(2, mechanic.getFirstName());
            ps.setString(3, mechanic.getLastName());
            ps.setString(4, mechanic.getFirstSurname());
            ps.setString(5, mechanic.getSecondSurname());
            ps.setInt(6, mechanic.getIdDocumentType());
            ps.setString(7, mechanic.getDocumentNumber());
            ps.setString(8, mechanic.getCellphone());
            ps.setString(9, mechanic.getAddress());
            ps.setString(10, mechanic.getEmail());
            ps.setInt(1, mechanic.getId());
            ps.executeUpdate();

            this.mechanic = null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void isMechanicEnable(MechanicModel mechanic) throws SQLException {
        if (mechanic == null) {
            return;
        }

        sql = "UPDATE JAMARA.TB_MECHANIC SET STATUS = ? WHERE ID_MECHANIC = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(2, !mechanic.isStatus());
            ps.setInt(1, mechanic.getId());
            ps.executeUpdate();

            this.mechanic = null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
    
}
