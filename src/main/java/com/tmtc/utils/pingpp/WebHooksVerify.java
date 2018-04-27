package com.tmtc.utils.pingpp;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import java.io.FileInputStream;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

/**
 * Function:
 *
 * @auther: hbwhypw
 * Date: 2016-01-13 15:09
 */
public class WebHooksVerify {
    private static String filePath = "my-server.pub";
//    private String eventPath = "charge";
//    private String signPath = "sign";

    /**
     * 根据 类路径 获取 文件绝对路径
     * @param classpath 类路径
     * @return 文件绝对路径
     */
    public static String getFilePath(String classpath){
        return WebHooksVerifyExample.class.getClassLoader().getResource(classpath).getPath();
    }
    /**
     * 读取文件,部署web程序的时候，签名和验签内容需要从request中获得
     * @param file
     * @param base64
     * @return
     * @throws Exception
     */
    public static byte[] getByteFromFile(String file, boolean base64) throws Exception {
        FileInputStream in = new FileInputStream(getFilePath(file));
        byte[] fileBytes = new byte[in.available()];
        in.read(fileBytes);
        in.close();
        String pubKey = new String(fileBytes, "UTF-8");
        if (base64) {
            fileBytes = Base64.decodeBase64(pubKey);
        }
        return fileBytes;
    }

    public static byte[] getByteFromString(String str, boolean base64) throws Exception {
        byte[] fileBytes = str.getBytes();
        String pubKey = new String(fileBytes, "UTF-8");
        if (base64) {
            fileBytes = Base64.decodeBase64(pubKey);
        }
        return fileBytes;
    }

    /**
     * 获得公钥
     * @return
     * @throws Exception
     */
    public static PublicKey getPubKey() throws Exception {
        // read key bytes
        FileInputStream in = new FileInputStream(getFilePath(filePath));
        byte[] keyBytes = new byte[in.available()];
        in.read(keyBytes);
        in.close();

        String pubKey = new String(keyBytes, "UTF-8");
        pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

        keyBytes = Base64.decodeBase64(pubKey);

        // generate public key
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(spec);
        return publicKey;
    }

    /**
     * 验证签名
     * @param data
     * @param signBytes
     * @param publicKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static boolean verifyData(byte[] data, byte[] signBytes, PublicKey publicKey)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(signBytes);
    }

    public static void main(String[] args) throws Exception {
        String msg = "SHA256withRSA";
        String substring = StringUtils.substring(msg, 0, 20);
//        System.out.println(substring);
//        boolean result = verifyData(getByteFromFile(eventPath, false), getByteFromFile(signPath, true), getPubKey());
//        System.out.println("验签结果："+result);
    }
}
