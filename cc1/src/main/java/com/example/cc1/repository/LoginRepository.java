package com.example.cc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cc1.model.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel,Integer>{

    
}