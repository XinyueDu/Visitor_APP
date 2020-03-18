package com.server;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartResolver;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

@SuppressWarnings("serial")
public class SavePic extends HttpServlet{
	public static String PhotoPath;
	public String getPhotoPath() {
		return PhotoPath;
	}
	public void setPhotoPath(String PhotoPath) {
		this.PhotoPath = PhotoPath;
	}
	@ResponseWrapper
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
		ServletFileUpload upload = new ServletFileUpload();
		upload.setHeaderEncoding("UTF-8");

		int i = 0;
		try{
		FileItemIterator iter = upload.getItemIterator(request);
		while(iter.hasNext()){
		 i++;
		 FileItemStream fi = iter.next();
		 InputStream in = null;
		 OutputStream fileout = null;
		try {
		 String fileName = fi.getName();
		 setPhotoPath("G:/STSwork/VisitorApp/WebContent/uploadImg/Message/" + fileName.substring(0, fileName.lastIndexOf(".")) + "_" + i + fileName.substring(fileName.lastIndexOf(".")));
		 File file = new File("G:/STSwork/VisitorApp/WebContent/uploadImg/Message/"+ fileName.substring(0, fileName.lastIndexOf(".")) + "_" + i + fileName.substring(fileName.lastIndexOf(".")));
		 System.out.println(PhotoPath);
		 in = fi.openStream();
		 ByteArrayOutputStream bstream = new ByteArrayOutputStream();
		 Streams.copy(in, bstream, true);
		 fileout = new FileOutputStream(file);
		 bstream.writeTo(fileout);
		 } catch (IOException e) {
		 throw new RuntimeException("file copy error!",e);
		 }finally{
		 if(in != null){
			 try {
		 
				 in.close();
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		}
		 if(fileout != null){
			 try {
				 fileout.close();
				 } catch (IOException e) {
					 e.printStackTrace();
				 }
			 }
		 }
		}
		}catch(Exception e) {
				throw new RuntimeException("upload file error.",e);
			}
		}
		else{
			
		}
}
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		//String uploadPath = "\\WEB-INF";
//		System.out.println(request + "************111");
//		multipartResolver = ((MultipartResolver)ApplicationContextUtil.getContext().getBean("multipartResolver", MultipartResolver.class));
//		ServletRequest req = multipartResolver.resolveMultipart((HttpServletRequest)request);
//		try {
//		String saveDirectory = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadImg/Message");
//		System.out.println(saveDirectory + "**********222");
//		String contype = req.getContentType();
//		System.out.println(contype + "*********222333");
//		InputStream is = req.getInputStream();
//
//		String ramdomname = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//		String fullname = ramdomname + "hh.jpg";
//		File filedes = new File(saveDirectory + "\\" + fullname);
//		filedes.createNewFile();
//		System.out.println(saveDirectory + "\\" + fullname + "   *******222333");
//		FileOutputStream fos = new FileOutputStream(filedes);
//
//		int bytesRead;
//		byte[] buf = new byte[4 * 1024];
//		while ((bytesRead = is.read(buf)) != -1) {
//			//System.out.println(new String(buf) + "333");
//			fos.write(buf, 0, bytesRead);
//		}
//		fos.flush();
//		fos.close();
//		is.close();
//		response.getWriter().print(fullname);
//		response.getWriter().close();
//
//	}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(request, response);
	}
}
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		System.out.println(request.getSession());
//		try {
//			System.out.println("kaishi");
//			String savePaht = uploadPic2Path(request, "jpg", "Message", "VistorMes");
//			if (savePaht != null) {
//				// 保存对象
//				System.out.println(savePaht);
//				out.print(savePaht);
//			}
//			//return buildSuccessRes(savePaht);
//		} catch (Exception e) {
//			e.printStackTrace();
//			//return buildErrorRes("0", e.getMessage());
//		}
//		
//	}
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//super.doPost(req, resp);
//		doGet(request, response);
//	}
//	@SuppressWarnings("null")
//	public static synchronized String uploadPic2Path(HttpServletRequest request, String type, String dir, String name)
//			throws Exception {
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//		String saveFileName = null;
//		System.out.println("Cunchun");
//		String imagePath = "WEB-INF/uploadImg/" + dir + "/";
//		String x = request.getParameter("length");
//		String y = request.getParameter("wide");
//		if (isMultipart) {
//			String headShowServicePath = request.getSession().getServletContext().getRealPath("/") + imagePath;
//			//Date nowDate = new Date();
//			System.out.println(headShowServicePath);
//			String fileName = name;
//			File headShowFile = new File(headShowServicePath);
//			if (!headShowFile.isDirectory())
//				headShowFile.mkdirs();
//			try{
//				DiskFileItemFactory factory = new DiskFileItemFactory();
//				ServletFileUpload sfu = new ServletFileUpload(factory);
//				sfu.setSizeMax(10 * 1024 * 1024);
//				sfu.setHeaderEncoding("utf-8"); 
//				@SuppressWarnings("unchecked") 
//				List<FileItem> fileItemList = sfu.parseRequest(request);
//				Iterator<FileItem> fileItems = fileItemList.iterator();
//				while (fileItems.hasNext()){
//						FileItem fileItem = fileItems.next(); 
//						if (fileItem.isFormField()) { 
//							String names = fileItem.getFieldName();// name属性值  
//							String value = fileItem.getString("utf-8");// name对应的value值    
//							System.out.println(names + " = " + value);
//						}
//						else{
////							String fileNames=fileItem.getName();
////							
////							String suffix=fileNames.substring(fileName,lastIndexOf('.'));
//							String fix = type;
//							fileName += "." + fix;
//							saveFileName = imagePath + fileName;
//							File file=new File(headShowServicePath + saveFileName);
//							fileItem.write(file);
//						}
//				}
//			}catch (FileUploadException e){
//						e.printStackTrace();
//				}
//		
////			DiskFileItemFactory factory = new DiskFileItemFactory();
////			factory.setSizeThreshold(4096);
////			factory.setRepository(headShowFile);
////			ServletFileUpload uploader = new ServletFileUpload(factory);
////			uploader.setSizeMax(20 * 1024 * 1024);
////			uploader.setHeaderEncoding("utf-8");
////			
////			//FileItem item = new F;
//////			String fix = type;
//////			fileName += "." + fix;
//////			saveFileName = imagePath + fileName;
//////			File file = new File(headShowServicePath + fileName);
////			//item.write(file);
////			System.out.println(uploader.parseRequest(request));
////			List<FileItem> fileItems = uploader.parseRequest(request);
////			for (FileItem item : fileItems) {
////				if (item.isFormField()) {
////					// funName=item.getString();
////				} else {
////					String fix = type;
////					fileName += "." + fix;
////					saveFileName = imagePath + fileName;
////					File file = new File(headShowServicePath + fileName);
////					item.write(file);
////				}
////			}
//			// 压缩图片
//			if (x != null && !"".equals(x) && y != null && !"".equals(y)) {
//				saveFileName = thumbnailatorImage(imagePath, fileName, type, Integer.parseInt(x), Integer.parseInt(y));
//			}
//		}
//		return saveFileName;
//	}
//	
//	//void write(File file) throws Exception;
//	
//	public static String thumbnailatorImage(String oldSavePath, String oldFileName, String fix, int x, int y)
//			throws IOException {
//		// Thumbnail读取并压缩图片
//		BufferedImage waterMarkBufferedImage = Thumbnails.of(oldSavePath + oldFileName)
//				// Thumbnail的方法,压缩图片
//				.size(x, y)
//				// 读取成BufferedImage对象
//				.asBufferedImage();
//		// 把内存中的图片写入到指定的文件中
//		String savePath = oldSavePath + x + "-" + y + "/";
//		File saveFile = new File(savePath);
//		if (!saveFile.isDirectory())
//			saveFile.mkdirs();
//
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		factory.setSizeThreshold(1024 * 4);
//		factory.setRepository(saveFile);
//		ServletFileUpload uploader = new ServletFileUpload(factory);
//		uploader.setSizeMax(20 * 1024 * 1024);
//
//		UUID uuid = UUID.randomUUID();
//		String fileName = uuid.toString();
//		fileName += "." + fix;
//		String saveFileName = savePath + fileName;
//		File fileOutPut = new File(saveFileName);
//		ImageIO.write(waterMarkBufferedImage, fix, fileOutPut);
//		return saveFileName;
//	}
//}
