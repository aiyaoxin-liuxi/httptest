package notify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import util.JsonUtil;
import util.XmlUtils;

public class HttpClientUtil {
	public static final String CHARSET = "UTF-8";
	private static final Logger logger = Logger.getLogger("HttpClientUtil");

	public static CloseableHttpClient createHttpsClient() throws Exception {
		X509TrustManager x509mgr = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] xcs, String string) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] xcs, String string) {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[] { x509mgr }, null);
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslContext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}

	public static CloseableHttpClient createSSLClientDefault() throws Exception {

		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,
				new TrustStrategy() {
					// 信任所有
					public boolean isTrusted(X509Certificate[] chain,
							String authType) throws CertificateException {
						return true;
					}
				}).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslContext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}

	public static String httpGet(String url, String ordersn, String uuid,
			Map<String, String> params) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		StringBuffer sb = new StringBuffer();
		if (!url.contains("?")) {
			sb.append("?");
		}
		if (params.size() > 0) {
			for (String key : params.keySet()) {
				sb.append(sb.length() > 0 ? "&" : "");
				sb.append(key).append("=").append(params.get(key));
			}
		}
		String ret = "";
		try {
			HttpGet httpget = new HttpGet(url + sb.toString());
			// 配置请求的超时设置
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectionRequestTimeout(120000).setConnectTimeout(120000)
					.setSocketTimeout(120000).build();
			httpget.setConfig(requestConfig);
			CloseableHttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			ret = EntityUtils.toString(entity);// , "utf-8");
			httpget.releaseConnection();
			logger.info("Execute Notify Result ordersn=" + ordersn + "-->uuid=" + uuid
					+ "-->" + ret);
		} catch (Exception e) {
			logger.error("HTTP get Exception uuid=" + uuid + ";ordersn="
					+ ordersn, e);
		}
		return ret;
	}

	public static String httpPost(String url, String ordersn, String uuid,
			Map<String, Object> parameters) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost httppost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(120000).setConnectTimeout(120000).build();//设置请求和传输超时时间
		httppost.setConfig(requestConfig);
