package com.semanticsquare.thrillio.dao;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.entities.*;
public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
	public void saveUserBookmark(UserBookMark userbookmark) {
		DataStore.add(userbookmark);
		
	}
}
