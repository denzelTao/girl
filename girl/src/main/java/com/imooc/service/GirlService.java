package com.imooc.service;

import com.imooc.dao.GirlRepository;
import com.imooc.domain.Girl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by think on 2018/2/7.
 */
@Service
public class GirlService {

    private static Log logger = LogFactory.getLog(GirlService.class);

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);


    }

    @CachePut(value = "usercache",key = "#p0")
    public Girl save(String name,String cupSize,Integer age){
        logger.info("*********save girl******name=="+name);
        Girl girl = new Girl();
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }
    @Cacheable(value = "usercache",key = "#p0")
    public Girl findByName(String name){
        logger.info("*********findbyname , name=="+name);
        return  girlRepository.findByName(name);
    }

    @CacheEvict(value = "usercache",key = "#p0")
    public void delete(String name,String cupSize){
        logger.info("*********delete girl , name=="+name);
        Girl girl = girlRepository.findByName(name);
        girlRepository.delete(girl.getId());
    }



}
