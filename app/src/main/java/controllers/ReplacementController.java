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
    public ArrayList<Replacement> getReplacements() throws SQLException {
        ArrayList<Replacement> listReplacement = new ArrayList<>();

        sql = "SELECT * FROM TB_REPLACEMENT ORDER BY ID_REPLACEMENT ASC";
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
                r.setPrice(rs.getInt(3));
                r.setQuantity(rs.getInt(4));
                r.setStatus(rs.getBoolean(5));
                r.setCreatedAt(rs.getDate(6));
                r.setUpdatedAt(rs.getDate(7));

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

        if (replacement == null) {
            return;
        }

        sql = "INSERT INTO TB_REPLACEMENT "
                + "(NAME, PRICE, QUANTITY)"
                + " VALUES"
                + "(?, ?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, replacement.getName());
            ps.setInt(2, replacement.getPrice());
            ps.setInt(3, replacement.getQuantity());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void getReplacement(int id) throws SQLException {
        Replacement d = null;
        sql = "SELECT * FROM TB_REPLACEMENT WHERE ID_REPLACEMENT = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                d = new Replacement();
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
