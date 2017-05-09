package com.test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import notify.NotifyService;
import util.JsonUtil;
import business.Business_credit;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Business_credit bc = new Business_credit();
		String service = "";

//		// 添加授信订单————后台
//		map = bc.addApplyBack();
//		service = "applyCreditBack";
		// 批复订单
//		map = bc.updateApplyAgree();
//		service = "applyAgree";
		// 用户确认
//		map = bc.updateApplyUserConfirm();
//		service = "applyUserConfirm";
		// 用户取消
//		map = bc.updateApplyUserCancel();
//		service = "applyUserCancel";
		// 查询接口————后台
//		map = bc.queryConditions();
//		service = "applyQuery";
		// 查询详细信息————后台
//		map = bc.queryApplyDetail();
//		service = "applyDetail";
//		
		/*
		 * 	========================app 查询=========================
		 */
		// 根据applyId查询单个申请信息的详细信息
		
		// 根据applyId查询所有还款记录信息(分页)
//		map = bc.repaymentQueryPageList();
//		service = "repaymentQueryPageList";
		// 根据applyId查询目前该还的还款记录信息
		
		// 根据rmId查询还款记录详细信息
		
		
		// 选择还款周期、利率、签约
//		map = bc.instalmentsAndContract();
//		service = "applyInsertPeriods";
		// 放款（手动）
//		map = bc.applyLoan();
//		service = "applyLoan";
		// 放款（自动）
//		map = bc.applyLoanAuto();
//		service = "applyLoanAuto";
		
		/*
		 * 还款
		 */
		// 还款记录单个查询
//		map = bc.repaymentQuery();
//		service = "repaymentQuery";
		// 前台手动还款
//		map = bc.repaymentOperate();
//		service = "repaymentOperate";
		// 手动还款银行卡确认
//		map = bc.repaymentOperateOk();
//		service = "repaymentOperateOk";
		// 自动还款后，处理中的人工审核确认，改为已还款
//		map = bc.repaymentConfirm();
//		service = "repaymentConfirm";
		// 自动还款后，处理中的人工审核确认，改为失败，计入逾期
//		map = bc.repaymentFail();
//		service = "repaymentFail";
		
		
		// 定时任务——用户还款
//		map = bc.quartzUserRepayment();
//		service = "quartzUserRepayment";
		// 定时任务开启下一期
//		map = bc.quartzOpenNextRepayment();
//		service = "quartzOpenNextRepayment";
		// 定时任务——中互联还款
//		map = bc.quartzZhlRepayment();
//		service = "quartzZhlRepayment";
		// 定时任务——此任务执行的是2期或以上所有已到期，但是没还款产生的逾期累加
//		map = bc.quartzExpireOverdue();
//		service = "quartzExpireOverdue";
		
		
		
		/*
		 * 配置的接口
		 */
		// 配置写入唯一key
//		map = bc.addConfig();
//		service = "configInfoInsert";
		// 配置写入可重复key  
//		map = bc.addConfigRepeat();
//		service = "configInfoInsertRepeat";
		// 配置修改
//		map = bc.updateConfig();
//		service = "configInfoUpdate";
		// 按唯一KEY查询
//		map = bc.queryByKey();
//		service = "configQueryValue";
		// 按可重KEY查询
//		map = bc.queryByKeyRepeat();
//		service = "configInfoQueryValueRepeat";
		// 按组查询
//		map = bc.QueryGroup();
//		service = "configQueryGroup";
		
		
		// 产品配置
		// 写入————后台管理
//		map = bc.addProductConfig();
//		service = "productConfigInsert";
		// 修改————后台管理
//		map = bc.updateProductConfig();
//		service = "productConfigUpdate";
		// 查询单个————后台管理
//		map = bc.productConfigQuery();
//		service = "productConfigQuery";
		// 查询列表————后台管理
//		map = bc.productConfigQueryList();
//		service = "productConfigQueryList";
		// 删除————后台管理
		
		
		// 新流程
		// ==============================app=========================
		// 查询产品列表————app
//		map = bc.productConfigList();
//		service = "productConfigList";
		// 根据userId查询所有的申请表信息
