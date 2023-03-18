package com.example.alarm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBConn {

    Connection conn;
    public DBConn()
    {
        try {
            // 1) Register the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql:///firsttime", "root", "admin");

        } catch (SQLException e) {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println(" Failed to register driver. Exception code : " + e);
        }
    }

    public void insertval(String mname, String remtim, int doses)
    {

        try {

            Statement stmt = ((java.sql.Connection) conn).createStatement();

            String query = "Insert into demo values('"+mname+"','"+doses+"','"+remtim+"')";
            int a = stmt.executeUpdate(query);
            if (a > 0) {
                System.out.println("Data is inserted");
            } else {
                System.out.println("Insertion failed");
            }
            stmt.close();
            ((java.sql.Connection) conn).close();


        } catch (SQLException e) {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        }
    }

    private ObservableList<demoinfo> list = FXCollections.observableArrayList();
    public ObservableList<demoinfo> getTable()
    {
        //ObservableList<demoinfo> list = FXCollections.observableArrayList();
        try
        {
            PreparedStatement ps = conn.prepareStatement("select * from demo");
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                list.add(new demoinfo(rs.getString("med_name"), rs.getString("remtime"), rs.getInt("doses")));
            }



        }
        catch (SQLException e) {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        }

        return list;

    }

    public demoinfo[] forDisplay()
    {
        demoinfo[] llst = new demoinfo[list.size()];
        try
        {
            PreparedStatement ps = conn.prepareStatement("select * from demo");
            ResultSet rs = ps.executeQuery();
            int i = 0;

            while(rs.next())
            {
                llst[i] = new demoinfo(rs.getString("med_name"), rs.getString("remtime"), rs.getInt("doses"));
                //list.add(new demoinfo(rs.getString("med_name"), rs.getString("remtime"), rs.getInt("doses")));
                i++;
            }



        }
        catch (SQLException e) {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        }

        return llst;
    }



}