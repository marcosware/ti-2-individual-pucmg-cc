package dao;

import java.sql.*;

public class DAO {
	private Connection conn;
	
	public DAO() {
		conn = null;
	}
	
	public boolean connect() {
		String driverName = "org.postgresqlDriver";
		String serverName = "localhost";
		String dbName = "";
		int port = 6789;
		String url = "jdbc:postgresql://" + serverName + ":" + port + "/" + dbName;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;
	}
}
