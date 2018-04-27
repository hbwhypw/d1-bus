package com.tmtc.utils;

import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Creater: hbwhypw
 * Date: 2015/8/21 10:30
 * Function:
 */
public class PasswordMasker {
    protected static final Logger logger = Logger.getLogger(PasswordMasker.class);

    public static String mask(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
            String text = (password == null) ? "" : password;
            digest.update(text.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] md5sum = digest.digest();
        BigInteger bigInt = new BigInteger(1, md5sum);
        return bigInt.toString(16);
    }

//    public static void main(String[] args) {
//        System.out.println(mask("lutouadmin"));
//    }
}
