package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.DataStore;
public class View {
	public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + "is booking");
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOK_MARK_PER_TYPE);
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
			
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			System.out.println(bookmark.toString());
		}
	}
}
