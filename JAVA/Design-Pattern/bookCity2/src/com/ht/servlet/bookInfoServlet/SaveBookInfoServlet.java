package com.ht.servlet.bookInfoServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.util.Tool;

public class SaveBookInfoServlet extends HttpServlet {
	PrintWriter out = null;
	private String[] strImages = new String[2];
	private String bookName = null;
	private int bookTypeId = 0;
	private String publishName;
	private String author = null;
	private String context = null;
	private float price;
	private Date  publishDate;
	private int bookStates;
	private float specialPrice;
	String msg = "失败";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** 数据访问对象start**/
			//操作图书信息的dao
			BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		/** 数据访问对象end**/
		
		out = response.getWriter();
		File[] files =  new File[2];
		
		// 图片上传路径
		String uploadPath = request.getSession().getServletContext().getRealPath("/")+ "upload/images/";
		// 图片临时上传路径
		String tempPath = request.getSession().getServletContext().getRealPath("/")+ "upload/images/temp/";
		// 图片网络相对路径
		String imagePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/";
		// 在这里可以记录用户和文件信息,生成上传后的文件名
		String destinationfileName = null;
		
		// 文件夹不存在就自动创建：
		if (!new File(uploadPath).isDirectory())
			new File(uploadPath).mkdirs();
		if (!new File(tempPath).isDirectory())
			new File(tempPath).mkdirs();
		try {
			DiskFileUpload fu1 = new DiskFileUpload();
			// 设置最大文件尺寸，这里是4MB
			fu1.setSizeMax(4194304);
			// 设置缓冲区大小，这里是4kb
			fu1.setSizeThreshold(4096);
			// 设置临时目录：
			fu1.setRepositoryPath(tempPath);
			// 得到所有的文件：
			List fileItems = fu1.parseRequest(request);
			Iterator i = fileItems.iterator();
			int z = 0;
			int y = 0;
			// 依次处理每一个文件：
			while (i.hasNext()) {
				FileItem file = (FileItem) i.next();
				if (file.isFormField()) {
					/**接受客户端数据start**/
					if(file.getFieldName().equals("bookName")) 
						bookName = file.getString("utf-8");
					if(file.getFieldName().equals("bookTypeId"))
						bookTypeId = Integer.parseInt(file.getString("utf-8"));
					if(file.getFieldName().equals("publishName"))
						publishName = file.getString("utf-8");
					if(file.getFieldName().equals("author"))
						author = file.getString("utf-8");
					if(file.getFieldName().equals("context"))
						context = file.getString("utf-8");
					if(file.getFieldName().equals("price"))
						price = Float.parseFloat(file.getString("utf-8"));
					if(file.getFieldName().equals("publishDate"))
						publishDate = Tool.convertStringToDate(file.getString("utf-8"));
					if(file.getFieldName().equals("bookStates"))
						bookStates = Integer.parseInt(file.getString("utf-8"));
					if(file.getFieldName().equals("specialPrice"))
						specialPrice = Float.parseFloat(file.getString("utf-8"));
				}else{
					// 获得文件名，这个文件名是用户上传时用户的绝对路径：
					String sourcefileName = file.getName();
					if (sourcefileName != null && (sourcefileName.endsWith(".jpg") || sourcefileName.endsWith(".gif"))) {
						Random rd = new Random();
						Calendar time = Calendar.getInstance();
						if (sourcefileName.endsWith(".jpg")) { 
							destinationfileName = String.valueOf(time.get(Calendar.YEAR)) + String.valueOf(time.get(Calendar.MONTH))+ String.valueOf(time.get(Calendar.DAY_OF_MONTH)) + String.valueOf(time.get(Calendar.HOUR_OF_DAY)) + String.valueOf(time.get(Calendar.MINUTE)) + String.valueOf(time.get(Calendar.SECOND)) + String.valueOf(rd.nextInt(100)) + ".jpg";
						} else if (sourcefileName.endsWith(".gif")) {
							destinationfileName = String.valueOf(time.get(Calendar.YEAR))+ String.valueOf(time.get(Calendar.MONTH))+ String.valueOf(time.get(Calendar.DAY_OF_MONTH))+ String.valueOf(time.get(Calendar.HOUR_OF_DAY))+ String.valueOf(time.get(Calendar.MINUTE))+ String.valueOf(time.get(Calendar.SECOND))+ String.valueOf(rd.nextInt(100)) + ".gif";
						}
						File f1 = new File(uploadPath + destinationfileName);
						files[y++] = f1;
						file.write(f1);
						//out.print(sourcefileName+"成功上传！") ;
						strImages[z++] = destinationfileName;
						// out.print("<img src="+imagePath+"upload/images/"+destinationfileName+">");
					} else {
						
						//out.println("上传文件出错，只能上传 *.jpg , *.gif");
					}
				}
			}

		} catch (Exception e) {
			// 可以跳转出错页面
			// out.flush();
			// out.close();
			e.printStackTrace();
			out.print("<script type='text/javascript'>alert('新增数据" +msg +"');document.location.href='"+ request.getContextPath()+"/background/bookInfo/SaveBookInfo.jsp';</script>");
		}
		
		
		/**
		 * 将从客户端得到的图书信息包装为一个实体类
		 */
		BookInfo bookInfo = new BookInfo(bookName, 
										bookTypeId, 
										publishName, 
										author, 
										context.trim(), 
										strImages[0], 
										strImages[1], 
										price, 
										publishDate, 
										bookStates, 
										specialPrice);
		
			msg = "成功";
			if(bookInfoDAOImpl.save(bookInfo)) {
				out.print("<script type='text/javascript'>alert('新增数据" + msg +"');document.location.href='FindAllBookInfoServlet';</script>");
				out.close();
			} else {
				msg = "失败";
				//插入失败循环删除图片
				for(int z = 0; z < 2; z++) {
					files[z].delete();
				}
				
				out.print("<script type='text/javascript'>alert('新增数据" +msg +"');document.location.href='"+ request.getContextPath()+"/InitBookTypeServlet';</script>");
				out.close();
			}
	}

}
