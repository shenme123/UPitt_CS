package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	/**
	 *  ����md5�㷨������һ��ժҪ��
	 *  ժҪ�㷨�������ص㣺
	 *  	a, Ψһ��: ��ͬ�����ģ���Ψһ��һ��ժҪ��֮��Ӧ��
	 *  	b,������:�õ�ժҪ֮�󣬲��ܹ����Ƴ�ԭʼ������
	 * @throws NoSuchAlgorithmException 
	 */
	public static String encrypt(String origStr) 
	throws NoSuchAlgorithmException{
		MessageDigest md = 
			MessageDigest.getInstance("md5");
		//digest��������md5�㷨��һ���ֽ��������
		//���ܣ�Ȼ�󷵻�һ������֮����ֽ�����
		byte[] buff = md.digest(origStr.getBytes());
		//��buff�ֽ�������ת����һ���ַ���
		BASE64Encoder encoder = new BASE64Encoder();
		//encode�����Ὣ�ֽ�����ת����һ���ַ���
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
