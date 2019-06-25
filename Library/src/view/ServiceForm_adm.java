package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ServiceForm_adm extends JFrame{
	
	JButton bt_room1_adm, bt_room2_adm, bt_room3_adm, bt_logout_adm, bt_allCustom,
	bt_seat1_1_adm, bt_seat1_2_adm, bt_seat1_3_adm, bt_seat1_4_adm, bt_seat1_5_adm, bt_seat1_6_adm, bt_seat1_7_adm, bt_seat1_8_adm, bt_seat1_9_adm,
	bt_seat2_1_adm, bt_seat2_2_adm, bt_seat2_3_adm, bt_seat2_4_adm, bt_seat2_5_adm, bt_seat2_6_adm, bt_seat2_7_adm, bt_seat2_8_adm, bt_seat2_9_adm,
	bt_seat3_1_adm, bt_seat3_2_adm, bt_seat3_3_adm, bt_seat3_4_adm, bt_seat3_5_adm, bt_seat3_6_adm, bt_seat3_7_adm, bt_seat3_8_adm, bt_seat3_9_adm;
	JTable table_service_adm;
	JPanel p_back_adm, p_room1_adm, p_room2_adm, p_room3_adm;

	public ServiceForm_adm() {
		bt_room1_adm = new JButton("1열람실");
		bt_room2_adm = new JButton("2열람실");
		bt_room3_adm = new JButton("3열람실");
		bt_logout_adm = new JButton("로그아웃");
		bt_allCustom = new JButton("모든회원정보");
		
		bt_seat1_1_adm = new JButton();
		bt_seat1_2_adm = new JButton();
		bt_seat1_3_adm = new JButton();
		bt_seat1_4_adm = new JButton();
		bt_seat1_5_adm = new JButton();
		bt_seat1_6_adm = new JButton();
		bt_seat1_7_adm = new JButton();
		bt_seat1_8_adm = new JButton();
		bt_seat1_9_adm = new JButton();
		
		bt_seat2_1_adm = new JButton();
		bt_seat2_2_adm = new JButton();
		bt_seat2_3_adm = new JButton();
		bt_seat2_4_adm = new JButton();
		bt_seat2_5_adm = new JButton();
		bt_seat2_6_adm = new JButton();
		bt_seat2_7_adm = new JButton();
		bt_seat2_8_adm = new JButton();
		bt_seat2_9_adm = new JButton();
		
		bt_seat3_1_adm = new JButton();
		bt_seat3_2_adm = new JButton();
		bt_seat3_3_adm = new JButton();
		bt_seat3_4_adm = new JButton();
		bt_seat3_5_adm = new JButton();
		bt_seat3_6_adm = new JButton();
		bt_seat3_7_adm = new JButton();
		bt_seat3_8_adm = new JButton();
		bt_seat3_9_adm = new JButton();
		table_service_adm = new JTable();
		
		p_back_adm = new JPanel();
		p_room1_adm = new JPanel();
		p_room2_adm = new JPanel();
		p_room3_adm = new JPanel();
		
//------------------------------------------------------------------
		
		bt_room1_adm.setBounds(28, 29, 100, 35);
		bt_room2_adm.setBounds(142, 29, 100, 35);
		bt_room3_adm.setBounds(256, 29, 100, 35);
		bt_logout_adm.setBounds(955, 29, 100, 35);
		bt_allCustom.setBounds(810, 29, 120, 35);
		
		p_room1_adm.setBounds(499, 100, 492, 465);
		p_room2_adm.setBounds(499, 100, 492, 465);
		p_room3_adm.setBounds(499, 100, 492, 465);
		
		table_service_adm.setBounds(45, 100, 400, 465);
		
//--------------------------------------------------------------------
		p_back_adm.add(bt_room1_adm);
		p_back_adm.add(bt_room2_adm);
		p_back_adm.add(bt_room3_adm);
		p_back_adm.add(bt_allCustom);
		p_back_adm.add(table_service_adm);
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
//--------------------------------------------------------------------
		
		p_room1_adm.setLayout(new GridLayout(3,3,20,20));
		p_room2_adm.setLayout(new GridLayout(3,3,20,20));
		p_room3_adm.setLayout(new GridLayout(3,3,20,20));
		p_room1_adm.setBackground(Color.orange);
		p_room2_adm.setBackground(Color.blue);
		p_room3_adm.setBackground(Color.green);
		p_back_adm.add(p_room1_adm);
		p_back_adm.add(p_room2_adm);
		p_back_adm.add(p_room3_adm);
		p_back_adm.add(table_service_adm);
		p_back_adm.setLayout(null);
		p_back_adm.setBackground(Color.orange);
		p_room1_adm.setVisible(true);
		p_room2_adm.setVisible(false);
		p_room3_adm.setVisible(false);
		setContentPane(p_back_adm);
		setLayout(null);
		setBounds(100, 100, 1100, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ServiceForm_adm();
	}
}
