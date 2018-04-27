package com.tmtc.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传图片
 * 
 * @author Administrator
 *
 */
public class UploadImage {

	private String[] uploadFileNames;
	private String[] shortFileUrl;

	private static UploadImage ui = new UploadImage();

	private UploadImage() {
	}

	public static UploadImage getUploadImage() {
		return ui;
	}

	public String[] getUploadFileNames() {
		return uploadFileNames;
	}

	public String getFileUrlToString() {
		return ConvertUtil.arrayToString(uploadFileNames);
	}

	public UploadImage upload(MultipartFile[] image,String filePath) {
		String monthStr = new SimpleDateFormat("yyyyMM").format(new Date());
		if (null == image || 0 >= image.length) {
			return this;
		}
		uploadFileNames = new String[image.length];
		shortFileUrl = new String[image.length];
		for (int i = 0; i < image.length; i++) {
			String fileName = image[i].getOriginalFilename();
			// 判断是否文件为空
			if (!"".equals(fileName)) {
				String contentType = image[i].getContentType();
				if ("image/png".equals(contentType) || "image/jpeg".equals(contentType)) {
					uploadFileNames[i] = String.valueOf(System.currentTimeMillis() + i);
					if ("image/png".equals(contentType)) {
						uploadFileNames[i] += ".png";
					} else if ("image/jpeg".equals(contentType)) {
						uploadFileNames[i] += ".jpg";
					}
					try {
						String local_file_url = filePath + File.separator + monthStr + File.separator + uploadFileNames[i];
						shortFileUrl[i] = monthStr + File.separator + uploadFileNames[i];
						image[i].transferTo(MakeQRCode.createFile(local_file_url));
					} catch (Exception e) {
						e.printStackTrace();
						return this;
					}
				}
			}
		}
		if (null == uploadFileNames[0] || "null".equals(uploadFileNames[0])) {
			uploadFileNames = null;
		}
		return this;
	}

	public UploadImage upload(MultipartFile image,String filePath) {
		return this;
	}
}
