package com.semanticsquare.thrillio.entities;

import java.util.Arrays;

public class Book extends Bookmark{
	private int publicationYear;
	private String publicsher;
	private String[] authors;
	private String genre;
	private double amazonRating;
	
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getPublicsher() {
		return publicsher;
	}
	public void setPublicsher(String publicsher) {
		this.publicsher = publicsher;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getAmazonRating() {
		return amazonRating;
	}
	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}
	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publicsher=" + publicsher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}
	
	
}
