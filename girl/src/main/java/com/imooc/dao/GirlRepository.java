package com.imooc.dao;

import com.imooc.domain.Girl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by think on 2018/2/7.
 */
@CacheConfig
public interface GirlRepository extends JpaRepository<Girl, Integer> {


    public List<Girl> findByAge(Integer age);


    @Cacheable(cacheNames = "girls")
    Girl findByName(String name);



}
