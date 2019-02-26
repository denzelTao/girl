package com.imooc.controller;

import com.imooc.domain.Torder;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/add")
    public Torder add(@RequestParam("name")String name,
                     @RequestParam("type") String type,
                     @RequestParam("tdescribe")String tdescribe){

        System.out.println("name=="+name+"*****type=="+type+"*********tdescribe=="+tdescribe);
        Torder order = new Torder(name,type,tdescribe);
        return orderService.create(order);
    }

    @GetMapping(value = "/list")
    public List<Torder> list(){
        return  orderService.list();
    }

    @GetMapping(value = "/deletebyid")
    public void deleteById(@RequestParam("id") Integer id){
        orderService.delete(id);
    }

    @GetMapping(value = "/update")
    public Torder update(@RequestParam("id")Integer id,
                        @RequestParam("name")String name,
                        @RequestParam("type")String type,
                        @RequestParam("tdescribe")String tdescribe){
        Torder order = new Torder();
        order.setId(id);
        order.setName(name);
        order.setType(type);
        order.setTdescribe(tdescribe);
       return orderService.update(order);
    }

    @GetMapping(value = "/get/{id}")
    public Torder findById(@PathVariable("id") Integer id){
        return orderService.findById(id);
    }


}
