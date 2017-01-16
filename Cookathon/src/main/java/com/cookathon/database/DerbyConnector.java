package com.cookathon.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DerbyConnector {

	public static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
	public static final String DB_CONNECTIVITY_URL = "jdbc:derby://localhost:1527/cookathon;create=true";
	public static final String RECEIPE_TABLE_CREATION_STRING = "CREATE TABLE RECEIPES(RECEIPE_ID INT NOT NULL GENERATED "
			+ "ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1), " + "RECEIPE_AUTHOR VARCHAR(20) NOT NULL, "
			+ "RECEIPE_TITLE VARCHAR(20) NOT NULL, " + "RECEIPE_DESCRIPTION VARCHAR(100) NOT NULL, "
			+ "RECEIPE_INGREDIENTS VARCHAR(10000) NOT NULL, " + "RECEIPE_PREPARATION VARCHAR(10000) NOT NULL,"
			+ "CREATED_DATE DATE NOT NULL," + "PRIMARY KEY (RECEIPE_ID))";
	public static final String COMMENT_TABLE_CREATION_STRING = "CREATE TABLE COMMENTS(COMMENT_ID INT NOT NULL GENERATED "
			+ "ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1), " + "COMMENT_MESSAGE VARCHAR(10000) NOT NULL, RECEIPE_ID INT NOT NULL,"
					+ "FOREIGN KEY(\"RECEIPE_ID\") REFERENCES RECEIPES(\"RECEIPE_ID\"),"
					+ "COMMENT_AUTHOR VARCHAR(10000) NOT NULL, "
			+ "PRIMARY KEY(COMMENT_ID))";
	public static final String RECEIPE_TABLE_CONTENTS = "SELECT * FROM RECEIPES";
	public static Connection connect = null;
	public static Statement statement = null;
	public static PreparedStatement ps = null ;
    
	public static boolean createTables() throws Exception {
		try {
			Class.forName(DB_DRIVER).newInstance();
			connect = DriverManager.getConnection(DB_CONNECTIVITY_URL);
			statement = connect.createStatement();
			int resultOfCreatingReceipeTable = statement.executeUpdate(RECEIPE_TABLE_CREATION_STRING);
			System.out.println("Receipe table creation status " + resultOfCreatingReceipeTable);
			int resultOfCreatingCommentsTable = statement.executeUpdate(COMMENT_TABLE_CREATION_STRING);
			System.out.println("Comments table creation status " + resultOfCreatingCommentsTable);
			/*if(resultOfCreatingReceipeTable == 0 && resultOfCreatingCommentsTable == 0){
				return true;
			}*/
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	public static ResultSet executeQuery(String query) throws Exception {
		Class.forName(DB_DRIVER).newInstance();
		connect = DriverManager.getConnection(DB_CONNECTIVITY_URL);
		ps = connect.prepareStatement(query);
		return ps.executeQuery();
	}
	
	public static int executeUpdate(String query) throws Exception {
		Class.forName(DB_DRIVER).newInstance();
		connect = DriverManager.getConnection(DB_CONNECTIVITY_URL);
		statement = connect.createStatement();
		System.out.println("Query is: " + query);
		return statement.executeUpdate(query);
	}

    private static void close() {
            try {
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
    	 ResultSet rs = executeQuery(RECEIPE_TABLE_CONTENTS);
    	 ResultSetMetaData rsmd = rs.getMetaData();
    	 int columnCount = rsmd.getColumnCount();
	    	for (int i = 1; i <= columnCount; i++ ) {
	    	  String name = rsmd.getColumnName(i);
	    	  System.out.println("Column names: "+name);
	    	}
    	//createTables();
    }

}
