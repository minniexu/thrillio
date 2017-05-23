package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partners.Shareable;
import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
public class View {
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items......");
		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean bookmarked = getBookmarkDecision(bookmark);
					if (bookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("Saved item -- " + bookmark.toString());
					}
				}
				
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					//Mark as Kid-Friendly
					if (bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatus(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
							//bookmark.setKidFriendlyStatus(kidFriendlyStatus);
							//System.out.println("Kid-Friendly Status: " + kidFriendlyStatus + " , " + bookmark.toString());
						}
					}
					//Sharing
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						if (isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}
					
				}
				
			}
		}
		
		
		
	}
	
	//TODO Below methods are used to simulate users' input
	private static boolean getShareDecision() {
		// TODO Auto-generated method stub
		return Math.random() < 0.5 ? true : false;
	}
	private static String getKidFriendlyStatus(Bookmark bookmark) {
		// TODO Auto-generated method stub
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED : (Math.random() >= 0.5 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
		
	}
	/*public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is booking");
		
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOK_MARK_PER_TYPE);
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
			
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			System.out.println(bookmark.toString());
		}
	}*/
	private static boolean getBookmarkDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub
		return Math.random() < 0.5 ? true : false;
	}
}
