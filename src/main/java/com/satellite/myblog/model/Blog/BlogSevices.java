package com.satellite.myblog.model.Blog;

import com.satellite.myblog.model.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BlogSevices extends DBContext<Blog> {

    Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<Blog> selectAll() throws Exception {
        //Init
        ArrayList<Blog> arr = new ArrayList<>();
        String sql = "Select * from `Blog`";
        //Excute
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int a = Integer.parseInt(rs.getString(1));
            String b = rs.getString(2);
            String c = rs.getString(3);
            String d = rs.getString(4);
            String e = rs.getString(5);
            String f = rs.getString(6);
            String g = rs.getString(7);
            String h = rs.getString(8);
            String i = rs.getString(9);
            int j = Integer.parseInt(rs.getString(10));
            float k = Float.parseFloat(rs.getString(11));
            arr.add(new Blog(a, b, c, d, e, f, g, h, i,j,k));
        }
        //Return
        return arr;
    }

    @Override
    public Blog selectById(int id) throws Exception {
        //Init
        Blog blog = null;
        String sql = "Select * from `Blog` where id='" + id + "'";
        //Excute
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            int a = Integer.valueOf(rs.getString(1));
            String b = rs.getString(2);
            String c = rs.getString(3);
            String d = rs.getString(4);
            String e = rs.getString(5);
            String f = rs.getString(6);
            String g = rs.getString(7);
            String h = rs.getString(8);
            String i = rs.getString(9);
            int j = Integer.parseInt(rs.getString(10));
            float k = Float.parseFloat(rs.getString(11));
            blog = new Blog(a, b, c, d, e, f, g, h, i,j,k);
        }
        //Return
        return blog;
    }

    @Override
    public int add(Blog a) throws Exception {
        PreparedStatement stt = connection.prepareStatement("Insert into `Blog`"
                + "(title,description,image,text,createdby,category)"
                + " values (?,?,?,?,?,?)");
        stt.setNString(1, a.getTitle());
        stt.setNString(2, a.getDescription());
        stt.setString(3, a.getImage());
        stt.setNString(4, a.getText());
        stt.setNString(5, a.getCreatedby());
        stt.setNString(6, a.getCategory());
        return stt.executeUpdate();
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "Delete from `Blog` where id = " + id;
        PreparedStatement stt = connection.prepareStatement(sql);
        return stt.executeUpdate();
    }

    @Override
    public int update(Blog a) throws Exception {
        PreparedStatement stt = connection.prepareStatement("Update `Blog` Set "
                + "title=?,description=?,image=?,text=?,createdby=?,category=?,datemodified = current_timestamp "
                + "Where id=?");
        stt.setNString(1, a.getTitle());
        stt.setNString(2, a.getDescription());
        stt.setString(3, a.getImage());
        stt.setNString(4, a.getText());
        stt.setNString(5, a.getCreatedby());
        stt.setNString(6, a.getCategory());
        stt.setInt(7, a.getId());
        return stt.executeUpdate();
    }

    public int updateViewRate(Blog a) throws Exception{
        //Init
        String sql
                = "Update `Blog` Set "
                + "view = '" + a.getView() + "',"
                + "rate = '" + a.getRate() + "',"
                + "datemodified = current_timestamp "
                + "Where id='" + a.getId() + "'";
        //Excute
        Statement statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }

}
