package com.auction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.auction.init.Common;
import com.auction.pages.auctionregistration.AbstractPage;

public class DashboardPage extends AbstractPage {

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Xpaths
	// -------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//
	/**
	 * Webelements
	 * 
	 */
	@FindBy(xpath = "//input[@id='usr']")
	private WebElement usernameInputID;

	@FindBy(xpath = "//*[@id='sub']")
	private WebElement submitbutton;

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard
	 *            driver
	 */
	public DashboardPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Verify Login Page Elements
	 * 
	 */
	public void verifyLoginPageElements() {

		common.log("<br></br> Step 3 : Verify Login Page Elements.");
		common.waitForConditionIsElementPresent("//input[@id='usr']");

		common.log("Verify Usernsme Text,");
		common.assertElementPresent("//div[text()='Username']");

		common.log("Verify Password,");
		common.assertElementPresent("//div[text()='Password']");

		common.log("Verify Not a Member text,");
		common.assertElementPresent("//h1[text()='Not a member yet?']");

		common.log("Verify Auctions text,");
		common.assertElementPresent("//span[text()='Auctions']");

		common.log("Verify My Items text,");
		common.assertElementPresent("//span[text()='My Items']");

		common.log("Verify My Alerts text,");
		common.assertElementPresent("//span[text()='My Alerts']");

		common.log("Verify Signup text,");
		common.assertElementPresent("//a//span[text()='Signup']"); 
		common.log("Verify Login text,");
		common.assertElementPresent("//span[text()='Login']");

		common.log("Verify Forgot Password text,");
		common.assertElementPresent("//div/a[text()='Forgot password?']");

		common.log("Verify Forgot Usernam text.");
		common.assertElementPresent("//div/a[text()='Forgot username?']");

	}

	/**
	 * Login User
	 * 
	 */
	public void LoginUser() {

		common.waitForConditionIsElementPresent(("//input[@id='usr']"));
		common.type("//div[text()='Username']", "sagar1");

		common.waitForConditionIsElementPresent(("//input[@id='pas']"));
		common.type("//div[text()='Username']", "123123");

		common.jsClick(submitbutton);
		common.pause(60);

	}

}
