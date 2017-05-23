package com.semanticsquare.thrillio.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.partners.Shareable;

public class Book extends Bookmark implements Shareable{
	private int publicationYear;
	private String publisher;
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
		return publisher;
	}
	public void setPublicsher(String publisher) {
		this.publisher = publisher;
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
		return "Book [publicationYear=" + publicationYear + ", publicsher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}
	@Override
	public boolean isKidFriendlyEligible() {
		// TODO Auto-generated method stub
		if (genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}
	@Override
	public String getItemData() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("<item>");
		sb.append("<type>Book</type>");
		sb.append("<title>").append(getTitle()).append("</title>");
		sb.append("<authors>").append(StringUtils.join(authors,",")).append("</authors>");
		sb.append("<publisher>").append(publisher).append("</publisher>");
		sb.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
		sb.append("<genre>").append(genre).append("</genre>");
		sb.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
		sb.append("</item>");
		
		return sb.toString();
	}
	
	
}