//		map = bc.applyQueryList();
//		service = "applyQueryList";
		// 用户点击确认————app
//		map = bc.applyInit();
//		service = "applyInit";
		// 添加授信订单————app
//		map = bc.addApply();
//		service = "applyCredit";
		// 用户提交填写个人资料————app（暂时不用，放入添加授信订单）
//		map = bc.applyUserInfo();
//		service = "applyUserInfo";
		// 查询申请信息————app（根据产品id和用户id）
//		map = bc.applyQueryDetail();
//		service = "applyQueryDetail";
		// 后台放款后用户点击放款————app
//		map = bc.applyUserConfirmLoan();
//		service = "applyUserConfirmLoan";
		// 重新申请（逻辑删除）————app
//		map = bc.reApplyCredit();
//		service = "reApplyCredit";
		
		// 记录用户信息图片地址
//		map = bc.applyUserImgInsert();
//		service = "applyUserImgInsert";
		// 读取用户信息图片地址
//		map = bc.applyUserImgQuery();
//		service = "applyUserImgQuery";
		
		/*
		 * 用户还款
		 * 		用户手动————充值、转账
		 * 		定时自动————
		 */
		// 获取当前用户本月应还款总额————app
//		map = bc.repaymentAmountQuery();
//		service = "repaymentAmountQuery";
		// 根据applyId查询所有还款记录信息
//		map = bc.repaymentQueryList();
//		service = "repaymentQueryList";
		// 前台手动还款
//		map = bc.repaymentOperate();
//		service = "repaymentOperate";
		
		// =============================后台========================
		// 按条件查询列表接口————后台
//		map = bc.queryConditions();
//		service = "applyQuery";
		// 获取单个详细信息（后台审核时获取数据）————后台
//		map = bc.queryApplyDetail();
//		service = "applyDetail";
		// 审核提交————后台
//		map = bc.applyBackReview();
//		service = "applyBackReview";
		// 驳回订单
//		map = bc.updateApplyRejected();
//		service = "applyRejected";
		// 后台强行放款———后台
//		map = bc.applyBackLoan();
//		service = "applyBackLoan";
		// 查询所有还款记录信息(分页)————后台
//		map = bc.repaymentBackQueryPageList();
//		service = "repaymentBackQueryPageList";
		// 查询还款详细信息————后台
//		map = bc.repaymentQueryDetail();
//		service = "repaymentQueryDetail";
		
		
		
		
		// 查询用户已还款，但中互联还未还款成功的列表信息
//		map = bc.zhlBackRepaymentQueryList();
//		service = "zhlBackRepaymentQueryList";
		// 查询用户已还款，但中互联还为还款成功的详细信息
//		map = bc.zhlBackRepaymentQueryDetail();
//		service = "zhlBackRepaymentQueryDetail";
		// 中互联还银行进行审核，提供人工设置的审核
//		map = bc.zhlBackRepaymentReview();
//		service = "zhlBackRepaymentReview";
		// 驳回订单————后台管理
//		map = bc.updateApplyRejected();
//		service = "applyRejected";
		
		
		
		// 转账异步通知
//		map = bc.accTransB2PNotify();
//		service = "accTransB2PNotify";
		
		// ==============================公用==========================
		// 第一次计算用户利息只用于显示
//		map = bc.interestCalculation();
//		service = "interestCalculation";
		// 根据修改的传参ajax生成利息、利率、每月还款额、每月利息、保证金金额信息————公用
//		map = bc.repaymentCreate();
//		service = "repaymentCreate";
		// 中互联利息计算公用方法（根据本金、期数、还款方式、配置中的利率，计算利息、还款金额）————公用
//		map = bc.zhlInterestCalculation();
//		service = "zhlInterestCalculation";
		
		
		
		
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
		parameters.put("url", "http://127.0.0.1:8075/credit-site/service/"+service);
//		parameters.put("url", "http://218.240.148.249:8075/credit-site/service/"+service);
		parameters.put("ordersn", "111111111111111111111");
		parameters.put("uuid", "111111111111111111111111");
		parameters.put("parameters", map2);
		String ret = NotifyService.executeNotice(parameters);
		System.out.println("通知结果："+ret);
		
		
	}

}
