package com.mobile.service;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.mobile.domain.Review;
import com.mobile.repository.ReviewRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@Transactional
public class S3Service {

	private AmazonS3 s3Client;
	
	@Autowired
	private ReviewRepository reviewRepo;

	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secretKey}")
	private String secretKey;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	@Value("${cloud.aws.region.static}")
	private String region;
	
	@PostConstruct
	public void setS3Client() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

		s3Client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(this.region)
				.build();
	}

	public String upload(MultipartFile file) throws IOException {
		String strFileName = file.getOriginalFilename();
		
		int pos = strFileName.lastIndexOf( "." );
		String ext = strFileName.substring( pos + 1 );

		int seq = reviewRepo.getNextValMySequence();
		String fileName = "review_image_"+ seq + "." + ext;
		s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), null)
				.withCannedAcl(CannedAccessControlList.PublicRead));
		return s3Client.getUrl(bucket, fileName).toString();
	}
	
	public String update(MultipartFile file, Long reviewId) throws IOException {
		String strFileName = file.getOriginalFilename();
		
		int pos = strFileName.lastIndexOf( "." );
		String ext = strFileName.substring( pos + 1 );

		String fileName = "review_image_"+ reviewId + "." + ext;
		s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), null)
				.withCannedAcl(CannedAccessControlList.PublicRead));
		return s3Client.getUrl(bucket, fileName).toString();
	}
	
	
	public String upload(MultipartFile file, Integer reviewId) throws IOException {
		String fileName = file.getOriginalFilename();

		s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), null)
				.withCannedAcl(CannedAccessControlList.PublicRead));
		return s3Client.getUrl(bucket, fileName).toString();
		
	}

}
