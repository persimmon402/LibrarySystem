package com.library.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import model.dao.LibraryDAO;
import model.vo.ReservationVO;
import model.vo.SitVO;
import model.vo.UserVO;
import view.AllmemberForm;
import view.JoinForm;
import view.LoginForm;
import view.SeatReserveSelectWindow;
import view.ServiceForm;
import view.ServiceForm_adm;
import view.UpJoinForm;
import view.UpJoinForm_adm;

public class Controller implements ActionListener {
	JoinForm joinForm;
	LoginForm loginForm;
	ServiceForm serviceForm;
	ServiceForm_adm serviceForm_adm;

	AllmemberForm allmemberForm;
	UpJoinForm upJoinForm;
	SeatReserveSelectWindow seatForm;

	UpJoinForm_adm upJoinForm_adm;

	public Controller() {
		loginForm = new LoginForm();
		joinForm = new JoinForm();

		serviceForm = new ServiceForm();
		serviceForm_adm = new ServiceForm_adm();

		allmemberForm = new AllmemberForm();
		upJoinForm = new UpJoinForm();

		seatForm = new SeatReserveSelectWindow();

		upJoinForm_adm = new UpJoinForm_adm();

		eventUp();
	}

	private void eventUp() {

		loginForm.bt_join.addActionListener(this);
		loginForm.bt_login.addActionListener(this);
		loginForm.bt_manager.addActionListener(this);

		// ----------------------------------------------------
		joinForm.bt_cancel.addActionListener(this);
		joinForm.bt_submit.addActionListener(this);
		joinForm.bt_check.addActionListener(this);
		// ---------------------------------------------------

		
		

		allmemberForm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				allmemberForm.setVisible(false);
				serviceForm_adm.setVisible(true);
			}
		});
		// -------------------------------------------------------
		serviceForm.bt_reserv.addActionListener(this);
		serviceForm.bt_logout.addActionListener(this);
		serviceForm.bt_myinfo.addActionListener(this);
		serviceForm.bt_out.addActionListener(this);
		serviceForm.bt_room1.addActionListener(this);
		serviceForm.bt_room2.addActionListener(this);
		serviceForm.bt_room3.addActionListener(this);
		serviceForm.bt_cont.addActionListener(this);
		// ----------------------------------------------------

		seatForm.bt_room1.addActionListener(this);
		seatForm.bt_room2.addActionListener(this);
		seatForm.bt_room3.addActionListener(this);
		seatForm.bt_logout.addActionListener(this);
		seatForm.bt_reserve.addActionListener(this);
		seatForm.bt_cancel.addActionListener(this);

		seatForm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				seatForm.setVisible(false);
				serviceForm.setVisible(true);
			}
		});

		// ------------------------------------------------------------
		allmemberForm.bt_sel_name.addActionListener(this);
		allmemberForm.bt_up.addActionListener(this);
		allmemberForm.bt_del.addActionListener(this);
		allmemberForm.bt_exit.addActionListener(this);

		serviceForm_adm.bt_allCustom.addActionListener(this);

		upJoinForm_adm.bt_submit.addActionListener(this);
		upJoinForm_adm.bt_cancle.addActionListener(this);

//	      ========================0702================================

		

		
		

		upJoinForm.bt_submit.addActionListener(this);
		upJoinForm.bt_cancel.addActionListener(this);

//	      =======================0702================================
//	      ====================0702 본진===============================
		serviceForm_adm.bt_logout_adm.addActionListener(this);
		serviceForm_adm.bt_room1_adm.addActionListener(this);
		serviceForm_adm.bt_room2_adm.addActionListener(this);
		serviceForm_adm.bt_room3_adm.addActionListener(this);

//	      ====================본진===============================
//	      ==========================0703=======================
		serviceForm.bt_myinfo.addActionListener(this);

		
