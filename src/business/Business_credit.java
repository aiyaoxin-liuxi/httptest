package business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.http.entity.mime.content.FileBody;

/**
 * 授信业务类，开发使用，可以删除
 * @author 刘熙
 *
 */
public class Business_credit {
	
	private String productId = "16122920553155895608";
	// 用户
	private String userId = "257477";
	private String personId = "257476";
	private String mobile = "13810193325";
	private String payPass = "lx1111";
	private String applyId = "17010510523178668356";
	private String rmId = "";
//	private String outNo = "1100000000118514"; // 电子账号
//	private String outNo = "1500000000121692"; // 我的电子账号
	private String outNo = "6228480712381120909"; // 银行卡号
	
	
	// 中互联
	private String ZhlOrder = "62220000000000000000";
	private String ZhluserId = "257743";
	private String ZhlMobile = "13810577695";
	/*
	 * ==========================授信=========================
	 */
	
	/**
	 * 查询用户下该产品授信信息，若没有则显示默认信息
	 * @return
	 */
	public Map<String, Object> applyInit(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("personId", "1239");
		map.put("userId", "12399");
		map.put("productId", productId);
		return map;
	}
	
	/**
	 * 添加授信申请————app
	 */
	public Map<String, Object> addApply(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("personId", personId);
//		map.put("personId", "12391");
		map.put("userId", userId);
		map.put("productId", productId);
		map.put("applyAmount", 10000);
		map.put("repaymentPeriods", "36");
		map.put("rmType", "01");
		return map;
	}
	
	/**
	 * app————根据产品id和用户id查询申请信息
	 * @return
	 */
	public Map<String, Object> applyQueryDetail(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("personId", personId);
		map.put("userId", userId);
		map.put("productId", productId);
		return map;
	}
	
	/**
	 * 利息计算————公用applyCommit
	 */
	public Map<String, Object> interestCalculation(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productId", productId);
		map.put("applyAmount", 10000);
		map.put("repaymentPeriods", "36");
		map.put("rmType", "01");
		return map;
	}
	
	/**
	 * 审核提交————后台
	 */
//	public Map<String, Object> applyBackReview(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("applyId", applyId);
//		map.put("userName", "刘熙");
//		map.put("idCardNo", "110104198811030333");// 身份证号
//		map.put("mobilePhone", mobile);// 手机号
//		map.put("bankName", "测试银行");// 银行卡名称
//		map.put("defaultCard", "66666666666666");// 银行卡号
//		map.put("applyAmount", "10000");// 申请金额
//		map.put("agreeAmount", "10000");// 批复金额
//		map.put("aggregateAmount", "9000");// 需还款总额=授信金额+利息
//		map.put("creditAmount", 9000);// 授信金额（刨除保证金）
//		map.put("deposit", "0.10");// 保证金率
//		map.put("depositAmount", "1000");// 保证金金额
//		map.put("extraAmount", 0);// 其他金额
////		map.put("agreeDate", "");
////		map.put("userAgreeDate", "");
////		map.put("state", "");
//		map.put("repaymentPeriods", "36");// 周期
//		map.put("interestRate", "0.0150");// 利率
//		map.put("interest", 5400);// 利息
//		map.put("rmType", "01");// 还款方式（等额本金）
//		map.put("monthRmPrincipal", "250");// 每月还款本金
//		map.put("monthRmInterest", 150);// 每月还款利息
//		map.put("loanComment", "你猜");// 用途
////		map.put("isAudit", "");
//		map.put("zhlPrincipalAmount", "30000");// 中互联本金金额
////		map.put("zhlApplyDate", "2017-01-01");// 中互联收到银行钱时间
////		map.put("zhlStartRmDate", "2019-01-01");// 中互联开始还款时间
////		map.put("zhlEarlyPeriods", "12");// 中互联前期期数
////		map.put("zhlLaterPeriods", "24");// 中互联后期期数
////		map.put("zhlEarlyRmAmount", "500");// 中互联前期还款额
////		map.put("zhlLaterRmAmount", "600");// 中互联后期还款额
////		map.put("zhlRmAmount", "30000");// 中互联总还款额
////		map.put("zhlInterestAmount", "900"); // 中互联总还款利息
//		return map;
//	}
	public Map<String, Object> applyBackReview(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		map.put("userName", "李吉龙");
		map.put("idCardNo", "110101199108121532");// 身份证号
		map.put("mobilePhone", mobile);// 手机号
		map.put("bankName", "测试银行");// 银行卡名称
		map.put("defaultCard", "66666666666666");// 银行卡号
		map.put("applyAmount", "10000");// 申请金额
		map.put("agreeAmount", "10000");// 批复金额
		map.put("aggregateAmount", "9000");// 需还款总额=授信金额+利息
		map.put("creditAmount", 9000);// 授信金额（刨除保证金）
		map.put("deposit", "0.10");// 保证金率
		map.put("depositAmount", "1000");// 保证金金额
		map.put("extraAmount", 0);// 其他金额
//		map.put("agreeDate", "");
//		map.put("userAgreeDate", "");
//		map.put("state", "");
		map.put("repaymentPeriods", "36");// 周期
		map.put("interestRate", "0.0150");// 利率
		map.put("interest", 5400);// 利息
		map.put("rmType", "01");// 还款方式（等额本金）
		map.put("monthRmPrincipal", "250");// 每月还款本金
		map.put("monthRmInterest", 150);// 每月还款利息
		map.put("loanComment", "你猜");// 用途
//		map.put("isAudit", "");
		map.put("zhlPrincipalAmount", "30000");// 中互联本金金额
//		map.put("zhlApplyDate", "2017-01-01");// 中互联收到银行钱时间
//		map.put("zhlStartRmDate", "2019-01-01");// 中互联开始还款时间
//		map.put("zhlEarlyPeriods", "12");// 中互联前期期数
//		map.put("zhlLaterPeriods", "24");// 中互联后期期数
//		map.put("zhlEarlyRmAmount", "500");// 中互联前期还款额
//		map.put("zhlLaterRmAmount", "600");// 中互联后期还款额
//		map.put("zhlRmAmount", "30000");// 中互联总还款额
//		map.put("zhlInterestAmount", "900"); // 中互联总还款利息
		return map;
	}
	
