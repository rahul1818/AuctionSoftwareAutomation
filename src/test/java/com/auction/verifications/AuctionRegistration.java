package com.auction.verifications;

import java.text.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.auction.init.SeleniumInit;

public class AuctionRegistration extends SeleniumInit {

	/**
	 * Initial Setup For Auction Registration
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void initialSetupForAuctionRegistration(String adminUserName,
			String adminPassword) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Initial Setup,TestCase Name: Initial Setup.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxSimplyfiedSignup(); // Verify
																	// Checked
																	// Check box
																	// Simplyfied
																	// Sign up
	}

	/**
	 * Initial Setup For Registration with CC not required for placing bids
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void initialSetupForRegistrationwithCCNotRequired(
			String adminUserName, String adminPassword)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Login Feature,TestCase Name: Login Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyRegistrationWithCCNotRequiredInitialSetup(); // Verify
		// Checked
		// Check box
		// Register With CC Not Required
		// Sign up
	}

	/**
	 * Create Live Auction
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "liveauction")
	public void createaLiveAuction(String adminUserName, String adminPassword,
			String Name, String username, String password)
			throws InterruptedException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Create Live Auction Feature,TestCase Name: 2.5 Create Live Auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String lotName = generateRandomChars(6);
		initialSetupForAuctionRegistration(adminUserName, adminPassword); // InitialSetup
																			// For
																			// Auction
																			// Registration
		adminDashboardPage.CreateNewAuction(Name); // Create New Auction with
													// Unique Name
		lotVerificationPage = adminDashboardPage.addALot(lotName); // Add Lot
		lotVerificationPage.verifyLot(lotName); // Verified added lot
	}

	/**
	 * Register User with Correct CC to the live sale Feature
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "liveauction")
	public void registerUserWithCorrectCCtotheLiveSale(String adminUserName,
			String adminPassword, String Name, String username, String password)
			throws InterruptedException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Register User with Correct CC to the live sale Feature,TestCase Name: 2.6 Register User with Correct CC to the live sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String lotName = generateRandomChars(6);
		// String NewAuction = generateRandomChars(6);
		System.out.println("NewLot ::" + lotName);
		initialSetupForRegistrationwithCCNotRequired(adminUserName,
				adminPassword); // InitialSetup
		// For
		// Register User With Correct CC to The Live Sale
		adminDashboardPage.CreateNewAuction(Name); // Create New Auction with
		// Unique Name
		lotVerificationPage = adminDashboardPage.addALot(lotName); // Add Lot
		lotVerificationPage.verifyLot(lotName); // Verified added lot
		runLiveAuctionPage = lotVerificationPage.clickOnRunLiveAuction(); // Run
																			// Live
																			// Auction
		runLiveAuctionPage.clickOnStartAuction(); // Start New Auction
		indexPage = runLiveAuctionPage.openFrontEnd(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.LoginUser(username, password); // Login with
																	// valid
																	// credentials

	}

	/**
	 * Data Provider for Live Auction
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "liveauction")
	public Object[][] getLiveAuction() throws Exception {

		Object[][] retObjectArr = parseliveauctionCsv();

		return retObjectArr;

	}
}
