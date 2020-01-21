package parametermappings;

import java.util.List;

public class SSLCommerzInitResponse {

	
	public String status;
    public String failedreason;
    public String sessionkey;
    public Gw gw;
    public String redirectGatewayURL;
    public String redirectGatewayURLFailed;
    public String GatewayPageURL;
    public String storeBanner;
    public String storeLogo;
    public List<Desc> desc;
    public String is_direct_pay_enable;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFailedreason() {
		return failedreason;
	}
	public void setFailedreason(String failedreason) {
		this.failedreason = failedreason;
	}
	public String getSessionkey() {
		return sessionkey;
	}
	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}
	public Gw getGw() {
		return gw;
	}
	public void setGw(Gw gw) {
		this.gw = gw;
	}
	public String getRedirectGatewayURL() {
		return redirectGatewayURL;
	}
	public void setRedirectGatewayURL(String redirectGatewayURL) {
		this.redirectGatewayURL = redirectGatewayURL;
	}
	public String getRedirectGatewayURLFailed() {
		return redirectGatewayURLFailed;
	}
	public void setRedirectGatewayURLFailed(String redirectGatewayURLFailed) {
		this.redirectGatewayURLFailed = redirectGatewayURLFailed;
	}
	public String getGatewayPageURL() {
		return GatewayPageURL;
	}
	public void setGatewayPageURL(String gatewayPageURL) {
		GatewayPageURL = gatewayPageURL;
	}
	public String getStoreBanner() {
		return storeBanner;
	}
	public void setStoreBanner(String storeBanner) {
		this.storeBanner = storeBanner;
	}
	public String getStoreLogo() {
		return storeLogo;
	}
	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
	}
	public List<Desc> getDesc() {
		return desc;
	}
	public void setDesc(List<Desc> desc) {
		this.desc = desc;
	}
	public String getIs_direct_pay_enable() {
		return is_direct_pay_enable;
	}
	public void setIs_direct_pay_enable(String is_direct_pay_enable) {
		this.is_direct_pay_enable = is_direct_pay_enable;
	}
    
    
}
