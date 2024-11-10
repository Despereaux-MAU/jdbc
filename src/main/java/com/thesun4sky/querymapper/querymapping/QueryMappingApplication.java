package com.thesun4sky.querymapper.querymapping;

import com.thesun4sky.querymapper.dao.UserDao;
import com.thesun4sky.querymapper.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.thesun4sky.querymapper")
@MapperScan(basePackages = "com.thesun4sky.querymapper.mapper")
public class QueryMappingApplication {
    public static void main(String[] args) {
        // 어플리케이션 실행 컨텍스트 생성
        var context = SpringApplication.run(QueryMappingApplication.class, args);

        // 데이터 조회 DAO 클래스 빈 조회
        var dao = context.getBean(UserDao.class);
        // DAO 를 통해 유저 정보 조회
        System.out.println("User by dao : " + dao.selectUserById(1L)); // data.sql 에서 1번 유저 정보 조회

        // 데이터 조회 Mapper 클래스 빈 조회
        var mapper = context.getBean(UserMapper.class);
        // FileMapper 를 통해 유저 정보 조회
        System.out.println("User by fileMapper : " + mapper.selectUserById(1L)); // data.sql 에서 1번 유저 정보 조회
    }
}
