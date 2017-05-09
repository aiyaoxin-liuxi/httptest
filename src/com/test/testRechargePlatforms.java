package com.test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.HashMap;
import java.util.Map;

import org.pub.util.https.HttpClientUtil;

import util.HttpUtil;
import util.JsonUtil;
import util.Utilc;
import business.Business_ticket;

public class testRechargePlatforms {

	public static void main(String[] args) throws ConnectException, SocketTimeoutException, MalformedURLException, FileNotFoundException, UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Business_ticket bc = new Business_ticket();
		String service = "";

		// 获得站点列表
//		map = bc.stationList();
//		service = "stationList";
		
		// 站站查询
//		map = bc.stationToStation();
//		service = "stationToStation";
		
		// 车站查询
//		map = bc.stationQuery();
//		service = "stationQuery";
		
		// 车次查询
//		map = bc.trainQuery();
//		service = "trainQuery";
		
		// 预订前的查询（车次、价格和余票）
//		map = bc.trainSearch();
//		service = "trainSearch";
		
		// 订单提交
//		map = bc.submitOrder();
//		service = "submitOrder";
		
		// 确认订单（支付）
//		map = bc.confirmOrder();
//		service = "confirmOrder";
		
		// 取消订单
//		map = bc.cancleOrder();
//		service = "cancleOrder";
		
		// 退票
//		map = bc.bounce();
//		service = "bounce";
		
		// 查询订单(返回值需要调整)
//		map = bc.queryOrder();
//		service = "queryOrder";
		
		// 余额查询
//		map = bc.overage();
//		service = "overage";
		
		
		// 通知
//		map = bc.trainTicketNotify();
		service = "trainTicketNotify";
		
		String mapStr = "method=AllotSuccess&data=%3c%3fxml+version%3d%221.0%22+encoding%3d%22utf-8%22%3f%3e%0d%0a%3cReceiveTicketStatusRet+xmlns%3axsd%3d%22http%3a%2f%2fwww.w3.org%2f2001%2fXMLSchema%22+xmlns%3axsi%3d%22http%3a%2f%2fwww.w3.org%2f2001%2fXMLSchema-instance%22%3e%0d%0a++++%3cOrderNo%3eT17011201063%3c%2fOrderNo%3e%0d%0a++++%3cRetCode%3e0000%3c%2fRetCode%3e%0d%0a++++%3cErrorMsg+%2f%3e%0d%0a++++%3cFlag%3e%e5%87%ba%e7%a5%a8%e6%88%90%e5%8a%9f%3c%2fFlag%3e%0d%0a++++%3cTickets%3e%0d%0a++++++++%3cReceiveTicketStatusItem%3e%0d%0a++++++++++++%3cPassengerName%3e%e8%92%8b%e5%b9%b3%e5%8f%91%3c%2fPassengerName%3e%0d%0a++++++++++++%3cPassengerIdCard%3e610104197505200013%3c%2fPassengerIdCard%3e%0d%0a++++++++++++%3cSeatName%3e101%3c%2fSeatName%3e%0d%0a++++++++++++%3cTicketPrice%3e192%3c%2fTicketPrice%3e%0d%0a++++++++++++%3cRefundAmount%3e0%3c%2fRefundAmount%3e%0d%0a++++++++++++%3cPassengerType%3e1%3c%2fPassengerType%3e%0d%0a++++++++++++%3cETicketNo%3eEB04870831%3c%2fETicketNo%3e%0d%0a++++++++++++%3cRoomNo%3e02%e8%bd%a6%e5%8e%a2%3c%2fRoomNo%3e%0d%0a++++++++++++%3cSeatNo%3e054%e5%8f%b7%3c%2fSeatNo%3e%0d%0a++++++++%3c%2fReceiveTicketStatusItem%3e%0d%0a++++%3c%2fTickets%3e%0d%0a%3c%2fReceiveTicketStatusRet%3e&sign=0175120ca928b2cea912a1ea2037c3f2";
//		String mapStr = Utilc.getUrlParamsByMap(map);
//		try {
//			mapStr = URLEncoder.encode(mapStr, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		map = JsonUtil.getJsonToMap(mapStr);
//		map = XmlUtils.getXmlToMap(str);
		
		String dbankUrl = null;
		
		/** 开发环境地质 */
//		dbankUrl = "http://127.0.0.1:8065/trainTicket-site/service/"+service;
		dbankUrl = "http://127.0.0.1:8065/trainTicket-provider/service/"+service;
		
		/** 测试环境地址（vpn） */
//		dbankUrl = "http://192.168.10.6:8065/trainTicket-site/service/"+service;
//		dbankUrl = "http://192.168.10.6:8065/trainTicket-provider/service/"+service;
		
		/** 测试环境地址（外网） */
//		dbankUrl = "http://218.240.148.254/trainTicket-site/service/"+service;
//		dbankUrl = "http://218.240.148.254/trainTicket-provider/service/"+service;
		
		String json = JsonUtil.getMapToJson(map);
//		json = HttpClientUtil.httpPost(dbankUrl, "", map);
		json = HttpClientUtil.httpPost(dbankUrl, "", mapStr);
//		json = HttpUtil.httpsPost(dbankUrl, "", map);
		
		System.out.println("通知结果:"+json);
		
	}

}
