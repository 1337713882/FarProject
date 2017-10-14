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
	
	 											
	static{	   //表示正在运行的 Java 应用程序中的类和接口。	//返回该类的类加载器
		InputStream stream=Configuration.class.getClassLoader().getResourceAsStream(propertiesFilePath);   
		if(stream!=null){										//查找具有给定名称的资源
			properties=new Properties();
			try {
				properties.load(stream); //  load是用来读取db文件
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
			throw new FileNotFoundException("配置文件路径不正确");
		}
	}
	
	public static String getPropertiesValue(String key) throws FileNotFoundException{
		if(properties==null)
			rebuilderProperties();
		return properties.getProperty(key);
	}
}
