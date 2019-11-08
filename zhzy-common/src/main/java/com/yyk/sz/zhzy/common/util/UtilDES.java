package com.yyk.sz.zhzy.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UtilDES {

    private static Logger logger = LoggerFactory.getLogger(UtilDES.class);

    /**
     * 使用DES解密指定字符串
     * @param encryptedValue 待解密字符串
     * @return 解密字符串
     */
    public static String Decrypt(String encryptedValue)
    {
        String key = "";
        String IV = "";
        //去掉干扰字符
        String tmp = encryptedValue;
        if (tmp.length() < 16)
        {
            return "";
        }

        for (int i = 0; i < 8; i++)
        {
            tmp = tmp.substring(0, 0 + i + 1) + tmp.substring(i + 2);
        }
        encryptedValue = tmp;

        //keyIV处理8字符
        key += "|123ab456";
        IV += "@123ab456";
        try
        {
            byte[] keyBytes = key.substring(0, 0+8).getBytes("UTF-8");
            byte[] IVBytes = IV.substring(0, 0+8).getBytes("UTF-8");
            byte[] base64DecodedBytes = Base64.getDecoder().decode(encryptedValue);

            IvParameterSpec ivParam = new IvParameterSpec(IVBytes);
            SecretKeySpec desKey = new SecretKeySpec(keyBytes, "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, desKey, ivParam);

            return new String(cipher.doFinal(base64DecodedBytes), "UTF-8");
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e)
        {
            logger.error(e.getCause()+"");
            return "解密失败";
        }

    }

}
