package test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test1 {

	private static Long id;
	private static Properties prop;
	private static FileOutputStream oFile = null;
	private static final String fileUrl = "src/main/resources/system.properties";
	private static final String ticket = "ticket";
	private static final String loginUrl = "loginUrl";
	private static final String defaultPwd = "defaultPwd";
	private static final String ignore = "ignore";

	static {
		FileInputStream fileInputStream = null;
		InputStream in = null;
		prop = new Properties();
		try {
			fileInputStream = new FileInputStream(fileUrl);
			in = new BufferedInputStream(fileInputStream);
			prop.load(in);
			id = Long.parseLong(prop.getProperty("id"));
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in = null;
		}
	}

	/**
	 * 得到配置文件对象
	 * @return
	 */
	public static Properties getProperties() {
		return prop;
	}

	/**
	 * 得到id
	 * @return
	 */
	public synchronized static long getID() {
		try {
			oFile = new FileOutputStream(fileUrl);
			prop.setProperty("id", String.valueOf(++id));
			prop.store(oFile, null);
			oFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			oFile = null;
		}
		return id;
	}

	/**
	 * 得到loginUrl
	 * @return
	 */
	public static String getLoginUrl(){
		return getProperties().getProperty(loginUrl);
	}
	
	/**
	 * 得到ticket
	 * @return
	 */
	public static String getTicket(){
		return getProperties().getProperty(ticket);
	}
	
	/**
	 * 得到DefaultPwd
	 * @return
	 */
	public static String getDefaultPwd(){
		return getProperties().getProperty(defaultPwd);
	}
	
	/**
	 * 得到DefaultPwd
	 * @return
	 * 
	 */
	public static String[] getIgnore(){
		return getProperties().getProperty(ignore).split(",");
	}
	
	
	public static void main(String[] args) {
		System.out.println(0.1+0.2);
	}
	
}

