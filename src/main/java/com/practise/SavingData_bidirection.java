package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;
import com.practise.Entity.BookReview;
import com.practise.Utility.HibernateUtility;

public class SavingData_bidirection {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
	
		Book book = new Book();
		book.setTitle("The Alchemist");
		book.setAuthorName("Paulo Coelho");
		book.setISBN_No("9780061122415");
		book.setAvailableCopies(6);
		
		
		BookReview breview = new BookReview();
		breview.setRating(4.3);
		breview.setReviewerName("Emma Wilson");
		breview.setComment("A beautiful journey of hope");
		breview.setBook(book);
		
		session.persist(breview);
		transaction.commit();
		session.close();
	}
}
