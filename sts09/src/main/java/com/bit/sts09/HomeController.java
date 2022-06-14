package com.bit.sts09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest req, Model model) throws IOException {
		
		// 파일명 읽어오기
		MultipartFile mfile = req.getFile("file");
		String origin = mfile.getOriginalFilename();
		
		// 업로드 위치 설정
		String uploadPath = req.getRealPath("/resources/upload");
		
		// 파일 업로드
		InputStream is = mfile.getInputStream();
		//File file = new File("C:\\BitFramework\\sts09\\src\\main\\webapp\\resources\\upload\\"+origin);
		File file = new File(uploadPath+"/"+origin);
		OutputStream os = new FileOutputStream(file);
		
		while(true) {
			int su = is.read();
			if(su==-1) break;
			os.write(su);
		}
		
		model.addAttribute("filename", origin);
		return "down";
	}
}
