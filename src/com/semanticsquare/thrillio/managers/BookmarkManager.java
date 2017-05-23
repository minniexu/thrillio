package com.semanticsquare.thrillio.managers;

import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookMark;
import com.semanticsquare.thrillio.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance() {
		return instance;
	}
	
	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast, String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);
		
		return movie;
	}
	
	public Book createBook(long id, String title, String profileUrl, int publicationYear, String publicsher, String[] authors, String genre, double amazonRating) {
		Book book = new Book();
		
		book.setId(id);
		book.setTitle(title);
		book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublicsher(publicsher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		
		return book;
	}
	
	public WebLink createWebLink(long id, String title, String profileUrl, String url, String host) {
		WebLink weblink = new WebLink();
		
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl);
		weblink.setUrl(url);
		weblink.setHost(host);
		
		return weblink;	
	}
	
	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}
	
	public void saveUserBookmark(User user, Bookmark bookmark) {		
		UserBookMark userbookmark = new UserBookMark();
		userbookmark.setBookmark(bookmark);
		userbookmark.setUser(user);
		
		dao.saveUserBookmark(userbookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		// TODO Auto-generated method stub
		bookmark.setKidFriendlyMarkedBy(user);
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", Marked by:" + user.getEmail() + "," + bookmark);
		
	}

	public void share(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		bookmark.setShareBy(user);
		System.out.println("Data to be shared: ");
		if (bookmark instanceof Book) {
			System.out.println(((Book) bookmark).getItemData());
		} else if (bookmark instanceof WebLink) {
			System.out.println(((WebLink) bookmark).getItemData());
		}
 		
	}
}
