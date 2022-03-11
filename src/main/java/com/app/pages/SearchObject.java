package com.app.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchObject extends BasePage {

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
	
	public SearchObject(){
			PageFactory.initElements(driver, this);	
	}

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
	}
	}
	
	
	

}
