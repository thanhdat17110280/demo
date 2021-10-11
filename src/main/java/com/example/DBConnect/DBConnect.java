package com.example.DBConnect;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
//    public static void main(String[] args){
//        SQLServerDataSource ds = new SQLServerDataSource();
//        ds.setUser("sa");
//        ds.setPassword("123");
//        ds.setServerName("DESKTOP-08U6G7C\\SQLEXPRESS");
//        ds.setPortNumber(1433);
//        ds.setDatabaseName("BanHang");
//        try(Connection conn = ds.getConnection()){
//            System.out.println("success");
//            System.out.println(conn.getMetaData());
//
//        } catch (SQLServerException throwables) {
//            throwables.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }
     String url = "jdbc:sqlserver://DESKTOP-08U6G7C\\SQLEXPRESS:1433;database=BanHang";
    private final String userID = "sa";
    private final String instance = "";
    private final String password = "123";

    public Connection getConnection()throws Exception{
        if (instance==null || instance.trim().isEmpty() )
            url = "jdbc:sqlserver://DESKTOP-08U6G7C\\SQLEXPRESS:1433;database=BanHang";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try{
            System.out.println(new DBConnect().getConnection());
        }catch (Exception e){

        }
    }



}
