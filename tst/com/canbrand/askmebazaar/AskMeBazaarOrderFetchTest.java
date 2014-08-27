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
public class AskMeBazaarOrderFetchTest extends AskmebazaarConstant {

	/**
	 * All Valid Test cases are including here
	 * 
	 * @param endPt
	 * @param apiKey
	 * @param apiPass
	 * @param orderId
	 * @param fltr
	 * @param fltrCity
	 * @param fltrState
	 * @param payment
	 * @param orderSource
	 * @param after
	 * @param before
	 * @param limit
	 * @param offSet
	 * @throws HttpException
	 * @throws IOException
	 */
	@Description("Test Suite : Order_Fetch")
	@DescriptorKey("TC-29, TC-31, TC-33, TC-35, TC-41")
	@Test
	@UseDataProvider("validApiKeyDataProvider")
	public void testValidApiKeyWithValidParam(String endPt, String apiKey,
			String apiPass, String orderId, String fltr, String fltrCity,
			String fltrState, String payment, String orderSource, String after,
			String before, String limit, String offSet) throws HttpException,
			IOException {
		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponseOrderFetch(endPt,
				apiKey, apiPass, orderId, fltr, fltrCity, fltrState, payment,
				orderSource, after, before, limit, offSet);
		Assert.assertNotNull(response);
		Assert.assertTrue("Success Message is not matching",
				response.contains(AskmebazaarConstant.SUCCESS_MESSAGE));
		Assert.assertTrue(
				"Order id from data array is not finding",
				response.contains(AskmebazaarConstant.DATA_ARRAY_KEY_ORDER_ID
						+ '"' + orderId + '"'));

	}

	/**
	 * All Invalid api keys and api password test cases are included
	 * 
	 * @param endPt
	 * @param apiKey
	 * @param apiPass
	 * @param orderId
	 * @param fltr
	 * @param fltrCity
	 * @param fltrState
	 * @param payment
	 * @param orderSource
	 * @param after
	 * @param before
	 * @param limit
	 * @param offSet
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Order_Fetch")
//	@DescriptorKey("TC-30, TC-36")
//	@Test
//	@UseDataProvider("invalidApiKeyDataProvider")
	public void testInvalidApiKeyAndPassword(String endPt, String apiKey,
			String apiPass, String orderId, String fltr, String fltrCity,
			String fltrState, String payment, String orderSource, String after,
			String before, String limit, String offSet) throws HttpException,
			IOException {
		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponseOrderFetch(endPt,
				apiKey, apiPass, orderId, fltr, fltrCity, fltrState, payment,
				orderSource, after, before, limit, offSet);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains(AskmebazaarConstant.FAILED_MESSAGE));
		Assert.assertTrue(
				"User is able to login using invalid api key and password",
				response.contains(AskmebazaarConstant.FAILED_LOGIN_MSG));
	}

	/**
	 * Here are all invalid order id related test cases
	 * 
	 * @param endPt
	 * @param apiKey
	 * @param apiPass
	 * @param orderId
	 * @param fltr
	 * @param fltrCity
	 * @param fltrState
	 * @param payment
	 * @param orderSource
	 * @param after
	 * @param before
	 * @param limit
	 * @param offSet
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Order_Fetch")
//	@DescriptorKey("TC-32, TC-37")
//	@Test
//	@UseDataProvider("invalidOrderIdDataProvider")
	public void testInvalidOrderId(String endPt, String apiKey, String apiPass,
			String orderId, String fltr, String fltrCity, String fltrState,
			String payment, String orderSource, String after, String before,
			String limit, String offSet) throws HttpException, IOException {
		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponseOrderFetch(endPt,
				apiKey, apiPass, orderId, fltr, fltrCity, fltrState, payment,
				orderSource, after, before, limit, offSet);
		Assert.assertNotNull(response);
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.SUCCESS_MESSAGE));
		Assert.assertTrue(
				"It is giving data for wrong order id also",
				response.contains(AskmebazaarConstant.INVALID_ORDER_MESSAGE
						+ orderId));
	}

	/**
	 * Test cases with filter on
	 * 
	 * @param endPt
	 * @param apiKey
	 * @param apiPass
	 * @param orderId
	 * @param fltr
	 * @param fltrCity
	 * @param fltrState
	 * @param payment
	 * @param orderSource
	 * @param after
	 * @param before
	 * @param limit
	 * @param offSet
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Order_Fetch")
//	@DescriptorKey("TC-34, TC-38, TC-40")
//	@Test
//	@UseDataProvider("filterOnwithInvalidParamDataProvider")
	public void testFilterOnWithInvalidPram(String endPt, String apiKey,
			String apiPass, String orderId, String fltr, String fltrCity,
			String fltrState, String payment, String orderSource, String after,
			String before, String limit, String offSet) throws HttpException,
			IOException {
		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponseOrderFetch(endPt,
				apiKey, apiPass, orderId, fltr, fltrCity, fltrState, payment,
				orderSource, after, before, limit, offSet);
		Assert.assertNotNull(response);
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.SUCCESS_MESSAGE));
		Assert.assertTrue(response
				.contains(AskmebazaarConstant.NO_ORDER_MATCH_MESSAGE));
	}

	/**
	 * Test cases with filter off
	 * 
	 * @param endPt
	 * @param apiKey
	 * @param apiPass
	 * @param orderId
	 * @param fltr
	 * @param fltrCity
	 * @param fltrState
	 * @param payment
	 * @param orderSource
	 * @param after
	 * @param before
	 * @param limit
	 * @param offSet
	 * @throws HttpException
	 * @throws IOException
	 */
//	@Description("Test Suite : Order_Fetch")
//	@DescriptorKey("TC-39")
//	@Test
//	@UseDataProvider("filterOffwithValidParamDataProvider")
	public void testFilterOffWithValidPram(String endPt, String apiKey,
			String apiPass, String orderId, String fltr, String fltrCity,
			String fltrState, String payment, String orderSource, String after,
			String before, String limit, String offSet) throws HttpException,
			IOException {
		AskmebazaarHelper askMeBazaarHelper = new AskmebazaarHelperImpl();
		String response = askMeBazaarHelper.httpURLResponseOrderFetch(endPt,
				apiKey, apiPass, orderId, fltr, fltrCity, fltrState, payment,
				orderSource, after, before, limit, offSet);
		Assert.assertNotNull(response);
		Assert.assertTrue("Success Message is not matching",
				response.contains(AskmebazaarConstant.SUCCESS_MESSAGE));
		Assert.assertTrue(
				"Order id from data array is not finding",
				response.contains(AskmebazaarConstant.DATA_ARRAY_KEY_ORDER_ID
						+ '"' + orderId + '"'));
	}