//		httppost.setHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
//		httppost.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
//		httppost.setHeader(HttpHeaders.CONTENT_TYPE,"text/html:charset=UTF-8");
//		httppost.setHeader(HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.6) Gecko/20100625 Firefox/3.6.6");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if (parameters.size() > 0) {
			for (String key : parameters.keySet()) {
				if(key != null && parameters.get(key)!=null){
					params.add(new BasicNameValuePair(key, parameters.get(key).toString()));
				}
			}
		}
		String ret = "";
		try {
			httppost.setEntity(new UrlEncodedFormEntity(params,CHARSET));
			CloseableHttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			ret = EntityUtils.toString(entity, CHARSET);
			httppost.releaseConnection();
			logger.info("Execute Notify Result ordersn=" + ordersn + "-->uuid=" + uuid
					+ "-->" + ret);
		} catch (Exception e) {
			logger.error("HTTP post Exception uuid=" + uuid + ";ordersn="
					+ ordersn, e);
		}
		return ret;
	}

	// 应用
	public static String httpsPost(String url, String ordersn, String uuid,
			Map<String, Object> map) {
		String ret = null;
		try {
			CloseableHttpClient httpClient = createSSLClientDefault();
			List<NameValuePair> pairs = null;
			if (map != null && !map.isEmpty()) {
				pairs = new ArrayList<NameValuePair>(map.size());
				for (Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					if (entry.getKey() != null && value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value.toString()));
					}
				}
			}
			HttpPost httpPost = new HttpPost(new URI(url));
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(120000).setConnectTimeout(120000).build();//设置请求和传输超时时间
			httpPost.setConfig(requestConfig);
			if (pairs != null && pairs.size() > 0) {
				httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
			}
			CloseableHttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new RuntimeException("HttpClient,error status code :"
						+ statusCode);
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				ret = EntityUtils.toString(entity, CHARSET);
			}
			EntityUtils.consume(entity);
			response.close();
			logger.info("Execute Notify Result ordersn=" + ordersn + "-->uuid=" + uuid
					+ "-->" + ret);
		} catch (Exception e) {
			logger.error("HTTPS post Exeception uuid=" + uuid + ";ordersn="
					+ ordersn, e);
		}
		return ret;
	}
	
	public static void main1(String[] args) {
		for(int i = 0 ;i<10 ;i++){
			String notify_url = "http://www.junkun.net/yytRechargeNotifyurl.do";
			String source = "returncode=00&merchno=611100000309910&dsorderid=R2015061700023007427&amount=162800.00&orderid=150617131814167&transdate=20150617&transtime=131931&syssn=315704&dstbdatasign=7FBB5615FE73CE4242304A31F6D621382E16985D2AFD85989C6F5836DCE418467E03EB1B13091ABA85E70F88C1D3EC1F037DB798FC69A49C70F0C254419652A7A8629BC9221DF4E64470D00A02AC15AFEC572B39367514448FB16089AA273B94A0AB56A2D6F4D3361C08C1EFA41800C2D5D5F78A072FF8FDEC3C9CD59C530ED59FFC3E022B3030899148109FF1CB35C2A5B9F158BD12205BD3DC8904B36129A9";
			Map<String, Object> sPara = new LinkedHashMap<String, Object>();
			String[] sourceArray = source.split("&");
			for(String s : sourceArray){
				String[] sa = s.split("=");
				sPara.put(sa[0], sa[1]);
				System.out.println("通知参数："+sa[0]+"="+sa[1]);
			}
			String str = httpPost(notify_url, "11", "22", sPara);
			System.out.println("通知结果："+str);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// String httpsUrl =
		// "https://www.ayjrjy.com/escrow/web/ebc/rechargeResult";
//		String httpsUrl = "https://localhost:8443/testssl/test";
//		String httpUrl = "http://www.ynfcct.com/excsh-1.0.1/ebcCallbackAction!recharge.htm";
		String httpUrl ="http://127.0.0.1:9080/trainTicket-site/service/trainTicketNotify";
//		
		String param = "%3c%3fxml+version%3d%221.0%22+encoding%3d%22utf-8%22%3f%3e%0d%0a%3cReceiveTicketStatusRet+xmlns%3axsd%3d%22http%3a%2f%2fwww.w3.org%2f2001%2fXMLSchema%22+xmlns%3axsi%3d%22http%3a%2f%2fwww.w3.org%2f2001%2fXMLSchema-instance%22%3e%0d%0a++++%3cOrderNo%3eT17011201063%3c%2fOrderNo%3e%0d%0a++++%3cRetCode%3e0000%3c%2fRetCode%3e%0d%0a++++%3cErrorMsg+%2f%3e%0d%0a++++%3cFlag%3e%e5%87%ba%e7%a5%a8%e6%88%90%e5%8a%9f%3c%2fFlag%3e%0d%0a++++%3cTickets%3e%0d%0a++++++++%3cReceiveTicketStatusItem%3e%0d%0a++++++++++++%3cPassengerName%3e%e8%92%8b%e5%b9%b3%e5%8f%91%3c%2fPassengerName%3e%0d%0a++++++++++++%3cPassengerIdCard%3e610104197505200013%3c%2fPassengerIdCard%3e%0d%0a++++++++++++%3cSeatName%3e101%3c%2fSeatName%3e%0d%0a++++++++++++%3cTicketPrice%3e192%3c%2fTicketPrice%3e%0d%0a++++++++++++%3cRefundAmount%3e0%3c%2fRefundAmount%3e%0d%0a++++++++++++%3cPassengerType%3e1%3c%2fPassengerType%3e%0d%0a++++++++++++%3cETicketNo%3eEB04870831%3c%2fETicketNo%3e%0d%0a++++++++++++%3cRoomNo%3e02%e8%bd%a6%e5%8e%a2%3c%2fRoomNo%3e%0d%0a++++++++++++%3cSeatNo%3e054%e5%8f%b7%3c%2fSeatNo%3e%0d%0a++++++++%3c%2fReceiveTicketStatusItem%3e%0d%0a++++%3c%2fTickets%3e%0d%0a%3c%2fReceiveTicketStatusRet%3e";
		String sign ="0175120ca928b2cea912a1ea2037c3f2";
		Map<String, Object> m1 = new HashMap<String, Object>();
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("data", param);
		m2.put("sign", sign);
		m2.put("method", "AllotSuccess");
		String json = JsonUtil.getMapToJson(m2);
		m1.put("resData", json);
		
		System.out.println("手动模拟异步通知是返回："+httpPost(httpUrl,"111111111111111111111","111111111111111111111111",m1));
	}
}
