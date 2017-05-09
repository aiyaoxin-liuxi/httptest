//package business;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 还款业务类，开发使用，可以删除
// * 
// * @author 刘熙
// * 
// */
//public class Business_repayment {
//	
//	private String applyId = "16121921502399775320";
//	
//	private String rmId = "";
//	
//	/*
//	 * ===========================还款========================
//	 */
//	
//	/**
//	 * 根据修改的传参ajax生成利息、利率、每月还款额、每月利息、保证金金额信息————公用
//	 */
//	public Map<String, Object> repaymentCreate() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("applyId", applyId);
//		map.put("amountParam", 100);
//		map.put("repaymentPeriodsParam", 36);
//		map.put("interestRateParam", 0.02);
//		map.put("rmTypeParam", "01");
//		map.put("deposit", 0.01);
//		return map;
//	}
//	
//	/**
//	 * 中互联利息计算公用方法（根据本金、期数、还款方式、配置中的利率，计算利息、还款金额）————公用
//	 */
//	public Map<String, Object> zhlInterestCalculation() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("applyId", applyId);
//		map.put("amountParam", 100);
//		map.put("repaymentPeriodsParam", 36);
//		map.put("interestRateParam", 0.02);
//		map.put("rmTypeParam", "01");
//		map.put("deposit", 0.01);
//		return map;
//	}
//	
//	/**
//	 * 获取当前用户本月应还款总额
//	 */
//	public Map<String, Object> repaymentAmountQuery() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("applyId", applyId);
//		return map;
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	/**
//	 * 还款记录单个查询
//	 */
//	public Map<String, Object> repaymentQuery() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("userId", "123123");
//		return map;
//	}
//
//	/**
//	 * 手动还款
//	 */
//	public Map<String, Object> repaymentOperate() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("userId", "123123");
//		map.put("personID", "1239");
//		map.put("applyId", applyId);
//		// map.put("type", "01");
//		map.put("transferAmount", "175.00");
//		return map;
//	}
//	
//	/**
//	 * 自动还款后，处理中的人工审核确认，改为已还款
//	 */
//	public Map<String, Object> repaymentConfirm() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("userId", "123123");
//		map.put("applyId", applyId);
//		return map;
//	}
//	
//	/**
//	 * 自动还款后，处理中的人工审核确认，改为已还款
//	 */
//	public Map<String, Object> repaymentFail() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("userId", "123123");
//		map.put("applyId", applyId);
//		return map;
//	}
//	
//	/**
//	 * 定时任务——用户还款
//	 */
//	public Map<String, Object> quartzUserRepayment() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		return map;
//	}
//	
//	/**
//	 * 定时任务开启下一期
//	 */
//	public Map<String, Object> quartzOpenNextRepayment() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		return map;
//	}
//	
//	/**
//	 * 定时任务——中互联还款
//	 */
//	public Map<String, Object> quartzZhlRepayment() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		return map;
//	}
//	
//	
//	
//
//}
