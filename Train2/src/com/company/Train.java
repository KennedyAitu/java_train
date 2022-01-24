package com.company;

import com.mysql.cj.exceptions.CJOperationNotSupportedException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Train {
    public static final String USER_NAME="root";
    public static final String PASSWORD="root";
    public static final String URL="jdbc:mysql://localhost:3306/newtrainmybd";
    public static Statement statement;
    public static Connection connection;

    static{
        try {
            connection=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException throwables){
            throwables.printStackTrace();
            throw new RuntimeException();
        }

    }
    static {
        try {
            statement=connection.createStatement();
        } catch (SQLException throwables){
            throwables.printStackTrace();;
            throw new RuntimeException();
        }
    }

}