/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chitu
 */
public class Connect {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:sqlserver://localhost:1433;databasename=BAI1;user=sa;password=123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Connect assest");
            return DriverManager.getConnection(url);
            
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    public ResultSet getDataLoaiSanPham() throws SQLException {
        Connection cnt = Connect.getJDBCConnection();
        String sql = "SELECT * FROM LoaiSanPham";
        PreparedStatement statement = cnt.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        return result;
    }
    public ResultSet getDataSanPham() throws SQLException {
        Connection cnt = Connect.getJDBCConnection();
        String sql = "SELECT * FROM SanPham";
        PreparedStatement statement = cnt.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        return result;
    }
}
