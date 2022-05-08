package com.study.aws.user.service;

import com.study.aws.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@Transactional
public class UserServiceImpl{

    @Autowired
    UserMapper userMapper;

    public ArrayList<HashMap<String, Object>> findAll() {
        return userMapper.findAll();
    }

    public ArrayList<HashMap<String, Object>> findUser(HashMap<String, Object> param) {
        return userMapper.findUser(param);
    }

    public HashMap<String, Object> insertUser(HashMap<String, Object> param) {
        HashMap<String, Object> returnMap = new HashMap<>();
        int resultRow = userMapper.insertUser(param);
        returnMap.put("resultRow", resultRow);
        return returnMap;
    }

    public int updateUser(String id) {
        int updatedRowCnt = userMapper.updateUser(id);
        return updatedRowCnt;
    }
}
