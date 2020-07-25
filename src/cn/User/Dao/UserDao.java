package cn.User.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import cn.Model.haha.User;
import cn.student.util.DBUtil;

public class UserDao {
		//◊¢≤·
		public static int Add(User user) {
			String sql="insert into user(name,password) values(?,?)";
			Object[] params= {user.getName(),user.getPassword()};
			int result = DBUtil.executeUpdate(sql, params);
			return result;
		}
		//≤È—Ø”√ªß
		public static int QueryUser(User user){
			String sql="select * from user where name=? and password=?";
			Object[] arr= {user.getName(),user.getPassword()};
			ResultSet rs = DBUtil.executeQuery(sql, arr);
			try {
				if(rs.next()) {
					return 1;
				}else {
					return 0;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(rs, DBUtil.state, DBUtil.connection);
			}
			return 0;
			
		}
		//≤È—Ø√‹¬Î
		public static String pwd(String name) {
			String sql="select password from user where name=? ";
			Object[] arr= {name};
			ResultSet rs = DBUtil.executeQuery(sql, arr);
			try {
				if(rs.next()) {
					String pwd = rs.getString("password");
					return pwd;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(rs, DBUtil.state, DBUtil.connection);
			}
			return sql;
		}
		//–ﬁ∏ƒ√‹¬Î
		public static int Updatepwd(String pwd,String name) {
			String sql="Update user set password=? where name=?";
			Object[] params= {pwd,name};
			int result = DBUtil.executeUpdate(sql, params);
			return result;
		}
}
