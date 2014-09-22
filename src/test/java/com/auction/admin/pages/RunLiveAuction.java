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

public class RunLiveAuction extends AdminAbstractPage {

	/**
	 * Web Elements
	 * 
	 */
	@FindBy(xpath = "//button[@id='z4']")
	private WebElement startAuction;

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard
	 *            driver
	 */
	public RunLiveAuction(WebDriver driver) {
		super(driver);

	}

	/**
	 * Start Auction
	 * 
	 */
	public void clickOnStartAuction() {

		common.waitForConditionIsElementPresent("//button[@id='z4']");
		this.driver.findElement(By.xpath("//button[@id='z4']")).click();

		common.waitForConditionIsElementPresent("//button[@id='z6']");
		common.pause(15);
	}

	/**
	 * Open Front End
	 * 
	 * @return
	 */
	public IndexPage openFrontEnd() {

		common.clickOnLogoutFromAdmin();
		common.openFrontEndURL();

		return new IndexPage(driver);
	}
}
