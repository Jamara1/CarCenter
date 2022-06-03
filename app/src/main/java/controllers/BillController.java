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
import models.Bill;

/**
 *
 * @author jamar
 */
@Named(value = "billController")
@RequestScoped
public class BillController {

    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    /* Methods */
    public ArrayList<Bill> getBills() throws SQLException {
        ArrayList<Bill> listBill = new ArrayList<>();

        sql = "SELECT * FROM TB_BILL ORDER BY ID_BILL ASC";

        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Bill b = new Bill();
                b.setIndex(i++);
                b.setId(rs.getInt(1));
                b.setIdBillService(rs.getInt(2));
                b.setIdBillReplacementSite(rs.getInt(3));
                b.setStatus(rs.getBoolean(4));
                b.setCreatedAt(rs.getDate(5));
                b.setUpdatedAt(rs.getDate(6));

                listBill.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listBill;
    }

    public void store(Bill bill) throws SQLException {
        sql = "INSERT INTO TB_BILL "
                + "(ID_BILL_SERVICE, ID_BILL_REPLACEMENT_SITE)"
                + " VALUES"
                + "(?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bill.getIdBillService());
            ps.setInt(2, bill.getIdBillReplacementSite());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public Bill getBill(int id) throws SQLException {
        Bill b = null;
        sql = "SELECT * FROM TB_BILL WHERE ID_BILL = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                b = new Bill();
                b.setId(rs.getInt(1));
                b.setIdBillService(rs.getInt(2));
                b.setIdBillReplacementSite(rs.getInt(3));
                b.setStatus(rs.getBoolean(4));
                b.setCreatedAt(rs.getDate(5));
                b.setUpdatedAt(rs.getDate(6));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return b;
    }

    public void update(Bill bill) throws SQLException {

        if (bill == null) {
            return;
        }

        sql = "UPDATE TB_BILL SET ID_BILL_SERVICE = ?, ID_BILL_REPLACEMENT_SITE = ?, "
                + "UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_BILL = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(2, bill.getIdBillService());
            ps.setInt(3, bill.getIdBillReplacementSite());
            ps.setInt(1, bill.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
}
