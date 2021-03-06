package com.bridgelabz.fundoonotes.service;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3Service {

	 void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess);

	    void deleteFileFromS3Bucket(String fileName);
}
