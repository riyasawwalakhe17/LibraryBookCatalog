package com.practise.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_details")
public class Book {

	@Id
	
	private int id;
	
	private String title;
	
	private String authorName;
	
	private String ISBN_No;
	
	private int availableCopies;

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

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authorName=" + authorName + ", ISBN_No=" + ISBN_No
				+ ", availableCopies=" + availableCopies + "]";
	}
	
	
}
