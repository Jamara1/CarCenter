/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import models.MechanicService;

/**
 *
 * @author jamar
 */
@Named(value = "mechanicSController")
@RequestScoped
public class MechanicServiceController {
    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    /* Methods */
    public ArrayList<MechanicService> getMechanicServices(boolean option) throws SQLException {
        ArrayList<MechanicService> listMechanicService = new ArrayList<>();

        if (option) {
            sql = "SELECT * FROM TB_MECHANIC_SERVICE WHERE STATUS = 1 ORDER BY ID_MECHANIC_SERVICE ASC";
        } else {
            sql = "SELECT * FROM TB_MECHANIC_SERVICE ORDER BY ID_MECHANIC_SERVICE ASC";
        }
        
        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MechanicService m = new MechanicService();
                m.setIndex(i++);
                m.setId(rs.getInt(1));
                m.setIdMechanic(rs.getInt(2));
                m.setCreatedAt(rs.getDate(3));
                m.setUpdatedAt(rs.getDate(4));

                listMechanicService.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listMechanicService;
    }

    public void store(MechanicService mechanicService) throws SQLException {

        if (mechanicService == null) {
            return;
        }

        sql = "INSERT INTO TB_MECHANIC_SERVICE "
                + "(ID_MECHANIC)"
                + " VALUES"
                + "(?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mechanicService.getIdMechanic());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
    
    public MechanicService getMechanicService(int id) throws SQLException {
        MechanicService r = null;
        sql = "SELECT * FROM TB_MECHANIC_SERVICE WHERE ID_MECHANIC_SERVICE = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = new MechanicService();
                r.setId(rs.getInt(1));
                r.setIdMechanic(rs.getInt(2));
                r.setCreatedAt(rs.getDate(3));
                r.setUpdatedAt(rs.getDate(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return r;
    }
    
    public void edit(int id) throws SQLException {
        connectionDb.saveData("editMechanicService", getMechanicService(id));
    }

    public void update(MechanicService mechanicService) throws SQLException {
        sql = "UPDATE TB_MECHANIC_SERVICE SET ID_MECHANIC = ?, "
                + "UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_MECHANIC_SERVICE = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mechanicService.getIdMechanic());
            ps.setInt(2, mechanicService.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void destroy(MechanicService mechanicService) throws SQLException {
        sql = "DELETE FROM TB_MECHANIC_SERVICE WHERE ID_MECHANIC_SERVICE = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mechanicService.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
}
