package com.thesun4sky.querymapper.dao;

import com.thesun4sky.querymapper.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User selectUserById(long id) {
        return this.sqlSession.selectOne("selectUserById", id);
    }
}
