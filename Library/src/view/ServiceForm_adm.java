package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.vo.ReservationVO;

public class ServiceForm_adm extends JFrame {

	public JButton bt_room1_adm, bt_room2_adm, bt_room3_adm, bt_logout_adm, bt_allCustom, bt_garbage, bt_seat1_1_adm,
			bt_seat1_2_adm, bt_seat1_3_adm, bt_seat1_4_adm, bt_seat1_5_adm, bt_seat1_6_adm, bt_seat1_7_adm,
			bt_seat1_8_adm, bt_seat1_9_adm, bt_seat2_1_adm, bt_seat2_2_adm, bt_seat2_3_adm, bt_seat2_4_adm,
			bt_seat2_5_adm, bt_seat2_6_adm, bt_seat2_7_adm, bt_seat2_8_adm, bt_seat2_9_adm, bt_seat3_1_adm,
			bt_seat3_2_adm, bt_seat3_3_adm, bt_seat3_4_adm, bt_seat3_5_adm, bt_seat3_6_adm, bt_seat3_7_adm,
			bt_seat3_8_adm, bt_seat3_9_adm;
	JPanel p_back_adm;
	public JPanel p_room1_adm;
	public JPanel p_room2_adm;
	public JPanel p_room3_adm;

	public JButton[] bt_seat_adm = new JButton[28];

	public DefaultTableModel dtm;
	public JTable table_service_adm;
	public JScrollPane scroll_table;

