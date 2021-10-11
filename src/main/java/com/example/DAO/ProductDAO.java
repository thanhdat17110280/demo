package com.example.DAO;

import com.example.DBConnect.DBConnect;
import com.example.Model.ProductModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ProductModel> getAllProduct(){
        List<ProductModel> list = new ArrayList<ProductModel>();

        String sql = "SELECT * FROM dbo.Product ORDER BY price ASC ";

        try{
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),rs.getInt(8)));
            }
        }catch (Exception e){

        }

        return list;
    }

    public List<ProductModel> getAllProductByCID(String cid){
        List<ProductModel> list = new ArrayList<ProductModel>();

        String sql = "SELECT * FROM dbo.Product WHERE CategoryID = ? ";

        try{
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),rs.getInt(8)));
            }
        }catch (Exception e){

        }

        return list;
    }
    public List<ProductModel> getAllProductByCIDASC (){
        List<ProductModel> list = new ArrayList<ProductModel>();

        String sql = "SELECT * FROM dbo.Product ORDER BY CategoryID ASC  ";

        try{
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),rs.getInt(8)));
            }
        }catch (Exception e){

        }

        return list;
    }
    public ProductModel getProductByID(String id){
        String sql = "SELECT * FROM dbo.Product WHERE ProductID = ?";
        try{
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()){
                return  new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),rs.getInt(8));
            }
        }catch (Exception e){

        }

        return null;
    }

    public List<ProductModel> getTop4Product(){
        List<ProductModel> list = new ArrayList<ProductModel>();

        String sql = "SELECT TOP 4 * FROM dbo.Product ORDER BY ProductID DESC";

        try{
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),rs.getInt(8)));
            }
        }catch (Exception e){

        }

        return list;
    }
    public List<ProductModel> getTop4Amount(){
        List<ProductModel> list = new ArrayList<ProductModel>();

        String sql = "SELECT TOP 4 * FROM dbo.Product ORDER BY Amount DESC";

        try{
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),rs.getInt(8)));
            }
        }catch (Exception e){

        }

        return list;
    }

    public List<ProductModel> getTop1Amount(){
        List<ProductModel> list = new ArrayList<ProductModel>();

        String sql = "SELECT TOP 1 * FROM dbo.Product ORDER BY Amount DESC";

        try{
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),rs.getInt(8)));
            }
        }catch (Exception e){

        }

        return list;
    }


//    public static void main(String[] args) {
//        ProductDAO dao = new ProductDAO();
//        ProductModel list = dao.getProductByID("1");
//        System.out.println(list);
//    }
}

