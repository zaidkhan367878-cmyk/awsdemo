package com.file.demo.controller;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.demo.service.S3Service;

@RestController
@RequestMapping("/api")

public class UploadController {

    private final S3Service s3Service;
    

    public UploadController(S3Service s3Service) {
		super();
		this.s3Service = s3Service;
	}

	@PostMapping("/files/upload")
    public String uploadFile(
            @RequestParam("file") MultipartFile file) {
		System.out.println("File Name: " + file.getOriginalFilename());
	    System.out.println("File Size: " + file.getSize());

        return s3Service.uploadFile(file, "files");
    }

    @PostMapping("/images/upload")
    public String uploadImage(
            @RequestParam("image") MultipartFile image) {

        return s3Service.uploadFile(image, "images");
    }
}