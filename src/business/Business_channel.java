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
 * channel类，开发使用，可以删除
 * @author 刘熙
 *
 */
public class Business_channel {
	
	
	public Map<String, Object> bankInfoQuery(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cardNo", "6200509999999999");
		return map;
	}
	

}