//	      ==========================0703=======================

		allmemberForm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				allmemberForm.setVisible(false);
				serviceForm_adm.setVisible(true);
			}
		});
		serviceForm_adm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				serviceForm_adm.setVisible(false);
			}
		});
		upJoinForm_adm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				upJoinForm_adm.setVisible(false);
			}
		});

	}

//	public void checkId() {// 입력한 아이디가 중복인지 아닌지 확인하는 기능 - 이것도 controller에 복사해 주세요 -김지우
//		LibraryDAO dao = new LibraryDAO();
//
//		String id = joinForm.showInput("아이디를 입력하세요.");
//		
//		if (dao.findExistId(id.trim()) == 1) {
//			joinForm.showMsg("이미 사용중인 아이디입니다!!");
//		} else {
//			joinForm.showMsg("그 아이디는 사용가능합니다.");
//			if (joinForm.showConfirm("이 아이디를 사용하시겠습니까?") == 0) {
//				joinForm.tf_id.setText(id);
//			}
//		}
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == loginForm.bt_join) {
			loginForm.setVisible(false);
			joinForm.setVisible(true);
		} else if (ob == loginForm.bt_login) {
			String id = loginForm.tf_id.getText();
			String pass = new String(loginForm.tf_pass.getPassword());

			LibraryDAO dao = new LibraryDAO();

			if (dao.findLogin(id, pass)) {
				loginForm.showMsg("로그인 성공했습니다.");

				// serviceForm.displayTable(dao.findAll());

				serviceForm.loginId = id;

				loginForm.initText();// 로그인 성공시 로그인 창 초기화

				loginForm.setVisible(false);
				serviceForm.setVisible(true);
				// 로그인 성공 후 서비스 폼 이동

				// seatreserveselectwindow.setVisible(true);
				id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);
				serviceForm.displayTable(dao.findMyres(user_num));

				// 예약중인 자리 색깔변하기
				// SitVO list = new SitVO();
				ArrayList<SitVO> list = dao.sit_check();

				for (int i = 0; i < list.size(); i++) {

					SitVO vo = list.get(i);

					int roomnum = vo.getRoom_num();
					int sitnum = vo.getSit_num();
					if (roomnum == 1) {
						serviceForm.change_sitcolor_room1(sitnum);
					} else if (roomnum == 2) {
						serviceForm.change_sitcolor_room2(sitnum);
					} else if (roomnum == 3) {
						serviceForm.change_sitcolor_room3(sitnum);
					}
				}

			} else {

				loginForm.showMsg("아이디 또는 비밀번호가 일치하지 않습니다!!");
			}

		}

		else if (ob == loginForm.bt_manager) {
			String id = loginForm.tf_id.getText();
			String pass = new String(loginForm.tf_pass.getPassword());

			LibraryDAO dao = new LibraryDAO();

			if (dao.findAdmin(id, pass)) {
				loginForm.showMsg("관리자 로그인 성공");

				serviceForm.loginId = id;
				loginForm.initText();

				loginForm.setVisible(false);
				serviceForm_adm.setVisible(true);
				
				ArrayList<SitVO> list = dao.sit_check();

				for (int i = 0; i < list.size(); i++) {
					SitVO vo = list.get(i);
					int roomnum = vo.getRoom_num();
					int sitnum = vo.getSit_num();
					if (roomnum == 1) {
						serviceForm_adm.change_sitcolor_room1(sitnum);
					}
				}

				// DB에서 정보끌어와서 보여주기
				// d=displayTable 메소드
				serviceForm_adm.displayTable1(dao.Show_CurrentUser());
				
			} else {
				loginForm.showMsg("관리자 로그인 실패");
			}

		}

		// ------------------------------------------------------김지우

		else if (ob == loginForm.bt_join) {// 로그인폼에서 회원가입 버튼을 누름 - 김지우
			loginForm.setVisible(false);
			joinForm.setVisible(true);

		} else if (ob == joinForm.bt_submit) {// 회원가입창에서 등록 버튼을 누름-김지우
			LibraryDAO dao = new LibraryDAO();

			/* 여기는 중복 확인하는 기능을 구현할 영역입니다.-김지우 */
			UserVO vo = new UserVO();

			String id = joinForm.tf_id.getText();
			String pwd = new String(joinForm.tf_pwd.getPassword());
			String name = joinForm.tf_name.getText();
			String phone1 = joinForm.tf_phone1.getText();
			String phone2 = joinForm.tf_phone2.getText();
			String phone3 = joinForm.tf_phone3.getText();
			String addr = joinForm.tf_addr.getText();

			vo.setUser_id(id);
			vo.setUser_pwd(pwd);
			vo.setUser_name(name);
			vo.setUser_phone1(phone1);
			vo.setUser_phone2(phone2);
			vo.setUser_phone3(phone3);
			vo.setUser_addr(addr);

			if (dao.insert(vo)) {
				joinForm.showMsg("회원가입에 성공하였습니다.");
				joinForm.setVisible(false);
				loginForm.setVisible(true);
			} else {
				joinForm.showMsg("회원가입에 실패하였습니다. 입력값을 확인하세요.");
			}

		} else if (ob == joinForm.bt_cancel) {// 회원가입창에서 취소 버튼을 누름-김지우

			joinForm.setVisible(false);
			loginForm.setVisible(true);

		} else if (ob == joinForm.bt_check) {// 회원가입창에서 중복확인 버튼을 누름-김지우
			System.out.println("중복확인버튼");

			LibraryDAO dao = new LibraryDAO();

			String id = joinForm.showInput("아이디를 입력하세요.");
			System.out.println(id);
			System.out.println(dao.findExistId(id));
			if (id.trim() != null) {
				if (dao.findExistId(id) > 0) {
					joinForm.showMsg("이미 사용중인 아이디입니다!!");
				}

				else {
					joinForm.showMsg("그 아이디는 사용가능합니다.");
					if (joinForm.showConfirm("이 아이디를 사용하시겠습니까?") == 0) {
						joinForm.tf_id.setText(id);
					}
				}

			} else {

				joinForm.showMsg("아이디를 입력하세요 (공백은안돼)");
			}

		} else if (ob == upJoinForm.bt_submit) {// 내정보수정 창에서 수정완료 버튼을 누름-김지우

			UserVO vo = new UserVO();
			vo.setUser_pwd(new String(upJoinForm.tf_pwd.getPassword()));
			vo.setUser_phone1(upJoinForm.tf_phone1.getText());
			vo.setUser_phone2(upJoinForm.tf_phone2.getText());
			vo.setUser_phone3(upJoinForm.tf_phone3.getText());
			vo.setUser_addr(upJoinForm.tf_addr.getText());

			LibraryDAO dao = new LibraryDAO();
			if (dao.update(vo)) {

				upJoinForm.showMsg("수정되었습니다.");
				upJoinForm.setVisible(false);
				serviceForm.setVisible(true);
			} else {
				upJoinForm.showMsg("입력된 데이터를 확인하세요.");
			}

		} else if (ob == upJoinForm.bt_cancel) {// 내 정보수정 창에서 취소 버튼을 누름 - 김지우

			upJoinForm.setVisible(false);
			serviceForm.setVisible(true);
		}

		// ---------------------------------------------------------------------------
		// 이진주

		else if (ob == serviceForm.bt_reserv) {// 서비스폼에서 예약버튼누를경우 -이진주
			LibraryDAO dao = new LibraryDAO();
			ArrayList<SitVO> list = dao.sit_check();

			for (int i = 0; i < list.size(); i++) {

				SitVO vo = list.get(i);

				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 1) {
					seatForm.change_sitcolor_room1(sitnum);
				} else if (roomnum == 2) {
					seatForm.change_sitcolor_room2(sitnum);
				} else if (roomnum == 3) {
					seatForm.change_sitcolor_room3(sitnum);
				}
			}

			serviceForm.setVisible(false);
			seatForm.setVisible(true);

