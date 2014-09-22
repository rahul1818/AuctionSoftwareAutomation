package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.auction.init.Common;
import com.auction.init.SeleniumInit;

public class Index extends SeleniumInit {

	Common common = new Common(driver);

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Login Method
	// -------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Login Feature
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "login")
	public void loginFeature(String username, String password) {
		log("Feature" + "-" + "UAT" + "\"Login Feature,TestCase Name: 1.1 Login Feature.");
		log("<br></br> Step :: Enter the URL in browser address bar and hit enter.");

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.LoginUser(username, password); // Login with
																	// valid
																	// credentials

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regular Signup
	// ------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignUp(String adminUserName, String adminPassword) throws InterruptedException, AWTException {
		log("Feature" + "-" + "UAT" + "\"Regular SignUp Feature,TestCase Name: 1.1 RegularSignUp");
		log("<br></br> Step :: Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxONRegistrationSettingsModule(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUp(); // Regular Sign Up
		driver.quit();

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regular Signup with Email
	// Already Exist In The System
	// ------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up With Username Already Exist
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupalreadyEmailExist(String adminUserName, String adminPassword) throws InterruptedException,
			AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Regular SignUp with email already exist in the system Name: 1.3 regularSignupalreadyEmailExist");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxONRegistrationSettingsModule(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignupWithExistingEmailUser(); // Regular Sign Up with
		// existing user
		driver.quit();

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regular Signup With Username
	// Already Exist
	// ------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up With Username Already Exist
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignUpWithUsernameAlreadyExist(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp with username already exist feature,TestCase Name: 1.2 regularSignUpWithUsernameAlreadyExist");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxONRegistrationSettingsModule(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignupWithExistingUser(); // Regular Sign Up with
													// existing user
		driver.quit();

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regular Signup With No
	// Captcha --------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up No Captcha Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupNoCaptcha(String adminUserName, String adminPassword) throws InterruptedException,
			AWTException {
		log("Feature" + "-" + "UAT" + "\"Regular SignUp Feature,TestCase Name: 1.31 RegularSignUp No Captcha Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxONRegistrationSettingsModule(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpNoCaptcha(); // Regular Sign Up No Captcha Value
		driver.quit();
	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regualr Signup With Wrong
	// Capcha -----------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up Wrong Captcha Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWrongCaptcha(String adminUserName, String adminPassword) throws InterruptedException,
			AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.32 RegularSignUp Wrong Captcha Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxONRegistrationSettingsModule(); // Verify
																				// Checked
																				// Check
																				// box
																				// on
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWrongCaptcha(); // Regular Sign Up with Wrong
												// Captcha Value
		driver.quit();
	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regualr Signup With
	// Confirmation Is Not Checked
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up Confirmation is not checked
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupConfirmationIsNotChecked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.33 RegularSignUp Confirmation Is Not Checked Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxONRegistrationSettingsModule(); // Verify
																				// Checked
																				// Check
																				// box
																				// on
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpConfirmationIsNotChecked(); // Regular Sign Up
															// with Confirmation
															// Is Not Checked
		driver.quit();
	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regualr Signup With
	// Basic Information Mandatory
	// All filled out
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up Confirmation is not checked
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.74 Regular SignUp With Basic Information Mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatory(); // Verify
																		// Checked
																		// Check
																		// box
																		// on
																		// Simplyfied
																		// with
																		// Signup
																		// basic
																		// info
																		// mandatory
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoMandatory(); // Regular Sign Up
		// with Basic Information
		// Mandatory
		driver.quit();

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regualr Signup With
	// Billing Information Mandatory
	// All filled out
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up Billing Information
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBillingInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.75 Regular SignUp With Billing Information Mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatory(); // Verify
																		// Checked
																		// Check
																		// box
																		// on
																		// Simplyfied
																		// Signup
																		// with
																		// billing
																		// info
																		// mandatory

		driver.quit();
	}

	/**
	 * Verify Regular Sign up CC is not checked
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithCCInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.76 Regular SignUp With CC Mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxCCInfoMandatory(); // Verify
																	// Checked
																	// Check
																	// box
																	// on
																	// Simplyfied
																	// Signup
																	// with
																	// CC
																	// info
																	// mandatory
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithCCInfoMandatory(); // the billing info box
														// was displayed with
														// the following fields
		// - billing CC type
		// - billing CC number
		// - billing expiration date
		// - billing security code
		driver.quit();

	}

	/**
	 * Verify Regular Sign up ACH is checked
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithACHInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.77 Regular SignUp With ACH Mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxACHInfoMandatory(); // Verify
																	// Checked
																	// Check
																	// box
																	// on
																	// Simplyfied
																	// Signup
																	// with
																	// ACH
																	// info
																	// mandatory
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithACHInfoMandatory(); // the billing info box
														// was displayed with
														// the following fields
		// - billing bank routing nb
		// - billing bank account nb
		// - billing bank account type
		// - billing bank name
		// - billing bank account name

		driver.quit();
	}

	/**
	 * Verify Regular Sign up basic info (mandatory) billing address info (not
	 * mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoMandatoryAndBillingAddressInfoNotMandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.78 Regular SignUp With * basic info mandatory and billing address info not mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndBillingAddressInfoNotMandatory(); //
																										// Verify
																										// Checked
																										// Checkbox
																										// BasicInfo
																										// Mandatory
																										// And
																										// Billing
																										// Address
																										// Info
																										// Not
																										// Mandatory
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndBillingAddressInfoNotMandatory(); // Basic
																							// Info
																							// Mandatory
																							// And
																							// Billing
																							// Address
																							// Info
																							// Not
																							// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info ( Not mandatory) billing address info (
	 * mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoNotMandatoryAndBillingAddressInfoMandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.79 Regular SignUp With * basic info not mandatory and billing address info not mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryAndBillingAddressInfoMandatory();
		// Verify
		// Checked
		// Checkbox
		// BasicInfo
		// Mandatory
		// And
		// Billing
		// Address
		// Not
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryAndBillingAddressInfoMandatory(); // Basic
																							// Info
																							// Mandatory
																							// And
																							// Billing
																							// Address
																							// Info
																							// Not
																							// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (mandatory) billing address info (
	 * mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoMandatoryAndBillingAddressInfoMandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.80 Regular SignUp With * basic info mandatory and billing address info mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndBillingAddressInfoMandatory(); //
																									// Verify
																									// Checked
																									// Checkbox
																									// BasicInfo
																									// Mandatory
																									// And
																									// Billing
																									// Address
																									// Info
																									// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndBillingAddressInfoMandatory(); // Basic
																						// Info
																						// Mandatory
																						// And
																						// Billing
																						// Address
																						// Info
																						// Not
																						// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (mandatory) CC info ( Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoMandatoryAndCCInfoNotMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.81 Regular SignUp With * basic info mandatory and CC info not mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndCCInfoNotMandatory(); //
																							// Verify
																							// Checked
																							// Checkbox
																							// BasicInfo
																							// Mandatory
																							// And
																							// CC
																							// Info
																							// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndCCInfoNotMandatory(); // Basic
																				// Info
																				// Mandatory
																				// And
																				// CC
																				// Not
																				// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (Not mandatory) CC info ( Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoNotMandatoryAndCCInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.82 Regular SignUp With * basic info Not mandatory and CC info mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryAndCCInfoMandatory(); //
																							// Verify
																							// Checked
																							// Check
																							// box
																							// BasicInfo
																							// Not
																							// Mandatory
																							// And
																							// CC
																							// Info
																							// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryAndCCInfoMandatory(); // Basic
																				// Info
																				// Mandatory
																				// And
																				// CC
																				// Info
																				// Not
																				// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (mandatory) CC info ( Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoMandatoryAndCCInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.83 Regular SignUp With * basic info  mandatory and CC info mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndCCInfoMandatory(); //
																						// Verify
																						// Checked
																						// Check
																						// box
																						// BasicInfo
																						// Mandatory
																						// And
																						// CC
																						// Info
																						// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndCCInfoMandatory(); // Basic
																			// Info
																			// Mandatory
																			// And
																			// CC
																			// Info
																			// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (mandatory) ACH info ( Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoMandatoryAndACHInfoNotMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.84 Regular SignUp With * basic info  mandatory and ACH info mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// BasicInfo
		// Mandatory
		// And
		// ACH
		// Info
		// Not
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndACHInfoNotMandatory(); // Basic
																				// Info
																				// Mandatory
																				// And
																				// ACH
																				// Info
																				// Not
																				// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (Not Mandatory) ACH info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoNotMandatoryAndACHInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.85 Regular SignUp With * basic info Not mandatory and ACH info Not mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryAndACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// BasicInfo
		// Not
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		// signupPage.regularSignUpWithBasicInfoNotMandatoryAndACHInfoMandatory();
		// // Basic
		// Info
		// Not
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up basic info (Mandatory) ACH info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBasicInfoMandatoryAndACHInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.86 Regular SignUp With * basic info Not mandatory and ACH info Not mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// BasicInfo
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryAndACHInfoMandatory(); // Basic
																				// Info
																				// Mandatory
																				// And
																				// ACH
																				// Info
																				// Not
																				// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Mandatory) CC info (Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBillingInfoMandatoryAndCCInfoNotMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.87 Regular SignUp With * billing info mandatory and CC info Not mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryAndCCInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// CC
		// Info Not
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBillingInfoMandatoryAndCCInfoNotMandatory(); // Billing
																					// Info
																					// Mandatory
																					// And
																					// CC
																					// Info
																					// Not
																					// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Not Mandatory) CC info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBillingInfoNotMandatoryAndCCInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.87 Regular SignUp With * billing info Not mandatory and CC info mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoNotMandatoryAndCCInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info Not
		// Mandatory
		// And
		// CC
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBillingInfoNotMandatoryAndCCInfoMandatory(); // Billing
																					// Info
																					// Not
																					// Mandatory
																					// And
																					// CC
																					// Info
																					// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Mandatory) CC info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBillingInfoMandatoryAndCCInfoMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.88 Regular SignUp With * billing info mandatory and CC info mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoNotMandatoryAndCCInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// CC
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBillingInfoNotMandatoryAndCCInfoMandatory(); // Billing
																					// Info
																					// Mandatory
																					// And
																					// CC
																					// Info
																					// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Mandatory) ACH info (Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void regularSignupWithBillingInfoMandatoryAndACHInfoNotMandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("Feature"
				+ "-"
				+ "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.89 Regular SignUp With * billing info mandatory and ACH info Not mandatory Feature.");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get("https://v2-10.auctionserver.net/admin"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUserProfilePage(); // Verify Users profile page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryAndACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info Not
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goToFrontEndAndEnterRegistrationDetails(); // Go
																					// To
																					// Front
																					// End
		signupPage.regularSignUpWithBillingInfoMandatoryAndACHInfoNotMandatory(); // Billing
																					// Info
																					// Mandatory
																					// And
																					// ACH
																					// Info
																					// Not
																					// Mandatory
		driver.quit();
	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Data Providers
	// ------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Data Provider for Login Feature
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "login")
	public Object[][] getLogin() throws Exception {

		Object[][] retObjectArr = parseCsv();

		return retObjectArr;

	}

	/**
	 * Data Provider for Signup Feature
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "signup")
	public Object[][] getSignup() throws Exception {

		Object[][] retObjectArr = parseSignUpCsv();

		return retObjectArr;

	}

	/**
	 * Data Provider for Regular Signup Feature
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "regularsignup")
	public Object[][] getRegularSignup() throws Exception {

		Object[][] retObjectArr = parseRegularSignupCsv();

		return retObjectArr;

	}
}
