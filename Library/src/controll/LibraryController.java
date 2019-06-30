package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.Calendar;

import model.dao.LibraryDAO;
import model.vo.ReservationVO;
import model.vo.SitVO;
import model.vo.UserVO;
import view.AllmemberForm;
import view.Joinform;
import view.SeatReserveSelectWindow;
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
	SeatReserveSelectWindow seatForm;
	
	//������ ��ȣ ��������
	boolean one,two,three;
	
	public LibraryController() {
		allmemberForm = new AllmemberForm();
		serviceForm_adm = new ServiceForm_adm();
		serviceForm = new ServiceForm();
		seatForm = new SeatReserveSelectWindow();
		loginForm = new loginForm();
		eventup();
	}
	
	private void eventup() {
		allmemberForm.bt_sel_name.addActionListener(this);
		allmemberForm.bt_up.addActionListener(this);
		allmemberForm.bt_del.addActionListener(this);
		allmemberForm.bt_exit.addActionListener(this);
		
		serviceForm.bt_reserv.addActionListener(this);
		seatForm.bt_room1.addActionListener(this);
		seatForm.bt_room2.addActionListener(this);
		seatForm.bt_room3.addActionListener(this);
		seatForm.bt_logout.addActionListener(this);
		seatForm.bt_reserve.addActionListener(this);
		
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
			
		}else if(ob==serviceForm.bt_reserv) {//���������� �����ư������� -������

			serviceForm.setVisible(false);
			seatForm.setVisible(true);
			
//			1������ ��ư���� true�� ������ֱ�(�⺻��)
			one=true;
			two=false;
			three=false;
			
//			SeatReserveSelectWindow�� ������ �ڵ����� ��ǽð�-����ð� ������ �������̺� ������ ����� ��ư�� �������ֱ�
			LibraryDAO dao = new LibraryDAO();
			dao.upOverSit();
			dao.delSit();
			
		}else if(ob==seatForm.bt_room1) {//SeatReserveSelectWindow���� ������1��ư ��������� -������

			seatForm.p_room1.setVisible(true);
			seatForm.p_room2.setVisible(false);
			seatForm.p_room3.setVisible(false);
			
//			1������ true�� ������ֱ�
			one=true;
			two=false;
			three=false;

		}else if(ob==seatForm.bt_room2) {//SeatReserveSelectWindow���� ������2��ư ��������� -������

			seatForm.p_room1.setVisible(false);
			seatForm.p_room2.setVisible(true);
			seatForm.p_room3.setVisible(false);
			
//			2������  true�� ������ֱ�
			one=false;
			two=true;
			three=false;

		}else if(ob==seatForm.bt_room3) {//SeatReserveSelectWindow���� ������3��ư ��������� -������

			seatForm.p_room1.setVisible(false);
			seatForm.p_room2.setVisible(false);
			seatForm.p_room3.setVisible(true);
			
//			3������ true�� ������ֱ�
			one=false;
			two=false;
			three=true;

		}else if(ob==seatForm.bt_logout) {//SeatReserveSelectWindow���� �α׾ƿ� ��ư ��������� -������

			if(seatForm.showConfirm("�α׾ƿ� �Ͻðڽ��ϱ�?")==0) {
				seatForm.setVisible(false);
				loginForm.setVisible(true);
			}
		}else if(ob==seatForm.bt_reserve) {//�����ư ������ -������
			LibraryDAO dao = new LibraryDAO();
			String sitNum =seatForm.showInput("�����Ͻ� �¼���ȣ�� �Է��ϼ���");
			int sit_num = Integer.parseInt(sitNum);
			ReservationVO rv = new ReservationVO();
			UserVO uv = new UserVO();
			SitVO sv = new SitVO();
			
			//�ð�����ϱ�
			long retryDate = System.currentTimeMillis(); 
			Timestamp sit_start = new Timestamp(retryDate); 
			Calendar cal = Calendar.getInstance(); 
			cal.setTimeInMillis(sit_start.getTime());
			cal.setTimeInMillis(sit_start.getTime()); 
			cal.add(Calendar.HOUR, 4); 
			Timestamp sit_end = new Timestamp(cal.getTime().getTime()); 			
			
			for(int i=1;i<28;i++) {
			if(one) {
				rv.setRes_num(i);
				rv.setSit_num(sit_num);
				rv.setUser_num(uv.getUser_num());
				rv.setSit_start(sit_start);
				rv.setSit_end(sit_end);

				sv.setSit_num(sit_num);
				sv.setRoom_num(1);
				sv.setSit_check(1);
				
				if(dao.checkSit(sit_num)) {
					seatForm.showMsg("�̹� ����� �ڸ��Դϴ�");
				}else if(dao.reserveInto(rv)&&dao.reserveSit(sv)) {
					seatForm.showMsg("����Ǽ̽��ϴ�!");
				}else {
					seatForm.showMsg("��������Ͽ����ϴ�!");
				}
			}else if(two) {
				rv.setRes_num(i);
				rv.setSit_num(sit_num);
				rv.setUser_num(uv.getUser_num());
				rv.setSit_start(sit_start);
				rv.setSit_end(sit_end);

				sv.setSit_num(sit_num);
				sv.setRoom_num(2);
				sv.setSit_check(1);
				
				if(dao.checkSit(sit_num)) {
					seatForm.showMsg("�̹� ����� �ڸ��Դϴ�");
				}else if(dao.reserveInto(rv)&&dao.reserveSit(sv)) {
					seatForm.showMsg("����Ǽ̽��ϴ�!");
				}else {
					seatForm.showMsg("��������Ͽ����ϴ�!");
				}
			}else if(three) {
				rv.setRes_num(i);
				rv.setSit_num(sit_num);
				rv.setUser_num(uv.getUser_num());
				rv.setSit_start(sit_start);
				rv.setSit_end(sit_end);

				sv.setSit_num(sit_num);
				sv.setRoom_num(3);
				sv.setSit_check(1);
				
				if(dao.checkSit(sit_num)) {
					seatForm.showMsg("�̹� ����� �ڸ��Դϴ�");
				}else if(dao.reserveInto(rv)&&dao.reserveSit(sv)) {
					seatForm.showMsg("����Ǽ̽��ϴ�!");
				}else {
					seatForm.showMsg("��������Ͽ����ϴ�!");
				}
			}
			}//for
		}else if(ob==seatForm.bt_cancel) {//SeatReserveSelectWindow���� ��ҹ�ư ������� -������
			seatForm.setVisible(false);
			serviceForm.setVisible(true);
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	}//actionPerformed
	
	public static void main(String[] args) {
		new LibraryController();
	}

}
