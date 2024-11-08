package com.thesun4sky.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		// 어플리케이션 실행 컨텍스트 생성
		var context = SpringApplication.run(JdbcApplication.class, args);
		// 데이터 조회 클래스 빈 조회
		var repository = context.getBean(DataRepository.class);

		// 테이블 생성
		repository.createTable();
		// 유저정보 추가
		for (int i = 0; i < 10; i++) {
			repository.insertUser("User" + i); // 10번 반복
		}
		repository.insertUser("Tim Kim");
		// 유저정보 조회
		for (int i = 1; i <= 10; i++) { // id를 1부터 10까지 조회
			System.out.println("User: " + repository.findUserById((long) i)); // 10번 반복
		}
		System.out.println("User: " + repository.findUserById(1L));
	}
}
