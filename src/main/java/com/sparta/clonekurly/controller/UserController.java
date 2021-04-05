//package com.sparta.clonekurly.controller;
//
//import com.sparta.clonekurly.model.User;
//import lombok.RequiredArgsConstructor;
//import net.bytebuddy.implementation.bind.MethodDelegationBinder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//public class UserController {
//
//    @ResponseBody
//    @GetMapping("/api/test")
//    public ReturnClass testCORS(){
//        ArrayList<User> uesrList = new ArrayList<>();
//        User user = new User();
//        user.setMsg("연결 성공");
//        uesrList.add(user);
//        ReturnClass returnClass = new ReturnClass();
//        returnClass.setOk(true);
//        returnClass.setResults(uesrList);
//        return returnClass;
//    }
//}
