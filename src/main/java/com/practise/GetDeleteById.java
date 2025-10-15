package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;

import com.practise.Utility.HibernateUtility;

public class GetDeleteById {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Book book = session.find(Book.class, 4);
		session.remove(book);

		System.out.println("Data deleted successfully");
		transaction.commit();
		session.close();
	}
}
