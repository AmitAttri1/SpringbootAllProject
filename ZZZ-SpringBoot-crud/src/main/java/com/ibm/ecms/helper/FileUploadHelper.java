package com.ibm.ecms.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
private final String Upload_Dir="C:\\springbootworkspace\\ZZZ-SpringBoot-crud\\src\\main\\resources\\static\\image";

public boolean uploadFile(MultipartFile multipart)
{
	boolean f=false;
	
	
	try {
		
		InputStream is = multipart.getInputStream();
		
		byte data[]=new byte[is.available()];
		is.read(data);
		
		FileOutputStream fos=new FileOutputStream(Upload_Dir+""+multipart.getOriginalFilename());
		
		fos.write(data);
		fos.flush();
		fos.close();
		f=true;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return f;
	
}

}
