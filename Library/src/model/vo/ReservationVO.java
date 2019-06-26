package model.vo;

import java.sql.Timestamp;

public class ReservationVO {

	private int res_num;
	private int sit_num;
	private int user_num;
	private Timestamp sit_start;
	private Timestamp sit_end;

	public ReservationVO() {
		
	}

	public ReservationVO(int res_num, int sit_num, int user_num, Timestamp sit_start, Timestamp sit_end) {
		super();
		this.res_num = res_num;
		this.sit_num = sit_num;
		this.user_num = user_num;
		this.sit_start = sit_start;
		this.sit_end = sit_end;
	}
	
	public int getRes_num() {
		return res_num;
	}

	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}

	public int getSit_num() {
		return sit_num;
	}

	public void setSit_num(int sit_num) {
		this.sit_num = sit_num;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public Timestamp getSit_start() {
		return sit_start;
	}

	public void setSit_start(Timestamp sit_start) {
		this.sit_start = sit_start;
	}

	public Timestamp getSit_end() {
		return sit_end;
	}

	public void setSit_end(Timestamp sit_end) {
		this.sit_end = sit_end;
	}


	@Override
	public String toString() {
		return "ReservationVO [res_num=" + res_num + ", sit_num=" + sit_num + ", user_num=" + user_num + ", sit_start="
				+ sit_start + ", sit_end=" + sit_end + "]";
	}

	
}
