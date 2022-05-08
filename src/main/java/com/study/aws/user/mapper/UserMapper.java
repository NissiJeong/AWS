package com.study.aws.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Repository
public interface UserMapper {
    ArrayList<HashMap<String, Object>> findAll();

    ArrayList<HashMap<String, Object>> findUser(HashMap<String, Object> param);

    int insertUser(HashMap<String, Object> param);

    int updateUser(String id);
}