	/**
	 * 后台————后台允许放款(修改状态)
	 * @return
	 */
	public Map<String, Object> applyBackLoan(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 后台————根据applyId查询所有还款记录信息(分页)
	 * @return
	 */
	public Map<String, Object> repaymentBackQueryPageList(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
//		map.put("state", "");
		map.put("pageNumber", 0);
//		map.put("pageSize", 5);
//		map.put("orderAscending", "DESC");				// 排序
//		map.put("orderPropertyName", "createdDate");	// 排序字段
		return map;
	}
	
	/**
	 * 查询还款详细信息————后台
	 * @return
	 */
	public Map<String, Object> repaymentQueryDetail(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rmId", rmId);
		return map;
	}
	
	/**
	 * app————后台放款后用户点击确认
	 * @return
	 */
	public Map<String, Object> applyUserConfirmLoan(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * app————记录用户信息图片地址
	 * @return
	 */
	public Map<String, Object> applyUserImgInsert(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("personId", personId);
		map.put("applyId", applyId);
		map.put("productId", productId);
		map.put("urlPaths", "\\upfiles\\1701031670835928-FFD8FF\\view.html,\\upfiles\\1701031726248203-FFD8FF\\view.html,\\upfiles\\1701030028936046-FFD8FF\\view.html");
		return map;
	}
	
	/**
	 * app————查询用户信息图片地址
	 * @return
	 */
	public Map<String, Object> applyUserImgQuery(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("personId", personId);
		map.put("applyId", applyId);
		map.put("productId", productId);
		map.put("imgId", "");
		map.put("pageNumber", 0);
//		map.put("pageSize", 15);
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 增加订单————后台
	 */
	public Map<String, Object> addApplyBack(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("userName", "张三");
		map.put("mobilePhone", mobile);
		map.put("bankName", "XXX银行");
		map.put("bankCardNo", "6666666666666666");
		map.put("loanComment", "钱钱钱");
		map.put("applyAmount", 15550);
		return map;
	}
	
	/**
	 * 批复订单
	 */
	public Map<String, Object> updateApplyAgree(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		map.put("agreeAmount", 10000.00);
		map.put("zhlPrincipalAmount", 29800.00);
		map.put("zhlApplyDate", "2016-11-30");
		map.put("zhlStartRmDate", "2016-11-30");
		return map;
	}
	
	/**
	 * 驳回订单
	 */
	public Map<String, Object> updateApplyRejected(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 订单通过后,用户确认
	 */
	public Map<String, Object> updateApplyUserConfirm(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 订单通过后,用户取消
	 */
	public Map<String, Object> updateApplyUserCancel(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 查询申请表或按条件查询
	 * 条件：申请id、用户id、申请状态、申请时间、批复时间
	 * @return
	 */
	public Map<String, Object> queryConditions(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageNumber", 0);
		map.put("applyId", "");
		map.put("userId", "");
		map.put("state", "");
		map.put("startAgreeDate", "");
		map.put("endAgreeDate", "");
		map.put("startCreateDate", "");
		map.put("endCreateDate", "");
		return map;
	}
	
	/**
	 * 查询单个详细信息
	 * @return
	 */
	public Map<String, Object> queryApplyDetail(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 分期和签约
	 * @return
	 */
	public Map<String, Object> instalmentsAndContract(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		map.put("contract", "01");
//		map.put("repayMentPeriods", "10");
//		map.put("counterFeeRecord", "{'服务费':'0.02','B费':'0.02'}");
		return map;
	}
	
	/**
	 * 放款(手动)
	 * @return
	 */
	public Map<String, Object> applyLoan(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 放款(自动)
	 * @return
	 */
	public Map<String, Object> applyLoanAuto(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		return map;
	}
	
	/**
	 * app————根据userId查询所有的申请表信息
	 * @return
	 */
	public Map<String, Object> applyQueryList(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
//		map.put("state", "00");
		map.put("pageNumber", 0);
//		map.put("pageSize", 5);
//		map.put("orderAscending", "DESC");				// 排序
//		map.put("orderPropertyName", "createdDate");	// 排序字段
		return map;
	}
	
	/**
	 * app————根据applyId查询所有还款记录信息(分页)
	 * @return
	 */
	public Map<String, Object> repaymentQueryPageList(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
//		map.put("state", "");
		map.put("pageNumber", 0);
//		map.put("pageSize", 5);
//		map.put("orderAscending", "DESC");				// 排序
//		map.put("orderPropertyName", "createdDate");	// 排序字段
		return map;
	}
	
	/**
	 * app————根据applyId查询所有还款记录信息
	 * @return
	 */
	public Map<String, Object> repaymentQueryList(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 中互联还银行进行审核，提供人工设置的审核————后台
	 */
	public Map<String, Object> zhlBackRepaymentReview() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rmId", applyId);
		map.put("zhlNewBalanceTotal", 100);
		map.put("zhlOverdueCharges", 50);
		return map;
	}
	
	/**
	 * 查询用户已还款，但中互联还未还款成功的列表信息————后台（分页）
	 */
	public Map<String, Object> zhlBackRepaymentQueryList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", 0);
		return map;
	}
	
	/**
	 * 查询用户已还款，但中互联还未还款成功的详细信息————后台
	 */
	public Map<String, Object> zhlBackRepaymentQueryDetail() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rmId", rmId);
		return map;
	}
	
//	/**
//	 * 增加用户个人信息————app
//	 * @return
//	 * @throws FileNotFoundException 
//	 */
//	public Map<String, Object> applyUserInfo(){
//		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("personId", "1239");
//		map.put("userId", "123123");
//		map.put("productId", applyId);
//		return map;
//	}
	
	
	
	/*
	 * ================================配置===================================
	 * 
	 */
	
	/**
	 * 增加key唯一配置
	 */
	public Map<String, Object> addConfig(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key", "zhlRepaymentDate");
		map.put("value", "1");
		map.put("order", "");
		map.put("group", "repayment");
		map.put("rsv1", "");
		map.put("rsv2", "");
		map.put("comment", "中互联还银行日期");
		return map;
	}
	
	/**
	 * 增加key可重配置
	 */
	public Map<String, Object> addConfigRepeat(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key", "60");
		map.put("value", "0.02");
		map.put("order", "");
		map.put("group", "interestRate");
		map.put("rsv1", "");
		map.put("rsv2", "");
		map.put("comment", "服务费");
		return map;
	}
	
	/**
	 * 修改配置
	 */
	public Map<String, Object> updateConfig(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key", "24");
		map.put("value", "0.01");
		map.put("order", "");
		map.put("group", "interestRate");
		map.put("rsv1", "1");
		map.put("rsv2", "");
		map.put("comment", "还款周期利率");
		return map;
	}
	
	/**
	 * 按唯一key查询
	 */
	public Map<String, Object> queryByKey(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key", "repaymentDay");
		map.put("group", "apply");
		return map;
	}
	
	/**
	 * 按可重key查询
	 */
	public Map<String, Object> queryByKeyRepeat(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key", "60");
		map.put("group", "interestRate");
		return map;
	}
	
	/**
	 * 按组查询
	 */
	public Map<String, Object> QueryGroup(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("group", "interestRate");
		return map;
	}
	
	
	
	

	/*
	 * =======================产品配置=======================
	 */
	
	/**
	 * 增加配置（后台管理）
	 */
	public Map<String, Object> addProductConfig(){
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("productName", "授信测试产品");
		map.put("applyAmount", 10000);
		map.put("zhlApplyAmount", 30000);
		map.put("interestRate1", 0.015);
		map.put("interestRate2", 0);
		map.put("interestRate3", 0);
		map.put("interestRate4", 0);
		map.put("interestRate5", 0);
		map.put("otherAmount", 0);
		map.put("overdueRate", 0.03);
		map.put("deposit", 0.10);
		return map;
	}
	
	/**
	 * 修改配置（后台管理）
	 */
	public Map<String, Object> updateProductConfig(){
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("productId", productId);
		map.put("productName", "产品1");
		map.put("applyAmount", 10000);
		map.put("zhlApplyAmount", 29800);
		map.put("interestRate1", 0.02);
		map.put("interestRate2", 0.03);
		map.put("interestRate3", 0.01);
		map.put("interestRate4", 0.01);
		map.put("interestRate5", 0.01);
		map.put("otherAmount", 5);
		map.put("overdueRate", 0.05);
		map.put("state", "01");
		return map;
	}
	
	/**
	 * 查询单个（后台管理）
	 */
	public Map<String, Object> productConfigQuery(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productId", productId);
		return map;
	}
	
	/**
	 * 查询list（后台管理）
	 */
	public Map<String, Object> productConfigQueryList(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageNumber", 0);
		map.put("productId", "");
		map.put("productName", "");
		map.put("state", "");
		map.put("type", "");
		return map;
	}
	
	/**
	 * 查询list（app）
	 */
	public Map<String, Object> productConfigList(){
		Map<String,Object> map = new HashMap<String,Object>();
		return map;
	}
	
	
	
	
	
	
	

	/*
	 * ===========================还款========================
	 */
	
	/**
	 * 根据修改的传参ajax生成利息、利率、每月还款额、每月利息、保证金金额信息————公用
	 */
	public Map<String, Object> repaymentCreate() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyId", applyId);
		map.put("amountParam", 100);
		map.put("repaymentPeriodsParam", 36);
		map.put("interestRateParam", 0.02);
		map.put("rmTypeParam", "01");
		map.put("deposit", 0.01);
		return map;
	}
	
	/**
	 * 中互联利息计算公用方法（根据本金、期数、还款方式、配置中的利率，计算利息、还款金额）————公用
	 */
	public Map<String, Object> zhlInterestCalculation() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyId", applyId);
		map.put("amountParam", 100);
		map.put("repaymentPeriodsParam", 36);
		map.put("interestRateParam", 0.02);
		map.put("rmTypeParam", "01");
		map.put("deposit", 0.01);
		return map;
	}
	
	/**
	 * 获取当前用户本月应还款总额
	 */
	public Map<String, Object> repaymentAmountQuery() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyId", applyId);
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 还款记录单个查询
	 */
	public Map<String, Object> repaymentQuery() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		return map;
	}

	/**
	 * 手动还款
	 */
	public Map<String, Object> repaymentOperate() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("personID", personId);
		map.put("applyId", applyId);
		// map.put("type", "01");
		map.put("transferAmount", "400");
		
		map.put("accType", "02");// 转账类型（01：个人对个人，02：银行卡对个人）
		map.put("outNo", outNo);// 个人to个人时是转出电子账户号，银行to个人时是转出银行卡
		map.put("payPass", "lx1111");
		map.put("msgCode", "");
		map.put("remark", "还款");
		map.put("inMobile", "13810577695");// 转入手机号
		
		
		return map;
	}
	
	/**
	 * 手动还款银行卡确认
	 */
	public Map<String, Object> repaymentOperateOk() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("personID", personId);
		map.put("applyId", applyId);
		map.put("transferAmount", "400");
		
		map.put("payPass", "lx1111");
		map.put("msgCode", "123123");
		
		
		return map;
	}
	
	/**
	 * 自动还款后，处理中的人工审核确认，改为已还款
	 */
	public Map<String, Object> repaymentConfirm() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 自动还款后，处理中的人工审核确认，改为已还款
	 */
	public Map<String, Object> repaymentFail() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("applyId", applyId);
		return map;
	}
	
	/**
	 * 定时任务——用户还款
	 */
	public Map<String, Object> quartzUserRepayment() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
	
	/**
	 * 定时任务开启下一期
	 */
	public Map<String, Object> quartzOpenNextRepayment() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
	
	/**
	 * 定时任务——中互联还款
	 */
	public Map<String, Object> quartzZhlRepayment() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
	
	/**
	 * 定时任务——此任务执行的是2期或以上所有已到期，但是没还款产生的逾期累加
	 */
	public Map<String, Object> quartzExpireOverdue() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
	
	/**
	 * 转账异步通知
	 */
	public Map<String, Object> accTransB2PNotify(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", "123123");
		return map;
	}
	
	/**
	 * app————重新申请授信（逻辑删除）
	 * @return
	 */
	public Map<String, Object> reApplyCredit(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId", applyId);
		map.put("userId", userId);
		return map;
	}

}
