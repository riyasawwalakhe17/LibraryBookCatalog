package com.practise.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;

import com.practise.Utility.HibernateUtility;

public class BookRepository {

	public void addData() {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Book b = new  Book();
		b.setId(5);
		b.setTitle(" Dracula");
		b.setAuthorName("Bram Stoker");
		b.setISBN_No("IJHJ6259");
		b.setAvailableCopies(40);

		session.persist(b);
		transaction.commit();
		session.close();
	}
	
	public void searchData() {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Book> blist = session.createQuery("FROM Book WHERE authorName LIKE :authorName", Book.class).setParameter("authorName", "%Bram Stoker%").getResultList();
		System.out.println("List of Book Details:");
		blist.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
	
	public void getUpdatedData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Updated Availble copies:");
		Book b = session.find(Book.class,2);
		b.setAvailableCopies(80);
		

		transaction.commit();
		session.close();
	}
	
	public void getDeletedData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Deleted Book Details");
		Book b=session.find(Book.class,3);
		session.remove(b);

		transaction.commit();

		session.close();
	}
	
}
