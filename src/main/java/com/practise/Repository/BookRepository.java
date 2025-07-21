package com.practise.Repository;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Book;

import com.practise.Utility.HibernateUtility;

public class BookRepository {

	public void addData(Scanner sc) {
		Book b = new Book();
		sc.nextLine(); // to consume the leftover newline from previous nextInt()

		System.out.print("Enter id: ");
		int id = sc.nextInt();

		sc.nextLine();
		System.out.print("Enter title: ");
		String title = sc.nextLine();

		System.out.print("Enter author: ");
		String author = sc.nextLine();

		System.out.print("Enter isbn: ");
		String isbn = sc.nextLine();

		System.out.print("Enter available copies: ");
		int availableCopies = sc.nextInt();

		sc.nextLine(); // again, consume newline

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		b.setId(id);
		b.setTitle(title);
		b.setAuthorName(author);
		b.setISBN_No(isbn);
		b.setAvailableCopies(availableCopies);

		session.persist(b);
		transaction.commit();
		session.close();

		System.out.println("Book Details Added successfully ");
	}

	public void searchData(Scanner sc) {

		System.out.println("Enter author name to search: ");
		sc.nextLine(); // clear the buffer if nextInt() was used before
		String author = sc.nextLine();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Book> elist = session.createQuery("FROM Book WHERE author LIKE :authorName", Book.class)
				.setParameter("name", author).getResultList();
		System.out.println("List of Book Details:");
		elist.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}

	public void updateData(Scanner sc) {
		System.out.println("Enter Id to update available copies : ");
		int id = sc.nextInt();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Book b = session.find(Book.class, id);
		System.out.println("Enter new available copies :");
		int update = sc.nextInt();

		b.setAvailableCopies(update);

		transaction.commit();
		session.close();
		System.out.println("Salary updated ");
	}

	public void deleteData(Scanner sc) {
		System.out.println("Enter the isbn to delete book : ");
		int isbn = sc.nextInt();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Book b = session.find(Book.class, isbn);
		session.remove(b);

		transaction.commit();
		session.close();

		System.out.println("Book details deleted ");
	}

}
