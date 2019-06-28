package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.dao.LibraryDAO;
import model.vo.UserVO;
import view.AllmemberForm;
import view.Joinform;
import view.ServiceForm;
import view.ServiceForm_adm;
import view.UpJoinForm;
import view.loginForm;

public class LibraryController implements ActionListener{
	
	AllmemberForm allmemberForm;
	ServiceForm serviceForm;
	ServiceForm_adm serviceForm_adm;
	Joinform joinForm;
	loginForm loginForm;
	UpJoinForm upJoinForm;
	
	public LibraryController() {
		allmemberForm = new AllmemberForm();
		serviceForm_adm = new ServiceForm_adm();
		eventup();
	}
	
	private void eventup() {
		allmemberForm.bt_sel_name.addActionListener(this);
		allmemberForm.bt_up.addActionListener(this);
		allmemberForm.bt_del.addActionListener(this);
		allmemberForm.bt_exit.addActionListener(this);
		
		allmemberForm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				   allmemberForm.setVisible(false);
				   serviceForm_adm.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==allmemberForm.bt_sel_name) {
			
		}else if(ob==allmemberForm.bt_up) {
			
		}else if(ob==allmemberForm.bt_del) {
			String user_id;
			user_id=allmemberForm.showInput("������ ���̵�:");
			LibraryDAO dao = new LibraryDAO();
			 if(allmemberForm.showConfirm("���� ����/Ż�� �Ͻðڽ��ϱ�?")==0) {
				   
			     if(dao.remove(user_id)) {//���� ������
			    //	allmemberForm.displayTable(dao.findAll());
			     }else {
			    	allmemberForm.showMsg("������ �����Ͽ����ϴ�!!"); 
			     }
		     }
		}else if(ob==allmemberForm.bt_exit) {
			
			allmemberForm.setVisible(false);
			serviceForm_adm.setVisible(true);
			
		} else if(ob==joinForm.bt_submit){//ȸ������â���� ��� ��ư�� ����-������
			LibraryDAO dao = new LibraryDAO();
			
			String id = joinForm.tf_name.getText();
			/*����� �ߺ� Ȯ���ϴ� ����� ������ �����Դϴ�.-������*/
			
			String pwd = new String(joinForm.tf_pwd.getPassword());
			String name = joinForm.tf_name.getText();
			String phone1 = joinForm.tf_phone1.getText();
			String phone2 = joinForm.tf_phone2.getText();
			String phone3 = joinForm.tf_phone3.getText();
			String addr = joinForm.tf_addr.getText();		
			
			UserVO vo = new UserVO();
			vo.setUser_id(id);
			vo.setUser_pwd(pwd);
			vo.setUser_name(name);
			vo.setUser_phone1(phone1);
			vo.setUser_phone2(phone2);
			vo.setUser_phone3(phone3);
			vo.setUser_addr(addr);
			
			if(dao.insert(vo)) {
				joinForm.showMsg("ȸ�����Կ� �����Ͽ����ϴ�.");
				joinForm.setVisible(false);
				loginForm.setVisible(true);
			} else {
				joinForm.showMsg("ȸ�����Կ� �����Ͽ����ϴ�. �Է°��� Ȯ���ϼ���.");
			}
				
		} else if(ob== joinForm.bt_cancel){//ȸ������â���� ��� ��ư�� ����-������
			
			joinForm.setVisible(false);
			loginForm.setVisible(true);
			
		} else if (ob == joinForm.bt_check) {//ȸ������â���� �ߺ�Ȯ�� ��ư�� ����-������
			
			LibraryDAO dao = new LibraryDAO();
			dao.checkId();
		
		} else if(ob == upJoinForm.bt_submit ) {//���������� â���� �����Ϸ� ��ư�� ����-������ 
			
			UserVO vo = new UserVO();
			vo.setUser_pwd(new String(upJoinForm.tf_pwd.getPassword()));
			vo.setUser_phone1(upJoinForm.tf_phone1.getText());
			vo.setUser_phone2(upJoinForm.tf_phone2.getText());
			vo.setUser_phone3(upJoinForm.tf_phone3.getText());
			vo.setUser_addr(upJoinForm.tf_addr.getText());
			
			LibraryDAO dao = new LibraryDAO();
			if (dao.update(vo)) {
				
				upJoinForm.showMsg("�����Ǿ����ϴ�.");
				upJoinForm.setVisible(false);
				serviceForm.setVisible(true);
			} else {
				upJoinForm.showMsg("�Էµ� �����͸� Ȯ���ϼ���.");
			}
			
		} else if(ob == upJoinForm.bt_cancel) {//�� �������� â���� ��� ��ư�� ���� - ������
			
			upJoinForm.setVisible(false);
			serviceForm.setVisible(true);
			
		}
		
	}
	
	public static void main(String[] args) {
		new LibraryController();
	}

}
