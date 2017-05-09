package business;

import java.util.HashMap;
import java.util.Map;

/**
 * dbank测试
 * @author 刘熙
 *
 */
public class Business_dbank {
	
	private String personID = "12391";
	
	/**
	 * 实名
	 */
	public Map<String, Object> getUserInfo(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personID", personID);
		map.put("isHide", "NO");
		return map;
	}
	

}
