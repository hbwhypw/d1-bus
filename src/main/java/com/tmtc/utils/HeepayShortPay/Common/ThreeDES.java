package com.tmtc.utils.HeepayShortPay.Common;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ThreeDES {
	private static final String Algorithm = "DESede";

	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		// Security.addProvider(new com.sun.crypto.provider.SunJCE());
		// int addProvider = Security.addProvider(new
		// com.sun.crypto.provider.SunJCE());
		try {
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// System.out.print(deskey);
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// keybyteΪ������Կ������Ϊ24�ֽ�
	// srcΪ���ܺ�Ļ�����
	public static byte[] decryptMode(byte[] keybyte, byte[] src) {
		// Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			// ������Կ
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// ����
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// ת����ʮ�������ַ���
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}

	public static String byteArr2HexStr(byte[] arrB) {
		int iLen = arrB.length;
		// ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// �Ѹ���ת��Ϊ����
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// С��0F������Ҫ��ǰ�油0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		// ���128λ
		String result = sb.toString();
		return result;
	}

	public static void main(String[] args) throws Exception {
		// Security.addProvider(new com.sun.crypto.provider.SunJCE());
		// Security.addProvider(new com.sun.crypto.provider.SunJCE());

		String szSrc = "123456";

		byte[] encoded = encryptMode("JUNNET_123456_123456_COM".getBytes(), szSrc.getBytes());

		byte[] srcBytes = decryptMode("JUNNET_123456_123456_COM".getBytes(), encoded);
	}

}
