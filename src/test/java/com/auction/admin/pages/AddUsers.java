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
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class AddUsers extends AdminAbstractPage {

	/**
	 * Web Elements
	 * 
	 */
	@FindBy(xpath = "//legend[text()='User information ']//a")
	private WebElement userinformation;

	@FindBy(xpath = "//input[@id='c66']")
	private WebElement savechanges;

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard
	 *            driver
	 */
	public AddUsers(WebDriver driver) {
		super(driver);

	}

	/**
	 * Add Users
	 * 
	 * @param UserName
	 * @param Password
	 * @param ConfirmPassword
	 */
	public void addUsers(String UserName, String Password,
			String ConfirmPassword) {

		common.waitForConditionIsElementPresent("//input[@id='c66']");
		// common.waitForAjax("0");
		common.pause(5);
		common.jsClick(userinformation);
		common.type("//input[@id='c1']", UserName);
		common.type("//input[@id='c2']", Password);
		common.type("//input[@id='c3']", ConfirmPassword);
		common.jsClick(savechanges);
		common.acceptAlert(); // Accept Alert
		common.pause(15);
	}
}
