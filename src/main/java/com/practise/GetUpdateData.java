package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;

import com.practise.Utility.HibernateUtility;

public class GetUpdateData {
	
		public static void main(String[] args) {
			SessionFactory factory = HibernateUtility.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Book book = session.find(Book.class, 2);
			book.setTitle("Deep Work");
			book.setAuthorName("Cal Newport");
			book.setISBN_No("9781455586691");
			book.setAvailableCopies(7);

			/*
			 * Here We need to get document first and then set it so it will change value in
			 */

			book.getBookreview().setRating(4.6);
			book.getBookreview().setReviewerName("Daniel Grey");
			book.getBookreview().setComment("Great insights on focus and productivity");
			

			transaction.commit();
			session.close();
		}
}
