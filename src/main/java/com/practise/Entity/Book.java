package com.practise.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String authorName;
	
	private String ISBN_No;
	
	private int availableCopies;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private BookReview bookreview;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getISBN_No() {
		return ISBN_No;
	}

	public void setISBN_No(String iSBN_No) {
		ISBN_No = iSBN_No;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	
	

	public BookReview getBookreview() {
		return bookreview;
	}

	public void setBookreview(BookReview bookreview) {
		this.bookreview = bookreview;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authorName=" + authorName + ", ISBN_No=" + ISBN_No
				+ ", availableCopies=" + availableCopies + "]";
	}
	
	
}
