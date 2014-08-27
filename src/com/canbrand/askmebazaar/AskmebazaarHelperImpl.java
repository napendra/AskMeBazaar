package com.canbrand.askmebazaar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 
 * @author napendra
 * 
 */

public class AskmebazaarHelperImpl implements AskmebazaarHelper {

	public String httpURLResponse(String endPoint, String apiKey,
			String apiPassword, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws HttpException, IOException {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(endPoint);

		method.addParameter("api_key", apiKey);
		method.addParameter("api_password", apiPassword);
		method.addParameter("data[coupon_code]", couponCode);
		method.addParameter("data[total_bill_amount]", totalBillAmount);
		method.addParameter("data[product_details][0][subscribed_product_id]",
				SubProId);
		method.addParameter("data[product_details][0][product_qty]", ProQty);

		String getResponse = sendRequestAndGetResponse(client, method);
		return getResponse;
	}

	public String httpURLResponseOrderFetch(String endPt, String apiKey,
			String apiPass, String orderId, String fltr, String fltrCity,
			String fltrState, String payment, String orderSource, String after,
			String before, String limit, String offSet) throws HttpException,
			IOException {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(endPt);

		method.addParameter("api_key", apiKey);
		method.addParameter("api_password", apiPass);
		method.addParameter("orderid", orderId);
		method.addParameter("filter", fltr);
		method.addParameter("filter_city", fltrCity);
		method.addParameter("filter_state", fltrState);
		method.addParameter("filter_payment", payment);
		method.addParameter("filter_order_source", orderSource);
		method.addParameter("filter_after", after);
		method.addParameter("filter_before", before);
		method.addParameter("filter_limit", limit);
		method.addParameter("filter_offset", offSet);

		String orderResponse = sendRequestAndGetResponse(client, method);
		return orderResponse;

	}

	private String sendRequestAndGetResponse(HttpClient client,
			PostMethod method) throws HttpException, IOException {

		// Send POST request
		int statusCode = client.executeMethod(method);

		if (statusCode != HttpStatus.SC_OK) {
			System.err.println("Method failed: " + method.getStatusLine());
		}
		InputStream rstream = null;

		// Get the response body
		rstream = method.getResponseBodyAsStream();

		// Process the response from Web Services
		BufferedReader br = new BufferedReader(new InputStreamReader(rstream));
		String line;
		String response = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			response += line;
		}
		br.close();

		return response;

	}

}
