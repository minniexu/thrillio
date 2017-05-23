package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test 1: porn in url -- false
		WebLink weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "", "http://www.javaworld.com/article/2072759/porn/taming-tiger--part-2.html",	"http://www.javaworld.com");
		boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertFalse("For porn in url must return false", isKidFriendlyEligible);
		
		//Test 2: porn in title -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2", "", "http://www.javaworld.com/article/2072759/taming-tiger--part-2.html",	"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertFalse("For porn in title must return false", isKidFriendlyEligible);
		
		//Test 3: adult in host -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "", "http://www.adult.com/article/2072759/taming-tiger--part-2.html",	"http://www.adult.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertFalse("For adult in host must return false", isKidFriendlyEligible);
		
		//Test 4: adult in title only -- true
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2", "", "http://www.javaworld.com/article/2072759/taming-tiger--part-2.html",	"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertTrue("For adult in title only must return false", isKidFriendlyEligible);
		
		//Test 5: adult in url but not in host part -- true
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "", "http://www.javaworld.com/article/2072759/adult/taming-tiger--part-2.html",	"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertTrue("For adult in url but not in host part must return true", isKidFriendlyEligible);
		
	}

}
