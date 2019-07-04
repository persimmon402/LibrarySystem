package com.library.view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.library.model.vo.UserVO;

public class AllmemberForm extends JFrame {

	DefaultTableModel dtm;
	public JTable table;
	// public �������? �ٸ� ��Ű���� �ִ� Ŭ����(��Ʈ�ѷ�)���� ����ϱ� ����.
	JScrollPane scroll_table;

	public JButton /* bt_sel_all, */ bt_del, bt_up, bt_sel_name, bt_exit;

	JPanel southp;

	public AllmemberForm() {
		setTitle("ȸ������");

		Object[][] rowData = new Object[0][7];
		String[] columTitle = { "ȸ����ȣ(pk)", "���̵�", "�̸�", "��ȭ��ȣ", "�ּ�" }; // ���Ȼ� ��й�ȣ�� �����߽��ϴ�
		dtm = new DefaultTableModel(rowData, columTitle);

		table = new JTable(dtm);
		scroll_table = new JScrollPane(table);

		table.setFont(new Font(null, 0, 20)); // ���̺� Ŭ�� ũ��
		table.setRowHeight(30);// ���̺� �� ���� ����

//      bt_sel_all = new JButton("��ü����");
		bt_sel_name = new JButton("�˻�");
		bt_up = new JButton("����");
		bt_del = new JButton("����");
		bt_exit = new JButton("������");

		southp = new JPanel();
//        southp.add(bt_sel_all);
		southp.add(bt_sel_name);
		southp.add(bt_up);
		southp.add(bt_del);
		southp.add(bt_exit);

		add("Center", scroll_table);
		add("South", southp);

		setBounds(300, 300, 1100, 700);
//      setVisible(true);

	}// ������
//    =================6/27 �߰��� �޼ҵ��============================

	public void displayTable(ArrayList<UserVO> list) {
		dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {
			UserVO vo = list.get(i);
			String user_phone1 = vo.getUser_phone1();
			String user_phone2 = vo.getUser_phone2();
			String user_phone3 = vo.getUser_phone3();

			String phoneNum = user_phone1 + "-" + user_phone2 + "-" + user_phone3;

			Object[] rowData = { vo.getUser_num(), vo.getUser_id(), vo.getUser_name(), phoneNum, vo.getUser_addr() };
			dtm.addRow(rowData);
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

//    public static void main(String[] args) {
//    new AllmemberForm();
// }
}// ServiceForm