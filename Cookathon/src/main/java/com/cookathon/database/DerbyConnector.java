package com.cookathon.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DerbyConnector {

	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public DerbyConnector() throws Exception {
            try {

                    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                    connect = DriverManager
                                    .getConnection("jdbc:derby://localhost:8280/cookathon;create=true");
                    PreparedStatement statement = connect
                                    .prepareStatement("SELECT * from USERS");

                    resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                            String user = resultSet.getString("name");
                            String number = resultSet.getString("number");
                            System.out.println("User: " + user);
                            System.out.println("ID: " + number);
                    }
            } catch (Exception e) {
                    throw e;
            } finally {
                    close();
            }

    }

    private void close() {
            try {
                    if (resultSet != null) {
                            resultSet.close();
                    }
                    if (statement != null) {
                            statement.close();
                    }
                    if (connect != null) {
                            connect.close();
                    }
            } catch (Exception e) {

            }
    }

    public static void main(String[] args) throws Exception {
    	DerbyConnector dao = new DerbyConnector();
    }

}
