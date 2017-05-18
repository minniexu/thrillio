package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading data ...");

		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
		//System.out.println("printing data ...");
		
		//printUserData();
		//printBookmarkData();;
	}
	private static void printBookmarkData() {
		// TODO Auto-generated method stub
		for (Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {
				System.out.println(bookmark.toString());
			}
		}
	}
	private static void printUserData() {
		// TODO Auto-generated method stub
		for (User user : users) {
			System.out.println(user.toString());
		}
		
	}
	
	private static void startBookmarking() {
		//System.out.println("\n2. Start bookmarking ...");
		
		for (User user : users) {
			View.bookmark(user, bookmarks);
		}
	}
	public static void main(String[] args) {
		loadData();
		startBookmarking();
	}
}
