package com.example.cc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.cc1.model.LoginModel;
import com.example.cc1.repository.LoginRepository;

@Service
public class LoginService {
    @Autowired
    LoginRepository cr;

    //post
    public LoginModel create(@NonNull LoginModel c)
    {
        return cr.save(c);
    }

    //sorting by field
    public List<LoginModel> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return cr.findAll(sort);
    }

    //pagination
    public List<LoginModel> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return cr.findAll(page).getContent();
    }

    //sorting and pagination
    public List<LoginModel> getsort(int pageNumber,int pageSize,String field)
    {          return cr.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }


}
