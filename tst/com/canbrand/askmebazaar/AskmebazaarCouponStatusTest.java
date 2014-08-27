package com.canbrand.askmebazaar;

import java.io.IOException;

import junit.framework.Assert;

import org.json.JSONException;
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
@SuppressWarnings("deprecation")
public class AskmebazaarCouponStatusTest extends AskmebazaarConstant {

	/**
	 * All Valid test cases with different valid parameters
	 * 
	 * @param endPt
	 * @param apiKey
	 * @param apiPass
	 * @param couponCode
	 * @param totalBillAmount
	 * @param SubProId
	 * @param ProQty
	 * @throws IOException
	 * @throws JSONException
	 */
//	@Description("Test Suite : Coupon_Code_Status")
//	@DescriptorKey("TC-10,")
//	@Test
//	@UseDataProvider("validDataProvider")
	public void testValidDataRequest(String endPt, String apiKey,
			String apiPass, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws IOException, JSONException {
		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponse(endPt, apiKey,
				apiPass, couponCode, totalBillAmount, SubProId, ProQty);
		Assert.assertNotNull(response);
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.SUCCESS_MESSAGE));

	}

	/**
	 * Invalid Test cases using some invalid test data from DataProvider
	 * 
	 * @param endPt
	 * @param apiKey
	 * @param apiPass
	 * @param couponCode
	 * @param totalBillAmount
	 * @param SubProId
	 * @param ProQty
	 * @throws IOException
	 * @throws JSONException
	 */
//	@Description("Test Suite : Coupon_Code_Status")
//	@DescriptorKey("TC-11,TC-13,TC-14,TC-15,TC-16,TC-18")
//	@Test
//	@UseDataProvider("invalidDataProvider")
	public void testInvalidDataRequest(String endPt, String apiKey,
			String apiPass, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws IOException, JSONException {
		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponse(endPt, apiKey,
				apiPass, couponCode, totalBillAmount, SubProId, ProQty);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains(AskmebazaarConstant.FAILED_MESSAGE));

	}

	/**
	 * Invalid Test cases including some more invalid test data
	 * 
	 * @param endPt
	 * @param apiKey
	 * @param apiPass
	 * @param couponCode
	 * @param totalBillAmount
	 * @param SubProId
	 * @param ProQty
	 * @throws IOException
	 * @throws JSONException
	 */
//	@Description("Test Suite : Coupon_Code_Status")
//	@DescriptorKey("TC-17,TC-19,TC-20,TC-22")
//	@Test
//	@UseDataProvider("invalidBillAmountDataProvider")
	public void testDefaultInvalidDataRequest(String endPt, String apiKey,
			String apiPass, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws IOException, JSONException {
		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponse(endPt, apiKey,
				apiPass, couponCode, totalBillAmount, SubProId, ProQty);
		Assert.assertNotNull(response);
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.SUCCESS_MESSAGE));

		Assert.assertTrue(response.contains(AskmebazaarConstant.DATA_MESSAGE));

	}

	@DataProvider
	public static Object[][] validDataProvider() {

		return new Object[][] { {
				"http://staging.mpdmapi.getitbazaar.com/coupon/status",
				"apiadmin", "apipassword123", "ABC10", "1000", "40669", "1" }

		};
	};

	@DataProvider
	public static Object[][] invalidDataProvider() {

		return new Object[][] {
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"api", "api123", "XXX", "1", "00000", "0" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status", "",
						"", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"123xyz", "apipassword123", "ABC10", "1000", "40669",
						"1" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apixyz123", "ABC10", "1000", "40669", "1" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "XXXXX", "1000", "40669",
						"1" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "ABC10", "1000", "00000",
						"1" },

		};
	};

	@DataProvider
	public static Object[][] invalidBillAmountDataProvider() {

		return new Object[][] {
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "ABC10", "0000", "40669",
						"1" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "ABC10", "1000", "40669",
						"0" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "ABC10", "-1000",
						"40669", "1" },
				{ "http://staging.mpdmapi.getitbazaar.com/coupon/status",
						"apiadmin", "apipassword123", "ABC10", "1000", "40669",
						"!@#$%" },

		};
	};

}
