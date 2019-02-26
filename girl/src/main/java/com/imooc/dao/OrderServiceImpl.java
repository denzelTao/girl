package com.imooc.dao;

import com.imooc.domain.Torder;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
@WebService
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepositity orderRepositity;


    @Override
    public Torder create(Torder order) {
        return  orderRepositity.save(order);
    }

    @Override
    public Torder findById(Integer id) {
        return orderRepositity.findOne(id);
//        return orderRepositity.findById(id).get();
    }

    @Override
    public void delete(Integer id) {

//        orderRepositity.deleteById(id);
    }

    @Override
    public void delete(Torder order) {
        orderRepositity.delete(order);
    }


    @Override
    public List<Torder> list() {
        return orderRepositity.findAll();
    }

    @Override
    public Torder update(Torder order) {
       return orderRepositity.save(order);
    }

    @Override
    public Torder findByName(String name) {
        return orderRepositity.findByName(name);
    }
}
