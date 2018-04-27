package test.com.tmtc.util.HeepayShortPay;

import com.tmtc.utils.HeepayShortPay.Common.ThreeDES;
import com.tmtc.utils.HeepayShortPay.HeepayMain.*;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.ConfirmOpenAuthPayReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.ConfirmPayReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.SendOpenAuthPaySMSReturn;
import com.tmtc.utils.HeepayShortPay.HeepayReturn.SubmitOrderReturn;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015-11-14 14:23
 */
public class TestPay {
    @org.junit.Test
    public void test() {
        String szSrc = "123456";
        System.out.println("加密前的字符串:" + szSrc);
    }

    @org.junit.Test
    public void MainTest() throws Exception {
        // 添加新安全算法,如果用JCE就要把它添加进去
//		Security.addProvider(new com.sun.crypto.provider.SunJCE());

//		String szSrc = "123456";
//		System.out.println("加密前的字符串:" + szSrc);
//
//		byte[] encoded = ThreeDES.encryptMode("574A4702E0644DA29E827E05".getBytes(), szSrc.getBytes());
//		System.out.println("加密后的字符串:" + ThreeDES.byteArr2HexStr(encoded));
//
//		byte[] srcBytes = ThreeDES.decryptMode("574A4702E0644DA29E827E05".getBytes(), encoded);
//		System.out.println("解密后的字符串:" + (new String(srcBytes)));
//
//
//		String ssw=desEncrypt("123456","JUNNET_123456_123456_COM");


//		 boolean  is_banksQuery= HeepayQueryBanks.QueryBanks();


//		  /*测试数据begin*/
//		  submitOrderResult.set_hy_auth_uid("H1312270079069A0_d9e37e4639a6cd8573b1a93bb8b207f9");
//		  submitOrderResult.set_pre_auth_uid("pre-b0a0093880b14bf3965f40b3c29dd8c1");
//		  /*测试数据end*/
        //1.提交订单

        String agent_id = "27652";// 汇付宝分配给商户的ID
        String mobile = "13888888999";//银行卡注册手机
        String custom_page = "0";//在汇付宝进行支付 1 为自定义支付 该功能只提供给开通该协议的商户
        String display = "1";
        String return_url = "http://www.merchant.com/return_url";
        String notify_url = "http://www.merchant.com/notify_url";
        String agent_bill_id = "M32w5a1w9432100"; //商户不重复订单号
        String agent_bill_time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pay_amt = "0.01";
        String goods_name = "商品名称";
        String goods_num = "1";//商品数量
        String user_ip = "127.0.0.1";
        String ext_param1 = "";
        String ext_param2 = "";
        String auth_card_type = "1"; //0储蓄卡 1信用卡
        String user_identity = "";
        String hy_auth_uid = "";//如果商户保存用户的授权码 每次将授权码赋值，通提交订单后返回的授权码对比 一致 代表已经授权，直接调用确认支付
        String device_type = "0";
        String device_id = "";
        String goods_note = "";

        HeepaySubmitOrder submitOrderService = new HeepaySubmitOrder();
        //如果商户支付需要自定义并汇付宝授权过 调用下单的接口
        SubmitOrderReturn submitOrderReturn = HeepaySubmitOrder.SubmitOrder(
                agent_id, user_identity, hy_auth_uid, mobile,
                device_type, device_id, custom_page, display, return_url, notify_url,
                agent_bill_id, agent_bill_time, pay_amt, goods_name, goods_note,
                goods_num, user_ip, ext_param1, ext_param2, auth_card_type);
        //下单失败  结束
        if (false == submitOrderReturn.is_Success()) {
            //错误信息
            String errorMessage = submitOrderReturn.get_error_message();

            return;
        }
        //调用汇付宝支付页面的商户提交成功 根据返回的submitOrderReturn.get_redirect_url() 汇付宝地址进行跳转即可
        //结束本次交易
        //******************************************************************************************************


        //以下接口为自定义商户的接口 没有自定义支付对接协议的 直接使用跳转到汇付宝进行交易即可 不需要进行下面接口的开发
        if (submitOrderReturn.get_hy_auth_uid().equalsIgnoreCase(hy_auth_uid)) {
            //给用户发送短信
            boolean is_Send_Sms = HeepaySendPaySMS.SendPaySMS(agent_id, submitOrderReturn.get_hy_auth_uid(), submitOrderReturn.get_hy_token_id());
            if (!is_Send_Sms) return;
            //调用发送支付短信接口 获取验证码
            String hy_token_id = submitOrderReturn.get_hy_token_id();
            //用户收到短信填写的验证码
            String verify_code = "123456";
            //确认支付
            HeepayConfirmPay confirmPayService = new HeepayConfirmPay();
            ConfirmPayReturn confirmPayReturn = confirmPayService.ConfirmPay(agent_id, submitOrderReturn.get_hy_auth_uid(), submitOrderReturn.get_hy_token_id(), verify_code);
            if (confirmPayReturn.is_Success()) {
                //支付成功
            } else {
                //错误信息
                String errorMessage = confirmPayReturn.get_error_message();
                //支付失败
            }
        }
        //如果保存的授权码和返回的授权码submitOrderReturn.get_hy_auth_uid()相同 代表 已经签约
        //直接可以调用确认支付

        //自定义支付页面 并获取汇付宝授权的商户 才允许直接调用 发送授权支付验证短信与直接支付的接口
        //开始发送授权支付短信码  并返回授权码
        HeepaySendOpenAuthPaySMS sendOpenAuthPaySevice = new HeepaySendOpenAuthPaySMS();
        SendOpenAuthPaySMSReturn sendOpenAuthPaySMSReturn = sendOpenAuthPaySevice.SendOpenAuthPaySMS(submitOrderReturn);
        if (false == sendOpenAuthPaySMSReturn.is_success()) {
            //错误信息
            String errorMessage = sendOpenAuthPaySMSReturn.get_error_message();
            return;
        }
        //返回值判断是否已经授权
        //已经授权
        if (sendOpenAuthPaySMSReturn.is_has_bank_auth()) {
            //调用发送支付短信接口 获取验证码
            //给用户发送短信
            boolean is_Send_Sms = HeepaySendPaySMS.SendPaySMS(agent_id, submitOrderReturn.get_hy_auth_uid(), submitOrderReturn.get_hy_token_id());
            if (!is_Send_Sms) return;
            //确认支付
            String verify_code = "123456";
            HeepayConfirmPay confirmPayService = new HeepayConfirmPay();
            ConfirmPayReturn confirmPayReturn = confirmPayService.ConfirmPay(
                    agent_id,
                    sendOpenAuthPaySMSReturn.get_hy_auth_uid(),
                    sendOpenAuthPaySMSReturn.get_hy_token_id(),
                    verify_code);
            if (confirmPayReturn.is_Success()) {
                //支付成功
            } else {
                //错误信息
                String errorMessage = confirmPayReturn.get_error_message();
                //支付失败
            }
        } else {
            //之前未授权过
            //授权并支付
            HeepayConfirmOpenAuthPay confirmOpenAuthPayService = new HeepayConfirmOpenAuthPay();
            ConfirmOpenAuthPayReturn confirmOpenAuthPayRetrun = confirmOpenAuthPayService.ConfirmOpenAuthPay(sendOpenAuthPaySMSReturn);
            if (confirmOpenAuthPayRetrun.is_Success()) {
                //授权支付成功
            } else {
                //错误信息
                String errorMessage = confirmOpenAuthPayRetrun.get_error_message();
                //授权支付失败
            }
        }
    }

    public static String desEncrypt(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede");

        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return ThreeDES.byte2hex(cipher.doFinal(message.getBytes("UTF-8")));
    }


}

