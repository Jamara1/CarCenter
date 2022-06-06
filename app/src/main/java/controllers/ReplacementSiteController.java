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
import models.ReplacementSite;

/**
 *
 * @author jamar
 */
@Named(value = "replacementSiteController")
@RequestScoped
public class ReplacementSiteController {
    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;
    
    /* Methods */
    public ArrayList<ReplacementSite> getInventories() throws SQLException {
        ArrayList<ReplacementSite> listReplacementSite = new ArrayList<>();

        sql = "SELECT * FROM TB_REPLACEMENT_SITE ORDER BY ID_REPLACEMENT_SITE ASC";

        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ReplacementSite r = new ReplacementSite();
                r.setIndex(i++);
                r.setId(rs.getInt(1));
                r.setIdReplacement(rs.getInt(2));
                r.setReplacement(r.relationReplacement(rs.getInt(2)));
                r.setIdSite(rs.getInt(3));
                r.setSite(r.relationSite(rs.getInt(3)));
                r.setQuantity(rs.getString(4));
                r.setCreatedAt(rs.getDate(5));
                r.setUpdatedAt(rs.getDate(6));

                listReplacementSite.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listReplacementSite;
    }

    public void store(ReplacementSite replacementSite) throws SQLException {

        if (replacementSite == null) {
            return;
        }

        sql = "INSERT INTO TB_REPLACEMENT_SITE "
                + "(ID_REPLACEMENT, ID_SITE, QUANTITY)"
                + " VALUES"
                + "(?, ?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, replacementSite.getIdReplacement());
            ps.setInt(2, replacementSite.getIdSite());
            ps.setString(3, replacementSite.getQuantity());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public ReplacementSite getReplacementSite(int id) throws SQLException {
        ReplacementSite r = null;
        sql = "SELECT * FROM TB_REPLACEMENT_SITE WHERE ID_REPLACEMENT_SITE = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = new ReplacementSite();
                r.setId(rs.getInt(1));
                r.setIdReplacement(rs.getInt(2));
                r.setIdSite(rs.getInt(3));
                r.setQuantity(rs.getString(4));
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
        connectionDb.saveData("editReplacementSite", getReplacementSite(id));
    }

    public void update(ReplacementSite replacementSite) throws SQLException {
        sql = "UPDATE TB_REPLACEMENT_SITE SET ID_REPLACEMENT = ?, ID_SITE = ?, QUANTITY = ?, "
                + "UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_REPLACEMENT_SITE = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, replacementSite.getIdReplacement());
            ps.setInt(2, replacementSite.getIdSite());
            ps.setString(3, replacementSite.getQuantity());
            ps.setInt(4, replacementSite.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
}
