package com.file.demo.controller;



import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.demo.service.S3Service;

@RestController
@RequestMapping("/api")

public class UploadController {

	private static final Logger logger = Logger.getLogger(UploadController.class.getName());
	
    private final S3Service s3Service;
    

    public UploadController(S3Service s3Service) {
		super();
		this.s3Service = s3Service;
	}

	@PostMapping("/files/upload")
    public String uploadFile(
            @RequestParam("file") MultipartFile file) {
		
		logger.info("File Name: " + file.getOriginalFilename()+ " "+"File Size: " + file.getSize());
		
        return s3Service.uploadFile(file, "files");
    }

    @PostMapping("/images/upload")
    public String uploadImage(
            @RequestParam("image") MultipartFile image) {

    	logger.info("image Name: " + image.getOriginalFilename()+ " "+"image Size: " + image.getSize());
        return s3Service.uploadFile(image, "images");
    }
}