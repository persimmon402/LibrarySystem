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
			pro = new Properties();//�Ӽ� ��� ��ü       (�Ӽ�0��)	
			   pro.load(new FileReader("conn/conn.properties"));
			   //�Ӽ�driver,url,user,password ����  (�Ӽ�4��)
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
	
	private void connect() {//���ᰴü����
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"),pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void disconnect() {//DB�ڿ���ȯ
		try {
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}