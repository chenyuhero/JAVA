package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.StudentsDAO;
import db.MyHibernateSessionFactory;
import entity.Students;

public class StudentsDAOImpl implements StudentsDAO {
	// 查询所有学生资料
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);

			list = query.list();
			tx.commit();
			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}

	}

	// 生成学生的编号
	public String getNewSid() {
		Transaction tx = null;
		String hql = "";
		String sid = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			// 获取当前学生的最大编号
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if (sid == null || "".equals(sid)) {
				// 默认的最大编号
				sid = "s0000001";

			} else {
				String temp = sid.substring(1);// 去掉前面的一位（s）
				int i = Integer.parseInt(temp);// 将字符转成数字
				i++;
				// 再还原为字符串
				temp = String.valueOf(i);
				int len = temp.length();
				// 凑够7位
				for (int j = 0; j < 7 - len; j++) {
					temp = "0" + temp;
				}
				temp = "s" + temp;
			}
			tx.commit();
			return sid;
		} catch (Exception ex) {

			ex.printStackTrace();
			tx.commit();
			return null;
		} finally {

			if (tx != null) {
				tx = null;
			}

		}

	}

	// 根据学生编号查询学生资料
	public Students queryStudentsBySid(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Students s = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			s = (Students) session.get(Students.class, sid);

			tx.commit();
			return s;

		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return s;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}

	}

	// 添加学生资料
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		s.setSid(getNewSid());// 设置学生的学号
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		} finally {
			if (tx != null) {
				tx = null;
			}

		}

	}

	// 修改学生资料
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		} finally {
			if (tx != null) {
				tx = null;
			}

		}
	}

	// 删除学生资料

	public boolean deleteStudents(String sid) {
		Transaction tx = null;
		// String hql = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();

			tx = session.beginTransaction();
			Students s = (Students) session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return false;

		} finally {

		}

	}

}
