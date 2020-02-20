package exam.board;

import java.util.Date;

public class BoardDTO {
	private int board_no;
	private String board_subject;
	private String board_content;
	private Date board_regdate;
	private int board_hit;
	private String today;
	private String board_email;
	

	public String getBoard_email() {
		return board_email;
	}
	public void setBoard_email(String board_email) {
		this.board_email = board_email;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	private String num;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	@Override
	public String toString() {
		return "BoardDTO [board_no=" + board_no + ", board_subject=" + board_subject + ", board_content="
				+ board_content + ", board_regdate=" + board_regdate + ", board_hit=" + board_hit + ", today=" + today
				+ ", board_email=" + board_email + ", num=" + num + "]";
	}
	
	
}