//			SeatReserveSelectWindow이 열리면 자동으로 퇴실시간-현재시간 제외한 예약테이블에 예약한 사람들 버튼색 변경해주기

		} else if (ob == seatForm.bt_room1) {// SeatReserveSelectWindow에서 열람실1버튼 눌렀을경우 -이진주
			LibraryDAO dao = new LibraryDAO();
			seatForm.p_room1.setVisible(true);
			seatForm.p_room2.setVisible(false);
			seatForm.p_room3.setVisible(false);

			ArrayList<SitVO> list = dao.sit_check();

			for (int i = 0; i < list.size(); i++) {
				SitVO vo = list.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 1) {
					seatForm.change_sitcolor_room1(sitnum);
				}
			}

//			1열람실 true로 만들어주기

		} else if (ob == seatForm.bt_room2) {// SeatReserveSelectWindow에서 열람실2버튼 눌렀을경우 -이진주

			seatForm.p_room1.setVisible(false);
			seatForm.p_room2.setVisible(true);
			seatForm.p_room3.setVisible(false);
			LibraryDAO dao = new LibraryDAO();
			ArrayList<SitVO> list = dao.sit_check();

			for (int i = 0; i < list.size(); i++) {
				SitVO vo = list.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 2) {
					seatForm.change_sitcolor_room2(sitnum);
				}
			}

