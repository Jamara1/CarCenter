/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.ConnectionController;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import models.BillReplacementSite;
import models.ReplacementSite;

/**
 *
 * @author jamar
 */
@Named(value = "billReplacementSController")
@ViewScoped
public class BillReplacementSiteController implements Serializable {

    private ArrayList<ReplacementSite> listReplacementSite;
    private static ArrayList<BillReplacementSite> listReplacementAdd = new ArrayList<>();
    private BillReplacementSite billReplacementSite = new BillReplacementSite();
    private String quantity;
    private String price;
    private int subtotal;

    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    public ArrayList<ReplacementSite> getListReplacementSite() {
        return listReplacementSite;
    }

    public void setListReplacementSite(ArrayList<ReplacementSite> listReplacementSite) {
        this.listReplacementSite = listReplacementSite;
    }

    public ArrayList<BillReplacementSite> getListReplacementAdd() {
        return listReplacementAdd;
    }

    public void setListReplacementAdd(ArrayList<BillReplacementSite> listReplacementAdd) {
        this.listReplacementAdd = listReplacementAdd;
    }

    public BillReplacementSite getBillReplacementSite() {
        return billReplacementSite;
    }

    public void setBillReplacementSite(BillReplacementSite billReplacementSite) {
        this.billReplacementSite = billReplacementSite;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public void getReplacementSite(int idSite) throws SQLException {
        listReplacementSite = new ArrayList<>();
        ReplacementSite r = null;

        sql = "SELECT ID_REPLACEMENT, ID_SITE, SUM(QUANTITY) "
                + "FROM TB_REPLACEMENT_SITE WHERE ID_SITE = " + idSite
                + "GROUP BY ID_REPLACEMENT, ID_SITE";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = new ReplacementSite();
                r.setIdReplacement(rs.getInt(1));
                r.setReplacement(r.relationReplacement(rs.getInt(1)));
                r.setIdSite(rs.getInt(2));
                r.setSite(r.relationSite(rs.getInt(2)));
                r.setQuantity(rs.getString(3));

                listReplacementSite.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void updateQuantity(int id) {
        for (ReplacementSite replacementSite : listReplacementSite) {
            if (replacementSite.getIdReplacement() == id) {
                quantity = replacementSite.getQuantity();
                price = replacementSite.getReplacement().getPrice();
            }
        }
    }

    public void addBillReplacementSite() throws SQLException {

        this.billReplacementSite.setSubtotal(Integer.parseInt(this.billReplacementSite.getQuantity()) * Integer.parseInt(price));

        for (int i = 0; i < this.listReplacementAdd.size() + 2; i++) {
            this.billReplacementSite.setReplacement(
                    this.billReplacementSite.relationReplacement(this.billReplacementSite.getIdReplacement())
            );
            
            this.billReplacementSite.setSite(
                    this.billReplacementSite.relationSite(this.billReplacementSite.getIdSite())
            );
            
            subtotal = this.billReplacementSite.getSubtotal();
        }
        
        this.listReplacementAdd.add(this.billReplacementSite);
    }

    public void destroy(BillReplacementSite billReplacementSite) {
        this.listReplacementAdd.remove(billReplacementSite);
    }

    public boolean duplicate(BillReplacementSite billReplacementSite) {
        for (BillReplacementSite billReplacement : this.listReplacementAdd) {
            if (billReplacement.getIdReplacement() == billReplacementSite.getIdReplacement() && billReplacement.getIdSite() == billReplacementSite.getIdSite()) {
                return true;
            }
        }

        return false;
    }
}
