package com.tmtc.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.UUID;

import com.tmtc.utils.secret.Base64;

public class StringUtility {

	public static String replace(String strSource, String strFrom, String strTo) {
		if (strSource == null) { 
			return null;
		}
		int i = 0;
		if ((i = strSource.indexOf(strFrom, i)) >= 0) {
			char[] cSrc = strSource.toCharArray();
			char[] cTo = strTo.toCharArray();
			int len = strFrom.length();
			StringBuffer buf = new StringBuffer(cSrc.length);
			buf.append(cSrc, 0, i).append(cTo);
			i += len;
			int j = i;
			while ((i = strSource.indexOf(strFrom, i)) > 0) {
				buf.append(cSrc, j, i - j).append(cTo);
				i += len;
				j = i;
			}
			buf.append(cSrc, j, cSrc.length - j);
			return buf.toString(); 
	    } 
	    return strSource;
	}
	
	/**
	 * 将url转成utf-8格式
	 * @param source
	 * @return
	 */
	public static String urlEncode (String source) {
		return urlEncode(source, "utf-8");
	}
	
	public static String urlEncode (String source, String enc) {
		if (source == null || enc == null) {
			return source;
		}
		String encode = null;
		try {
			encode = URLEncoder.encode(source, enc);
			encode = replace(encode, "+", "%20");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			
		}
		return encode;
	}
	
	public static String urlDecode (String source) {
		return urlDecode(source, "utf-8");
	}
	
	public static String urlDecode (String source, String enc) {
		String decode = null;
		try {
			decode = URLDecoder.decode(source, enc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			
		}
		return decode;
	}
	
	/**
	 * 检查是否包含某个子项，如果父串为 null/""/"all" 都认为是全部
	 * */
	public static boolean containElementIgnoreCase (String parent, Object sub) {
		if (sub == null || sub.toString() == null) {
			return false;
		}
		if (parent == null || parent.equals("") || parent.equalsIgnoreCase("all")) {
			return true;
		}
		
		return ( "," + parent.toLowerCase() + ",")
				.indexOf("," + sub.toString().toLowerCase() + ",") > -1;
	}
	
	/**
	 * 全角半角转换
	 * */
	public static String qj2bj(String src) {
        if (src == null) {  
            return src;  
        }
        
		//char DBC_CHAR_START = 33; // 半角!
		
	    /**
	     * ASCII表中可见字符到~结束，偏移位值为126(Decimal)
	     */
		//char DBC_CHAR_END = 126; // 半角~
		
	    /**
	     * 全角对应于ASCII表的可见字符从！开始，偏移值为65281
	     */
		char SBC_CHAR_START = 65281; // 全角！ 
		  
	    /**
	     * 全角对应于ASCII表的可见字符到～结束，偏移值为65374 
	     */ 
		char SBC_CHAR_END = 65374; // 全角～
		  
	    /** 
	     * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
	     */
		int CONVERT_STEP = 65248; // 全角半角转换间隔
		
	    /** 
	     * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理 
	     */
		char SBC_SPACE = 12288; // 全角空格 12288
		
	    /** 
	     * 半角空格的值，在ASCII中为32(Decimal) 
	     */
		char DBC_SPACE = ' '; // 半角空格 

        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (int i = 0; i < src.length(); i++) {
            if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) { // 如果位于全角！到全角～区间内  
                buf.append((char) (ca[i] - CONVERT_STEP));
            } else if (ca[i] == SBC_SPACE) { // 如果是全角空格
                buf.append(DBC_SPACE);
            } else { // 不处理全角空格，全角！到全角～区间外的字符
                buf.append(ca[i]);
            }
        }
        return buf.toString();  
	}

	/**
	 * 字符串为空或者all的话对应{0}
	 * */
	public static ArrayList<Integer> toIntArray (String input) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		if (input == null || input.equalsIgnoreCase("all")) {
			array.add(0);
		} else {
			String[] ids = input.split(",");
			for (String string : ids) {
				array.add(Parser.getInt(string, 0));
			}
		}
		return array;
	}
	
	public static String objectToString (Serializable obj) {
		ByteArrayOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
        	os = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(obj);
            return Base64.encode(os.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {oos.close(); oos = null;}
				if (os != null) {os.close(); os = null;}
			} catch (IOException e2) {
				
			}
		}
        return null;
	}
	
	public static Object stringToObject (String str) {
		InputStream is = null;
		ObjectInputStream ois = null;
        try {
        	is = new ByteArrayInputStream(Base64.decode(str));
	        ois = new ObjectInputStream(is);
	        return ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {ois.close(); ois = null;}
				if (is != null) {is.close(); is = null;}
			} catch (IOException e2) {
				
			}
		}
	    return null;
	}
	
	public static String byte2HexString(byte[] b) {
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7',
                      '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] newChar = new char[b.length * 2];
        for(int i = 0; i < b.length; i++) {
            newChar[2 * i] = hex[(b[i] & 0xf0) >> 4];
            newChar[2 * i + 1] = hex[b[i] & 0xf];
        }
        return new String(newChar);
    }
	
	public static String exceptionToString (Exception e) {
		ByteArrayOutputStream baos = null;
		PrintStream ps = null;
		try {
			baos = new ByteArrayOutputStream();
			ps = new PrintStream(baos);
			e.printStackTrace(ps);
			return baos.toString();
		} finally {
			try {
				if (baos != null) {baos.close(); baos = null;}
				if (ps != null) {ps.close(); ps = null;}
			} catch (IOException exp) {
				exp.printStackTrace();
			}
		}
	}
	
	public static String UUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String uniqueFuncId (Object...objects) {
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
		StringBuilder sb = new StringBuilder();
		sb.append(traceElement.getFileName())
			.append(".")
			.append(traceElement.getMethodName())
			.append("(");
		for (Object object : objects) {
			sb.append(object==null? " ": object);
			sb.append(",");
		}
		if (objects.length > 0) {
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append(")");
		return sb.toString();
	}
	
	public StringUtility() {

	}

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
////		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
////		System.out.println(StringUtility.replace("123+123+123", "+", "1"));
//// 159114739349499437878318329027970656231
//		
////		long long1 = Long.parseLong(UUID(), 16);
////		System.out.println(long1);
//		String uuid = "b";
//		BigInteger bi = new BigInteger(uuid,16);
//		System.out.println(bi);
//		System.out.println(Long.MAX_VALUE);
//	}

}
