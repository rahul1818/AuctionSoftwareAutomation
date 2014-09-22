package com.auction.verifications;

import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.admin.pages.AddUsers;
import com.auction.init.SeleniumInit;

public class adminUserCreation extends SeleniumInit {

	/**
	 * Admin User Creation Script
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "adminuser")
	public void adminUserCreation(String adminUserName, String adminPassword,
			String UserName, String Password, String ConfirmPassword)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Admin User Create,TestCase Name: Admin User Create.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminUsersPage = adminDashboardPage.goToUsersPage();
		addUsersPage = adminUsersPage.createAdminNewUser();
		addUsersPage.addUsers(UserName, Password, ConfirmPassword);

	}

	/**
	 * Data Provider for Admin New User Creation Data Sheet
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "adminuser")
	public Object[][] getAdminNewUser() throws Exception {

		Object[][] retObjectArr = parseAdminUserCsv();

		return retObjectArr;

	}
}
