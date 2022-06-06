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
import models.Car;

/**
 *
 * @author jamar
 */
@Named(value = "carController")
@ViewScoped
public class CarController implements Serializable {

    private ArrayList<Car> listCar = new ArrayList<>();

    /* SQL */
    PreparedStatement ps;
    ResultSet rs;
    ConnectionController connectionDb = new ConnectionController();
    Connection conn;
    String sql;

    public ArrayList<Car> getListCar() {
        return listCar;
    }

    public void setListCar(ArrayList<Car> listCar) {
        this.listCar = listCar;
    }

    /* Methods */
    public ArrayList<Car> getCars(boolean option) throws SQLException {
        listCar = new ArrayList<>();
        if (option) {
            sql = "SELECT * FROM TB_CAR WHERE STATUS = 1 ORDER BY ID_CAR ASC";
        } else {
            sql = "SELECT * FROM TB_CAR ORDER BY ID_CAR ASC";
        }

        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Car c = new Car();
                c.setIndex(i++);
                c.setId(rs.getInt(1));
                c.setIdClient(rs.getInt(2));
                c.setClient(c.relationClient(rs.getInt(2)));
                c.setPlaca(rs.getString(3));
                c.setBrand(rs.getString(4));
                c.setStatus(rs.getBoolean(5));
                c.setCreatedAt(rs.getDate(6));
                c.setUpdatedAt(rs.getDate(7));

                listCar.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listCar;
    }

    /* Methods */
    public ArrayList<Car> getCarClient(int id) throws SQLException {
        sql = "SELECT * FROM TB_CAR WHERE ID_CLIENT = "+ id +" AND STATUS = 1 ORDER BY ID_CAR ASC";

        int i = 1;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Car c = new Car();
                c.setIndex(i++);
                c.setId(rs.getInt(1));
                c.setIdClient(rs.getInt(2));
                c.setClient(c.relationClient(rs.getInt(2)));
                c.setPlaca(rs.getString(3));
                c.setBrand(rs.getString(4));
                c.setStatus(rs.getBoolean(5));
                c.setCreatedAt(rs.getDate(6));
                c.setUpdatedAt(rs.getDate(7));

                listCar.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }

        return listCar;
    }

    public void store(Car car) throws SQLException {
        sql = "INSERT INTO TB_CAR "
                + "(ID_CLIENT, PLACA, BRAND)"
                + " VALUES"
                + "(?, ?, ?)";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, car.getIdClient());
            ps.setString(2, car.getPlaca());
            ps.setString(3, car.getBrand());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void getCar(int id) throws SQLException {
        Car c = null;
        sql = "SELECT * FROM TB_CAR WHERE ID_CAR = " + id;

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Car();
                c.setId(rs.getInt(1));
                c.setIdClient(rs.getInt(2));
                c.setPlaca(rs.getString(3));
                c.setBrand(rs.getString(4));
                c.setCreatedAt(rs.getDate(5));
                c.setUpdatedAt(rs.getDate(6));
            }

            connectionDb.saveData("editCar", c);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void update(Car car) throws SQLException {
        sql = "UPDATE TB_CAR SET ID_CLIENT = ?, PLACA = ?, BRAND = ?,"
                + "UPDATED_AT = CURRENT_TIMESTAMP WHERE ID_CAR = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, car.getIdClient());
            ps.setString(2, car.getPlaca());
            ps.setString(3, car.getBrand());
            ps.setInt(4, car.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }

    public void isEnable(Car car) throws SQLException {
        sql = "UPDATE TB_CAR SET STATUS = ? WHERE ID_CAR = ?";

        try {
            conn = connectionDb.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, !car.isStatus());
            ps.setInt(2, car.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
    }
}
