package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class Test4 {
	
	public static void main(String[] args) {
		try {
			getA272();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 自动产生RSA512位密钥(可以在512到2048之间)
	 * 
	 */
	public static void getA271() throws Exception {

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

		kpg.initialize(512);

		KeyPair kp = kpg.genKeyPair();

		PublicKey puk = kp.getPublic();

		PrivateKey prk = kp.getPrivate();

		System.out.println("公钥：" + puk);

		System.out.println("私钥：" + prk);

	}

	/**
	 * 
	 * 自动产生RSA1024位密钥；并保持到文件里
	 * 
	 */
	public static void getA272() throws Exception {

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

		kpg.initialize(517);
		KeyPair kp = kpg.genKeyPair();
		PublicKey puk = kp.getPublic();

		PrivateKey prk = kp.getPrivate();

		FileOutputStream pufos = new FileOutputStream("d:\\rsapublickey.txt");

		ObjectOutputStream puoos = new ObjectOutputStream(pufos);

		puoos.writeObject(puk);

		FileOutputStream prfos = new FileOutputStream("d:\\rsaprivatekey.txt");

		ObjectOutputStream proos = new ObjectOutputStream(prfos);

		proos.writeObject(prk);

	}

	/**
	 * 
	 * 使用非对称生成的公钥进行加密RSA512
	 * 
	 */
	public static void getA281() throws Exception {

		FileInputStream fis = new FileInputStream("d:\rsapublickey.txt");

		ObjectInputStream ois = new ObjectInputStream(fis);

		RSAPublicKey pbk = (RSAPublicKey) ois.readObject();

		BigInteger e = pbk.getPublicExponent();

		BigInteger n = pbk.getModulus();

		String mingwen = "hello world";// 明文

		byte[] ptext = mingwen.getBytes("UTF-8");

		BigInteger m = new BigInteger(ptext);

		BigInteger c = m.modPow(e, n);// 因为RSA算法要求整型数m的值必须小于n，所以需要计算

		// 保存密文

		String cs = c.toString();

		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("d:\rsapublickeyjiamihou.txt")));

		bw.write(cs);

		bw.flush();

	}

	/**
	 * 
	 * 使用非对称生成的公钥和私钥进行解密RSA512
	 * 
	 */
	public static void getA282() throws Exception {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("d:\rsapublickeyjiamihou.txt")));// 加密后文件

		String ctext = br.readLine();

		BigInteger c = new BigInteger(ctext);

		FileInputStream fis = new FileInputStream("d:\rsaprivatekey.txt");

		ObjectInputStream ois = new ObjectInputStream(fis);

		RSAPrivateKey prk = (RSAPrivateKey) ois.readObject();

		BigInteger d = prk.getPrivateExponent();

		BigInteger n = prk.getModulus();

		BigInteger m = c.modPow(d, n);
		byte[] mt = m.toByteArray();
		String s = "";
		for (int i = 0; i < mt.length; i++) {

			s += (char) mt[i];
		}
		System.out.println(s);

	}
}
