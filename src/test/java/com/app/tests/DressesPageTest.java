package com.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pages.BasePage;
import com.app.pages.HomePageObjects;
import com.app.pages.SearchObject;

public class DressesPageTest {
	
	HomePageObjects homePage;
	SearchObject searchPage;
	BasePage bp;
	//Created the Test Cases
	public DressesPageTest(){
		searchPage = new SearchObject();
		homePage = new HomePageObjects();
		bp = new BasePage();
	}
	
	@Test
	public void imageAddedToCart() {
		Assert.assertTrue(searchPage.imageMouseHover(), "Failed, Product not added");
	}
	
	@Test
	public void imageClickSuccess(){
		searchPage.clickTheDressesTab();
	}

}
