package com.cn.text;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.databases.DBManager;

public class Demo {

	public static void main(String[] args) throws SQLException, FileNotFoundException{
		Connection conn = DBManager.openConnection();
	//	String sql = "insert into student values (7,'Â¹êÏ','ÄÐ')";
	//	int count = DBManager.upData(conn, sql);
	//	System.out.println(count>0? "²Ù×÷³É¹¦":"²Ù×÷Ê§°Ü");
	//	DBManager.closeConnection(conn);
		
		String sql = "select * from student";
		ResultSet rs = DBManager.query(conn, sql);
		while(rs.next()){
			System.out.println(rs.getInt("stuID")+"--"+rs.getString("stuName")+"--"+rs.getString("stuSex"));		
		}
		conn.close();
 	}

}