//			2열람실  true로 만들어주기

		} else if (ob == seatForm.bt_room3) {// SeatReserveSelectWindow에서 열람실3버튼 눌렀을경우 -이진주

			seatForm.p_room1.setVisible(false);
			seatForm.p_room2.setVisible(false);
			seatForm.p_room3.setVisible(true);

			LibraryDAO dao = new LibraryDAO();
			ArrayList<SitVO> list = dao.sit_check();

			for (int i = 0; i < list.size(); i++) {
				SitVO vo = list.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 3) {
					seatForm.change_sitcolor_room3(sitnum);
				}
			}

//			

		} else if (ob == seatForm.bt_logout) {// SeatReserveSelectWindow에서 로그아웃 버튼 눌렀을경우 -이진주

			if (seatForm.showConfirm("로그아웃 하시겠습니까?") == 0) {
				seatForm.setVisible(false);
				loginForm.setVisible(true);
				serviceForm.loginId = "";
			}
		} else if (ob == seatForm.bt_reserve) {// 예약버튼 누를시 -이진주
			LibraryDAO dao = new LibraryDAO();
			String sitNum = seatForm.showInput("예약하실 좌석번호를 입력하세요");
			int sit_num = Integer.parseInt(sitNum);
			ReservationVO reservationvo = new ReservationVO();
			UserVO uservo = new UserVO();
			SitVO sitvo = new SitVO();

			// 시간계산하기

			long retryDate = System.currentTimeMillis();
			Timestamp sit_start = new Timestamp(retryDate);
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(sit_start.getTime());
			cal.add(Calendar.HOUR, 4);
			Timestamp sit_end = new Timestamp(cal.getTime().getTime());
//			System.out.println("one>>>"+ one+", two>>>"+ two+ ", three>>>"+ three);

			// 예약좌석번호를 받아온 상황

			if (dao.checkSit(sit_num).equals("success")) {
				// 해당 좌석에 예약된 사람이 없을때
				// 예약진행
				reservationvo.setSit_num(sit_num);
				reservationvo.setSit_start(sit_start);
				reservationvo.setSit_end(sit_end);
				String id = serviceForm.loginId;
				reservationvo.setUser_num(dao.findusernumByid(id));

				if (dao.reserveInto(reservationvo)) {
					// 예약테이블에 성공적으로 들어감
					boolean ch = dao.reserveSit_t(sit_num);
					System.out.println(ch);
					// 좌석테이블 1로 바꾸기
					seatForm.showMsg("예약성공");

					System.out.println(sit_num);

				} else {
					// 예약테이블에 입력 실패
					seatForm.showMsg("예약실패");
				}

			} else {
				// 해당 좌석에 예약된 사람이 있을 때
				seatForm.showMsg("이미 예약된 번호입니다.");
			}

		} else if (ob == seatForm.bt_cancel) {// SeatReserveSelectWindow에서 취소버튼 누른경우 -이진주
			seatForm.setVisible(false);
			serviceForm.setVisible(true);
		}

		// ----------------------------------------------------------------------윤유빈
