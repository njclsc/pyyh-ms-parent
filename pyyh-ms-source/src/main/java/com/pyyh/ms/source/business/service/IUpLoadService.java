package com.pyyh.ms.source.business.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface IUpLoadService {
	
	public String uploadSource(MultipartFile files[], HttpServletRequest request);
}
