package org.postgres;

import java.io.*;
import java.sql.*;
import java.util.Scanner;


public class Postgres {

    public static void main(String[] args) throws SQLException {
        try {
            Scanner in =new Scanner(System.in);
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/hari";
            //String user = System.getenv("MYSQL_DB_USERNAME");
            //String password = System.getenv("MYSQL_DB_PASSWORD");


            Connection connect = DriverManager.getConnection(url,"hari","ponsmahi1");
            if(!connect.equals(false)) {
                System.out.println("connection success");
                Statement statement= connect.createStatement();
                ResultSet resultSet=statement.executeQuery("select * from home");
                while (resultSet.next()){
                    System.out.print(resultSet.getString("name")+"\n");
                }
                System.out.println("enter name to insert");
                String name=in.next();

                statement.executeUpdate("insert into home values('"+name+"')");
                System.out.println("Updated table values:");
                resultSet=statement.executeQuery("select * from home");
                while (resultSet.next()){
                    System.out.print(resultSet.getString("name")+"\n");
                }
                connect.close();
            }
        }
        catch(Exception e){
            System.out.println(e);

        }
    }
}