package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
public class CheckCodeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service...");
		//生成一张图片
		Random r = new Random(
				System.currentTimeMillis());
		//随机字符串
		String value = r.nextInt(999999) + "";
		//先创建一个内存映像对象
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//得到画笔
		Graphics g = image.getGraphics();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//填充
		g.fillRect(0, 0, 80, 30);
		//画画
		g.setColor(new Color(0,0,0));
		//Font(String,int,int); 字体名称，风格，大小
		g.setFont(new Font(null,Font.BOLD,18));
		g.drawString(value, 5, 20);
		for(int i=0;i<8;i++){
			g.drawLine(r.nextInt(80), r.nextInt(30),
					r.nextInt(80), r.nextInt(30));
		}
		
		//将图片压缩
		//需要提供一个输出流,encoder工具会将
		//图片压缩之后的数据以流的方式输出。
		response.setContentType("image/jpeg");
		OutputStream ops = 
			response.getOutputStream();
//		JPEGImageEncoder encoder = 
//			JPEGCodec.createJPEGEncoder(ops);
//		encoder.encode(image);
		javax.imageio.ImageIO.write(
				image, "jpg", ops);
		
	}

}
