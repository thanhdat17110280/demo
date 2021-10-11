package com.example.DAO;

import com.example.DBConnect.DBConnect;
import com.example.Model.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<CategoryModel> getAllCategory(){
        List<CategoryModel> list = new ArrayList<CategoryModel>();
        String sql="SELECT * FROM Category";

        try{

            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new CategoryModel(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }

        }catch (Exception e){

        }

        return list;
    }
    public List<CategoryModel> getAllCategoryASC(){
        List<CategoryModel> list = new ArrayList<CategoryModel>();
        String sql="SELECT * FROM dbo.Category ORDER BY CategoryID ASC";

        try{

            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                list.add(new CategoryModel(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }

        }catch (Exception e){

        }

        return list;
    }

}
