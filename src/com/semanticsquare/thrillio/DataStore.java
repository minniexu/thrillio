package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.Gender;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.entities.*;
import com.semanticsquare.thrillio.managers.*;

public class DataStore {
	public static final int USER_BOOKMARK_LIMIT = 5;
	public  static final int BOOK_MARK_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;
	private static User[] users = new User[TOTAL_USER_COUNT];
	
	public static User[] getUsers() {
		return users;
	}
	
	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOK_MARK_PER_TYPE];
	
	
	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}

	private static UserBookMark[] userBookmarks = new UserBookMark[USER_BOOKMARK_LIMIT * TOTAL_USER_COUNT];
	
	private static int bookmarkIndex = 1;
	public static UserBookMark[] getUserBookmarks() {
		return userBookmarks;
	}

	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}
	private static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE, UserType.USER);
		users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com","test", "Sam", "M", Gender.MALE, UserType.USER);
	}
	private static void loadBooks() {
		bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications",	new String[]{"Henry", "David", "Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
	}
	private static void loadMovies() {
		bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,	new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
	}
	private static void loadWebLinks() {
		bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com", "unknown");
		
	}

	public static void add(UserBookMark userbookmark) {
		// TODO Auto-generated method stub
		userBookmarks[bookmarkIndex] = userbookmark;
		bookmarkIndex++;
		
	}
	
	
}
