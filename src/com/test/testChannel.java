package com.test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import notify.NotifyService;
import util.JsonUtil;
import business.Business_channel;

public class testChannel {

	public static void main(String[] args) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Business_channel bc = new Business_channel();
		String service = "";

		// 查询银行信息
		map = bc.bankInfoQuery();
		service = "bankInfoQuery";
		
		String json = JsonUtil.getMapToJson(map);
		
		//组装调用dbank-site的数据报文
		String keyStr = "112233";
		String resData = json;
		String md5Str = MD5Encrypt.MD5("keyStr="+keyStr + "resData="+resData);
		
		Map<String,Object> map2 = new LinkedHashMap<String, Object>();
//		map2.put("md5Str", md5Str);
		map2.put("resData", resData);
//		map2.put("keyStr", keyStr);
//		String json = "{\"channel\" : \"01\",\"serviceCode\" : \"authenticate\",\"channelUserId\" : \"01|19477\",\"channelUserKey\" : null,\"channelSerialNumber\" : \"CK9dighffgfdcd85475KS9E15324\",\"ifpSerialNumber\" : null,\"dealingSerialNumber\" : null,\"sig\" : null,\"document\" : \"原始报文包含敏感信息,已屏蔽\",\"serviceTime\" : 1429511866586,\"view\" : null},\"requestOperateType\" : \"NORMAL\",\"username\":\"15190130165\",\"password\":\"123qwe\",\"passwordCode\":null,\"handPassword\":null,\"imageCodeInRequest\":null,\"imageCodeInSession\":null,\"imageCodeGeneratedTime\":null,\"ip\":\"221.178.135.254\",\"sessionId\":\"b-kuG4FmuiYJ98BFZsKsd3v\",\"mac\":\"CC:3A:61:29:66:16\"}";
//		HttpRequestParam param = new HttpRequestParam();
//		param.setUrl("http://127.0.0.1:8098/dbank-site/service/test?format=json");
//		param.setUrl("http://127.0.0.1:8098/dbank-site/service/register?format=json");//用户注册
		
//		Map<String,String> heads = Maps.newHashMap();
//		heads.put("Content-Type", "application/json;charset=UTF-8");
//		param.setContext(map1);
//		param.setHeads(heads);
//		HttpResponser resp=HttpHelp.postParamByHttpClient(param);
//		System.out.println(resp.getContent());

		
		Map<String,Object> parameters = new HashMap<String, Object>();
//		parameters.put("url", "http://127.0.0.1:9086/channel-site/service/"+service);
		parameters.put("url", "http://218.240.148.249:8070/channel-site/service/"+service);
		parameters.put("ordersn", "111111111111111111111");
		parameters.put("uuid", "111111111111111111111111");
		parameters.put("parameters", map2);
		String ret = NotifyService.executeNotice(parameters);
		System.out.println("通知结果："+ret);
		
		
	}

}
