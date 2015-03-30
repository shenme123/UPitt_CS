package web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//step1 创建一个DiskFileItemFactory对象
		//给对象为解析器提供解析时的一些缺省的配置 
		DiskFileItemFactory factory = 
			new DiskFileItemFactory();
		//step2 创建一个解析器
		ServletFileUpload sfu = 
			new ServletFileUpload(factory);
		//step3 使用解析器解析InputStream
			try {
				//解析器在解析完成之后，会生成一个
				//一个FileItem集合：一个表单域对应一个
				//FileItem对象
				List<FileItem> items = 
					sfu.parseRequest(request);
				for(int i=0;i<items.size();i++){
					FileItem curr = items.get(i);
					//要区分是普通表单域还是上传文件域
					if(curr.isFormField()){
						//是一个普通的表单域
						String username = curr.getString();
						System.out.println("username:" + username);
					}else{
						//是一个上传文件域
						//会将数据以文件的方式保存下来
						ServletContext sctx = 
							getServletContext();
						//依据逻辑路径获得实际部署时的物理路径
						String path = sctx.getRealPath("upload");
						System.out.println("path:" + path);
						//获得文件名
						String fileName = curr.getName();
						System.out.println("fileName:"
								+ fileName);
						File file = new File(path + "\\" + fileName);
						curr.write(file);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		
		
	}

}
