package com.library.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.library.model.vo.ReservationVO;

public class ServiceForm extends JFrame {
	DefaultTableModel dtm;
	public JButton bt_room1, bt_room2, bt_room3, bt_logout, bt_reserv, bt_out, bt_cont, bt_myinfo, bt_seat1_1,
			bt_seat1_2, bt_seat1_3, bt_seat1_4, bt_seat1_5, bt_seat1_6, bt_seat1_7, bt_seat1_8, bt_seat1_9, bt_seat2_1,
			bt_seat2_2, bt_seat2_3, bt_seat2_4, bt_seat2_5, bt_seat2_6, bt_seat2_7, bt_seat2_8, bt_seat2_9, bt_seat3_1,
			bt_seat3_2, bt_seat3_3, bt_seat3_4, bt_seat3_5, bt_seat3_6, bt_seat3_7, bt_seat3_8, bt_seat3_9;
	public JTable table_service;
	public JPanel p_back, p_room1, p_room2, p_room3;
	JScrollPane scroll_table;
	Color cc = new Color(255, 192, 203);
	public String loginId; // 서비스폼이 켜져잇는동안 메모리 기억

	public ServiceForm() {
		Color c = new Color(151, 216, 244);
		bt_room1 = new JButton("1열람실");
		bt_room2 = new JButton("2열람실");
		bt_room3 = new JButton("3열람실");
		bt_logout = new JButton("로그아웃");
		bt_logout.setBackground(c);
		bt_room1.setBackground(c);
		bt_room2.setBackground(c);
		bt_room3.setBackground(c);

		bt_reserv = new JButton("예 약");
		bt_out = new JButton("퇴 실");
		bt_cont = new JButton("연 장");
		bt_myinfo = new JButton("내 정보보기");
		bt_reserv.setBackground(c);
		bt_out.setBackground(c);
		bt_cont.setBackground(c);
		bt_myinfo.setBackground(c);

		bt_seat1_1 = new JButton("1");
		bt_seat1_2 = new JButton("2");
		bt_seat1_3 = new JButton("3");
		bt_seat1_4 = new JButton("4");
		bt_seat1_5 = new JButton("5");
		bt_seat1_6 = new JButton("6");
		bt_seat1_7 = new JButton("7");
		bt_seat1_8 = new JButton("8");
		bt_seat1_9 = new JButton("9");

		bt_seat2_1 = new JButton("10");
		bt_seat2_2 = new JButton("11");
		bt_seat2_3 = new JButton("12");
		bt_seat2_4 = new JButton("13");
		bt_seat2_5 = new JButton("14");
		bt_seat2_6 = new JButton("15");
		bt_seat2_7 = new JButton("16");
		bt_seat2_8 = new JButton("17");
		bt_seat2_9 = new JButton("18");

		bt_seat3_1 = new JButton("19");
		bt_seat3_2 = new JButton("20");
		bt_seat3_3 = new JButton("21");
		bt_seat3_4 = new JButton("22");
		bt_seat3_5 = new JButton("23");
		bt_seat3_6 = new JButton("24");
		bt_seat3_7 = new JButton("25");
		bt_seat3_8 = new JButton("26");
		bt_seat3_9 = new JButton("27");

		Object[][] rowData = new Object[0][5];
		String[] columTitle = { "사용자번호", "좌석번호", "시작시간", "끝시간", "남은시간" };
		dtm = new DefaultTableModel(rowData, columTitle);
		table_service = new JTable(dtm);
		scroll_table = new JScrollPane(table_service);

		p_back = new JPanel();
		p_room1 = new JPanel();
		p_room2 = new JPanel();
		p_room3 = new JPanel();

//----------------------------------------------------------------------
		bt_room1.setBounds(28, 29, 100, 35);
		bt_room2.setBounds(142, 29, 100, 35);
		bt_room3.setBounds(256, 29, 100, 35);
		bt_logout.setBounds(955, 29, 100, 35);

		bt_reserv.setBounds(285, 580, 110, 45);
		bt_out.setBounds(440, 580, 110, 45);
		bt_cont.setBounds(593, 580, 110, 45);
		bt_myinfo.setBounds(749, 580, 110, 45);

		scroll_table.setBounds(45, 107, 399, 408);

		p_room1.setBounds(499, 67, 492, 465);
		p_room2.setBounds(499, 67, 492, 465);
		p_room3.setBounds(499, 67, 492, 465);

//-----------------------------------------------------------------------
		p_back.add(bt_room1);
		p_back.add(bt_room2);
		p_back.add(bt_room3);
		p_back.add(bt_logout);

		p_back.add(bt_reserv);
		p_back.add(bt_out);
		p_back.add(bt_cont);
		p_back.add(bt_myinfo);
		p_back.add(scroll_table);

		p_room1.add(bt_seat1_1);
		p_room1.add(bt_seat1_2);
		p_room1.add(bt_seat1_3);
		p_room1.add(bt_seat1_4);
		p_room1.add(bt_seat1_5);
		p_room1.add(bt_seat1_6);
		p_room1.add(bt_seat1_7);
		p_room1.add(bt_seat1_8);
		p_room1.add(bt_seat1_9);

		p_room2.add(bt_seat2_1);
		p_room2.add(bt_seat2_2);
		p_room2.add(bt_seat2_3);
		p_room2.add(bt_seat2_4);
		p_room2.add(bt_seat2_5);
		p_room2.add(bt_seat2_6);
		p_room2.add(bt_seat2_7);
		p_room2.add(bt_seat2_8);
		p_room2.add(bt_seat2_9);

		p_room3.add(bt_seat3_1);
		p_room3.add(bt_seat3_2);
		p_room3.add(bt_seat3_3);
		p_room3.add(bt_seat3_4);
		p_room3.add(bt_seat3_5);
		p_room3.add(bt_seat3_6);
		p_room3.add(bt_seat3_7);
		p_room3.add(bt_seat3_8);
		p_room3.add(bt_seat3_9);

		p_room1.setLayout(new GridLayout(3, 3, 20, 20));
		p_room2.setLayout(new GridLayout(3, 3, 20, 20));
		p_room3.setLayout(new GridLayout(3, 3, 20, 20));
		p_room1.setBackground(Color.orange);
		p_room2.setBackground(Color.blue);
		p_room3.setBackground(Color.green);
		p_back.add(p_room1);
		p_back.add(p_room2);
		p_back.add(p_room3);

		p_back.setLayout(null);
		p_back.setBackground(Color.white);
		p_room1.setVisible(true);
		p_room2.setVisible(false);
		p_room3.setVisible(false);
		setContentPane(p_back);
		setLayout(null);
		setBounds(100, 100, 1100, 700);
		setVisible(false);
	}

