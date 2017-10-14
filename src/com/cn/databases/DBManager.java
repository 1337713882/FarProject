package com.cn.databases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cn.tool.Configuration;


public class DBManager {
	//��������
	//������̬��(��̬������ص�ʱ�� ����)
	static {
		try {
			String driverClass=Configuration.getPropertiesValue("driver_class");
			Class.forName(driverClass);
		} catch (ClassNotFoundException| IOException e) {
			e.printStackTrace();
		} 	
	}
	/**
	 * ������ݿ����Ӷ���
	 * @return ���ݿ����Ӷ���
	 * @throws SQLException
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public static Connection openConnection() throws SQLException, FileNotFoundException{
		String url = Configuration.getPropertiesValue("url");
		String user = Configuration.getPropertiesValue("username");
		String passwrd = Configuration.getPropertiesValue("password");
		return DriverManager.getConnection(url,user,passwrd);
	}
	/**
	 * �ر����ݿ����Ӷ���
	 * @param conn ���ݿ����Ӷ���
	 * @throws SQLException
	 */
	public static void closeConnection(Connection conn) throws SQLException{
		if(conn!=null && !conn.isClosed()){
			conn.close();
			conn=null;
		}
	}
	
	
	public static int upData(Connection conn,String sql) throws SQLException{
		int count=0;
		Statement stm = conn.createStatement();
		count = stm.executeUpdate(sql);
	
		return count;
	}
	public static ResultSet query(Connection conn,String sql) throws SQLException{
		ResultSet rs=null;
		if(conn!=null && !conn.isClosed()){
			Statement stm=conn.createStatement();
			rs=stm.executeQuery(sql);
		}
		return rs;
	}
}
