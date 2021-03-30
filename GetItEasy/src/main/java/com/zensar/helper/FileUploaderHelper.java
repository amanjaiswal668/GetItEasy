package com.zensar.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploaderHelper {
	
	@Value("${image.url}")
	public String UPLOAD_DIR; 

	public boolean uploadFile(MultipartFile file,int produId) {
		boolean uploaded = false;
		try {
			//Read
			InputStream inputStream = file.getInputStream();
			byte data[] = new byte[inputStream.available()];
			inputStream.read(data);
			//Write
			FileOutputStream outputStream = new FileOutputStream(UPLOAD_DIR+"\\"+"product"+produId+file.getOriginalFilename());
			outputStream.write(data);
			outputStream.flush();
			outputStream.close();
			uploaded = true;
			
		}catch(Exception e) {
			System.out.println("File Upload Failed");
			e.printStackTrace();
		}
		
		return uploaded;
	}
	
}
