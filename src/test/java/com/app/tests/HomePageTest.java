package com.app.tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.pages.BasePage;
import com.app.pages.HomePageObjects;
import com.app.pages.SearchObject;

public class HomePageTest {

	HomePageObjects homePage;
	SearchObject searchPage;
	BasePage bp;

	public HomePageTest() {
		homePage = new HomePageObjects();
		bp = new BasePage();
	}

	@Test
	public void verifyTabRow() {
		homePage.displayWomenTab();
		homePage.dispalyDressesTab();
		homePage.displayTshirtTab();
	}

	@Test
	public void verifyFrontPageList() {

		homePage.clickWomenTab();
		String getValue = homePage.getTextWomenTab();
		Assert.assertTrue(getValue.contentEquals("There are 7 products."), ("Failed - There is exception in WOMEN"));

		homePage.clickDressesTab();
		String getValueone = homePage.getTextDressesTab();
		Assert.assertTrue(getValueone.contentEquals("There are 5 products."), ("Failed - There is exception"));

		homePage.clickTshirtTab();
		String getValuetwo = homePage.getTextTshirtTab();
		Assert.assertTrue(getValuetwo.contentEquals("There is 1 product."), ("Failed - There is exception"));
	}

	@Test
	public void verifyEmail() {
		homePage.loginToEmail();
		Assert.assertTrue(homePage.successfulLoginText());
	}

	@Test
	public void verifyDressesSizeList() {

		homePage.clickWomenTab();
		homePage.displaySizeSmall();
		homePage.clickDressesTab();
		homePage.displaySizeMedium();
		homePage.clickTshirtTab();
		homePage.displaySizeLarge();
	}

	@Test
	public void verifyProductCount() {

		homePage.clickDressesTab();
		int actual = homePage.getProductCountFromHeader();
		int expected = homePage.getProductCount();
		Assert.assertTrue(actual == expected, "Failed, Count not Matched");
	}

	@Test
	public void verifyImageAddedToCart() {
		homePage.clickTheDressesTab();
		Assert.assertTrue(homePage.imageMouseHover(), "Failed, Product not added");
	}
	
	public void imageClickSuccess(){
		searchPage.clickTheDressesTab();
	}

}
