//package business;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 产品配置类，开发使用，可以删除
// * @author 刘熙
// *
// */
//public class Business_productConfig {
//	
//	private String productId = "16122016173780156821";
//	
//	/*
//	 * =======================产品配置=======================
//	 */
//	
//	/**
//	 * 增加配置（后台管理）
//	 */
//	public Map<String, Object> addProductConfig(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		
//		map.put("productName", "产品1");
//		map.put("applyAmount", 10000);
//		map.put("zhlApplyAmount", 30000);
//		map.put("interestRate1", 0.02);
//		map.put("interestRate2", 0.03);
//		map.put("interestRate3", 0.01);
//		map.put("interestRate4", 0.01);
//		map.put("interestRate5", 0.01);
//		map.put("otherAmount", 50);
//		map.put("overdueRate", 0.05);
//		map.put("deposit", 0.01);
//		map.put("otherAmount", 5);
//		return map;
//	}
//	
//	/**
//	 * 修改配置（后台管理）
//	 */
//	public Map<String, Object> updateProductConfig(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		
//		map.put("productId", productId);
//		map.put("productName", "产品1");
//		map.put("applyAmount", 10000);
//		map.put("zhlApplyAmount", 29800);
//		map.put("interestRate1", 0.02);
//		map.put("interestRate2", 0.03);
//		map.put("interestRate3", 0.01);
//		map.put("interestRate4", 0.01);
//		map.put("interestRate5", 0.01);
//		map.put("otherAmount", 5);
//		map.put("overdueRate", 0.05);
//		map.put("state", "01");
//		return map;
//	}
//	
//	/**
//	 * 查询单个（后台管理）
//	 */
//	public Map<String, Object> productConfigQuery(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("productId", productId);
//		return map;
//	}
//	
//	/**
//	 * 查询list（后台管理）
//	 */
//	public Map<String, Object> productConfigQueryList(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("pageNumber", 0);
//		map.put("productId", "");
//		map.put("productName", "");
//		map.put("state", "");
//		map.put("type", "");
//		return map;
//	}
//	
//	/**
//	 * 查询list（app）
//	 */
//	public Map<String, Object> productConfigList(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		return map;
//	}
//	
//}
