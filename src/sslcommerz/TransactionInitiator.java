package sslcommerz;
import java.util.Map;

import Utility.ParameterBuilder;
import model.OrderSellerProductModel;
import model.OrdersModel;

public class TransactionInitiator {

	public String initTrnxnRequest(OrdersModel ordersModel) {
        String response = "";
        try {
            /**
             * All parameters in payment order should be constructed in this follwing postData Map
             * keep an eye on success fail url correctly.
             * insert your success and fail URL correctly in this Map
             */
            Map<String, String> postData = ParameterBuilder.constructRequestParameters(ordersModel);
            /**
             * Provide your SSL Commerz store Id and Password by this following constructor.
             * If Test Mode then insert true and false otherwise.
             */
            SSLCommerz sslcz = new SSLCommerz("kachabazarslive", "5DF89D41AE36A11457", false);

            /**
             * If user want to get Gate way list then pass isGetGatewayList parameter as true
             * If user want to get URL as returned response, pass false.
             */
            response = sslcz.initiateTransaction(postData, false);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

	public String initTrnxnRequest(String tranId, double total) {
		// TODO Auto-generated method stub
		 String response = "";
	        try {
	            /**
	             * All parameters in payment order should be constructed in this follwing postData Map
	             * keep an eye on success fail url correctly.
	             * insert your success and fail URL correctly in this Map
	             */
	            Map<String, String> postData = ParameterBuilder.constructRequestParameters(tranId, total);
	            /**
	             * Provide your SSL Commerz store Id and Password by this following constructor.
	             * If Test Mode then insert true and false otherwise.
	             */
	            SSLCommerz sslcz = new SSLCommerz("	kachabazarslive", "5DF89D41AE36A11457", false);

	            /**
	             * If user want to get Gate way list then pass isGetGatewayList parameter as true
	             * If user want to get URL as returned response, pass false.
	             */
	            response = sslcz.initiateTransaction(postData, false);
	            return response;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return response;
	}

	public String initTrnxnRequest(OrderSellerProductModel ordersModel) {
		// TODO Auto-generated method stub
		String response = "";
        try {
            /**
             * All parameters in payment order should be constructed in this follwing postData Map
             * keep an eye on success fail url correctly.
             * insert your success and fail URL correctly in this Map
             */
            Map<String, String> postData = ParameterBuilder.constructRequestParameters(ordersModel);
            /**
             * Provide your SSL Commerz store Id and Password by this following constructor.
             * If Test Mode then insert true and false otherwise.
             */
            SSLCommerz sslcz = new SSLCommerz("	kachabazarslive", "5DF89D41AE36A11457", false);

            /**
             * If user want to get Gate way list then pass isGetGatewayList parameter as true
             * If user want to get URL as returned response, pass false.
             */
            response = sslcz.initiateTransaction(postData, false);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
	}
}
