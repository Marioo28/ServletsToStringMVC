package com.fdm.repository;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.fdm.model.*;

@Repository
public class PiesaRepository {

	public Set<Piesa> getAllPiese() {
		Set<Piesa> setPiesa = new HashSet<>();

		Session session = HibernateFactory.getSession();
		Transaction tr = session.beginTransaction();
		Query<Piesa> query = session.createQuery("FROM Piesa", Piesa.class);
		List<Piesa> list = query.list();
		setPiesa.addAll(list);
		return setPiesa;
	}

	public void addPiesa(Piesa piesa) {
		Session session = HibernateFactory.getSession();
		Transaction tr = session.beginTransaction();
		Piesa existingPiesa = session.get(Piesa.class, piesa.getId());
		if(existingPiesa == null) {
		session.persist(piesa);
		}else {
			throw new RuntimeException("Same ID");
		}
		tr.commit();
	}

	public void deletePiesa(Integer id) {
		Session session = HibernateFactory.getSession();
		Transaction tr = session.beginTransaction();

		session.remove(getPiesa(id));

		tr.commit();
	}

	public Piesa getPiesa(Integer id) {
		Session session = HibernateFactory.getSession();

		return session.get(Piesa.class, id);
	}

	public void updatePiesa(Piesa piesa) {
		Session session = HibernateFactory.getSession();
		Transaction tr = session.beginTransaction();

		Piesa existingPiesa = session.get(Piesa.class, piesa.getId());
        if (existingPiesa != null) {
            existingPiesa.setStoc(piesa.getStoc());
            session.persist(existingPiesa);
        } 
		tr.commit();
	}

}
