package cn.User.service;

import java.util.List;

import cn.Model.haha.User;
import cn.User.Dao.UserDao;

public class Userservice {
		public static int Add(User user) {
			int result = UserDao.Add(user);
			return result;
		}
		public static int QueryUser(User user){
			  int result = UserDao.QueryUser(user);
			return result;
		}
		public static String pwd(String name) {
			String pwd = UserDao.pwd(name);
			return pwd;
		}
		public static int Updatepwd(String pwd,String name) {
			int result = UserDao.Updatepwd(pwd, name);
			return result;
		}
}
