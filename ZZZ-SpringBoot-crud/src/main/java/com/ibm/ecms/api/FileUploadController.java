package com.ibm.ecms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.ecms.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
    private FileUploadHelper fileUploadHelper;
	
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam ("file") MultipartFile file)
	{
		try {
			
		
		/*
		 * System.out.println(file.getOriginalFilename());
		 * System.out.println(file.getSize()); System.out.println(file.getName());
		 */
		
		if(file.isEmpty())
		{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		}
		
		boolean f = fileUploadHelper.uploadFile(file);
		if(f)
		{
			return ResponseEntity.ok("file is uploaded successfully");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.internalServerError().body("something went wrong");
	}
	//file upload code...
	

}
