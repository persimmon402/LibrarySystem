package model.vo;

public class UserVO {

	private int user_num;
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String user_addr;
	private String user_phone1;
	private String user_phone2;
	private String user_phone3;
	
	public UserVO() {
		
	}
	
	public UserVO(int user_num, String user_id, String user_pwd, String user_name, String user_addr, String user_phone1,
			String user_phone2, String user_phone3) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_addr = user_addr;
		this.user_phone1 = user_phone1;
		this.user_phone2 = user_phone2;
		this.user_phone3 = user_phone3;
	}
	
	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public String getUser_phone1() {
		return user_phone1;
	}

	public void setUser_phone1(String user_phone1) {
		this.user_phone1 = user_phone1;
	}

	public String getUser_phone2() {
		return user_phone2;
	}

	public void setUser_phone2(String user_phone2) {
		this.user_phone2 = user_phone2;
	}

	public String getUser_phone3() {
		return user_phone3;
	}

	public void setUser_phone3(String user_phone3) {
		this.user_phone3 = user_phone3;
	}

	@Override
	public String toString() {
		return "userVO [user_num=" + user_num + ", user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name="
				+ user_name + ", user_addr=" + user_addr + ", user_phone1=" + user_phone1 + ", user_phone2="
				+ user_phone2 + ", user_phone3=" + user_phone3 + "]";
	}
}
