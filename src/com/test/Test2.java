package com.test;
import java.io.File;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.pub.util.file.HclientFileUtil;


public class Test2 {
	
	 public void SubmitPost(String url, String file36Path) {

	        HttpClient httpclient = new DefaultHttpClient();

	        try {

	            HttpPost httppost = new HttpPost(url);
	            File f = new File(file36Path);
	            FileBody file = new FileBody(f);

//	            MultipartEntity reqEntity = new MultipartEntity();
//	            reqEntity.addPart("desc",new StringBody("美丽的西双版纳", Charset.forName("utf-8")));
//	            reqEntity.addPart("file", file);// file36为请求后台的File upload;属性
//	            httppost.setEntity(reqEntity);
	            
	            
	            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//	            builder.addBinaryBody("file", f);
	            builder.addPart("file", file);
	            httppost.setEntity(builder.build());
	            
	            
	            HttpResponse response = httpclient.execute(httppost);
	            
	            int statusCode = response.getStatusLine().getStatusCode();

	            if (statusCode == HttpStatus.SC_OK) {

	                System.out.println("服务器正常响应.....");

	                HttpEntity resEntity = response.getEntity();

	                System.out.println(EntityUtils.toString(resEntity));// httpclient自带的工具类读取返回数据

	                System.out.println(resEntity.getContent());//这里是服务端的返回值

	                EntityUtils.consume(resEntity);
	            }

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	            try {
	                httpclient.getConnectionManager().shutdown();
	            } catch (Exception ignore) {

	            }
	        }
	    }

	    /**
	     * @param args
	     */
	    public static void main(String[] args) {
//	        // TODO Auto-generated method stub
//
	    	Test2 fileUploadClient = new Test2();
//
//	        fileUploadClient.SubmitPost(
//	                "http://127.0.0.1:9086/credit-site/service/file/upload",
//	                "d://test1.jpg");
	    	
	    	fileUploadClient.test2();
	    }
	    
	    public void test2(){
	    	
	    	try {
				System.out.println(HclientFileUtil.uploadFileMethod("userinfo", new File("d://test1.jpg")));
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }

}
