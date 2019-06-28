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

import model.vo.UserVO;
import view.Joinform;

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
	
	public boolean insert(UserVO vo) {//ȸ������â�� �Էµ� ������ DB���̺� �����ϴ� ��� - ������
		connect();
		try {
			String sql = "insert into user_tab (user_id, user_pwd, user_name, user_addr, user_phone1, user_phone2, user_phone3) values (?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getUser_id());
			stmt.setString(2, vo.getUser_pwd());
			stmt.setString(3, vo.getUser_name());
			stmt.setString(4, vo.getUser_addr());
			stmt.setString(5, vo.getUser_phone1());
			stmt.setString(6, vo.getUser_phone2());
			stmt.setString(7, vo.getUser_phone3());
			
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	public void checkId() {//�Է��� ���̵� �ߺ����� �ƴ��� Ȯ���ϴ� ��� -������
		Joinform joinForm = new Joinform();
		String id = joinForm.showInput("���̵� �Է��ϼ���.");
		
		LibraryDAO dao = new LibraryDAO();
		if(dao.findExistId(id.trim()) == 1){
			joinForm.showMsg("�̹� ������� ���̵��Դϴ�!!");
		} else {
			joinForm.showMsg("�� ���̵�� ��밡���մϴ�.");
			if(joinForm.showConfirm("�� ���̵� ����Ͻðڽ��ϱ�?")==0) {
				joinForm.tf_id.setText(id);
			}
		}
	}
	
	public int findExistId(String id) {// Ư�� ���̵��� (DB����)���� ����üũ==>��Ͻ� ���� �߻��� �����ϱ� ���� ��� - ������
		connect();
		int count = 0;
		try {
			String sql = "select count(*) cnt from user_tab where user_id=?";
			stmt.getConnection().prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;
	}
	
	public boolean update(UserVO vo) {//ȸ�������� �����ϴ� ��� -������
		connect();
		try {
			String sql = "update user_id set user_pwd=?, user_phone1=?, user_phone2=?, user_phone3=? user_addr=? where user_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getUser_pwd());
			stmt.setString(2, vo.getUser_phone1());
			stmt.setString(3, vo.getUser_phone2());
			stmt.setString(4, vo.getUser_phone3());
			stmt.setString(5, vo.getUser_addr());
			stmt.setString(5, vo.getUser_id());
			int t = stmt.executeUpdate();
			if(t == 1) {//������ ���� ������ �����Ѵٸ�
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean remove(String user_id){
		//���⿡ ������ ����� �ۼ����ּ���
		return false;
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