//		else if (ob == serviceForm.bt_reserv) {
//			LibraryDAO dao = new LibraryDAO();
//			// seatreserveselectwindow.setVisible(true);
//			String id = serviceForm.loginId;
//			int user_num = dao.findusernumByid(id);
//			serviceForm.displayTable(dao.findMyres(user_num));
//			// list로 넘어오는거 화면에 보여주기
//		} 
		else if (ob == serviceForm.bt_room1) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm.p_room1.setVisible(true);
			serviceForm.p_room2.setVisible(false);
			serviceForm.p_room3.setVisible(false);

			// 예약중인 자리 색깔변하기
			// SitVO list = new SitVO();
			ArrayList<SitVO> list = dao.sit_check();

			for (int i = 0; i < list.size(); i++) {
				SitVO vo = list.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 1) {
					serviceForm.change_sitcolor_room1(sitnum);
				} else if (roomnum == 2) {
					serviceForm.change_sitcolor_room2(sitnum);
				} else if (roomnum == 3) {
					serviceForm.change_sitcolor_room3(sitnum);
				}
			}

		} else if (ob == serviceForm.bt_room2) {
			serviceForm.p_room1.setVisible(false);
			serviceForm.p_room2.setVisible(true);
			serviceForm.p_room3.setVisible(false);

			// 예약중인 자리 색깔변하기
			// SitVO list = new SitVO();
			LibraryDAO dao = new LibraryDAO();
			ArrayList<SitVO> list2 = dao.sit_check();
			for (int i = 0; i < list2.size(); i++) {
				SitVO vo = list2.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 1) {
					serviceForm.change_sitcolor_room1(sitnum);
				}
			}

		} else if (ob == serviceForm.bt_room3) {
			serviceForm.p_room1.setVisible(false);
			serviceForm.p_room2.setVisible(false);
			serviceForm.p_room3.setVisible(true);
			LibraryDAO dao = new LibraryDAO();
			// 예약중인 자리 색깔변하기
			// SitVO list = new SitVO();
			ArrayList<SitVO> list3 = dao.sit_check();
			for (int i = 0; i < list3.size(); i++) {
				SitVO vo = list3.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 1) {
					serviceForm.change_sitcolor_room1(sitnum);
				}
			}

		} else if (ob == serviceForm.bt_myinfo) { // 내 정보 버튼
			LibraryDAO dao = new LibraryDAO();
			upJoinForm.setVisible(true);
			String id = serviceForm.loginId;

			upJoinForm.initText(dao.findByid(id));

		} else if (ob == serviceForm.bt_logout) {// 로그아웃 버튼
			loginForm.setVisible(true);
			serviceForm.setVisible(false);
			serviceForm.loginId = "";
		} else if (ob == serviceForm.bt_out) {// 퇴실버튼
			LibraryDAO dao = new LibraryDAO();
			if (serviceForm.showConfirm("정말 퇴실 하시겠습니까?") == 0) {
				String id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);
				if (dao.sitcheckchange(user_num)) {// 삭제 성공시
					dao.deleteres(user_num);

					serviceForm.displayTable(dao.findMyres(user_num));
					// -----------------------내 예약목록 초기화

					// -------------------------------------------

					ArrayList<SitVO> list = dao.sit_check0();

					for (int i = 0; i < list.size(); i++) {

						SitVO vo = list.get(i);

						int roomnum = vo.getRoom_num();
						int sitnum = vo.getSit_num();
						if (roomnum == 1) {
							serviceForm.default_sitcolor_room1(sitnum);
						} else if (roomnum == 2) {
							serviceForm.default_sitcolor_room2(sitnum);
						} else if (roomnum == 3) {
							serviceForm.default_sitcolor_room3(sitnum);
						}
					}

					// -------------------------------------------
					// 퇴실 성공시 버튼색깔 초기화
					serviceForm.showMsg("퇴실에 성공하였습니다!!");
				} else {
					serviceForm.showMsg("퇴실에 실패하였습니다!!");
				}
			} else {
				serviceForm.showMsg("퇴실에 실패하였습니다!!");
			}

		} else if (ob == serviceForm.bt_cont) {
			LibraryDAO dao = new LibraryDAO();
			if (serviceForm.showConfirm("연장 하시겠습니까?") == 0) {
				String id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);

				if (dao.timeextension(user_num)) {// 연장 성공시
					serviceForm.displayTable(dao.findMyres(user_num));
					serviceForm.showMsg("시간연장에 성공하였습니다!!");
				} else {
					serviceForm.showMsg("시간연장에 실패하였습니다!!");
				}

			}

		}

		// --------------------------------------------------------------------

		else if (ob == serviceForm_adm.bt_allCustom) {// 관리자 창에서 모든 회원 정보보기 눌렀을때
			LibraryDAO dao = new LibraryDAO();
			allmemberForm.displayTable(dao.findAll());
			serviceForm_adm.setVisible(false);
			allmemberForm.setVisible(true);

		} else if (ob == allmemberForm.bt_sel_name) {// 검색 눌렀을때
			LibraryDAO dao = new LibraryDAO();
			String name = allmemberForm.showInput("조회할 이름:");
			if (name == null) {
				return;
			}
			allmemberForm.displayTable(dao.findByName(name));

		} else if (ob == allmemberForm.bt_up) {
			LibraryDAO dao = new LibraryDAO();
			String user_id = allmemberForm.showInput("수정할 아이디:");
			UserVO vo = dao.findByid(user_id);
			if (user_id == null) {
				return;
			}
			if (vo == null) {
				allmemberForm.showMsg("존재하지 않는 아이디입니다.");
				return;
			}
			upJoinForm_adm.initText(vo);
			upJoinForm_adm.setVisible(true);

		} else if (ob == allmemberForm.bt_del) {// 삭제 눌렀을때
			LibraryDAO dao = new LibraryDAO();
			String user_id;
			user_id = allmemberForm.showInput("삭제할 아이디:");
			dao = new LibraryDAO();
			if (user_id == null) {
				return;
			}
			if (allmemberForm.showConfirm("정말 삭제/탈퇴 하시겠습니까?") == 0) {
				if (dao.remove(user_id)) {
					allmemberForm.displayTable(dao.findAll());
				} else {
					allmemberForm.showMsg("삭제에 실패했습니다.\n삭제할 아이디를 다시 확인해주세요");
				}
			}

		} else if (ob == allmemberForm.bt_exit) {// 나가기 눌렀을때
			allmemberForm.setVisible(false);
			serviceForm_adm.setVisible(true);

		} else if (ob == upJoinForm_adm.bt_submit) {// 수정버튼 누른 후 관리자만의 회원 수정 폼에서 등록 눌렀을때
			LibraryDAO dao = new LibraryDAO();
			UserVO vo = new UserVO();
			vo.setUser_id(upJoinForm_adm.tf_id.getText());
			vo.setUser_name(upJoinForm_adm.tf_name.getText());
			vo.setUser_phone1(upJoinForm_adm.tf_phone1.getText());
			vo.setUser_phone2(upJoinForm_adm.tf_phone2.getText());
			vo.setUser_phone3(upJoinForm_adm.tf_phone3.getText());
			vo.setUser_addr(upJoinForm_adm.tf_addr.getText());
			dao = new LibraryDAO();
			if (dao.modify(vo)) {
				allmemberForm.displayTable(dao.findAll());
				upJoinForm_adm.setVisible(false);
				allmemberForm.setVisible(true);
			}

		} else if (ob == upJoinForm_adm.bt_cancle) {// 수정버튼 누른 후 관리자만의 회원 수정 폼에서 취소 눌렀을때
			upJoinForm_adm.setVisible(false);
			allmemberForm.setVisible(true);
		}

		else if (ob == upJoinForm.bt_submit) {// 내정보수정 창에서 수정완료 버튼을 누름-김지우

			UserVO vo = new UserVO();
			LibraryDAO dao = new LibraryDAO();
			vo.setUser_id(upJoinForm.tf_id.getText());
			vo.setUser_name(upJoinForm.tf_name.getText());
			vo.setUser_pwd(new String(upJoinForm.tf_pwd.getPassword()));
			vo.setUser_phone1(upJoinForm.tf_phone1.getText());
			vo.setUser_phone2(upJoinForm.tf_phone2.getText());
			vo.setUser_phone3(upJoinForm.tf_phone3.getText());
			vo.setUser_addr(upJoinForm.tf_addr.getText());

			dao = new LibraryDAO();
			if (dao.update(vo)) {
				upJoinForm.showMsg("수정되었습니다.");
				upJoinForm.setVisible(false);
				serviceForm.setVisible(true);
			} else {
				upJoinForm.showMsg("입력된 데이터를 확인하세요.");
			}

		} else if (ob == upJoinForm.bt_cancel) {// 내 정보수정 창에서 취소 버튼을 누름 - 김지우

			upJoinForm.setVisible(false);
			serviceForm.setVisible(true);
		}

		// ==============================================================================
		/* 본진시작 */
		else if (ob == serviceForm_adm.bt_logout_adm) {
			serviceForm_adm.setVisible(false);
			loginForm.setVisible(true);
		} 
		else if (ob == serviceForm_adm.bt_room1_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(true);
			serviceForm_adm.p_room2_adm.setVisible(false);
			serviceForm_adm.p_room3_adm.setVisible(false);

			// 예약중인 자리 색깔변하기
			// SitVO list = new SitVO();
			ArrayList<SitVO> list = dao.sit_check();

			for (int i = 0; i < list.size(); i++) {
				SitVO vo = list.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 1) {
					serviceForm_adm.change_sitcolor_room1(sitnum);
				}
			}

			// DB에서 정보끌어와서 보여주기
			// d=displayTable 메소드
			serviceForm_adm.displayTable1(dao.Show_CurrentUser());

		}
		// 2열람실 누르면
		else if (ob == serviceForm_adm.bt_room2_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(false);
			serviceForm_adm.p_room2_adm.setVisible(true);
			serviceForm_adm.p_room3_adm.setVisible(false);

			// 예약중인 자리 색깔변하기
			// SitVO list = new SitVO();
			ArrayList<SitVO> list2 = dao.sit_check();
			for (int i = 0; i < list2.size(); i++) {
				SitVO vo = list2.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 2) {
					serviceForm_adm.change_sitcolor_room2(sitnum);
				}
			}

			serviceForm_adm.displayTable2(dao.Show_CurrentUser());
		}

		// 3열람실 누르면
		else if (ob == serviceForm_adm.bt_room3_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(false);
			serviceForm_adm.p_room2_adm.setVisible(false);
			serviceForm_adm.p_room3_adm.setVisible(true);

			// 예약중인 자리 색깔변하기
			// SitVO list = new SitVO();
			ArrayList<SitVO> list3 = dao.sit_check();
			for (int i = 0; i < list3.size(); i++) {
				SitVO vo = list3.get(i);
				int roomnum = vo.getRoom_num();
				int sitnum = vo.getSit_num();
				if (roomnum == 3) {
					serviceForm_adm.change_sitcolor_room3(sitnum);
				}
			}

			serviceForm_adm.displayTable3(dao.Show_CurrentUser());
		}

	}

	public static void main(String[] args) {
		new Controller();
	}

}
