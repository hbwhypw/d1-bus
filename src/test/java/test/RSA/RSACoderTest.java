package test.RSA;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 
import java.util.Map;
 
/**
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public class RSACoderTest {
    private static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs6qbMxGf5DldGAlfkHH+9tUchPFZTey+OlMeE43qwZ4opy9YkpQW/zj9VZuUtenqPQsv5npMkweml4U+HhfSlZvp6W37rMfkPXH+kgfwGNGpiErhWrR60Wzn9WAlVIIwQ3nYR+dh8zJOOFdGyJHhO76eNBPYaQpBztmiSNVMp3HE36Z7zwudVAH5PHMY23wBcX2fPIFR1nG87dHqk3+U0ijMo4zg84L03yPi9YcOC97iTqO8il1lszB4nUNaBhfUQwzwn9Q4VcJ0gsKJSpvg4+uRQu1rhNnxE/sCkTm/YXo9SlFSgvLAlZDodF3pRJan0ucRBIQH/GhTSHBG3Kim4QIDAQAB";
    private static String privateKey  = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCzqpszEZ/kOV0YCV+Qcf721RyE8VlN7L46Ux4TjerBniinL1iSlBb/OP1Vm5S16eo9Cy/mekyTB6aXhT4eF9KVm+npbfusx+Q9cf6SB/AY0amISuFatHrRbOf1YCVUgjBDedhH52HzMk44V0bIkeE7vp40E9hpCkHO2aJI1UynccTfpnvPC51UAfk8cxjbfAFxfZ88gVHWcbzt0eqTf5TSKMyjjODzgvTfI+L1hw4L3uJOo7yKXWWzMHidQ1oGF9RDDPCf1DhVwnSCwolKm+Dj65FC7WuE2fET+wKROb9hej1KUVKC8sCVkOh0XelElqfS5xEEhAf8aFNIcEbcqKbhAgMBAAECggEAW48X5GCY8P9it7sfHkdZvYRBMmakMhfxoVt2OlTaS61D3l88bgZV6d6rC5Nrp4D7Q/yNfpDYsRz3AsR+MWvGf0OjYrgPx69eWwnax6SP8LX4BWLTkRvkcxFi7CMBIx3tZpWTaKE7w2nhfsjLY68j7wRnLvbmFDGL89Po5eD9XV68QgHWH82jQjE7Tef3Yulw5ffHe2N3rFFPt+Xr9f8sP0RDqCfseBgle7RPmLp+BCXoiJqXtylJK6MMIA7whjPEpUnNoXCcdFLH03k7vwJRXD+/3nZg1I6pdtWIQhulCJfdQv+Rv/e03o7M9+Rh5eXAVfBdoR5mneV1AwDMTT+wWQKBgQDf2aBZ/xxdw68lM/lZlVqSjxTwf/gcwr7SnOSmniA2vsg3FX7Nr+qmkqo6ShGEE5RIm/xwDJrF6agIC/YuPYJq9ztl4bzUmSa5wzvMwC+scZ57vAk6bXU4Derwi4+IeVjum497ybsSwnJ++kqKPHkvEIWRXGdRTdCuS6oKNiHKvwKBgQDNeHavkuwFU04r9XDkRkMhaOlSr0SckruzArbvpIcCeVmpxbUAbErExamaGRm4ZnxjSW7tTrwTWuCi8x2cso1DssH9cwhWCieWF2/uWMxSoJ7irMFWD5BGnil22hzEzUO9f5w6V9QaQOqpI1t8gnf25igDdHLu2YwUGPvGh84WXwKBgQCZr62y/D66dXZTYYqpoawMgWXL9OAgxugCa6tkZZ4SWAvYHc7wYv4EnR94Y5ABEPw2mbnIKC8/ADvYQnYjqyFWVSWXvlNJ11hKI6tz2OMiTuOTajcfwTTAZnXN7tN9zGptb6okQA1LROsdGLSCkiBVWs+JTFq27GkAsXwuBJpQuwKBgQDItuiZ0pglC5/NaVICbHCfbnCeiQApQ12AHSK/LqWEUS65nZyW8TKIzd5D3kk1zUetZcqqnsMy1Q+jnoJK1FES1MiT4Y8/HWRWRkbdOnk+LhGHtOKYQ1PY6B/xLlf0F+AYeVQP2kQj8U5KM3PnSTwPP/3Ogi7UDEe+SjmJUpiLWQKBgAKHZR/aU4GSI9rh8BaVFnCGpKZUrmbJa8pxqr+jidnFJrw3i2oHdBdR5kXtAiY5KdE1fZHdWO0CsYMyL+lpOH1ApV60LHq2xyTdMTKHjwLkTlnooYGSwlPlJQowBgz9PoInzHN0s7oT9cvjSBimYF8589RKEy4oEIqzwrdUz0Wo";
 
//    @Before
//    public void setUp() throws Exception {
//        Map<String, Object> keyMap = RSACoder.initKey();
// 
//        publicKey = RSACoder.getPublicKey(keyMap);
//        privateKey = RSACoder.getPrivateKey(keyMap);
//        System.err.println("公钥: \n\r" + publicKey);
//        System.err.println("私钥： \n\r" + privateKey);
//    }
 
    public static void main(String[] args) {
    	try {
			new RSACoderTest().test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @Test
    public void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String inputStr = "{\"money\":\"100\",\"timeKey\":\"1450251335389\",\"enc\":\"fe19b506104470ca1cb06c4a5bb73895\",\"card_no\":\"1234567890\"}";
        byte[] data = inputStr.getBytes();
        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);
        
        System.err.println(Coder.encryptBASE64(encodedData));
       
//    	byte[] base64 = Coder.decryptBASE64("fVZyMsIC/kafAxdwg8irq/W8VQm5PXfeuBRuvtciCB976SQ8JsjPziyoILtXDwPvthiwZnPxedUPVcgCKzldgbAFL9EoY2oCHD0r/bJLwNyTCH7uOuS9vk6YHz//B3HCMK1rE+sC2cpJtve0wP8PzIXoL5CJaSV+dF275BogAhbRVwYItY4qnLXnmysCE6jsXrFk+nu6Pe3q6Ru1w9QHDff94aXi9IXZTVLUbUPLJA19E6vGxjQWRW+7I+WHjdbaS1znrVWuaZh/BUA20rCzNheRSjPP8XjPiwfnAZUw4HpCH0SFqV6jNcJ4AAZ03IHU9UvlyHzxk+Ke0X6ZKXLamw==");
    	
//        BYTE[] DECODEDDATA = RSACODER.DECRYPTBYPRIVATEKEY(ENCODEDDATA,PRIVATEKEY);
//        STRING OUTPUTSTR = NEW STRING(DECODEDDATA);
//        STRING ENCRYPTBASE64 = CODER.ENCRYPTBASE64(ENCODEDDATA);
//        SYSTEM.ERR.PRINTLN(NEW STRING(ENCRYPTBASE64));
//        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
//        System.err.println(outputStr);
//        assertEquals(inputStr, outputStr);
 
    }
 
    @Test
    public void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String inputStr = "sign";
        byte[] data = inputStr.getBytes();
        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);
        byte[] decodedData = RSACoder.decryptByPublicKey(encodedData, publicKey);
 
        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        assertEquals(inputStr, outputStr);
 
        System.err.println("私钥签名——公钥验证签名");
        // 产生签名
        String sign = RSACoder.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);
 
        // 验证签名
        boolean status = RSACoder.verify(encodedData, publicKey, sign);
        System.err.println("状态:\r" + status);
        assertTrue(status);
 
    }
    
}
