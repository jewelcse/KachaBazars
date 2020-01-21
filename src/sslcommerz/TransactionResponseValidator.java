package sslcommerz;
import java.util.Map;

public class TransactionResponseValidator {

	/**
    *
    * @param request
    * @return
    * @throws Exception
    * Send Received params from your success resoponse (POST ) in this Map</>
    */
   public boolean receiveSuccessResponse(Map<String, String> request) throws Exception {

       String trxId = request.get("tran_id");
       /**
        *Get your AMOUNT and Currency FROM DB to initiate this Transaction
        */
       String amount = request.get("amount");
       String currency = "BDT";
       // Set your store Id and store password and define TestMode
       SSLCommerz sslcz = new SSLCommerz("kachabazarslive", "5DF89D41AE36A11457", false);

       /**
        * If following order validation returns true, then process transaction as success.
        * if this following validation returns false , then query status if failed of canceled.
        *      Check request.get("status") for this purpose
        */
       return sslcz.orderValidate(trxId, amount, currency, request);

   }
	
}
