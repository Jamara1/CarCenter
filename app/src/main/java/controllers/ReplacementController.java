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
import models.Replacement;

/**
 *
 * @author jamar
 */
@Named(value = "replacementController")
@RequestScoped
public class ReplacementController {

    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    /* Methods */
    public ArrayList<Replacement> getReplacements(boolean option) throws SQLException {
        ArrayList<Replacement> listReplacement = new ArrayList<>();

        if (option) {
            sql = "SELECT * FROM TB_REPLACEMENT WHERE STATUS = 1 ORDER BY ID_REPLACEMENT ASC";
        } else {
            sql = "SELECT * FROM TB_REPLACEMENT ORDER BY ID_REPLACEMENT ASC";
        }
        
        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Replacement r = new Replacement();
                r.setIndex(i++);
                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));
                r.setPrice(rs.getString(3));
                r.setStatus(rs.getBoolean(4));
                r.setCreatedAt(rs.getDate(5));
                r.setUpdatedAt(rs.getDate(6));

                listReplacement.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listReplacement;
    }

    public void store(Replacement replacement) throws SQLException {
        sql = "INSERT INTO TB_REPLACEMENT "
                + "(NAME, PRICE)"
                + " VALUES"
                + "(?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, replacement.getName());
            ps.setString(2, replacement.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
    
    public Replacement getReplacement(int id) throws SQLException {
        Replacement r = null;
        sql = "SELECT * FROM TB_REPLACEMENT WHERE ID_REPLACEMENT = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = new Replacement();
                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));
                r.setPrice(rs.getString(3));
                r.setStatus(rs.getBoolean(4));
                r.setCreatedAt(rs.getDate(5));
                r.setUpdatedAt(rs.getDate(6));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return r;
    }
    
    public void edit(int id) throws SQLException {
        connectionDb.saveData("editReplacement", getReplacement(id));
    }

    public void update(Replacement replacement) throws SQLException {
        sql = "UPDATE TB_REPLACEMENT SET NAME = ?, "
                + "UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_REPLACEMENT = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, replacement.getName());
            ps.setInt(2, replacement.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void isEnable(Replacement replacement) throws SQLException {
        sql = "UPDATE TB_REPLACEMENT SET STATUS = ? WHERE ID_REPLACEMENT = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, !replacement.isStatus());
            ps.setInt(2, replacement.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
}
