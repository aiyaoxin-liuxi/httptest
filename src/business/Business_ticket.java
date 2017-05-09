package business;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.pub.util.json.JsonUtil;
import org.pub.util.security.MessageSecurity;

import pojo.Passenger;
import util.Utilc;
import util.XmlUtils;

/**
 * ticket类，开发使用，可以删除
 * @author 刘熙
 *
 */
public class Business_ticket {
	
	/**
	 * 获得站点列表
	 * @return
	 */
	public Map<String, Object> stationList(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		return addSign(map);
	}
	
	/**
	 * 站站查询
	 * @return
	 */
	public Map<String, Object> stationToStation(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("from", "北京");
		map.put("to", "上海");
		return addSign(map);
	}
	
	/**
	 * 车站查询
	 * @return
	 */
	public Map<String, Object> stationQuery(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("stationName", "北京");
		return addSign(map);
	}
	
	/**
	 * 车次查询
	 * @return
	 */
	public Map<String, Object> trainQuery(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("trainNo", "G140");
		return addSign(map);
	}
	
	/**
	 * 预订前的查询（车次、价格和余票）
	 * @return
	 */
	public Map<String, Object> trainSearch(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("from", "北京");
		map.put("to", "南京");
		map.put("date", "2017-02-16");
		return addSign(map);
	}
	
	/**
	 * 提交订单
	 * @return
	 */
	public Map<String, Object> submitOrder(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("outOrderNo", "222222");
		map.put("notifyUrl", "www.test.com");
		map.put("fromStation", "北京");
		map.put("toStation", "南京");
		map.put("fromDate", "2017-02-20");
		map.put("trainNo", "G101");
		map.put("seatCode", "207");
		map.put("ticketCount", "1");
		map.put("otherSeats", "205");
		map.put("conName", "刘熙");
		map.put("conMobile", "13810193325");
		map.put("conEmail", "liuxi_0203@163.com");
//		map.put("conEmail", "");
		
		Map<String,Object> psmap = new HashMap<String,Object>();
		List<Passenger> list = new ArrayList<Passenger>();
		Passenger p = new Passenger();
		p.setTicketType("1");
		p.setPassengerName("刘熙");
		p.setCertCardType("2");
		p.setCertCardNo("110104198602030438");
		p.setInsuranceCount("1");
		
//		Passenger p2 = new Passenger();
//		p2.setTicketType("1");
//		p2.setPassengerName("李敏");
//		p2.setCertCardType("2");
//		p2.setCertCardNo("342625198303102394");
//		p2.setInsuranceCount("1");
//		list.add(p2);
		list.add(p);
		
		psmap.put("Passenger", list);
		String json = JsonUtil.getMapToJson(psmap);
		
		map.put("passengers", json);
		return addSign(map);
	}
	
	/**
	 * 确认订单（支付）
	 * @return
	 */
	public Map<String, Object> confirmOrder(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("zOrderNo", "17021517117619999932");
		map.put("outOrderNo", "222222");
		map.put("orderNo", "T17021501004");
		map.put("payAmount", "768.50");
		return addSign(map);
	}
	
	/**
	 * 取消订单
	 * @return
	 */
	public Map<String, Object> cancleOrder(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("zOrderNo", "17021410501510291997");
		map.put("outOrderNo", "222222");
		map.put("orderNo", "T17021401004");
		return addSign(map);
	}
	
	/**
	 * 退票
	 * @return
	 */
	public Map<String, Object> bounce(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("zOrderNo", "17021410039737626575");
		map.put("outOrderNo", "222222");
		map.put("orderNo", "T17021401001");
		map.put("ticketNos", "201953");
		return addSign(map);
	}
	
	/**
	 * 查询订单
	 * @return
	 */
	public Map<String, Object> queryOrder(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", "000001");
		map.put("zOrderNo", "17021517117619999932");
		map.put("outOrderNo", "222222");
		map.put("orderNo", "T17021501004");
//		map.put("orderNo", "T17011801017");
		
		return addSign(map);
	}
	
	/**
	 * 余额查询
	 * @return
	 */
	public Map<String, Object> overage(){
		Map<String,Object> map = new HashMap<String,Object>();
		return map;
	}
	
	/**
	 * 通知
	 * @return
	 */
	public Map<String, Object> trainTicketNotify(){
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 出票失敗通知
//		Map<String, Object> testMap = new LinkedHashMap<String, Object>();
////		Map<String, Object> testMap1 = new LinkedHashMap<String, Object>();
//		testMap.put("OrderNo", "T17011901003");
////		testMap.put("receiveTicketStatusRet", testMap1);
//		String xml = XmlUtils.getMapToXmlNotify(testMap);
//		String sign = DigestUtils.md5Hex(xml + "zhltest");
//		try {
//			xml = URLEncoder.encode(xml, "UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//		map.put("method", "AllotFailed");
//		map.put("sign", sign);
//		map.put("data", xml);
		
		// 出票成功
		Map<String, Object> testMap = new LinkedHashMap<String, Object>();
		Map<String, Object> testMap1 = new LinkedHashMap<String, Object>();
		Map<String, Object> testMap2 = new LinkedHashMap<String, Object>();
		Map<String, Object> testMap3 = new LinkedHashMap<String, Object>();
		
		testMap3.put("PassengerName", "刘熙");
		testMap3.put("PassengerIdCard", "110104198602030438");
		testMap3.put("SeatName", "207");
		testMap3.put("TicketPrice", "500");
		testMap3.put("RefundAmount", "200");
		testMap3.put("PassengerType", "1");
		testMap3.put("ETicketNo", "EB04870831");
		testMap3.put("RoomNo", "02车厢");
		testMap3.put("SeatNo", "054号");
		
		testMap2.put("ReceiveTicketStatusItem", testMap3);
		
		testMap1.put("OrderNo", "T17021501003");
		testMap1.put("RetCode", "0000");
		testMap1.put("ErrorMsg", "");
		testMap1.put("Flag", "出票成功");
		testMap1.put("Tickets", testMap2);
		
//		testMap.put("ReceiveTicketStatusRet", testMap1);
		
		String xml = XmlUtils.getMapToXmlNotify(testMap1);
		String sign = DigestUtils.md5Hex(xml + "zhltest");
		try {
			xml = URLEncoder.encode(xml, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		map.put("method", "WaitRepay");
		map.put("sign", sign);
		map.put("data", xml);
		
		return map;
	}
	
	
	private Map<String, Object> addSign(Map<String, Object> map){
		String json = JsonUtil.getMapToJson(map);
		String sign = MessageSecurity.getMessageSecurity("", json, "test123");
		map.put("sign", sign);
		return map;
	}

}
