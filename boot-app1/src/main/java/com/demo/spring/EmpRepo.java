package com.demo.spring;

import org.springframework.data.repository.CrudRepository;

import com.demo.spring.entity.Emp;

public interface EmpRepo extends CrudRepository<Emp, Integer> {

}
