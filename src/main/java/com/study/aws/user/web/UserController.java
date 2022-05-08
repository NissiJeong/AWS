package com.study.aws.user.web;

import com.study.aws.common.entity.ResponseDTO;
import com.study.aws.user.service.UserService;
import com.study.aws.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> userList(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode(HttpStatus.OK+"");
        ArrayList<HashMap<String, Object>> userList = userService.findAll();
        for(HashMap<String, Object> map : userList) System.out.println("map: "+map);
        responseDTO.setRes(userService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> getOneUser(@PathVariable String id){
        ResponseDTO responseDTO = new ResponseDTO();
        HashMap<String, Object> param = new HashMap<>();
        param.put("id", id);
        ArrayList<HashMap<String, Object>> userList = userService.findUser(param);
        responseDTO.setRes(userList);
        responseDTO.setResultCode(HttpStatus.OK+"");

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(value="")
    public ResponseEntity<?> insertUser(@RequestBody HashMap<String, Object> param){
        try{
            HashMap<String, Object> returnMap = userService.insertUser(param);
            return new ResponseEntity<>(returnMap, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody HashMap<String, Object> param){
        HashMap<String, Object> returnMap = new HashMap<>();
        int returnCnt = userService.updateUser(id);
        returnMap.put("returnCnt", returnCnt);
        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }
}
