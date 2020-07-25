package com.Student.service;

import java.util.List;

import com.Student.Dao.StudentDao;

import cn.Model.haha.Student;

public class Studentservice {
	
		StudentDao dao=new StudentDao();
		//增加
		public int Add(Student stu) {
			if(dao.exist(stu.getId())==1) {
				return 0;
			}else {
				int result = dao.Add(stu);
				return result;
			}
		}
		//删除
		public int delete(int id) {
			if(dao.exist(id)==1) {
				int result = dao.delete(id);
				return result;
			}else {
				return 0;
			}
		}
		//修改
		public int update(int id,Student stu) {
			if(dao.exist(id)==1) {
				int result = dao.update(stu, id);
				return result;
			}else {
				return 0;
			}
		}
		//学号查询信息
		public Student querybyid(int id) {
				if(dao.exist(id)==1) {
					Student student = dao.QueryStudentbyId(id);
					return student;
				}else {
					return null;
				}
				
			}
		//分页查询信息
		public List<Student> querybypage(int currentPage,int PageSize) {
			List<Student> students = dao.QuerybyPage(currentPage, PageSize);
			return students;
		}
		//查询总量
		public int count() {
			int count = dao.Count();
			return count;
		}
		//删除所有学生
		public int delall(String del) {
			int result = dao.delall(del);
			return result;
		}
}
