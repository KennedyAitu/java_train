package com.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.company.Train.statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int answer;
            System.out.print("Hello! This is a sales department!\n" +
                    "1. Book Ticket\n" +
                    "2. Info \n");
            answer = scanner.nextInt();

            switch(answer) {
                case 1:
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM traininfo");
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(2) + ". Direction: " +
                                resultSet.getString(3) + " Time: " +
                                resultSet.getString(4) + " Class: " +
                                resultSet.getString(5));
                    }
                    int ans1 = scanner.nextInt();
                    if(ans1 == 1) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        statement.executeUpdate("INSERT INTO pricelist (idPriceList, Directions1, Data1, Class1) VALUES ('1', 'NQZ -> ALA', '12:20:00', 'Talgo')");
                    }
                    else if(ans1 == 2) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        statement.executeUpdate("INSERT INTO pricelist (idPriceList, Directions1, Data1, Class1) VALUES ('1', 'NQZ -> CIT', '17:30:00', 'Talgo')");
                    }
                    else if(ans1 == 3) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        statement.executeUpdate("INSERT INTO pricelist (idPriceList, Directions1, Data1, Class1) VALUES ('1', 'NQZ -> GUW', '00:00:00', 'Talgo')");
                    }
                    else if(ans1 == 4) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        statement.executeUpdate("INSERT INTO pricelist (idPriceList, Directions1, Data1, Class1) VALUES ('1', 'NQZ -> BHX', '07:45:00', 'Talgo')");
                    }
                    System.out.println("Choose car");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    ResultSet resultSet1 = statement.executeQuery("SELECT Lux_idLux, Cupe_idCupe, Plascart_idPlascart FROM car WHERE trains_idtrains=1");
                    while (resultSet1.next()) {
                        System.out.println("1. Lux: " + resultSet1.getString(1) + " 2. Cupe: " +
                                resultSet1.getString(2) + " 3. Plascart: " +
                                resultSet1.getString(3));
                    }
                    int car = scanner.nextInt();
                    System.out.println("Number of seats");
                    if(car == 1) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        ResultSet resultSet2 = statement.executeQuery("SELECT Max(idLux) FROM lux");
                        while (resultSet2.next()) {
                            System.out.println(resultSet2.getString(1) + "/6");
                        }
                        statement.executeUpdate("Update pricelist set Cars1 = 'Lux' where idPriceList = 1");
                        statement.executeUpdate("Update pricelist set Price = '20000' where idPriceList = 1");
                    }
                    else if(car == 2) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        ResultSet resultSet2 = statement.executeQuery("SELECT Max(idCupe) FROM cupe");
                        while (resultSet2.next()) {
                            System.out.println(resultSet2.getString(1) + "/10");
                        }
                        statement.executeUpdate("Update pricelist set Cars1 = 'Cupe' where idPriceList = 1");
                        statement.executeUpdate("Update pricelist set Price = '15000' where idPriceList = 1");
                    }
                    else if(car == 3) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        ResultSet resultSet2 = statement.executeQuery("SELECT Max(idPlascart) FROM plascart");
                        while (resultSet2.next()) {
                            System.out.println(resultSet2.getString(1) + "/15");
                        }
                        statement.executeUpdate("Update pricelist set Cars1 = 'Plascart' where idPriceList = 1");
                        statement.executeUpdate("Update pricelist set Price = '10000' where idPriceList = 1");
                    }
                    System.out.println("What is your name?");
                    String name = scanner.next();
                    System.out.println("What is your surname?");
                    String surname = scanner.next();
                    System.out.println("What is your id?");
                    String id = scanner.next();
                    System.out.println("What is your gender?");
                    String gender = scanner.next();
                    System.out.println("How old are you?");
                    int age = scanner.nextInt();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    statement.executeUpdate("Insert into passengers(Name, Surname, ID, Gender, Age) values ('" + name + "','" + surname + "','" + id + "','" + gender + "'," + age + ")");
                    statement.executeUpdate("Update pricelist set Name1 = ('"+ name +"') where idPriceList=1");
                    statement.executeUpdate("Update pricelist set Surname1 = ('" + surname + "') where idPriceList=1");
                    statement.executeUpdate("Update pricelist set ID1 = ('" + id + "') where idPriceList=1");
                    statement.executeUpdate("Update pricelist set Gender1 = ('" + gender + "') where idPriceList=1");
                    statement.executeUpdate("Update pricelist set Place1 = ('" + id + "') where idPriceList=1");


                        break;
                case 2:
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    ResultSet resultSet3 = statement.executeQuery("SELECT * FROM pricelist");
                    while (resultSet3.next()) {
                        System.out.println(" Price: " + resultSet3.getString(5) + "\n Name: " + resultSet3.getString(6) + "\n Surname: " + resultSet3.getString(7) + "\n ID: " +
                                resultSet3.getString(8) + "\n Gender: " + resultSet3.getString(9) +
                                "\n Route: " + resultSet3.getString(10) + "\n Time: " + resultSet3.getString(11) +
                                "\n Class: " + resultSet3.getString(12) + "\n Car: " + resultSet3.getString(13) +
                                "\n Place: " + resultSet3.getString(14));

                    }
                    System.out.println(" ");
                    break;

                default:
                    System.out.print("Error function");
                    break;
            }
        }
    }
}

