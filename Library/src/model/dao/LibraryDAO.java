package model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import model.vo.ReservationVO;
import model.vo.SitVO;
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
	
	public void upOverSit() {////��볡�ð��� ����ð����� ������ �¼����̺� ��뿩�θ� 0���� �ٲ��ֱ� -������
		connect();
		try {
		String sql="update sit_check set sit_check=0 from sit_tab, reservation_tab "
				+ "where sit_tab.sit_num IN (select reservation_tab.sit_num from reservation_tab "
				+ "where sit_end<=now())";
		stmt=conn.prepareStatement(sql);
		stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}//upOverSit
	
	public void delSit() {//��볡�ð��� ����ð����� ������ �������̺��� �����ֱ�  -������	
		connect();
		try {
			String sql = "delete from reservation_tab where sit_end<=now()";
			stmt=conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}//delSit
	
//	public List sitColor() { //�¼� �� �ٲ��ֱ� �߸𸣰���..��
//		connect();
//		try {
//			String sql="select sit_num, room_num from sit_tab where sit_check = 1";
//			stmt=conn.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery(sql);
//	          rs = stmt.executeQuery(sql);
//	          while(rs.next()) {
//	        	 List list = new ArrayList();
//	        		 list.add(rs.getInt("no"));
//	          }
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return list;
//	}//sitColor
	
	
	
	
	
	
	public boolean reserveInto(ReservationVO vo) {//�����ư ������ �̿��¼� �Է��ϸ� �������̺� �Է��ϱ�  -������
		connect();
		try {
		String sql = "insert into reservation_tab (res_num, sit_num, user_num, sit_start, sit_end) values(?,?,?,?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, vo.getRes_num());
		stmt.setInt(2, vo.getSit_num());
		stmt.setInt(3, vo.getUser_num());
		stmt.setTimestamp(4, vo.getSit_start());
		stmt.setTimestamp(5, vo.getSit_end());
		stmt.executeUpdate();
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		disconnect();
		}
		return false;
		}	
	
	
	public boolean reserveSit(SitVO vo) {//�������̺� �ԷµǸ� �¼����̺��� �־��ֱ�  -������
		connect();
		try {
		String sql = "insert into sit_tab (sit_num, room_num, sit_check) values(?,?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, vo.getSit_num());
		stmt.setInt(2, vo.getRoom_num());
		stmt.setInt(3, vo.getSit_check());
		stmt.executeUpdate();
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		disconnect();
		}
		return false;
		}	
		
	public boolean checkSit(int num) {// ��Ʈ�ѷ����� �����Ҷ� ����� �ڸ� ������ ������ϰ��ϱ� -������
		connect();
		try {
		String sql = "select sit_check from sit_tab where sit_num="+num;
		stmt=conn.prepareStatement(sql);
		int t =stmt.executeUpdate();
		if(t > 0) {
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