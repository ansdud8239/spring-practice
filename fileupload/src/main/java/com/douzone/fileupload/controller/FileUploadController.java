package com.douzone.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping({"","/form"})
	public String form() {
		return "form";
	}
	
	@RequestMapping("/upload")
	public String upload(String email,MultipartFile file,Model model) {
		String url = fileuploadService.restore(file);
		model.addAttribute("url",url);
		return "result";
	}
}