	@DataProvider
	public static Object[][] validApiKeyDataProvider() {
		return new Object[][] {
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"apiadmin", "apipassword123", "fest4904", "on",
						"delhi", "Jharkhand", "", "web", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"apiadmin", "apipassword123", "fest4904", "off",
						"delhi", "Jharkhand", "", "web", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"fest", "fest", "fest4904", "on", "delhi", "Jharkhand",
						"", "web", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"apiadmin", "apipassword123", "fest4904", " ", " ",
						" ", " ", " ", " ", " ", " ", " " }

		};
	};

	@DataProvider
	public static Object[][] invalidApiKeyDataProvider() {
		return new Object[][] {
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"abc", "apipassword123", "fest4904", "on", "delhi",
						"Jharkhand", "", "web", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"apiadmin", "xyz", "fest4904", "on", "delhi",
						"Jharkhand", "", "web", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"fest_invalid", "fest", "fest4904", "", "", "", "", "",
						"", "", "", "" }

		};
	};

	@DataProvider
	public static Object[][] invalidOrderIdDataProvider() {
		return new Object[][] {
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"apiadmin", "apipassword123", "abc123", "", "", "", "",
						"", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"fest", "fest", "apiadmin5130", "", "", "", "", "", "",
						"", "", "" }

		};
	};

	@DataProvider
	public static Object[][] filterOnwithInvalidParamDataProvider() {
		return new Object[][] {
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"apiadmin", "apipassword123", "fest4904", "on",
						"mumbai", "Jharkhand", "", "web", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"fest", "fest", "fest%", "on", "delhi", "Jharkhand",
						"", "web", "", "", "", "" },
				{ "http://staging.mpdmapi.getitbazaar.com/order/products",
						"fest", "fest", "fest4904", "on", "delhi_invalid",
						"Jharkhand", "", "web", "", "", "", "" }

		};
	};

	@DataProvider
	public static Object[][] filterOffwithValidParamDataProvider() {
		return new Object[][] { {
				"http://staging.mpdmapi.getitbazaar.com/order/products",
				"fest", "fest", "fest4904", "off", "delhi", "Jharkhand", "",
				"web", "", "", "", "" }

		};
	};

}
