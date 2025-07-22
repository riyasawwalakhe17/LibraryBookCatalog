package com.practise.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookreview_details")
public class BookReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double rating;
	
	private String reviewerName;
	
	private String comment;
	
	@OneToOne(mappedBy = "bookreview")
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookReview [id=" + id + ", rating=" + rating + ", reviewerName=" + reviewerName + ", comment=" + comment
				+ ", book=" + book + "]";
	}
	
	
}
