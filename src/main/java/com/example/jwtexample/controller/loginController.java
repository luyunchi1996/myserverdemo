package com.example.jwtexample.controller;

import com.example.jwtexample.UserLoginToken;
import com.example.jwtexample.entity.User;
import com.example.jwtexample.service.TokenService;
import com.example.jwtexample.service.UserService;
import com.example.jwtexample.utils.MyPasswordEncoder;
import com.example.jwtexample.utils.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.util.UUID;


@Controller
@RequestMapping("api")
public class loginController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @PostMapping("/login")
    public @ResponseBody Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUsername(user);
        MyPasswordEncoder passWordencode = new MyPasswordEncoder();


        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            Boolean equ = passWordencode.matches(user.getPassWord()+user.getName(),userForBase.getPassWord());
            if (!equ){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @PostMapping("/saveUser")
    public  @ResponseBody User SaveUser(@RequestBody User user){
        MyPasswordEncoder passWordencode = new MyPasswordEncoder();
        user.setId(getUUID());
        user.setPassWord( passWordencode.encode(user.getPassWord()+user.getName()) );
        return  userService.SaveUser(user);
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public @ResponseBody String getMessage(){
        return "你已通过验证";
    }
    public  String getUUID(){
        return  UUID.randomUUID().toString().replaceAll("-","");
    }
}
