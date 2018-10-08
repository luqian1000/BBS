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
	 * ��ѯ
	 */
	
	public static  List<HashMap<String ,Object>> select(String sql,Object ...ob){//��Ҫ��Ϊ�˸�sql�������ʺŸ�ֵ������Object ..obһ��������������Ȼ����򷵻ز�ѯ������ ��List���͡�
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
			ResultSetMetaData rsm=rs.getMetaData();//��ȡ��ͷԪ����
			int length=rsm.getColumnCount();//��ȡ����
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
			throw new RuntimeException("��ѯ����",e);
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
	 * ģ������
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
					pst.setObject(i+1,"%"+ob[i]+"%");//Ҫ���һ����Ǹ�ռλ������ֵ��󶼻��Ե����ŵ���ʽ����������Sql���ռλ��
					//select * from user where username  like ?==select * from user where username  like '%¬%'��
				}
			}
			rs=pst.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();//��ȡ��ͷԪ����
			int length=rsm.getColumnCount();//��ȡ����
			while(rs.next()){
				HashMap<String,Object> map=new HashMap<String,Object>();
				for(int i=0;i<length;i++){
					String coo=rsm.getColumnLabel(i+1);
					//�����ݿ���������ĳ��շ���ʽ
					map.put(camelName(coo), rs.getObject(coo));
				}
			list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����",e);
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
	 * ����
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
	 * ����дkebab-case��д�� PascalCase
	 * @param name
	 * @return
	 */
	public static String camelName(String name) {
	    StringBuilder result = new StringBuilder();
	    // ���ټ��
	    if (name == null || name.isEmpty()) {
	        // û��Ҫת��
	        return "";
	    } else if (!name.contains("_")) {
	        // �����»��ߣ���������ĸСд
	        return name.substring(0, 1).toLowerCase() + name.substring(1);
	    }
	    // ���»��߽�ԭʼ�ַ����ָ�
	    String camels[] = name.split("_");
	    for (String camel :  camels) {
	        // ����ԭʼ�ַ����п�ͷ����β���»��߻�˫���»���
	        if (camel.isEmpty()) {
	            continue;
	        }
	        // �����������շ�Ƭ��
	        if (result.length() == 0) {
	            // ��һ���շ�Ƭ�Σ�ȫ����ĸ��Сд
	            result.append(camel.toLowerCase());
	        } else {
	            // �������շ�Ƭ�Σ�����ĸ��д
	            result.append(camel.substring(0, 1).toUpperCase());
	            result.append(camel.substring(1).toLowerCase());
	        }
	    }
	    return result.toString();
	}
	
}

