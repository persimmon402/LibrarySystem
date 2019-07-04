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
//	      ====================0702 ����===============================
		serviceForm_adm.bt_logout_adm.addActionListener(this);
		serviceForm_adm.bt_room1_adm.addActionListener(this);
		serviceForm_adm.bt_room2_adm.addActionListener(this);
		serviceForm_adm.bt_room3_adm.addActionListener(this);

//	      ====================����===============================
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
		//�ڵ�����ȣ �Է½�  ��Ŀ�� �ڵ����� �Ѱ��ֱ�

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
				loginForm.showMsg("�α��� �����߽��ϴ�.");

				// serviceForm.displayTable(dao.findAll());

				serviceForm.loginId = id;

				// -----------------------------------------
				dao.upSit_tab();// ��ǽð� ������ sit���̺��� 1�ΰ� 0���� �ٲٱ�
				dao.delres_tab();// ��ǽð� ������ ����
				// -------------------------------------------

				loginForm.initText();// �α��� ������ �α��� â �ʱ�ȭ

				loginForm.setVisible(false);
				serviceForm.setVisible(true);
				// �α��� ���� �� ���� �� �̵�

				// seatreserveselectwindow.setVisible(true);
				id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);
				serviceForm.displayTable(dao.findMyres(user_num));

				// �������� �ڸ� �����ϱ�
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

				loginForm.showMsg("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�!!");
			}

		}

		else if (ob == loginForm.bt_manager) {
			String id = loginForm.tf_id.getText();
			String pass = new String(loginForm.tf_pass.getPassword());

			LibraryDAO dao = new LibraryDAO();

			if (dao.findAdmin(id, pass)) {
				loginForm.showMsg("������ �α��� ����");

				// -----------------------------------------
				dao.upSit_tab();// ��ǽð� ������ sit���̺��� 1�ΰ� 0���� �ٲٱ�
				dao.delres_tab();// ��ǽð� ������ ����
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

				// DB���� ��������ͼ� �����ֱ�
				// d=displayTable �޼ҵ�
				serviceForm_adm.displayTable1(dao.Show_CurrentUser());

			} else {
				loginForm.showMsg("������ �α��� ����");
			}

		}

		// ------------------------------------------------------������

		else if (ob == loginForm.bt_join) {// �α��������� ȸ������ ��ư�� ���� - ������
			loginForm.setVisible(false);
			joinForm.setVisible(true);

		} else if (ob == joinForm.bt_submit) {// ȸ������â���� ��� ��ư�� ����-������
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

			// �߸��� �Է°��� ���� ��ȿ�� �˻�
			if (vo.getUser_pwd().equals("")) {
				joinForm.showMsg("��й�ȣ�� �ݵ�� �Է��ؾ� �մϴ�.");
				joinForm.tf_pwd.requestFocus();
				return;
			} else if (!vo.getUser_pwd()
					.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$")) {
				joinForm.showMsg("��й�ȣ�¼���, ����, Ư������(@,$,!,%,*,#,?,&) ���� 1�� �̻� �����Ͽ� �ּ� 8�ڸ� �̻� �Է��Ͽ��� �մϴ�.");
				joinForm.tf_pwd.requestFocus();
				return;
			} else if (vo.getUser_name().equals("")) {
				joinForm.showMsg("�̸��� �ݵ�� �Է��ؾ� �մϴ�.");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_name().trim().matches("^[��-�R]*$")) {
				joinForm.showMsg("�̸��� �ѱ۸� �Է� �����մϴ�. �ùٸ� �̸��� �Է��Ͻʽÿ�. ");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_phone1().matches("^[\\d]*$") || !vo.getUser_phone2().matches("^[\\d]*$")
					|| !vo.getUser_phone3().matches("^[\\d]*$")) {
				joinForm.showMsg("��ȭ��ȣ ������ ���ڸ� �Է��ϸ� �ȵ˴ϴ�.");
				return;
			} else if (vo.getUser_phone1().length() != 3) {
				joinForm.showMsg("��ȭ��ȣ ù��° ĭ���� 3�ڸ��� ���ڸ� �Է��ؾ� �մϴ�.");
				return;
			} else if ((vo.getUser_phone2().length() != 4) || (vo.getUser_phone3().length()) != 4) {
				joinForm.showMsg("��ȭ��ȣ �ι�°, ������ ĭ���� 4�ڸ��� ���ڸ� �Է��ؾ� �մϴ�.");
				return;
			} else {
				joinForm.showMsg("ȸ�����Կ� �����Ͽ����ϴ�. �α����� �� �ֽʽÿ�.");
				dao.insert(vo);
				joinForm.setVisible(false);
				loginForm.setVisible(true);
			}

		} else if (ob == joinForm.bt_cancel) {// ȸ������â���� ��� ��ư�� ����-������
			joinForm.initText();
			joinForm.setVisible(false);
			loginForm.setVisible(true);

		} else if (ob == joinForm.bt_check) {// ȸ������â���� �ߺ�Ȯ�� ��ư�� ����-������
			System.out.println("�ߺ�Ȯ�ι�ư");

			LibraryDAO dao = new LibraryDAO();

			String id = joinForm.showInput("���̵� �Է��ϼ���.");
			if (id == null) {
				return;
			}
			System.out.println("�Է���id=" + id);
			if (id.equals("")) {
				joinForm.showMsg("��ĭ�� �Է��Ҽ� �����ϴ�.");
				return;
			} else if (!id.trim().matches("^[a-zA-Z]*$")) {
				joinForm.showMsg("���̵�� �����ڷ� �����Ǿ�� �մϴ�. �ٽ� �ߺ�Ȯ���� ���ֽʽÿ�.");
				return;
			} else {
				System.out.println(dao.findExistId(id));
				if (id.trim() != null) {
					if (dao.findExistId(id) > 0) {
						joinForm.showMsg("�̹� ������� ���̵��Դϴ�!!");
					} else {
						joinForm.showMsg("�� ���̵�� ��밡���մϴ�.");
						if (joinForm.showConfirm("�� ���̵� ����Ͻðڽ��ϱ�?") == 0) {
							joinForm.tf_id.setText(id);
							joinForm.bt_submit.setEnabled(true);
						}
					}
				}
			}
		} else if (ob == upJoinForm.bt_cancel) {// �� �������� â���� ��� ��ư�� ���� - ������

			upJoinForm.setVisible(false);
			serviceForm.setVisible(true);
		}

		// ---------------------------------------------------------------------------
		// ������

		else if (ob == serviceForm.bt_reserv) {// ���������� �����ư������� -������
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

//			SeatReserveSelectWindow�� ������ �ڵ����� ��ǽð�-����ð� ������ �������̺� ������ ����� ��ư�� �������ֱ�

		} else if (ob == seatForm.bt_room1) {// SeatReserveSelectWindow���� ������1��ư ��������� -������
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

//			1������ true�� ������ֱ�

		} else if (ob == seatForm.bt_room2) {// SeatReserveSelectWindow���� ������2��ư ��������� -������

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

//			2������  true�� ������ֱ�

		} else if (ob == seatForm.bt_room3) {// SeatReserveSelectWindow���� ������3��ư ��������� -������

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

		} else if (ob == seatForm.bt_logout) {// SeatReserveSelectWindow���� �α׾ƿ� ��ư ��������� -������

			if (seatForm.showConfirm("�α׾ƿ� �Ͻðڽ��ϱ�?") == 0) {
				seatForm.setVisible(false);
				loginForm.setVisible(true);
				serviceForm.loginId = "";
			}
		} else if (ob == seatForm.bt_reserve) {// �����ư ������ -������
			LibraryDAO dao = new LibraryDAO();
			String id = serviceForm.loginId;
			int cnt = dao.countRes(dao.findusernumByid(id));
			if (cnt == 0) {// �α����� ������ ������ �ڸ��� ���� ��
				String pattern = "^[1-9]{1}$|^1{1}[0-9]{1}$|^2{1}[0-7]{1}";
				String sitNum = seatForm.showInput("�����Ͻ� �¼���ȣ�� �Է��ϼ���");
				System.out.println(sitNum);
				if (sitNum == null) {
					return;
				}
				if (sitNum.matches(pattern)) {// ���ڸ�
					int sit_num = Integer.parseInt(sitNum);
					ReservationVO reservationvo = new ReservationVO();
					UserVO uservo = new UserVO();
					SitVO sitvo = new SitVO();

					// �ð�����ϱ�

					long retryDate = System.currentTimeMillis();
					Timestamp sit_start = new Timestamp(retryDate);
					Calendar cal = Calendar.getInstance();
					cal.setTimeInMillis(sit_start.getTime());
					cal.add(Calendar.HOUR, 4);
					Timestamp sit_end = new Timestamp(cal.getTime().getTime());
//					System.out.println("one>>>"+ one+", two>>>"+ two+ ", three>>>"+ three);

					// �����¼���ȣ�� �޾ƿ� ��Ȳ

					if (dao.checkSit(sit_num).equals("success")) {
						// �ش� �¼��� ����� ����� ������
						// ��������
						reservationvo.setSit_num(sit_num);
						reservationvo.setSit_start(sit_start);
						reservationvo.setSit_end(sit_end);

						reservationvo.setUser_num(dao.findusernumByid(id));

						if (dao.reserveInto(reservationvo)) {
							// �������̺� ���������� ��
							boolean ch = dao.reserveSit_t(sit_num);
							System.out.println(ch);
							// �¼����̺� 1�� �ٲٱ�
							seatForm.showMsg("���༺��");

							// ������ �¼��� ����
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
							// �������̺� �Է� ����
							seatForm.showMsg("�������");
						}
					} else {
						// �ش� �¼��� ����� ����� ���� ��
						seatForm.showMsg("�̹� ����� ��ȣ�Դϴ�.");
					}
				} else {
					seatForm.showMsg("1~27������ �¼��� �Է��� �ּ���");
				}
			} else {
				seatForm.showMsg("�̹� �¼��� �����ϼ̽��ϴ�.");
			}

		} // �����ư ������ ��
		else if (ob == seatForm.bt_cancel) {// SeatReserveSelectWindow���� ��ҹ�ư ������� -������
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

		// ----------------------------------------------------------------------������

		else if (ob == serviceForm.bt_room1) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm.p_room1.setVisible(true);
			serviceForm.p_room2.setVisible(false);
			serviceForm.p_room3.setVisible(false);

			// �������� �ڸ� �����ϱ�
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

			// �������� �ڸ� �����ϱ�
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
			// �������� �ڸ� �����ϱ�
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

		} else if (ob == serviceForm.bt_myinfo) { // �� ���� ��ư
			LibraryDAO dao = new LibraryDAO();
			upJoinForm.setVisible(true);
			String id = serviceForm.loginId;

			upJoinForm.initText(dao.findByid(id));

		} else if (ob == serviceForm.bt_logout) {// �α׾ƿ� ��ư
			loginForm.setVisible(true);
			serviceForm.setVisible(false);
			serviceForm.loginId = "";
		} else if (ob == serviceForm.bt_out) {// ��ǹ�ư
			LibraryDAO dao = new LibraryDAO();
			if (serviceForm.showConfirm("���� ��� �Ͻðڽ��ϱ�?") == 0) {
				String id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);
				if (dao.sitcheckchange(user_num)) {// ���� ������
					dao.deleteres(user_num);

					serviceForm.displayTable(dao.findMyres(user_num));
					// -----------------------�� ������ �ʱ�ȭ

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
					// ��� ������ ��ư���� �ʱ�ȭ ������

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

					// ������ �¼� �� ����
					serviceForm.showMsg("��ǿ� �����Ͽ����ϴ�!!");
				} else {
					serviceForm.showMsg("��ǿ� �����Ͽ����ϴ�!!");
				}
			} else {
				serviceForm.showMsg("��ǿ� �����Ͽ����ϴ�!!");
			}

		} else if (ob == serviceForm.bt_cont) {
			LibraryDAO dao = new LibraryDAO();
			if (serviceForm.showConfirm("���� �Ͻðڽ��ϱ�?") == 0) {
				String id = serviceForm.loginId;
				int user_num = dao.findusernumByid(id);

				if (dao.timeextension(user_num)) {// ���� ������
					serviceForm.displayTable(dao.findMyres(user_num));
					serviceForm.showMsg("�ð����忡 �����Ͽ����ϴ�!!");
				} else {
					serviceForm.showMsg("�ð����忡 �����Ͽ����ϴ�!!");
				}

			}

		}

		// --------------------------------------------------------------------

		else if (ob == serviceForm_adm.bt_allCustom) {// ������ â���� ��� ȸ�� �������� ��������
			LibraryDAO dao = new LibraryDAO();
			allmemberForm.displayTable(dao.findAll());
			serviceForm_adm.setVisible(false);
			allmemberForm.setVisible(true);

		} else if (ob == allmemberForm.bt_sel_name) {// �˻� ��������
			LibraryDAO dao = new LibraryDAO();
			String name = allmemberForm.showInput("��ȸ�� �̸�:");
			if (name == null) {
				return;
			}
			allmemberForm.displayTable(dao.findByName(name));

		} else if (ob == allmemberForm.bt_up) {
			LibraryDAO dao = new LibraryDAO();
			String user_id = allmemberForm.showInput("������ ���̵�:");
			UserVO vo = dao.findByid(user_id);
			if (user_id == null) {
				return;
			}
			if (vo == null) {
				allmemberForm.showMsg("�������� �ʴ� ���̵��Դϴ�.");
				return;
			}
			upJoinForm_adm.initText(vo);
			upJoinForm_adm.setVisible(true);

		} else if (ob == allmemberForm.bt_del) {// ���� ��������
			LibraryDAO dao = new LibraryDAO();
			String user_id;
			user_id = allmemberForm.showInput("������ ���̵�:");
			dao = new LibraryDAO();
			if (user_id == null) {
				return;
			}
			if (allmemberForm.showConfirm("���� ����/Ż�� �Ͻðڽ��ϱ�?") == 0) {
				if (dao.remove(user_id)) {
					allmemberForm.displayTable(dao.findAll());
				} else {
					allmemberForm.showMsg("������ �����߽��ϴ�.\n������ ���̵� �ٽ� Ȯ�����ּ���");
				}
			}

		} else if (ob == allmemberForm.bt_exit) {// ������ ��������
			allmemberForm.setVisible(false);
			serviceForm_adm.setVisible(true);

		} else if (ob == upJoinForm_adm.bt_submit) {// ������ư ���� �� �����ڸ��� ȸ�� ���� ������ ��� ��������
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
				joinForm.showMsg("�̸��� �ݵ�� �Է��ؾ� �մϴ�.");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_name().trim().matches("^[��-�R]*$")) {
				joinForm.showMsg("�̸��� �ѱ۸� �Է� �����մϴ�. �ùٸ� �̸��� �Է��Ͻʽÿ�. ");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_phone1().matches("^[\\d]*$") || !vo.getUser_phone2().matches("^[\\d]*$")
					|| !vo.getUser_phone3().matches("^[\\d]*$")) {
				joinForm.showMsg("��ȭ��ȣ ������ ���ڸ� �Է��ϸ� �ȵ˴ϴ�.");
				return;
			} else if (vo.getUser_phone1().length() != 3) {
				joinForm.showMsg("��ȭ��ȣ ù��° ĭ���� 3�ڸ��� ���ڸ� �Է��ؾ� �մϴ�.");
				return;
			} else if ((vo.getUser_phone2().length() != 4) || (vo.getUser_phone3().length()) != 4) {
				joinForm.showMsg("��ȭ��ȣ �ι�°, ������ ĭ���� 4�ڸ��� ���ڸ� �Է��ؾ� �մϴ�.");
				return;
			} else if (vo.getUser_addr().equals("")) {
				joinForm.showMsg("�ּҸ� �Է����ּ���.");
				joinForm.tf_addr.requestFocus();
				return;
			}

			if (dao.modify(vo)) {
				allmemberForm.displayTable(dao.findAll());
				upJoinForm_adm.setVisible(false);
				allmemberForm.setVisible(true);
			}

		} else if (ob == upJoinForm_adm.bt_cancle) {// ������ư ���� �� �����ڸ��� ȸ�� ���� ������ ��� ��������
			upJoinForm_adm.setVisible(false);
			allmemberForm.setVisible(true);
		}

		else if (ob == upJoinForm.bt_submit) {// ���������� â���� �����Ϸ� ��ư�� ����-������

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
				joinForm.showMsg("��й�ȣ�� �ݵ�� �Է��ؾ� �մϴ�.");
				joinForm.tf_pwd.requestFocus();
				return;
			} else if (!vo.getUser_pwd()
					.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$")) {
				joinForm.showMsg("��й�ȣ�¼���, ����, Ư������(@,$,!,%,*,#,?,&) ���� 1�� �̻� �����Ͽ� �ּ� 8�ڸ� �̻� �Է��Ͽ��� �մϴ�.");
				joinForm.tf_pwd.requestFocus();
				return;
			} else if (vo.getUser_name().equals("")) {
				joinForm.showMsg("�̸��� �ݵ�� �Է��ؾ� �մϴ�.");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_name().trim().matches("^[��-�R]*$")) {
				joinForm.showMsg("�̸��� �ѱ۸� �Է� �����մϴ�. �ùٸ� �̸��� �Է��Ͻʽÿ�. ");
				joinForm.tf_name.requestFocus();
				return;
			} else if (!vo.getUser_phone1().matches("^[\\d]*$") || !vo.getUser_phone2().matches("^[\\d]*$")
					|| !vo.getUser_phone3().matches("^[\\d]*$")) {
				joinForm.showMsg("��ȭ��ȣ ������ ���ڸ� �Է��ϸ� �ȵ˴ϴ�.");
				return;
			} else if (vo.getUser_phone1().length() != 3) {
				joinForm.showMsg("��ȭ��ȣ ù��° ĭ���� 3�ڸ��� ���ڸ� �Է��ؾ� �մϴ�.");
				return;
			} else if ((vo.getUser_phone2().length() != 4) || (vo.getUser_phone3().length()) != 4) {
				joinForm.showMsg("��ȭ��ȣ �ι�°, ������ ĭ���� 4�ڸ��� ���ڸ� �Է��ؾ� �մϴ�.");
				return;
			} else {

				if (dao.update(vo)) {
					upJoinForm.showMsg("�����Ǿ����ϴ�.");
					upJoinForm.setVisible(false);
					serviceForm.setVisible(true);
				} else {
					upJoinForm.showMsg("������ �����߽��ϴ�.");
				}

			}

		} else if (ob == upJoinForm.bt_cancel) {// �� �������� â���� ��� ��ư�� ���� - ������

			upJoinForm.setVisible(false);
			serviceForm.setVisible(true);
		}

		// ==============================================================================
		/* �������� */
		else if (ob == serviceForm_adm.bt_logout_adm) {
			joinForm.initText();
			serviceForm_adm.setVisible(false);
			loginForm.setVisible(true);
		} else if (ob == serviceForm_adm.bt_room1_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(true);
			serviceForm_adm.p_room2_adm.setVisible(false);
			serviceForm_adm.p_room3_adm.setVisible(false);

			// �������� �ڸ� �����ϱ�
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

			// DB���� ��������ͼ� �����ֱ�
			// d=displayTable �޼ҵ�
			serviceForm_adm.displayTable1(dao.Show_CurrentUser());

		}
		// 2������ ������
		else if (ob == serviceForm_adm.bt_room2_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(false);
			serviceForm_adm.p_room2_adm.setVisible(true);
			serviceForm_adm.p_room3_adm.setVisible(false);

			// �������� �ڸ� �����ϱ�
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

		// 3������ ������
		else if (ob == serviceForm_adm.bt_room3_adm) {
			LibraryDAO dao = new LibraryDAO();
			serviceForm_adm.p_room1_adm.setVisible(false);
			serviceForm_adm.p_room2_adm.setVisible(false);
			serviceForm_adm.p_room3_adm.setVisible(true);

			// �������� �ڸ� �����ϱ�
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
