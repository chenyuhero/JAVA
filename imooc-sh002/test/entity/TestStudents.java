package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {

	@Test
	public void testSchemaExport() {
		// 创建一个配置对象
		Configuration config = new Configuration().configure();

		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		// 创建sessionFactory
		/*
		 * SessionFactory sessionFactory = config
		 * .buildSessionFactory(serviceRegistry);
		 */
		// 创建session对象
		/*
		 * Session session = sessionFactory.getCurrentSession();
		 */
		// 创建SchemaExport对象
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);

	}

	@Test
	public void testSaveStudents() {
		// 创建一个配置对象
		Configuration config = new Configuration().configure();

		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		// 创建sessionFactory

		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);

		// 创建session对象

		Session session = sessionFactory.getCurrentSession();

		// 创建事物对象
		Transaction tx = session.beginTransaction();

		Students s1 = new Students("s0000001", "张三丰", "男", new Date(), "武当山");

		session.save(s1);
		tx.commit();
		/* sessionFactory.close(); */
	}

}
