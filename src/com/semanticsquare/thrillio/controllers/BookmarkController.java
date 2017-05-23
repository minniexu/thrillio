package com.semanticsquare.thrillio.controllers;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookMark;
import com.semanticsquare.thrillio.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	public static BookmarkController getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}
	
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		UserBookMark userbookmark = new UserBookMark();
		userbookmark.setBookmark(bookmark);
		userbookmark.setUser(user);
	}
	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		// TODO Auto-generated method stub
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
		
	}
	public void share(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		BookmarkManager.getInstance().share(user, bookmark);
	}
}
