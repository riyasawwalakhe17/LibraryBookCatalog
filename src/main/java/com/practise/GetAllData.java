package com.practise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;

import com.practise.Utility.HibernateUtility;

public class GetAllData {
		public static void main(String[] args) {
			SessionFactory factory = HibernateUtility.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			List<Book> bookList = session.createQuery("select b FROM Book b", Book.class).getResultList();

			System.out.println("List of Books: ");
			bookList.stream().forEach(k -> System.out.println(k.toString()));

			transaction.commit();
			session.close();
		}
}
