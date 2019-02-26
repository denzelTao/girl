package com.imooc.controller;

import com.imooc.dao.GirlRepository;
import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by think on 2018/2/6.
 */
@RestController
@RequestMapping(value = "/girl")
public class GirlController {

    @Autowired
    private GirlService girlService;

    @Autowired
    private GirlRepository girlRepository;


    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/list")
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生信息
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/add")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age,
                        @RequestParam("name") String name) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
//        girlService.save(name,cupSize,age);
//        return girlRepository.save(girl);
        return girlService.save(name,cupSize,age);
    }

    /**
     * 查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Girl findById(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
//        return  girlRepository.findById(id).get();
    }

    @PostMapping("/getbyname")
    public Girl findByName(@RequestParam("name") String name){
        return girlService.findByName(name);
    }

    /**
     * 更新一个女生
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/update/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age
    ) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     *
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        /*Girl girl = new Girl();
        girl.setId(id);*/
//        girlRepository.deleteById(id);
        Girl girl = girlRepository.getOne(id);
        girlService.delete(girl.getName(),girl.getCupSize());
    }

    @GetMapping("/get/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @GetMapping("/girls/two")
    public void insertTwo() {
        girlService.insertTwo();
    }
}
