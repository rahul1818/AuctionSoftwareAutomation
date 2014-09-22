package com.auction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.auction.init.Common;
import com.auction.pages.auctionregistration.AbstractPage;
import com.auction.pages.index.IndexPage;

public class LoginPage extends AbstractPage {

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Xpaths
	// -------------------------------------------------------------------//---------------------------//

	// ---------------------------------------------------------------------------------------------
	@FindBy(xpath = "//input[@id='usr']")
	private WebElement usernameInputID;

	@FindBy(xpath = "//*[@id='sub']")
	private WebElement submitbutton;

	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logout;

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard
	 *            driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Verify Login Page Elements
	 * 
	 */
	public void verifyLoginPageElements() {

		System.out
				.println("-----------------------------------------------------------------------------------");
		System.out.println("Verify Login Page Elements");
		common.log("<br></br> Step :: Verify Login Page Elements.");
		common.waitForConditionIsElementPresent("//input[@id='usr']");
		common.log("<br></br>Verify Usernsme Text,");
		common.assertElementPresent("//div[text()='Username']");

		common.log("Verify Password,");
		common.assertElementPresent("//div[text()='Password']");

		common.log("Verify Not a Member text,");
		common.assertElementPresent("//h1[text()='Not a member yet?']");

		common.log("Verify Auctions text,");
		common.assertElementPresent("//li[@class='auctions']");

		common.log("Verify My Items text,");
		common.assertElementPresent("//li[@class='my-items']");

		common.log("Verify My Alerts text,");
		common.assertElementPresent("//li[@class='my-alerts']");

		common.log("Verify Signup text,");
		common.assertElementPresent("//a//span[text()='Signup']");

		common.log("Verify Login text,");
		common.assertElementPresent("//li[@class='login']");

		common.log("Verify Forgot Password text,");
		common.assertElementPresent("//div/a[text()='Forgot password?']");

		common.log("Verify Forgot Usernam text.");
		common.assertElementPresent("//div/a[text()='Forgot username?']");

	}

	/**
	 * [Dashboard Page]Login Users
	 * 
	 */
	public DashboardPage LoginUser(String username, String password) {

		System.out
				.println("-----------------------------------------------------------------------------------");
		System.out.println("Enter Login Details.");
		common.log("<br></br> Step :: Enter Login Details.");
		common.waitForConditionIsElementPresent(("//input[@id='usr']"));

		System.out.println("Username ::" + username);
		common.log("<br></br>Username ::" + username);
		common.type("//input[@id='usr']", username);

		System.out.println("Password ::" + password);
		common.log("<br></br>Password ::" + password);
		common.type("//input[@id='pas']", password);

		System.out
				.println("-----------------------------------------------------------------------------------");
		System.out.println("Click on submit button.");
		common.log("<br></br>Step :: Click on submit button");
		common.jsClick(submitbutton);

		System.out
				.println("-----------------------------------------------------------------------------------");
		System.out.println("Verify Logout Link.");
		common.log("<br></br>Step :: Verify Logout Link.");
		common.waitForConditionIsElementPresent("//span[text()='Logout']");
		common.assertElementPresent("//span[text()='Logout']");
		//common.jsClick(logout);

		return new DashboardPage(driver);
	}

}
