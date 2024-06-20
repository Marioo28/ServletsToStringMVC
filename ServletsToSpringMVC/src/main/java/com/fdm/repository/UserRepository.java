//package com.fdm.repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//import org.springframework.stereotype.Repository;
//
//import com.fdm.model.User;
//
//@Repository
//public class UserRepository {
//
//	public void addUser(User user) {
//
//		Session session = HibernateFactory.getSession();
//		Transaction transaction = session.beginTransaction();
//
//		User existingUser = session.get(User.class, user.getUsername());
//		if (existingUser == null) {
//			session.persist(user);
//
//		} else {
//			throw new RuntimeException("Username Exists");
//		}
//		transaction.commit();
//
//	}
//
//	public void updateUser(User user) {
//		Session session = HibernateFactory.getSession();
//		Transaction tr = session.beginTransaction();
//		User existingUser = session.get(User.class, user.getUsername());
//
//		if (existingUser != null) {
//			existingUser.setFirstName(user.getFirstName());
//			existingUser.setLastName(user.getLastName());
//			existingUser.setPassword(user.getPassword());
//			existingUser.setAge(user.getAge());
//			existingUser.setType(user.getType());
//
//			session.persist(existingUser);
//		}
//		tr.commit();
//	}
//
//	public Set<User> getAllUsers() {
//		Set<User> setUser = new HashSet<>();
//
//		Session session = HibernateFactory.getSession();
//		Query<User> query = session.createQuery("FROM User", User.class);
//		List<User> userList = query.list();
//		setUser.addAll(userList);
//
//		return setUser;
//	}
//
//	public void deleteUser(String username) {
//		User user = getUser(username);
//		Session session = HibernateFactory.getSession();
//
//		Transaction tr = session.beginTransaction();
//		session.remove(user);
//		tr.commit();
//	}
//
//	public User getUser(String username) {
//		User user = null;
//
//		Session session = HibernateFactory.getSession();
//		user = session.get(User.class, username);
//
//		return user;
//	}
//}
