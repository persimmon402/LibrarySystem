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
			user_id=allmemberForm.showInput("삭제할 아이디:");
			LibraryDAO dao = new LibraryDAO();
			 if(allmemberForm.showConfirm("정말 삭제/탈퇴 하시겠습니까?")==0) {
				   
			     if(dao.remove(user_id)) {//삭제 성공시
			    //	allmemberForm.displayTable(dao.findAll());
			     }else {
			    	allmemberForm.showMsg("삭제에 실패하였습니다!!"); 
			     }
		     }
		}else if(ob==allmemberForm.bt_exit) {
			
			allmemberForm.setVisible(false);
			serviceForm_adm.setVisible(true);
			
		} else if(ob==joinForm.bt_submit){//회원가입창에서 등록 버튼을 누름-김지우
			LibraryDAO dao = new LibraryDAO();
			
			String id = joinForm.tf_name.getText();
			/*여기는 중복 확인하는 기능을 구현할 영역입니다.-김지우*/
			
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
				joinForm.showMsg("회원가입에 성공하였습니다.");
				joinForm.setVisible(false);
				loginForm.setVisible(true);
			} else {
				joinForm.showMsg("회원가입에 실패하였습니다. 입력값을 확인하세요.");
			}
				
		} else if(ob== joinForm.bt_cancel){//회원가입창에서 취소 버튼을 누름-김지우
			
			joinForm.setVisible(false);
			loginForm.setVisible(true);
			
		} else if (ob == joinForm.bt_check) {//회원가입창에서 중복확인 버튼을 누름-김지우
			
			LibraryDAO dao = new LibraryDAO();
			dao.checkId();
		
		} else if(ob == upJoinForm.bt_submit ) {//내정보수정 창에서 수정완료 버튼을 누름-김지우 
			
			UserVO vo = new UserVO();
			vo.setUser_pwd(new String(upJoinForm.tf_pwd.getPassword()));
			vo.setUser_phone1(upJoinForm.tf_phone1.getText());
			vo.setUser_phone2(upJoinForm.tf_phone2.getText());
			vo.setUser_phone3(upJoinForm.tf_phone3.getText());
			vo.setUser_addr(upJoinForm.tf_addr.getText());
			
			LibraryDAO dao = new LibraryDAO();
			if (dao.update(vo)) {
				
				upJoinForm.showMsg("수정되었습니다.");
				upJoinForm.setVisible(false);
				serviceForm.setVisible(true);
			} else {
				upJoinForm.showMsg("입력된 데이터를 확인하세요.");
			}
			
		} else if(ob == upJoinForm.bt_cancel) {//내 정보수정 창에서 취소 버튼을 누름 - 김지우
			
			upJoinForm.setVisible(false);
			serviceForm.setVisible(true);
			
		}
		
	}
	
	public static void main(String[] args) {
		new LibraryController();
	}

}
