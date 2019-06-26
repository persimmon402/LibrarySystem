package model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class LibraryDAO {

	Connection conn;
	PreparedStatement stmt;
	ResultSet  rs;
	Properties pro;
	
	public LibraryDAO() {//
		try {
			pro = new Properties();//加己 淬绰 按眉       (加己0俺)	
			   pro.load(new FileReader("conn/conn.properties"));
			   //加己driver,url,user,password 利犁  (加己4俺)
			   Class.forName(pro.getProperty("driver"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loginAction() {
		connect();
		
		disconnect();
	}
	
	private void connect() {//楷搬按眉积己
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"),pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void disconnect() {//DB磊盔馆券
		try {
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}