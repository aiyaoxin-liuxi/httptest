package pojo;

/**
 * 提交订单————乘客列表对象
 * @author 刘熙
 *
 */
public class Passenger {
	
	/**
	 * 票类型（成人票=1，儿童票=2）
	 */
	private String TicketType;
	
	/**
	 * 乘客姓名
	 */
	private String PassengerName;
	
	/**
	 * 证件类型(二代身份证：2)
	 */
	private String CertCardType;
	
	/**
	 * 证件号
	 */
	private String CertCardNo;
	
	/**
	 * 保险份数( 0 或 1，保险 1 份 20 元)
	 */
	private String InsuranceCount;

	/**
	 * 获取ticketType ticketType
	 */
	public String getTicketType() {
		return TicketType;
	}

	/**
	 * 设置ticketType ticketType
	 */
	public void setTicketType(String ticketType) {
		TicketType = ticketType;
	}

	/**
	 * 获取passengerName passengerName
	 */
	public String getPassengerName() {
		return PassengerName;
	}

	/**
	 * 设置passengerName passengerName
	 */
	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}

	/**
	 * 获取certCardType certCardType
	 */
	public String getCertCardType() {
		return CertCardType;
	}

	/**
	 * 设置certCardType certCardType
	 */
	public void setCertCardType(String certCardType) {
		CertCardType = certCardType;
	}

	/**
	 * 获取certCardNo certCardNo
	 */
	public String getCertCardNo() {
		return CertCardNo;
	}

	/**
	 * 设置certCardNo certCardNo
	 */
	public void setCertCardNo(String certCardNo) {
		CertCardNo = certCardNo;
	}

	/**
	 * 获取insuranceCount insuranceCount
	 */
	public String getInsuranceCount() {
		return InsuranceCount;
	}

	/**
	 * 设置insuranceCount insuranceCount
	 */
	public void setInsuranceCount(String insuranceCount) {
		InsuranceCount = insuranceCount;
	}


}
