package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;
import com.practise.Entity.BookReview;
import com.practise.Utility.HibernateUtility;

public class GetUpdateData_bidirection {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		BookReview bReview = session.find(BookReview.class, 3);
		bReview.setRating(4.4);
		bReview.setReviewerName("Priya Verma");
		bReview.setComment("Spiritually deep and grounding");

		/*
		 * Here We need to get document first and then set it so it will change value in
		 */

		bReview.getBook().setTitle("The Power of Now");
		bReview.getBook().setAuthorName("Eckhart Tolle");
		bReview.getBook().setISBN_No("9781577314806");
		bReview.getBook().setAvailableCopies(5);
		

		transaction.commit();
		session.close();
	}
}
