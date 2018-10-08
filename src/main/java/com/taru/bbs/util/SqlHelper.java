package com.taru.bbs.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class SqlHelper {

	static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	private static Properties properties=new Properties();
	static{
		try {
			properties.load(SqlHelper.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static{
		try {
			Class.forName(properties.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection openconnection(){
		Connection conn=tl.get();
		try {
			if(conn==null || conn.isClosed()){
				 conn=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("User"),properties.getProperty("Password"));
				tl.set(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return conn;
	}
	/*\
	 * 查询
	 */
	
	public static  List<HashMap<String ,Object>> select(String sql,Object ...ob){//主要是为了给sql中留的问号赋值，传的Object ..ob一个个赋给“？”然后程序返回查询的数据 是List类型。
		Connection conn=SqlHelper.openconnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<HashMap<String,Object>>list=new ArrayList<HashMap<String,Object>>();
		try {
			pst=conn.prepareStatement(sql);
			if(ob!=null){
				for(int i=0;i<ob.length;i++){
					pst.setObject(i+1,ob[i]);
				}
			}
			rs=pst.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();//获取列头元数据
			int length=rsm.getColumnCount();//获取长度
			while(rs.next()){
				HashMap<String,Object> map=new HashMap<String,Object>();
				for(int i=0;i<length;i++){
					String coo=rsm.getColumnLabel(i+1);
					map.put(camelName(coo), rs.getObject(coo));
				}
			list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询错误",e);
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	/*\
	 * 模糊搜索
	 * 
	 */
	
	public static List<HashMap<String ,Object>>select1(String sql,Object ...ob){
		Connection conn=SqlHelper.openconnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<HashMap<String,Object>>list=new ArrayList<HashMap<String,Object>>();
		try {
			pst=conn.prepareStatement(sql);
			if(ob!=null){
				for(int i=0;i<ob.length;i++){
					pst.setObject(i+1,"%"+ob[i]+"%");//要理解一点就是给占位符传的值最后都会以单引号的形式括起来传入Sql里的占位符
					//select * from user where username  like ?==select * from user where username  like '%卢%'；
				}
			}
			rs=pst.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();//获取列头元数据
			int length=rsm.getColumnCount();//获取长度
			while(rs.next()){
				HashMap<String,Object> map=new HashMap<String,Object>();
				for(int i=0;i<length;i++){
					String coo=rsm.getColumnLabel(i+1);
					//将数据库的属性名改成驼峰形式
					map.put(camelName(coo), rs.getObject(coo));
				}
			list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询错误",e);
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	/*
	 * 更新
	 */
	public static int update(String sql,Object ...praprate) {
		Connection conn=	SqlHelper.openconnection();
		PreparedStatement pst=null;
		int row=0;
		try {
			pst=conn.prepareStatement(sql);
			if(praprate!=null){
				for(int i=0;i<praprate.length;i++){
					pst.setObject(i+1, praprate[i]);
				}
				row=pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	return row;
	}
	public static void close(){
		Connection conn=tl.get();
		if(conn!=null){
			try {
				conn.close();
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	/**
	 * 将大写kebab-case改写成 PascalCase
	 * @param name
	 * @return
	 */
	public static String camelName(String name) {
	    StringBuilder result = new StringBuilder();
	    // 快速检查
	    if (name == null || name.isEmpty()) {
	        // 没必要转换
	        return "";
	    } else if (!name.contains("_")) {
	        // 不含下划线，仅将首字母小写
	        return name.substring(0, 1).toLowerCase() + name.substring(1);
	    }
	    // 用下划线将原始字符串分割
	    String camels[] = name.split("_");
	    for (String camel :  camels) {
	        // 跳过原始字符串中开头、结尾的下换线或双重下划线
	        if (camel.isEmpty()) {
	            continue;
	        }
	        // 处理真正的驼峰片段
	        if (result.length() == 0) {
	            // 第一个驼峰片段，全部字母都小写
	            result.append(camel.toLowerCase());
	        } else {
	            // 其他的驼峰片段，首字母大写
	            result.append(camel.substring(0, 1).toUpperCase());
	            result.append(camel.substring(1).toLowerCase());
	        }
	    }
	    return result.toString();
	}
	
}

