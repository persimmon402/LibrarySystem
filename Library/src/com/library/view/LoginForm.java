package com.library.view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
	public JTextField tf_id;
	public JPasswordField tf_pass;
	public JButton bt_login, bt_join, bt_manager;
	public JLabel la_id, la_pass;
	public JPanel back, p_img;

	public LoginForm() {

		Color c = new Color(151, 216, 244);
		setTitle("Login Form");
		back = new JPanel();
		p_img = new JPanel() {
			ImageIcon icon = new ImageIcon("src/image/img_library.png");
			Image img = icon.getImage();

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

		tf_id = new JTextField();
		tf_pass = new JPasswordField();
		tf_id.setFont(new Font("맑은고딕", Font.BOLD, 20));
		tf_pass.setFont(new Font("맑은고딕", Font.BOLD, 25));

		bt_login = new JButton("로그인");
		bt_join = new JButton("회원가입");
		bt_manager = new JButton("관리자");
		bt_join.setFocusable(false);
		bt_join.setBackground(c);
		bt_login.setBackground(c);
		bt_manager.setBackground(c);

		la_pass = new JLabel("Password");
		la_id = new JLabel("I  D");
		la_id.setFont(new Font("맑은고딕", Font.BOLD, 15));
		la_pass.setFont(new Font("맑은고딕", Font.BOLD, 15));

		tf_id.setBounds(500, 30, 230, 60);
		tf_pass.setBounds(500, 95, 230, 60);
		bt_login.setBounds(388, 170, 165, 60);
		bt_join.setBounds(565, 170, 165, 60);
		bt_manager.setBounds(565, 240, 165, 60);
		la_id.setBounds(388, 30, 90, 60);
		la_pass.setBounds(388, 95, 90, 60);
		p_img.setBounds(20, 30, 350, 420);

		back.setLayout(null);
		back.setBackground(Color.WHITE);
		setContentPane(back);

		back.add(tf_id);
		back.add(tf_pass);
		back.add(bt_login);
		back.add(bt_join);
		back.add(bt_manager);
		back.add(la_id);
		back.add(la_pass);
		back.add(p_img);

		setBounds(400, 300, 750, 500);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// X버튼클릭시 전체 응용프로그램 종료

	}// 생성자

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}// showMsg

	public void initText() {
		tf_id.setText("");
		tf_pass.setText("");
		tf_id.requestFocus();
	}

//	public static void main(String[] args) {
//		new LoginForm();
//	}
}// LoginForm
