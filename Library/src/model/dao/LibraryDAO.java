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
			pro = new Properties();//속성 담는 객체       (속성0개)	
			   pro.load(new FileReader("conn/conn.properties"));
			   //속성driver,url,user,password 적재  (속성4개)
			   Class.forName(pro.getProperty("driver"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insert(UserVO vo) {//회원가입창에 입력된 정보를 DB테이블에 저장하는 기능 - 김지우
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
	
	public void checkId() {//입력한 아이디가 중복인지 아닌지 확인하는 기능 -김지우
		Joinform joinForm = new Joinform();
		String id = joinForm.showInput("아이디를 입력하세요.");
		
		LibraryDAO dao = new LibraryDAO();
		if(dao.findExistId(id.trim()) == 1){
			joinForm.showMsg("이미 사용중인 아이디입니다!!");
		} else {
			joinForm.showMsg("그 아이디는 사용가능합니다.");
			if(joinForm.showConfirm("이 아이디를 사용하시겠습니까?")==0) {
				joinForm.tf_id.setText(id);
			}
		}
	}
	
	public int findExistId(String id) {// 특정 아이디의 (DB내의)존재 유무체크==>등록시 에러 발생을 방지하기 위한 기능 - 김지우
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
	
	public boolean update(UserVO vo) {//회원정보를 수정하는 기능 -김지우
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
			if(t == 1) {//수정된 행의 개수가 존재한다면
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
		//여기에 삭제할 기능을 작성해주세요
		return false;
	}
	
	public void loginAction() {
		connect();
		
		disconnect();
	}
	
	
	
	private void connect() {//연결객체생성
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"),pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void disconnect() {//DB자원반환
		try {
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}