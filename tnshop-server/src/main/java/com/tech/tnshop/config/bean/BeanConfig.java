package com.tech.tnshop.config.bean;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */

@Configuration
@RequiredArgsConstructor
public class BeanConfig {
	@Value("${cloud.aws.credentials.accessKey}")
	private String accessKey ;
	@Value("${cloud.aws.credentials.secretKey}")
	private  String secretKey;
	@Value("${cloud.aws.region.static}")
	private String region;
	@Bean
	public AmazonS3 amazonS3() {
		return AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
				.withRegion(region)
				.build();
	}

}
