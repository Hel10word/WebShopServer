package domain;

/*******************************************************************************
 * 
 * @author 张不凡  管理员  用户名和密码
 * 
 */

public class Userinfo {
	//用户名
	private String userName;
	//密码
	private String passWord;
	public String getUserName() {
		return userName;
	}
	public Userinfo(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
