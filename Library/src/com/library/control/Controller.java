package com.library.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.library.model.dao.LibraryDAO;
import com.library.model.vo.ReservationVO;
import com.library.model.vo.SitVO;
import com.library.model.vo.UserVO;
import com.library.view.AllmemberForm;
import com.library.view.JoinForm;
import com.library.view.LoginForm;
import com.library.view.SeatReserveSelectWindow;
import com.library.view.ServiceForm;
import com.library.view.ServiceForm_adm;
import com.library.view.UpJoinForm;
import com.library.view.UpJoinForm_adm;

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
//	      ====================0702 º»Áø===============================
		serviceForm_adm.bt_logout_adm.addActionListener(this);
		serviceForm_adm.bt_room1_adm.addActionListener(this);
		serviceForm_adm.bt_room2_adm.addActionListener(this);
		serviceForm_adm.bt_room3_adm.addActionListener(this);

//	      ====================º»Áø===============================
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
		joinForm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				joinForm.setVisible(false);
				loginForm.setVisible(true);
			}
		});
		
		//=========================================================
		//ÇÚµåÆù¹øÈ£ ÀÔ·Â½Ã  Æ÷Ä¿½º ÀÚµ¿À¸·Î ³Ñ°ÜÁÖ±â

		joinForm.tf_phone1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (joinForm.tf_phone1.getText().length() == 3) {
					joinForm.tf_phone2.requestFocus();
				}
			}
		});
		joinForm.tf_phone2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (joinForm.tf_phone2.getText().length() == 4) {
					joinForm.tf_phone3.requestFocus();
				}
			}
		});
		joinForm.tf_phone3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (joinForm.tf_phone3.getText().length() == 4) {
					joinForm.tf_addr.requestFocus();
				}
			}
		});
		//----------------------------------------------------------
		upJoinForm.tf_phone1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (upJoinForm.tf_phone1.getText().length() == 3) {
					upJoinForm.tf_phone2.requestFocus();
				}
			}
		});
		upJoinForm.tf_phone2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (upJoinForm.tf_phone2.getText().length() == 4) {
					upJoinForm.tf_phone3.requestFocus();
				}
			}
		});
		upJoinForm.tf_phone3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (upJoinForm.tf_phone3.getText().length() == 4) {
					upJoinForm.tf_addr.requestFocus();
				}
			}
		});
		//--------------------------------------------------------------
		
		upJoinForm_adm.tf_phone1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (upJoinForm_adm.tf_phone1.getText().length() == 3) {
					upJoinForm_adm.tf_phone2.requestFocus();
				}
			}
		});
		upJoinForm_adm.tf_phone2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (upJoinForm_adm.tf_phone2.getText().length() == 4) {
					upJoinForm_adm.tf_phone3.requestFocus();
				}
			}
		});
		upJoinForm_adm.tf_phone3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (upJoinForm_adm.tf_phone3.getText().length() == 4) {
					upJoinForm_adm.tf_addr.requestFocus();
				}
			}
		});
		

	}


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
				loginForm.showMsg("·Î±×ÀÎ ¼º°øÇß½À´Ï´Ù.");

				// serviceForm.displayTable(dao.findAll());

				serviceForm.loginId = id;

				// -----------------------------------------
				dao.upSit_tab();// Åð½Ç½Ã°£ Áö³­°Å sitÅ×ÀÌºí¿¡¼­ 1ÀÎ°Å 0À¸·Î ¹Ù²Ù±â
				dao.delres_tab();// Åð½Ç½Ã°£ Áö³­°Å »èÁ¦
				// -------------------------------------------

				loginForm.initText();// ·Î±×ÀÎ ¼º°ø½Ã ·Î±×ÀÎ Ã¢ ÃÊ±âÈ­

				loginForm.setVisible(false);
				serviceForm.setVisible(true);
				// ·Î±×ÀÎ ¼º°ø ÈÄ ¼­ºñ½º Æû ÀÌµ¿

				// seatreserveselectwindow.setVisible(true);
				id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);
				serviceForm.displayTable(dao.findMyres(user_num));

				// ¿¹¾àÁßÀÎ ÀÚ¸® »ö±òº¯ÇÏ±â
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

				loginForm.showMsg("¾ÆÀÌµð ¶Ç´Â ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù!!");
			}

		}

		else if (ob == loginForm.bt_manager) {
			String id = loginForm.tf_id.getText();
			String pass = new String(loginForm.tf_pass.getPassword());

			LibraryDAO dao = new LibraryDAO();

			if (dao.findAdmin(id, pass)) {
				loginForm.showMsg("°ü¸®ÀÚ ·Î±×ÀÎ ¼º°ø");

				// -----------------------------------------
				dao.upSit_tab();// Åð½Ç½Ã°£ Áö³­°Å sitÅ×ÀÌºí¿¡¼­ 1ÀÎ°Å 0À¸·Î ¹Ù²Ù±â
				dao.delres_tab();// Åð½Ç½Ã°£ Áö³­°Å »èÁ¦
				// -------------------------------------------

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

				// DB¿¡¼­ Á¤º¸²ø¾î¿Í¼­ º¸¿©ÁÖ±â
				// d=displayTable ¸Þ¼Òµå
				serviceForm_adm.displayTable1(dao.Show_CurrentUser());

			} else {
				loginForm.showMsg("°ü¸®ÀÚ ·Î±×ÀÎ ½ÇÆÐ");
			}

		}

		// ------------------------------------------------------±èÁö¿ì

		else if (ob == loginForm.bt_join) {// ·Î±×ÀÎÆû¿¡¼­ È¸¿ø°¡ÀÔ ¹öÆ°À» ´©¸§ - ±èÁö¿ì
			loginForm.setVisible(false);
			joinForm.setVisible(true);

		} else if (ob == joinForm.bt_submit) {// È¸¿ø°¡ÀÔÃ¢¿¡¼­ µî·Ï ¹öÆ°À» ´©¸§-±èÁö¿ì
			LibraryDAO dao = new LibraryDAO();

			UserVO vo = new UserVO();

			String id = joinForm.tf_id.getText();
			String pwd = new String(joinForm.tf_pwd.getPassword());
			String name = joinForm.tf_name.getText();
			String phone1 = joinForm.tf_phone1.getText().trim();
			String phone2 = joinForm.tf_phone2.getText().trim();
			String phone3 = joinForm.tf_phone3.getText().trim();
			String addr = joinForm.tf_addr.getText();

			vo.setUser_id(id);
			vo.setUser_pwd(pwd);
			vo.setUser_name(name);
			vo.setUser_phone1(phone1);
			vo.setUser_phone2(phone2);
			vo.setUser_phone3(phone3);
			vo.setUser_addr(addr);

			// Àß¸øµÈ ÀÔ·Â°ª¿¡ ÀÇÇÑ À¯È¿¼º °Ë»ç
			if (vo.getUser_pwd().equals("")) {
				joinForm.showMsg("ºñ¹Ð¹øÈ£´Â ¹Ýµå½Ã ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				joinForm.tf_pwd.requestFocus();
				return;
			} else if (!vo.getUser_pwd()
					.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$")) {
				joinForm.showMsg("ºñ¹Ð¹øÈ£´Â¼ýÀÚ, ¹®ÀÚ, Æ¯¼ö¹®ÀÚ(@,$,!,%,*,#,?,&) °¢°¢ 1°³ ÀÌ»ó Æ÷ÇÔÇÏ¿© ÃÖ¼Ò 8ÀÚ¸® ÀÌ»ó ÀÔ·ÂÇÏ¿©¾ß ÇÕ´Ï´Ù.");
				joinForm.tf_pwd.requestFocus();
				return;
			} else if (vo.getUser_name().equals("")) {
				joinForm.showMsg("ÀÌ¸§Àº ¹Ýµå½Ã ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_name().trim().matches("^[°¡-ÆR]*$")) {
				joinForm.showMsg("ÀÌ¸§Àº ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù. ¿Ã¹Ù¸¥ ÀÌ¸§À» ÀÔ·ÂÇÏ½Ê½Ã¿À. ");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_phone1().matches("^[\\d]*$") || !vo.getUser_phone2().matches("^[\\d]*$")
					|| !vo.getUser_phone3().matches("^[\\d]*$")) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ ¶õ¿¡´Â ¹®ÀÚ¸¦ ÀÔ·ÂÇÏ¸é ¾ÈµË´Ï´Ù.");
				return;
			} else if (vo.getUser_phone1().length() != 3) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ Ã¹¹øÂ° Ä­¿¡´Â 3ÀÚ¸®ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				return;
			} else if ((vo.getUser_phone2().length() != 4) || (vo.getUser_phone3().length()) != 4) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ µÎ¹øÂ°, ¼¼¹ø¤Š Ä­¿¡´Â 4ÀÚ¸®ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				return;
			} else {
				joinForm.showMsg("È¸¿ø°¡ÀÔ¿¡ ¼º°øÇÏ¿´½À´Ï´Ù. ·Î±×ÀÎÀ» ÇØ ÁÖ½Ê½Ã¿À.");
				dao.insert(vo);
				joinForm.setVisible(false);
				loginForm.setVisible(true);
			}

		} else if (ob == joinForm.bt_cancel) {// È¸¿ø°¡ÀÔÃ¢¿¡¼­ Ãë¼Ò ¹öÆ°À» ´©¸§-±èÁö¿ì
			joinForm.initText();
			joinForm.setVisible(false);
			loginForm.setVisible(true);

		} else if (ob == joinForm.bt_check) {// È¸¿ø°¡ÀÔÃ¢¿¡¼­ Áßº¹È®ÀÎ ¹öÆ°À» ´©¸§-±èÁö¿ì
			System.out.println("Áßº¹È®ÀÎ¹öÆ°");

			LibraryDAO dao = new LibraryDAO();

			String id = joinForm.showInput("¾ÆÀÌµð¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
			if (id == null) {
				return;
			}
			System.out.println("ÀÔ·ÂÇÑid=" + id);
			if (id.equals("")) {
				joinForm.showMsg("ºóÄ­Àº ÀÔ·ÂÇÒ¼ö ¾ø½À´Ï´Ù.");
				return;
			} else if (!id.trim().matches("^[a-zA-Z]*$")) {
				joinForm.showMsg("¾ÆÀÌµð´Â ¿µ¹®ÀÚ·Î ±¸¼ºµÇ¾î¾ß ÇÕ´Ï´Ù. ´Ù½Ã Áßº¹È®ÀÎÀ» ÇØÁÖ½Ê½Ã¿À.");
				return;
			} else {
				System.out.println(dao.findExistId(id));
				if (id.trim() != null) {
					if (dao.findExistId(id) > 0) {
						joinForm.showMsg("ÀÌ¹Ì »ç¿ëÁßÀÎ ¾ÆÀÌµðÀÔ´Ï´Ù!!");
					} else {
						joinForm.showMsg("±× ¾ÆÀÌµð´Â »ç¿ë°¡´ÉÇÕ´Ï´Ù.");
						if (joinForm.showConfirm("ÀÌ ¾ÆÀÌµð¸¦ »ç¿ëÇÏ½Ã°Ú½À´Ï±î?") == 0) {
							joinForm.tf_id.setText(id);
							joinForm.bt_submit.setEnabled(true);
						}
					}
				}
			}
		} else if (ob == upJoinForm.bt_cancel) {// ³» Á¤º¸¼öÁ¤ Ã¢¿¡¼­ Ãë¼Ò ¹öÆ°À» ´©¸§ - ±èÁö¿ì

			upJoinForm.setVisible(false);
			serviceForm.setVisible(true);
		}

		// ---------------------------------------------------------------------------
		// ÀÌÁøÁÖ

		else if (ob == serviceForm.bt_reserv) {// ¼­ºñ½ºÆû¿¡¼­ ¿¹¾à¹öÆ°´©¸¦°æ¿ì -ÀÌÁøÁÖ
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

//			SeatReserveSelectWindowÀÌ ¿­¸®¸é ÀÚµ¿À¸·Î Åð½Ç½Ã°£-ÇöÀç½Ã°£ Á¦¿ÜÇÑ ¿¹¾àÅ×ÀÌºí¿¡ ¿¹¾àÇÑ »ç¶÷µé ¹öÆ°»ö º¯°æÇØÁÖ±â

		} else if (ob == seatForm.bt_room1) {// SeatReserveSelectWindow¿¡¼­ ¿­¶÷½Ç1¹öÆ° ´­·¶À»°æ¿ì -ÀÌÁøÁÖ
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

//			1¿­¶÷½Ç true·Î ¸¸µé¾îÁÖ±â

		} else if (ob == seatForm.bt_room2) {// SeatReserveSelectWindow¿¡¼­ ¿­¶÷½Ç2¹öÆ° ´­·¶À»°æ¿ì -ÀÌÁøÁÖ

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

//			2¿­¶÷½Ç  true·Î ¸¸µé¾îÁÖ±â

		} else if (ob == seatForm.bt_room3) {// SeatReserveSelectWindow¿¡¼­ ¿­¶÷½Ç3¹öÆ° ´­·¶À»°æ¿ì -ÀÌÁøÁÖ

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

		} else if (ob == seatForm.bt_logout) {// SeatReserveSelectWindow¿¡¼­ ·Î±×¾Æ¿ô ¹öÆ° ´­·¶À»°æ¿ì -ÀÌÁøÁÖ

			if (seatForm.showConfirm("·Î±×¾Æ¿ô ÇÏ½Ã°Ú½À´Ï±î?") == 0) {
				seatForm.setVisible(false);
				loginForm.setVisible(true);
				serviceForm.loginId = "";
			}
		} else if (ob == seatForm.bt_reserve) {// ¿¹¾à¹öÆ° ´©¸¦½Ã -ÀÌÁøÁÖ
			LibraryDAO dao = new LibraryDAO();
			String id = serviceForm.loginId;
			int cnt = dao.countRes(dao.findusernumByid(id));
			if (cnt == 0) {// ·Î±×ÀÎÇÑ À¯Àú°¡ ¿¹¾àÇÑ ÀÚ¸®°¡ ¾øÀ» ¶§
				String pattern = "^[1-9]{1}$|^1{1}[0-9]{1}$|^2{1}[0-7]{1}";
				String sitNum = seatForm.showInput("¿¹¾àÇÏ½Ç ÁÂ¼®¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
				System.out.println(sitNum);
				if (sitNum == null) {
					return;
				}
				if (sitNum.matches(pattern)) {// ¼ýÀÚ¸¸
					int sit_num = Integer.parseInt(sitNum);
					ReservationVO reservationvo = new ReservationVO();
					UserVO uservo = new UserVO();
					SitVO sitvo = new SitVO();

					// ½Ã°£°è»êÇÏ±â

					long retryDate = System.currentTimeMillis();
					Timestamp sit_start = new Timestamp(retryDate);
					Calendar cal = Calendar.getInstance();
					cal.setTimeInMillis(sit_start.getTime());
					cal.add(Calendar.HOUR, 4);
					Timestamp sit_end = new Timestamp(cal.getTime().getTime());
//					System.out.println("one>>>"+ one+", two>>>"+ two+ ", three>>>"+ three);

					// ¿¹¾àÁÂ¼®¹øÈ£¸¦ ¹Þ¾Æ¿Â »óÈ²

					if (dao.checkSit(sit_num).equals("success")) {
						// ÇØ´ç ÁÂ¼®¿¡ ¿¹¾àµÈ »ç¶÷ÀÌ ¾øÀ»¶§
						// ¿¹¾àÁøÇà
						reservationvo.setSit_num(sit_num);
						reservationvo.setSit_start(sit_start);
						reservationvo.setSit_end(sit_end);

						reservationvo.setUser_num(dao.findusernumByid(id));

						if (dao.reserveInto(reservationvo)) {
							// ¿¹¾àÅ×ÀÌºí¿¡ ¼º°øÀûÀ¸·Î µé¾î°¨
							boolean ch = dao.reserveSit_t(sit_num);
							System.out.println(ch);
							// ÁÂ¼®Å×ÀÌºí 1·Î ¹Ù²Ù±â
							seatForm.showMsg("¿¹¾à¼º°ø");

							// ¿¹¾àÆû ÁÂ¼®»ö º¯°æ
							ArrayList<SitVO> list = dao.sit_check();
							for (int i = 0; i < list.size(); i++) {
								SitVO vo = list.get(i);
								int roomnum = vo.getRoom_num();
								int sitnum = vo.getSit_num();
								if (roomnum == 1) {
									seatForm.change_sitcolor_room1(sitnum);
								} else if (roomnum == 2) {
									seatForm.change_sitcolor_room1(sitnum);
								} else if (roomnum == 3) {
									seatForm.change_sitcolor_room1(sitnum);
								}
							}

							System.out.println(sit_num);

						} else {
							// ¿¹¾àÅ×ÀÌºí¿¡ ÀÔ·Â ½ÇÆÐ
							seatForm.showMsg("¿¹¾à½ÇÆÐ");
						}
					} else {
						// ÇØ´ç ÁÂ¼®¿¡ ¿¹¾àµÈ »ç¶÷ÀÌ ÀÖÀ» ¶§
						seatForm.showMsg("ÀÌ¹Ì ¿¹¾àµÈ ¹øÈ£ÀÔ´Ï´Ù.");
					}
				} else {
					seatForm.showMsg("1~27±îÁöÀÇ ÁÂ¼®¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
				}
			} else {
				seatForm.showMsg("ÀÌ¹Ì ÁÂ¼®À» ¿¹¾àÇÏ¼Ì½À´Ï´Ù.");
			}

		} // ¿¹¾à¹öÆ° ´©¸¦½Ã ³¡
		else if (ob == seatForm.bt_cancel) {// SeatReserveSelectWindow¿¡¼­ Ãë¼Ò¹öÆ° ´©¸¥°æ¿ì -ÀÌÁøÁÖ
			seatForm.setVisible(false);
			serviceForm.setVisible(true);
			LibraryDAO dao = new LibraryDAO();

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

			String id = loginForm.tf_id.getText();
			id = serviceForm.loginId;
			int user_num = dao.findusernumByid(id);
			serviceForm.displayTable(dao.findMyres(user_num));
		}

		// ----------------------------------------------------------------------À±À¯ºó

		else if (ob == serviceForm.bt_room1) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm.p_room1.setVisible(true);
			serviceForm.p_room2.setVisible(false);
			serviceForm.p_room3.setVisible(false);

			// ¿¹¾àÁßÀÎ ÀÚ¸® »ö±òº¯ÇÏ±â
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

			// ¿¹¾àÁßÀÎ ÀÚ¸® »ö±òº¯ÇÏ±â
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
			// ¿¹¾àÁßÀÎ ÀÚ¸® »ö±òº¯ÇÏ±â
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

		} else if (ob == serviceForm.bt_myinfo) { // ³» Á¤º¸ ¹öÆ°
			LibraryDAO dao = new LibraryDAO();
			upJoinForm.setVisible(true);
			String id = serviceForm.loginId;

			upJoinForm.initText(dao.findByid(id));

		} else if (ob == serviceForm.bt_logout) {// ·Î±×¾Æ¿ô ¹öÆ°
			loginForm.setVisible(true);
			serviceForm.setVisible(false);
			serviceForm.loginId = "";
		} else if (ob == serviceForm.bt_out) {// Åð½Ç¹öÆ°
			LibraryDAO dao = new LibraryDAO();
			if (serviceForm.showConfirm("Á¤¸» Åð½Ç ÇÏ½Ã°Ú½À´Ï±î?") == 0) {
				String id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);
				if (dao.sitcheckchange(user_num)) {// »èÁ¦ ¼º°ø½Ã
					dao.deleteres(user_num);

					serviceForm.displayTable(dao.findMyres(user_num));
					// -----------------------³» ¿¹¾à¸ñ·Ï ÃÊ±âÈ­

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
					// Åð½Ç ¼º°ø½Ã ¹öÆ°»ö±ò ÃÊ±âÈ­ ¼­ºñ½ºÆû

					for (int i = 0; i < list.size(); i++) {

						SitVO vo = list.get(i);

						int roomnum = vo.getRoom_num();
						int sitnum = vo.getSit_num();
						if (roomnum == 1) {
							seatForm.change_sitdefault_room1(sitnum);
						} else if (roomnum == 2) {
							seatForm.change_sitdefault_room2(sitnum);
						} else if (roomnum == 3) {
							seatForm.change_sitdefault_room3(sitnum);
						}
					}

					// ¿¹¾àÆû ÁÂ¼® »ö º¯°æ
					serviceForm.showMsg("Åð½Ç¿¡ ¼º°øÇÏ¿´½À´Ï´Ù!!");
				} else {
					serviceForm.showMsg("Åð½Ç¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù!!");
				}
			} else {
				serviceForm.showMsg("Åð½Ç¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù!!");
			}

		} else if (ob == serviceForm.bt_cont) {
			LibraryDAO dao = new LibraryDAO();
			if (serviceForm.showConfirm("¿¬Àå ÇÏ½Ã°Ú½À´Ï±î?") == 0) {
				String id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);

				if (dao.timeextension(user_num)) {// ¿¬Àå ¼º°ø½Ã
					serviceForm.displayTable(dao.findMyres(user_num));
					serviceForm.showMsg("½Ã°£¿¬Àå¿¡ ¼º°øÇÏ¿´½À´Ï´Ù!!");
				} else {
					serviceForm.showMsg("½Ã°£¿¬Àå¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù!!");
				}

			}

		}

		// --------------------------------------------------------------------

		else if (ob == serviceForm_adm.bt_allCustom) {// °ü¸®ÀÚ Ã¢¿¡¼­ ¸ðµç È¸¿ø Á¤º¸º¸±â ´­·¶À»¶§
			LibraryDAO dao = new LibraryDAO();
			allmemberForm.displayTable(dao.findAll());
			serviceForm_adm.setVisible(false);
			allmemberForm.setVisible(true);

		} else if (ob == allmemberForm.bt_sel_name) {// °Ë»ö ´­·¶À»¶§
			LibraryDAO dao = new LibraryDAO();
			String name = allmemberForm.showInput("Á¶È¸ÇÒ ÀÌ¸§:");
			if (name == null) {
				return;
			}
			allmemberForm.displayTable(dao.findByName(name));

		} else if (ob == allmemberForm.bt_up) {
			LibraryDAO dao = new LibraryDAO();
			String user_id = allmemberForm.showInput("¼öÁ¤ÇÒ ¾ÆÀÌµð:");
			UserVO vo = dao.findByid(user_id);
			if (user_id == null) {
				return;
			}
			if (vo == null) {
				allmemberForm.showMsg("Á¸ÀçÇÏÁö ¾Ê´Â ¾ÆÀÌµðÀÔ´Ï´Ù.");
				return;
			}
			upJoinForm_adm.initText(vo);
			upJoinForm_adm.setVisible(true);

		} else if (ob == allmemberForm.bt_del) {// »èÁ¦ ´­·¶À»¶§
			LibraryDAO dao = new LibraryDAO();
			String user_id;
			user_id = allmemberForm.showInput("»èÁ¦ÇÒ ¾ÆÀÌµð:");
			dao = new LibraryDAO();
			if (user_id == null) {
				return;
			}
			if (allmemberForm.showConfirm("Á¤¸» »èÁ¦/Å»Åð ÇÏ½Ã°Ú½À´Ï±î?") == 0) {
				if (dao.remove(user_id)) {
					allmemberForm.displayTable(dao.findAll());
				} else {
					allmemberForm.showMsg("»èÁ¦¿¡ ½ÇÆÐÇß½À´Ï´Ù.\n»èÁ¦ÇÒ ¾ÆÀÌµð¸¦ ´Ù½Ã È®ÀÎÇØÁÖ¼¼¿ä");
				}
			}

		} else if (ob == allmemberForm.bt_exit) {// ³ª°¡±â ´­·¶À»¶§
			allmemberForm.setVisible(false);
			serviceForm_adm.setVisible(true);

		} else if (ob == upJoinForm_adm.bt_submit) {// ¼öÁ¤¹öÆ° ´©¸¥ ÈÄ °ü¸®ÀÚ¸¸ÀÇ È¸¿ø ¼öÁ¤ Æû¿¡¼­ µî·Ï ´­·¶À»¶§
			LibraryDAO dao = new LibraryDAO();
			UserVO vo = new UserVO();
			vo.setUser_id(upJoinForm_adm.tf_id.getText());
			vo.setUser_name(upJoinForm_adm.tf_name.getText());
			vo.setUser_phone1(upJoinForm_adm.tf_phone1.getText());
			vo.setUser_phone2(upJoinForm_adm.tf_phone2.getText());
			vo.setUser_phone3(upJoinForm_adm.tf_phone3.getText());
			vo.setUser_addr(upJoinForm_adm.tf_addr.getText());
			dao = new LibraryDAO();

			if (vo.getUser_name().equals("")) {
				joinForm.showMsg("ÀÌ¸§Àº ¹Ýµå½Ã ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_name().trim().matches("^[°¡-ÆR]*$")) {
				joinForm.showMsg("ÀÌ¸§Àº ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù. ¿Ã¹Ù¸¥ ÀÌ¸§À» ÀÔ·ÂÇÏ½Ê½Ã¿À. ");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_phone1().matches("^[\\d]*$") || !vo.getUser_phone2().matches("^[\\d]*$")
					|| !vo.getUser_phone3().matches("^[\\d]*$")) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ ¶õ¿¡´Â ¹®ÀÚ¸¦ ÀÔ·ÂÇÏ¸é ¾ÈµË´Ï´Ù.");
				return;
			} else if (vo.getUser_phone1().length() != 3) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ Ã¹¹øÂ° Ä­¿¡´Â 3ÀÚ¸®ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				return;
			} else if ((vo.getUser_phone2().length() != 4) || (vo.getUser_phone3().length()) != 4) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ µÎ¹øÂ°, ¼¼¹ø¤Š Ä­¿¡´Â 4ÀÚ¸®ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				return;
			} else if (vo.getUser_addr().equals("")) {
				joinForm.showMsg("ÁÖ¼Ò¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				joinForm.tf_addr.requestFocus();
				return;
			}

			if (dao.modify(vo)) {
				allmemberForm.displayTable(dao.findAll());
				upJoinForm_adm.setVisible(false);
				allmemberForm.setVisible(true);
			}

		} else if (ob == upJoinForm_adm.bt_cancle) {// ¼öÁ¤¹öÆ° ´©¸¥ ÈÄ °ü¸®ÀÚ¸¸ÀÇ È¸¿ø ¼öÁ¤ Æû¿¡¼­ Ãë¼Ò ´­·¶À»¶§
			upJoinForm_adm.setVisible(false);
			allmemberForm.setVisible(true);
		}

		else if (ob == upJoinForm.bt_submit) {// ³»Á¤º¸¼öÁ¤ Ã¢¿¡¼­ ¼öÁ¤¿Ï·á ¹öÆ°À» ´©¸§-±èÁö¿ì

			UserVO vo = new UserVO();
			LibraryDAO dao = new LibraryDAO();
			vo.setUser_id(upJoinForm.tf_id.getText());

			vo.setUser_name(upJoinForm.tf_name.getText());

			vo.setUser_pwd(new String(upJoinForm.tf_pwd.getPassword()));
			vo.setUser_phone1(upJoinForm.tf_phone1.getText());
			vo.setUser_phone2(upJoinForm.tf_phone2.getText());
			vo.setUser_phone3(upJoinForm.tf_phone3.getText());
			vo.setUser_addr(upJoinForm.tf_addr.getText());

			if (vo.getUser_pwd().equals("")) {
				joinForm.showMsg("ºñ¹Ð¹øÈ£´Â ¹Ýµå½Ã ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				joinForm.tf_pwd.requestFocus();
				return;
			} else if (!vo.getUser_pwd()
					.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$")) {
				joinForm.showMsg("ºñ¹Ð¹øÈ£´Â¼ýÀÚ, ¹®ÀÚ, Æ¯¼ö¹®ÀÚ(@,$,!,%,*,#,?,&) °¢°¢ 1°³ ÀÌ»ó Æ÷ÇÔÇÏ¿© ÃÖ¼Ò 8ÀÚ¸® ÀÌ»ó ÀÔ·ÂÇÏ¿©¾ß ÇÕ´Ï´Ù.");
				joinForm.tf_pwd.requestFocus();
				return;
			} else if (vo.getUser_name().equals("")) {
				joinForm.showMsg("ÀÌ¸§Àº ¹Ýµå½Ã ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_name().trim().matches("^[°¡-ÆR]*$")) {
				joinForm.showMsg("ÀÌ¸§Àº ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù. ¿Ã¹Ù¸¥ ÀÌ¸§À» ÀÔ·ÂÇÏ½Ê½Ã¿À. ");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_phone1().matches("^[\\d]*$") || !vo.getUser_phone2().matches("^[\\d]*$")
					|| !vo.getUser_phone3().matches("^[\\d]*$")) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ ¶õ¿¡´Â ¹®ÀÚ¸¦ ÀÔ·ÂÇÏ¸é ¾ÈµË´Ï´Ù.");
				return;
			} else if (vo.getUser_phone1().length() != 3) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ Ã¹¹øÂ° Ä­¿¡´Â 3ÀÚ¸®ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				return;
			} else if ((vo.getUser_phone2().length() != 4) || (vo.getUser_phone3().length()) != 4) {
				joinForm.showMsg("ÀüÈ­¹øÈ£ µÎ¹øÂ°, ¼¼¹ø¤Š Ä­¿¡´Â 4ÀÚ¸®ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØ¾ß ÇÕ´Ï´Ù.");
				return;
			} else {

				if (dao.update(vo)) {
					upJoinForm.showMsg("¼öÁ¤µÇ¾ú½À´Ï´Ù.");
					upJoinForm.setVisible(false);
					serviceForm.setVisible(true);
				} else {
					upJoinForm.showMsg("¼öÁ¤¿¡ ½ÇÆÐÇß½À´Ï´Ù.");
				}

			}

		} else if (ob == upJoinForm.bt_cancel) {// ³» Á¤º¸¼öÁ¤ Ã¢¿¡¼­ Ãë¼Ò ¹öÆ°À» ´©¸§ - ±èÁö¿ì

			upJoinForm.setVisible(false);
			serviceForm.setVisible(true);
		}

		// ==============================================================================
		/* º»Áø½ÃÀÛ */
		else if (ob == serviceForm_adm.bt_logout_adm) {
			joinForm.initText();
			serviceForm_adm.setVisible(false);
			loginForm.setVisible(true);
		} else if (ob == serviceForm_adm.bt_room1_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(true);
			serviceForm_adm.p_room2_adm.setVisible(false);
			serviceForm_adm.p_room3_adm.setVisible(false);

			// ¿¹¾àÁßÀÎ ÀÚ¸® »ö±òº¯ÇÏ±â
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

			// DB¿¡¼­ Á¤º¸²ø¾î¿Í¼­ º¸¿©ÁÖ±â
			// d=displayTable ¸Þ¼Òµå
			serviceForm_adm.displayTable1(dao.Show_CurrentUser());

		}
		// 2¿­¶÷½Ç ´©¸£¸é
		else if (ob == serviceForm_adm.bt_room2_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(false);
			serviceForm_adm.p_room2_adm.setVisible(true);
			serviceForm_adm.p_room3_adm.setVisible(false);

			// ¿¹¾àÁßÀÎ ÀÚ¸® »ö±òº¯ÇÏ±â
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

		// 3¿­¶÷½Ç ´©¸£¸é
		else if (ob == serviceForm_adm.bt_room3_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(false);
			serviceForm_adm.p_room2_adm.setVisible(false);
			serviceForm_adm.p_room3_adm.setVisible(true);

			// ¿¹¾àÁßÀÎ ÀÚ¸® »ö±òº¯ÇÏ±â
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
