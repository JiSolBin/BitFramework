package com.bit.sts10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	
	String uploadPath = "C:/BitFramework/sts10/src/upload/";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest req) throws IllegalStateException, IOException {

		// 파일명 같을 경우 덮어쓰기 됨
		//file.transferTo(new File(req.getRealPath("/resources/upload")+"/"+file.getOriginalFilename()));
		
		// 파일 덮어쓰기 방지
		String filename = System.currentTimeMillis()+"_"+file.getOriginalFilename();
		//file.transferTo(new File(req.getRealPath("/resources/upload")+"/"+filename)); 
		
		// 임의의 폴더에 업로드 한 뒤, 컨트롤러를 거쳐 다운로드 하도록 함
		file.transferTo(new File(uploadPath+filename));
		
		req.setAttribute("origin", file.getOriginalFilename());
		req.setAttribute("filename", filename);
		return "down";
	}
	
	@RequestMapping(value = "/down", method = RequestMethod.GET)
	public void down1(HttpServletResponse res, @RequestParam("file") String filename) throws IOException {
		
		File file = new File(uploadPath+filename);
		
		try (
			OutputStream os = res.getOutputStream();
			InputStream is = new FileInputStream(file);
		){
			while(true) {
				int su = is.read();
				if(su==-1) break;
				os.write(su);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
