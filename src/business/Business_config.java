//package business;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 配置类，开发使用，可以删除
// * @author 刘熙
// *
// */
//public class Business_config {
//	
//	/*
//	 * ================================配置===================================
//	 * 
//	 */
//	
//	/**
//	 * 增加key唯一配置
//	 */
//	public Map<String, Object> addConfig(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("key", "zhlRepaymentDate");
//		map.put("value", "1");
//		map.put("order", "");
//		map.put("group", "repayment");
//		map.put("rsv1", "");
//		map.put("rsv2", "");
//		map.put("comment", "中互联还银行日期");
//		return map;
//	}
//	
//	/**
//	 * 增加key可重配置
//	 */
//	public Map<String, Object> addConfigRepeat(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("key", "60");
//		map.put("value", "0.02");
//		map.put("order", "");
//		map.put("group", "interestRate");
//		map.put("rsv1", "");
//		map.put("rsv2", "");
//		map.put("comment", "服务费");
//		return map;
//	}
//	
//	/**
//	 * 修改配置
//	 */
//	public Map<String, Object> updateConfig(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("key", "24");
//		map.put("value", "0.01");
//		map.put("order", "");
//		map.put("group", "interestRate");
//		map.put("rsv1", "1");
//		map.put("rsv2", "");
//		map.put("comment", "还款周期利率");
//		return map;
//	}
//	
//	/**
//	 * 按唯一key查询
//	 */
//	public Map<String, Object> queryByKey(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("key", "defaultLoanTime");
//		map.put("group", "interestRate");
//		return map;
//	}
//	
//	/**
//	 * 按可重key查询
//	 */
//	public Map<String, Object> queryByKeyRepeat(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("key", "60");
//		map.put("group", "interestRate");
//		return map;
//	}
//	
//	/**
//	 * 按组查询
//	 */
//	public Map<String, Object> QueryGroup(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("group", "interestRate");
//		return map;
//	}
//	
//	
//	
//
//}
