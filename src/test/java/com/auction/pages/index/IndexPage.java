package com.auction.pages.index;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auction.admin.pages.AdminDashboardPage;
import com.auction.init.Common;
import com.auction.pages.LoginPage;
import com.auction.pages.SignupPage;
import com.auction.pages.auctionregistration.AbstractPage;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.HttpCommandProcessor;

public class IndexPage extends AbstractPage {

	Common common = new Common(driver);

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Xpaths
	// -------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//
	/**
	 * Webelements
	 * 
	 */
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginlink;

	@FindBy(xpath = "//a//span[text()='Signup']")
	private WebElement signup;

	// For Admin Webelements

	@FindBy(xpath = "//input[@id='sub']")
	private WebElement submitbutton;

	/**
	 * Constructor [Index Page]
	 * 
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Click on Login link
	 * 
	 * @return
	 */
	public LoginPage clickOnLoginLink() {

		System.out
				.println("-----------------------------------------------------------------------------------");

		System.out.println("Click on login link.");
		common.log("<br></br> Step :: Click on Login link.");
		common.waitForConditionIsElementPresent("//span[text()='Login']");

		common.jsClick(loginlink);

		return new LoginPage(driver);

	}

	/**
	 * Click on Signup Link
	 * 
	 * @return
	 */
	public SignupPage clickOnSignupLink() {

		System.out
				.println("-----------------------------------------------------------------------------------");

		System.out.println("Click on signup link.");
		common.log("<br></br> Step :: Click on Signup link.");
		common.waitForConditionIsElementPresent("//a//span[text()='Signup']");

		common.jsClick(signup);

		return new SignupPage(driver);

	}

	/**
	 * Admin SignIn
	 * 
	 * @param username
	 * @param password
	 */
	public AdminDashboardPage adminSignin(String username, String password) {

		System.out
				.println("-----------------------------------------------------------------------------------");

		System.out.println("Click on admin signin Link.");
		common.log("<br></br> Step :: Click on admin signin Link link.");
		common.waitForConditionIsElementPresent("//input[@id='usr']");

		System.out
				.println("-----------------------------------------------------------------------------------");

		System.out.println("Click on admin signin Link.");
		common.log("<br></br> Step :: Enter admin User Name ::");
		common.type("//input[@id='usr']", username);

		System.out
				.println("-----------------------------------------------------------------------------------");

		System.out.println("Click on admin signin Link.");
		common.log("<br></br> Step :: Enter admin Password ::");
		common.type("//input[@id='pas']", password);

		System.out
				.println("-----------------------------------------------------------------------------------");

		System.out.println("Click on signin button");
		common.log("<br></br> Step :: Click on signin button ::");
		common.jsClick(submitbutton);

		return new AdminDashboardPage(driver);
	}

}
