package com.taru.bbs.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * 把对象转换为Json
 * @author WZW
 *
 */
public class JsonResultWriter {
	
	
	public static void writer(HttpServletResponse response,Object object) throws ServletException, IOException  {
		
		Gson gson=new Gson();
    	String json=gson.toJson(object);
    	
    	//4、响应数据的编码和类型
    	
    	response.setContentType("application/json");
    	//5、返回json数据，并关闭响应  response
    	response.getWriter().println(json);
    	response.getWriter().close();
	}
}
