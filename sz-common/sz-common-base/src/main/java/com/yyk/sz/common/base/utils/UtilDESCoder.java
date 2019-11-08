package com.yyk.sz.common.base.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.InputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilDESCoder {
	public static final String ALGORITHM = "DES";
	/**
	 * 转换密钥<br>
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(dks);

		// 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码
		// SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);

		return secretKey;
	}

	/**
	 * 解密内部实现
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String key) throws Exception {
		Key k = toKey((new BASE64Decoder()).decodeBuffer(key));

		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);

		return cipher.doFinal(data);
	}

	/**
	 * 加密内部实现
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String key) throws Exception {
		Key k = toKey((new BASE64Decoder()).decodeBuffer(key));
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);

		return cipher.doFinal(data);
	}

	/**
	 * 生成密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String initKey() throws Exception {
		return initKey(null);
	}

	/**
	 * 根据密钥原文生成密钥
	 * 
	 * @param seed
	 * @return
	 * @throws Exception
	 */
	public static String initKey(String seed) throws Exception {
		SecureRandom secureRandom = null;

		if (seed != null) {
			secureRandom = new SecureRandom((new BASE64Decoder()).decodeBuffer(seed));
		} else {
			secureRandom = new SecureRandom();
		}

		KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
		kg.init(secureRandom);

		SecretKey secretKey = kg.generateKey();

		return (new BASE64Encoder()).encodeBuffer(secretKey.getEncoded());
	}
	
	/**
	 * 加密封装后的可调用方法
	 * @param inputStr
	 * @return
	 * @throws Exception
	 */
	public static String encryptFunction(String inputStr) throws Exception{
		String key = UtilDESCoder.initKey(getProperty("descoder_key"));
		System.out.println("原文:\t" + inputStr+"  长度:\t" + inputStr.length());

		System.out.println("密钥:\t" + key+"  长度:\t" + key.length());
		int num = Integer.valueOf(getProperty("descoder_encrypt_num"));
		StringBuilder firstSb = new StringBuilder("");
		StringBuilder secondSb = new StringBuilder("");
		StringBuilder thirdSb = new StringBuilder("");
		
		
		if(inputStr.length()>num){
			int identification_startnum = Integer.valueOf(getProperty("identification_startnum"));
			int identification_endnum = Integer.valueOf(getProperty("identification_endnum"));

			firstSb.append(inputStr.substring(0, identification_startnum));
			secondSb.append(inputStr.substring(identification_startnum, inputStr.length()-identification_endnum));
			thirdSb.append(inputStr.substring(inputStr.length()-identification_endnum));
		}else{
			int phone_startnum = Integer.valueOf(getProperty("phone_startnum"));
			int phone_endnum = Integer.valueOf(getProperty("phone_endnum"));

			firstSb.append(inputStr.substring(0, phone_startnum));
			secondSb.append(inputStr.substring(phone_startnum, inputStr.length()-phone_endnum));
			thirdSb.append(inputStr.substring(inputStr.length()-phone_endnum));
		}
		String secondStr = secondSb.toString();
		if(!isNumeric(secondStr)){
			System.out.println("不用加密直接输出:\t"+inputStr);
			return inputStr;
		}
		byte[] inputData = secondStr.getBytes();
		inputData = UtilDESCoder.encrypt(inputData, key);
		System.out.println((new BASE64Encoder()).encodeBuffer(inputData));
		String outputStr = (firstSb.append((new BASE64Encoder()).encodeBuffer(inputData).replaceAll("\r\n","")).append(thirdSb)).toString();
		System.out.println("加密后:\t" + outputStr+"  长度:\t" + outputStr.length());
		return outputStr;
	}
	/**
	 * 解密封装后的可调用方法
	 * @param inputStr
	 * @return
	 * @throws Exception
	 */
	public static String decryptFunction (String inputStr) throws Exception{
		String key = UtilDESCoder.initKey(getProperty("descoder_key"));
		System.out.println("密文:\t" + inputStr+"  长度:\t" + inputStr.length());
		System.out.println("密钥:\t" + key+"  长度:\t" + key.length());
		
		int num = Integer.valueOf(getProperty("descoder_decrypt_num"));
		StringBuilder firstSb = new StringBuilder("");
		StringBuilder secondSb = new StringBuilder("");
		StringBuilder thirdSb = new StringBuilder("");


		if(inputStr.length()>num){
			int identification_startnum = Integer.valueOf(getProperty("identification_startnum"));
			int identification_endnum = Integer.valueOf(getProperty("identification_endnum"));

			firstSb.append(inputStr.substring(0, identification_startnum));
			secondSb.append(inputStr.substring(identification_startnum, inputStr.length()-identification_endnum));
			thirdSb.append(inputStr.substring(inputStr.length()-identification_endnum));
		}else{
			int phone_startnum = Integer.valueOf(getProperty("phone_startnum"));
			int phone_endnum = Integer.valueOf(getProperty("phone_endnum"));

			firstSb.append(inputStr.substring(0, phone_startnum));
			secondSb.append(inputStr.substring(phone_startnum, inputStr.length()-phone_endnum));
			thirdSb.append(inputStr.substring(inputStr.length()-phone_endnum));
		}
		String secondStr = secondSb.toString();
		if(isNumeric(secondStr)){
			System.out.println("不用解密直接输出:\t"+inputStr);
			return inputStr;
		}
		
		byte[] inputData = (new BASE64Decoder()).decodeBuffer(secondStr);

		byte[] outputData = UtilDESCoder.decrypt(inputData, key);
		String outputStr = (firstSb.append(new String(outputData)).append(thirdSb)).toString();
		System.out.println(new String(outputData));
		System.out.println("解密后:\t" + outputStr+"  长度:\t" + outputStr.length());
		return outputStr;
	}
	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]+"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
	public static void main(String args[]) throws Exception{
		System.out.println(getProperty("phone_endnum"));
		
		String en = encryptFunction("372925198711141319");
		String de = decryptFunction(en);
		System.out.println("===============================================");
		String en1 = encryptFunction("15165469998");
		String de1 = decryptFunction(en1);
	}
	
	public static String getProperty(String proName)throws Exception{
		InputStream fileStream = UtilDESCoder.class.getResourceAsStream("/DESCoder.properties");
		Properties property = new Properties();
        property.load(fileStream);
        return property.getProperty(proName);
	}
}
