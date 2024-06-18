package com.fdm.repository;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fdm.model.Piesa;
import com.fdm.model.User;


public class HibernateFactory {

	private static SessionFactory sessionFactory;

	static {
		Configuration con = new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Piesa.class);

		sessionFactory = con.buildSessionFactory();
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

}
