package com.canbrand.askmebazaar;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sun.org.glassfish.gmbal.Description;
import com.sun.org.glassfish.gmbal.DescriptorKey;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

/**
 * 
 * @author napendra
 * 
 */

@RunWith(DataProviderRunner.class)
public class AskMeBazaarCouponRedeemTest extends AskmebazaarConstant {

	/**
	 * Test for all valid input parameters
	 * 
	 * @param endPoint
	 * @param apiKey
	 * @param apiPassword
	 * @param couponCode
	 * @param totalBillAmount
	 * @param SubProId
	 * @param ProQty
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Coupon_Code_Redeem")
//	@DescriptorKey("TC-23")
//	@Test
//	@UseDataProvider("validDataProvider")
	public void testWithValidInputData(String endPoint, String apiKey,
			String apiPassword, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws HttpException, IOException {

		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponse(endPoint, apiKey,
				apiPassword, couponCode, totalBillAmount, SubProId, ProQty);
		Assert.assertNotNull(response);
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.SUCCESS_MESSAGE));
	}

	/**
	 * Test for some invalid api keys and api passwords
	 * 
	 * @param endPoint
	 * @param apiKey
	 * @param apiPassword
	 * @param couponCode
	 * @param totalBillAmount
	 * @param SubProId
	 * @param ProQty
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Coupon_Code_Redeem")
//	@DescriptorKey("TC-24")
//	@Test
//	@UseDataProvider("invalidKeyDataProvider")
	public void testWithInvalidUserIdOrKey(String endPoint, String apiKey,
			String apiPassword, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws HttpException, IOException {

		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponse(endPoint, apiKey,
				apiPassword, couponCode, totalBillAmount, SubProId, ProQty);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains(AskmebazaarConstant.FAILED_MESSAGE));
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.FAILED_LOGIN_MSG));
	}

	/**
	 * Test for some invalid coupon codes
	 * 
	 * @param endPoint
	 * @param apiKey
	 * @param apiPassword
	 * @param couponCode
	 * @param totalBillAmount
	 * @param SubProId
	 * @param ProQty
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Coupon_Code_Redeem")
//	@DescriptorKey("TC-25")
//	@Test
//	@UseDataProvider("invalidCouponCodeDataProvider")
	public void testInvalidCouponCode(String endPoint, String apiKey,
			String apiPassword, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws HttpException, IOException {

		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponse(endPoint, apiKey,
				apiPassword, couponCode, totalBillAmount, SubProId, ProQty);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains(AskmebazaarConstant.FAILED_MESSAGE));
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.INVALID_COUPONP_CODE_MSG));
	}

	/**
	 * Test for some invalid total bill amounts
	 * 
	 * @param endPoint
	 * @param apiKey
	 * @param apiPassword
	 * @param couponCode
	 * @param totalBillAmount
	 * @param SubProId
	 * @param ProQty
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Coupon_Code_Redeem")
//	@DescriptorKey("TC-26,27")
//	@Test
//	@UseDataProvider("InvalidBillAmountDataProvider")
	public void testInvalidBillAmount(String endPoint, String apiKey,
			String apiPassword, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws HttpException, IOException {

		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponse(endPoint, apiKey,
				apiPassword, couponCode, totalBillAmount, SubProId, ProQty);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains(AskmebazaarConstant.FAILED_MESSAGE));
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.COUPON_NOT_APPLIED_MSG));
	}

	/**
	 * Some invalid product quantity test are here
	 * 
	 * @param endPoint
	 * @param apiKey
	 * @param apiPassword
	 * @param couponCode
	 * @param totalBillAmount
	 * @param SubProId
	 * @param ProQty
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Coupon_Code_Redeem")
//	@DescriptorKey("TC-28")
//	@Test
//	@UseDataProvider("InvalidProductQuantityDataProvider")
	public void testInvalidProductQuantity(String endPoint, String apiKey,
			String apiPassword, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws HttpException, IOException {

		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponse(endPoint, apiKey,
				apiPassword, couponCode, totalBillAmount, SubProId, ProQty);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains(AskmebazaarConstant.FAILED_MESSAGE));
		// Put Assert for error message also
	}

	@DataProvider
	public static Object[][] validDataProvider() {
		return new Object[][] { {
				"http://staging.mpdmapi.getitbazaar.com/coupon/status",
				"apiadmin", "apipassword123", "MULTICOUPON", "1000", "40669",
				"1" }

		};
	};

	@DataProvider
	public static Object[][] invalidKeyDataProvider() {
		return new Object[][] { {
				"http://staging.mpdmapi.getitbazaar.com/coupon/status",
				"apiadmin", "wrongpassword", "MULTICOUPON", "1000", "40669",
				"1" }

		};
	};

	@DataProvider
	public static Object[][] invalidCouponCodeDataProvider() {
		return new Object[][] { {
				"http://staging.mpdmapi.getitbazaar.com/coupon/status",
				"apiadmin", "apipassword123", "MULTICOUP ", "1000", "40669",
				"1" }

		};
	};

	@DataProvider
	public static Object[][] InvalidBillAmountDataProvider() {
		return new Object[][] {
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "MULTICOUPON", "10",
						"40669", "1" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "MULTICOUPON", "abc",
						"40669", "1" }

		};
	};

	@DataProvider
	public static Object[][] InvalidProductQuantityDataProvider() {
		return new Object[][] {
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "MULTICOUPON", "1000",
						"40669", "abc" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "MULTICOUPON", "1000",
						"40669", "0.5" }

		};
	};

}
