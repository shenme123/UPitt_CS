package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{
	private int count = 0; //������
	/**
	 * ��������session����֮�󣬻������������������
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session created.");
		count ++;
		//�������󶩵�ServletContext
		ServletContext sctx = 
			arg0.getSession().getServletContext();
		sctx.setAttribute("count", count);
	}
	
	/**
	 * ��������session����֮�󣬻������������������
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session destroyed.");
		count --;
		ServletContext sctx = 
			arg0.getSession().getServletContext();
		sctx.setAttribute("count", count);
		
	}

}