	public ServiceForm_adm() {

		Object[][] rowData = new Object[0][6];
		String[] columTitle = { "회원번호", "이름", "좌석번호", "예약번호", "입실시간", "퇴실시간" };

		dtm = new DefaultTableModel(rowData, columTitle);
		table_service_adm = new JTable(dtm); // 테이블
		scroll_table = new JScrollPane(table_service_adm);

		table_service_adm.setRowHeight(50);

		bt_room1_adm = new JButton("1열람실");
		bt_room2_adm = new JButton("2열람실");
		bt_room3_adm = new JButton("3열람실");
		bt_logout_adm = new JButton("로그아웃");
		bt_allCustom = new JButton("모든회원정보");

		bt_seat1_1_adm = new JButton("1");
		bt_seat1_2_adm = new JButton("2");
		bt_seat1_3_adm = new JButton("3");
		bt_seat1_4_adm = new JButton("4");
		bt_seat1_5_adm = new JButton("5");
		bt_seat1_6_adm = new JButton("6");
		bt_seat1_7_adm = new JButton("7");
		bt_seat1_8_adm = new JButton("8");
		bt_seat1_9_adm = new JButton("9");

		bt_seat2_1_adm = new JButton("10");
		bt_seat2_2_adm = new JButton("11");
		bt_seat2_3_adm = new JButton("12");
		bt_seat2_4_adm = new JButton("13");
		bt_seat2_5_adm = new JButton("14");
		bt_seat2_6_adm = new JButton("15");
		bt_seat2_7_adm = new JButton("16");
		bt_seat2_8_adm = new JButton("17");
		bt_seat2_9_adm = new JButton("18");

		bt_seat3_1_adm = new JButton("19");
		bt_seat3_2_adm = new JButton("20");
		bt_seat3_3_adm = new JButton("21");
		bt_seat3_4_adm = new JButton("22");
		bt_seat3_5_adm = new JButton("23");
		bt_seat3_6_adm = new JButton("24");
		bt_seat3_7_adm = new JButton("25");
		bt_seat3_8_adm = new JButton("26");
		bt_seat3_9_adm = new JButton("27");
		// table_service_adm = new JTable();

		bt_seat_adm[0] = bt_garbage;
		bt_seat_adm[1] = bt_seat1_1_adm;
		bt_seat_adm[2] = bt_seat1_2_adm;
		bt_seat_adm[3] = bt_seat1_3_adm;
		bt_seat_adm[4] = bt_seat1_4_adm;
		bt_seat_adm[5] = bt_seat1_5_adm;
		bt_seat_adm[6] = bt_seat1_6_adm;
		bt_seat_adm[7] = bt_seat1_7_adm;
		bt_seat_adm[8] = bt_seat1_8_adm;
		bt_seat_adm[9] = bt_seat1_9_adm;
		bt_seat_adm[10] = bt_seat2_1_adm;
		bt_seat_adm[11] = bt_seat2_2_adm;
		bt_seat_adm[12] = bt_seat2_3_adm;
		bt_seat_adm[13] = bt_seat2_4_adm;
		bt_seat_adm[14] = bt_seat2_5_adm;
		bt_seat_adm[15] = bt_seat2_6_adm;
		bt_seat_adm[16] = bt_seat2_7_adm;
		bt_seat_adm[17] = bt_seat2_8_adm;
		bt_seat_adm[18] = bt_seat2_9_adm;
		bt_seat_adm[19] = bt_seat3_1_adm;
		bt_seat_adm[20] = bt_seat3_2_adm;
		bt_seat_adm[21] = bt_seat3_3_adm;
		bt_seat_adm[22] = bt_seat3_4_adm;
		bt_seat_adm[23] = bt_seat3_5_adm;
		bt_seat_adm[24] = bt_seat3_6_adm;
		bt_seat_adm[25] = bt_seat3_7_adm;
		bt_seat_adm[26] = bt_seat3_8_adm;
		bt_seat_adm[27] = bt_seat3_9_adm;

		p_back_adm = new JPanel();
		p_room1_adm = new JPanel();
		p_room2_adm = new JPanel();
		p_room3_adm = new JPanel();

		// ------------------------------------------------------------------

		bt_room1_adm.setBounds(28, 29, 100, 35);
		bt_room2_adm.setBounds(142, 29, 100, 35);
		bt_room3_adm.setBounds(256, 29, 100, 35);
		bt_logout_adm.setBounds(955, 29, 100, 35);
		bt_allCustom.setBounds(810, 29, 120, 35);

		p_room1_adm.setBounds(499, 100, 492, 465);
		p_room2_adm.setBounds(499, 100, 492, 465);
		p_room3_adm.setBounds(499, 100, 492, 465);

		scroll_table.setBounds(45, 100, 400, 465);

		// --------------------------------------------------------------------
		p_back_adm.add(bt_room1_adm);
		p_back_adm.add(bt_room2_adm);
		p_back_adm.add(bt_room3_adm);
		p_back_adm.add(bt_allCustom);
		p_back_adm.add(scroll_table);
		p_back_adm.add(bt_logout_adm);

		p_room1_adm.add(bt_seat1_1_adm);
		p_room1_adm.add(bt_seat1_2_adm);
		p_room1_adm.add(bt_seat1_3_adm);
		p_room1_adm.add(bt_seat1_4_adm);
		p_room1_adm.add(bt_seat1_5_adm);
		p_room1_adm.add(bt_seat1_6_adm);
		p_room1_adm.add(bt_seat1_7_adm);
		p_room1_adm.add(bt_seat1_8_adm);
		p_room1_adm.add(bt_seat1_9_adm);

		p_room2_adm.add(bt_seat2_1_adm);
		p_room2_adm.add(bt_seat2_2_adm);
		p_room2_adm.add(bt_seat2_3_adm);
		p_room2_adm.add(bt_seat2_4_adm);
		p_room2_adm.add(bt_seat2_5_adm);
		p_room2_adm.add(bt_seat2_6_adm);
		p_room2_adm.add(bt_seat2_7_adm);
		p_room2_adm.add(bt_seat2_8_adm);
		p_room2_adm.add(bt_seat2_9_adm);

		p_room3_adm.add(bt_seat3_1_adm);
		p_room3_adm.add(bt_seat3_2_adm);
		p_room3_adm.add(bt_seat3_3_adm);
		p_room3_adm.add(bt_seat3_4_adm);
		p_room3_adm.add(bt_seat3_5_adm);
		p_room3_adm.add(bt_seat3_6_adm);
		p_room3_adm.add(bt_seat3_7_adm);
		p_room3_adm.add(bt_seat3_8_adm);
		p_room3_adm.add(bt_seat3_9_adm);
		// --------------------------------------------------------------------

		p_room1_adm.setLayout(new GridLayout(3, 3, 20, 20));
		p_room2_adm.setLayout(new GridLayout(3, 3, 20, 20));
		p_room3_adm.setLayout(new GridLayout(3, 3, 20, 20));
		p_room1_adm.setBackground(Color.orange);
		p_room2_adm.setBackground(Color.blue);
		p_room3_adm.setBackground(Color.green);
		p_back_adm.add(p_room1_adm);
		p_back_adm.add(p_room2_adm);
		p_back_adm.add(p_room3_adm);
		p_back_adm.add(scroll_table);
		p_back_adm.setLayout(null);
		p_back_adm.setBackground(Color.orange);
		p_room1_adm.setVisible(true);
		p_room2_adm.setVisible(false);
		p_room3_adm.setVisible(false);
		setContentPane(p_back_adm);
		setLayout(null);
		setBounds(100, 100, 1100, 700);
		setVisible(false);
	}

