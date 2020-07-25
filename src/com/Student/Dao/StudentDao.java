package com.Student.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.Model.haha.Student;
import cn.student.util.DBUtil;

public class StudentDao {
		//����
		public static int Add(Student stu) {
			String sql="insert into student values(?,?,?,?,null,?) ";
			Object[] params= {stu.getId(),stu.getName(),stu.getAge(),stu.getAddress(),stu.getTime2()};
			int result = DBUtil.executeUpdate(sql, params);
			return result;
		}
		//ɾ��
		public static int delete(int id) {
			String sql="delete from student where id=?";
			Object[] arr= {id};
			int result = DBUtil.executeUpdate(sql, arr);
			return result;
		}
		//�޸�
		public static int update(Student stu,int id) {
			String sql="update student set name=?,age=?,address=?,time2=? where id=? ";
			Object[] arr= {stu.getName(),stu.getAge(),stu.getAddress(),stu.getTime2(),id};
			int result = DBUtil.executeUpdate(sql, arr);
			return result;
		}
		//����
		public static int exist(int id) {
			String sql="select count(*) from student where id=?";
			Object[] arr= {id};
			ResultSet rs = DBUtil.executeQuery(sql, arr);
			int count=0;
			try {
				if(rs.next()) {
					 count = rs.getInt("count(*)");
				}
				return count;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(rs, DBUtil.state, DBUtil.connection);
			}
			return 0;
		}
		//ѧ�Ų���Ϣ
		public static Student QueryStudentbyId(int id) {
			String sql="select * from student where id=?";
			Object[] arr= {id};
			ResultSet rs = DBUtil.executeQuery(sql, arr);
			Student stu=null;
			try {
				if(rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String address = rs.getString("address");
					String time1 =rs.getString("time1");
					String time2 =rs.getString("time2");
					stu=new Student(id,name,age,address,time1,time2);
					
				}
				return stu;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(rs, DBUtil.state, DBUtil.connection);
			}
			return null;
		}
		//��ҳ����Ϣ
		public static List<Student> QuerybyPage(int currentPage,int PageSize) {
			String sql="select * from student limit ?,?";
			int a=currentPage*PageSize;
			Object[] arr= {a,PageSize};
			ResultSet rs = DBUtil.executeQuery(sql, arr);
			List<Student> students=new ArrayList<Student>();
			try {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String address = rs.getString("address");
					String time1 =rs.getString("time1");
					Student student=new Student(id,name,age,address,time1);
					students.add(student);
				}
				return students;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(rs, DBUtil.state, DBUtil.connection);
			}
			return null;
		}
		//��ѯ����
		public static int Count() {
			String sql="select count(*) from student";
			int count = DBUtil.getCount(sql);
			return count;
		}
		//ɾ������ѧ��
		public static int delall(String del) {
			String sql="delete from student where id in("+del+")";
			int result = DBUtil.executeUpdate(sql, null);
			return result;
		}
		//Excel�������ݿ�
		public static void addStudentBatch(List<Student> list) {
			 String URL="jdbc:mysql://localhost:3306/student";
			 String user="root";
			 String password="root";
			 PreparedStatement pstmt=null;
			 Connection conn=null;
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				  conn = DriverManager.getConnection(URL, user, password);
				 String sql="insert into student values(?,?,?,?,null,?)";
				  pstmt = conn.prepareStatement(sql);
				 conn.setAutoCommit(false);
		    		pstmt = conn.prepareStatement(sql);
		    		for(Student stu:list){
					pstmt.setInt(1, stu.getId());
					pstmt.setString(2, stu.getName());
					pstmt.setInt(3, stu.getAge());
					pstmt.setString(4, stu.getAddress());
					pstmt.setString(5, stu.getTime2());
					//1. ��һ��SQL������������б�
					pstmt.addBatch();   
		    		}
		    		   //2.ִ��batch
					pstmt.executeBatch();
		             //3.���batch
				    pstmt.clearBatch();
		    		//�ύ����
		            conn.commit();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//��ѯ����ѧ��
		public static List<Student> QueryAllStuden() {
			String sql="select * from student";
			ResultSet rs = DBUtil.executeQuery(sql, null);
			List<Student> students=new ArrayList<Student>();
			try {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String address = rs.getString("address");
					String time1 =rs.getString("time1");
					String time2 =rs.getString("time2");
					Student student=new Student(id,name,age,address,time1,time2);
					students.add(student);
				}
				return students;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(rs, DBUtil.state, DBUtil.connection);
			}
			return null;
		}
	}
