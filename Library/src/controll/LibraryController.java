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
	
	//열람실 번호 가져오기
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
			
		}else if(ob==serviceForm.bt_reserv) {//서비스폼에서 예약버튼누를경우 -이진주

			serviceForm.setVisible(false);
			seatForm.setVisible(true);
			
//			1열람실 버튼값을 true로 만들어주기(기본값)
			one=true;
			two=false;
			three=false;
			
//			SeatReserveSelectWindow이 열리면 자동으로 퇴실시간-현재시간 제외한 예약테이블에 예약한 사람들 버튼색 변경해주기
			LibraryDAO dao = new LibraryDAO();
			dao.upOverSit();
			dao.delSit();
			
		}else if(ob==seatForm.bt_room1) {//SeatReserveSelectWindow에서 열람실1버튼 눌렀을경우 -이진주

			seatForm.p_room1.setVisible(true);
			seatForm.p_room2.setVisible(false);
			seatForm.p_room3.setVisible(false);
			
//			1열람실 true로 만들어주기
			one=true;
			two=false;
			three=false;

		}else if(ob==seatForm.bt_room2) {//SeatReserveSelectWindow에서 열람실2버튼 눌렀을경우 -이진주

			seatForm.p_room1.setVisible(false);
			seatForm.p_room2.setVisible(true);
			seatForm.p_room3.setVisible(false);
			
//			2열람실  true로 만들어주기
			one=false;
			two=true;
			three=false;

		}else if(ob==seatForm.bt_room3) {//SeatReserveSelectWindow에서 열람실3버튼 눌렀을경우 -이진주

			seatForm.p_room1.setVisible(false);
			seatForm.p_room2.setVisible(false);
			seatForm.p_room3.setVisible(true);
			
//			3열람실 true로 만들어주기
			one=false;
			two=false;
			three=true;

		}else if(ob==seatForm.bt_logout) {//SeatReserveSelectWindow에서 로그아웃 버튼 눌렀을경우 -이진주

			if(seatForm.showConfirm("로그아웃 하시겠습니까?")==0) {
				seatForm.setVisible(false);
				loginForm.setVisible(true);
			}
		}else if(ob==seatForm.bt_reserve) {//예약버튼 누를시 -이진주
			LibraryDAO dao = new LibraryDAO();
			String sitNum =seatForm.showInput("예약하실 좌석번호를 입력하세요");
			int sit_num = Integer.parseInt(sitNum);
			ReservationVO rv = new ReservationVO();
			UserVO uv = new UserVO();
			SitVO sv = new SitVO();
			
			//시간계산하기
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
					seatForm.showMsg("이미 예약된 자리입니다");
				}else if(dao.reserveInto(rv)&&dao.reserveSit(sv)) {
					seatForm.showMsg("예약되셨습니다!");
				}else {
					seatForm.showMsg("예약실패하였습니다!");
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
					seatForm.showMsg("이미 예약된 자리입니다");
				}else if(dao.reserveInto(rv)&&dao.reserveSit(sv)) {
					seatForm.showMsg("예약되셨습니다!");
				}else {
					seatForm.showMsg("예약실패하였습니다!");
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
					seatForm.showMsg("이미 예약된 자리입니다");
				}else if(dao.reserveInto(rv)&&dao.reserveSit(sv)) {
					seatForm.showMsg("예약되셨습니다!");
				}else {
					seatForm.showMsg("예약실패하였습니다!");
				}
			}
			}//for
		}else if(ob==seatForm.bt_cancel) {//SeatReserveSelectWindow에서 취소버튼 누른경우 -이진주
			seatForm.setVisible(false);
			serviceForm.setVisible(true);
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	}//actionPerformed
	
	public static void main(String[] args) {
		new LibraryController();
	}

}
