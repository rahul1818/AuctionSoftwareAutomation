package com.auction.admin.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.auction.init.Common;
import com.auction.pages.SignupPage;
import com.auction.pages.index.IndexPage;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class AdminUsers extends AdminAbstractPage {

	/**
	 * Web Elements
	 * 
	 */
	@FindBy(xpath = "//input[@id='ulf9']")
	private WebElement adduser;

	@FindBy(xpath = "//legend[text()='User information ']//a")
	private WebElement userinformation;

	@FindBy(xpath = "//input[@id='c66']")
	private WebElement savechanges;

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Admin
	 *            Users Page driver
	 */
	public AdminUsers(WebDriver driver) {
		super(driver);

	}

	/**
	 * Create Admin Users
	 * 
	 * @return
	 */
	public AddUsers createAdminNewUser() {

		common.waitForConditionIsElementPresent("//input[@id='ulf9']");
		common.pause(5);
		common.jsClick(adduser);

		return new AddUsers(driver);

	}
}
