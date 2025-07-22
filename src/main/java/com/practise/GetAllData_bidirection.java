package com.practise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;
import com.practise.Entity.BookReview;
import com.practise.Utility.HibernateUtility;

public class GetAllData_bidirection {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<BookReview> reviewList = session.createQuery("select b FROM BookReview b", BookReview.class).getResultList();

		reviewList.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
}
