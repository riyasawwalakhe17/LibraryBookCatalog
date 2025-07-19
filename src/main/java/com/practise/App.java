package com.practise;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.practise.Repository.BookRepository;

import com.practise.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("WELCOME TO LIBRARY BOOK CATALOG");
			System.out.println("Please Select as per Requirement");
			System.out.println("1. Add Book");
			System.out.println("2. Search by Author");
			System.out.println("3. Update Available Copies");
			System.out.println("4. Delete by ISBN_No");

			System.out.println("Please Enter your choice: ");
			int choice = sc.nextInt();

			BookRepository user = new BookRepository();
			switch (choice) {
			case 1:
				System.out.println("Please Enter ID: ");
				int bookid = sc.nextInt();
				user.addData();
				break;
				
			case 2:
				System.out.println("Please Enter Author name: ");
				String name = sc.next();
				user.searchData();
				break;
//				
			case 3:
				user.getUpdatedData();
				break;
////			
			case 4:
				System.out.println("Enter ISBN_No: ");
				String ISBN_No = sc.next();
				user.getDeletedData();
				break;
//			}
    	}
    }
 }
}