	public void change_sitcolor_room1(int sitnum) {
		if (sitnum == 1) {
			bt_seat1_1.setBackground(cc);
		} else if (sitnum == 2) {
			bt_seat1_2.setBackground(cc);
		} else if (sitnum == 3) {
			bt_seat1_3.setBackground(cc);
		} else if (sitnum == 4) {
			bt_seat1_4.setBackground(cc);
		} else if (sitnum == 5) {
			bt_seat1_5.setBackground(cc);
		} else if (sitnum == 6) {
			bt_seat1_6.setBackground(cc);
		} else if (sitnum == 7) {
			bt_seat1_7.setBackground(cc);
		} else if (sitnum == 8) {
			bt_seat1_8.setBackground(cc);
		} else if (sitnum == 9) {
			bt_seat1_9.setBackground(cc);
		}
	}

	public void change_sitcolor_room2(int sitnum) {
		if (sitnum == 10) {
			bt_seat2_1.setBackground(cc);
		} else if (sitnum == 11) {
			bt_seat2_2.setBackground(cc);
		} else if (sitnum == 12) {
			bt_seat2_3.setBackground(cc);
		} else if (sitnum == 13) {
			bt_seat2_4.setBackground(cc);
		} else if (sitnum == 14) {
			bt_seat2_5.setBackground(cc);
		} else if (sitnum == 15) {
			bt_seat2_6.setBackground(cc);
		} else if (sitnum == 16) {
			bt_seat2_7.setBackground(cc);
		} else if (sitnum == 17) {
			bt_seat2_8.setBackground(cc);
		} else if (sitnum == 18) {
			bt_seat2_9.setBackground(cc);
		}
	}

