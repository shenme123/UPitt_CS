package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	/**
	 *  依据md5算法，生成一个摘要。
	 *  摘要算法有两个特点：
	 *  	a, 唯一性: 不同的明文，有唯一的一个摘要与之对应。
	 *  	b,不可逆:得到摘要之后，不能够反推出原始的明文
	 * @throws NoSuchAlgorithmException 
	 */
	public static String encrypt(String origStr) 
	throws NoSuchAlgorithmException{
		MessageDigest md = 
			MessageDigest.getInstance("md5");
		//digest方法依据md5算法对一个字节数组进行
		//加密，然后返回一个加密之后的字节数组
		byte[] buff = md.digest(origStr.getBytes());
		//将buff字节数组再转换成一个字符串
		BASE64Encoder encoder = new BASE64Encoder();
		//encode方法会将字节数组转换成一个字符串
		String str = encoder.encode(buff);
		return str;
	}

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) 
	throws NoSuchAlgorithmException {
		String str = encrypt("I love you");
		System.out.println(str);
	}

}
