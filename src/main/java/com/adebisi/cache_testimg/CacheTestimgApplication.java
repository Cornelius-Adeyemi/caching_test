package com.adebisi.cache_testimg;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@EnableCaching
@Slf4j
@RequiredArgsConstructor
public class CacheTestimgApplication {

	private final NotificationMailPropertyConfig notificationMailPropertyConfig;

	private final ObjectMapper objectMapper;


	public static void main(String[] args) {
		SpringApplication.run(CacheTestimgApplication.class, args);
	}




}
