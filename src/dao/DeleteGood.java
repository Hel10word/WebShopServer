package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Good;
import util.DBHelper;

public class DeleteGood extends BaseDao {
	public void deleteGoodsByGoodId(Integer goodid) {
		String sql = "delete from good where ID = ?";
		conn = DBHelper.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, goodid);
			rs = ps.executeQuery();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.closeResouce(conn, ps, rs);
		}
		
	}
}
