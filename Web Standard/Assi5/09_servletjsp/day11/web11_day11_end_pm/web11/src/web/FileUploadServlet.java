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
		//step1 ����һ��DiskFileItemFactory����
		//������Ϊ�������ṩ����ʱ��һЩȱʡ������ 
		DiskFileItemFactory factory = 
			new DiskFileItemFactory();
		//step2 ����һ��������
		ServletFileUpload sfu = 
			new ServletFileUpload(factory);
		//step3 ʹ�ý���������InputStream
			try {
				//�������ڽ������֮�󣬻�����һ��
				//һ��FileItem���ϣ�һ�������Ӧһ��
				//FileItem����
				List<FileItem> items = 
					sfu.parseRequest(request);
				for(int i=0;i<items.size();i++){
					FileItem curr = items.get(i);
					//Ҫ��������ͨ�������ϴ��ļ���
					if(curr.isFormField()){
						//��һ����ͨ�ı���
						String username = curr.getString();
						System.out.println("username:" + username);
					}else{
						//��һ���ϴ��ļ���
						//�Ὣ�������ļ��ķ�ʽ��������
						ServletContext sctx = 
							getServletContext();
						//�����߼�·�����ʵ�ʲ���ʱ������·��
						String path = sctx.getRealPath("upload");
						System.out.println("path:" + path);
						//����ļ���
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
