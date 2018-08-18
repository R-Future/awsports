package com.awsports.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String Encode(String plainText){
		StringBuffer cipherText=new StringBuffer("");
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			byte[] encode=md5.digest(plainText.getBytes());
			for(int i=0;i<encode.length;i++){
				int temp=encode[i]&0xff;
				String tempHex=Integer.toHexString(temp);
				if(tempHex.length()<2){
					cipherText.append("0"+tempHex);
				}else{
					cipherText.append(tempHex);
				}
			}	
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cipherText.toString();
	}
}
