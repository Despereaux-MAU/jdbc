package com.thesun4sky.querymapper.mapper;

import com.thesun4sky.querymapper.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    User selectUserById(@Param("id") Long id);

}
