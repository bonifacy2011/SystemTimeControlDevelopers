package com.timemanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			final String nameDB = Config.DataBase.nameDB;
			final String user = Config.DataBase.user;
			final String pass = Config.DataBase.pass;
			final String host = Config.DataBase.host;
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + nameDB + "", "" + user + "", "" + pass + "");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void closeDbResources(Connection connection, Statement statement) {
		;
		closeStatement(statement);
		closeConnection(connection);
	}

	public static void closeDbResources(Connection connection, Statement statement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
			}
		}
	}

}
