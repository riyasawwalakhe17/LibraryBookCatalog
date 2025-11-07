package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;
import com.practise.Entity.BookReview;

import com.practise.Utility.HibernateUtility;

public class SavingData {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		BookReview breview = new BookReview();
		breview.setRating(4.7);
		breview.setReviewerName("Michael Brown");
		breview.setComment("Life-changing and insightful");
	
		Book book = new Book();
		book.setTitle("Atomic Habits");
		book.setAuthorName("James Clear");
		book.setISBN_No("9780735211292");
		book.setAvailableCopies(2);
		book.setBookreview(breview);
		
		System.out.println("Book Data Saved sucessfully");
		session.persist(book);
		transaction.commit();
		session.close();
	}
}
