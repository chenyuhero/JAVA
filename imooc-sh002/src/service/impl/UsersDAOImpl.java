package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.UsersDAO;
import db.MyHibernateSessionFactory;
import entity.Users;

public class UsersDAOImpl implements UsersDAO {

	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		// 事物对象
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			hql = "from Users where username=? and password=?";
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit();
			if (list.size() > 0) {
				return true;

			} else {
				return false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		} finally {
			if (tx != null) {
				// tx.commit();
				tx = null;
			}
		}

	}

}
