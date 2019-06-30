package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ServiceForm extends JFrame{
	
	JButton bt_room1, bt_room2, bt_room3, bt_logout;
	public JButton bt_reserv;
	JButton bt_out;
	JButton bt_cont;
	JButton bt_myinfo;
	JButton bt_seat1_1;
	JButton bt_seat1_2;
	JButton bt_seat1_3;
	JButton bt_seat1_4;
	JButton bt_seat1_5;
	JButton bt_seat1_6;
	JButton bt_seat1_7;
	JButton bt_seat1_8;
	JButton bt_seat1_9;
	JButton bt_seat2_1;
	JButton bt_seat2_2;
	JButton bt_seat2_3;
	JButton bt_seat2_4;
	JButton bt_seat2_5;
	JButton bt_seat2_6;
	JButton bt_seat2_7;
	JButton bt_seat2_8;
	JButton bt_seat2_9;
	JButton bt_seat3_1;
	JButton bt_seat3_2;
	JButton bt_seat3_3;
	JButton bt_seat3_4;
	JButton bt_seat3_5;
	JButton bt_seat3_6;
	JButton bt_seat3_7;
	JButton bt_seat3_8;
	JButton bt_seat3_9;
	JTable table_service;
	JPanel p_back, p_room1, p_room2, p_room3;
	
	public ServiceForm() {
		bt_room1 = new JButton("1열람실");
		bt_room2 = new JButton("2열람실");
		bt_room3 = new JButton("3열람실");
		bt_logout = new JButton("로그아웃");
		
		bt_reserv = new JButton("예 약");
		bt_out = new JButton("퇴 실");
		bt_cont = new JButton("연 장");
		bt_myinfo = new JButton("내 정보보기");
		
		bt_seat1_1 = new JButton();
		bt_seat1_2 = new JButton();
		bt_seat1_3 = new JButton();
		bt_seat1_4 = new JButton();
		bt_seat1_5 = new JButton();
		bt_seat1_6 = new JButton();
		bt_seat1_7 = new JButton();
		bt_seat1_8 = new JButton();
		bt_seat1_9 = new JButton();
		
		bt_seat2_1 = new JButton();
		bt_seat2_2 = new JButton();
		bt_seat2_3 = new JButton();
		bt_seat2_4 = new JButton();
		bt_seat2_5 = new JButton();
		bt_seat2_6 = new JButton();
		bt_seat2_7 = new JButton();
		bt_seat2_8 = new JButton();
		bt_seat2_9 = new JButton();
		
		bt_seat3_1 = new JButton();
		bt_seat3_2 = new JButton();
		bt_seat3_3 = new JButton();
		bt_seat3_4 = new JButton();
		bt_seat3_5 = new JButton();
		bt_seat3_6 = new JButton();
		bt_seat3_7 = new JButton();
		bt_seat3_8 = new JButton();
		bt_seat3_9 = new JButton();
		table_service = new JTable();
		
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
		
		table_service.setBounds(45, 107, 399, 408);
		
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
		p_back.add(table_service);
		
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

		p_room1.setLayout(new GridLayout(3,3,20,20));
		p_room2.setLayout(new GridLayout(3,3,20,20));
		p_room3.setLayout(new GridLayout(3,3,20,20));
		p_room1.setBackground(Color.orange);
		p_room2.setBackground(Color.blue);
		p_room3.setBackground(Color.green);
		p_back.add(p_room1);
		p_back.add(p_room2);
		p_back.add(p_room3);
		p_back.add(table_service);
		p_back.setLayout(null);
		p_back.setBackground(Color.orange);
		p_room1.setVisible(true);
		p_room2.setVisible(false);
		p_room3.setVisible(false);
		setContentPane(p_back);
		setLayout(null);
		setBounds(100, 100, 1100, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ServiceForm();
	}
}
