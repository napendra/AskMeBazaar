package com.canbrand.askmebazaar;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

/**
 * 
 * @author napendra
 * 
 */

public interface AskmebazaarHelper {

	public String httpURLResponse(String endPoint, String apiKey,
			String apiPassword, String couponCode, String totalBillAmount,
			String SubProId, String ProQty) throws HttpException, IOException;
	
	public String httpURLResponseOrderFetch(String endPt, String apiKey,
			String apiPass, String orderId, String fltr, String fltrCity,
			String fltrState, String payment, String orderSource, String after,
			String before, String limit, String offSet) throws HttpException, IOException;

}
