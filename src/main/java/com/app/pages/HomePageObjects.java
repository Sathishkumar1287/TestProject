package com.app.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends BasePage {

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	WebElement clickWomenFrontPage;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	WebElement clickDressesFrontPage;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	WebElement clickTshirtFrontPage;

	@FindBy(id = "newsletter-input")
	private WebElement emailInput;
	
	@FindBy(name = "submitNewsletter")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id='columns']/p")
	private WebElement sucessEmailLogin;
	
	@FindBy(id = "layered_id_attribute_group_1")
	private WebElement verifyDressesSmallSize;
	
	@FindBy(id = "layered_id_attribute_group_2")
	private WebElement verifyDressesMediumSize;
	
	@FindBy(id = "layered_id_attribute_group_3")
	private WebElement verifyDressesLargeSize;

	@FindBy(xpath = "//*[@class = 'heading-counter']")
	private WebElement txtHeaderProductCount;

	@FindBys(@FindBy(xpath = "//ul[@class='product_list grid row']/li"))
	private List<WebElement> lstProduct;

	@FindBy(xpath= "//*[@id='center_column']/h1/span[2]")
	private WebElement pageRowTab;
	
	@FindBys(@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_1']/li[1]"))
	private List<WebElement> listProduct;

	//Search Object class
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	WebElement clickONDressesTab;
	
	@FindBy(xpath = "//*[@id=center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
	WebElement clickImage;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	WebElement clickAddCart;
	
	@FindBy (xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2/text()")
	WebElement successfullyAddedCart;
	
	@FindBy (partialLinkText = "View my shopping cart")
	WebElement clickMouseHoverOnCart;
	
	@FindBy (id = "button_order_cart")
	WebElement clickProductAddedOnCart;

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayWomenTab(){
		return clickWomenFrontPage.isDisplayed();
		
	}
	
	public boolean dispalyDressesTab(){
		return clickDressesFrontPage.isDisplayed();
	}
	
	public boolean displayTshirtTab(){
		return clickTshirtFrontPage.isDisplayed();
	}

	public void clickWomenTab() {
		clickWomenFrontPage.click();
	}
	
	public String getTextWomenTab(){
		
		return pageRowTab.getText();	
		
	}
	public void clickDressesTab() {
		clickDressesFrontPage.click();
	}
	
	public String getTextDressesTab(){
		
		return pageRowTab.getText();		
	}
	
	public void clickTshirtTab() {
		clickTshirtFrontPage.click();
	}
	
	public String getTextTshirtTab(){
		
		return pageRowTab.getText();	
	}

	int value = new Random().nextInt(500000);
	public void loginToEmail() {
		String emailID = "sathishkumar"+value+"@gmail.com";
		emailInput.sendKeys(emailID);
		btnLogin.click();
		
	}
	
	public boolean successfulLoginText(){
		return sucessEmailLogin.getText().contains("successfully subscribed");
	}
	
	public boolean displaySizeSmall(){
		verifyDressesSmallSize.click();
		return verifyDressesSmallSize.isDisplayed();
	}
	
	public boolean displaySizeMedium(){
		verifyDressesMediumSize.click();
		return verifyDressesMediumSize.isDisplayed();
	}
	
	public boolean displaySizeLarge(){
		verifyDressesLargeSize.click();
		return verifyDressesLargeSize.isDisplayed();
	}
	
	public int getProductCountFromHeader(){
		/*String headerTxt = txtHeaderProductCount.getText();
		String[] arr = headerTxt.split("");
		String txt = arr[2];
		int value = Integer.parseInt(txt);
		return value;*/
		
		return Integer.parseInt(txtHeaderProductCount.getText().split(" ")[2]);
		
	}

	public int getProductCount() {
		return lstProduct.size();
	}
	
	
	
	//Search Object Method
	
	public void clickTheDressesTab() {
		clickONDressesTab.click();
	}
	
	public void getTextSuccessCase(){
		successfullyAddedCart.getText();
	}
	
	public boolean imageMouseHover(){
		Actions action = new Actions(driver);
		action.moveToElement(clickImage).click(clickAddCart).build().perform();
		
		Alert alert =  driver.switchTo().alert();
		alert.getText();
		System.out.println(alert.getText());
		alert.accept();
		
		action.moveToElement(clickMouseHoverOnCart).click(clickProductAddedOnCart).build().perform();
		return false;
	}
	
	/*public List<String> getnavPanelHeading() {
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement element : navPanelHeading) {
			list.add(element.getText());
		}
		return list;
	}

	public WebElement getImgCustomerSupport() {
		return imgCustomerSupport;
	}

	public WebElement getTitleHome() {
		return titleHome;
	}
	
	public WebElement getlnkAboutUs() {
		return lnkAbousUs;
	}
	
	public WebElement getlnkServices() {
		return lnkServices;
	}
	
	public WebElement getlnkBlog() {
		return lnkBlog;
	}
	
	public WebElement getlnkContact() {
		return lnkContact;
	}	*/
}
