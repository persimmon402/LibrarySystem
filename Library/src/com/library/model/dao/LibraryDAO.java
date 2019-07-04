package com.library.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;

import com.library.model.vo.ReservationVO;
import com.library.model.vo.SitVO;
import com.library.model.vo.UserVO;

public class LibraryDAO {

	Connection conn;
	PreparedStatement stmt;
	// conn.properties파일 --> db연결 정보 저장!!

	Properties pro;

	ResultSet rs;

	// DAO : 데이터베이스 전용객체 (DB관련된 일 전담)
	// -- CRUD 작성 (Create,read,update,delete)

	public LibraryDAO() {
		try {
			pro = new Properties();// 속성이 없다
			pro.load(new FileReader("conn/conn.properties"));// 속성 4개 적재
			Class.forName(pro.getProperty("driver"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public boolean findLogin(String id, String pass) {
		connect();

		try {

			if (id.equals("admin")) {
				return false;
			}

			// 관리자 거르기

			String sql = "select count(*) from user_tab where user_id=? and user_pwd=?";
			stmt = conn.prepareStatement(sql);// db에 sql문 전송
			stmt.setString(1, id);
			stmt.setString(2, pass);

			rs = stmt.executeQuery();

			if (rs.next()) {
				int cnt = rs.getInt(1);

				if (cnt > 0)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}

	public boolean findAdmin(String id, String pass) {
		connect();

		try {
			String sql = "select count(*) from user_tab where user_id='admin' and user_pwd=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pass);

			rs = stmt.executeQuery();
			if (!id.equals("admin")) {
				return false;
			} else {
				if (rs.next()) {
					int cnt = rs.getInt(1);
					if (cnt > 0) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}

	// ------------------------------------------------------------------------------------

	public void upOverSit() {//// 사용끝시간이 현재시간보다 적으면 좌석테이블 사용여부를 0으로 바꿔주기 -이진주
		connect();
		try {
			String sql = "update sit_check set sit_check=0 from sit_tab, reservation_tab "
					+ "where sit_tab.sit_num IN (select reservation_tab.sit_num from reservation_tab "
					+ "where sit_end<=now())";
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}// upOverSit
	
	public void upSit_tab() {// 시간지난 자리 1->0 변경 순서가 upSit_tab() -> delres_tab()
		connect();
		LocalDateTime currentDateTime = LocalDateTime.now();
		Timestamp smp = Timestamp.valueOf(LocalDateTime.now());
		
		try {
			String sql = "update sit_tab set sit_check=0 where sit_num in "
					+ "(select sit_num from reservation_tab where sit_end<?)";
			stmt = conn.prepareStatement(sql);
			stmt.setTimestamp(1, smp);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void delres_tab() {// 사용끝시간이 현재시간보다 적으면 예약테이블에서 지워주기 -이진주
		connect();
		LocalDateTime currentDateTime = LocalDateTime.now();
		Timestamp smp = Timestamp.valueOf(LocalDateTime.now());
		try {
			String sql = "delete from reservation_tab where sit_end<?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setTimestamp(1, smp);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}// delSit

//	public List sitColor() { //좌석 색 바꿔주기 잘모르겠음..ㅜ
//		connect();
//		try {
//			String sql="select sit_num, room_num from sit_tab where sit_check = 1";
//			stmt=conn.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery(sql);
//	          rs = stmt.executeQuery(sql);
//	          SitVO sv = new SitVO();
//	          ArrayList<SitVO> list = new ArrayList();
//	          while(rs.next()) {
//	        		rs.get
//	          }
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return list;
//	}//sitColor

	public boolean reserveInto(ReservationVO vo) {// 예약버튼 눌러서 이용좌석 입력하면 예약테이블에 입력하기 -이진주
		connect();
		try {
			String sql = "insert into reservation_tab(sit_num, user_num, sit_start, sit_end) values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			// stmt.setInt(1, vo.getRes_num());
			stmt.setInt(1, vo.getSit_num());
			stmt.setInt(2, vo.getUser_num());
			stmt.setTimestamp(3, vo.getSit_start());
			stmt.setTimestamp(4, vo.getSit_end());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean reserveSit_t(int sit_num) {// 예약테이블에 입력 후 좌석테이블 사용여부 변경 -이진주
		connect();

		try {
			String sql = "update sit_tab set sit_check=1 where sit_num=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, sit_num);
			System.out.println(sit_num);
			int t = stmt.executeUpdate();
			System.out.println(t);
			if (t == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public String checkSit(int sit_num) {// 컨트롤러에서 예약할때 예약된 자리 있으면 예약못하게하기 -이진주
		connect();
		try {
			String sql = "select count(*) from reservation_tab where sit_num = ?";
//		System.out.println("로그인SQL>>>"+ sql);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, sit_num);

			rs = stmt.executeQuery();
			int t = 999;
			if (rs.next()) {
				t = rs.getInt(1);
			}

			if (t == 0) {// 해당 좌석에 예약된 사람이 없을때
				return "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return "fail";
	}
	// ---------------------------------------------------------------------------윤유빈

	// 퇴실시 예약삭제
	public boolean deleteres(int user_num) {
		connect();
		String sql = "delete from reservation_tab where user_num=?";
		try {
			stmt = conn.prepareStatement(sql);// sql문 전송
			stmt.setInt(1, user_num);//
			int t = stmt.executeUpdate();
			if (t == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean sitcheckchange(int user_num) {
		connect();
		String sql = "update sit_tab set sit_check=0 " + "where sit_num in "
				+ "(select sit_num from reservation_tab where user_num = ?)";
		try {
			stmt = conn.prepareStatement(sql);// sql전송
			stmt.setInt(1, user_num);
			int t = stmt.executeUpdate();
			if (t == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 시간연장
	public boolean timeextension(int user_num) {
		connect();
		String sql = "update reservation_tab set sit_end=sit_end+(4/24) where user_num =?";
		try {
			stmt = conn.prepareStatement(sql);// sql문 전송
			stmt.setInt(1, user_num);//
			int t = stmt.executeUpdate();
			if (t > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// id로 user_num구하기
	public int findusernumByid(String id) {
		connect();
		int user_num = 0;
		String sql = "select user_num from user_tab where user_id like ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				user_num = rs.getInt("user_num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user_num;
	}

	// 아이디로 회원 검색
	public UserVO findByid(String id) {// 접속해 있는 회원정보 검색
		connect();
		UserVO vo = new UserVO();
		try {
			String sql = "select user_num,user_pwd,user_id,user_name,user_phone1,user_phone2,user_phone3,user_addr from user_tab where user_id like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {

				vo.setUser_num(rs.getInt("user_num"));
				vo.setUser_pwd(rs.getString("user_pwd"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_phone1(rs.getString("user_phone1"));
				vo.setUser_phone2(rs.getString("user_phone2"));
				vo.setUser_phone3(rs.getString("user_phone3"));
				vo.setUser_addr(rs.getString("user_addr"));

			} //

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}// findByName

	// user_num으로 내 예약 정보 확인-> 테이블에 나타낼 정보
	public ArrayList<ReservationVO> findMyres(int user_num) {
		connect();
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();

		try {
			String sql = " select res_num, user_num, sit_num, sit_start, sit_end from reservation_tab where user_num=?";
			stmt = conn.prepareStatement(sql);// sql문 전송
			stmt.setInt(1, user_num);//
			rs = stmt.executeQuery();

			while (rs.next()) {// 아이디에 일치하는 행이 존재한다면
				ReservationVO vo = new ReservationVO();
				vo.setRes_num(rs.getInt("res_num"));
				vo.setUser_num(rs.getInt("user_num"));
				vo.setSit_num(rs.getInt("sit_num"));
				vo.setSit_start(rs.getTimestamp("sit_start"));
				vo.setSit_end(rs.getTimestamp("sit_end"));
				// vo.setSit_remain(rs.getTimestamp("sit_end-sit_start"));

				LocalDateTime currentDateTime = LocalDateTime.now();
				Timestamp smp = Timestamp.valueOf(LocalDateTime.now());
				// 현재시간

				Timestamp t1 = rs.getTimestamp("sit_start");
				Timestamp t2 = rs.getTimestamp("sit_end");

				// 남은시간 = 퇴실시간 - 현재시간
				long l = (t2.getTime() - smp.getTime());

				long minute = (l / 1000) / 60; // minute

				long reshour = minute / 60; // 남은시간
				long resmin = minute % 60; // 남은 분

				String restime = reshour + "시간" + resmin + "분";
				if (l < 0) {
					restime = "퇴실시간초과";
				}
				vo.setSit_remain(restime);
				// System.out.println(restime);
				list.add(vo);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 좌석 사용 여부 1인 좌석번호 구하기
	public ArrayList<SitVO> sit_check() {
		connect();
		ArrayList<SitVO> list = new ArrayList<SitVO>();

		try {
			String sql = "select room_num,sit_num from sit_tab where sit_check = 1";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				SitVO vo = new SitVO();
				vo.setRoom_num(rs.getInt("room_num"));
				vo.setSit_num(rs.getInt("sit_num"));

				list.add(vo);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public ArrayList<SitVO> sit_check0() {
		// 좌석사용여부 0 인거 찾기
		connect();
		ArrayList<SitVO> list = new ArrayList<SitVO>();

		try {
			String sql = "select room_num,sit_num from sit_tab where sit_check = 0";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				SitVO vo = new SitVO();
				vo.setRoom_num(rs.getInt("room_num"));
				vo.setSit_num(rs.getInt("sit_num"));

				list.add(vo);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	

	// -------------------------------------------------------김지우

	public boolean insert(UserVO vo) {// 회원가입창에 입력된 정보를 DB테이블에 저장하는 기능 - 김지우
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

	public int findExistId(String id) {// 특정 아이디의 (DB내의)존재 유무체크==>등록시 에러 발생을 방지하기 위한 기능 - 김지우
		connect();
		int count = 9999;
		try {
			String sql = "select count(*) cnt from user_tab where user_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;
	}

	public boolean update(UserVO vo) {// 회원정보를 수정하는 기능 -김지우
		connect();
		try {
			String sql = "update user_tab set user_pwd=?, user_name=?, user_phone1=?, user_phone2=?, user_phone3=?, user_addr=? where user_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getUser_pwd());
			stmt.setString(2, vo.getUser_name());
			stmt.setString(3, vo.getUser_phone1());
			stmt.setString(4, vo.getUser_phone2());
			stmt.setString(5, vo.getUser_phone3());
			stmt.setString(6, vo.getUser_addr());
			stmt.setString(7, vo.getUser_id());
			int t = stmt.executeUpdate();
			if (t == 1) {// 수정된 행의 개수가 존재한다면
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// --------------------------------------------------------------
	// (전체)회원 정보 조회
	public ArrayList<UserVO> findAll() {
		connect();
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		// 컬럼 : 회원번호, 아이디, 이름, 전화번호, 주소
		try {
			String sql = "select user_num,user_id,user_name,user_phone1,user_phone2,user_phone3,user_addr from user_tab";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setUser_num(rs.getInt("user_num"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_phone1(rs.getString("user_phone1"));
				vo.setUser_phone2(rs.getString("user_phone2"));
				vo.setUser_phone3(rs.getString("user_phone3"));
				vo.setUser_addr(rs.getString("user_addr"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}// findAll

	// 이름으로 회원 검색
	public ArrayList<UserVO> findByName(String name) {
		connect();
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		// 컬럼: user_num,user_id,user_name,user_phone1,user_phone2,user_phone3,user_addr
		try {
			String sql = "select user_num,user_id,user_name,user_phone1,user_phone2,user_phone3,user_addr from user_tab where user_name like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				// 열데이터 얻기
				UserVO vo = new UserVO();
				vo.setUser_num(rs.getInt("user_num"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_phone1(rs.getString("user_phone1"));
				vo.setUser_phone2(rs.getString("user_phone2"));
				vo.setUser_phone3(rs.getString("user_phone3"));
				vo.setUser_addr(rs.getString("user_addr"));

				list.add(vo);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}// findByName

	// ---------------------------------------------------------
	// 회원삭제
	public boolean remove(String user_id) {
		connect();
		try {
			String sql = "delete from user_tab where user_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user_id);
			int t = stmt.executeUpdate();
			if (t == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// remove

	// 수정폼에 입력된 데이터로 DB 갱신
	public boolean modify(UserVO vo) {
		connect();
		try {
			String sql = "update user_tab set user_name=?, user_phone1=?, user_phone2=?, user_phone3=?, user_addr=? where user_id=?";
			stmt = conn.prepareStatement(sql);// sql전송
			stmt.setString(1, vo.getUser_name());
			stmt.setString(2, vo.getUser_phone1());
			stmt.setString(3, vo.getUser_phone2());
			stmt.setString(4, vo.getUser_phone3());
			stmt.setString(5, vo.getUser_addr());
			stmt.setString(6, vo.getUser_id());
			int t = stmt.executeUpdate();// sql실행요청
			if (t == 1)
				return true;// t:수정된 행의 갯수
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// modify
		// ============================================================

	public ArrayList<ReservationVO> Show_CurrentUser() {
		connect();
		ArrayList<ReservationVO> list = new ArrayList<>();

		try {
			String sql = "select usert.user_num, user_name, sit_num, res_num, sit_start, sit_end "
					+ "from user_tab usert, reservation_tab res " + "where usert.user_num = res.user_num";
			// where조건절로 열람실 구분하기

			// 컬럼: 회원번호, 이름, 좌석번호, 예약번호, 입실시간, 퇴실시간
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(); // sql문 실행요청(실행시점!!)

			while (rs.next()) {
				ReservationVO vo = new ReservationVO();
				vo.setUser_num(rs.getInt("user_num"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setSit_num(rs.getInt("sit_num"));
				vo.setRes_num(rs.getInt("res_num"));
				vo.setSit_start(rs.getTimestamp("sit_start"));
				vo.setSit_end(rs.getTimestamp("sit_end"));

				list.add(vo);
			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//============================================================
	//좌석예약시 한사람에 한명만 자리예약 위해서 예약 테이블 조회
	public int countRes(int user_num) {
		connect();
		int count = 999;
		
		try {
			String sql = "select count(sit_num) cnt from reservation_tab where user_num=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user_num);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;
	}
	
	private void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"),
					pro.getProperty("password"));

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void disconnect() {

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
