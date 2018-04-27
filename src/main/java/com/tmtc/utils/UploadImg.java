package com.tmtc.utils;

import com.tmtc.frame.ServiceException;
import com.tmtc.frame.ServiceExceptionEnum;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created:  hbwhypw
 * Date: 2015/10/19 15:37
 * Function:
 */
public class UploadImg {

    public static String[] upload(MultipartFile[] images, String filePath, boolean can) throws ServiceException {
        String monthStr = new SimpleDateFormat("yyyyMM").format(new Date());
        if (images == null || images.length <= 0) {
            return null;
        }
        String[] fileNames = new String[images.length];
        String[] shortFileUrl = new String[images.length];
        for (int i = 0; i < images.length; i++) {
            String fileName = images[i].getOriginalFilename();
            // 判断是否文件为空
            if (!"".equals(fileName)) {
                String contentType = images[i].getContentType();
                if ("image/png".equals(contentType) || "image/jpeg".equals(contentType)) {
                    fileNames[i] = String.valueOf(System.currentTimeMillis() + i);
                    if ("image/png".equals(contentType)) {
                        fileNames[i] += ".png";
                    } else if ("image/jpeg".equals(contentType)) {
                        fileNames[i] += ".jpg";
                    }
                    String local_file_url = filePath + "/" + monthStr + "/" + fileNames[i];
                    shortFileUrl[i] = monthStr + "/" + fileNames[i];
                    try {
                        images[i].transferTo(MakeQRCode.createFile(local_file_url));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new ServiceException(ServiceExceptionEnum.UPLOAD_NOT_IMAGE);
                }
            }
            if (null == shortFileUrl[0] || "null".equals(shortFileUrl[0])) {
            	shortFileUrl = null;
    		}
        }
        return shortFileUrl;
    }

    public static String upload(MultipartFile[] images, String filePath) throws ServiceException {
        return ConvertUtil.arrayToString(upload(images, filePath, true));
    }

    public static String upload(MultipartFile image, String filePath) throws ServiceException {
        if (image == null){
            return null;
        }
        String monthStr = new SimpleDateFormat("yyyyMM").format(new Date());
        String fileName = image.getOriginalFilename();
        String storeFileName = "";
        String shortFileUrl = "";
        if (!"".equals(fileName)) {
            String contentType = image.getContentType();
            if ("image/png".equals(contentType) || "image/jpeg".equals(contentType)) {
                storeFileName = String.valueOf(System.currentTimeMillis());
                if ("image/png".equals(contentType)) {
                    storeFileName += ".png";
                } else if ("image/jpeg".equals(contentType)) {
                    storeFileName += ".jpg";
                }
                String local_file_url = filePath + "/" + monthStr + "/" + storeFileName;

                try {
                    image.transferTo(MakeQRCode.createFile(local_file_url));
                    shortFileUrl = monthStr + "/" + storeFileName;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }  else {
                throw new ServiceException(ServiceExceptionEnum.UPLOAD_NOT_IMAGE);
            }
        }
        return shortFileUrl;
    }
}
