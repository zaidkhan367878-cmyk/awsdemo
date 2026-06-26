package com.file.demo.dto;

public class UploadResponse {

    private String fileName;
    private String s3Key;
    private String message;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getS3Key() {
		return s3Key;
	}
	public void setS3Key(String s3Key) {
		this.s3Key = s3Key;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "UploadResponse [fileName=" + fileName + ", s3Key=" + s3Key + ", message=" + message + "]";
	}
    
    
    
}