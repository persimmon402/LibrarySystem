package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SeatReserveSelectWindow extends JFrame{
	
	public JButton[] bt_room_seat = new JButton[28];

	public JButton bt_room1, bt_room2, bt_room3, bt_reserve, bt_cancel, bt_logout;
				
	public JPanel p_room1, p_room2, p_room3;


	public SeatReserveSelectWindow() {
		bt_room_seat[1] = new JButton("1_1");
		bt_room_seat[2] = new JButton("1_2");
		bt_room_seat[3] = new JButton();
		bt_room_seat[4] = new JButton();
		bt_room_seat[5] = new JButton();
		bt_room_seat[6] = new JButton();
		bt_room_seat[7] = new JButton();
		bt_room_seat[8] = new JButton();
		bt_room_seat[9] = new JButton();//열람실 1까지 좌석버튼들
		
		bt_room_seat[10] = new JButton();
		bt_room_seat[11] = new JButton();
		bt_room_seat[12] = new JButton();
		bt_room_seat[13] = new JButton();
		bt_room_seat[14] = new JButton();
		bt_room_seat[15] = new JButton();
		bt_room_seat[16] = new JButton();
		bt_room_seat[17] = new JButton();
		bt_room_seat[18] = new JButton();//열람실 2까지 좌석버튼들
		
		bt_room_seat[19] = new JButton();
		bt_room_seat[20] = new JButton();
		bt_room_seat[21] = new JButton();
		bt_room_seat[22] = new JButton();
		bt_room_seat[23] = new JButton();
		bt_room_seat[24] = new JButton();
		bt_room_seat[25] = new JButton();
		bt_room_seat[26] = new JButton();
		bt_room_seat[27] = new JButton();//열람실 3까지 좌석버튼들
		
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


		p_room1.add(bt_room_seat[1]);
		p_room1.add(bt_room_seat[2]);
		p_room1.add(bt_room_seat[3]);
		p_room1.add(bt_room_seat[4]);
		p_room1.add(bt_room_seat[5]);
		p_room1.add(bt_room_seat[6]);
		p_room1.add(bt_room_seat[7]);
		p_room1.add(bt_room_seat[8]);
		p_room1.add(bt_room_seat[9]);

		//==============열람실 2 패널=============
		add(p_room2);
		p_room2.setBounds(300, 60, 510, 510);
		p_room2.setBackground(Color.MAGENTA);
		p_room2.setLayout(new GridLayout(3, 3, 3, 3));
		p_room2.setVisible(false);

		p_room2.add(bt_room_seat[10]);
		p_room2.add(bt_room_seat[11]);
		p_room2.add(bt_room_seat[12]);
		p_room2.add(bt_room_seat[13]);
		p_room2.add(bt_room_seat[14]);
		p_room2.add(bt_room_seat[15]);
		p_room2.add(bt_room_seat[16]);
		p_room2.add(bt_room_seat[17]);
		p_room2.add(bt_room_seat[18]);

		//==============열람실 3 패널===========

		add(p_room3);
		p_room3.setBounds(300, 60, 510, 510);
		p_room3.setBackground(Color.YELLOW);
		p_room3.setLayout(new GridLayout(3, 3, 3, 3));
		p_room3.setVisible(false);

		p_room3.add(bt_room_seat[19]);
		p_room3.add(bt_room_seat[20]);
		p_room3.add(bt_room_seat[21]);
		p_room3.add(bt_room_seat[22]);
		p_room3.add(bt_room_seat[23]);
		p_room3.add(bt_room_seat[24]);
		p_room3.add(bt_room_seat[25]);
		p_room3.add(bt_room_seat[26]);
		p_room3.add(bt_room_seat[27]);

		//=================================
		setLayout(null);
		setBounds(100, 100, 1100, 700);
		setVisible(true);
		
	}//생성자

	  public void showMsg(String msg) {
		   JOptionPane.showMessageDialog(this, msg);
	   }//showMsg
	   
	   public String showInput(String msg) {
		   return JOptionPane.showInputDialog(this, msg);
	   }//showInput
	   
	   public int showConfirm(String msg) {
		   return JOptionPane.showConfirmDialog(this, msg);
	   }//showConfirm
	   

	public static void main(String[] args) {

		new SeatReserveSelectWindow();

	}

}

