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
import models.Site;

/**
 *
 * @author jamar
 */
@Named(value = "siteController")
@RequestScoped
public class SiteController {
    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    /* Methods */
    public ArrayList<Site> getSites(boolean option) throws SQLException {
        ArrayList<Site> listSite = new ArrayList<>();
        
        if (option) {
            sql = "SELECT * FROM TB_SITE WHERE STATUS = 1 ORDER BY ID_SITE ASC";
        } else {
            sql = "SELECT * FROM TB_SITE ORDER BY ID_SITE ASC";
        }
        
        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Site s = new Site();
                s.setIndex(i++);
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setStatus(rs.getBoolean(3));
                s.setCreatedAt(rs.getDate(4));
                s.setUpdatedAt(rs.getDate(5));

                listSite.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listSite;
    }

    public void store(Site site) throws SQLException {

        if (site.getName() == null) {
            return;
        }

        sql = "INSERT INTO TB_SITE "
                + "(NAME)"
                + " VALUES"
                + "(?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, site.getName());
            ps.executeUpdate();

            site.setModelNull();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
    
    public Site getSite(int id) throws SQLException {
        Site s = null;
        sql = "SELECT * FROM TB_SITE WHERE ID_SITE = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                s = new Site();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setStatus(rs.getBoolean(3));
                s.setCreatedAt(rs.getDate(4));
                s.setUpdatedAt(rs.getDate(5));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return s;
    }

    public void update(Site site) throws SQLException {

        if (site == null) {
            return;
        }

        sql = "UPDATE TB_SITE SET TYPE_NAME = ?,"
                + " UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_SITE = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(2, site.getName());
            ps.setInt(1, site.getId());
            ps.executeUpdate();

            site.setModelNull();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void isEnable(Site site) throws SQLException {
        sql = "UPDATE TB_SITE SET STATUS = ? WHERE ID_SITE = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, !site.isStatus());
            ps.setInt(2, site.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
}
