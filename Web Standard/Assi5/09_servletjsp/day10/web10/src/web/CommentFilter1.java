package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����������ʱ���ᴴ��������ʵ�����������������
 * ��������init�������ڵ��ø÷�����ʱ�򣬻��ȴ�����
 * ����FilterConfig�ӿڵ�һ�����󣬿���ͨ���ö����
 * String getInitPararmeter(String paraName)������
 * ���ʹ������ĳ�ʼ��������
 * 
 * �������յ�����󣬻���ù�������doFilter����,��ʱ��
 * �����Ὣrequest,response������Ϊ�������ݸ���������
 * ���������Ե�������������(�������ͨ��request����
 * ����������)��ֻ��ִ��FilterChain��doFilter������
 * �����Ż���ú����Ĺ�������
 * 
 * ������������Ҫ������������ɾ��������֮ǰ���ȵ���
 * destroy������
 * 
 *������ʵ��ֻ��һ����
 */
public class CommentFilter1 implements Filter{
	
	public CommentFilter1() {
		System.out.println("CommentFilter1's constructor...");
	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0,
			ServletResponse arg1, FilterChain arg2) 
	throws IOException, ServletException {
		System.out.println("CommentFilter1's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		if(content.indexOf("dog") >=0){
			out.println("your comment is illegal.");
		}else{
			//���ú����Ĺ�������
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("CommentFilter1's doFilter end.");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CommentFilter1's init...");
	}

}
