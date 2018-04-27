package test.RSA;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
 
import javax.crypto.Cipher;
 
/**
 * RSA安全编码组件
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public abstract class CRSACoder extends Coder {
	private static final String KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs6qbMxGf5DldGAlfkHH+9tUchPFZTey+OlMeE43qwZ4opy9YkpQW/zj9VZuUtenqPQsv5npMkweml4U+HhfSlZvp6W37rMfkPXH+kgfwGNGpiErhWrR60Wzn9WAlVIIwQ3nYR+dh8zJOOFdGyJHhO76eNBPYaQpBztmiSNVMp3HE36Z7zwudVAH5PHMY23wBcX2fPIFR1nG87dHqk3+U0ijMo4zg84L03yPi9YcOC97iTqO8il1lszB4nUNaBhfUQwzwn9Q4VcJ0gsKJSpvg4+uRQu1rhNnxE/sCkTm/YXo9SlFSgvLAlZDodF3pRJan0ucRBIQH/GhTSHBG3Kim4QIDAQAB";
    
    /**
     * 校验数字签名
     * 
     * @param data
     *            加密数据
     * @param publicKey
     *            公钥
     * @param sign
     *            数字签名
     * 
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     * 
     */
    public static boolean verify(byte[] data, String sign)
            throws Exception {
 
        // 解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(PUBLIC_KEY);
 
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
 
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
 
        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
 
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
 
        // 验证签名是否正常
        return signature.verify(decryptBASE64(sign));
    }
 
    /**
     * 解密<br>
     * 用公钥解密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(PUBLIC_KEY);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }
 
    /**
     * 加密<br>
     * 用公钥加密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data)
            throws Exception {
        // 对公钥解密
        byte[] keyBytes = decryptBASE64(PUBLIC_KEY);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }
}
