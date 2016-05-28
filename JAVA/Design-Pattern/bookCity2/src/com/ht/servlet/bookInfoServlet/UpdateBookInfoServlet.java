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

public class UpdateBookInfoServlet extends HttpServlet {
	PrintWriter out = null;
	private String[] strImages = new String[2];
	private int bookId = 0;
	private String bookName = null;
	private int bookTypeId = 0;
	private String publishName;
	private String author = null;
	private String context = null;
	private float price;
	private Date  publishDate;
	private int bookStates;
	private float specialPrice;
	String msg = "ʧ��";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** ���ݷ��ʶ���start**/
			//����ͼ����Ϣ��dao
			BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		/** ���ݷ��ʶ���end**/
			
		out = response.getWriter();
		File[] files =  new File[2];
		// ͼƬ�ϴ�·��
		String uploadPath = request.getSession().getServletContext().getRealPath("/")+ "upload/images/";
		// ͼƬ��ʱ�ϴ�·��
		String tempPath = request.getSession().getServletContext().getRealPath("/")+ "upload/images/temp/";
		// ͼƬ�������·��
		String imagePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/";
		// ��������Լ�¼�û����ļ���Ϣ,�����ϴ�����ļ���
		String destinationfileName = null;
		
		// �ļ��в����ھ��Զ�������
		if (!new File(uploadPath).isDirectory())
			new File(uploadPath).mkdirs();
		if (!new File(tempPath).isDirectory())
			new File(tempPath).mkdirs();
		try {
			DiskFileUpload fu = new DiskFileUpload();
			// ��������ļ��ߴ磬������4MB
			fu.setSizeMax(4194304);
			// ���û�������С��������4kb
			fu.setSizeThreshold(4096);
			// ������ʱĿ¼��
			fu.setRepositoryPath(tempPath);
			// �õ����е��ļ���
			List fileItems = fu.parseRequest(request);
			Iterator i = fileItems.iterator();
			int z = 0;
			int y = 0;
			// ���δ���ÿһ���ļ���
			while (i.hasNext()) {
				FileItem file = (FileItem) i.next();
				/** ���ܿͻ�������**/
				if (file.isFormField()) {
					if(file.getFieldName().equals("bookId"))
						bookId = Integer.parseInt(file.getString());
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
					// ����ļ���������ļ������û��ϴ�ʱ�û��ľ���·����
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
						//out.print(sourcefileName+"�ɹ��ϴ���") ;
						strImages[z++] = destinationfileName;
						// out.print("<img src="+imagePath+"upload/images/"+destinationfileName+">");
					} else {
						
						//out.println("�ϴ��ļ�����ֻ���ϴ� *.jpg , *.gif");
					}
				}
			}

		} catch (Exception e) {
			// ������ת����ҳ��
			// out.flush();
			out.print("<script type='text/javascript'>alert('�޸�����" +msg +"');document.location.href='FindBookInfoByIdServlet?bookId=" + bookId + "';</script>");
		}
				/** ���ܿͻ�������end**/
		/*int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		String publishName = request.getParameter("publishName");
		String author = request.getParameter("author");
		String context = request.getParameter("context");
		String smallImg = request.getParameter("smallImg");
		String bigImg = request.getParameter("bigImg");
		float price = Float.parseFloat(request.getParameter("price"));
		Date  publishDate = null;
		try {
			publishDate = Tool.convertStringToDate(request.getParameter("publishDate"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int bookStates = Integer.parseInt(request.getParameter("bookStates"));
		float specialPrice = Float.parseFloat(request.getParameter("specialPrice"));*/
		
		/**
		 * ���ӿͻ��˵õ���ͼ����Ϣ��װΪһ��ʵ����
		 */
		BookInfoDAO bookInfoDAOImplZ = new BookInfoDAOImpl();
		BookInfo bookInfoZ = bookInfoDAOImplZ.findById(bookId);
		if(strImages[0] == null)  
			strImages[0] = bookInfoZ.getSmallImg();
		else {
			File file = new File(uploadPath + bookInfoZ.getSmallImg());
			file.delete();
		}
		
		if(strImages[1] == null) {
			strImages[1] = bookInfoZ.getBigImg();
		} else {
			File file = new File(uploadPath + bookInfoZ.getBigImg());
			file.delete();
		}
		
		BookInfo bookInfo = new BookInfo(
										bookId,
										bookName, 
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
		
		//��ͻ��˴�ӡ��ʾ��Ϣ�ͷ���·�� 
		msg = "�ɹ�";
		if(bookInfoDAOImpl.update(bookInfo)) {
			out.print("<script type='text/javascript'>alert('�޸�����" + msg +"');document.location.href='FindAllBookInfoServlet';</script>");
			out.close();
		} else {
			msg = "ʧ��";
			//����ʧ��ѭ��ɾ��ͼƬ
			for(int z = 0; z < 2; z++) {
				files[z].delete();
			}
			out.print("<script type='text/javascript'>alert('�޸�����" +msg +"');document.location.href='FindBookInfoByIdServlet?bookId=" + bookId + "';</script>");
			out.close();
		}
	}

}
