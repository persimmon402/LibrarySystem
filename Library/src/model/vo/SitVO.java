package model.vo;

public class SitVO {

	private int sit_num;
	private int room_num;
	private int sit_check;

	public SitVO() {
		
	}

	public SitVO(int sit_num, int room_num, int sit_check) {
		super();
		this.sit_num = sit_num;
		this.room_num = room_num;
		this.sit_check = sit_check;
	}
	
	public int getSit_num() {
		return sit_num;
	}

	public void setSit_num(int sit_num) {
		this.sit_num = sit_num;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public int getSit_check() {
		return sit_check;
	}

	public void setSit_check(int sit_check) {
		this.sit_check = sit_check;
	}

	@Override
	public String toString() {
		return "SitVO [sit_num=" + sit_num + ", room_num=" + room_num + ", sit_check=" + sit_check + "]";
	}

	
}