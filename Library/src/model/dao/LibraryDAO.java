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
	
	public void upOverSit() {////사용끝시간이 현재시간보다 적으면 좌석테이블 사용여부를 0으로 바꿔주기 -이진주
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
	
	public void delSit() {//사용끝시간이 현재시간보다 적으면 예약테이블에서 지워주기  -이진주	
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
	
//	public List sitColor() { //좌석 색 바꿔주기 잘모르겠음..ㅜ
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
	
	
	
	
	
	
	public boolean reserveInto(ReservationVO vo) {//예약버튼 눌러서 이용좌석 입력하면 예약테이블에 입력하기  -이진주
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
	
	
	public boolean reserveSit(SitVO vo) {//예약테이블에 입력되면 좌석테이블에도 넣어주기  -이진주
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
		
	public boolean checkSit(int num) {// 컨트롤러에서 예약할때 예약된 자리 있으면 예약못하게하기 -이진주
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