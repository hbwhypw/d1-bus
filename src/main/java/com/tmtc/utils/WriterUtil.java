package com.tmtc.utils;

import java.io.FileWriter;
import java.io.IOException;

public class WriterUtil {

	private static final String fileUrl = "";
	
	private static final String head = "<html><head><meta name='viewport' content='width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'/></head><body>";
	private static final String fooder = "</body></html>";
	
	private static final String html = ".html";
	
	public static void writer(String str,String fileName){
		//此处设置为true即可追加
        FileWriter out;
		try {
			out = new FileWriter("D:\\1.html", true);
	        out.write(head);
	        out.write(str);
	        out.write(fooder);
	        out.flush();
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
