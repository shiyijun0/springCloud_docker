package com.itmuch.cloud.study.controller;

import com.itmuch.cloud.study.entity.User;
import com.itmuch.cloud.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = userRepository.getOne(id);
        return findOne;
    }

    public String[] object(String ...msg){
        return msg;
    }

    public static void main(String[] args) {
        UserController userController=new UserController();
        System.out.println(userController.object("东风风光","电饭锅")[1]);
        SerializationUtils.serialize("sd");
       // System.gc();
        List list=new ArrayList();//动态扩容 比如10  10*/2/2+1
        Vector vector=new Vector();//动态扩容两倍
        Integer[] data={1,4,7,3,9,2};
        List<Integer> integerList=Arrays.asList(data);
        TreeSet<Integer> set=new TreeSet<>(integerList);
        System.out.println(set.lower(set.last()));//老二

    }

}
