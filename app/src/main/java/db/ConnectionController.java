/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jamar
 */
public class ConnectionController {
    
    Connection conn;
    private final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private final String user = "jamara";
    private final String pass = "123456";
    
    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    this.url,
                    this.user,
                    this.pass
            );
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        return conn;
    }
    
}
