package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{
	private int count = 0; //计数器
	/**
	 * 容器创建session对象之后，会立即调用这个方法。
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session created.");
		count ++;
		//将人数绑订到ServletContext
		ServletContext sctx = 
			arg0.getSession().getServletContext();
		sctx.setAttribute("count", count);
	}
	
	/**
	 * 容器销毁session对象之后，会立即调用这个方法。
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session destroyed.");
		count --;
		ServletContext sctx = 
			arg0.getSession().getServletContext();
		sctx.setAttribute("count", count);
		
	}

}
