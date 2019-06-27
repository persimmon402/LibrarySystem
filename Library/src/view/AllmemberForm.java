package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AllmemberForm extends JFrame {
	
	   DefaultTableModel dtm;
	   public JTable table;
	   //public 명시이유? 다른 패키지에 있는 클래스(컨트롤러)에서 사용하기 때문.
	   JScrollPane scroll_table;
	   
	   public JButton /*bt_sel_all,*/ bt_del, bt_up, bt_sel_name, bt_exit;
	   
	   JPanel southp;

	   public AllmemberForm() {
		  setTitle("회원정보");
		  
		  Object [][]rowData = new Object[0][7];	  
		  String []columTitle = {"NO.","회원번호(pk)","아이디","이름","전화번호","주소"};	  //보안상 비밀번호를 제거했습니다
		  dtm = new DefaultTableModel(rowData,columTitle);

		  table = new JTable(dtm);
		  scroll_table = new JScrollPane(table);
		  
		  
//		  bt_sel_all = new JButton("전체보기");
		  bt_sel_name = new JButton("검색");
		  bt_up = new JButton("수정");
		  bt_del = new JButton("삭제");
		  bt_exit = new JButton("나가기");
		  
		  southp = new JPanel();
//		    southp.add(bt_sel_all);
		    southp.add(bt_sel_name);
		    southp.add(bt_up);
		    southp.add(bt_del);
		    southp.add(bt_exit);
		    
		    
		  add("Center", scroll_table);
		  add("South", southp);
		  
		  setBounds(300,300,1100,700);
		  setVisible(true);
		  
		  
	   }//생성자
	   
	   public void showMsg(String msg) {
			JOptionPane.showMessageDialog(this, msg);
		}// showMsg
		
		public String showInput(String msg) {
			return JOptionPane.showInputDialog(this, msg);
		}// showInput
		
		public int showConfirm(String msg) {
			return JOptionPane.showConfirmDialog(this, msg);
		}// showConfirm
	   

	   public static void main(String[] args) {
		new AllmemberForm();
	   }
	}//ServiceForm