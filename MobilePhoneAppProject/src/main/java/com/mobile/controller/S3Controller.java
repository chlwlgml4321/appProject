package com.mobile.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.ResponseBody; 
import org.springframework.web.multipart.MultipartFile;

import com.mobile.service.S3Service;

import java.io.IOException; 

/**
 * 이미지 업로드 테스트 컨트롤러
 * */

@Controller
@AllArgsConstructor
public class S3Controller {
	private S3Service s3Service;
//	private GalleryService galleryService;

	@GetMapping("/gallery")
	public String dispWrite() {

		return "/admin/gallery";
	}

}
