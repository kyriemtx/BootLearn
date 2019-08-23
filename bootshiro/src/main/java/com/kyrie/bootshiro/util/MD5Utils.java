package com.kyrie.bootshiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
	private static final String SALT = "kyrie";

	private static final String ALGORITH_NAME = "md5";

	private static final int HASH_ITERATIONS = 2;
    //ByteSource credentialsSalt = ByteSource.Util.bytes(username);

	public static String encrypt(String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}

	public static String encrypt(String username, String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
				HASH_ITERATIONS).toHex();
		return newPassword;
	}
	public static void main(String[] args) {

        System.err.println("颜值"+ByteSource.Util.bytes(SALT).toString());
		
		System.out.println("加密好的密码是："+MD5Utils.encrypt("kyrie", "kyrie"));


	}

}
