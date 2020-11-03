package com.it.gb4.util;

import java.io.File;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	public String saveTransfer(File dest, MultipartFile multipartFile)throws Exception{
		if(!dest.exists()) {
			dest.mkdirs();
		}
		
		// 1. 이름설정(시간으로)
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String fileName = multipartFile.getOriginalFilename();
		fileName = time+"_"+fileName;
		
		dest = new File(dest, fileName);
		
		multipartFile.transferTo(dest);
		
		return fileName;
	}
	
	// FilecopyUtils.copy 사용
	public String saveCopy(File dest, MultipartFile multipartFile)throws Exception{
		
		if(!dest.exists()) {
			dest.mkdirs();
		}
		
		// 1. 이름설정(시간으로)
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String fileName = multipartFile.getOriginalFilename();
		fileName = time+"_"+fileName;
		
		dest = new File(dest, fileName);
		
		// 2. HDD 저장
		FileCopyUtils.copy(multipartFile.getBytes(), dest);
		
		return fileName;
	}
}
