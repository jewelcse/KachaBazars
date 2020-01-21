package Utility;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import model.OrderSellerProductModel;
import model.OrdersModel;

public class ParameterBuilder {
	
	

	
	public static String getParamsString(Map<String, String> params, boolean urlEncode) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (urlEncode)
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            else
                result.append(entry.getKey());

            result.append("=");
            if (urlEncode)
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            else
                result.append(entry.getValue());
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
	
	/*
	public static Map<String, String> constructRequestParameters() {
        // CREATING LIST OF POST DATA
        String baseUrl = "http://localhost:9090/demo/";//Request.Url.Scheme + "://" + Request.Url.Authority + Request.ApplicationPath.TrimEnd('/') + "/";
        Map<String, String> postData = new HashMap<String, String>();
        postData.put("total_amount", "150.00");
        postData.put("tran_id", "TESTASPNET1234");
        postData.put("success_url", baseUrl + "success.jsp");
        postData.put("fail_url", "https://sandbox.sslcommerz.com/developer/fail.php");
        postData.put("cancel_url", "https://sandbox.sslcommerz.com/developer/cancel.php");
        postData.put("version", "3.00");
        postData.put("cus_name","Md. Erfan");
        postData.put("cus_email", "abc.xyz@mail.co");
        postData.put("cus_add1", "Address Line On");
        postData.put("cus_add2", "Address Line Tw");
        postData.put("cus_city", "City Nam");
        postData.put("cus_state", "State Nam");
        postData.put("cus_postcode", "Post Cod");
        postData.put("cus_country", "Countr");
        postData.put("cus_phone", "0111111111");
        postData.put("cus_fax", "0171111111");
        postData.put("ship_name", "ABC XY");
        postData.put("ship_add1", "Address Line On");
        postData.put("ship_add2", "Address Line Tw");
        postData.put("ship_city", "City Nam");
        postData.put("ship_state", "State Nam");
        postData.put("ship_postcode", "Post Cod");
        postData.put("ship_country", "Countr");
        postData.put("value_a", "ref00");
        postData.put("value_b", "ref00");
        postData.put("value_c", "ref00");
        postData.put("value_d", "ref00");
        return postData;
    }
	*/
	public static Map<String, String> constructRequestParameters(OrdersModel ordersModel) {
        // CREATING LIST OF POST DATA
		double total = ordersModel.getOrderQuantity() * Double.parseDouble(ordersModel.getProductModel().getProductPrice().toString());
		String amountString = total + "";
		
		System.out.println("para " +ordersModel.getTranId());
		
	//	String baseUrl = "http://localhost:9090/ecommerce/";
        String baseUrl = "http://103.28.121.29:8080/ecommerce/";
        
        //Request.Url.Scheme + "://" + Request.Url.Authority + Request.ApplicationPath.TrimEnd('/') + "/";
        
        Map<String, String> postData = new HashMap<String, String>();
        postData.put("total_amount", amountString);
        postData.put("tran_id", ordersModel.getTranId());
        postData.put("success_url", baseUrl + "success?action=inventoryorder&trsansid="+ordersModel.getTranId());
        postData.put("fail_url", baseUrl + "fail.jsp");
        postData.put("cancel_url", baseUrl + "cancel.jsp");
        postData.put("version", "3.00");

        return postData;
    }

	public static Map<String, String> constructRequestParameters(String tranId, double total) {
		// TODO Auto-generated method stub

	//	String baseUrl = "http://localhost:9090/ecommerce/";

        String baseUrl = "http://103.28.121.29:8080/ecommerce/";//Request.Url.Scheme + "://" + Request.Url.Authority + Request.ApplicationPath.TrimEnd('/') + "/";
        Map<String, String> postData = new HashMap<String, String>();
        postData.put("total_amount", total + "");
        postData.put("tran_id", tranId);
        postData.put("success_url", baseUrl + "success?action=cartorder&trsansid=" + tranId);
        postData.put("fail_url", baseUrl + "fail.jsp");
        postData.put("cancel_url", baseUrl + "cancel.jsp");
        postData.put("version", "3.00");
        return postData;
	}

	public static Map<String, String> constructRequestParameters(OrderSellerProductModel ordersModel) {
		// TODO Auto-generated method stub
		double total = ordersModel.getOrderQuantity() * ordersModel.getSellersProduct().getProductPrice();
		String amountString = total + "";
		
        String baseUrl = "http://103.28.121.29:8080/ecommerce/";//Request.Url.Scheme + "://" + Request.Url.Authority + Request.ApplicationPath.TrimEnd('/') + "/";
        Map<String, String> postData = new HashMap<String, String>();
        postData.put("total_amount", amountString);
        postData.put("tran_id", ordersModel.getTranId());
        postData.put("success_url", baseUrl + "success?action=sellerproduct&trsansid="+ordersModel.getTranId());
        postData.put("fail_url", baseUrl + "fail.jsp");
        postData.put("cancel_url", baseUrl + "cancel.jsp");
        postData.put("version", "3.00");

        return postData;
	}

}
