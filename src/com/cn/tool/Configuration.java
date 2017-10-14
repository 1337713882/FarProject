package com.cn.tool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private static Properties properties;
	private static String propertiesFilePath="db.properties";
	
	public static void setPropertiesFilePath(String propertiesFilePath) {
		Configuration.propertiesFilePath = propertiesFilePath;
	}
	
	 											
	static{	   //��ʾ�������е� Java Ӧ�ó����е���ͽӿڡ�	//���ظ�����������
		InputStream stream=Configuration.class.getClassLoader().getResourceAsStream(propertiesFilePath);   
		if(stream!=null){										//���Ҿ��и������Ƶ���Դ
			properties=new Properties();
			try {
				properties.load(stream); //  load��������ȡdb�ļ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void rebuilderProperties() throws FileNotFoundException {
		InputStream stream = Configuration.class.getClassLoader().getResourceAsStream(propertiesFilePath);
		if (stream != null) {
			properties = new Properties();
			try {
				properties.load(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new FileNotFoundException("�����ļ�·������ȷ");
		}
	}
	
	public static String getPropertiesValue(String key) throws FileNotFoundException{
		if(properties==null)
			rebuilderProperties();
		return properties.getProperty(key);
	}
}