	// //ArrayList안에 저장된 Res_UserVO정보를 JTable에 출력하는 기능.
//	      //JTable ==> {"회원번호","이름","좌석번호","예약번호","입실시간","퇴실시간"};
//	      public void displayTable(ArrayList<ReservationVO> list) {
//	          dtm.setRowCount(0);
//	          
//	          for (int i = 0; i < list.size(); i++) {
//	            ReservationVO vo = list.get(i);
//	         
//	            Object []rowData= {vo.getUser_num(), vo.getUser_name(), vo.getSit_num(), vo.getRes_num(), vo.getSit_start(), vo.getSit_end()};
//	            dtm.addRow(rowData);
//	          }        
//	      }//displayTable

	public void displayTable1(ArrayList<ReservationVO> list) {
		dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			ReservationVO vo = list.get(i);
			if (list.get(i).getSit_num() < 10) {
				Object[] rowData = { vo.getUser_num(), vo.getUser_name(), vo.getSit_num(), vo.getRes_num(),
						vo.getSit_start(), vo.getSit_end() };
				dtm.addRow(rowData);
			}

		}
	}// displayTable

	public void displayTable2(ArrayList<ReservationVO> list) {
		dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			ReservationVO vo = list.get(i);
			if (list.get(i).getSit_num() > 9 && list.get(i).getSit_num() <= 18) {
				Object[] rowData = { vo.getUser_num(), vo.getUser_name(), vo.getSit_num(), vo.getRes_num(),
						vo.getSit_start(), vo.getSit_end() };
				dtm.addRow(rowData);
			}

		}
	}// displayTable

	public void displayTable3(ArrayList<ReservationVO> list) {
		dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			ReservationVO vo = list.get(i);
			if (list.get(i).getSit_num() > 18 && list.get(i).getSit_num() <= 27) {
				Object[] rowData = { vo.getUser_num(), vo.getUser_name(), vo.getSit_num(), vo.getRes_num(),
						vo.getSit_start(), vo.getSit_end() };
				dtm.addRow(rowData);
			}

		}
	}// displayTable

	public void change_sitcolor_room1(int sitnum) {
		if (sitnum == 1) {
			bt_seat1_1_adm.setBackground(Color.red);
		} else if (sitnum == 2) {
			bt_seat1_2_adm.setBackground(Color.red);
		} else if (sitnum == 3) {
			bt_seat1_3_adm.setBackground(Color.red);
		} else if (sitnum == 4) {
			bt_seat1_4_adm.setBackground(Color.red);
		} else if (sitnum == 5) {
			bt_seat1_5_adm.setBackground(Color.red);
		} else if (sitnum == 6) {
			bt_seat1_6_adm.setBackground(Color.red);
		} else if (sitnum == 7) {
			bt_seat1_7_adm.setBackground(Color.red);
		} else if (sitnum == 8) {
			bt_seat1_8_adm.setBackground(Color.red);
		} else if (sitnum == 9) {
			bt_seat1_9_adm.setBackground(Color.red);
		}
	}

	public void change_sitcolor_room2(int sitnum) {
		if (sitnum == 10) {
			bt_seat2_1_adm.setBackground(Color.red);
		} else if (sitnum == 11) {
			bt_seat2_2_adm.setBackground(Color.red);
		} else if (sitnum == 12) {
			bt_seat2_3_adm.setBackground(Color.red);
		} else if (sitnum == 13) {
			bt_seat2_4_adm.setBackground(Color.red);
		} else if (sitnum == 14) {
			bt_seat2_5_adm.setBackground(Color.red);
		} else if (sitnum == 15) {
			bt_seat2_6_adm.setBackground(Color.red);
		} else if (sitnum == 16) {
			bt_seat2_7_adm.setBackground(Color.red);
		} else if (sitnum == 17) {
			bt_seat2_8_adm.setBackground(Color.red);
		} else if (sitnum == 18) {
			bt_seat2_9_adm.setBackground(Color.red);
		}
	}

	public void change_sitcolor_room3(int sitnum) {
		if (sitnum == 19) {
			bt_seat3_1_adm.setBackground(Color.red);
		} else if (sitnum == 20) {
			bt_seat3_2_adm.setBackground(Color.red);
		} else if (sitnum == 21) {
			bt_seat3_3_adm.setBackground(Color.red);
		} else if (sitnum == 22) {
			bt_seat3_4_adm.setBackground(Color.red);
		} else if (sitnum == 23) {
			bt_seat3_5_adm.setBackground(Color.red);
		} else if (sitnum == 24) {
			bt_seat3_6_adm.setBackground(Color.red);
		} else if (sitnum == 25) {
			bt_seat3_7_adm.setBackground(Color.red);
		} else if (sitnum == 26) {
			bt_seat3_8_adm.setBackground(Color.red);
		} else if (sitnum == 27) {
			bt_seat3_9_adm.setBackground(Color.red);
		}
	}

	// public static void main(String[] args) {
//	      new ServiceForm_adm();
	// }
}