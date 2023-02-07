package com.douzone.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.fileupload.service.FileuploadService;

@Controller
public class FileuploadController {
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping({"","/form"})
	public String form() {
		return "form";
	}
	
	@RequestMapping("/upload")
	public String upload(String email,MultipartFile file,Model model) {
		System.out.println("email : "+email);
		String url = fileuploadService.restore(file);
		model.addAttribute("url",url);
		return "result";
	}
}
