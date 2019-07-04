package com.library.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.library.model.vo.UserVO;

public class UpJoinForm extends JFrame{
	public JTextField tf_id, tf_name, tf_phone1, tf_phone2, tf_phone3, tf_addr;
	public JPasswordField tf_pwd;
	public JButton bt_check, bt_submit, bt_cancel;
	public JLabel la_title, la_id, la_pwd, la_name, la_phone, la_addr, la_bar1, la_bar2;
	public JPanel p_back;
	
	
	public UpJoinForm() {
		setTitle("내정보수정");
		Color c = new Color(151, 216, 244);
		p_back = new JPanel();
		tf_id = new JTextField();
		tf_name = new JTextField(); 
		tf_phone1 = new JTextField();
		tf_phone2 = new JTextField();
		tf_phone3 = new JTextField();
		tf_addr = new JTextField();
		
		tf_pwd = new JPasswordField();
		
		bt_check = new JButton("중복확인");
		bt_submit = new JButton("등록");
		bt_cancel = new JButton("취소");
	
		la_title = new JLabel("내정보 수정");
		la_id = new JLabel("ID              :");
		la_pwd = new JLabel("비밀번호   :");
		la_name = new JLabel("이름          :");
		la_phone = new JLabel("전화번호   :");
		la_addr = new JLabel("주소          :");
		la_bar1 = new JLabel("-");
		la_bar2 = new JLabel("-");
		
		la_title.setFont(la_title.getFont().deriveFont(35.0f));
		la_id.setFont(la_id.getFont().deriveFont(25.0f));
		la_pwd.setFont(la_id.getFont().deriveFont(25.0f));
		la_name.setFont(la_id.getFont().deriveFont(25.0f));
		la_phone.setFont(la_phone.getFont().deriveFont(25.0f));
		la_bar1.setFont(la_bar1.getFont().deriveFont(25.0f));
		la_bar2.setFont(la_bar2.getFont().deriveFont(25.0f));
		la_addr.setFont(la_addr.getFont().deriveFont(25.0f));
		
		tf_id.setFont(tf_id.getFont().deriveFont(25.0f));
		tf_name.setFont(tf_name.getFont().deriveFont(25.0f));
		tf_pwd.setFont(tf_pwd.getFont().deriveFont(25.0f));
		tf_phone1.setFont(tf_phone1.getFont().deriveFont(25.0f));
		tf_phone2.setFont(tf_phone2.getFont().deriveFont(25.0f));
		tf_phone3.setFont(tf_phone3.getFont().deriveFont(25.0f));
		tf_addr.setFont(tf_addr.getFont().deriveFont(25.0f));
		
		la_title.setBounds(450, 5, 500, 100);
		
		la_id.setBounds(350, 130, 200, 40);
		tf_id.setBounds(500, 130, 200, 40);
		tf_id.setEditable(false);
		
		la_pwd.setBounds(350, 200, 200, 40);
		tf_pwd.setBounds(500, 200, 200, 40);
		tf_pwd.setFocusable(true);
		
		la_name.setBounds(350, 270, 200, 40);
		tf_name.setBounds(500, 270, 200, 40);
		
		la_phone.setBounds(350, 340, 200, 40);
		tf_phone1.setBounds(500,340, 60, 40);
		
		la_bar1.setBounds(565, 340, 10, 40);
		tf_phone2.setBounds(580,340, 60, 40);
		la_bar2.setBounds(645,340,10,40);
		tf_phone3.setBounds(660,340, 60, 40);
		
		la_addr.setBounds(350, 410, 200, 40);
		tf_addr.setBounds(500, 410, 220, 40);
		
		bt_submit.setBounds(450, 510, 80, 40);
		bt_cancel.setBounds(570, 510, 80, 40);
		
		
		
		p_back.add(tf_id);
		p_back.add(tf_pwd);
		p_back.add(tf_name);
		p_back.add(tf_phone1);
		p_back.add(tf_phone2);
		p_back.add(tf_phone3);
		p_back.add(tf_addr);
		p_back.add(la_title);
		p_back.add(la_id);
		p_back.add(la_pwd);
		p_back.add(la_name);
		p_back.add(la_phone);
		p_back.add(la_addr);
		p_back.add(la_bar1);
		p_back.add(la_bar2);
		p_back.add(bt_check);
		p_back.add(bt_submit);
		p_back.add(bt_cancel);
		
		bt_submit.setBackground(c);
		bt_submit.setForeground(Color.black);
		bt_cancel.setBackground(c);
		bt_cancel.setForeground(Color.black);
		bt_check.setBackground(c);
		bt_check.setForeground(Color.black);
		p_back.setBackground(Color.white);
		p_back.setLayout(null);
		setContentPane(p_back);
		setBounds(300, 200, 1100, 700);
		setVisible(false);
	}
	
	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public void initText(UserVO vo) {
		tf_id.setText(vo.getUser_id());
		tf_pwd.setText(vo.getUser_pwd());
		tf_name.setText(vo.getUser_name());
		tf_phone1.setText(vo.getUser_phone1());
		tf_phone2.setText(vo.getUser_phone2());
		tf_phone3.setText(vo.getUser_phone3());
		tf_addr.setText(vo.getUser_addr());
		
	}


//	public static void main(String[] args) {
//		new UpJoinForm();
//	}

}// class
