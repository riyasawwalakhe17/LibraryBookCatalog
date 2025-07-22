package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.practise.Entity.BookReview;
import com.practise.Utility.HibernateUtility;

public class GetDataById_bidirection {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		int id = 1;
		BookReview bReview = session.find(BookReview.class, 2);
		
		transaction.commit();
		session.close();
		System.out.println("DATA for book review with id " + id + " : " + bReview.toString());
	}
}