	public void change_sitcolor_room3(int sitnum) {
		if (sitnum == 19) {
			bt_seat3_1.setBackground(cc);
		} else if (sitnum == 20) {
			bt_seat3_2.setBackground(cc);
		} else if (sitnum == 21) {
			bt_seat3_3.setBackground(cc);
		} else if (sitnum == 22) {
			bt_seat3_4.setBackground(cc);
		} else if (sitnum == 23) {
			bt_seat3_5.setBackground(cc);
		} else if (sitnum == 24) {
			bt_seat3_6.setBackground(cc);
		} else if (sitnum == 25) {
			bt_seat3_7.setBackground(cc);
		} else if (sitnum == 26) {
			bt_seat3_8.setBackground(cc);
		} else if (sitnum == 27) {
			bt_seat3_9.setBackground(cc);
		}
	}

	public void default_sitcolor_room1(int sitnum) {
		if (sitnum == 1) {
			bt_seat1_1.setBackground(new JButton().getBackground());
		} else if (sitnum == 2) {
			bt_seat1_2.setBackground(new JButton().getBackground());
		} else if (sitnum == 3) {
			bt_seat1_3.setBackground(new JButton().getBackground());
		} else if (sitnum == 4) {
			bt_seat1_4.setBackground(new JButton().getBackground());
		} else if (sitnum == 5) {
			bt_seat1_5.setBackground(new JButton().getBackground());
		} else if (sitnum == 6) {
			bt_seat1_6.setBackground(new JButton().getBackground());
		} else if (sitnum == 7) {
			bt_seat1_7.setBackground(new JButton().getBackground());
		} else if (sitnum == 8) {
			bt_seat1_8.setBackground(new JButton().getBackground());
		} else if (sitnum == 9) {
			bt_seat1_9.setBackground(new JButton().getBackground());
		}
	}

	public void default_sitcolor_room2(int sitnum) {
		if (sitnum == 10) {
			bt_seat2_1.setBackground(new JButton().getBackground());
		} else if (sitnum == 11) {
			bt_seat2_2.setBackground(new JButton().getBackground());
		} else if (sitnum == 12) {
			bt_seat2_3.setBackground(new JButton().getBackground());
		} else if (sitnum == 13) {
			bt_seat2_4.setBackground(new JButton().getBackground());
		} else if (sitnum == 14) {
			bt_seat2_5.setBackground(new JButton().getBackground());
		} else if (sitnum == 15) {
			bt_seat2_6.setBackground(new JButton().getBackground());
		} else if (sitnum == 16) {
			bt_seat2_7.setBackground(new JButton().getBackground());
		} else if (sitnum == 17) {
			bt_seat2_8.setBackground(new JButton().getBackground());
		} else if (sitnum == 18) {
			bt_seat2_9.setBackground(new JButton().getBackground());
		}
	}

	public void default_sitcolor_room3(int sitnum) {
		if (sitnum == 19) {
			bt_seat3_1.setBackground(new JButton().getBackground());
		} else if (sitnum == 20) {
			bt_seat3_2.setBackground(new JButton().getBackground());
		} else if (sitnum == 21) {
			bt_seat3_3.setBackground(new JButton().getBackground());
		} else if (sitnum == 22) {
			bt_seat3_4.setBackground(new JButton().getBackground());
		} else if (sitnum == 23) {
			bt_seat3_5.setBackground(new JButton().getBackground());
		} else if (sitnum == 24) {
			bt_seat3_6.setBackground(new JButton().getBackground());
		} else if (sitnum == 25) {
			bt_seat3_7.setBackground(new JButton().getBackground());
		} else if (sitnum == 26) {
			bt_seat3_8.setBackground(new JButton().getBackground());
		} else if (sitnum == 27) {
			bt_seat3_9.setBackground(new JButton().getBackground());
		}
	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}// showMsg

	public String showInput(String msg) {
		return JOptionPane.showInputDialog(this, msg);
	}// showInput

	public int showConfirm(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}// showConfirm

	public void displayTable(ArrayList<ReservationVO> list) {
		dtm.setRowCount(0);
		System.out.println(list.toString());

		for (int i = 0; i < list.size(); i++) {
			ReservationVO vo = list.get(i);
			Object[] rowData = { vo.getUser_num(), vo.getSit_num(), vo.getSit_start(), vo.getSit_end(),
					vo.getSit_remain() };
			dtm.addRow(rowData);
		}
	}
} // displayTable

// public static void main(String[] args) {
// new ServiceForm();
// }}