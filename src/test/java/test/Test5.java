package test;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class Test5 {

	private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDBYfxP506fBObSQctZ5TyLeiB8UM4n/TUiBCacKIWvQUk3QTe47VHPDCI5V/pZVjsXETE9dBOTGyQSLRFkWlHCVxtP6YjJtQbpI3JgjlJSylfl+L/+Tn7SdPUrUsCTrvr0g5OGy4YOgrsVlvljQ4Bf0io+y1Z9GU43Lj/ih4T1wIDAQAB";
	private static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIMFh/E/nTp8E5tJBy1nlPIt6IHxQzif9NSIEJpwoha9BSTdBN7jtUc8MIjlX+llWOxcRMT10E5MbJBItEWRaUcJXG0/piMm1BukjcmCOUlLKV+X4v/5OftJ09StSwJOu+vSDk4bLhg6CuxWW+WNDgF/SKj7LVn0ZTjcuP+KHhPXAgMBAAECgYBp8xsPFyYJmTQxqkhHiy+C92TBT1vQemj9RFpIyTQJtyhluuSpaPG6fQ2yZem9Ttstpx9lNnIQHvTbaC9+4iuCvYL8e0eAII4H4VtITOK3Zory0XBBws99z1XnQmaD01uu0og0Srug3zZC2AaCMRfLmfiGRJRD1L24F6co4ubcwQJBANnKZj1W2UPRtwk+pH7cgvHZNjNGj+7hh40efoIDXoJMbLMlXpV9cefREzQdy4g4zaBEA4nGxNxJkXzlIDQy32kCQQCaAhYqgAC2mLLJjR9K/p3EImF7yGs70tr2SjiV1VGhqJVKvMVO7mfH4hOmUpxyHBK5nBe1jqeZmRbvJONJZjE/AkA5n6/FcwExTH+dVpG3byjGTK5mirjyf4GZ+QOH6tRKrWXlUHHiI7rLlyn5lBiSBlWBnf1BqvHTRzPTU9xdc0hhAkEAgyhFwloSwW7XzEhQHykqKO/yv11W3bLb4SYifJAYHimZQvXyvx7P6W2CuIHgVFnOJJ5nnqpn16qF2pI6srbCNwJBAMBEodSgSBUiks9k7CEqwiPCFcj6HDgwWuiIVzxkXVoC0VKopmtN11tf4el+O5LIr6vTzb894UBVeInYMwN1NeM=";

	public static void main(String[] args) {
		// String publicKey =
		// "aced0005737200146a6176612e73656375726974792e4b6579526570bdf94fb3889aa5430200044c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b0007656e636f6465647400025b424c0006666f726d617471007e00014c00047479706574001b4c6a6176612f73656375726974792f4b657952657024547970653b7870740003525341757200025b42acf317f8060854e002000078700000005e305c300d06092a864886f70d0101010500034b0030480241009abcfd9c99adf077718ef0ffb9c3495b638e0689b0f0239b8bcac763f88a3234d8e2a984bf3df2c20a835aa5370a265244e641e4832772582b5cc5357b79db710203010001740005582e3530397e7200196a6176612e73656375726974792e4b6579526570245479706500000000000000001200007872000e6a6176612e6c616e672e456e756d000000000000000012000078707400065055424c4943";
		// String privateKey =
		// "aced0005737200146a6176612e73656375726974792e4b6579526570bdf94fb3889aa5430200044c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b0007656e636f6465647400025b424c0006666f726d617471007e00014c00047479706574001b4c6a6176612f73656375726974792f4b657952657024547970653b7870740003525341757200025b42acf317f8060854e002000078700000005e305c300d06092a864886f70d0101010500034b0030480241009abcfd9c99adf077718ef0ffb9c3495b638e0689b0f0239b8bcac763f88a3234d8e2a984bf3df2c20a835aa5370a265244e641e4832772582b5cc5357b79db710203010001740005582e3530397e7200196a6176612e73656375726974792e4b6579526570245479706500000000000000001200007872000e6a6176612e6c616e672e456e756d000000000000000012000078707400065055424c4943";
		// System.out.println(publicKey.length());

		// byte[] decode = Base64.decode(publicKey);
//		new KeyGenerater();
		try {
			String string = new String(Signaturer.sign(Base64.encodeToByte(publicKey.getBytes()), "123"));
			System.out.println(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class KeyGenerater {
	private byte[] priKey;
	private byte[] pubKey;

	public KeyGenerater() {
		try {
			java.security.KeyPairGenerator keygen = java.security.KeyPairGenerator.getInstance("RSA");
			SecureRandom secrand = new SecureRandom();
			secrand.setSeed("qiukai".getBytes()); // 初始化随机产生器
			keygen.initialize(1024, secrand);
			KeyPair keys = keygen.genKeyPair();

			PublicKey pubkey = keys.getPublic();
			PrivateKey prikey = keys.getPrivate();

			pubKey = Base64.encodeToByte(pubkey.getEncoded());
			priKey = Base64.encodeToByte(prikey.getEncoded());

			System.out.println("pubKey = " + new String(pubKey));
			System.out.println("priKey = " + new String(priKey));
		} catch (java.lang.Exception e) {
			System.out.println("生成密钥对失败");
			e.printStackTrace();
		}
	}

	public byte[] getPriKey() {
		return priKey;
	}

	public byte[] getPubKey() {
		return pubKey;
	}
}

class Signaturer {
	/**
	 * 
	 * Description:数字签名
	 * 
	 * @param priKeyText
	 * @param plainText
	 * @return
	 * @author 孙钰佳 @since：2007-12-27 上午10:51:48
	 */
	public static byte[] sign(byte[] priKeyText, String plainText) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(priKeyText));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey prikey = keyf.generatePrivate(priPKCS8);
			// 用私钥对信息生成数字签名
			java.security.Signature signet = java.security.Signature.getInstance("MD5withRSA");
			signet.initSign(prikey);
			signet.update(plainText.getBytes("GBK"));
			byte[] signed = Base64.encodeToByte(signet.sign());
			return signed;
		} catch (java.lang.Exception e) {
			System.out.println("签名失败");
			e.printStackTrace();
		}
		return null;
	}
}

class SignProvider {

	/**
	 * 
	 * Description:校验数字签名,此方法不会抛出任务异常,成功返回true,失败返回false,要求全部参数不能为空
	 * 
	 * @param pubKeyText
	 *            公钥,base64编码
	 * @param plainText
	 *            明文
	 * @param signTest
	 *            数字签名的密文,base64编码
	 * @return 校验成功返回true 失败返回false
	 * @author 孙钰佳 @since：2007-12-27 上午09:33:55
	 */
	public static boolean verify(byte[] pubKeyText, String plainText, byte[] signText) {
		try {
			// 解密由base64编码的公钥,并构造X509EncodedKeySpec对象
			java.security.spec.X509EncodedKeySpec bobPubKeySpec = new java.security.spec.X509EncodedKeySpec(
					Base64.decode(pubKeyText));
			// RSA对称加密算法
			java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance("RSA");
			// 取公钥匙对象
			java.security.PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);
			// 解密由base64编码的数字签名
			byte[] signed = Base64.decode(signText);
			java.security.Signature signatureChecker = java.security.Signature.getInstance("MD5withRSA");
			signatureChecker.initVerify(pubKey);
			signatureChecker.update(plainText.getBytes());
			// 验证签名是否正常
			if (signatureChecker.verify(signed))
				return true;
			else
				return false;
		} catch (Throwable e) {
			System.out.println("校验签名失败");
			e.printStackTrace();
			return false;
		}
	}
}
