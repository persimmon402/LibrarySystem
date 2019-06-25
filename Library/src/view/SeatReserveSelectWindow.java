package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SeatReserveSelectWindow extends JFrame{
	public JButton bt_room1, bt_room2, bt_room3, bt_reserve, bt_cancel, bt_logout, 
					bt_room1_seat1, bt_room1_seat2, bt_room1_seat3,
					bt_room1_seat4, bt_room1_seat5, bt_room1_seat6,
					bt_room1_seat7, bt_room1_seat8, bt_room1_seat9,
					
					bt_room2_seat1, bt_room2_seat2, bt_room2_seat3,
					bt_room2_seat4, bt_room2_seat5, bt_room2_seat6,
					bt_room2_seat7, bt_room2_seat8, bt_room2_seat9,
					
					bt_room3_seat1, bt_room3_seat2, bt_room3_seat3,
					bt_room3_seat4, bt_room3_seat5, bt_room3_seat6,
					bt_room3_seat7, bt_room3_seat8, bt_room3_seat9;
	
	public JPanel p_room1, p_room2, p_room3;

	public SeatReserveSelectWindow() {
		setTitle("좌석선택");
		bt_room1 = new JButton("열람실1");
		bt_room2 = new JButton("열람실2");
		bt_room3 = new JButton("열람실3");
		bt_reserve = new JButton("예약하기");
		bt_cancel = new JButton("취소");
		bt_logout = new JButton("로그아웃");
		
		p_room1 = new JPanel();
		p_room2 = new JPanel();
		p_room3 = new JPanel();
		
		bt_room1_seat1 = new JButton("1_1");
		bt_room1_seat1.setBackground(Color.RED);
		bt_room1_seat2 = new JButton("1_2");
		bt_room1_seat3 = new JButton("1_3");
		bt_room1_seat4 = new JButton("1_4");
		bt_room1_seat5 = new JButton("1_5");
		bt_room1_seat6 = new JButton("1_6");
		bt_room1_seat7 = new JButton("1_7");
		bt_room1_seat8 = new JButton("1_8");
		bt_room1_seat9 = new JButton("1_9");//열람실 1의 좌석버튼들
		
		bt_room2_seat1 = new JButton();
		bt_room2_seat2 = new JButton();
		bt_room2_seat3 = new JButton();
		bt_room2_seat4 = new JButton();
		bt_room2_seat5 = new JButton();
		bt_room2_seat6 = new JButton();
		bt_room2_seat7 = new JButton();
		bt_room2_seat8 = new JButton();
		bt_room2_seat9 = new JButton();//열람실 2의 좌석버튼들
		
		bt_room3_seat1 = new JButton();
		bt_room3_seat2 = new JButton();
		bt_room3_seat3 = new JButton();
		bt_room3_seat4 = new JButton();
		bt_room3_seat5 = new JButton();
		bt_room3_seat6 = new JButton();
		bt_room3_seat7 = new JButton();
		bt_room3_seat8 = new JButton();
		bt_room3_seat9 = new JButton();//열람실 3의 좌석버튼들
			
		add(bt_room1);
		add(bt_room2);
		add(bt_room3);
		add(bt_logout);
		add(bt_reserve);
		add(bt_cancel);
		
		bt_room1.setBounds(50, 20, 100, 30);
		bt_room2.setBounds(200, 20, 100, 30);
		bt_room3.setBounds(350, 20, 100, 30);
		bt_logout.setBounds(950, 20, 100, 30);
		bt_reserve.setBounds(400, 600, 100, 30);
		bt_cancel.setBounds(610, 600, 100, 30);
		
		//==============열람실 1 패널===============
		add(p_room1);
		p_room1.setBounds(300, 60, 510, 510);
		p_room1.setBackground(Color.CYAN);
		p_room1.setLayout(new GridLayout(3, 3, 3, 3));
		p_room1.setVisible(true);
		
		p_room1.add(bt_room1_seat1);
		p_room1.add(bt_room1_seat2);
		p_room1.add(bt_room1_seat3);
		p_room1.add(bt_room1_seat4);
		p_room1.add(bt_room1_seat5);
		p_room1.add(bt_room1_seat6);
		p_room1.add(bt_room1_seat7);
		p_room1.add(bt_room1_seat8);
		p_room1.add(bt_room1_seat9);
		
		//==============열람실 2 패널=============
		add(p_room2);
		p_room2.setBounds(500, 50, 510, 510);
		p_room2.setBackground(Color.MAGENTA);
		p_room2.setLayout(new GridLayout(3, 3, 3, 3));
		p_room2.setVisible(false);
		
		p_room2.add(bt_room2_seat1);
		p_room2.add(bt_room2_seat2);
		p_room2.add(bt_room2_seat3);
		p_room2.add(bt_room2_seat4);
		p_room2.add(bt_room2_seat5);
		p_room2.add(bt_room2_seat6);
		p_room2.add(bt_room2_seat7);
		p_room2.add(bt_room2_seat8);
		p_room2.add(bt_room2_seat9);
		
		//==============열람실 3 패널===========
		add(p_room3);
		p_room3.setBounds(500, 50, 510, 510);
		p_room3.setBackground(Color.YELLOW);
		p_room3.setLayout(new GridLayout(3, 3, 3, 3));
		p_room3.setVisible(false);
		
		p_room3.add(bt_room3_seat1);
		p_room3.add(bt_room3_seat2);
		p_room3.add(bt_room3_seat3);
		p_room3.add(bt_room3_seat4);
		p_room3.add(bt_room3_seat5);
		p_room3.add(bt_room3_seat6);
		p_room3.add(bt_room3_seat7);
		p_room3.add(bt_room3_seat8);
		p_room3.add(bt_room3_seat9);
		
		//=================================
		setLayout(null);
		setBounds(100, 100, 1100, 700);
		setVisible(true);
		
	}//생성자
	
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public int showConfirm(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}
	
	public static void main(String[] args) {
		new SeatReserveSelectWindow();
	}
}