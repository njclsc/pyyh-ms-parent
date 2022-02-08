package com.pyyh.ms.source.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pyyh.ms.source.business.service.IUpLoadService;

@RestController
@RequestMapping("/upload")
public class UpLoadController {
	@Autowired
	@Qualifier("UpLoadServiceImp")
	private IUpLoadService uploadService;
	@RequestMapping("uploadSource")
	public String uploadSource(@RequestParam("files") MultipartFile[] files, HttpServletRequest request){
		return uploadService.uploadSource(files, request);
		
	}
}
