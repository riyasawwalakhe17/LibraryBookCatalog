package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.practise.Entity.BookReview;
import com.practise.Utility.HibernateUtility;

public class GetDeleteById_bidirection {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		BookReview bReview = session.find(BookReview.class, 1);
		session.remove(bReview);

		System.out.println("Book Data deleted successfully");
		transaction.commit();
		session.close();
	}
}
