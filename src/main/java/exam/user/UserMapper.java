package exam.user;

public interface UserMapper {
	
	//이메일유무
	public int userEmailYn(String user_email);
	
	//가입
	public UserInfoDTO insertUserInfo();
	
}
