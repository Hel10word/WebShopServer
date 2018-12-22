package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Good;
import domain.Userinfo;
import util.DBHelper;

/*******************************************************************************
 * 
 * @author 张不凡  用户表数据库操作对象
 * 
 */

//查询出所有的用户和密码
public class UserinfoDao extends BaseDao {
	
	public List<Userinfo> queryUser() {
		List<Userinfo> list = new ArrayList<Userinfo>();
		String sql = "select username,password from userinfo";
		conn = DBHelper.getConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Userinfo userinfo = new Userinfo();
				userinfo.setUserName(rs.getString("username"));
				userinfo.setPassWord(rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public String queryPassWordByUserName(String username) {
		String password = "";
		String sql = "select password from userinfo where username = ?";
		conn = DBHelper.getConn();
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				rs = ps.executeQuery();
				while (rs.next()) {
					password = rs.getString("password");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBHelper.closeResouce(conn, ps, rs);
			}
		return password;
	}
	
	
	
//测试
//	public static void main(String[] args) {
//		UserinfoDao userDao =new UserinfoDao();
//		List<Userinfo> list = userDao.queryUser();
//		System.out.println(userDao.queryPassWordByUserName("root"));
//	}
	
	
}
