package com.example.cc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cc1.model.LoginModel;
import com.example.cc1.service.LoginService;


@RestController
public class LoginController {
    @Autowired
    LoginService cs;

    //post
    @PostMapping("/api/children")
    public ResponseEntity<LoginModel> create(@RequestBody LoginModel c)
    {
       LoginModel obj = cs.create(c);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    //sorting
    @GetMapping("/api/children/sortBy/{field}")
    public List<LoginModel> g(@PathVariable String field)
    {
        return cs.sort(field);
    }

    //pagination
    @GetMapping("/api/children/{offset}/{pagesize}")
    public List<LoginModel> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return cs.page(pagesize, offset);
    }
   
    //sorting and pagination
    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public List<LoginModel> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return cs.getsort(offset,pagesize,field);
    }
}
